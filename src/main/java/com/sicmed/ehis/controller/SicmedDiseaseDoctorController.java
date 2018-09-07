package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Constant;
import com.sicmed.ehis.entity.SicmedDisease;
import com.sicmed.ehis.entity.SicmedDiseaseDoctor;
import com.sicmed.ehis.service.SicmedDiseaseDoctorService;
import com.sicmed.ehis.service.SicmedDiseaseService;
import com.sicmed.ehis.service.SicmedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 17:10
 * @Todo:  医生常用疾病表
 */
@Controller
@RequestMapping(value = "/rest/sicmedDiseaseDoctor")
public class SicmedDiseaseDoctorController extends BaseController{

    @Autowired
    private SicmedDiseaseDoctorService sicmedDiseaseDoctorService;

    @Autowired
    private SicmedUserService sicmedDoctorService;

    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/6 17:23
     *@Description:  添加医生常用疾病
     *@param:  SicmedDiseaseDoctor(内含疾病id和医生id)
    */
    @ResponseBody
    @PostMapping(value = "add")
    public Map add(SicmedDiseaseDoctor sicmedDiseaseDoctor) {
        sicmedDiseaseDoctor.setDelFlag(Constant.DEL_FLAG_USABLE);

        try {
            //根据疾病id查询到疾病分类id,存入sicmedDiseaseDoctor
            SicmedDisease sicmedDisease = sicmedDiseaseService.selectById(sicmedDiseaseDoctor.getDiseaseCode());
            sicmedDiseaseDoctor.setDiseaseClassCode(sicmedDisease.getDiseaseCode());
            if (sicmedDiseaseDoctorService.insertSelective(sicmedDiseaseDoctor) > 0){
                return insertSuccseeResponse();
            }
            return insertFailedResponse();
        } catch (Exception e) {
            e.printStackTrace();
            return insertFailedResponse();
        }
    }

    /**
     * 根据ID查询医生个人常用疾病
     *
     * @param diseaseBranchId
     * @return
     */
    @ResponseBody
    @GetMapping(value = "getById")
    public Map getById(String diseaseDoctorId) {
        SicmedDiseaseDoctor sicmedDiseaseDoctor = sicmedDiseaseDoctorService.selectById(diseaseDoctorId);
        if (sicmedDiseaseDoctor == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDiseaseDoctor);
    }

    /**
     * 根据医生查询医生个人常用疾病
     *
     * @param doctorId
     * @return
     */

    @ResponseBody
    @GetMapping(value = "findByDoctor")
    public Map findByBranch(String doctorId) {
        List<SicmedDiseaseDoctor> sicmedDiseaseDoctor = sicmedDiseaseDoctorService.selectByDoctorCode(doctorId);
        if (sicmedDiseaseDoctor.isEmpty()){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDiseaseDoctor);

    }

}
