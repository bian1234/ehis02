package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Constant;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.AppParameterSimulation;
import com.sicmed.ehis.entity.GroupID;
import com.sicmed.ehis.entity.GroupWithoutId;
import com.sicmed.ehis.entity.SicmedAskedClass;
import com.sicmed.ehis.service.SicmedAskedClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 9:41
 * @Todo:   医嘱信息控制
 */
@Controller
@RequestMapping(value = "/ehis/sicmedAskedClass")
public class SicmedAskedClassController extends BaseController{


    @Autowired
    private SicmedAskedClassService sicmedAskedClassService;

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 9:46
     *@Description:  添加医嘱信息
     *@param:
    */
    @ResponseBody
    @PostMapping("add")
    public Map save(@Validated({GroupWithoutId.class})SicmedAskedClass sicmedAskedClass) {
        sicmedAskedClass.setDelFlag(Constant.DEL_FLAG_USABLE);
        //判断医嘱类别编号是否为空或者是否为1位===参数错误的话直接返回，需要改成@Validate
        if(!AppParameterSimulation.AskedClassId(sicmedAskedClass.getClassNumber())){
            return insertFailedResponse();
        }
        if (sicmedAskedClassService.insertSelective(sicmedAskedClass) > 0){
            return insertSuccseeResponse();
        }
       return insertFailedResponse();
    }




    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 11:33
     *@Description:  查询医嘱类别信息
     *@param:
    */
    @ResponseBody
    @GetMapping("findAllList")
    public Map findAllList(Query query){
        return querySuccessResponse(sicmedAskedClassService.findAllList(query));
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 11:36
     *@Description: 根据id查询医嘱信息
     *@param:
    */
    @ResponseBody
    @RequestMapping(value = "getById")
    public Map getById(@Validated(GroupID.class)String id) {
        SicmedAskedClass sicmedAskedClass = sicmedAskedClassService.selectById(id);
        if ( sicmedAskedClass!= null){
            return querySuccessResponse(sicmedAskedClass);
        }
       return queryEmptyResponse();
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 13:18
     *@Description: 逻辑删除医嘱类别
     *@param:
    */
    @ResponseBody
    @RequestMapping(value = "delete")
    public Map delete( @Validated(GroupID.class)String id) {
        if( sicmedAskedClassService.logicDelete(id) > 0){
            return deleteSuccseeResponse();
        }
        return deleteFailedResponse();
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/4 13:32
     *@Description: 修改医嘱类型信息
     *@param:
    */
    @ResponseBody
    @RequestMapping(value = "update")
    public Map update( @Validated({GroupID.class,GroupWithoutId.class})SicmedAskedClass sicmedAskedClass) {
      if (sicmedAskedClassService.updateSelective(sicmedAskedClass)  > 0){
          return updateSuccseeResponse();
      }
       return updateFailedResponse();
    }

}
