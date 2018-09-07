package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedDoctorAsked;
import com.sicmed.ehis.service.SicmedDoctorAskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 9:16
 * @Todo:  医生常用医嘱
 */
@Controller
@RequestMapping(value = "/rest/sicmedDoctorAsked")
public class SicmedDoctorAskedController extends BaseController{


    @Autowired
    private SicmedDoctorAskedService sicmedDoctorAskedService;

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 9:23
     *@Description:  增加按照id获取信息
     *@param:
    */
    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String id) {
        SicmedDoctorAsked sicmedDoctorAsked = sicmedDoctorAskedService.selectById(id);
        if (sicmedDoctorAsked == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDoctorAsked);
    }

}
