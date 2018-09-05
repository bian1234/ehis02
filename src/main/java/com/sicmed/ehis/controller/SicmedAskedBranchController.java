package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedAskedBranch;
import com.sicmed.ehis.service.SicmedAskedBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 14:35
 * @Todo:   医嘱传送部门
 */
@Controller
@RequestMapping(value = "/rest/sicmedAskedBranch")
public class SicmedAskedBranchController   extends BaseController{


    @Autowired
    private SicmedAskedBranchService sicmedAskedBranchService;
    /**
     *@Author:      ykbian
     *@date_time:   2018/9/5 14:40
     *@Description: 新增根据id查询信息================源码无
     *@param:
    */
    @ResponseBody
    @GetMapping("/selectById")
    public Map selectById(String id) {
        SicmedAskedBranch sicmedAskedBranch = sicmedAskedBranchService.selectById(id);
        if (sicmedAskedBranch == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedAskedBranch);
    }
}
