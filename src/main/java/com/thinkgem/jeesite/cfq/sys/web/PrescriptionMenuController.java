/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.config.Global;
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

import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionMenu;
import com.thinkgem.jeesite.cfq.sys.service.PrescriptionSystemService;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionUserUtils;

/**
 * 菜单Controller
 *
 * @author ThinkGem
 * @version 2013-3-23
 */
@Controller
@RequestMapping(value = "${adminPath}/sys/prescriptionMenu")
public class PrescriptionMenuController extends BaseController {

    @Autowired
    private PrescriptionSystemService prescriptionSystemService;

    @ModelAttribute("prescriptionMenu")
    public PrescriptionMenu get(@RequestParam(required = false) String id) {
        if (StringUtils.isNotBlank(id)) {
            return prescriptionSystemService.getMenu(id);
        } else {
            return new PrescriptionMenu();
        }
    }

    @RequiresPermissions("sys:prescriptionMenu:view")
    @RequestMapping(value = {"list", ""})
    public String list(Model model) {
        List<PrescriptionMenu> list = Lists.newArrayList();
        List<PrescriptionMenu> sourcelist = prescriptionSystemService.findAllMenu();
        PrescriptionMenu.sortList(list, sourcelist, PrescriptionMenu.getRootId(), true);
        model.addAttribute("list", list);
        return "cfq/sys/menuList";
    }

    @RequiresPermissions("sys:prescriptionMenu:view")
    @RequestMapping(value = "form")
    public String form(PrescriptionMenu prescriptionMenu, Model model) {
        if (prescriptionMenu.getParent() == null || prescriptionMenu.getParent().getId() == null) {
            prescriptionMenu.setParent(new PrescriptionMenu(PrescriptionMenu.getRootId()));
        }
        prescriptionMenu.setParent(prescriptionSystemService.getMenu(prescriptionMenu.getParent().getId()));
        // 获取排序号，最末节点排序号+30
        if (StringUtils.isBlank(prescriptionMenu.getId())) {
            List<PrescriptionMenu> list = Lists.newArrayList();
            List<PrescriptionMenu> sourcelist = prescriptionSystemService.findAllMenu();
            PrescriptionMenu.sortList(list, sourcelist, prescriptionMenu.getParentId(), false);
            if (list.size() > 0) {
                prescriptionMenu.setSort(list.get(list.size() - 1).getSort() + 30);
            }
        }
        model.addAttribute("prescriptionMenu", prescriptionMenu);
        return "cfq/sys/menuForm";
    }

    @RequiresPermissions("sys:prescriptionMenu:edit")
    @RequestMapping(value = "save")
    public String save(PrescriptionMenu prescriptionMenu, Model model, RedirectAttributes redirectAttributes) {
        if (!PrescriptionUserUtils.getPrescriptionUser().isAdmin()) {
            addMessage(redirectAttributes, "越权操作，只有超级管理员才能添加或修改数据！");
            return "redirect:" + adminPath + "/sys/prescriptionRole/?repage";
        }
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionMenu/";
        }
        if (!beanValidator(model, prescriptionMenu)) {
            return form(prescriptionMenu, model);
        }
        prescriptionSystemService.saveMenu(prescriptionMenu);
        addMessage(redirectAttributes, "保存菜单'" + prescriptionMenu.getName() + "'成功");
        return "redirect:" + adminPath + "/sys/prescriptionMenu/";
    }

    @RequiresPermissions("sys:prescriptionMenu:edit")
    @RequestMapping(value = "delete")
    public String delete(PrescriptionMenu prescriptionMenu, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionMenu/";
        }
//		if (Menu.isRoot(id)){
//			addMessage(redirectAttributes, "删除菜单失败, 不允许删除顶级菜单或编号为空");
//		}else{
        prescriptionSystemService.deleteMenu(prescriptionMenu);
        addMessage(redirectAttributes, "删除菜单成功");
//		}
        return "redirect:" + adminPath + "/sys/prescriptionMenu/";
    }

    @RequiresPermissions("user")
    @RequestMapping(value = "tree")
    public String tree() {
        return "cfq/sys/menuTree";
    }

    @RequiresPermissions("user")
    @RequestMapping(value = "treeselect")
    public String treeselect(String parentId, Model model) {
        model.addAttribute("parentId", parentId);
        return "cfq/sys/menuTreeselect";
    }

    /**
     * 批量修改菜单排序
     */
    @RequiresPermissions("sys:prescriptionMenu:edit")
    @RequestMapping(value = "updateSort")
    public String updateSort(String[] ids, Integer[] sorts, RedirectAttributes redirectAttributes) {
        if (Global.isDemoMode()) {
            addMessage(redirectAttributes, "演示模式，不允许操作！");
            return "redirect:" + adminPath + "/sys/prescriptionMenu/";
        }
        for (int i = 0; i < ids.length; i++) {
            PrescriptionMenu prescriptionMenu = new PrescriptionMenu(ids[i]);
            prescriptionMenu.setSort(sorts[i]);
            prescriptionSystemService.updateMenuSort(prescriptionMenu);
        }
        addMessage(redirectAttributes, "保存菜单排序成功!");
        return "redirect:" + adminPath + "/sys/prescriptionMenu/";
    }

    /**
     * isShowHide是否显示隐藏菜单
     *
     * @param extId
     * @param isShowHidden
     * @param response
     * @return
     */
    @RequiresPermissions("user")
    @ResponseBody
    @RequestMapping(value = "treeData")
    public List<Map<String, Object>> treeData(@RequestParam(required = false) String extId, @RequestParam(required = false) String isShowHide, HttpServletResponse response) {
        List<Map<String, Object>> mapList = Lists.newArrayList();
        List<PrescriptionMenu> list = prescriptionSystemService.findAllMenu();
        for (int i = 0; i < list.size(); i++) {
            PrescriptionMenu e = list.get(i);
            if (StringUtils.isBlank(extId) || (extId != null && !extId.equals(e.getId()) && e.getParentIds().indexOf("," + extId + ",") == -1)) {
                if (isShowHide != null && isShowHide.equals("0") && e.getIsShow().equals("0")) {
                    continue;
                }
                Map<String, Object> map = Maps.newHashMap();
                map.put("id", e.getId());
                map.put("pId", e.getParentId());
                map.put("name", e.getName());
                mapList.add(map);
            }
        }
        return mapList;
    }
}
