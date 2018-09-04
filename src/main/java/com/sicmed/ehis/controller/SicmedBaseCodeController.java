package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.GroupID;
import com.sicmed.ehis.entity.GroupWithoutId;
import com.sicmed.ehis.entity.SicmedBaseCode;
import com.sicmed.ehis.service.SicmedBaseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 13:49
 * @Todo:   基础编码表
 */
@Controller
@RequestMapping("/rest/sicmedBaseCode")
public class SicmedBaseCodeController extends BaseController{


    @Autowired
    private SicmedBaseCodeService sicmedBaseCodeService;
    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 13:50
     *@Description:   添加基础编码信息
     *@param:
    */
    @ResponseBody
    @RequestMapping(value = "save")
    public Map save(@Validated(GroupWithoutId.class) SicmedBaseCode sicmedBaseCode) {
        if (sicmedBaseCodeService.insertSelective(sicmedBaseCode) > 0){
            return insertSuccseeResponse();
        }
        return insertFailedResponse();
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 13:51
     *@Description:  根据id获取基础编码数据
     *@param:
    */

    @ResponseBody
    @RequestMapping(value = "getById")
    public Map getById(@Validated(GroupID.class) String id) {    //此处的id可以不做校验
        SicmedBaseCode sicmedBaseCode = sicmedBaseCodeService.selectById(id);
        if (sicmedBaseCode != null){
            return querySuccessResponse(sicmedBaseCode);
        }return queryEmptyResponse();
    }
}
