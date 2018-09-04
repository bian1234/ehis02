package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Constant;
import com.sicmed.ehis.entity.GroupID;
import com.sicmed.ehis.entity.GroupWithoutId;
import com.sicmed.ehis.entity.SicmedDept;
import com.sicmed.ehis.service.impl.SicmedDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 18:58
 * @Todo:  科室信息控制
 */
@Controller
@RequestMapping("/rest/sicmedDept")
public class SicmedDeptController  extends BaseController{

    @Autowired
    private SicmedDeptService sicmedDeptService;

    /**
     * 添加部门
     *
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "add")
    public Map add(@Validated(GroupWithoutId.class) SicmedDept sicmedDept) {
        sicmedDept.setDelFlag(Constant.DEL_FLAG_USABLE);
        if(sicmedDeptService.insertSelective(sicmedDept) > 0){
            return insertSuccseeResponse();
        }
        return insertFailedResponse();
    }

    /**
     * 根据ID查询部门信息
     *
     * @return
     */

    @ResponseBody
    @RequestMapping(value = "getById")
    public Map getById(String id) {
        SicmedDept sicmedDept = sicmedDeptService.selectById(id);
        if(sicmedDept != null){
            return querySuccessResponse(sicmedDept);
        }
        return queryEmptyResponse();
    }
}
