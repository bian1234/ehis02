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


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCurePriceService;

/**
 * 治疗价格 接口示例Controller
 *
 * @author DING
 * @version 2016-07-22
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedCurePrice")
public class SicmedCurePriceController extends BaseController {

    @Autowired
    private SicmedCurePriceService sicmedCurePriceService;

    @ModelAttribute
    public SicmedCurePrice get(@RequestParam(required = false) String id) {
        SicmedCurePrice entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedCurePriceService.get(id);
        }
        if (entity == null) {
            entity = new SicmedCurePrice();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedCurePrice:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedCurePrice sicmedCurePrice, HttpServletRequest request, HttpServletResponse response,
                       Model model) {
        Page<SicmedCurePrice> page = sicmedCurePriceService.findPage(new Page<SicmedCurePrice>(request, response),
                sicmedCurePrice);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedCurePriceList";
    }

    @RequiresPermissions("rest:sicmedCurePrice:view")
    @RequestMapping(value = "form")
    public String form(SicmedCurePrice sicmedCurePrice, Model model) {
        model.addAttribute("sicmedCurePrice", sicmedCurePrice);
        return "mobile/rest/sicmedCurePriceForm";
    }

    @RequiresPermissions("rest:sicmedCurePrice:edit")
    @RequestMapping(value = "save")
    public String save(SicmedCurePrice sicmedCurePrice, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedCurePrice)) {
            return form(sicmedCurePrice, model);
        }
        sicmedCurePriceService.save(sicmedCurePrice);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedCurePrice/?repage";
    }

    @RequiresPermissions("rest:sicmedCurePrice:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedCurePrice sicmedCurePrice, RedirectAttributes redirectAttributes) {
        sicmedCurePriceService.delete(sicmedCurePrice);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedCurePrice/?repage";
    }

}