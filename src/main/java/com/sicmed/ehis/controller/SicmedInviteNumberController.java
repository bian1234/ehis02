package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedInviteNumber;
import com.sicmed.ehis.service.SicmedInviteNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 9:33
 * @Todo:   账号激活码
 */
@Controller
@RequestMapping("/rest/inviteNumber")
public class SicmedInviteNumberController extends BaseController{

    @Autowired
    private SicmedInviteNumberService sicmedInviteNumberService;

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 9:35
     *@Description:  新增按照id查询信息
     *@param:
    */
    @GetMapping("/selectById")
    @ResponseBody
    public Map selectById(@RequestParam(required=false) String id) {
        SicmedInviteNumber entity = sicmedInviteNumberService.selectById(id);
        if (entity ==null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(entity);
    }
}
