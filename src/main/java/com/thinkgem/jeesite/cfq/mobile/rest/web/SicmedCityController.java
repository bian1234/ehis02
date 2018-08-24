package com.thinkgem.jeesite.cfq.mobile.rest.web;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCityBean;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedCityBeans;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCity;
import com.thinkgem.jeesite.cfq.mobile.rest.service.SicmedCityService;

/**
 * 单表生成Controller
 *
 * @author Max
 * @version 2016-08-10
 */
@Controller
@RequestMapping(value = "${adminPath}/rest/sicmedCity")
public class SicmedCityController extends BaseController {

    @Autowired
    private SicmedCityService sicmedCityService;

    /**
     * 获取所有国家
     *
     * @param null
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "findAllCountry")
    public BaseBean findAllCountry() {
        SicmedCityBeans sicmedCityBeans = new SicmedCityBeans();
        // 校验传入的参数

        // 创建查询条件
        SicmedCity sicmedCity = new SicmedCity();
        // 为查询条件赋值
        sicmedCity.setCityType("0");
        // 查询所有的国家
        List<SicmedCity> sicmedCities = sicmedCityService.findList(sicmedCity);
        // 遍历查询结果
        for (SicmedCity sicmedCity2 : sicmedCities) {
            // 将查询结果放到Bean中
            SicmedCityBean sicmedCityBean = new SicmedCityBean();
            sicmedCityBean.setSCB(sicmedCity2);
            sicmedCityBeans.getSicmedCityBeans().add(sicmedCityBean);
        }
        // 返回Bean
        sicmedCityBeans.setError("0");
        return sicmedCityBeans;
    }

    /**
     * 根据国家获取所有省市
     *
     * @param cityId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "findAllProvince")
    public BaseBean findAllProvince(@RequestParam(required = false) String cityId) {
        SicmedCityBeans sicmedCityBeans = new SicmedCityBeans();
        // 校验传入的参数

        // 创建查询条件
        SicmedCity sicmedCity = new SicmedCity();
        // 为查询条件赋值
        sicmedCity.setCityParentId(cityId);
        sicmedCity.setCityType("1");
        // 查询所有的国家
        List<SicmedCity> sicmedCities = sicmedCityService.findList(sicmedCity);
        // 遍历查询结果
        for (SicmedCity sicmedCity2 : sicmedCities) {
            // 将查询结果放到Bean中
            SicmedCityBean sicmedCityBean = new SicmedCityBean();
            sicmedCityBean.setSCB(sicmedCity2);
            sicmedCityBeans.getSicmedCityBeans().add(sicmedCityBean);
        }
        // 返回Bean
        sicmedCityBeans.setError("0");
        return sicmedCityBeans;
    }

    /**
     * 根据省获取所有市
     *
     * @param cityId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "findAllCity")
    public BaseBean findAllCity(@RequestParam(required = false) String cityId) {
        SicmedCityBeans sicmedCityBeans = new SicmedCityBeans();
        // 校验传入的参数

        // 创建查询条件
        SicmedCity sicmedCity = new SicmedCity();
        // 为查询条件赋值
        sicmedCity.setCityParentId(cityId);
        sicmedCity.setCityType("2");

        // 查询所有的国家
        List<SicmedCity> sicmedCities = sicmedCityService.findList(sicmedCity);
        // 遍历查询结果
        for (SicmedCity sicmedCity2 : sicmedCities) {
            // 将查询结果放到Bean中
            SicmedCityBean sicmedCityBean = new SicmedCityBean();
            sicmedCityBean.setSCB(sicmedCity2);
            sicmedCityBeans.getSicmedCityBeans().add(sicmedCityBean);
        }
        // 返回Bean
        sicmedCityBeans.setError("0");
        return sicmedCityBeans;
    }

    /**
     * 根据省获取所有县
     *
     * @param cityId
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "findAllCounty")
    public BaseBean findAllCounty(@RequestParam(required = false) String cityId) {
        SicmedCityBeans sicmedCityBeans = new SicmedCityBeans();
        // 校验传入的参数

        // 创建查询条件
        SicmedCity sicmedCity = new SicmedCity();
        // 为查询条件赋值
        sicmedCity.setCityParentId(cityId);
        sicmedCity.setCityType("3");
        // 查询所有的国家
        List<SicmedCity> sicmedCities = sicmedCityService.findList(sicmedCity);
        // 遍历查询结果
        for (SicmedCity sicmedCity2 : sicmedCities) {
            // 将查询结果放到Bean中
            SicmedCityBean sicmedCityBean = new SicmedCityBean();
            sicmedCityBean.setSCB(sicmedCity2);
            sicmedCityBeans.getSicmedCityBeans().add(sicmedCityBean);
        }
        // 返回Bean
        sicmedCityBeans.setError("0");
        return sicmedCityBeans;
    }

	/*
     * @ModelAttribute public SicmedCity get(@RequestParam(required = false)
	 * String id) { SicmedCity entity = null; if (StringUtils.isNotBlank(id)) {
	 * entity = sicmedCityService.get(id); } if (entity == null) { entity = new
	 * SicmedCity(); } return entity; }
	 * 
	 * @RequiresPermissions("rest:sicmedCity:view")
	 * 
	 * @RequestMapping(value = { "list", "" }) public String list(SicmedCity
	 * sicmedCity, HttpServletRequest request, HttpServletResponse response,
	 * Model model) { Page<SicmedCity> page = sicmedCityService.findPage(new
	 * Page<SicmedCity>(request, response), sicmedCity);
	 * model.addAttribute("page", page); return "mobile/rest/sicmedCityList"; }
	 * 
	 * @RequiresPermissions("rest:sicmedCity:view")
	 * 
	 * @RequestMapping(value = "form") public String form(SicmedCity sicmedCity,
	 * Model model) { model.addAttribute("sicmedCity", sicmedCity); return
	 * "mobile/rest/sicmedCityForm"; }
	 * 
	 * @RequiresPermissions("rest:sicmedCity:edit")
	 * 
	 * @RequestMapping(value = "save") public String save(SicmedCity sicmedCity,
	 * Model model, RedirectAttributes redirectAttributes) { if
	 * (!beanValidator(model, sicmedCity)) { return form(sicmedCity, model); }
	 * sicmedCityService.save(sicmedCity); addMessage(redirectAttributes,
	 * "保存单表成功"); return "redirect:" + Global.getAdminPath() +
	 * "/rest/sicmedCity/?repage"; }
	 * 
	 * @RequiresPermissions("rest:sicmedCity:edit")
	 * 
	 * @RequestMapping(value = "delete") public String delete(SicmedCity
	 * sicmedCity, RedirectAttributes redirectAttributes) {
	 * sicmedCityService.delete(sicmedCity); addMessage(redirectAttributes,
	 * "删除单表成功"); return "redirect:" + Global.getAdminPath() +
	 * "/rest/sicmedCity/?repage"; }
	 */

}