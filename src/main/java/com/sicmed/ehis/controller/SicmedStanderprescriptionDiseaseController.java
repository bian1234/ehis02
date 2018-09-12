package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Constant;
import com.sicmed.ehis.entity.SicmedStanderprescriptionDisease;
import com.sicmed.ehis.service.SicmedDiseaseService;
import com.sicmed.ehis.service.SicmedStanderprescriptionAskedService;
import com.sicmed.ehis.service.SicmedStanderprescriptionDiseaseService;
import com.sicmed.ehis.service.SicmedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 11:23
 * @Todo:  标准处方中的疾病
 */
@Controller
@RequestMapping("/rest/sicmedStanderprescriptionDisease")
public class SicmedStanderprescriptionDiseaseController  extends BaseController {


    @Autowired
    private SicmedStanderprescriptionDiseaseService sicmedStanderprescriptionDiseaseService;




    /**
     * 添加标准处方中的疾病
     *
     * @param
     * @return
     */
    @ResponseBody
    @PostMapping(value = "add")
    public Map add(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {

        /**
         *   创建者信息
         */

      sicmedStanderprescriptionDisease.setDelFlag(Constant.DEL_FLAG_USABLE);
      if (sicmedStanderprescriptionDiseaseService.insertSelective(sicmedStanderprescriptionDisease) > 0){
          return insertSuccseeResponse();
      }
      return insertFailedResponse();
    }

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 18:25
     *@Description:  根据创建者信息查询处方信息------
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "getByCreate")
    public Map getByCreate() {

        /**
         *    要么从token中获取创建者id，要么从session,或者redis中获取当前用户的信息
         */
        String createUser = "0e27768cb28811e89c1500163e000a60";

        List<SicmedStanderprescriptionDisease> sicmedStanderprescriptionDiseases =
                sicmedStanderprescriptionDiseaseService.selectByCreate(createUser);

        if (sicmedStanderprescriptionDiseases.isEmpty()){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedStanderprescriptionDiseases);

    }

    /**
     * 删除标准处方
     *
     */
    @ResponseBody
    @PostMapping(value = "delete")
    public Map delete(String id) {
        //找不到直接返回失败
        SicmedStanderprescriptionDisease sicmedStanderprescriptionDiseas  =
                sicmedStanderprescriptionDiseaseService.selectById(id);
        if (sicmedStanderprescriptionDiseas == null){
            return deleteFailedResponse();
        }
       sicmedStanderprescriptionDiseas.setDelFlag(Constant.DEL_FLAG_DISUSABLE);
        if ( sicmedStanderprescriptionDiseaseService.updateSelective(sicmedStanderprescriptionDiseas) > 0){
            return deleteSuccseeResponse();
        }
        return deleteFailedResponse();
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 18:43
     *@Description:  修改
     *@param:
    */
    @ResponseBody
    @PostMapping(value = "update")
    public Map update(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {

        /**
         *   修改者信息
         */
        //防止误操作 改变删除信息
        sicmedStanderprescriptionDisease.setDelFlag(Constant.DEL_FLAG_USABLE);
        if (sicmedStanderprescriptionDiseaseService.updateSelective(sicmedStanderprescriptionDisease) > 0){
            return updateSuccseeResponse();
        }
        return updateFailedResponse();
    }

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 18:27
     *@Description: 根据处方名查询处方信息
     *@param:
    */
    @ResponseBody
    @RequestMapping(value = "findByName")
    public Map findByName(String prescriptionName) {
        List<SicmedStanderprescriptionDisease> sicmedStanderprescriptionDisease =
                sicmedStanderprescriptionDiseaseService.selectByName(prescriptionName);
        if (sicmedStanderprescriptionDisease.isEmpty()){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedStanderprescriptionDisease);
    }


}
