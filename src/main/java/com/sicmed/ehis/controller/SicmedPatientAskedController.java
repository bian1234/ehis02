package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedDisease;
import com.sicmed.ehis.entity.SicmedPatientAsked;
import com.sicmed.ehis.service.SicmedPatientAskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 11:12
 * @Todo:   患者医嘱表
 */
@Controller
@RequestMapping(value = "/rest/sicmedPatientAsked")
public class SicmedPatientAskedController extends BaseController{


    @Autowired
    private SicmedPatientAskedService sicmedPatientAskedService;



    /**
     *@Author:      ykbian
     *@date_time:   2018/9/10 11:13
     *@Description:  根据id查询医嘱信息
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "getById")
    public Map getById(String id) {
        SicmedPatientAsked sicmedPatientAsked = sicmedPatientAskedService.selectById(id);
        if (sicmedPatientAsked == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedPatientAsked);
    }

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/10 11:14
     *@Description:  患者查询医嘱信息
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "getByPatient")
    public Map getByPatient(String patientId, String askedClass) {
        List<SicmedPatientAsked> sicmedPatientAsked = sicmedPatientAskedService.getByPatient(patientId,askedClass);
        if (sicmedPatientAsked == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedPatientAsked);
    }

}
