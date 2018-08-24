/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thinkgem.jeesite.cfq.common.beanvalidator.BeanValidators;
import com.thinkgem.jeesite.cfq.common.config.Global;
import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.utils.DateUtils;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.common.utils.excel.ExportExcel;
import com.thinkgem.jeesite.cfq.common.utils.excel.ImportExcel;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionOffice;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionRole;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionUser;
import com.thinkgem.jeesite.cfq.sys.service.PrescriptionSystemService;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionUserUtils;

/**
 * 用户Controller
 *
 * @author ThinkGem
 * @version 2013-8-29
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/prescriptionUser")
public class PrescriptionUserController extends BaseController {

    @Autowired
    private PrescriptionSystemService prescriptionSystemService;

    @ModelAttribute
    public PrescriptionUser get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return prescriptionSystemService.getUser(id);
        } else {
            return new PrescriptionUser();
        }
    }

    @RequiresPermissions("sys:prescriptionUser:view")
    @RequestMapping(value = {"index"})
    public String index(PrescriptionUser prescriptionUser, Model model) {
        return "cfq/sys/userIndex";
    }

    @RequiresPermissions("sys:prescriptionUser:view")
    @RequestMapping(value = {"list", ""})
    public String list(PrescriptionUser prescriptionUser, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<PrescriptionUser> page = prescriptionSystemService.findUser(new Page<PrescriptionUser>(request, response), prescriptionUser);
        model.addAttribute("page", page);
        return "cfq/sys/userList";
    }

    @ResponseBody
    @RequiresPermissions("sys:prescriptionUser:view")
    @RequestMapping(value = {"listData"})
    public Page<PrescriptionUser> listData(PrescriptionUser prescriptionUser, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<PrescriptionUser> page = prescriptionSystemService.findUser(new Page<PrescriptionUser>(request, response), prescriptionUser);
        return page;
    }

    @RequiresPermissions("sys:prescriptionUser:view")
    @RequestMapping(value = "form")
    public String form(PrescriptionUser prescriptionUser, Model model) {
        if (prescriptionUser.getCompany() == null || prescriptionUser.getCompany().getId() == null) {
            prescriptionUser.setCompany(PrescriptionUserUtils.getPrescriptionUser().getCompany());
        }
        if (prescriptionUser.getOffice() == null || prescriptionUser.getOffice().getId() == null) {
            prescriptionUser.setOffice(PrescriptionUserUtils.getPrescriptionUser().getOffice());
        }
        model.addAttribute("user", prescriptionUser);
        model.addAttribute("allRoles", prescriptionSystemService.findAllRole());
        return "cfq/sys/userForm";
    }

    @RequiresPermissions("sys:prescriptionUser:edit")
    @RequestMapping(value = "save")
    public String save(PrescriptionUser prescriptionUser, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionUser/list?repage";
        }
        // 修正引用赋值问题，不知道为何，Company和Office引用的一个实例地址，修改了一个，另外一个跟着修改。
        prescriptionUser.setCompany(new PrescriptionOffice(request.getParameter("company.id")));
        prescriptionUser.setOffice(new PrescriptionOffice(request.getParameter("office.id")));
        // 如果新密码为空，则不更换密码
        if (StringUtils.isNotBlank(prescriptionUser.getNewPassword())) {
            prescriptionUser.setPassword(PrescriptionSystemService.entryptPassword(prescriptionUser.getNewPassword()));
        }
        if (!beanValidator(model, prescriptionUser)) {
            return form(prescriptionUser, model);
        }
        if (!"true".equals(checkLoginName(prescriptionUser.getOldLoginName(), prescriptionUser.getLoginName()))) {
            addMessage(model, "保存用户'" + prescriptionUser.getLoginName() + "'失败，登录名已存在");
            return form(prescriptionUser, model);
        }
        // 角色数据有效性验证，过滤不在授权内的角色
        List<PrescriptionRole> prescriptionRoleList = Lists.newArrayList();
        List<String> roleIdList = prescriptionUser.getRoleIdList();
        for (PrescriptionRole r : prescriptionSystemService.findAllRole()) {
            if (roleIdList.contains(r.getId())) {
                prescriptionRoleList.add(r);
            }
        }
        prescriptionUser.setRoleList(prescriptionRoleList);
        // 保存用户信息
        prescriptionSystemService.saveUser(prescriptionUser);
        // 清除当前用户缓存
        if (prescriptionUser.getLoginName().equals(PrescriptionUserUtils.getPrescriptionUser().getLoginName())) {
            PrescriptionUserUtils.clearCache();
            //UserUtils.getCacheMap().clear();
        }
        addMessage(redirectAttributes, "保存用户'" + prescriptionUser.getLoginName() + "'成功");
        return "redirect:" + adminPath + "/sys/prescriptionUser/list?repage";
    }

    @RequiresPermissions("sys:prescriptionUser:edit")
    @RequestMapping(value = "delete")
    public String delete(PrescriptionUser prescriptionUser, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionUser/list?repage";
        }
        if (PrescriptionUserUtils.getPrescriptionUser().getId().equals(prescriptionUser.getId())) {
            addMessage(redirectAttributes, "删除用户失败, 不允许删除当前用户");
        } else if (PrescriptionUser.isAdmin(prescriptionUser.getId())) {
            addMessage(redirectAttributes, "删除用户失败, 不允许删除超级管理员用户");
        } else {
            prescriptionSystemService.deleteUser(prescriptionUser);
            addMessage(redirectAttributes, "删除用户成功");
        }
        return "redirect:" + adminPath + "/sys/prescriptionUser/list?repage";
    }

    /**
     * 导出用户数据
     *
     * @param user
     * @param request
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sys:prescriptionUser:view")
    @RequestMapping(value = "export", method = RequestMethod.POST)
    public String exportFile(PrescriptionUser prescriptionUser, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        try {
            String fileName = "用户数据" + DateUtils.getDate("yyyyMMddHHmmss") + ".xlsx";
            Page<PrescriptionUser> page = prescriptionSystemService.findUser(new Page<PrescriptionUser>(request, response, -1), prescriptionUser);
            new ExportExcel("用户数据", PrescriptionUser.class).setDataList(page.getList()).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导出用户失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + adminPath + "/sys/prescriptionUser/list?repage";
    }

    /**
     * 导入用户数据
     *
     * @param file
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sys:prescriptionUser:edit")
    @RequestMapping(value = "import", method = RequestMethod.POST)
    public String importFile(MultipartFile file, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionUser/list?repage";
        }
        try {
            int successNum = 0;
            int failureNum = 0;
            StringBuilder failureMsg = new StringBuilder();
            ImportExcel ei = new ImportExcel(file, 1, 0);
            List<PrescriptionUser> list = ei.getDataList(PrescriptionUser.class);
            for (PrescriptionUser prescriptionUser : list) {
                try {
                    if ("true".equals(checkLoginName("", prescriptionUser.getLoginName()))) {
                        prescriptionUser.setPassword(PrescriptionSystemService.entryptPassword("123456"));
                        BeanValidators.validateWithException(validator, prescriptionUser);
                        prescriptionSystemService.saveUser(prescriptionUser);
                        successNum++;
                    } else {
                        failureMsg.append("<br/>登录名 " + prescriptionUser.getLoginName() + " 已存在; ");
                        failureNum++;
                    }
                } catch (ConstraintViolationException ex) {
                    failureMsg.append("<br/>登录名 " + prescriptionUser.getLoginName() + " 导入失败：");
                    List<String> messageList = BeanValidators.extractPropertyAndMessageAsList(ex, ": ");
                    for (String message : messageList) {
                        failureMsg.append(message + "; ");
                        failureNum++;
                    }
                } catch (Exception ex) {
                    failureMsg.append("<br/>登录名 " + prescriptionUser.getLoginName() + " 导入失败：" + ex.getMessage());
                }
            }
            if (failureNum > 0) {
                failureMsg.insert(0, "，失败 " + failureNum + " 条用户，导入信息如下：");
            }
            addMessage(redirectAttributes, "已成功导入 " + successNum + " 条用户" + failureMsg);
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入用户失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + adminPath + "/sys/prescriptionUser/list?repage";
    }

    /**
     * 下载导入用户数据模板
     *
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sys:prescriptionUser:view")
    @RequestMapping(value = "import/template")
    public String importFileTemplate(HttpServletResponse response, RedirectAttributes redirectAttributes) {
        try {
            String fileName = "用户数据导入模板.xlsx";
            List<PrescriptionUser> list = Lists.newArrayList();
            list.add(PrescriptionUserUtils.getPrescriptionUser());
            new ExportExcel("用户数据", PrescriptionUser.class, 2).setDataList(list).write(response, fileName).dispose();
            return null;
        } catch (Exception e) {
            addMessage(redirectAttributes, "导入模板下载失败！失败信息：" + e.getMessage());
        }
        return "redirect:" + adminPath + "/sys/prescriptionUser/list?repage";
    }

    /**
     * 验证登录名是否有效
     *
     * @param oldLoginName
     * @param loginName
     * @return
     */
    @ResponseBody
    @RequiresPermissions("sys:prescriptionUser:edit")
    @RequestMapping(value = "checkLoginName")
    public String checkLoginName(String oldLoginName, String loginName) {
        if (loginName != null && loginName.equals(oldLoginName)) {
            return "true";
        } else if (loginName != null && prescriptionSystemService.getUserByLoginName(loginName) == null) {
            return "true";
        }
        return "false";
    }

    /**
     * 用户信息显示及保存
     *
     * @param user
     * @param model
     * @return
     */
    @RequiresPermissions("user")
    @RequestMapping(value = "info")
    public String info(PrescriptionUser prescriptionUser, HttpServletResponse response, Model model) {
        PrescriptionUser currentUser = PrescriptionUserUtils.getPrescriptionUser();
        if (StringUtils.isNotBlank(prescriptionUser.getName())) {
            if (Global.isDemoMode()) {
                model.addAttribute("message", "演示模式，不允许操作！");
                return "modules/sys/userInfo";
            }
            currentUser.setEmail(prescriptionUser.getEmail());
            currentUser.setPhone(prescriptionUser.getPhone());
            currentUser.setMobile(prescriptionUser.getMobile());
            currentUser.setRemarks(prescriptionUser.getRemarks());
            currentUser.setPhoto(prescriptionUser.getPhoto());
            prescriptionSystemService.updateUserInfo(currentUser);
            model.addAttribute("message", "保存用户信息成功");
        }
        model.addAttribute("prescriptionUser", currentUser);
        model.addAttribute("Global", new Global());
        return "cfq/sys/userInfo";
    }

    /**
     * 返回用户信息
     *
     * @return
     */
    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "infoData")
    public PrescriptionUser infoData() {
        return PrescriptionUserUtils.getPrescriptionUser();
    }

    /**
     * 修改个人用户密码
     *
     * @param oldPassword
     * @param newPassword
     * @param model
     * @return
     */
    @RequiresPermissions("user")
    @RequestMapping(value = "modifyPwd")
    public String modifyPwd(String oldPassword, String newPassword, Model model) {
        PrescriptionUser prescriptionUser = PrescriptionUserUtils.getPrescriptionUser();
        if (StringUtils.isNotBlank(oldPassword) && StringUtils.isNotBlank(newPassword)) {
            if (Global.isDemoMode()) {
                model.addAttribute("message", "演示模式，不允许操作！");
                return "cfq/sys/userModifyPwd";
            }
            if (PrescriptionSystemService.validatePassword(oldPassword, prescriptionUser.getPassword())) {
                prescriptionSystemService.updatePasswordById(prescriptionUser.getId(), prescriptionUser.getLoginName(), newPassword);
                model.addAttribute("message", "修改密码成功");
            } else {
                model.addAttribute("message", "修改密码失败，旧密码错误");
            }
        }
        model.addAttribute("prescriptionUser", prescriptionUser);
        return "cfq/sys/userModifyPwd";
    }

    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required = false) String officeId, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<PrescriptionUser> list = prescriptionSystemService.findUserByOfficeId(officeId);
        for (int i = 0; i < list.size(); i++) {
            PrescriptionUser e = list.get(i);
            Map<String, Object> map = Maps.newHashMap();
            map.put("id", "u_" + e.getId());
            map.put("pId", officeId);
            map.put("name", StringUtils.replace(e.getName(), " ", ""));
            mapList.add(map);
        }
        return mapList;
    }

//	@InitBinder
//	public void initBinder(WebDataBinder b) {
//		b.registerCustomEditor(List.class, "roleList", new PropertyEditorSupport(){
//			@Autowired
//			private SystemService systemService;
//			@Override
//			public void setAsText(String text) throws IllegalArgumentException {
//				String[] ids = StringUtils.split(text, ",");
//				List<Role> roles = new ArrayList<Role>();
//				for (String id : ids) {
//					Role role = systemService.getRole(Long.valueOf(id));
//					roles.add(role);
//				}
//				setValue(roles);
//			}
//			@Override
//			public String getAsText() {
//				return Collections3.extractToString((List) getValue(), "id", ",");
//			}
//		});
//	}
}
