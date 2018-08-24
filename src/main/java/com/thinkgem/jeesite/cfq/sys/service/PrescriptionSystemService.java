/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.service;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.thinkgem.jeesite.cfq.common.service.BaseService;
import com.thinkgem.jeesite.cfq.common.security.shiro.session.SessionDAO;
import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionMenuDao;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionRoleDao;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionUserDao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.Group;
import org.apache.shiro.session.Session;

import com.thinkgem.jeesite.cfq.common.config.Global;
import com.thinkgem.jeesite.cfq.common.security.Digests;
import com.thinkgem.jeesite.cfq.common.service.ServiceException;
import com.thinkgem.jeesite.cfq.common.utils.CacheUtils;
import com.thinkgem.jeesite.cfq.common.utils.Encodes;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.common.web.Servlets;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionMenu;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionOffice;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionRole;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionUser;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionLogUtils;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionUserUtils;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 *
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class PrescriptionSystemService extends BaseService implements InitializingBean {

    public static final String HASH_ALGORITHM = "SHA-1";
    public static final int HASH_INTERATIONS = 1024;
    public static final int SALT_SIZE = 8;

    @Autowired
    private PrescriptionUserDao prescriptionUserDao;
    @Autowired
    private PrescriptionRoleDao prescriptionRoleDao;
    @Autowired
    private PrescriptionMenuDao prescriptionMenuDao;

    @Autowired
    private SessionDAO sessionDao;

    public SessionDAO getSessionDao() {
        return sessionDao;
    }

    @Autowired
    private IdentityService identityService;

    //-- User Service --//

    /**
     * 获取用户
     *
     * @param id
     * @return
     */
    public PrescriptionUser getUser(String id) {
        return PrescriptionUserUtils.get(id);
    }

    /**
     * 根据登录名获取用户
     *
     * @param loginName
     * @return
     */
    public PrescriptionUser getUserByLoginName(String loginName) {
        return PrescriptionUserUtils.getByLoginName(loginName);
    }

    public Page<PrescriptionUser> findUser(Page<PrescriptionUser> page, PrescriptionUser user) {
        // 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
        user.getSqlMap().put("dsf", dataScopeFilter(user.getCurrentUser(), "o", "a"));
        // 设置分页参数
        user.setPage(page);
        // 执行分页查询
        page.setList(prescriptionUserDao.findList(user));
        return page;
    }

    /**
     * 无分页查询人员列表
     *
     * @param user
     * @return
     */
    public List<PrescriptionUser> findUser(PrescriptionUser user) {
        // 生成数据权限过滤条件（dsf为dataScopeFilter的简写，在xml中使用 ${sqlMap.dsf}调用权限SQL）
        user.getSqlMap().put("dsf", dataScopeFilter(user.getCurrentUser(), "o", "a"));
        List<PrescriptionUser> list = prescriptionUserDao.findList(user);
        return list;
    }

    /**
     * 通过部门ID获取用户列表，仅返回用户id和name（树查询用户时用）
     *
     * @param user
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<PrescriptionUser> findUserByOfficeId(String officeId) {
        List<PrescriptionUser> list = (List<PrescriptionUser>) CacheUtils.get(PrescriptionUserUtils.USER_CACHE, PrescriptionUserUtils.USER_CACHE_LIST_BY_OFFICE_ID_ + officeId);
        if (list == null) {
            PrescriptionUser user = new PrescriptionUser();
            user.setOffice(new PrescriptionOffice(officeId));
            list = prescriptionUserDao.findUserByOfficeId(user);
            CacheUtils.put(PrescriptionUserUtils.USER_CACHE, PrescriptionUserUtils.USER_CACHE_LIST_BY_OFFICE_ID_ + officeId, list);
        }
        return list;
    }

    @Transactional(readOnly = false)
    public void saveUser(PrescriptionUser prescriptionUser) {
        if (StringUtils.isBlank(prescriptionUser.getId())) {
            prescriptionUser.preInsert();
            prescriptionUserDao.insert(prescriptionUser);
        } else {
            // 清除原用户机构用户缓存
            PrescriptionUser oldUser = prescriptionUserDao.get(prescriptionUser.getId());
            if (oldUser.getOffice() != null && oldUser.getOffice().getId() != null) {
                CacheUtils.remove(PrescriptionUserUtils.USER_CACHE, PrescriptionUserUtils.USER_CACHE_LIST_BY_OFFICE_ID_ + oldUser.getOffice().getId());
            }
            // 更新用户数据
            prescriptionUser.preUpdate();
            prescriptionUserDao.update(prescriptionUser);
        }
        if (StringUtils.isNotBlank(prescriptionUser.getId())) {
            // 更新用户与角色关联
            prescriptionUserDao.deleteUserRole(prescriptionUser);
            if (prescriptionUser.getRoleList() != null && prescriptionUser.getRoleList().size() > 0) {
                prescriptionUserDao.insertUserRole(prescriptionUser);
            } else {
                throw new ServiceException(prescriptionUser.getLoginName() + "没有设置角色！");
            }
            // 将当前用户同步到Activiti
            saveActivitiUser(prescriptionUser);
            // 清除用户缓存
            PrescriptionUserUtils.clearCache(prescriptionUser);
//			// 清除权限缓存
//			prescriptionSystemAuthorizingRealm.clearAllCachedAuthorizationInfo();
        }
    }

    @Transactional(readOnly = false)
    public void updateUserInfo(PrescriptionUser prescriptionUser) {
        prescriptionUser.preUpdate();
        prescriptionUserDao.updateUserInfo(prescriptionUser);
        // 清除用户缓存
        PrescriptionUserUtils.clearCache(prescriptionUser);
//		// 清除权限缓存
//		prescriptionSystemAuthorizingRealm.clearAllCachedAuthorizationInfo();
    }

    @Transactional(readOnly = false)
    public void deleteUser(PrescriptionUser prescriptionUser) {
        prescriptionUserDao.delete(prescriptionUser);
        // 同步到Activiti
        deleteActivitiUser(prescriptionUser);
        // 清除用户缓存
        PrescriptionUserUtils.clearCache(prescriptionUser);
//		// 清除权限缓存
//		prescriptionSystemAuthorizingRealm.clearAllCachedAuthorizationInfo();
    }

    @Transactional(readOnly = false)
    public void updatePasswordById(String id, String loginName, String newPassword) {
        PrescriptionUser prescriptionUser = new PrescriptionUser(id);
        prescriptionUser.setPassword(entryptPassword(newPassword));
        prescriptionUserDao.updatePasswordById(prescriptionUser);
        // 清除用户缓存
        prescriptionUser.setLoginName(loginName);
        PrescriptionUserUtils.clearCache(prescriptionUser);
//		// 清除权限缓存
//		prescriptionSystemAuthorizingRealm.clearAllCachedAuthorizationInfo();
    }

    @Transactional(readOnly = false)
    public void updateUserLoginInfo(PrescriptionUser prescriptionUser) {
        // 保存上次登录信息
        prescriptionUser.setOldLoginIp(prescriptionUser.getLoginIp());
        prescriptionUser.setOldLoginDate(prescriptionUser.getLoginDate());
        // 更新本次登录信息
        prescriptionUser.setLoginIp(StringUtils.getRemoteAddr(Servlets.getRequest()));
        prescriptionUser.setLoginDate(new Date());
        prescriptionUserDao.updateLoginInfo(prescriptionUser);
    }

    /**
     * 生成安全的密码，生成随机的16位salt并经过1024次 sha-1 hash
     */
    public static String entryptPassword(String plainPassword) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword);
    }

    /**
     * 验证密码
     *
     * @param plainPassword 明文密码
     * @param password      密文密码
     * @return 验证成功返回true
     */
    public static boolean validatePassword(String plainPassword, String password) {
        String plain = Encodes.unescapeHtml(plainPassword);
        byte[] salt = Encodes.decodeHex(password.substring(0, 16));
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, HASH_INTERATIONS);
        return password.equals(Encodes.encodeHex(salt) + Encodes.encodeHex(hashPassword));
    }

    /**
     * 获得活动会话
     *
     * @return
     */
    public Collection<Session> getActiveSessions() {
        return sessionDao.getActiveSessions(false);
    }

    //-- Role Service --//

    public PrescriptionRole getRole(String id) {
        return prescriptionRoleDao.get(id);
    }

    public PrescriptionRole getRoleByName(String name) {
        PrescriptionRole r = new PrescriptionRole();
        r.setName(name);
        return prescriptionRoleDao.getByName(r);
    }

    public PrescriptionRole getRoleByEnname(String enname) {
        PrescriptionRole r = new PrescriptionRole();
        r.setEnname(enname);
        return prescriptionRoleDao.getByEnname(r);
    }

    public List<PrescriptionRole> findRole(PrescriptionRole role) {
        return prescriptionRoleDao.findList(role);
    }

    public List<PrescriptionRole> findAllRole() {
        return PrescriptionUserUtils.getPrescriptionRoleList();
    }

    @Transactional(readOnly = false)
    public void saveRole(PrescriptionRole role) {
        if (StringUtils.isBlank(role.getId())) {
            role.preInsert();
            prescriptionRoleDao.insert(role);
            // 同步到Activiti
            saveActivitiGroup(role);
        } else {
            role.preUpdate();
            prescriptionRoleDao.update(role);
        }
        // 更新角色与菜单关联
        prescriptionRoleDao.deleteRoleMenu(role);
        if (role.getMenuList().size() > 0) {
            prescriptionRoleDao.insertRoleMenu(role);
        }
        // 更新角色与部门关联
        prescriptionRoleDao.deleteRoleOffice(role);
        if (role.getOfficeList().size() > 0) {
            prescriptionRoleDao.insertRoleOffice(role);
        }
        // 同步到Activiti
        saveActivitiGroup(role);
        // 清除用户角色缓存
        PrescriptionUserUtils.removeCache(PrescriptionUserUtils.CACHE_ROLE_LIST);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
    }

    @Transactional(readOnly = false)
    public void deleteRole(PrescriptionRole prescriptionRole) {
        prescriptionRoleDao.delete(prescriptionRole);
        // 同步到Activiti
        deleteActivitiGroup(prescriptionRole);
        // 清除用户角色缓存
        PrescriptionUserUtils.removeCache(PrescriptionUserUtils.CACHE_ROLE_LIST);
//		// 清除权限缓存
//		prescriptionSystemAuthorizingRealm.clearAllCachedAuthorizationInfo();
    }

    @Transactional(readOnly = false)
    public Boolean outUserInRole(PrescriptionRole prescriptionRole, PrescriptionUser prescriptionUser) {
        List<PrescriptionRole> roles = prescriptionUser.getRoleList();
        for (PrescriptionRole e : roles) {
            if (e.getId().equals(prescriptionRole.getId())) {
                roles.remove(e);
                saveUser(prescriptionUser);
                return true;
            }
        }
        return false;
    }

    @Transactional(readOnly = false)
    public PrescriptionUser assignUserToRole(PrescriptionRole prescriptionRole, PrescriptionUser prescriptionUser) {
        if (prescriptionUser == null) {
            return null;
        }
        List<String> roleIds = prescriptionUser.getRoleIdList();
        if (roleIds.contains(prescriptionRole.getId())) {
            return null;
        }
        prescriptionUser.getRoleList().add(prescriptionRole);
        saveUser(prescriptionUser);
        return prescriptionUser;
    }

    //-- Menu Service --//

    public PrescriptionMenu getMenu(String id) {
        return prescriptionMenuDao.get(id);
    }

    public List<PrescriptionMenu> findAllMenu() {
        return PrescriptionUserUtils.getPrescriptionMenuList();
    }

    @Transactional(readOnly = false)
    public void saveMenu(PrescriptionMenu prescriptionMenu) {

        // 获取父节点实体
        prescriptionMenu.setParent(this.getMenu(prescriptionMenu.getParent().getId()));

        // 获取修改前的parentIds，用于更新子节点的parentIds
        String oldParentIds = prescriptionMenu.getParentIds();

        // 设置新的父节点串
        prescriptionMenu.setParentIds(prescriptionMenu.getParent().getParentIds() + prescriptionMenu.getParent().getId() + ",");

        // 保存或更新实体
        if (StringUtils.isBlank(prescriptionMenu.getId())) {
            prescriptionMenu.preInsert();
            prescriptionMenuDao.insert(prescriptionMenu);
        } else {
            prescriptionMenu.preUpdate();
            prescriptionMenuDao.update(prescriptionMenu);
        }

        // 更新子节点 parentIds
        PrescriptionMenu m = new PrescriptionMenu();
        m.setParentIds("%," + prescriptionMenu.getId() + ",%");
        List<PrescriptionMenu> list = prescriptionMenuDao.findByParentIdsLike(m);
        for (PrescriptionMenu e : list) {
            e.setParentIds(e.getParentIds().replace(oldParentIds, prescriptionMenu.getParentIds()));
            prescriptionMenuDao.updateParentIds(e);
        }
        // 清除用户菜单缓存
        PrescriptionUserUtils.removeCache(PrescriptionUserUtils.CACHE_MENU_LIST);
//		// 清除权限缓存
//		prescriptionSystemAuthorizingRealm.clearAllCachedAuthorizationInfo();
        // 清除日志相关缓存
        CacheUtils.remove(PrescriptionLogUtils.CACHE_MENU_NAME_PATH_MAP);
    }

    @Transactional(readOnly = false)
    public void updateMenuSort(PrescriptionMenu prescriptionMenu) {
        prescriptionMenuDao.updateSort(prescriptionMenu);
        // 清除用户菜单缓存
        PrescriptionUserUtils.removeCache(PrescriptionUserUtils.CACHE_MENU_LIST);
//		// 清除权限缓存
//		systemRealm.clearAllCachedAuthorizationInfo();
        // 清除日志相关缓存
        CacheUtils.remove(PrescriptionLogUtils.CACHE_MENU_NAME_PATH_MAP);
    }

    @Transactional(readOnly = false)
    public void deleteMenu(PrescriptionMenu prescriptionMenu) {
        prescriptionMenuDao.delete(prescriptionMenu);
        // 清除用户菜单缓存
        PrescriptionUserUtils.removeCache(PrescriptionUserUtils.CACHE_MENU_LIST);
//		// 清除权限缓存
//		prescriptionSystemAuthorizingRealm.clearAllCachedAuthorizationInfo();
        // 清除日志相关缓存
        CacheUtils.remove(PrescriptionLogUtils.CACHE_MENU_NAME_PATH_MAP);
    }

    /**
     * 获取Key加载信息
     */
    public static boolean printKeyLoadMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n    欢迎使用 " + Global.getConfig("productName") + "  - Powered By http://jeesite.com\r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb.toString());
        return true;
    }

    ///////////////// Synchronized to the Activiti //////////////////

    // 已废弃，同步见：ActGroupEntityServiceFactory.java、ActUserEntityServiceFactory.java

    /**
     * 是需要同步Activiti数据，如果从未同步过，则同步数据。
     */
    private static boolean isSynActivitiIndetity = true;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (!Global.isSynActivitiIndetity()) {
            return;
        }
        if (isSynActivitiIndetity) {
            isSynActivitiIndetity = false;
            // 同步角色数据
            List<Group> groupList = identityService.createGroupQuery().list();
            if (groupList.size() == 0) {
                Iterator<PrescriptionRole> roles = prescriptionRoleDao.findAllList(new PrescriptionRole()).iterator();
                while (roles.hasNext()) {
                    PrescriptionRole role = roles.next();
                    saveActivitiGroup(role);
                }
            }
            // 同步用户数据
            List<org.activiti.engine.identity.User> userList = identityService.createUserQuery().list();
            if (userList.size() == 0) {
                Iterator<PrescriptionUser> users = prescriptionUserDao.findAllList(new PrescriptionUser()).iterator();
                while (users.hasNext()) {
                    saveActivitiUser(users.next());
                }
            }
        }
    }

    private void saveActivitiGroup(PrescriptionRole prescriptionRole) {
        if (!Global.isSynActivitiIndetity()) {
            return;
        }
        String groupId = prescriptionRole.getEnname();

        // 如果修改了英文名，则删除原Activiti角色
        if (StringUtils.isNotBlank(prescriptionRole.getOldEnname()) && !prescriptionRole.getOldEnname().equals(prescriptionRole.getEnname())) {
            identityService.deleteGroup(prescriptionRole.getOldEnname());
        }

        Group group = identityService.createGroupQuery().groupId(groupId).singleResult();
        if (group == null) {
            group = identityService.newGroup(groupId);
        }
        group.setName(prescriptionRole.getName());
        group.setType(prescriptionRole.getRoleType());
        identityService.saveGroup(group);

        // 删除用户与用户组关系
        List<org.activiti.engine.identity.User> activitiUserList = identityService.createUserQuery().memberOfGroup(groupId).list();
        for (org.activiti.engine.identity.User activitiUser : activitiUserList) {
            identityService.deleteMembership(activitiUser.getId(), groupId);
        }

        // 创建用户与用户组关系
        List<PrescriptionUser> userList = findUser(new PrescriptionUser(new PrescriptionRole(prescriptionRole.getId())));
        for (PrescriptionUser e : userList) {
            String userId = e.getLoginName();//ObjectUtils.toString(user.getId());
            // 如果该用户不存在，则创建一个
            org.activiti.engine.identity.User activitiUser = identityService.createUserQuery().userId(userId).singleResult();
            if (activitiUser == null) {
                activitiUser = identityService.newUser(userId);
                activitiUser.setFirstName(e.getName());
                activitiUser.setLastName(StringUtils.EMPTY);
                activitiUser.setEmail(e.getEmail());
                activitiUser.setPassword(StringUtils.EMPTY);
                identityService.saveUser(activitiUser);
            }
            identityService.createMembership(userId, groupId);
        }
    }

    public void deleteActivitiGroup(PrescriptionRole prescriptionRole) {
        if (!Global.isSynActivitiIndetity()) {
            return;
        }
        if (prescriptionRole != null) {
            String groupId = prescriptionRole.getEnname();
            identityService.deleteGroup(groupId);
        }
    }

    private void saveActivitiUser(PrescriptionUser prescriptionUser) {
        if (!Global.isSynActivitiIndetity()) {
            return;
        }
        String userId = prescriptionUser.getLoginName();//ObjectUtils.toString(user.getId());
        org.activiti.engine.identity.User activitiUser = identityService.createUserQuery().userId(userId).singleResult();
        if (activitiUser == null) {
            activitiUser = identityService.newUser(userId);
        }
        activitiUser.setFirstName(prescriptionUser.getName());
        activitiUser.setLastName(StringUtils.EMPTY);
        activitiUser.setEmail(prescriptionUser.getEmail());
        activitiUser.setPassword(StringUtils.EMPTY);
        identityService.saveUser(activitiUser);

        // 删除用户与用户组关系
        List<Group> activitiGroups = identityService.createGroupQuery().groupMember(userId).list();
        for (Group group : activitiGroups) {
            identityService.deleteMembership(userId, group.getId());
        }
        // 创建用户与用户组关系
        for (PrescriptionRole prescriptionRole : prescriptionUser.getRoleList()) {
            String groupId = prescriptionRole.getEnname();
            // 如果该用户组不存在，则创建一个
            Group group = identityService.createGroupQuery().groupId(groupId).singleResult();
            if (group == null) {
                group = identityService.newGroup(groupId);
                group.setName(prescriptionRole.getName());
                group.setType(prescriptionRole.getRoleType());
                identityService.saveGroup(group);
            }
            identityService.createMembership(userId, prescriptionRole.getEnname());
        }
    }

    private void deleteActivitiUser(PrescriptionUser prescriptionUser) {
        if (!Global.isSynActivitiIndetity()) {
            return;
        }
        if (prescriptionUser != null) {
            String userId = prescriptionUser.getLoginName();//ObjectUtils.toString(user.getId());
            identityService.deleteUser(userId);
        }
    }

    ///////////////// Synchronized to the Activiti end //////////////////

}
