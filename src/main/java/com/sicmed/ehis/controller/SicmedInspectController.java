package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.AppParameterSimulation;
import com.sicmed.ehis.entity.SicmedInspect;
import com.sicmed.ehis.service.SicmedInspectClassService;
import com.sicmed.ehis.service.SicmedInspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 13:18
 * @Todo:  检验表管理
 */
@Controller
@RequestMapping(value = "/rest/sicmedInspect")
public class SicmedInspectController  extends BaseController {

    /**
     *   检验表服务
     */
    @Autowired
    private SicmedInspectService sicmedInspectService;



    /**
     *@Author:      ykbian
     *@date_time:   2018/9/5 13:44
     *@Description:  模糊查询检验项目信息
     *@param:
    */
    @ResponseBody
    @RequestMapping(value = "searchInspect")
    public Map searchInspect(String parameter,String inspectClassCode,Integer offset,Integer limit) {
        SicmedInspect sicmedInspect = new SicmedInspect();
        Query query = new Query(offset,limit);
        Map<String,Object> map = new HashMap();
        if(parameter!=null){
            if(AppParameterSimulation.isChineseName(parameter)){
                sicmedInspect.setInspectName(parameter);
            }else if(AppParameterSimulation.simulationIsNumber(parameter)){
                sicmedInspect.setInspectCode(parameter);
            }else if(AppParameterSimulation.simulationIsPinYin(parameter)){
                sicmedInspect.setInspectNamePy(parameter);
            }
        }
        sicmedInspect.setInspectClassCode(inspectClassCode);
        // 根据查询条件查询
        map.put("query",query);
        map.put("sicmedInspect",sicmedInspect);
        List<SicmedInspect> sicmedInspects = sicmedInspectService.findListLike(map);
        // 判断查询结果
        if (sicmedInspects.isEmpty()) {
           return queryEmptyResponse();
        } else {
            return querySuccessResponse(sicmedInspects);
        }
    }


}
