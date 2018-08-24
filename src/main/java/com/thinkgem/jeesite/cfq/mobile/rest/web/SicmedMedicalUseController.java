package com.thinkgem.jeesite.cfq.mobile.rest.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.config.Global;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedAskedService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalUseService;

/**
 * 单表生成Controller
 *
 * @author Max
 * @version 2016-08-16
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedMedicalUse")
public class SicmedMedicalUseController extends BaseController {

    @Autowired
    private SicmedMedicalUseService sicmedMedicalUseService;

    @Autowired
    private SicmedAskedService sicmedMdeicalAskedService;


    /**
     * 根据医嘱ID查询药品用法
     */
    @ResponseBody
    @RequestMapping(value = "getByMAsked")
    public BaseBean getByMAsked(String MAskedId) {
        //创建返回对象

        //传入参数校验

        //创建查询对象
        SicmedMedicalUse sicmedMedicalUse = new SicmedMedicalUse();
        //获取查询参数
        SicmedAsked sicmedMdeicalAsked = sicmedMdeicalAskedService.get(MAskedId);
        //查询对象赋值
//		sicmedMedicalUse.sets
        //调用service

        //查询结果校验处理

        //返回查询结果
        return null;

    }


    @ModelAttribute
    public SicmedMedicalUse get(@RequestParam(required = false) String id) {
        SicmedMedicalUse entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedMedicalUseService.get(id);
        }
        if (entity == null) {
            entity = new SicmedMedicalUse();
        }
        return entity;
    }

    @RequiresPermissions("rest:sicmedMedicalUse:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedMedicalUse sicmedMedicalUse, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedMedicalUse> page = sicmedMedicalUseService.findPage(new Page<SicmedMedicalUse>(request, response), sicmedMedicalUse);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedMedicalUseList";
    }

    @RequiresPermissions("rest:sicmedMedicalUse:view")
    @RequestMapping(value = "form")
    public String form(SicmedMedicalUse sicmedMedicalUse, Model model) {
        model.addAttribute("sicmedMedicalUse", sicmedMedicalUse);
        return "mobile/rest/sicmedMedicalUseForm";
    }

    @RequiresPermissions("rest:sicmedMedicalUse:edit")
    @RequestMapping(value = "save")
    public String save(SicmedMedicalUse sicmedMedicalUse, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedMedicalUse)) {
            return form(sicmedMedicalUse, model);
        }
        sicmedMedicalUseService.save(sicmedMedicalUse);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedMedicalUse/?repage";
    }

    @RequiresPermissions("rest:sicmedMedicalUse:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedMedicalUse sicmedMedicalUse, RedirectAttributes redirectAttributes) {
        sicmedMedicalUseService.delete(sicmedMedicalUse);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedMedicalUse/?repage";
    }

}