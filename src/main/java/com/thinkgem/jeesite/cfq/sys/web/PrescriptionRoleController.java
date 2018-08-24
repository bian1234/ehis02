/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.config.Global;
import com.thinkgem.jeesite.cfq.common.utils.Collections3;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionOffice;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionRole;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionUser;
import com.thinkgem.jeesite.cfq.sys.service.PrescriptionOfficeService;
import com.thinkgem.jeesite.cfq.sys.service.PrescriptionSystemService;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionUserUtils;

/**
 * 角色Controller
 *
 * @author ThinkGem
 * @version 2013-12-05
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/prescriptionRole")
public class PrescriptionRoleController extends BaseController {

    @Autowired
    private PrescriptionSystemService prescriptionSystemService;

    @Autowired
    private PrescriptionOfficeService prescriptionOfficeService;

    @ModelAttribute("prescriptionRole")
    public PrescriptionRole get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return prescriptionSystemService.getRole(id);
        } else {
            return new PrescriptionRole();
        }
    }

    @RequiresPermissions("sys:prescriptionRole:view")
    @RequestMapping(value = {"list", ""})
    public String list(PrescriptionRole PrescriptionRole, Model model) {
        List<PrescriptionRole> list = prescriptionSystemService.findAllRole();
        model.addAttribute("list", list);
        return "cfq/sys/roleList";
    }

    @RequiresPermissions("sys:prescriptionRole:view")
    @RequestMapping(value = "form")
    public String form(PrescriptionRole prescriptionRole, Model model) {
        if (prescriptionRole.getOffice() == null) {
            prescriptionRole.setOffice(PrescriptionUserUtils.getPrescriptionUser().getOffice());
        }
        model.addAttribute("prescriptionRole", prescriptionRole);
        model.addAttribute("menuList", prescriptionSystemService.findAllMenu());
        model.addAttribute("officeList", prescriptionOfficeService.findAll());
        return "cfq/sys/roleForm";
    }

    @RequiresPermissions("sys:prescriptionRole:edit")
    @RequestMapping(value = "save")
    public String save(PrescriptionRole prescriptionRole, Model model, RedirectAttributes redirectAttributes) {
        if (!PrescriptionUserUtils.getPrescriptionUser().isAdmin() && prescriptionRole.getSysData().equals(Global.YES)) {
            addMessage(redirectAttributes, "越权操作，只有超级管理员才能修改此数据！");
            return "redirect:" + adminPath + "/sys/prescriptionRole/?repage";
        }
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionRole/?repage";
        }
        if (!beanValidator(model, prescriptionRole)) {
            return form(prescriptionRole, model);
        }
    /*	if (!"true".equals(checkName(prescriptionRole.getOldName(), prescriptionRole.getName()))){
			addMessage(model, "保存角色'" + prescriptionRole.getName() + "'失败, 角色名已存在");
			return form(prescriptionRole, model);
		}
		if (!"true".equals(checkEnname(prescriptionRole.getOldEnname(), prescriptionRole.getEnname()))){
			addMessage(model, "保存角色'" + prescriptionRole.getName() + "'失败, 英文名已存在");
			return form(prescriptionRole, model);
		}*/
        prescriptionSystemService.saveRole(prescriptionRole);
        addMessage(redirectAttributes, "保存角色'" + prescriptionRole.getName() + "'成功");
        return "redirect:" + adminPath + "/sys/prescriptionRole/?repage";
    }

    @RequiresPermissions("sys:prescriptionRole:edit")
    @RequestMapping(value = "delete")
    public String delete(PrescriptionRole prescriptionRole, RedirectAttributes redirectAttributes) {
        if (!PrescriptionUserUtils.getPrescriptionUser().isAdmin() && prescriptionRole.getSysData().equals(Global.YES)) {
            addMessage(redirectAttributes, "越权操作，只有超级管理员才能修改此数据！");
            return "redirect:" + adminPath + "/sys/prescriptionRole/?repage";
        }
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionRole/?repage";
        }
//		if (Role.isAdmin(id)){
//			addMessage(redirectAttributes, "删除角色失败, 不允许内置角色或编号空");
////		}else if (UserUtils.getUser().getRoleIdList().contains(id)){
////			addMessage(redirectAttributes, "删除角色失败, 不能删除当前用户所在角色");
//		}else{
        prescriptionSystemService.deleteRole(prescriptionRole);
        addMessage(redirectAttributes, "删除角色成功");
//		}
        return "redirect:" + adminPath + "/sys/prescriptionRole/?repage";
    }

    /**
     * 角色分配页面
     *
     * @param role
     * @param model
     * @return
     */
    @RequiresPermissions("sys:prescriptionRole:edit")
    @RequestMapping(value = "assign")
    public String assign(PrescriptionRole prescriptionRole, Model model) {
        List<PrescriptionUser> userList = prescriptionSystemService.findUser(new PrescriptionUser(new PrescriptionRole(prescriptionRole.getId())));
        model.addAttribute("userList", userList);
        return "cfq/sys/roleAssign";
    }

    /**
     * 角色分配 -- 打开角色分配对话框
     *
     * @param role
     * @param model
     * @return
     */
    @RequiresPermissions("sys:prescriptionRole:view")
    @RequestMapping(value = "usertorole")
    public String selectUserToRole(PrescriptionRole prescriptionRole, Model model) {
        List<PrescriptionUser> userList = prescriptionSystemService.findUser(new PrescriptionUser(new PrescriptionRole(prescriptionRole.getId())));
        model.addAttribute("prescriptionRole", prescriptionRole);
        model.addAttribute("userList", userList);
        model.addAttribute("selectIds", Collections3.extractToString(userList, "name", ","));
        model.addAttribute("officeList", prescriptionOfficeService.findAll());
        return "cfq/sys/selectUserToRole";
    }

    /**
     * 角色分配 -- 根据部门编号获取用户列表
     *
     * @param officeId
     * @param response
     * @return
     */
    @RequiresPermissions("sys:prescriptionRole:view")
    @ResponseBody
    @RequestMapping(value = "users")
    public List<Map<String, Object>> users(String officeId, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        PrescriptionUser prescriptionUser = new PrescriptionUser();
        prescriptionUser.setOffice(new PrescriptionOffice(officeId));
        Page<PrescriptionUser> page = prescriptionSystemService.findUser(new Page<PrescriptionUser>(1, -1), prescriptionUser);
        for (PrescriptionUser e : page.getList()) {
            Map<String, Object> map = Maps.newHashMap();
            map.put("id", e.getId());
            map.put("pId", 0);
            map.put("name", e.getName());
            mapList.add(map);
        }
        return mapList;
    }

    /**
     * 角色分配 -- 从角色中移除用户
     *
     * @param userId
     * @param roleId
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sys:prescriptionRole:edit")
    @RequestMapping(value = "outrole")
    public String outrole(String userId, String roleId, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionRole/assign?id=" + roleId;
        }
        PrescriptionRole prescriptionRole = prescriptionSystemService.getRole(roleId);
        PrescriptionUser prescriptionUser = prescriptionSystemService.getUser(userId);
        if (PrescriptionUserUtils.getPrescriptionUser().getId().equals(userId)) {
            addMessage(redirectAttributes, "无法从角色【" + prescriptionRole.getName() + "】中移除用户【" + prescriptionUser.getName() + "】自己！");
        } else {
            if (prescriptionUser.getRoleList().size() <= 1) {
                addMessage(redirectAttributes, "用户【" + prescriptionUser.getName() + "】从角色【" + prescriptionRole.getName() + "】中移除失败！这已经是该用户的唯一角色，不能移除。");
            } else {
                Boolean flag = prescriptionSystemService.outUserInRole(prescriptionRole, prescriptionUser);
                if (!flag) {
                    addMessage(redirectAttributes, "用户【" + prescriptionUser.getName() + "】从角色【" + prescriptionRole.getName() + "】中移除失败！");
                } else {
                    addMessage(redirectAttributes, "用户【" + prescriptionUser.getName() + "】从角色【" + prescriptionRole.getName() + "】中移除成功！");
                }
            }
        }
        return "redirect:" + adminPath + "/sys/prescriptionRole/assign?id=" + prescriptionRole.getId();
    }

    /**
     * 角色分配
     *
     * @param role
     * @param idsArr
     * @param redirectAttributes
     * @return
     */
    @RequiresPermissions("sys:prescriptionRole:edit")
    @RequestMapping(value = "assignrole")
    public String assignRole(PrescriptionRole prescriptionRole, String[] idsArr, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionRole/assign?id=" + prescriptionRole.getId();
        }
        StringBuilder msg = new StringBuilder();
        int newNum = 0;
        for (int i = 0; i < idsArr.length; i++) {
            PrescriptionUser prescriptionUser = prescriptionSystemService.assignUserToRole(prescriptionRole, prescriptionSystemService.getUser(idsArr[i]));
            if (null != prescriptionUser) {
                msg.append("<br/>新增用户【" + prescriptionUser.getName() + "】到角色【" + prescriptionRole.getName() + "】！");
                newNum++;
            }
        }
        addMessage(redirectAttributes, "已成功分配 " + newNum + " 个用户" + msg);
        return "redirect:" + adminPath + "/sys/prescriptionRole/assign?id=" + prescriptionRole.getId();
    }

    /**
     * 验证角色名是否有效
     *
     * @param oldName
     * @param name
     * @return
     */
    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "checkName")
    public String checkName(String oldName, String name) {
        if (name != null && name.equals(oldName)) {
            return "true";
        } else if (name != null && prescriptionSystemService.getRoleByName(name) == null) {
            return "true";
        }
        return "false";
    }

    /**
     * 验证角色英文名是否有效
     *
     * @param oldName
     * @param name
     * @return
     */
    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "checkEnname")
    public String checkEnname(String oldEnname, String enname) {
        if (enname != null && enname.equals(oldEnname)) {
            return "true";
        } else if (enname != null && prescriptionSystemService.getRoleByEnname(enname) == null) {
            return "true";
        }
        return "false";
    }

}
