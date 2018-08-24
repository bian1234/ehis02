/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
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

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedMedicalPriceBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedMedicalPriceService;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.AppParameterSimulation;

/**
 * 药品价格信息Controller
 *
 * @author 丁学志
 * @version 2016-07-12
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedMedicalPrice")
public class SicmedMedicalPriceController extends BaseController {

    @Autowired
    private SicmedMedicalPriceService sicmedMedicalPriceService;

    @ModelAttribute
    public SicmedMedicalPrice get(@RequestParam(required = false) String id) {
        SicmedMedicalPrice entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = sicmedMedicalPriceService.get(id);
        }
        if (entity == null) {
            entity = new SicmedMedicalPrice();
        }
        return entity;
    }

    /*
     * restful 接口示例
     * */
    @ResponseBody
    @RequestMapping(value = "mdeical")
    public SicmedMedicalPriceBean medicalPriceBean(@RequestParam(required = false) String medicalPriceId, HttpServletResponse response) {

        //获取药品信息的ID

        SicmedMedicalPriceBean medicalPriceBean = new SicmedMedicalPriceBean();

        if (AppParameterSimulation.simulationId(medicalPriceId)) {

            try {
                //通过药品ID获取药品信息对象
                SicmedMedicalPrice sicmedMedicalPrice = sicmedMedicalPriceService.get(medicalPriceId);

                medicalPriceBean.setError("0");
                medicalPriceBean.setErrorMessage("查询成功返回的JSON");
                medicalPriceBean.setSicmedMedicaPrice(sicmedMedicalPrice);

            } catch (Exception e) {

                medicalPriceBean.setError("1");
                medicalPriceBean.setErrorMessage("查询失败");
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }

            return medicalPriceBean;

        } else {

            medicalPriceBean.setError("1");
            medicalPriceBean.setErrorMessage("输入的ID不是需要的类型");
            return medicalPriceBean;

        }

    }


    @RequiresPermissions("rest:sicmedMedicalPrice:view")
    @RequestMapping(value = {"list", ""})
    public String list(SicmedMedicalPrice sicmedMedicalPrice, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<SicmedMedicalPrice> page = sicmedMedicalPriceService.findPage(new Page<SicmedMedicalPrice>(request, response), sicmedMedicalPrice);
        model.addAttribute("page", page);
        return "mobile/rest/sicmedMedicalPriceList";
    }

    @RequiresPermissions("rest:sicmedMedicalPrice:view")
    @RequestMapping(value = "form")
    public String form(SicmedMedicalPrice sicmedMedicalPrice, Model model) {
        model.addAttribute("sicmedMedicalPrice", sicmedMedicalPrice);
        return "mobile/rest/sicmedMedicalPriceForm";
    }

    @RequiresPermissions("rest:sicmedMedicalPrice:edit")
    @RequestMapping(value = "save")
    public String save(SicmedMedicalPrice sicmedMedicalPrice, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, sicmedMedicalPrice)) {
            return form(sicmedMedicalPrice, model);
        }
        sicmedMedicalPriceService.save(sicmedMedicalPrice);
        addMessage(redirectAttributes, "保存药品价格信息保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedMedicalPrice/?repage";
    }

    @RequiresPermissions("rest:sicmedMedicalPrice:edit")
    @RequestMapping(value = "delete")
    public String delete(SicmedMedicalPrice sicmedMedicalPrice, RedirectAttributes redirectAttributes) {
        sicmedMedicalPriceService.delete(sicmedMedicalPrice);
        addMessage(redirectAttributes, "删除药品价格信息保存成功成功");
        return "redirect:" + Global.getAdminPath() + "/rest/sicmedMedicalPrice/?repage";
    }

}