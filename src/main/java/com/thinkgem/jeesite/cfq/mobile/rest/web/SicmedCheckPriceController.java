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

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCheckPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCheckPriceService;

/**
 * RESTful接口示例Controller
 *
 * @author DING
 * @version 2016-07-22
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedCheckPrice")
public class SicmedCheckPriceController extends BaseController {

    @Autowired
    private SicmedCheckPriceService sicmedCheckPriceService;

    @ModelAttribute
    public SicmedCheckPrice get(@RequestParam(required = false) String id) {
        SicmedCheckPrice entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedCheckPriceService.get(id);
        }
        if (entity == null) {
            entity = new SicmedCheckPrice();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedCheckPrice:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedCheckPrice sicmedCheckPrice, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedCheckPrice> page = sicmedCheckPriceService.findPage(new Page<SicmedCheckPrice>(request, response), sicmedCheckPrice);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedCheckPriceList";
    }

    @RequiresPermissions("rest:sicmedCheckPrice:view")
    @RequestMapping(value = "form")
    public String form(SicmedCheckPrice sicmedCheckPrice, Model model) {
        model.addAttribute("sicmedCheckPrice", sicmedCheckPrice);
        return "mobile/rest/sicmedCheckPriceForm";
    }

    @RequiresPermissions("rest:sicmedCheckPrice:edit")
    @RequestMapping(value = "save")
    public String save(SicmedCheckPrice sicmedCheckPrice, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedCheckPrice)) {
            return form(sicmedCheckPrice, model);
        }
        sicmedCheckPriceService.save(sicmedCheckPrice);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedCheckPrice/?repage";
    }

    @RequiresPermissions("rest:sicmedCheckPrice:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedCheckPrice sicmedCheckPrice, RedirectAttributes redirectAttributes) {
        sicmedCheckPriceService.delete(sicmedCheckPrice);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedCheckPrice/?repage";
    }

}