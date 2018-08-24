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


import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientAskedBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBranchService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;

/**
 * 患者医嘱表Controller
 *
 * @author XUE
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedPatientAsked")
public class SicmedPatientAskedController extends BaseController {

    @Autowired
    private SicmedPatientAskedService sicmedPatientAskedService;
    @Autowired
    private SicmedPatientService sicmedPatientService;
    @Autowired
    private SicmedAskedService sicmedAskedService;
    @Autowired
    private SicmedBranchService sicmedBranchService;
    @Autowired
    private SicmedUserService sicmedUserService;
    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;

    @ModelAttribute
    public SicmedPatientAsked get(@RequestParam(required = false) String id) {
        SicmedPatientAsked entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedPatientAskedService.get(id);
        }
        if (entity == null) {
            entity = new SicmedPatientAsked();
        }
        return entity;
    }

    /**
     * 暂时不用
     * 患者医嘱查询接口
     * URL:localhost:8080/jeesite/a/rest/sicmedPatientAsked/findPatientAsked
     * 参数1:patientId= (1) 参数2:askedClass= (检查)
     * <p>
     * 返回:患者医嘱的所有信息
     *
     * @param sicmedPatientAsked
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findPatientAsked")
    public SicmedPatientAskedBeans findPatientAsked(String patientId, String askedClass, HttpServletResponse response) {
        SicmedPatientAskedBeans sicmedab = new SicmedPatientAskedBeans();
        if (patientId != "" && askedClass != null) {
            try {
                SicmedPatient sicmedPatient = sicmedPatientService.get(patientId);
                SicmedAskedClass sicmedAsked = sicmedAskedClassService.getAskedByAskedClass(askedClass);
                SicmedPatientAsked sicmedPatientAsked = new SicmedPatientAsked();

                sicmedPatientAsked.setAskedClass(sicmedAsked);
                sicmedPatientAsked.setSicmedPatient(sicmedPatient);

                List<SicmedPatientAsked> sicmedPatientAskeds = sicmedPatientAskedService.findList(sicmedPatientAsked);

                if (sicmedPatientAskeds.size() != 0) {
                    for (SicmedPatientAsked sicmedPatientAsked2 : sicmedPatientAskeds) {
                        SicmedPatientAskedBean sicmedPatientAskedBean = new SicmedPatientAskedBean();
                        sicmedab.getSicmedPatientAskedBeans().add(sicmedPatientAskedBean);
                        sicmedPatientAsked2.setAskedClass(sicmedAsked);
                        sicmedPatientAsked2.setSicmedPatient(sicmedPatient);
                        sicmedPatientAsked2.setSicmedBranch(
                                sicmedBranchService.get(sicmedPatientAsked2.getSicmedBranch().getId()));
                        sicmedPatientAsked2
                                .setSicmedAsked(sicmedAskedService.get(sicmedPatientAsked2.getSicmedAsked().getId()));
                        sicmedPatientAsked2
                                .setSicmedUser(sicmedUserService.get(sicmedPatientAsked2.getSicmedUser().getId()));
                        sicmedPatientAskedBean.setpm(sicmedPatientAsked2);
                    }
                    sicmedab.setError("0");
                    sicmedab.setErrorMessage("查询成功");
                } else {
                    sicmedab.setError("0");
                    sicmedab.setErrorMessage("查询失败,没有找到患者医嘱");
                }

            } catch (Exception e) {
                e.printStackTrace();
                sicmedab.setError("1");
                sicmedab.setErrorMessage("查询失败!内部异常" + e.getMessage());
            }
        } else {
            sicmedab.setError("1");
            sicmedab.setErrorMessage("输入的内容有误");
        }
        return sicmedab;
    }

    @RequiresPermissions("rest:sicmedPatientAsked:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedPatientAsked sicmedPatientAsked, HttpServletRequest request, HttpServletResponse response,
                       Model model) {
        Page<SicmedPatientAsked> page = sicmedPatientAskedService
                .findPage(new Page<SicmedPatientAsked>(request, response), sicmedPatientAsked);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedPatientAskedList";
    }

    @RequiresPermissions("rest:sicmedPatientAsked:view")
    @RequestMapping(value = "form")
    public String form(SicmedPatientAsked sicmedPatientAsked, Model model) {
        model.addAttribute("sicmedPatientAsked", sicmedPatientAsked);
        return "mobile/rest/sicmedPatientAskedForm";
    }

    @RequiresPermissions("rest:sicmedPatientAsked:edit")
    @RequestMapping(value = "save")
    public String save(SicmedPatientAsked sicmedPatientAsked, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedPatientAsked)) {
            return form(sicmedPatientAsked, model);
        }
        sicmedPatientAskedService.save(sicmedPatientAsked);
        addMessage(redirectAttributes, "保存患者医嘱表保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedPatientAsked/?repage";
    }

    @RequiresPermissions("rest:sicmedPatientAsked:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedPatientAsked sicmedPatientAsked, RedirectAttributes redirectAttributes) {
        sicmedPatientAskedService.delete(sicmedPatientAsked);
        addMessage(redirectAttributes, "删除患者医嘱表保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedPatientAsked/?repage";
    }

}