package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.AppParameterSimulation;
import com.sicmed.ehis.entity.SicmedDisease;
import com.sicmed.ehis.entity.SicmedInspectPrice;
import com.sicmed.ehis.service.SicmedDiseaseClassService;
import com.sicmed.ehis.service.SicmedDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 15:20
 * @Todo:  疾病表
 */
@Controller
@RequestMapping(value = "/rest/sicmedDisease")
public class SicmedDiseaseController extends BaseController{


    @Autowired
    private SicmedDiseaseService sicmedDiseaseService;



   /**
    *@Author:      ykbian
    *@date_time:   2018/9/6 15:24
    *@Description:  根据id查询疾病信息
    *@param:
   */
    @ResponseBody
    @RequestMapping(value = "getById")
    public Map getById(String id) {
        SicmedDisease sicmedDisease = sicmedDiseaseService.selectById(id);
        if (sicmedDisease == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDisease);
    }

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/6 15:33
     *@Description:  根据疾病类别查询疾病信息
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "getByClass")
    public Map getByDiseaseClass(String diseaseClassCode,Integer offset,Integer limit) {
        //这里要传入两个类型的参数，一个是分页信息，一个是疾病类别信息，使用map
        Query query = new Query(offset,limit);
        Map map = new HashMap();
        map.put("query",query);
        map.put("diseaseClassCode",diseaseClassCode);
        List<SicmedDisease> sicmedDisease = sicmedDiseaseService.getByClass(map);
        if (sicmedDisease.isEmpty()){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDisease);
    }

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/10 9:57
     *@Description:   模糊查询
     *@param:  （名称，英语，拼音）和疾病类别id
    */
    @ResponseBody
    @GetMapping(value = "searchDisease")
    public Map searchDisease(String param, String classCode,Integer offset,Integer limit) {
        SicmedDisease sicmedDisease = new SicmedDisease();
        Query query = new Query(offset,limit);
        Map<String ,Object> map = new HashMap();
       //判断传入的数据类型，名称，英文或者拼音简写
        if(AppParameterSimulation.simulationIsChinese(param)){
            sicmedDisease.setDiseaseName(param);
        }else if(AppParameterSimulation.simulationIsPinYin(param)){
            sicmedDisease.setDiseaseNamePmpa(param);
        }else{
            sicmedDisease.setDiseaseCode(param);
        }
        //如果有类型id的话，类型也传进去
        if(AppParameterSimulation.isNotEmpty(classCode)){
            sicmedDisease.setDiseaseClassCode(classCode);
        }
        map.put("query",query);
        map.put("sicmedDisease",sicmedDisease);
        //查询

        List<SicmedDisease> sicmedDiseases = sicmedDiseaseService.searchDisease(map);
        if (sicmedDiseases.isEmpty()){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedDiseases);
    }
}
