package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedAskedClass;
import com.sicmed.ehis.entity.SicmedBranch;
import com.sicmed.ehis.entity.SicmedStandardprescriptionBranch;
import com.sicmed.ehis.service.SicmedAskedClassService;
import com.sicmed.ehis.service.SicmedBranchService;
import com.sicmed.ehis.service.SicmedStandardprescriptionBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 16:19
 * @Todo:  科室标准处方
 */
@Controller
@RequestMapping("/rest/standardprescriptionBranch")
public class SicmedStandardprescriptionBranchController  extends BaseController {

    @Autowired
    private SicmedStandardprescriptionBranchService sicmedStandardprescriptionBranchService;
    @Autowired
    private SicmedBranchService sicmedBranchService;
    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 16:44
     *@Description: 查询科室标准处方
     *@param:   科室标准处方对象，里面有科室ID和医嘱类别两个参数
    */
    @ResponseBody
    @GetMapping(value = "findStandardPrescriptionBranch")
    public Map findStandardPrescriptionBranch(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch){
        List<SicmedStandardprescriptionBranch> sicmedStandardprescriptionBranches =
                sicmedStandardprescriptionBranchService.findStandardPrescriptionBranch(sicmedStandardprescriptionBranch.getBranchCode(),
                        sicmedStandardprescriptionBranch.getAskedCode());
        if (sicmedStandardprescriptionBranches.isEmpty()){
            return queryEmptyResponse();
        }
        //将科室信息和医嘱信息赋值给处方信息
        for (SicmedStandardprescriptionBranch ssb: sicmedStandardprescriptionBranches) {
            //根据科室id查询科室信息
            SicmedBranch sicmedBranch  = sicmedBranchService.selectById(sicmedStandardprescriptionBranch.getBranchCode());
            //根据医嘱类别查询到医嘱信息
            SicmedAskedClass sicmedAskedClass = sicmedAskedClassService.selectById(sicmedStandardprescriptionBranch.getAskedCode());
            //根据科室和医嘱信息查询处方信息
            ssb.setSicmedBranch(sicmedBranch);
            ssb.setSicmedAskedClass(sicmedAskedClass);
        }
        return querySuccessResponse(sicmedStandardprescriptionBranches);
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 17:39
     *@Description:   通过id查询
     *@param:
    */
    @GetMapping("selectById")
    @ResponseBody
    public Map selectById(String id) {
        SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch
                = sicmedStandardprescriptionBranchService.selectById(id);

        if (sicmedStandardprescriptionBranch == null) {
           return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedStandardprescriptionBranch);
    }
}
