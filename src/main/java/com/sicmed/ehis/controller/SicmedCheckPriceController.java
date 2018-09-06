package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedCheckPrice;
import com.sicmed.ehis.service.SicmedCheckPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 8:57
 * @Todo:   放射线检查价格表
 */
@Controller
@RequestMapping(value = "/rest/sicmedCheckPrice")
public class SicmedCheckPriceController extends BaseController{

    @Autowired
    private SicmedCheckPriceService sicmedCheckPriceService;


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/6 8:59
     *@Description:  源码无
     *@param:
    */
    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String id) {
        SicmedCheckPrice sicmedCheckPrice = sicmedCheckPriceService.selectById(id);
        if (sicmedCheckPrice == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedCheckPrice);
    }
}
