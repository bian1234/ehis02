package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedRegisteredPrice;
import com.sicmed.ehis.entity.SicmedStandardprescriptionDoctor;
import com.sicmed.ehis.service.SicmedStandardprescriptionDoctorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 17:26
 * @Todo:   医生标准处方
 */
@Controller
@RequestMapping(value = "/rest/sicmedStandardprescriptionDoctor")
public class SicmedStandardprescriptionDoctorController extends BaseController{


    @Autowired
    private SicmedStandardprescriptionDoctorService sicmedStandardprescriptionDoctorService;


    @ResponseBody
    @GetMapping("/selectById")
    public Map selectById(String id){
        SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor
                = sicmedStandardprescriptionDoctorService.selectById(id);
        if (sicmedStandardprescriptionDoctor == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedStandardprescriptionDoctor);
    }


  /**
   *@Author:      ykbian
   *@date_time:   2018/9/10 17:53
   *@Description: 根据医生信息和医嘱分类信息查询
   *@param:
  */
    @ResponseBody
    @RequestMapping(value = "selectByDoctorCodeAndAskedCode")
    public Map selectByDoctorCodeAndAskedCode(String doctorCode, String askedClass,Integer offset,Integer limit) {
        Query query =  new Query(offset,limit);
        Map<String,Object> map = new HashMap<>();
        map.put("doctorCode",doctorCode);
        map.put("askedCode",askedClass);
        map.put("query",query);
        List<SicmedStandardprescriptionDoctor> sicmedStandardprescriptionDoctors =
                sicmedStandardprescriptionDoctorService.select(map);
        if (sicmedStandardprescriptionDoctors.isEmpty()){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedStandardprescriptionDoctors);
    }


}
