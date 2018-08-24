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
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseBranchBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseBranchBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBranchService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseBranchService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDiseaseService;

/**
 * 科室常用疾病表Controller
 *
 * @author Max
 * @version 2016-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedDiseaseBranch")
public class SicmedDiseaseBranchController extends BaseController {

    @Autowired
    private SicmedDiseaseBranchService sicmedDiseaseBranchService;

    @Autowired
    private SicmedBranchService sicmedBranchService;

    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;

    /**
     * 添加科室常用疾病
     *
     * @param diseaseId
     * @param branchId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(@RequestParam(required = false) String diseaseId,
                        @RequestParam(required = false) String branchId) {

        SicmedDiseaseBranchBean sicmedDiseaseBranchBean = new SicmedDiseaseBranchBean();

        SicmedDiseaseBranch sicmedDiseaseBranch = new SicmedDiseaseBranch();

        try {
            SicmedBranch sicmedBranch = sicmedBranchService.get(branchId);

            SicmedDisease sicmedDisease = sicmedDiseaseService.get(diseaseId);

            sicmedDiseaseBranch.setSicmedBranch(sicmedBranch);
            sicmedDiseaseBranch.setSicmedDisease(sicmedDisease);

            sicmedDiseaseBranch.setSicmedDiseaseClass(sicmedDisease.getDiseaseClass());

            sicmedDiseaseBranchService.save(sicmedDiseaseBranch);
//
            sicmedDiseaseBranchBean.setError("0");
            sicmedDiseaseBranchBean.setErrorMessage("添加科室常用疾病成功");

        } catch (Exception e) {
            e.printStackTrace();
            sicmedDiseaseBranchBean.setError("1");
            sicmedDiseaseBranchBean.setErrorMessage("添加科室常用疾病失败");
        }

        // sicmedDiseaseBranch.setCreateBy(sicmedDiseaseBranchBean.get);
        // sicmedDiseaseBranch.setCreateDate(sicmedDiseaseBranchBean.get);
        // sicmedDiseaseBranch.setCurrentUser(sicmedDiseaseBranchBean.get);
        // sicmedDiseaseBranch.setDelFlag(sicmedDiseaseBranchBean.get);
        // sicmedDiseaseBranch.setId(sicmedDiseaseBranchBean.get);
        // sicmedDiseaseBranch.setIsNewRecord(sicmedDiseaseBranchBean.get);
        // sicmedDiseaseBranch.setPage(sicmedDiseaseBranchBean.get)
        // sicmedDiseaseBranch.setRemarks(sicmedDiseaseBranchBean.get);
        // sicmedDiseaseBranch.setSicmedBranch(sicmedDiseaseBranchBean.getSicmedBranchBean());
        // sicmedDiseaseBranch.setSicmedDisease(sicmedDiseaseBranchBean.getSicmedDiseaseBean());
        // sicmedDiseaseBranch.setSicmedDiseaseClass(sicmedDiseaseBranchBean.getSicmedDiseaseClassBean());
        // sicmedDiseaseBranch.setSqlMap(sicmedDiseaseBranchBean.get);
        // sicmedDiseaseBranch.setUpdateBy(sicmedDiseaseBranchBean.get);
        // sicmedDiseaseBranch.setUpdateDate(sicmedDiseaseBranchBean.get);

        return sicmedDiseaseBranchBean;

    }

    /**
     * 根据ID查询科室常用疾病
     *
     * @param diseaseBranchId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam(required = false) String diseaseBranchId) {

        SicmedDiseaseBranchBean sicmedDiseaseBranchBean = new SicmedDiseaseBranchBean();

        try {
            SicmedDiseaseBranch sicmedDiseaseBranch = sicmedDiseaseBranchService.get(diseaseBranchId);

            sicmedDiseaseBranchBean.setDB(sicmedDiseaseBranch);
            sicmedDiseaseBranchBean.setError("0");
            sicmedDiseaseBranchBean.setErrorMessage("查询科室常用疾病成功");

        } catch (Exception e) {
            e.printStackTrace();
            sicmedDiseaseBranchBean.setError("1");
            sicmedDiseaseBranchBean.setErrorMessage("查询科室常用疾病失败");
        }

        return sicmedDiseaseBranchBean;

    }

    /**
     * 根据科室查询科室常用疾病
     *
     * @param branchId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "findByBranch")
    public BaseBean findByBranch(@RequestParam(required = false) String branchId) {

        SicmedDiseaseBranchBeans sicmedDiseaseBranchBeans = new SicmedDiseaseBranchBeans();

        SicmedDiseaseBranch sicmedDiseaseBranch = new SicmedDiseaseBranch();

        try {
            SicmedBranch sicmedBranch = sicmedBranchService.get(branchId);
            sicmedDiseaseBranch.setSicmedBranch(sicmedBranch);

            List<SicmedDiseaseBranch> sicmedDiseaseBranches = sicmedDiseaseBranchService.findList(sicmedDiseaseBranch);

            if (sicmedDiseaseBranches.size() != 0) {
                for (SicmedDiseaseBranch sicmedDiseaseBranch2 : sicmedDiseaseBranches) {
                    SicmedDiseaseBranchBean sicmedDiseaseBranchBean = new SicmedDiseaseBranchBean();
                    sicmedDiseaseBranchBean.setDB(sicmedDiseaseBranch2);
                    sicmedDiseaseBranchBeans.getSicmedDiseaseBranchBeans().add(sicmedDiseaseBranchBean);
                    sicmedDiseaseBranchBeans.setError("0");
                    sicmedDiseaseBranchBeans.setErrorMessage("查询科室常用疾病成功");
                }

            } else {
                sicmedDiseaseBranchBeans.setError("0");
                sicmedDiseaseBranchBeans.setErrorMessage("查询科室常用疾病为空");

            }

        } catch (Exception e) {
            e.printStackTrace();
            sicmedDiseaseBranchBeans.setError("1");
            sicmedDiseaseBranchBeans.setErrorMessage("添加科室常用疾病失败");
        }
        return sicmedDiseaseBranchBeans;

    }
    /*
	 * @ModelAttribute public SicmedDiseaseBranch
	 * get(@RequestParam(required=false) String id) { SicmedDiseaseBranch entity
	 * = null; if (StringUtils.isNotBlank(id)){ entity =
	 * sicmedDiseaseBranchService.get(id); } if (entity == null){ entity = new
	 * SicmedDiseaseBranch(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseBranch:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String
	 * list(SicmedDiseaseBranch sicmedDiseaseBranch, HttpServletRequest request,
	 * HttpServletResponse response, Model model) { Page<SicmedDiseaseBranch>
	 * page = sicmedDiseaseBranchService.findPage(new
	 * Page<SicmedDiseaseBranch>(request, response), sicmedDiseaseBranch);
	 * model.addAttribute("page", page); return
	 * "mobile/rest/sicmedDiseaseBranchList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseBranch:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedDiseaseBranch
	 * sicmedDiseaseBranch, Model model) {
	 * model.addAttribute("sicmedDiseaseBranch", sicmedDiseaseBranch); return
	 * "mobile/rest/sicmedDiseaseBranchForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseBranch:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedDiseaseBranch
	 * sicmedDiseaseBranch, Model model, RedirectAttributes redirectAttributes)
	 * { if (!beanValidator(model, sicmedDiseaseBranch)){ return
	 * form(sicmedDiseaseBranch, model); }
	 * sicmedDiseaseBranchService.save(sicmedDiseaseBranch);
	 * addMessage(redirectAttributes, "保存保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDiseaseBranch/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDiseaseBranch:edit")
	 * 
	 * @RequestMapping(value = "delete") public String
	 * delete(SicmedDiseaseBranch sicmedDiseaseBranch, RedirectAttributes
	 * redirectAttributes) {
	 * sicmedDiseaseBranchService.delete(sicmedDiseaseBranch);
	 * addMessage(redirectAttributes, "删除保存成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDiseaseBranch/?repage"; }
	 */

}