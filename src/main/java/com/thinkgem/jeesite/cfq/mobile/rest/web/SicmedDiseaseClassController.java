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
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedDiseaseClassSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * 疾病类别表Controller
 *
 * @author Max
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedDiseaseClass")
public class SicmedDiseaseClassController extends BaseController {

    @Autowired
    private SicmedDiseaseClassService sicmedDiseaseClassService;

    /**
     * 未写参数校验(不确定传来的参数信息为什么)
     * <p>
     * 添加药品类别
     *
     * @param sicmedDiseaseClassBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedDiseaseClassBean sicmedDiseaseClassBean) {

        SicmedDiseaseClass sicmedDiseaseClass = SicmedDiseaseClassSetBean.setSDCB(sicmedDiseaseClassBean);
        try {
            sicmedDiseaseClassService.save(sicmedDiseaseClass);
            sicmedDiseaseClassBean.setError("0");
            sicmedDiseaseClassBean.setErrorMessage("添加药品类别成功");
        } catch (Exception e) {
            e.printStackTrace();
            sicmedDiseaseClassBean.setError("1");
            sicmedDiseaseClassBean.setErrorMessage("添加药品类别失败");
        }
        return sicmedDiseaseClassBean;

    }

    /**
     * 根据药品类别ID查询药品类别
     *
     * @param diseaseClassId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam String diseaseClassId) {

        if (!AppParameterSimulation.simulationId(diseaseClassId)) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedDiseaseClassBean sicmedDiseaseClassBean = new SicmedDiseaseClassBean();

        try {

            SicmedDiseaseClass sicmedDiseaseClass = sicmedDiseaseClassService.get(diseaseClassId);
            sicmedDiseaseClassBean.setDC(sicmedDiseaseClass);
            sicmedDiseaseClassBean.setError("0");
            sicmedDiseaseClassBean.setErrorMessage("查询药品类别成功");

        } catch (Exception e) {

            e.printStackTrace();
            sicmedDiseaseClassBean.setError("1");
            sicmedDiseaseClassBean.setErrorMessage("查询药品类别失败");

        }
        return sicmedDiseaseClassBean;

    }

    /**
     * 查询所有药品类别
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findAll")
    public BaseBean findAll() {
        SicmedDiseaseClassBeans sicmedDiseaseClassBeans = new SicmedDiseaseClassBeans();

        SicmedDiseaseClass sicmedDiseaseClass = new SicmedDiseaseClass();

        List<SicmedDiseaseClass> sicmedDiseaseClasses = sicmedDiseaseClassService.findList(sicmedDiseaseClass);
        for (SicmedDiseaseClass sicmedDiseaseClass2 : sicmedDiseaseClasses) {
            SicmedDiseaseClassBean sicmedDiseaseClassBean = new SicmedDiseaseClassBean();
            sicmedDiseaseClassBean.setDC(sicmedDiseaseClass2);
            sicmedDiseaseClassBeans.getSicmedDiseaseClassBeans().add(sicmedDiseaseClassBean);
        }
        sicmedDiseaseClassBeans.setError("0");
        sicmedDiseaseClassBeans.setErrorMessage("查询疾病类别成功");

        return sicmedDiseaseClassBeans;

    }

	/*
     * @ModelAttribute public SicmedDiseaseClass
	 * get(@RequestParam(required=false) String id) { SicmedDiseaseClass entity
	 * = null; if (StringUtils.isNotBlank(id)){ entity =
	 * sicmedDiseaseClassService.get(id); } if (entity == null){ entity = new
	 * SicmedDiseaseClass(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseClass:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String
	 * list(SicmedDiseaseClass sicmedDiseaseClass, HttpServletRequest request,
	 * HttpServletResponse response, Model model) { Page<SicmedDiseaseClass>
	 * page = sicmedDiseaseClassService.findPage(new
	 * Page<SicmedDiseaseClass>(request, response), sicmedDiseaseClass);
	 * model.addAttribute("page", page); return
	 * "mobile/rest/sicmedDiseaseClassList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseClass:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedDiseaseClass
	 * sicmedDiseaseClass, Model model) {
	 * model.addAttribute("sicmedDiseaseClass", sicmedDiseaseClass); return
	 * "mobile/rest/sicmedDiseaseClassForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseClass:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedDiseaseClass
	 * sicmedDiseaseClass, Model model, RedirectAttributes redirectAttributes) {
	 * if (!beanValidator(model, sicmedDiseaseClass)){ return
	 * form(sicmedDiseaseClass, model); }
	 * sicmedDiseaseClassService.save(sicmedDiseaseClass);
	 * addMessage(redirectAttributes, "保存保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDiseaseClass/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseClass:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedDiseaseClass
	 * sicmedDiseaseClass, RedirectAttributes redirectAttributes) {
	 * sicmedDiseaseClassService.delete(sicmedDiseaseClass);
	 * addMessage(redirectAttributes, "删除保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDiseaseClass/?repage"; }
	 */
}