/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.cfq.common.config.Global;
import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStandardprescriptionDoctorBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedStandardprescriptionDoctorBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStandardprescriptionDoctor;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedStandardprescriptionDoctorService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;

/**
 * 医生常用疾病表Controller
 *
 * @author Max
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedStandardprescriptionDoctor")
public class SicmedStandardprescriptionDoctorController extends BaseController {

    @Autowired
    private SicmedStandardprescriptionDoctorService sicmedStandardprescriptionDoctorService;
    @Autowired
    private SicmedUserService sicmedUserService;
    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;


    /**
     * 此处暂时注释掉注解一个 ===============@ModelAttributem
     */
    //@ModelAttributem
    public SicmedStandardprescriptionDoctor get(@RequestParam(required = false) String id) {
        SicmedStandardprescriptionDoctor entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedStandardprescriptionDoctorService.get(id);
        }
        if (entity == null) {
            entity = new SicmedStandardprescriptionDoctor();
        }
        return entity;
    }

    /**
     * URL: http://localhost:8080/jeesite/a/rest/sicmedStandardprescriptionDoctor/findStandardPrescriptionDoctor
     *
     * @param request String userId   (11)   String askedClass   (检查)
     * @return 医生标准处方
     */
    @ResponseBody
    @RequestMapping(value = "findStandardPrescriptionDoctor")
    public SicmedStandardprescriptionDoctorBeans findStandardPrescriptionDoctor(String userId, String askedClass,
                                                                                HttpServletResponse response) {
        SicmedStandardprescriptionDoctorBeans sicmedStandardprescriptionDoctorBeans = new SicmedStandardprescriptionDoctorBeans();
        try {
            SicmedUser sicmedUser = sicmedUserService.get(userId);
            SicmedAskedClass sicmedAskedClass = sicmedAskedClassService.getAskedByAskedClass(askedClass);

            SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor = new SicmedStandardprescriptionDoctor();

            sicmedStandardprescriptionDoctor.setSicmedUser(sicmedUser);
            sicmedStandardprescriptionDoctor.setAskedClass(sicmedAskedClass);

            List<SicmedStandardprescriptionDoctor> sicmedStandardprescription = sicmedStandardprescriptionDoctorService
                    .findList(sicmedStandardprescriptionDoctor);
            if (sicmedStandardprescription.size() != 0) {
                for (SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctors : sicmedStandardprescription) {

                    SicmedStandardprescriptionDoctorBean sicmedStandardprescriptionDoctorBean = new SicmedStandardprescriptionDoctorBean();
                    //sicmedStandardprescriptionDoctorBeans.getSicmedStandardprescriptionDoctorBeans().add(sicmedStandardprescriptionDoctorBean);
                    sicmedStandardprescriptionDoctors.setSicmedUser(sicmedUser);
                    sicmedStandardprescriptionDoctors.setAskedClass(sicmedAskedClass);
                    //sicmedStandardprescriptionDoctors.setStanderprescriptionDisease(sicmedStanderprescriptionDiseaseService.get(sicmedStandardprescriptionDoctors.getStanderprescriptionDisease().getId()));
                    //sicmedStandardprescriptionDoctors.setStanderprescriptionAsked(sicmedStanderprescriptionAskedService.get(sicmedStandardprescriptionDoctors.getStanderprescriptionAsked().getId()));
                    sicmedStandardprescriptionDoctorBean.setssd(sicmedStandardprescriptionDoctors);
                    sicmedStandardprescriptionDoctorBeans.getSicmedStandardprescriptionDoctorBeans().add(sicmedStandardprescriptionDoctorBean);
                }
                sicmedStandardprescriptionDoctorBeans.setError("0");
                sicmedStandardprescriptionDoctorBeans.setErrorMessage("医生标准处方查看成功");
            } else {
                sicmedStandardprescriptionDoctorBeans.setError("0");
                sicmedStandardprescriptionDoctorBeans.setErrorMessage("查询失败!没有找到医生处方");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sicmedStandardprescriptionDoctorBeans.setError("1");
            sicmedStandardprescriptionDoctorBeans.setErrorMessage("查询失败!系统内部异常" + e.getMessage());
        }
        return sicmedStandardprescriptionDoctorBeans;
    }


    @RequiresPermissions("rest:sicmedStandardprescriptionDoctor:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedStandardprescriptionDoctor> page = sicmedStandardprescriptionDoctorService.findPage(new Page<SicmedStandardprescriptionDoctor>(request, response), sicmedStandardprescriptionDoctor);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedStandardprescriptionDoctorList";
    }

    @RequiresPermissions("rest:sicmedStandardprescriptionDoctor:view")
    @RequestMapping(value = "form")
    public String form(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor, Model model) {
        model.addAttribute("sicmedStandardprescriptionDoctor", sicmedStandardprescriptionDoctor);
        return "mobile/rest/sicmedStandardprescriptionDoctorForm";
    }

    @RequiresPermissions("rest:sicmedStandardprescriptionDoctor:edit")
    @RequestMapping(value = "save")
    public String save(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedStandardprescriptionDoctor)) {
            return form(sicmedStandardprescriptionDoctor, model);
        }
        sicmedStandardprescriptionDoctorService.save(sicmedStandardprescriptionDoctor);
        addMessage(redirectAttributes, "保存保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedStandardprescriptionDoctor/?repage";
    }

    @RequiresPermissions("rest:sicmedStandardprescriptionDoctor:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor, RedirectAttributes redirectAttributes) {
        sicmedStandardprescriptionDoctorService.delete(sicmedStandardprescriptionDoctor);
        addMessage(redirectAttributes, "删除保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedStandardprescriptionDoctor/?repage";
    }

}