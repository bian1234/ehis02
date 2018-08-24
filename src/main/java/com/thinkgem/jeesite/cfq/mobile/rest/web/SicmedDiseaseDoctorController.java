/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseDoctorBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseDoctorBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseDoctor;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseDoctorService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedUserService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * 医生常用疾病表Controller
 *
 * @author Max
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedDiseaseDoctor")
public class SicmedDiseaseDoctorController extends BaseController {

    @Autowired
    private SicmedDiseaseDoctorService sicmedDiseaseDoctorService;

    @Autowired
    private SicmedUserService sicmedDoctorService;

    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;

    /**
     * 添加医生个人常用疾病
     *
     * @param diseaseId
     * @param branchId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(@RequestParam(required = false) String diseaseId,
                        @RequestParam(required = false) String doctorId) {

        if (!AppParameterSimulation.simulationId(diseaseId) ||
                !AppParameterSimulation.simulationId(doctorId)
                ) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;

        }

        SicmedDiseaseDoctorBean sicmedDiseaseDoctorBean = new SicmedDiseaseDoctorBean();

        SicmedDiseaseDoctor sicmedDiseaseDoctor = new SicmedDiseaseDoctor();

        try {
            SicmedUser sicmedDoctor = sicmedDoctorService.get(doctorId);

            SicmedDisease sicmedDisease = sicmedDiseaseService.get(diseaseId);

            sicmedDiseaseDoctor.setSicmedDoctor(sicmedDoctor);
            sicmedDiseaseDoctor.setSicmedDisease(sicmedDisease);

            sicmedDiseaseDoctor.setSicmedDiseaseClass(sicmedDisease.getDiseaseClass());

            sicmedDiseaseDoctorService.save(sicmedDiseaseDoctor);

            sicmedDiseaseDoctorBean.setError("0");
            sicmedDiseaseDoctorBean.setErrorMessage("添加医生个人常用疾病成功");

        } catch (Exception e) {
            e.printStackTrace();
            sicmedDiseaseDoctorBean.setError("1");
            sicmedDiseaseDoctorBean.setErrorMessage("添加医生个人常用疾病失败");
        }

        return sicmedDiseaseDoctorBean;

    }

    /**
     * 根据ID查询医生个人常用疾病
     *
     * @param diseaseBranchId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam(required = false) String diseaseDoctorId) {

        if (!AppParameterSimulation.simulationId(diseaseDoctorId)) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;

        }

        SicmedDiseaseDoctorBean sicmedDiseaseDoctorBean = new SicmedDiseaseDoctorBean();

        try {
            SicmedDiseaseDoctor sicmedDiseaseDoctor = sicmedDiseaseDoctorService.get(diseaseDoctorId);

            sicmedDiseaseDoctorBean.setSDD(sicmedDiseaseDoctor);
            sicmedDiseaseDoctorBean.setError("0");
            sicmedDiseaseDoctorBean.setErrorMessage("查询医生个人常用疾病成功");

        } catch (Exception e) {
            e.printStackTrace();
            sicmedDiseaseDoctorBean.setError("1");
            sicmedDiseaseDoctorBean.setErrorMessage("查询医生个人常用疾病失败");
        }

        return sicmedDiseaseDoctorBean;

    }

    /**
     * 根据医生查询医生个人常用疾病
     *
     * @param doctorId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "findByDoctor")
    public BaseBean findByBranch(@RequestParam(required = false) String doctorId) {

        if (!AppParameterSimulation.simulationId(doctorId)) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;

        }

        SicmedDiseaseDoctorBeans sicmedDiseaseDoctorBeans = new SicmedDiseaseDoctorBeans();

        SicmedDiseaseDoctor sicmedDiseaseDoctor = new SicmedDiseaseDoctor();

        try {
            SicmedUser sicmedDoctor = sicmedDoctorService.get(doctorId);
            sicmedDiseaseDoctor.setSicmedDoctor(sicmedDoctor);

            List<SicmedDiseaseDoctor> sicmedDiseaseDoctores = sicmedDiseaseDoctorService.findList(sicmedDiseaseDoctor);

            if (sicmedDiseaseDoctores.size() != 0) {
                for (SicmedDiseaseDoctor sicmedDiseaseDoctor2 : sicmedDiseaseDoctores) {
                    SicmedDiseaseDoctorBean sicmedDiseaseDoctorBean = new SicmedDiseaseDoctorBean();
                    sicmedDiseaseDoctorBean.setSDD(sicmedDiseaseDoctor2);
                    sicmedDiseaseDoctorBeans.getSicmedDiseaseDoctorBeans().add(sicmedDiseaseDoctorBean);
                }
                sicmedDiseaseDoctorBeans.setError("0");
                sicmedDiseaseDoctorBeans.setErrorMessage("查询医生个人常用疾病成功");

            } else {
                sicmedDiseaseDoctorBeans.setError("0");
                sicmedDiseaseDoctorBeans.setErrorMessage("查询医生个人常用疾病为空");
            }

        } catch (Exception e) {
            e.printStackTrace();
            sicmedDiseaseDoctorBeans.setError("1");
            sicmedDiseaseDoctorBeans.setErrorMessage("查询医生个人常用疾病失败");
        }
        return sicmedDiseaseDoctorBeans;

    }

	/*
     * @ModelAttribute public SicmedDiseaseDoctor
	 * get(@RequestParam(required=false) String id) { SicmedDiseaseDoctor entity
	 * = null; if (StringUtils.isNotBlank(id)){ entity =
	 * sicmedDiseaseDoctorService.get(id); } if (entity == null){ entity = new
	 * SicmedDiseaseDoctor(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseDoctor:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String
	 * list(SicmedDiseaseDoctor sicmedDiseaseDoctor, HttpServletRequest request,
	 * HttpServletResponse response, Model model) { Page<SicmedDiseaseDoctor>
	 * page = sicmedDiseaseDoctorService.findPage(new
	 * Page<SicmedDiseaseDoctor>(request, response), sicmedDiseaseDoctor);
	 * model.addAttribute("page", page); return
	 * "mobile/rest/sicmedDiseaseDoctorList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseDoctor:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedDiseaseDoctor
	 * sicmedDiseaseDoctor, Model model) {
	 * model.addAttribute("sicmedDiseaseDoctor", sicmedDiseaseDoctor); return
	 * "mobile/rest/sicmedDiseaseDoctorForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseDoctor:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedDiseaseDoctor
	 * sicmedDiseaseDoctor, Model model, RedirectAttributes redirectAttributes)
	 * { if (!beanValidator(model, sicmedDiseaseDoctor)){ return
	 * form(sicmedDiseaseDoctor, model); }
	 * sicmedDiseaseDoctorService.save(sicmedDiseaseDoctor);
	 * addMessage(redirectAttributes, "保存保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDiseaseDoctor/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseDoctor:edit")
	 * 
	 * @RequestMapping(value = "delete") public String
	 * delete(SicmedDiseaseDoctor sicmedDiseaseDoctor, RedirectAttributes
	 * redirectAttributes) {
	 * sicmedDiseaseDoctorService.delete(sicmedDiseaseDoctor);
	 * addMessage(redirectAttributes, "删除保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDiseaseDoctor/?repage"; }
	 */

}