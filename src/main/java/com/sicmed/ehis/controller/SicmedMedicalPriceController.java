package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedMedicalPrice;
import com.sicmed.ehis.service.SicmedMedicalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 9:59
 * @Todo:  药品价格
 */
@Controller
@RequestMapping(value = "/rest/sicmedMedicalPrice")
public class SicmedMedicalPriceController   extends BaseController{

    @Autowired
    private SicmedMedicalPriceService sicmedMedicalPriceService;


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 10:24
     *@Description:  根据id查询信息
     *@param:
    */
    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String id) {
        SicmedMedicalPrice entity = sicmedMedicalPriceService.selectById(id);
       if (entity ==null){
           return queryEmptyResponse();
       }
       return querySuccessResponse(entity);
    }

}
