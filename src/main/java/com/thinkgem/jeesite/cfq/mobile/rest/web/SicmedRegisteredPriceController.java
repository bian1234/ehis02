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


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegisteredPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedRegisteredPriceService;

/**
 * 挂号价格Controller
 *
 * @author XUE
 * @version 2016-09-06
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedRegisteredPrice")
public class SicmedRegisteredPriceController extends BaseController {

    @Autowired
    private SicmedRegisteredPriceService sicmedRegisteredPriceService;

    @ModelAttribute
    public SicmedRegisteredPrice get(@RequestParam(required = false) String id) {
        SicmedRegisteredPrice entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedRegisteredPriceService.get(id);
        }
        if (entity == null) {
            entity = new SicmedRegisteredPrice();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedRegisteredPrice:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedRegisteredPrice sicmedRegisteredPrice, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedRegisteredPrice> page = sicmedRegisteredPriceService.findPage(new Page<SicmedRegisteredPrice>(request, response), sicmedRegisteredPrice);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedRegisteredPriceList";
    }

    @RequiresPermissions("rest:sicmedRegisteredPrice:view")
    @RequestMapping(value = "form")
    public String form(SicmedRegisteredPrice sicmedRegisteredPrice, Model model) {
        model.addAttribute("sicmedRegisteredPrice", sicmedRegisteredPrice);
        return "mobile/rest/sicmedRegisteredPriceForm";
    }

    @RequiresPermissions("rest:sicmedRegisteredPrice:edit")
    @RequestMapping(value = "save")
    public String save(SicmedRegisteredPrice sicmedRegisteredPrice, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedRegisteredPrice)) {
            return form(sicmedRegisteredPrice, model);
        }
        sicmedRegisteredPriceService.save(sicmedRegisteredPrice);
        addMessage(redirectAttributes, "保存挂号价格成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedRegisteredPrice/?repage";
    }

    @RequiresPermissions("rest:sicmedRegisteredPrice:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedRegisteredPrice sicmedRegisteredPrice, RedirectAttributes redirectAttributes) {
        sicmedRegisteredPriceService.delete(sicmedRegisteredPrice);
        addMessage(redirectAttributes, "删除挂号价格成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedRegisteredPrice/?repage";
    }

}