/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.utils;


import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.thinkgem.jeesite.cfq.common.service.BaseService;
import com.thinkgem.jeesite.cfq.common.utils.CacheUtils;
import com.thinkgem.jeesite.cfq.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionAreaDao;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionMenuDao;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionOfficeDao;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionRoleDao;
import com.thinkgem.jeesite.cfq.sys.dao.PrescriptionUserDao;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionArea;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionMenu;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionOffice;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionRole;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionUser;
import com.thinkgem.jeesite.cfq.sys.security.PrescriptionSystemAuthorizingRealm.PrescriptionPrincipal;


/**
 * 用户工具类
 *
 * @author ThinkGem
 * @version 2013-12-05
 */
public class PrescriptionUserUtils {

    private static PrescriptionUserDao prescriptionUserDao = SpringContextHolder.getBean(PrescriptionUserDao.class);
    private static PrescriptionRoleDao prescriptionRoleDao = SpringContextHolder.getBean(PrescriptionRoleDao.class);
    private static PrescriptionMenuDao prescriptionMenuDao = SpringContextHolder.getBean(PrescriptionMenuDao.class);
    private static PrescriptionAreaDao prescriptionAreaDao = SpringContextHolder.getBean(PrescriptionAreaDao.class);
    private static PrescriptionOfficeDao prescriptionOfficeDao = SpringContextHolder.getBean(PrescriptionOfficeDao.class);

    public static final String USER_CACHE = "userCache";
    public static final String USER_CACHE_ID_ = "id_";
    public static final String USER_CACHE_LOGIN_NAME_ = "ln";
    public static final String USER_CACHE_LIST_BY_OFFICE_ID_ = "oid_";

    public static final String CACHE_ROLE_LIST = "roleList";
    public static final String CACHE_MENU_LIST = "menuList";
    public static final String CACHE_AREA_LIST = "areaList";
    public static final String CACHE_OFFICE_LIST = "officeList";
    public static final String CACHE_OFFICE_ALL_LIST = "officeAllList";

    /**
     * 根据ID获取用户
     *
     * @param id
     * @return 取不到返回null
     */
    public static PrescriptionUser get(String id) {
        PrescriptionUser prescriptionUser = (PrescriptionUser) CacheUtils.get(USER_CACHE, USER_CACHE_ID_ + id);
        if (prescriptionUser == null) {
            prescriptionUser = prescriptionUserDao.get(id);
            if (prescriptionUser == null) {
                return null;
            }
            prescriptionUser.setRoleList(prescriptionRoleDao.findList(new PrescriptionRole(prescriptionUser)));
            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + prescriptionUser.getId(), prescriptionUser);
            CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + prescriptionUser.getLoginName(), prescriptionUser);
        }
        return prescriptionUser;
    }

    /**
     * 根据登录名获取用户
     *
     * @param loginName
     * @return 取不到返回null
     */
    public static PrescriptionUser getByLoginName(String loginName) {
        PrescriptionUser prescriptionUser = (PrescriptionUser) CacheUtils.get(USER_CACHE, USER_CACHE_LOGIN_NAME_ + loginName);
        if (prescriptionUser == null) {
            prescriptionUser = prescriptionUserDao.getByLoginName(new PrescriptionUser(null, loginName));
            if (prescriptionUser == null) {
                return null;
            }
            prescriptionUser.setRoleList(prescriptionRoleDao.findList(new PrescriptionRole(prescriptionUser)));
            CacheUtils.put(USER_CACHE, USER_CACHE_ID_ + prescriptionUser.getId(), prescriptionUser);
            CacheUtils.put(USER_CACHE, USER_CACHE_LOGIN_NAME_ + prescriptionUser.getLoginName(), prescriptionUser);
        }
        return prescriptionUser;
    }

    /**
     * 清除当前用户缓存
     */
    public static void clearCache() {
        removeCache(CACHE_ROLE_LIST);
        removeCache(CACHE_MENU_LIST);
        removeCache(CACHE_AREA_LIST);
        removeCache(CACHE_OFFICE_LIST);
        removeCache(CACHE_OFFICE_ALL_LIST);
        PrescriptionUserUtils.clearCache(getPrescriptionUser());
    }

    /**
     * 清除指定用户缓存
     */
    public static void clearCache(PrescriptionUser prescriptionUser) {
        CacheUtils.remove(USER_CACHE, USER_CACHE_ID_ + prescriptionUser.getId());
        CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + prescriptionUser.getLoginName());
        CacheUtils.remove(USER_CACHE, USER_CACHE_LOGIN_NAME_ + prescriptionUser.getOldLoginName());
        if (prescriptionUser.getOffice() != null && prescriptionUser.getOffice().getId() != null) {
            CacheUtils.remove(USER_CACHE, USER_CACHE_LIST_BY_OFFICE_ID_ + prescriptionUser.getOffice().getId());
        }
    }

    /**
     * 获取当前用户
     *
     * @return 取不到返回 new PrescriptionUser()
     */
    public static PrescriptionUser getPrescriptionUser() {
        PrescriptionPrincipal principal = getPrescriptionPrincipal();
        if (principal != null) {
            PrescriptionUser prescriptionUser = get(principal.getId());
            if (prescriptionUser != null) {
                return prescriptionUser;
            }
            return new PrescriptionUser();
        }
        // 如果没有登录，则返回实例化空的User对象。
        return new PrescriptionUser();
    }

    /**
     * 获取当前用户角色列表
     *
     * @return
     */
    public static List<PrescriptionRole> getPrescriptionRoleList() {
        @SuppressWarnings("unchecked")
        List<PrescriptionRole> prescriptionRoleList = (List<PrescriptionRole>) getCache(CACHE_ROLE_LIST);
        if (prescriptionRoleList == null) {
            PrescriptionUser prescriptionUser = getPrescriptionUser();
            if (prescriptionUser.isAdmin()) {
                prescriptionRoleList = prescriptionRoleDao.findAllList(new PrescriptionRole());
            } else {
                PrescriptionRole prescriptionRole = new PrescriptionRole();
                prescriptionRole.getSqlMap().put("dsf", BaseService.dataScopeFilter(prescriptionUser.getCurrentUser(), "o", "u"));
                prescriptionRoleList = prescriptionRoleDao.findList(prescriptionRole);
            }
            putCache(CACHE_ROLE_LIST, prescriptionRoleList);
        }
        return prescriptionRoleList;
    }

    /**
     * 获取当前用户授权菜单
     *
     * @return
     */
    public static List<PrescriptionMenu> getPrescriptionMenuList() {
        @SuppressWarnings("unchecked")
        List<PrescriptionMenu> prescriptionMenuList = (List<PrescriptionMenu>) getCache(CACHE_MENU_LIST);
        if (prescriptionMenuList == null) {
            PrescriptionUser prescriptionUser = getPrescriptionUser();
            if (prescriptionUser.isAdmin()) {
                prescriptionMenuList = prescriptionMenuDao.findAllList(new PrescriptionMenu());
            } else {
                PrescriptionMenu prescriptionMenu = new PrescriptionMenu();
                prescriptionMenu.setUserId(prescriptionUser.getId());
                prescriptionMenuList = prescriptionMenuDao.findByUserId(prescriptionMenu);
            }
            putCache(CACHE_MENU_LIST, prescriptionMenuList);
        }
        return prescriptionMenuList;
    }

    /**
     * 获取当前用户授权的区域
     *
     * @return
     */
    public static List<PrescriptionArea> getPrescriptionAreaList() {
        @SuppressWarnings("unchecked")
        List<PrescriptionArea> prescriptionAreaList = (List<PrescriptionArea>) getCache(CACHE_AREA_LIST);
        if (prescriptionAreaList == null) {
            prescriptionAreaList = prescriptionAreaDao.findAllList(new PrescriptionArea());
            putCache(CACHE_AREA_LIST, prescriptionAreaList);
        }
        return prescriptionAreaList;
    }

    /**
     * 获取当前用户有权限访问的部门
     *
     * @return
     */
    public static List<PrescriptionOffice> getPrescriptionOfficeList() {
        @SuppressWarnings("unchecked")
        List<PrescriptionOffice> prescriptionOfficeList = (List<PrescriptionOffice>) getCache(CACHE_OFFICE_LIST);
        if (prescriptionOfficeList == null) {
            PrescriptionUser prescriptionUser = getPrescriptionUser();
            if (prescriptionUser.isAdmin()) {
                prescriptionOfficeList = prescriptionOfficeDao.findAllList(new PrescriptionOffice());
            } else {
                PrescriptionOffice prescriptionOffice = new PrescriptionOffice();
                prescriptionOffice.getSqlMap().put("dsf", BaseService.dataScopeFilter1(prescriptionUser, "a", ""));
                prescriptionOfficeList = prescriptionOfficeDao.findList(prescriptionOffice);
            }
            putCache(CACHE_OFFICE_LIST, prescriptionOfficeList);
        }
        return prescriptionOfficeList;
    }

    /**
     * 获取当前用户有权限访问的部门
     *
     * @return
     */
    public static List<PrescriptionOffice> getPrescriptionOfficeAllList() {
        @SuppressWarnings("unchecked")
        List<PrescriptionOffice> prescriptionOfficeList = (List<PrescriptionOffice>) getCache(CACHE_OFFICE_ALL_LIST);
        if (prescriptionOfficeList == null) {
            prescriptionOfficeList = prescriptionOfficeDao.findAllList(new PrescriptionOffice());
        }
        return prescriptionOfficeList;
    }

    /**
     * 获取授权主要对象
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 获取当前登录者对象
     */
    public static PrescriptionPrincipal getPrescriptionPrincipal() {
        try {
            Subject subject = SecurityUtils.getSubject();
            PrescriptionPrincipal principal = (PrescriptionPrincipal) subject.getPrincipal();
            if (principal != null) {
                return principal;
            }
//			subject.logout();
        } catch (UnavailableSecurityManagerException e) {

        } catch (InvalidSessionException e) {

        }
        return null;
    }

    public static Session getSession() {
        try {
            Subject subject = SecurityUtils.getSubject();
            Session session = subject.getSession(false);
            if (session == null) {
                session = subject.getSession();
            }
            if (session != null) {
                return session;
            }
//			subject.logout();
        } catch (InvalidSessionException e) {

        }
        return null;
    }

    // ============== User Cache ==============

    public static Object getCache(String key) {
        return getCache(key, null);
    }

    public static Object getCache(String key, Object defaultValue) {
//		Object obj = getCacheMap().get(key);
        Object obj = getSession().getAttribute(key);
        return obj == null ? defaultValue : obj;
    }

    public static void putCache(String key, Object value) {
//		getCacheMap().put(key, value);
        getSession().setAttribute(key, value);
    }

    public static void removeCache(String key) {
//		getCacheMap().remove(key);
        getSession().removeAttribute(key);
    }

//	public static Map<String, Object> getCacheMap(){
//		Principal principal = getPrincipal();
//		if(principal!=null){
//			return principal.getCacheMap();
//		}
//		return new HashMap<String, Object>();
//	}

}
