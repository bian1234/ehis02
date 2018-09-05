package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedCity;
import com.sicmed.ehis.entity.SicmedHospital;
import com.sicmed.ehis.service.SicmedCityService;
import com.sicmed.ehis.service.SicmedHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 10:34
 * @Todo:  医院表
 */
@Controller
@RequestMapping(value = "/rest/sicmedHospital")
public class SicmedHospitalController extends BaseController{

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
    public Map findAllHopital(String cityId) {

        //根据城市信息查询医院信息====列表
        List<SicmedHospital> sicmedHospitals = sicmedHospitalService.selectALLByCityId(cityId);
        if (!sicmedHospitals.isEmpty()){
            //根据cityId查询城市信息
            SicmedCity sicmedCity = sicmedCityService.selectById(cityId);
            //将城市信息赋值给医院对象并返回
            for (SicmedHospital sicmedHospital:sicmedHospitals) {
                sicmedHospital.setCityCode(sicmedCity.getCityName());
            }
            return querySuccessResponse(sicmedHospitals);
        }
        return queryEmptyResponse();

    }
}
