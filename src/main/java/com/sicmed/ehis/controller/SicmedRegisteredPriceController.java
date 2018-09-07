package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedRegisteredPrice;
import com.sicmed.ehis.service.SicmedRegisteredPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 18:27
 * @Todo:  挂号价格
 */
@Controller
@RequestMapping(value = "/rest/sicmedRegisteredPrice")
public class SicmedRegisteredPriceController extends BaseController{

    @Autowired
    private SicmedRegisteredPriceService sicmedRegisteredPriceService;



    /**
     *@Author:      ykbian
     *@date_time:   2018/9/5 18:32
     *@Description:   新增按照id查询-----------源码没有这个接口
     *@param:
    */
    @ResponseBody
    @GetMapping("/selectById")
    public Map selectById(String id){
        SicmedRegisteredPrice sicmedRegisteredPrice = sicmedRegisteredPriceService.selectById(id);
        if (sicmedRegisteredPrice == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedRegisteredPrice);
    }

}
