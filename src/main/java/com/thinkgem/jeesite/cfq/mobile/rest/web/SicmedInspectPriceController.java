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

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedInspectPriceService;

/**
 * RESTful接口示例Controller
 *
 * @author DING
 * @version 2016-07-22
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedInspectPrice")
public class SicmedInspectPriceController extends BaseController {

    @Autowired
    private SicmedInspectPriceService sicmedInspectPriceService;

    @ModelAttribute
    public SicmedInspectPrice get(@RequestParam(required = false) String id) {
        SicmedInspectPrice entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedInspectPriceService.get(id);
        }
        if (entity == null) {
            entity = new SicmedInspectPrice();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedInspectPrice:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedInspectPrice sicmedInspectPrice, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedInspectPrice> page = sicmedInspectPriceService.findPage(new Page<SicmedInspectPrice>(request, response), sicmedInspectPrice);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedInspectPriceList";
    }

    @RequiresPermissions("rest:sicmedInspectPrice:view")
    @RequestMapping(value = "form")
    public String form(SicmedInspectPrice sicmedInspectPrice, Model model) {
        model.addAttribute("sicmedInspectPrice", sicmedInspectPrice);
        return "mobile/rest/sicmedInspectPriceForm";
    }

    @RequiresPermissions("rest:sicmedInspectPrice:edit")
    @RequestMapping(value = "save")
    public String save(SicmedInspectPrice sicmedInspectPrice, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedInspectPrice)) {
            return form(sicmedInspectPrice, model);
        }
        sicmedInspectPriceService.save(sicmedInspectPrice);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedInspectPrice/?repage";
    }

    @RequiresPermissions("rest:sicmedInspectPrice:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedInspectPrice sicmedInspectPrice, RedirectAttributes redirectAttributes) {
        sicmedInspectPriceService.delete(sicmedInspectPrice);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedInspectPrice/?repage";
    }

}