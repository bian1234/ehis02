package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.AppParameterSimulation;
import com.sicmed.ehis.entity.SicmedTwxrayCheck;
import com.sicmed.ehis.service.SicmedTwxrayCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:50
 * @Todo:   放射线检查
 */
@Controller
@RequestMapping(value = "/rest/sicmedTwxrayCheck")
public class SicmedTwxrayCheckController extends BaseController{


    @Autowired
    private SicmedTwxrayCheckService sicmedTwxrayCheckService;



    /**
     *@Author:      ykbian
     *@date_time:   2018/9/12 11:28
     *@Description: 模糊搜索放射线检查信息
     *@param:       (编码;名称;拼音缩写)
    */
    @ResponseBody
    @GetMapping(value = "searchCheck")
    public Map searchAllCheck(String parameter, String classId,Integer offset,Integer limit) {
        Query query = new Query(offset,limit);
        // 创建查询条件对象
        SicmedTwxrayCheck sicmedTwxrayCheck = new SicmedTwxrayCheck();
        sicmedTwxrayCheck.setCheckClassCode(classId);
        //判断传入的参数类型
        if (parameter != null) {
            if (AppParameterSimulation.isChineseName(parameter)) {
                sicmedTwxrayCheck.setCheckName(parameter);
            } else if (AppParameterSimulation.simulationIsNumber(parameter)) {
                sicmedTwxrayCheck.setCheckCode(parameter);
            } else if (AppParameterSimulation.simulationIsPinYin(parameter)) {
                sicmedTwxrayCheck.setCheckNamePy(parameter);
            }
        }
        // 根据查询条件查询检查项目信息
        List<SicmedTwxrayCheck> sicmedTwxrayChecks = sicmedTwxrayCheckService.selectALLByParams(sicmedTwxrayCheck,query);
       if(sicmedTwxrayChecks.isEmpty()){
           return queryEmptyResponse();
       }
       return querySuccessResponse(sicmedTwxrayChecks);
    }
}
