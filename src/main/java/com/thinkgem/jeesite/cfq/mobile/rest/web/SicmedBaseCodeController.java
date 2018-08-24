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
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedBaseCodeBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBaseCode;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedBaseCodeService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedBaseCodeSetBean;

/**
 * 基础编码表Controller
 *
 * @author Max
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedBaseCode")
public class SicmedBaseCodeController extends BaseController {

    @Autowired
    private SicmedBaseCodeService sicmedBaseCodeService;

    /**
     * 添加基础编码
     *
     * @param sicmedBaseCodeBean
     * @return sicmedBaseCodeBean
     */
    @ResponseBody
    @RequestMapping(value = "save")
    public BaseBean save(SicmedBaseCodeBean sicmedBaseCodeBean) {

        SicmedBaseCode sicmedBaseCode = SicmedBaseCodeSetBean.setSBCB(sicmedBaseCodeBean, null);
        try {
            sicmedBaseCodeService.save(sicmedBaseCode);
            sicmedBaseCodeBean.setError("0");
            sicmedBaseCodeBean.setErrorMessage("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            sicmedBaseCodeBean.setError("1");
            sicmedBaseCodeBean.setErrorMessage("添加失败");
        }

        return sicmedBaseCodeBean;
    }

    /**
     * 根据ID获取
     *
     * @param sicmedBaseCodeId
     * @return sicmedBaseCodeBean
     */

    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam(required = false) String sicmedBaseCodeId) {

        SicmedBaseCodeBean sicmedBaseCodeBean = new SicmedBaseCodeBean();
        try {
            SicmedBaseCode sicmedBaseCode = sicmedBaseCodeService.get(sicmedBaseCodeId);
            sicmedBaseCodeBean.setSBC(sicmedBaseCode);
            sicmedBaseCodeBean.setError("0");
            sicmedBaseCodeBean.setErrorMessage("查询成功");
        } catch (Exception e) {
            e.printStackTrace();
            sicmedBaseCodeBean.setError("1");
            sicmedBaseCodeBean.setErrorMessage("查询失败");
        }
        return sicmedBaseCodeBean;
    }

	/*
	 * @ModelAttribute public SicmedBaseCode get(@RequestParam(required = false)
	 * String id) { SicmedBaseCode entity = null; if
	 * (StringUtils.isNotBlank(id)) { entity = sicmedBaseCodeService.get(id); }
	 * if (entity == null) { entity = new SicmedBaseCode(); } return entity; }
	 */
	/*
	 * @RequiresPermissions("rest:sicmedBaseCode:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String list(SicmedBaseCode
	 * sicmedBaseCode, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedBaseCode> page =
	 * sicmedBaseCodeService.findPage(new Page<SicmedBaseCode>(request,
	 * response), sicmedBaseCode); model.addAttribute("page", page); return
	 * "mobile/rest/sicmedBaseCodeList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedBaseCode:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedBaseCode
	 * sicmedBaseCode, Model model) { model.addAttribute("sicmedBaseCode",
	 * sicmedBaseCode); return "mobile/rest/sicmedBaseCodeForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedBaseCode:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedBaseCode
	 * sicmedBaseCode, Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedBaseCode)){ return form(sicmedBaseCode,
	 * model); } sicmedBaseCodeService.save(sicmedBaseCode);
	 * addMessage(redirectAttributes, "保存保存基础编码成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedBaseCode/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedBaseCode:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedBaseCode
	 * sicmedBaseCode, RedirectAttributes redirectAttributes) {
	 * sicmedBaseCodeService.delete(sicmedBaseCode);
	 * addMessage(redirectAttributes, "删除保存基础编码成功成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedBaseCode/?repage"; }
	 */
}