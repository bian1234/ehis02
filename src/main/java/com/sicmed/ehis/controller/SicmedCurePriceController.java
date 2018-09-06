package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedCurePrice;
import com.sicmed.ehis.entity.SicmedInspectPrice;
import com.sicmed.ehis.service.SicmedCurePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:51
 * @Todo:
 */
@Controller
@RequestMapping(value = "/rest/sicmedCurePrice")
public class SicmedCurePriceController  extends BaseController {

    @Autowired
    private SicmedCurePriceService sicmedCurePriceService;

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/6 14:11
     *@Description:  源码无此方法
     *@param:
     */
    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String id) {
        SicmedCurePrice sicmedCurePrice = sicmedCurePriceService.selectById(id);
        if (sicmedCurePrice == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedCurePrice);
    }
}
