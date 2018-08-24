package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedHospitalBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedHospitalBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCity;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedHospital;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCityService;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedHospitalService;

/**
 * 单表生成Controller
 *
 * @author Max
 * @version 2016-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedHospital")
public class SicmedHospitalController extends BaseController {

    @Autowired
    private SicmedHospitalService sicmedHospitalService;

    @Autowired
    private SicmedCityService sicmedCityService;

    /**
     * 根据区/县获取医院信息
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "findAllHospital")
    public BaseBean findAllHopital(@RequestParam(required = false) String cityId) {
        SicmedHospitalBeans sicmedHospitalBeans = new SicmedHospitalBeans();
        // 校验传入的参数

        // 创建查询条件
        SicmedHospital sicmedHospital = new SicmedHospital();
        // 获取查询条件属性
        SicmedCity sicmedCity = sicmedCityService.getById(cityId);
        // 为查询条件赋值
        sicmedHospital.setSicmedCity(sicmedCity);
        // 查询医院集合
        List<SicmedHospital> sicmedHospitals = sicmedHospitalService.findList(sicmedHospital);
        // 遍历查询结果
        for (SicmedHospital sicmedHospital2 : sicmedHospitals) {
            // 将查询结果放到Bean中
            SicmedHospitalBean sicmedHospitalBean = new SicmedHospitalBean();
            sicmedHospitalBean.setSHB(sicmedHospital2);
            sicmedHospitalBeans.getSicmedHospitalBeans().add(sicmedHospitalBean);
        }
        // 返回Bean
        sicmedHospitalBeans.setError("0");
        return sicmedHospitalBeans;
    }

	/*
     * @ModelAttribute public SicmedHospital get(@RequestParam(required=false)
	 * String id) { SicmedHospital entity = null; if
	 * (StringUtils.isNotBlank(id)){ entity = sicmedHospitalService.get(id); }
	 * if (entity == null){ entity = new SicmedHospital(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedHospital:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public String list(SicmedHospital
	 * sicmedHospital, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedHospital> page =
	 * sicmedHospitalService.findPage(new Page<SicmedHospital>(request,
	 * response), sicmedHospital); model.addAttribute("page", page); return
	 * "mobile/rest/sicmedHospitalList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedHospital:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedHospital
	 * sicmedHospital, Model model) { model.addAttribute("sicmedHospital",
	 * sicmedHospital); return "mobile/rest/sicmedHospitalForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedHospital:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedHospital
	 * sicmedHospital, Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedHospital)){ return form(sicmedHospital,
	 * model); } sicmedHospitalService.save(sicmedHospital);
	 * addMessage(redirectAttributes, "保存单表成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedHospital/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedHospital:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedHospital
	 * sicmedHospital, RedirectAttributes redirectAttributes) {
	 * sicmedHospitalService.delete(sicmedHospital);
	 * addMessage(redirectAttributes, "删除单表成功"); return
	 * "redirect:"+Global.getAdminPath()+"/rest/sicmedHospital/?repage"; }
	 */

}