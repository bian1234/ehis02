package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Constant;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.GroupWithoutId;
import com.sicmed.ehis.entity.SicmedDiseaseClass;
import com.sicmed.ehis.service.SicmedDiseaseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 9:04
 * @Todo:   疾病类别管理
 */
@Controller
@RequestMapping(value = "/rest/sicmedDiseaseClass")
public class SicmedDiseaseClassController   extends BaseController {

    @Autowired
    private SicmedDiseaseClassService sicmedDiseaseClassService;



    /**
     *@Author:      ykbian
     *@date_time:   2018/9/5 9:08
     *@Description:  添加药品类别信息
     *@param:
    */
    @ResponseBody
    @PostMapping(value = "add")
    public Map add(@Validated(GroupWithoutId.class) SicmedDiseaseClass sicmedDiseaseClass) {
        /**
         * 缺少创建者信息
         */
        sicmedDiseaseClass.setDelFlag(Constant.DEL_FLAG_USABLE);
        if (sicmedDiseaseClassService.insertSelective(sicmedDiseaseClass) < 0){
            return insertSuccseeResponse();
        }
           return insertFailedResponse();
    }

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/5 9:10
     *@Description:  根据id查询药品类别信息
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "getById")
    public Map getById(String id) {
        SicmedDiseaseClass sicmedDiseaseClass = sicmedDiseaseClassService.selectById(id);
        if (sicmedDiseaseClass == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDiseaseClass);
    }

   /**
    *@Author:      ykbian
    *@date_time:   2018/9/5 9:17
    *@Description:  查询所有的药品类别信息
    *@param:
   */
    @ResponseBody
    @GetMapping(value = "findAll")
    public Map findAll(Integer offset,Integer limit) {
        Query query = new Query(offset,limit);
        List<SicmedDiseaseClass> sicmedDiseaseClass = sicmedDiseaseClassService.findAllList(query);
        if (sicmedDiseaseClass.isEmpty()){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDiseaseClass);

    }
}
