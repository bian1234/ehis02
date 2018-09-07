package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.entity.SicmedMedicalUse;
import com.sicmed.ehis.service.SicmedMedicalUseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.stream.IIOByteBuffer;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 10:28
 * @Todo:   药品用法管理
 */
@Controller
@RequestMapping("/rest/sicmedMedicalUse")
public class SicmedMedicalUseController extends BaseController{

    @Autowired
    private SicmedMedicalUseService sicmedMedicalUseService;

//    @Autowired
//    private SicmedAskedService sicmedMdeicalAskedService;
//
//
//    /**
//     * 根据医嘱ID查询药品用法
//     */
//    @ResponseBody
//    @RequestMapping(value = "getByMAsked")
//    public BaseBean getByMAsked(String MAskedId){
//        //创建返回对象
//
//        //传入参数校验
//
//        //创建查询对象
//        SicmedMedicalUse sicmedMedicalUse= new SicmedMedicalUse();
//        //获取查询参数
//        SicmedAsked sicmedMdeicalAsked = sicmedMdeicalAskedService.get(MAskedId);
//        //查询对象赋值
////		sicmedMedicalUse.sets
//        //调用service
//
//        //查询结果校验处理
//
//        //返回查询结果
//        return null;
//
//    }

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/7 10:32
     *@Description:  根据id查询
     *@param:
    */

    @GetMapping("selectById")
    @ResponseBody
    public Map selectById(String id) {
        SicmedMedicalUse sicmedMedicalUse = sicmedMedicalUseService.selectById(id);
        if (sicmedMedicalUse == null){
            return queryEmptyResponse();
        }return querySuccessResponse(sicmedMedicalUse);
    }

}
