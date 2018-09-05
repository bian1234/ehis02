package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedCity;
import com.sicmed.ehis.service.SicmedCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 16:45
 * @Todo:   城市
 */
@Controller
@RequestMapping(value = "/rest/sicmedCity")
public class SicmedCityController  extends BaseController {

    @Autowired
    private SicmedCityService sicmedCityService;

    /**
     * 获取所有国家
     *
     * @param null
     * @return
     */
    @ResponseBody
    @GetMapping(value = "findAllCountry")
    public Map findAllCountry(Integer offset,Integer limit) {
        Query query = new Query(offset,limit);
        List<SicmedCity> sicmedCities = sicmedCityService.findAllList(query);
        if (sicmedCities == null){
            return  queryEmptyResponse();
        }
        return querySuccessResponse(sicmedCities);
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/5 16:47
     *@Description:  源码是三个接口，根据国家获取省份、根据省份获取地市和根据地市获取区县，现整理为一个，根据parentId获取ChildList
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "getChild")
    public Map getChild(String cityParentId) {
        List<SicmedCity> sicmedCities = sicmedCityService.getChild(cityParentId);
        if (sicmedCities == null){
            return  queryEmptyResponse();
        }
        return querySuccessResponse(sicmedCities);
    }

}
