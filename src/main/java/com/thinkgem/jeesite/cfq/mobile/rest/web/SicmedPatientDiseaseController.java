package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientDiseaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedPatientDiseaseBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedPatientDiseaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * 疾病诊断Controller
 *
 * @author Max
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedPatientDisease")
public class SicmedPatientDiseaseController extends BaseController {

    @Autowired
    private SicmedPatientDiseaseService sicmedPatientDiseaseService;

    @Autowired
    private SicmedCaseService sicmedCaseService;

    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;

    /**
     * 添加初步诊断
     *
     * @param caseId
     * @param diseaseId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(String caseId, String diseaseId) {
        // 创建返回对象
        SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
        // 输入参数验证
        if (AppParameterSimulation.isEmpty(diseaseId) || AppParameterSimulation.isEmpty(caseId)) {
            sicmedPatientDiseaseBean.setError("1");
            sicmedPatientDiseaseBean.setErrorMessage("请求参数为空");
            return sicmedPatientDiseaseBean;
        } else if (!AppParameterSimulation.simulationId(diseaseId) || !AppParameterSimulation.simulationId(caseId)) {
            sicmedPatientDiseaseBean.setError("1");
            sicmedPatientDiseaseBean.setErrorMessage("Id格式不正确");
            return sicmedPatientDiseaseBean;
        }

        // 创建添加对象
        SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
        // 添加对象赋值
        sicmedPatientDisease.setDiseaseCode(sicmedDiseaseService.get(diseaseId));
        sicmedPatientDisease.setCaseCode(sicmedCaseService.get(caseId));
        //判断诊断疾病是否重复添加
        if (sicmedPatientDiseaseService.getOnly(sicmedPatientDisease) != null) {
            sicmedPatientDiseaseBean.setError("1");
            sicmedPatientDiseaseBean.setErrorMessage("该疾病在病历中已存在不可以重复添加!");
            return sicmedPatientDiseaseBean;
        }
        // 执行添加
        sicmedPatientDiseaseService.save(sicmedPatientDisease);

        sicmedPatientDiseaseBean.setError("0");
        sicmedPatientDiseaseBean.setErrorMessage("添加诊断成功");
        return sicmedPatientDiseaseBean;

    }


    /**
     * 根据病历ID查询初步诊断
     *
     * @param caseId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "get")
    public BaseBean get(String caseId) {
        // 创建返回参数
        SicmedPatientDiseaseBeans sicmedPatientDiseaseBeans = new SicmedPatientDiseaseBeans();
        // 传入参数校验
        if (AppParameterSimulation.isEmpty(caseId)) {
            sicmedPatientDiseaseBeans.setError("1");
            sicmedPatientDiseaseBeans.setErrorMessage("参数为空");
            return sicmedPatientDiseaseBeans;
        } else if (!AppParameterSimulation.simulationId(caseId)) {
            sicmedPatientDiseaseBeans.setError("1");
            sicmedPatientDiseaseBeans.setErrorMessage("ID格式不正确");
            return sicmedPatientDiseaseBeans;
        }
        // 创建查询条件
        SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
        // 查询条件赋值
        sicmedPatientDisease.setCaseCode(sicmedCaseService.get(caseId));
        // 查询数据
        List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService.findList(sicmedPatientDisease);
        // 返回值校验
        if (sicmedPatientDiseases.size() > 0) {
            // 返回值处理
            for (SicmedPatientDisease sicmedPatientDisease2 : sicmedPatientDiseases) {
                SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
                sicmedPatientDiseaseBean.setspd(sicmedPatientDisease2);
                sicmedPatientDiseaseBean.setDiseaseName(
                        sicmedDiseaseService.get(sicmedPatientDisease2.getDiseaseCode().getId()).getDiseaseName());
                sicmedPatientDiseaseBeans.getSicmedPatientDiseaseBeans().add(sicmedPatientDiseaseBean);
            }
            sicmedPatientDiseaseBeans.setError("0");
            sicmedPatientDiseaseBeans.setErrorMessage("查询诊断成功");
        } else {
            sicmedPatientDiseaseBeans.setError("1");
            sicmedPatientDiseaseBeans.setErrorMessage("初步诊断为空");
            return sicmedPatientDiseaseBeans;
        }
        return sicmedPatientDiseaseBeans;
    }

    @ResponseBody
    @RequestMapping(value = "delete")
    public BaseBean delete(String id) {
        // 创建返回对象
        SicmedPatientDiseaseBean sicmedPatientDiseaseBean = new SicmedPatientDiseaseBean();
        //传入参数校验
        if (AppParameterSimulation.isEmpty(id)) {
            sicmedPatientDiseaseBean.setError("1");
            sicmedPatientDiseaseBean.setErrorMessage("请求参数为空");
            return sicmedPatientDiseaseBean;
        } else if (!AppParameterSimulation.simulationId(id)) {
            sicmedPatientDiseaseBean.setError("1");
            sicmedPatientDiseaseBean.setErrorMessage("id格式不正确");
            return sicmedPatientDiseaseBean;
        }
        //创建删除对象
        SicmedPatientDisease sicmedPatientDisease = new SicmedPatientDisease();
        sicmedPatientDisease.setId(id);

        sicmedPatientDiseaseService.delete(sicmedPatientDisease);

        sicmedPatientDiseaseBean.setError("0");
        sicmedPatientDiseaseBean.setErrorMessage("删除诊断成功");

        return sicmedPatientDiseaseBean;
    }

	/*
     * @ModelAttribute public SicmedPatientDisease
	 * get(@RequestParam(required=false) String id) { SicmedPatientDisease
	 * entity = null; if (StringUtils.isNotBlank(id)){ entity =
	 * sicmedPatientDiseaseService.get(id); } if (entity == null){ entity = new
	 * SicmedPatientDisease(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatientDisease:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String
	 * list(SicmedPatientDisease sicmedPatientDisease, HttpServletRequest
	 * request, HttpServletResponse response, Model model) {
	 * Page<SicmedPatientDisease> page =
	 * sicmedPatientDiseaseService.findPage(new
	 * Page<SicmedPatientDisease>(request, response), sicmedPatientDisease);
	 * model.addAttribute("page", page); return
	 * "mobile/rest/sicmedPatientDiseaseList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatientDisease:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedPatientDisease
	 * sicmedPatientDisease, Model model) {
	 * model.addAttribute("sicmedPatientDisease", sicmedPatientDisease); return
	 * "mobile/rest/sicmedPatientDiseaseForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatientDisease:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedPatientDisease
	 * sicmedPatientDisease, Model model, RedirectAttributes redirectAttributes)
	 * { if (!beanValidator(model, sicmedPatientDisease)){ return
	 * form(sicmedPatientDisease, model); }
	 * sicmedPatientDiseaseService.save(sicmedPatientDisease);
	 * addMessage(redirectAttributes, "保存保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedPatientDisease/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedPatientDisease:edit")
	 * 
	 * @RequestMapping(value = "delete") public String
	 * delete(SicmedPatientDisease sicmedPatientDisease, RedirectAttributes
	 * redirectAttributes) {
	 * sicmedPatientDiseaseService.delete(sicmedPatientDisease);
	 * addMessage(redirectAttributes, "删除保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedPatientDisease/?repage"; }
	 */
}