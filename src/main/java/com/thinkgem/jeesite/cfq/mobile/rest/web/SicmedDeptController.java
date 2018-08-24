/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.web;


import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDeptBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDept;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedDeptService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedDeptSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * 部门信息表Controller
 *
 * @author Max
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedDept")
public class SicmedDeptController extends BaseController {

    @Autowired
    private SicmedDeptService sicmedDeptService;

    /**
     * 添加部门
     *
     * @param sicmedDeptBean
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedDeptBean sicmedDeptBean) {

        if (!AppParameterSimulation.entrustedAsked(sicmedDeptBean.getDeptCode())
                //判断部门名称长度小于30
                || !AppParameterSimulation.BranchName(sicmedDeptBean.getDeptName())
                || !AppParameterSimulation.DeptPmpa(sicmedDeptBean.getDeptPmpa())) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedDept sicmedDept = SicmedDeptSetBean.setSDB(sicmedDeptBean, null);

        try {
            sicmedDeptService.save(sicmedDept);
            sicmedDeptBean.setError("0");
            sicmedDeptBean.setErrorMessage("添加部门成功!");
        } catch (Exception e) {
            e.printStackTrace();
            sicmedDeptBean.setError("1");
            sicmedDeptBean.setErrorMessage("添加部门失败!");
        }
        return sicmedDeptBean;

    }

    /**
     * 根据ID查询部门信息
     *
     * @param deptId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam String deptId) {

        if (!AppParameterSimulation.simulationId(deptId)) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedDeptBean sicmedDeptBean = new SicmedDeptBean();
        try {
            SicmedDept sicmedDept = sicmedDeptService.get(deptId);
            sicmedDeptBean.setSD(sicmedDept);
            sicmedDeptBean.setError("0");
            sicmedDeptBean.setErrorMessage("查询成功!返回部门信息");
        } catch (Exception e) {
            e.printStackTrace();
            sicmedDeptBean.setError("1");
            sicmedDeptBean.setErrorMessage("查询部门失败!");
        }
        return sicmedDeptBean;

    }

    /**
     * 获取所有可挂号科室信息
     *
     * @return
     *//*

	@ResponseBody
	@RequestMapping(value = "findAllDept")
	public BaseBean findAllRegisteredBranch() {
		SicmedBranchBeans sicmedBranchBeans = new SicmedBranchBeans();

		SicmedBranch sicmedBranch = new SicmedBranch();

		sicmedBranch.setBranchRegistered("0");
		try {
			List<SicmedBranch> sicmedBranchs = sicmedBranchService.findList(sicmedBranch);
			if (sicmedBranchs.size() != 0) {
				for (SicmedBranch sicmedBranch2 : sicmedBranchs) {
					SicmedBranchBean sicmedBranchBean = new SicmedBranchBean();
					sicmedBranchBean.setSB(sicmedBranch2);
					sicmedBranchBeans.getSicmedBranchBeans().add(sicmedBranchBean);
				}
				sicmedBranchBeans.setError(0);
				sicmedBranchBeans.setErrorMessage("查询成功!返回科室信息");
			} else {
				sicmedBranchBeans.setError(1);
				sicmedBranchBeans.setErrorMessage("查询失败!科室信息不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			sicmedBranchBeans.setError(1);
			sicmedBranchBeans.setErrorMessage("查询科室失败!");
		}
		return sicmedBranchBeans;

	}*/

	/*
     * @ModelAttribute public SicmedDept get(@RequestParam(required=false)
	 * String id) { SicmedDept entity = null; if (StringUtils.isNotBlank(id)){
	 * entity = sicmedDeptService.get(id); } if (entity == null){ entity = new
	 * SicmedDept(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedDept:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String list(SicmedDept
	 * sicmedDept, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedDept> page = sicmedDeptService.findPage(new
	 * Page<SicmedDept>(request, response), sicmedDept);
	 * model.addAttribute("page", page); return "mobile/rest/sicmedDeptList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDept:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedDept sicmedDept,
	 * Model model) { model.addAttribute("sicmedDept", sicmedDept); return
	 * "mobile/rest/sicmedDeptForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDept:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedDept sicmedDept,
	 * Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedDept)){ return form(sicmedDept, model); }
	 * sicmedDeptService.save(sicmedDept); addMessage(redirectAttributes,
	 * "保存保存部门成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDept/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedDept:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedDept
	 * sicmedDept, RedirectAttributes redirectAttributes) {
	 * sicmedDeptService.delete(sicmedDept); addMessage(redirectAttributes,
	 * "删除保存部门成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedDept/?repage"; }
	 */

}