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
//    /**
//     * Url:
//     * http://localhost:8080/jeesite/a/rest/sicmedStandardprescriptionBranch/
//     * findStandardPrescriptionBranch
//     *
//     * @param id(科室id)
//     *            (21) askedClass(医嘱类别) (检查)
//     *
//     * @return 科室标准处方
//     */
//    @ResponseBody
//    @RequestMapping(value = "findStandardPrescriptionBranch")
//    public SicmedStandardprescriptionBranchBeans findStandardPrescriptionBranch(
//            @RequestParam(required = false) String id, String askedClass, HttpServletResponse response) {
//        SicmedStandardprescriptionBranchBeans sicmedStandardprescriptionBranchBeans = new SicmedStandardprescriptionBranchBeans();
//        try {
//            //查询科室信息
//            SicmedBranch sicmedBranch = sicmedBranchService.get(id);
//            if (sicmedBranch == null) {
//                sicmedStandardprescriptionBranchBeans.setError("1");
//                sicmedStandardprescriptionBranchBeans.setErrorMessage("科室编号输入有误或者没有该科室处方");
//            } else {
//                //查询医嘱类别信息
//                SicmedAskedClass sicmedAskedClass = sicmedAskedClassService.getAskedByAskedClass(askedClass);
//                SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch = new SicmedStandardprescriptionBranch();
//                sicmedStandardprescriptionBranch.setSicmedBranch(sicmedBranch);
//                sicmedStandardprescriptionBranch.setAskedClass(sicmedAskedClass);
//
//                //查询到标准处方列表
//                List<SicmedStandardprescriptionBranch> sicmedStandardprescriptionBranchs = sicmedStandardprescriptionBranchService
//                        .findList(sicmedStandardprescriptionBranch);
//
//                if (sicmedStandardprescriptionBranchs.size() != 0) {
//                    for (SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch2 : sicmedStandardprescriptionBranchs) {
//                        SicmedStandardprescriptionBranchBean sicmedStandardprescriptionBranchBean = new SicmedStandardprescriptionBranchBean();
//                        // sicmedStandardprescriptionBranchBeans.getSicmedStandardprescriptionBranchBeans().add(sicmedStandardprescriptionBranchBean);
//                        sicmedStandardprescriptionBranch2.setSicmedBranch(sicmedBranch);
//                        sicmedStandardprescriptionBranch2.setAskedClass(sicmedAskedClass);
//                        // sicmedStandardprescriptionBranch2.setStanderprescriptionDisease(sicmedStanderprescriptionDiseaseService.get(sicmedStandardprescriptionBranch2.getStanderprescriptionDisease().getId()));
//                        // sicmedStandardprescriptionBranch2.setStanderprescriptionAsked(sicmedStanderprescriptionAskedService.get(sicmedStandardprescriptionBranch2.getStanderprescriptionAsked().getId()));
//                        sicmedStandardprescriptionBranchBean.setssb(sicmedStandardprescriptionBranch2);
//                        sicmedStandardprescriptionBranchBeans.getSicmedStandardprescriptionBranchBeans()
//                                .add(sicmedStandardprescriptionBranchBean);
//                    }
//                    sicmedStandardprescriptionBranchBeans.setError("0");
//                    sicmedStandardprescriptionBranchBeans.setErrorMessage("科室标准处方查看成功");
//                } else {
//                    sicmedStandardprescriptionBranchBeans.setError("1");
//                    sicmedStandardprescriptionBranchBeans.setErrorMessage("查询失败,找不到信息");
//                }
//            }
//
//        } catch (Exception e) {
//            sicmedStandardprescriptionBranchBeans.setError("1");
//            sicmedStandardprescriptionBranchBeans.setErrorMessage("查询失败!系统内部异常" + e.getMessage());
//        }
//        return sicmedStandardprescriptionBranchBeans;
//    }

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
