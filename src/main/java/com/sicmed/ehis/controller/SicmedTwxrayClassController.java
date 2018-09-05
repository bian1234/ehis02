package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedTwxrayClass;
import com.sicmed.ehis.service.SicmedTwxrayClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 10:09
 * @Todo:   放射线大分类管理
 */
@Controller
@RequestMapping("/rest/sicmedTwxrayClass")
public class SicmedTwxrayClassController extends BaseController{

    @Autowired
    private SicmedTwxrayClassService sicmedTwxrayClassService;

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/5 10:10
     *@Description:   获取检查类别
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "findAll")
    public Map searchAllCheck(Integer offset,Integer limit) {
        Query query = new Query(offset,limit);

        List<SicmedTwxrayClass> sicmedTwxrayClasses= sicmedTwxrayClassService.findAllList(query);
        if (sicmedTwxrayClasses.isEmpty()){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedTwxrayClasses);
    }

}
