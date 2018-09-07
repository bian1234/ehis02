package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.entity.SicmedInspectPrice;
import com.sicmed.ehis.entity.SicmedRegisteredType;
import com.sicmed.ehis.service.SicmedBranchService;
import com.sicmed.ehis.service.SicmedRegisteredPriceService;
import com.sicmed.ehis.service.SicmedRegisteredTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 16:01
 * @Todo:  挂号类型
 */

@Controller
@RequestMapping("/rest/sicmedRegisteredType")
public class SicmedRegisteredTypeController extends BaseController{

    @Autowired
    private SicmedRegisteredTypeService sicmedRegisteredTypeService;

    @Autowired
    private SicmedRegisteredPriceService sicmedRegisteredPriceService;
    @Autowired
    private SicmedBranchService sicmedBranchService;

    /**
     * 根据科室等级查询 挂号类别
     *
     * @author Max
     * @param branchId
     * @return sicmedRegisteredTypeBeans
     */
//    @ResponseBody
//    @RequestMapping(value = "findByBranch")
//    public BaseBean findByBranch(String branchId) {
//        //根据科室id找到科室信息





//
//        // 创建返回对象
//        SicmedRegisteredTypeBeans sicmedRegisteredTypeBeans = new SicmedRegisteredTypeBeans();
//
//        // 创建查询对象
//        SicmedRegisteredType sicmedRegisteredType = new SicmedRegisteredType();
//        // 获取查询对象属性
//        SicmedBranch sicmedBranch = sicmedBranchService.get(branchId);
//        // 查询对象赋值
//        sicmedRegisteredType.setCodeGrades(sicmedBranch.getBranchNumber());
//        // 调用service方法查询挂号类型
//        List<SicmedRegisteredType> sicmedRegisteredTypes = sicmedRegisteredTypeService.findList(sicmedRegisteredType);
//        // 查询结果校验 处理
//        if (sicmedRegisteredTypes.size() > 0) {
//            for (SicmedRegisteredType sicmedRegisteredType2 : sicmedRegisteredTypes) {
//                SicmedRegisteredTypeBean sicmedRegisteredTypeBean = new SicmedRegisteredTypeBean();
//                sicmedRegisteredType2.setSicmedRegisteredPrice(
//                        sicmedRegisteredPriceService.get(sicmedRegisteredType2.getSicmedRegisteredPrice().getId()));
//
//                sicmedRegisteredTypeBean.setSRTB(sicmedRegisteredType2);
//                sicmedRegisteredTypeBeans.getSicmedRegisteredTypeBeans().add(sicmedRegisteredTypeBean);
//            }
//            sicmedRegisteredTypeBeans.setError("0");
//            sicmedRegisteredTypeBeans.setErrorMessage("查询成功");
//        } else {
//            sicmedRegisteredTypeBeans.setError("1");
//            sicmedRegisteredTypeBeans.setErrorMessage("查询失败查询结果为空");
//        }
//        // 返回处理信息
//        return sicmedRegisteredTypeBeans;
//    }



    /**
     *@Author:      ykbian
     *@date_time:   2018/9/6 14:11
     *@Description:
     *@param:
     */
    @ResponseBody
    @GetMapping("selectById")
    public Map selectById(String id) {
        SicmedRegisteredType sicmedRegisteredType = sicmedRegisteredTypeService.selectById(id);
        if (sicmedRegisteredType == null) {
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedRegisteredType);
    }

}
