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

import com.thinkgem.jeesite.cfq.mobile.rest.entity.Sno;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SnoService;

/**
 * 单表生成Controller
 *
 * @author Max
 * @version 2016-08-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sno")
public class SnoController extends BaseController {

    @Autowired
    private SnoService snoService;

    @ModelAttribute
    public Sno get(@RequestParam(required = false) String id) {
        Sno entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = snoService.get(id);
        }
        if (entity == null) {
            entity = new Sno();
        }
        return entity;
    }

    @RequiresPermissions("rest:sno:view")
    @RequestMapping(value = {"list", ""})
    public String list(Sno sno, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Sno> page = snoService.findPage(new Page<Sno>(request, response), sno);
        model.addAttribute("page", page);
        return "mobile/rest/snoList";
    }

    @RequiresPermissions("rest:sno:view")
    @RequestMapping(value = "form")
    public String form(Sno sno, Model model) {
        model.addAttribute("sno", sno);
        return "mobile/rest/snoForm";
    }

    @RequiresPermissions("rest:sno:edit")
    @RequestMapping(value = "save")
    public String save(Sno sno, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sno)) {
            return form(sno, model);
        }
        snoService.save(sno);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sno/?repage";
    }

    @RequiresPermissions("rest:sno:edit")
    @RequestMapping(value = "delete")
    public String delete(Sno sno, RedirectAttributes redirectAttributes) {
        snoService.delete(sno);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sno/?repage";
    }

}