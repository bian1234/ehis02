package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedMedicalAsked;
import com.sicmed.ehis.entity.Sno;
import com.sicmed.ehis.service.SnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:35
 * @Todo:   单表控制
 */
@Controller
@RequestMapping(value = "/rest/sno")
public class SnoController extends BaseController{


    @Autowired
    private SnoService snoService;


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/6 14:38
     *@Description:  源码无这个方法    如果查询不到表信息的话 自动生成一个新的表
     *@param:
    */
    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String id) {
        Sno sno = snoService.selectById(id);
        if (sno == null) {
            Sno sno1 = new Sno();
            return querySuccessResponse(sno1);
        }
        return querySuccessResponse(sno);
    }
}
