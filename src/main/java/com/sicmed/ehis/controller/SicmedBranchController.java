package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.GroupID;
import com.sicmed.ehis.entity.GroupWithoutId;
import com.sicmed.ehis.entity.SicmedBranch;
import com.sicmed.ehis.service.SicmedBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 14:48
 * @Todo:  科室信息表
 */
@Controller
@RequestMapping(value = "/rest/sicmedBranch")
public class SicmedBranchController extends BaseController{

    @Autowired
    private SicmedBranchService sicmedBranchService;

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 14:59
     *@Description:  添加科室信息
     *@param:
    */
    @ResponseBody
    @PostMapping(value = "add")
    public Map add(SicmedBranch sicmedBranch) {
        if (sicmedBranchService.insertSelective(sicmedBranch)>0){
            return insertSuccseeResponse();
        }return insertFailedResponse();
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 15:06
     *@Description:  根据id查询科室信息
     *@param:et
    */
    @ResponseBody
    @GetMapping(value = "getById")
    public Map getById( @Validated(GroupID.class) String id) {
        SicmedBranch sicmedBranch = sicmedBranchService.selectById(id);
        if (sicmedBranch == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedBranch);
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 15:14
     *@Description:  查询所有可以挂号的科室====查询删除标记为0的数据
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "findAllRegisteredBranch")
    public Map findAllRegisteredBranch(Integer offset,Integer limit){
        Query query = new Query(offset,limit);
        List<SicmedBranch> sicmedBranches = sicmedBranchService.selectRegistered(query);
        if (sicmedBranches.isEmpty()){
            return  queryEmptyResponse();
        }
        return querySuccessResponse(sicmedBranches);
    }
}
