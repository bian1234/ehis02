package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedCureClass;
import com.sicmed.ehis.service.SicmedCureClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 17:34
 * @Todo:   治疗类别
 */
@Controller
@RequestMapping(value = "/rest/sicmedCureClass")
public class SicmedCureClassController extends BaseController{

    @Autowired
    private SicmedCureClassService sicmedCureClassService;

    /**
     * @author Max
     * @return sicmedCureClassBeans
     */

    @ResponseBody
    @GetMapping(value = "findAll")
    public Map findAll(Integer offset,Integer limit) {
        Query query = new Query(offset,limit);
        // 调用service方法查询
        List<SicmedCureClass> sicmedCureClasses = sicmedCureClassService.findAllList(query);
        if (sicmedCureClasses.isEmpty()) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedCureClasses);
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/5 17:52
     *@Description:  新增按照id查询===源码无
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "selectById")
    public Map selectById(String id) {
        SicmedCureClass sicmedCureClasse = sicmedCureClassService.selectById(id);
        if (sicmedCureClasse == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedCureClasse);
    }
}
