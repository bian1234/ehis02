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


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInviteNumber;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInviteNumberService;

/**
 * 账号激活码Controller
 *
 * @author Max
 * @version 2016-07-19
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedInviteNumber")
public class SicmedInviteNumberController extends BaseController {

    @Autowired
    private SicmedInviteNumberService sicmedInviteNumberService;

    @ModelAttribute
    public SicmedInviteNumber get(@RequestParam(required = false) String id) {
        SicmedInviteNumber entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedInviteNumberService.get(id);
        }
        if (entity == null) {
            entity = new SicmedInviteNumber();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedInviteNumber:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedInviteNumber sicmedInviteNumber, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedInviteNumber> page = sicmedInviteNumberService.findPage(new Page<SicmedInviteNumber>(request, response), sicmedInviteNumber);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedInviteNumberList";
    }

    @RequiresPermissions("rest:sicmedInviteNumber:view")
    @RequestMapping(value = "form")
    public String form(SicmedInviteNumber sicmedInviteNumber, Model model) {
        model.addAttribute("sicmedInviteNumber", sicmedInviteNumber);
        return "mobile/rest/sicmedInviteNumberForm";
    }

    @RequiresPermissions("rest:sicmedInviteNumber:edit")
    @RequestMapping(value = "save")
    public String save(SicmedInviteNumber sicmedInviteNumber, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedInviteNumber)) {
            return form(sicmedInviteNumber, model);
        }
        sicmedInviteNumberService.save(sicmedInviteNumber);
        addMessage(redirectAttributes, "保存保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedInviteNumber/?repage";
    }

    @RequiresPermissions("rest:sicmedInviteNumber:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedInviteNumber sicmedInviteNumber, RedirectAttributes redirectAttributes) {
        sicmedInviteNumberService.delete(sicmedInviteNumber);
        addMessage(redirectAttributes, "删除保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedInviteNumber/?repage";
    }

}