package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedCureClass;
import com.sicmed.ehis.entity.SicmedInspectPrice;
import com.sicmed.ehis.service.SicmedInspectPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:02
 * @Todo:  检验价格
 */
@Controller
@RequestMapping(value = "/rest/sicmedInspectPrice")
public class SicmedInspectPriceController  extends BaseController {

    @Autowired
    private SicmedInspectPriceService sicmedInspectPriceService;


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/6 14:11
     *@Description:  源码无此方法
     *@param:
    */
    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String id) {
        SicmedInspectPrice sicmedInspectPrice = sicmedInspectPriceService.selectById(id);
        if (sicmedInspectPrice == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedInspectPrice);
    }
}
