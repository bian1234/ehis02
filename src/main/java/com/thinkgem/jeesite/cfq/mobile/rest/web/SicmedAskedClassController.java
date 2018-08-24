/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedAskedClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedClassService;
import com.thinkgem.jeesite.cfq.mobile.rest.setBean.SicmedAskedClassSetBean;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * 医嘱分类编码Controller
 *
 * @author Max
 * @version 2016-07-24
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedAskedClass")
public class SicmedAskedClassController extends BaseController {

    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;

    /**
     * 添加医嘱类别
     *
     * @param sicmedAskedClassBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "add")
    public BaseBean add(SicmedAskedClassBean sicmedAskedClassBean) {
        //判断医嘱类别编号是否为空或者是否为1位
        if (!AppParameterSimulation.AskedClassId(sicmedAskedClassBean.getClassNumber())) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedAskedClass sicmedAskedClass = SicmedAskedClassSetBean.setSAC(sicmedAskedClassBean, null);

        sicmedAskedClassService.save(sicmedAskedClass);

        return sicmedAskedClassBean;

    }

    /**
     * 刪除医嘱类别
     *
     * @param askedClassid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete")
    public BaseBean delete(@RequestParam(required = false) String askedClassid) {
        //判断医嘱类别ID是否为32位
        if (!AppParameterSimulation.simulationId(askedClassid)) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();

        sicmedAskedClassService.delete(sicmedAskedClassService.get(askedClassid));

        return sicmedAskedClassBean;

    }

    /**
     * 修改医嘱类别
     *
     * @param sicmedAskedClassBean
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "update")
    public BaseBean update(SicmedAskedClassBean sicmedAskedClassBean) {
        //判断医嘱id是否为32位,医嘱类编编号是否小于4为
        if (!AppParameterSimulation.simulationId(sicmedAskedClassBean.getId())
                || !AppParameterSimulation.AskedClassId(sicmedAskedClassBean.getClassNumber())
                ) {
            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedAskedClass sicmedAskedClass = sicmedAskedClassService.get(sicmedAskedClassBean.getId());

        sicmedAskedClass = SicmedAskedClassSetBean.setSAC(sicmedAskedClassBean, sicmedAskedClass);

        sicmedAskedClassService.update(sicmedAskedClass);

        return sicmedAskedClassBean;

    }

    /**
     * 根据Id查询医嘱类别
     *
     * @param askedClassid
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getById")
    public BaseBean getById(@RequestParam(required = false) String askedClassid) {

        //判断医嘱类别ID是否为32位
        if (!AppParameterSimulation.simulationId(askedClassid)) {

            BaseBean baseBean = new BaseBean();
            baseBean.failureWithParameter();
            return baseBean;
        }

        SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();

        SicmedAskedClass sicmedAskedClass = sicmedAskedClassService.get(askedClassid);

        sicmedAskedClassBean.setSac(sicmedAskedClass);

        return sicmedAskedClassBean;

    }

    /**
     * 查询所有医嘱类别
     *
     * @param null
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findAllList")
    public BaseBean findAllList() {
        SicmedAskedClassBeans sicmedAskedClassBeans = new SicmedAskedClassBeans();
        SicmedAskedClass sicmedAskedClass = new SicmedAskedClass();

        List<SicmedAskedClass> sicmedAskedClasses = sicmedAskedClassService.findList(sicmedAskedClass);
        if (sicmedAskedClasses.size() > 0) {
            for (SicmedAskedClass sicmedAskedClass2 : sicmedAskedClasses) {
                SicmedAskedClassBean sicmedAskedClassBean = new SicmedAskedClassBean();
                sicmedAskedClassBean.setSac(sicmedAskedClass2);
                sicmedAskedClassBeans.getSicmedAskedClassBeans().add(sicmedAskedClassBean);
            }
        }
        return sicmedAskedClassBeans;

    }

	/*
     * @ModelAttribute public SicmedAskedClass get(@RequestParam(required =
	 * false) String id) { SicmedAskedClass entity = null; if
	 * (StringUtils.isNotBlank(id)) { entity = sicmedAskedClassService.get(id);
	 * } if (entity == null) { entity = new SicmedAskedClass(); } return entity;
	 * }
	 * 
	 * @RequiresPermissions("rest:sicmedAskedClass:view")
	 * 
	 * @RequestMapping(value = { "list", "" }) public String
	 * list(SicmedAskedClass sicmedAskedClass, HttpServletRequest request,
	 * HttpServletResponse response, Model model) { Page<SicmedAskedClass> page
	 * = sicmedAskedClassService.findPage(new Page<SicmedAskedClass>(request,
	 * response), sicmedAskedClass); model.addAttribute("page", page); return
	 * "mobile/rest/sicmedAskedClassList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedAskedClass:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedAskedClass
	 * sicmedAskedClass, Model model) { model.addAttribute("sicmedAskedClass",
	 * sicmedAskedClass); return "mobile/rest/sicmedAskedClassForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedAskedClass:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedAskedClass
	 * sicmedAskedClass, Model model, RedirectAttributes redirectAttributes) {
	 * if (!beanValidator(model, sicmedAskedClass)) { return
	 * form(sicmedAskedClass, model); }
	 * sicmedAskedClassService.save(sicmedAskedClass);
	 * addMessage(redirectAttributes, "保存医嘱分类保存成功成功"); return "redirect:" +
	 * Global.getAdminPath() + "/rest/sicmedAskedClass/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedAskedClass:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedAskedClass
	 * sicmedAskedClass, RedirectAttributes redirectAttributes) {
	 * sicmedAskedClassService.delete(sicmedAskedClass);
	 * addMessage(redirectAttributes, "删除医嘱分类保存成功成功"); return "redirect:" +
	 * Global.getAdminPath() + "/rest/sicmedAskedClass/?repage"; }
	 */

}