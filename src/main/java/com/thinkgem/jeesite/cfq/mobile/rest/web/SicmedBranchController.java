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
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedBranchBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedBranchBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBranchService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedBranchSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * 科室信息表Controller
 *
 * @author Max
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedBranch")
public class SicmedBranchController extends BaseController {

    @Autowired
    private SicmedBranchService sicmedBranchService;

    /**
     * 添加科室
     *
     * @param sicmedBranchBean
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedBranchBean sicmedBranchBean) {

        if (!AppParameterSimulation.BranchCode(sicmedBranchBean.getBranchCode())
                || !AppParameterSimulation.BranchName(sicmedBranchBean.getBranchName())
                || !AppParameterSimulation.BranchEnglist(sicmedBranchBean.getBranchNameEnglish())
                || !AppParameterSimulation.Location(sicmedBranchBean.getBranchLocation())
                //判断长度为一,是数字,不能为空
                || !AppParameterSimulation.AskedClassId(sicmedBranchBean.getBranchRegistered())
                || !AppParameterSimulation.Number(sicmedBranchBean.getBranchRegisteredAm())
                || !AppParameterSimulation.Number(sicmedBranchBean.getBranchRegisteredPm())) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedBranch sicmedBranch = SicmedBranchSetBean.setSBB(sicmedBranchBean, null);
        try {
            sicmedBranchService.save(sicmedBranch);
            sicmedBranchBean.setError("0");
            sicmedBranchBean.setErrorMessage("添加科室成功!");
        } catch (Exception e) {
            e.printStackTrace();
            sicmedBranchBean.setError("1");
            sicmedBranchBean.setErrorMessage("添加科室失败!");
        }
        return sicmedBranchBean;

    }

    /**
     * 根据ID查询科室信息
     *
     * @param branchId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam String branchId) {

        if (!AppParameterSimulation.simulationId(branchId)) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
        }

        SicmedBranchBean sicmedBranchBean = new SicmedBranchBean();
        try {
            SicmedBranch sicmedBranch = sicmedBranchService.get(branchId);
            sicmedBranchBean.setSB(sicmedBranch);
            sicmedBranchBean.setError("0");
            sicmedBranchBean.setErrorMessage("查询成功!返回科室信息");
        } catch (Exception e) {
            e.printStackTrace();
            sicmedBranchBean.setError("1");
            sicmedBranchBean.setErrorMessage("查询科室失败!");
        }
        return sicmedBranchBean;

    }

    /**
     * 获取所有可挂号科室信息
     *
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "findAllRegisteredBranch")
    public BaseBean findAllRegisteredBranch() {
        SicmedBranchBeans sicmedBranchBeans = new SicmedBranchBeans();

        SicmedBranch sicmedBranch = new SicmedBranch();

        sicmedBranch.setBranchRegistered("1");
        try {
            List<SicmedBranch> sicmedBranchs = sicmedBranchService.findList(sicmedBranch);
            if (sicmedBranchs.size() != 0) {
                for (SicmedBranch sicmedBranch2 : sicmedBranchs) {
                    SicmedBranchBean sicmedBranchBean = new SicmedBranchBean();
                    sicmedBranchBean.setSB(sicmedBranch2);
                    sicmedBranchBeans.getSicmedBranchBeans().add(sicmedBranchBean);
                }
                sicmedBranchBeans.setError("0");
                sicmedBranchBeans.setErrorMessage("查询成功!返回科室信息");
            } else {
                sicmedBranchBeans.setError("1");
                sicmedBranchBeans.setErrorMessage("查询失败!科室信息不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            sicmedBranchBeans.setError("1");
            sicmedBranchBeans.setErrorMessage("查询科室失败!");
        }
        return sicmedBranchBeans;

    }

	/*
     * 获取
	 */
	/*
	 * @RequiresPermissions("rest:sicmedBranch:view")
	 * 
	 * @RequestMapping(value = { "list", "" }) public String list(SicmedBranch
	 * sicmedBranch, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedBranch> page = sicmedBranchService.findPage(new
	 * Page<SicmedBranch>(request, response), sicmedBranch);
	 * model.addAttribute("page", page); return "mobile/rest/sicmedBranchList";
	 * }
	 * 
	 * @RequiresPermissions("rest:sicmedBranch:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedBranch
	 * sicmedBranch, Model model) { model.addAttribute("sicmedBranch",
	 * sicmedBranch); return "mobile/rest/sicmedBranchForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedBranch:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedBranch
	 * sicmedBranch, Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedBranch)) { return form(sicmedBranch, model);
	 * } sicmedBranchService.save(sicmedBranch); addMessage(redirectAttributes,
	 * "保存保存科室成功成功"); return "redirect:" + Global.getAdminPath() +
	 * "/rest/sicmedBranch/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedBranch:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedBranch
	 * sicmedBranch, RedirectAttributes redirectAttributes) {
	 * sicmedBranchService.delete(sicmedBranch); addMessage(redirectAttributes,
	 * "删除保存科室成功成功"); return "redirect:" + Global.getAdminPath() +
	 * "/rest/sicmedBranch/?repage"; }
	 */

}