/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.Page;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranchAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBranchAskedService;

/**
 * 科室常用医嘱Controller
 *
 * @author XUE
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedBranchAsked")
public class SicmedBranchAskedController extends BaseController {

    @Autowired
    private SicmedBranchAskedService sicmedBranchAskedService;

    @ModelAttribute
    public SicmedBranchAsked get(@RequestParam(required = false) String id) {
        SicmedBranchAsked entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedBranchAskedService.get(id);
        }
        if (entity == null) {
            entity = new SicmedBranchAsked();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedBranchAsked:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedBranchAsked sicmedBranchAsked, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedBranchAsked> page = sicmedBranchAskedService.findPage(new Page<SicmedBranchAsked>(request, response), sicmedBranchAsked);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedBranchAskedList";
    }

    @RequiresPermissions("rest:sicmedBranchAsked:view")
    @RequestMapping(value = "form")
    public String form(SicmedBranchAsked sicmedBranchAsked, Model model) {
        model.addAttribute("sicmedBranchAsked", sicmedBranchAsked);
        return "mobile/rest/sicmedBranchAskedForm";
    }

    @RequiresPermissions("rest:sicmedBranchAsked:edit")
    @RequestMapping(value = "save")
    public String save(SicmedBranchAsked sicmedBranchAsked, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedBranchAsked)) {
            return form(sicmedBranchAsked, model);
        }
        sicmedBranchAskedService.save(sicmedBranchAsked);
        addMessage(redirectAttributes, "保存科室常用医嘱保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedBranchAsked/?repage";
    }

    @RequiresPermissions("rest:sicmedBranchAsked:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedBranchAsked sicmedBranchAsked, RedirectAttributes redirectAttributes) {
        sicmedBranchAskedService.delete(sicmedBranchAsked);
        addMessage(redirectAttributes, "删除科室常用医嘱保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedBranchAsked/?repage";
    }

}