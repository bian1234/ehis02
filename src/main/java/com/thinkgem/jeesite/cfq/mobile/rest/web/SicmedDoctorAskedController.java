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


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDoctorAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDoctorAskedService;

/**
 * 医生常用医嘱Controller
 *
 * @author XUE
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedDoctorAsked")
public class SicmedDoctorAskedController extends BaseController {

    @Autowired
    private SicmedDoctorAskedService sicmedDoctorAskedService;

    @ModelAttribute
    public SicmedDoctorAsked get(@RequestParam(required = false) String id) {
        SicmedDoctorAsked entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedDoctorAskedService.get(id);
        }
        if (entity == null) {
            entity = new SicmedDoctorAsked();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedDoctorAsked:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedDoctorAsked sicmedDoctorAsked, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedDoctorAsked> page = sicmedDoctorAskedService.findPage(new Page<SicmedDoctorAsked>(request, response), sicmedDoctorAsked);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedDoctorAskedList";
    }

    @RequiresPermissions("rest:sicmedDoctorAsked:view")
    @RequestMapping(value = "form")
    public String form(SicmedDoctorAsked sicmedDoctorAsked, Model model) {
        model.addAttribute("sicmedDoctorAsked", sicmedDoctorAsked);
        return "mobile/rest/sicmedDoctorAskedForm";
    }

    @RequiresPermissions("rest:sicmedDoctorAsked:edit")
    @RequestMapping(value = "save")
    public String save(SicmedDoctorAsked sicmedDoctorAsked, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedDoctorAsked)) {
            return form(sicmedDoctorAsked, model);
        }
        sicmedDoctorAskedService.save(sicmedDoctorAsked);
        addMessage(redirectAttributes, "保存医生常用医嘱保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedDoctorAsked/?repage";
    }

    @RequiresPermissions("rest:sicmedDoctorAsked:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedDoctorAsked sicmedDoctorAsked, RedirectAttributes redirectAttributes) {
        sicmedDoctorAskedService.delete(sicmedDoctorAsked);
        addMessage(redirectAttributes, "删除医生常用医嘱保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedDoctorAsked/?repage";
    }

}