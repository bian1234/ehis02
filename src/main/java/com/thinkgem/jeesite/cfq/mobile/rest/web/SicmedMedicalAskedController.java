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

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalAskedService;

/**
 * 医嘱患者中间表Controller
 *
 * @author 丁学志
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedMedicalAsked")
public class SicmedMedicalAskedController extends BaseController {

    @Autowired
    private SicmedMedicalAskedService sicmedMedicalAskedService;

    @ModelAttribute
    public SicmedMedicalAsked get(@RequestParam(required = false) String id) {
        SicmedMedicalAsked entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedMedicalAskedService.get(id);
        }
        if (entity == null) {
            entity = new SicmedMedicalAsked();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedMedicalAsked:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedMedicalAsked sicmedMedicalAsked, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedMedicalAsked> page = sicmedMedicalAskedService.findPage(new Page<SicmedMedicalAsked>(request, response), sicmedMedicalAsked);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedMedicalAskedList";
    }

    @RequiresPermissions("rest:sicmedMedicalAsked:view")
    @RequestMapping(value = "form")
    public String form(SicmedMedicalAsked sicmedMedicalAsked, Model model) {
        model.addAttribute("sicmedMedicalAsked", sicmedMedicalAsked);
        return "mobile/rest/sicmedMedicalAskedForm";
    }

    @RequiresPermissions("rest:sicmedMedicalAsked:edit")
    @RequestMapping(value = "save")
    public String save(SicmedMedicalAsked sicmedMedicalAsked, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedMedicalAsked)) {
            return form(sicmedMedicalAsked, model);
        }
        sicmedMedicalAskedService.save(sicmedMedicalAsked);
        addMessage(redirectAttributes, "保存医嘱患者中间表方保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedMedicalAsked/?repage";
    }

    @RequiresPermissions("rest:sicmedMedicalAsked:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedMedicalAsked sicmedMedicalAsked, RedirectAttributes redirectAttributes) {
        sicmedMedicalAskedService.delete(sicmedMedicalAsked);
        addMessage(redirectAttributes, "删除医嘱患者中间表方保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedMedicalAsked/?repage";
    }

}