package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedMedicalAsked;
import com.sicmed.ehis.service.SicmedMedicalAskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:18
 * @Todo:   医嘱个药品中间表
 */
@Controller
@RequestMapping("/rest/sicmedMedicalAsked")
public class SicmedMedicalAskedController extends BaseController{

    @Autowired
    private SicmedMedicalAskedService sicmedMedicalAskedService;

    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String id) {
        SicmedMedicalAsked sicmedMedicalAsked = sicmedMedicalAskedService.selectById(id);
        if (sicmedMedicalAsked == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedMedicalAsked);
    }

}
