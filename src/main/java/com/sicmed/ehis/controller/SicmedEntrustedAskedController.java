package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Constant;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.GroupID;
import com.sicmed.ehis.entity.GroupWithoutId;
import com.sicmed.ehis.entity.SicmedEntrustedAsked;
import com.sicmed.ehis.service.SicmedEntrustedAskedService;
import org.apache.ibatis.ognl.ASTSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Date;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 13:33
 * @Todo:   嘱托医嘱管理
 */
@Controller
@RequestMapping(value = "/rest/sicmedEntrustedAsked")
public class SicmedEntrustedAskedController extends BaseController{



    @Autowired
    private SicmedEntrustedAskedService sicmedEntrustedAskedService;



    /**
     * 添加嘱托医嘱
     */
    @ResponseBody
    @PostMapping(value = "add")
    public Map add(@Validated(GroupWithoutId.class) SicmedEntrustedAsked sicmedEntrustedAsked) {
        /**
         *   添加创建者信息,并将创建者信息存入createUser
         */
        sicmedEntrustedAsked.setCreateDate(new Date());
        sicmedEntrustedAsked.setDelFlag(Constant.DEL_FLAG_USABLE);
        if (sicmedEntrustedAskedService.insertSelective(sicmedEntrustedAsked) > 0){
            return insertSuccseeResponse();
        }
        return insertFailedResponse();

    }

    /**
     * 删除嘱托医嘱
     */
    @ResponseBody
    @PostMapping(value = "delete")
    public Map delete(@Validated(GroupID.class)String id) {
        if(sicmedEntrustedAskedService.logicDelete(id) > 0){
            return deleteSuccseeResponse();
        }
        return deleteFailedResponse();
    }

    /**
     * 修改医嘱
     */
    @ResponseBody
    @PostMapping(value = "update")
    public Map update(@Validated({GroupID.class,GroupWithoutId.class}) SicmedEntrustedAsked sicmedEntrustedAsked) {
       //防止误操作
        sicmedEntrustedAsked.setDelFlag(Constant.DEL_FLAG_USABLE);
        if (sicmedEntrustedAskedService.updateSelective(sicmedEntrustedAsked) > 0){
            return updateSuccseeResponse();
        }
        return updateFailedResponse();
    }

    /**
     * 通过嘱托医嘱id查询嘱托医嘱
     */
    @ResponseBody
    @GetMapping(value = "selectById")
    public Map selectById(String id) {
        SicmedEntrustedAsked sicmedEntrustedAsked = sicmedEntrustedAskedService.selectById(id);

        if (sicmedEntrustedAsked == null){
            return queryEmptyResponse();
        }
       return querySuccessResponse(sicmedEntrustedAsked);
    }
}
