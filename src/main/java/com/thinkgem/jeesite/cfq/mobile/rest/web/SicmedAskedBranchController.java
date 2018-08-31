/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.cfq.common.config.Global;
import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedBranchService;

/**
 * 医嘱传送部门Controller
 *
 * @author XUE
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedAskedBranch")
public class SicmedAskedBranchController extends BaseController {

    @Autowired
    private SicmedAskedBranchService sicmedAskedBranchService;

    @ModelAttribute
    public SicmedAskedBranch get(@RequestParam(required = false) String id) {
        SicmedAskedBranch entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedAskedBranchService.get(id);
        }
        if (entity == null) {
            entity = new SicmedAskedBranch();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedAskedBranch:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedAskedBranch sicmedAskedBranch, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedAskedBranch> page = sicmedAskedBranchService.findPage(new Page<SicmedAskedBranch>(request, response), sicmedAskedBranch);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedAskedBranchList";
    }

    @RequiresPermissions("rest:sicmedAskedBranch:view")
    @RequestMapping(value = "form")
    public String form(SicmedAskedBranch sicmedAskedBranch, Model model) {
        model.addAttribute("sicmedAskedBranch", sicmedAskedBranch);
        return "mobile/rest/sicmedAskedBranchForm";
    }

    @RequiresPermissions("rest:sicmedAskedBranch:edit")
    @RequestMapping(value = "save")
    public String save(SicmedAskedBranch sicmedAskedBranch, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedAskedBranch)) {
            return form(sicmedAskedBranch, model);
        }
        sicmedAskedBranchService.save(sicmedAskedBranch);
        addMessage(redirectAttributes, "保存医嘱传送成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedAskedBranch/?repage";
    }

    @RequiresPermissions("rest:sicmedAskedBranch:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedAskedBranch sicmedAskedBranch, RedirectAttributes redirectAttributes) {
        sicmedAskedBranchService.delete(sicmedAskedBranch);
        addMessage(redirectAttributes, "删除医嘱传送成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedAskedBranch/?repage";
    }

}