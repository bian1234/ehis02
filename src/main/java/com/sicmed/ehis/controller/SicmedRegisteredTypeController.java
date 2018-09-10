package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedBranch;
import com.sicmed.ehis.entity.SicmedInspectPrice;
import com.sicmed.ehis.entity.SicmedRegisteredType;
import com.sicmed.ehis.service.SicmedBranchService;
import com.sicmed.ehis.service.SicmedRegisteredPriceService;
import com.sicmed.ehis.service.SicmedRegisteredTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:01
 * @Todo:  挂号类型
 */

@Controller
@RequestMapping("/rest/sicmedRegisteredType")
public class SicmedRegisteredTypeController extends BaseController{

    @Autowired
    private SicmedRegisteredTypeService sicmedRegisteredTypeService;

    @Autowired
    private SicmedRegisteredPriceService sicmedRegisteredPriceService;
    @Autowired
    private SicmedBranchService sicmedBranchService;

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/10 16:38
     *@Description: 根据科室等级查询挂号类别
     *@param:
    */
    @ResponseBody
    @GetMapping("selectByBranch")
    public Map selectByBranch(String branchId) {
        //查询科室信息

        SicmedBranch sicmedBranch = sicmedBranchService.selectById(branchId);
        if (sicmedBranch == null){
            return queryEmptyResponse();
        }
        //根据科室等级查询到挂号信息
        List<SicmedRegisteredType> sicmedRegisteredTypes = sicmedRegisteredTypeService.selectByGrades(sicmedBranch.getBranchNumber());
        if ( !sicmedRegisteredTypes.isEmpty()){
//            for (SicmedRegisteredType registeredType :sicmedRegisteredTypes) {
//                System.out.println("----------"+registeredType);
//                registeredType.setSicmedRegisteredPrice(sicmedRegisteredPriceService.selectById(registeredType.getPriceId()));
//            }
            return querySuccessResponse(sicmedRegisteredTypes);
        }return queryEmptyResponse();
    }



    /**
     *@Author:      ykbian
     *@date_time:   2018/9/6 14:11
     *@Description:
     *@param:
     */
    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String id) {
        SicmedRegisteredType sicmedRegisteredType = sicmedRegisteredTypeService.selectById(id);
        if (sicmedRegisteredType == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedRegisteredType);
    }

}
