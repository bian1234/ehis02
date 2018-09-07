//package com.sicmed.ehis.controller;
//
//import com.sicmed.ehis.base.BaseController;
//import com.sicmed.ehis.entity.SicmedInspect;
//import com.sicmed.ehis.service.SicmedInspectClassService;
//import com.sicmed.ehis.service.SicmedInspectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
///**
// * @Author: ykbian
// * @Date: 2018/9/5 13:18
// * @Todo:  检验表管理
// */
//@Controller
//@RequestMapping(value = "/rest/sicmedInspect")
//public class SicmedInspectController  extends BaseController {
//
//    /**
//     *   检验表服务
//     */
//    @Autowired
//    private SicmedInspectService sicmedInspectService;
//
//
//    /**
//     *   检验分类服务
//     */
//    @Autowired
//    private SicmedInspectClassService sicmedInspectClassService;
//
//    /**
//     *@Author:      ykbian
//     *@date_time:   2018/9/5 13:44
//     *@Description:  查询检验信息
//     *@param:
//    */
//    @ResponseBody
//    @RequestMapping(value = "searchInspect")
//    public BaseBean searchInspect(String parameter, String pageNo, String classId) {
//        SicmedInspectBeans sicmedInspectBeans = new SicmedInspectBeans();
//        // 传入参数判断
//        // 创建查询条件
//        SicmedInspect sicmedInspect = new SicmedInspect();
//        // 分页查询
//        Page<SicmedInspect> page = new Page<SicmedInspect>();
//        page.setPageSize(PageUtils.PAGE_SIZE);
//        if (AppParameterSimulation.isEmpty(pageNo)) {
//            pageNo = "1";
//        }
//        page.setPageNo(Integer.parseInt(pageNo));
//        sicmedInspect.setPage(page);
//        if(parameter!=null){
//            if(AppParameterSimulation.isChineseName(parameter)){
//                sicmedInspect.setInspectName(parameter);
//            }else if(AppParameterSimulation.simulationIsNumber(parameter)){
//                sicmedInspect.setInspectCode(parameter);
//            }else if(AppParameterSimulation.simulationIsPinYin(parameter)){
//                sicmedInspect.setInspectNamePY(parameter);
//            }
//        }
//        if (AppParameterSimulation.isNotEmpty(classId)) {
//            sicmedInspect.setSicmedInspectClass(sicmedInspectClassService.get(classId));
//        }
//        // 根据查询条件查询
//        List<SicmedInspect> sicmedInspects = sicmedInspectService.findListLike(sicmedInspect);
//        // 判断查询结果
//        if (sicmedInspects.size() == 0) {
//            sicmedInspectBeans.setError("1");
//            sicmedInspectBeans.setErrorMessage("查询结果为空");
//            return sicmedInspectBeans;
//        } else {
//            // 遍历查询结果
//            for (SicmedInspect sicmedInspect2 : sicmedInspects) {
//                SicmedInspectBean sicmedInspectBean = new SicmedInspectBean();
//                sicmedInspectBean.setSIB(sicmedInspect2);
//                sicmedInspectBeans.getSicmedInspectBeans().add(sicmedInspectBean);
//            }
//            sicmedInspectBeans.setError("0");
//            sicmedInspectBeans.setSuccessMessage("查询成功");
//        }
//        return sicmedInspectBeans;
//    }
//
//    /**
//     * 根据检验类别获取检验项目
//     *
//     * @param parameter
//     * @param classId
//     * @return BaseBean
//     */
//    @ResponseBody
//    @RequestMapping(value = "findInspect")
//    public BaseBean findInspect(String parameter, String classId, String pageNo) {
//        // 创建返回条件
//        SicmedInspectBeans sicmedInspectBeans = new SicmedInspectBeans();
//        // 传入参数判断
//        if (AppParameterSimulation.isEmpty(classId)) {
//            sicmedInspectBeans.setError("1");
//            sicmedInspectBeans.setErrorMessage("参数为空");
//            return sicmedInspectBeans;
//        } else if (AppParameterSimulation.simulationId(classId)) {
//            sicmedInspectBeans.setError("1");
//            sicmedInspectBeans.setErrorMessage("检验类别ID不正确");
//            return sicmedInspectBeans;
//        }
//        // 获取检验类别
//        SicmedInspectClass sicmedInspectClass = sicmedInspectClassService.get(classId);
//        // 创建查询条件
//        SicmedInspect sicmedInspect = new SicmedInspect();
//        // 创建分页条件
//        Page<SicmedInspect> page = new Page<SicmedInspect>();
//        page.setPageSize(PageUtils.PAGE_SIZE);
//        if (AppParameterSimulation.isEmpty(pageNo)) {
//            pageNo = "1";
//        }
//        page.setPageNo(Integer.parseInt(pageNo));
//        // 查询条件赋值
//        sicmedInspect.setPage(page);
//        sicmedInspect.setInspectCode(parameter);
//        sicmedInspect.setSicmedInspectClass(sicmedInspectClass);
//
//        // 调用service方法查询检验项目
//        List<SicmedInspect> sicmedInspects = sicmedInspectService.findListLike(sicmedInspect);
//        // 判断查询结果
//        if (sicmedInspects.size() == 0) {
//            sicmedInspectBeans.setError("1");
//            sicmedInspectBeans.setErrorMessage("查询结果为空");
//            return sicmedInspectBeans;
//        } else {
//            // 遍历查询结果
//            for (SicmedInspect sicmedInspect2 : sicmedInspects) {
//                SicmedInspectBean sicmedInspectBean = new SicmedInspectBean();
//                sicmedInspectBean.setSIB(sicmedInspect2);
//                sicmedInspectBeans.getSicmedInspectBeans().add(sicmedInspectBean);
//            }
//        }
//        return sicmedInspectBeans;
//    }
//}
