package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedInspectClass;
import com.sicmed.ehis.service.SicmedInspectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 15:54
 * @Todo:  检验分类管理
 */
@Controller
@RequestMapping(value = "/rest/sicmedInspectClass")
public class SicmedInspectClassController extends BaseController {


    @Autowired
    private SicmedInspectClassService sicmedInspectClassService;

   /**
    *@Author:      ykbian
    *@date_time:   2018/9/5 15:55
    *@Description:  获取所有检验分类
    *@param:
   */
    @ResponseBody
    @GetMapping(value = "findAll")
    public Map findAll(Integer offset,Integer limit) {
        Query query = new Query(offset,limit);
        List<SicmedInspectClass> sicmedInspectClasses =  sicmedInspectClassService.findAllList(query);
        if (sicmedInspectClasses.isEmpty()){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedInspectClasses);
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/5 15:56
     *@Description:  新增根据id查询数据=====源码无
     *@param:
    */
    @ResponseBody
    @GetMapping("/selectByID")
    public Map get(@RequestParam(required = false) String id) {
        SicmedInspectClass sicmedInspectClasse =  sicmedInspectClassService.selectById(id);
        if (sicmedInspectClasse == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedInspectClasse);
    }

}
