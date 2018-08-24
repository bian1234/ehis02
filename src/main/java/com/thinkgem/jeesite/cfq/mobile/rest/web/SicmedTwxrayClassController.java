/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedTwxrayClassBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayClass;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedTwxrayClassService;

/**
 * RESTful接口示例Controller
 *
 * @author DING
 * @version 2016-07-22
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedTwxrayClass")
public class SicmedTwxrayClassController extends BaseController {

    @Autowired
    private SicmedTwxrayClassService sicmedTwxrayClassService;

    /**
     * 获取检查类别
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findAll")
    public BaseBean searchAllCheck() {
        SicmedTwxrayClassBeans sicmedTwxrayClassBeans = new SicmedTwxrayClassBeans();
        SicmedTwxrayClass sicmedTwxrayClass = new SicmedTwxrayClass();
        List<SicmedTwxrayClass> sicmedTwxrayClasses = sicmedTwxrayClassService.findList(sicmedTwxrayClass);

        for (SicmedTwxrayClass sicmedTwxrayClass2 : sicmedTwxrayClasses) {
            SicmedTwxrayClassBean sicmedTwxrayClassBean = new SicmedTwxrayClassBean();
            sicmedTwxrayClassBean.setSicmedTwxrayClass(sicmedTwxrayClass2);
            sicmedTwxrayClassBeans.getSicmedTwxrayClassBeans().add(sicmedTwxrayClassBean);
        }
        return sicmedTwxrayClassBeans;
    }

	/*
     * @Autowired private SicmedTwxrayClassService sicmedTwxrayClassService;
	 * 
	 * @ModelAttribute public SicmedTwxrayClass
	 * get(@RequestParam(required=false) String id) { SicmedTwxrayClass entity =
	 * null; if (StringUtils.isNotBlank(id)){ entity =
	 * sicmedTwxrayClassService.get(id); } if (entity == null){ entity = new
	 * SicmedTwxrayClass(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedTwxrayClass:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String
	 * list(SicmedTwxrayClass sicmedTwxrayClass, HttpServletRequest request,
	 * HttpServletResponse response, Model model) { Page<SicmedTwxrayClass> page
	 * = sicmedTwxrayClassService.findPage(new Page<SicmedTwxrayClass>(request,
	 * response), sicmedTwxrayClass); model.addAttribute("page", page); return
	 * "mobile/rest/sicmedTwxrayClassList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedTwxrayClass:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedTwxrayClass
	 * sicmedTwxrayClass, Model model) { model.addAttribute("sicmedTwxrayClass",
	 * sicmedTwxrayClass); return "mobile/rest/sicmedTwxrayClassForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedTwxrayClass:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedTwxrayClass
	 * sicmedTwxrayClass, Model model, RedirectAttributes redirectAttributes) {
	 * if (!beanValidator(model, sicmedTwxrayClass)){ return
	 * form(sicmedTwxrayClass, model); }
	 * sicmedTwxrayClassService.save(sicmedTwxrayClass);
	 * addMessage(redirectAttributes, "保存单表成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedTwxrayClass/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedTwxrayClass:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedTwxrayClass
	 * sicmedTwxrayClass, RedirectAttributes redirectAttributes) {
	 * sicmedTwxrayClassService.delete(sicmedTwxrayClass);
	 * addMessage(redirectAttributes, "删除单表成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedTwxrayClass/?repage"; }
	 */

}