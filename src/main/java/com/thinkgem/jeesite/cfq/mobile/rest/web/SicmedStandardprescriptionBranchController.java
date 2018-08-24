/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStandardprescriptionBranchBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStandardprescriptionBranchBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStandardprescriptionBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBranchService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedStandardprescriptionBranchService;

/**
 * 医生常用疾病表Controller
 *
 * @author Max
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedStandardprescriptionBranch")
public class SicmedStandardprescriptionBranchController extends BaseController {

    @Autowired
    private SicmedStandardprescriptionBranchService sicmedStandardprescriptionBranchService;
    @Autowired
    private SicmedBranchService sicmedBranchService;
    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;

    /**
     * Url:
     * http://localhost:8080/jeesite/a/rest/sicmedStandardprescriptionBranch/
     * findStandardPrescriptionBranch
     *
     * @param id(科室id) (21) askedClass(医嘱类别) (检查)
     * @return 科室标准处方
     */
    @ResponseBody
    @RequestMapping(value = "findStandardPrescriptionBranch")
    public SicmedStandardprescriptionBranchBeans findStandardPrescriptionBranch(
            @RequestParam(required = false) String id, String askedClass, HttpServletResponse response) {
        SicmedStandardprescriptionBranchBeans sicmedStandardprescriptionBranchBeans = new SicmedStandardprescriptionBranchBeans();
        try {
            SicmedBranch sicmedBranch = sicmedBranchService.get(id);
            if (sicmedBranch == null) {
                sicmedStandardprescriptionBranchBeans.setError("1");
                sicmedStandardprescriptionBranchBeans.setErrorMessage("科室编号输入有误或者没有该科室处方");
            } else {
                SicmedAskedClass sicmedAskedClass = sicmedAskedClassService.getAskedByAskedClass(askedClass);
                SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch = new SicmedStandardprescriptionBranch();
                sicmedStandardprescriptionBranch.setSicmedBranch(sicmedBranch);
                sicmedStandardprescriptionBranch.setAskedClass(sicmedAskedClass);

                List<SicmedStandardprescriptionBranch> sicmedStandardprescriptionBranchs = sicmedStandardprescriptionBranchService
                        .findList(sicmedStandardprescriptionBranch);

                if (sicmedStandardprescriptionBranchs.size() != 0) {
                    for (SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch2 : sicmedStandardprescriptionBranchs) {
                        SicmedStandardprescriptionBranchBean sicmedStandardprescriptionBranchBean = new SicmedStandardprescriptionBranchBean();
                        // sicmedStandardprescriptionBranchBeans.getSicmedStandardprescriptionBranchBeans().add(sicmedStandardprescriptionBranchBean);
                        sicmedStandardprescriptionBranch2.setSicmedBranch(sicmedBranch);
                        sicmedStandardprescriptionBranch2.setAskedClass(sicmedAskedClass);
                        // sicmedStandardprescriptionBranch2.setStanderprescriptionDisease(sicmedStanderprescriptionDiseaseService.get(sicmedStandardprescriptionBranch2.getStanderprescriptionDisease().getId()));
                        // sicmedStandardprescriptionBranch2.setStanderprescriptionAsked(sicmedStanderprescriptionAskedService.get(sicmedStandardprescriptionBranch2.getStanderprescriptionAsked().getId()));
                        sicmedStandardprescriptionBranchBean.setssb(sicmedStandardprescriptionBranch2);
                        sicmedStandardprescriptionBranchBeans.getSicmedStandardprescriptionBranchBeans()
                                .add(sicmedStandardprescriptionBranchBean);
                    }
                    sicmedStandardprescriptionBranchBeans.setError("0");
                    sicmedStandardprescriptionBranchBeans.setErrorMessage("科室标准处方查看成功");
                } else {
                    sicmedStandardprescriptionBranchBeans.setError("1");
                    sicmedStandardprescriptionBranchBeans.setErrorMessage("查询失败,找不到信息");
                }
            }

        } catch (Exception e) {
            sicmedStandardprescriptionBranchBeans.setError("1");
            sicmedStandardprescriptionBranchBeans.setErrorMessage("查询失败!系统内部异常" + e.getMessage());
        }
        return sicmedStandardprescriptionBranchBeans;
    }

    @ModelAttribute
    public SicmedStandardprescriptionBranch get(@RequestParam(required = false) String id) {
        SicmedStandardprescriptionBranch entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedStandardprescriptionBranchService.get(id);
        }
        if (entity == null) {
            entity = new SicmedStandardprescriptionBranch();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedStandardprescriptionBranch:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch, HttpServletRequest request,
                       HttpServletResponse response, Model model) {
        Page<SicmedStandardprescriptionBranch> page = sicmedStandardprescriptionBranchService.findPage(
                new Page<SicmedStandardprescriptionBranch>(request, response), sicmedStandardprescriptionBranch);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedStandardprescriptionBranchList";
    }

    @RequiresPermissions("rest:sicmedStandardprescriptionBranch:view")
    @RequestMapping(value = "form")
    public String form(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch, Model model) {
        model.addAttribute("sicmedStandardprescriptionBranch", sicmedStandardprescriptionBranch);
        return "mobile/rest/sicmedStandardprescriptionBranchForm";
    }

    @RequiresPermissions("rest:sicmedStandardprescriptionBranch:edit")
    @RequestMapping(value = "save")
    public String save(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch, Model model,
                       RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedStandardprescriptionBranch)) {
            return form(sicmedStandardprescriptionBranch, model);
        }
        sicmedStandardprescriptionBranchService.save(sicmedStandardprescriptionBranch);
        addMessage(redirectAttributes, "保存保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedStandardprescriptionBranch/?repage";
    }

    @RequiresPermissions("rest:sicmedStandardprescriptionBranch:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch,
                         RedirectAttributes redirectAttributes) {
        sicmedStandardprescriptionBranchService.delete(sicmedStandardprescriptionBranch);
        addMessage(redirectAttributes, "删除保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedStandardprescriptionBranch/?repage";
    }

}