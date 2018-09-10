package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Constant;
import com.sicmed.ehis.entity.GroupID;
import com.sicmed.ehis.entity.GroupWithoutId;
import com.sicmed.ehis.entity.SicmedPatientDisease;
import com.sicmed.ehis.service.SicmedPatientDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 14:59
 * @Todo:   患者疾病表
 */
@Controller
@RequestMapping(value = "/rest/sicmedPatientDisease")
public class SicmedPatientDiseaseController  extends BaseController{

    @Autowired
    private SicmedPatientDiseaseService sicmedPatientDiseaseService;

  /**
   *@Author:      ykbian
   *@date_time:   2018/9/10 15:44
   *@Description: 添加初步诊断
   *@param:
  */
    @ResponseBody
    @PostMapping(value = "add")
    public Map add(@Validated(GroupWithoutId.class) SicmedPatientDisease sicmedPatientDisease) {
        /**
         *   缺少创建者信息
         */

        /**
         *  判断是否重复添加
         */
        List<SicmedPatientDisease> sicmedPatientDiseases = sicmedPatientDiseaseService.selectOneByParams(sicmedPatientDisease);
        if (sicmedPatientDiseases.isEmpty()){
            sicmedPatientDisease.setDelFlag(Constant.DEL_FLAG_USABLE);
            if (sicmedPatientDiseaseService.insertSelective(sicmedPatientDisease) > 0){
                return insertSuccseeResponse();
            }
            return insertFailedResponse();
        }
        return insertFailedResponse();


    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/10 15:47
     *@Description: 根据病历信息查询
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "getByCase")
    public Map getByCase(String caseCode) {
        List<SicmedPatientDisease>  sicmedPatientDiseases = sicmedPatientDiseaseService.getByCase(caseCode);
        if (!sicmedPatientDiseases.isEmpty()){
            return querySuccessResponse(sicmedPatientDiseases);
        }
        return queryEmptyResponse();
    }



    /**
     *@Author:      ykbian
     *@date_time:   2018/9/10 15:48
     *@Description:  删除信息
     *@param:
    */
    @ResponseBody
    @PostMapping(value = "delete")
    public Map delete(@Validated(GroupID.class)String id) {

        if ( sicmedPatientDiseaseService.logicDelete(id) > 0){
            return deleteSuccseeResponse();
        }
       return deleteFailedResponse();

    }

}
