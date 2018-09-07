package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Constant;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.*;
import com.sicmed.ehis.service.SicmedBranchService;
import com.sicmed.ehis.service.SicmedDiseaseBranchService;
import com.sicmed.ehis.service.SicmedDiseaseClassService;
import com.sicmed.ehis.service.SicmedDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.locks.Condition;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:19
 * @Todo: 科室常用疾病表Controller
 */
@Controller
@RequestMapping(value = "/rest/sicmedDiseaseBranch")
public class SicmedDiseaseBranchController  extends BaseController {


    @Autowired
    private SicmedDiseaseBranchService sicmedDiseaseBranchService;

    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;


   /**
    *@Author:      ykbian
    *@date_time:   2018/9/7 15:39
    *@Description: 添加科室常用疾病
    *@param:   疾病id，科室id
   */
    @ResponseBody
    @PostMapping(value = "add")
    public Map add(SicmedDiseaseBranch sicmedDiseaseBranch) {
        //根据疾病id查询出疾病分类信息,赋值给科室疾病对象
        SicmedDisease sicmedDisease = sicmedDiseaseService.selectById(sicmedDiseaseBranch.getDiseaseCode());
        sicmedDiseaseBranch.setDiseaseClassCode(sicmedDisease.getDiseaseClassCode());
        sicmedDiseaseBranch.setDelFlag(Constant.DEL_FLAG_USABLE);
        if(sicmedDiseaseBranchService.insertSelective(sicmedDiseaseBranch) > 0){
            //保存信息
            return insertSuccseeResponse();
        }
        return insertFailedResponse();
    }

    /**
     * 根据ID查询科室常用疾病
     *
     * @param diseaseBranchId
     * @return
     */
    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String diseaseBranchId) {
        SicmedDiseaseBranch sicmedDiseaseBranch = sicmedDiseaseBranchService.selectById(diseaseBranchId);
        if (sicmedDiseaseBranch == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDiseaseBranch);
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 13:47
     *@Description:   根据科室信息查询疾病信息
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "findByBranch")
    public Map findByBranch(String branchId,Integer offset,Integer limit) {
        Map<String,Object> map = new HashMap<>();
        SicmedDiseaseBranch sicmedDiseaseBranch = new SicmedDiseaseBranch();
        sicmedDiseaseBranch.setBranchCode(branchId);
        Query query = new Query(offset,limit);
        map.put("query",query);
        map.put("sicmedDiseaseBranch",sicmedDiseaseBranch);
        List<SicmedDiseaseBranch> sicmedDiseaseBranches  = sicmedDiseaseBranchService.selectByBranch(map);
        if (sicmedDiseaseBranches.isEmpty()){
            return queryEmptyResponse();
        }return querySuccessResponse(sicmedDiseaseBranches);
    }
}
