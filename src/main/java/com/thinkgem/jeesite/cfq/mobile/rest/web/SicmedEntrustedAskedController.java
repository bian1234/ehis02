/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.web;

import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedEntrustedAskedBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedEntrustedAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCaseService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedEntrustedAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedAskedSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedEntrustedAskedSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * 嘱托医嘱Controller
 *
 * @author yjx
 * @version 2016-07-28
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedEntrustedAsked")
public class SicmedEntrustedAskedController extends BaseController {

    @Autowired
    private SicmedEntrustedAskedService sicmedEntrustedAskedService;
    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;
    @Autowired
    private SicmedCaseService sicmedCaseService;
    @Autowired
    private SicmedAskedService sicmedAskedService;

    @ModelAttribute
    public SicmedEntrustedAsked get(@RequestParam(required = false) String id) {
        SicmedEntrustedAsked entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedEntrustedAskedService.get(id);
        }
        if (entity == null) {
            entity = new SicmedEntrustedAsked();
        }
        return entity;
    }

    /**
     * 添加嘱托医嘱
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedEntrustedAskedBean sicmedEntrustedAskedBean, String askedClassId, String caseId) {

        if (!AppParameterSimulation.simulationId(caseId)
                || !AppParameterSimulation.simulationId(askedClassId)
                || !AppParameterSimulation.entrustedAsked(sicmedEntrustedAskedBean.getEntrustedAsked())) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }
        SicmedEntrustedAsked sicmedEntrustedAsked = SicmedEntrustedAskedSetBean.setSEA(sicmedEntrustedAskedBean, null);
        try {

            sicmedEntrustedAskedService.save(sicmedEntrustedAsked);
            SicmedAskedBean sicmedAskedBean = new SicmedAskedBean();
            SicmedAsked sicmedAsked = SicmedAskedSetBean.setAsked(sicmedAskedBean, null);
            // 获取医嘱类别
            SicmedAskedClass sicmedAskedClass = sicmedAskedClassService.get(askedClassId);
            // 添加医嘱类别
            sicmedAsked.setSicmedAskedClass(sicmedAskedClass);

            // 获取病历信息
            SicmedCase sicmedCase = sicmedCaseService.get(caseId);
            // 添加医嘱所属病历
            sicmedAsked.setSicmedCase(sicmedCase);
            sicmedAsked.setOrderCode(sicmedEntrustedAsked.getId());
            sicmedAskedService.save(sicmedAsked);
            sicmedEntrustedAskedBean.setError("0");
            sicmedEntrustedAskedBean.setErrorMessage("添加嘱托医嘱成功");
        } catch (Exception e) {
            sicmedEntrustedAskedBean.setError("1");
            sicmedEntrustedAskedBean.setErrorMessage("添加嘱托医嘱失败");
        }
        return sicmedEntrustedAskedBean;
    }

    /**
     * 删除嘱托医嘱
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public BaseBean delete(String id) {

        if (!AppParameterSimulation.simulationId(id)) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedEntrustedAskedBean sicmedEntrustedAsked = new SicmedEntrustedAskedBean();
        try {
            sicmedEntrustedAskedService.delete(sicmedEntrustedAskedService.get(id));

            sicmedEntrustedAsked.setError("0");
            sicmedEntrustedAsked.setErrorMessage("删除嘱托医嘱成功");
        } catch (Exception e) {
            sicmedEntrustedAsked.setError("1");
            sicmedEntrustedAsked.setErrorMessage("删除嘱托医嘱失败");
        }
        return sicmedEntrustedAsked;
    }

    /**
     * 修改医嘱
     */
    @ResponseBody
    @RequestMapping(value = "update")
    public BaseBean update(SicmedEntrustedAskedBean sicmedEab, String id) {

        if (!AppParameterSimulation.simulationId(id)
                || !AppParameterSimulation.entrustedAsked(sicmedEab.getEntrustedAsked())
                ) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedEntrustedAsked sicmedEntrustedAsked = sicmedEntrustedAskedService.get(id);

        sicmedEntrustedAsked = SicmedEntrustedAskedSetBean.setSEA(sicmedEab, sicmedEntrustedAsked);

        sicmedEntrustedAskedService.save(sicmedEntrustedAsked);

        return sicmedEab;
    }

    /**
     * 通过嘱托医嘱id查询嘱托医嘱
     */
    @ResponseBody
    @RequestMapping(value = "find")
    public BaseBean find(String id) {

        if (!AppParameterSimulation.simulationId(id)) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }
        SicmedEntrustedAskedBean sicmedEntrustedAskedBean = new SicmedEntrustedAskedBean();
        try {
            SicmedEntrustedAsked sicmedEntrustedAsked = sicmedEntrustedAskedService.get(id);
            sicmedEntrustedAskedBean.setError("0");
            sicmedEntrustedAskedBean.setErrorMessage("查询嘱托医嘱成功");
            sicmedEntrustedAskedBean.setSeab(sicmedEntrustedAsked);
        } catch (Exception e) {
            sicmedEntrustedAskedBean.setError("1");
            sicmedEntrustedAskedBean.setErrorMessage("查询嘱托医嘱失败");
        }
        return sicmedEntrustedAskedBean;
    }

	/*
     * @RequiresPermissions("rest:sicmedEntrustedAsked:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String
	 * list(SicmedEntrustedAsked sicmedEntrustedAsked, HttpServletRequest
	 * request, HttpServletResponse response, Model model) {
	 * Page<SicmedEntrustedAsked> page =
	 * sicmedEntrustedAskedService.findPage(new
	 * Page<SicmedEntrustedAsked>(request, response), sicmedEntrustedAsked);
	 * model.addAttribute("page", page); return
	 * "mobile/rest/sicmedEntrustedAskedList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedEntrustedAsked:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedEntrustedAsked
	 * sicmedEntrustedAsked, Model model) {
	 * model.addAttribute("sicmedEntrustedAsked", sicmedEntrustedAsked); return
	 * "mobile/rest/sicmedEntrustedAskedForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedEntrustedAsked:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedEntrustedAsked
	 * sicmedEntrustedAsked, Model model, RedirectAttributes redirectAttributes)
	 * { if (!beanValidator(model, sicmedEntrustedAsked)){ return
	 * form(sicmedEntrustedAsked, model); }
	 * sicmedEntrustedAskedService.save(sicmedEntrustedAsked);
	 * addMessage(redirectAttributes, "保存单表成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedEntrustedAsked/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedEntrustedAsked:edit")
	 * 
	 * @RequestMapping(value = "delete") public String
	 * delete(SicmedEntrustedAsked sicmedEntrustedAsked, RedirectAttributes
	 * redirectAttributes) {
	 * sicmedEntrustedAskedService.delete(sicmedEntrustedAsked);
	 * addMessage(redirectAttributes, "删除单表成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedEntrustedAsked/?repage"; }
	 */

}