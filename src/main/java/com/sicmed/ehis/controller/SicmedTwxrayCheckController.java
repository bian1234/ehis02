//package com.sicmed.ehis.controller;
//
//import com.sicmed.ehis.base.BaseController;
//import com.sicmed.ehis.base.util.AppParameterSimulation;
//import com.sicmed.ehis.entity.SicmedTwxrayCheck;
//import com.sicmed.ehis.service.SicmedTwxrayCheckService;
//import com.sicmed.ehis.service.SicmedTwxrayClassService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
///**
// * @Author: ykbian
// * @Date: 2018/9/6 16:50
// * @Todo:   放射线检查
// */
//@Controller
//@RequestMapping(value = "/rest/sicmedTwxrayCheck")
//public class SicmedTwxrayCheckController extends BaseController{
//
//
//    @Autowired
//    private SicmedTwxrayCheckService sicmedTwxrayCheckService;
//
//    @Autowired
//    private SicmedTwxrayClassService sicmedTwxrayClassService;
//
//
//    /**
//     * 检查搜索接
//     *
//     * @author Max
//     * @param parameter(编码;名称;拼音缩写)
//     * @return BaseBean
//     */
//    @ResponseBody
//    @RequestMapping(value = "searchCheck")
//    public SicmedTwxrayCheckBeans searchAllCheck(String parameter, String classId, String pageNo) {
//        // 创建查询条件对象
//        SicmedTwxrayCheck sicmedTwxrayCheck = new SicmedTwxrayCheck();
//        //判断传入的参数类型
//        if (parameter != null) {
//            if (AppParameterSimulation.isChineseName(parameter)) {
//                sicmedTwxrayCheck.setCheckName(parameter);
//            } else if (AppParameterSimulation.simulationIsNumber(parameter)) {
//                sicmedTwxrayCheck.setCheckCode(parameter);
//            } else if (AppParameterSimulation.simulationIsPinYin(parameter)) {
//                sicmedTwxrayCheck.setCheckNamePy(parameter);
//            }
//        }
//
//
//
//        // 创建返回对象
//        SicmedTwxrayCheckBeans sicmedTwxrayCheckBeans = new SicmedTwxrayCheckBeans();
//        // 传入参数校验
//        // 创建查询条件对象
//        SicmedTwxrayCheck sicmedTwxrayCheck = new SicmedTwxrayCheck();
//
//        // 创建分页查询条件
//        Page<SicmedTwxrayCheck> page = new Page<SicmedTwxrayCheck>();
//        page.setPageSize(PageUtils.PAGE_SIZE);
//        if (AppParameterSimulation.isEmpty(pageNo)) {
//            pageNo = "1";
//        }
//        page.setPageNo(Integer.parseInt(pageNo));
//        sicmedTwxrayCheck.setPage(page);
//        if (parameter != null) {
//            if (AppParameterSimulation.isChineseName(parameter)) {
//                sicmedTwxrayCheck.setCheckName(parameter);
//            } else if (AppParameterSimulation.simulationIsNumber(parameter)) {
//                sicmedTwxrayCheck.setCheckCode(parameter);
//            } else if (AppParameterSimulation.simulationIsPinYin(parameter)) {
//                sicmedTwxrayCheck.setCheckNamePY(parameter);
//            }
//        }
//        if (AppParameterSimulation.isNotEmpty(classId)) {
//            // 获取检查类别
//            SicmedTwxrayClass sicmedTwxrayClass = sicmedTwxrayClassService.get(classId);
//            sicmedTwxrayCheck.setSicmedTwxrayClass(sicmedTwxrayClass);
//        }
//        // 根据查询条件查询检查项目信息
//        List<SicmedTwxrayCheck> sicmedTwxrayChecks = sicmedTwxrayCheckService.findListLike(sicmedTwxrayCheck);
//        // 判断查询结果
//        if (sicmedTwxrayChecks.size() == 0) {
//            sicmedTwxrayCheckBeans.setError("1");
//            sicmedTwxrayCheckBeans.setErrorMessage("查询结果为空");
//            return sicmedTwxrayCheckBeans;
//        } else {
//            // 遍历查询结果
//            sicmedTwxrayCheckBeans.setError("0");
//            sicmedTwxrayCheckBeans.setErrorMessage("查询成功");
//            for (SicmedTwxrayCheck sicmedTwxrayCheck2 : sicmedTwxrayChecks) {
//                SicmedTwxrayCheckBean sicmedTwxrayCheckBean = new SicmedTwxrayCheckBean();
//                sicmedTwxrayCheckBean.setSTCB(sicmedTwxrayCheck2);
//                sicmedTwxrayCheckBeans.getTwxrayCheckBeanList().add(sicmedTwxrayCheckBean);
//            }
//        }
//        return sicmedTwxrayCheckBeans;
//    }
//
////    /**
////     * 根据类别 获取检查项目
////     *
////     * @param parameter
////     * @param classId
////     * @return
////     */
////    @ResponseBody
////    @RequestMapping(value = "findCheck")
////    public SicmedTwxrayCheckBeans findCheck(String parameter, String classId, String pageNo) {
////
////        //根据classId 查询到检查类别
////
////
////
////
////
////
////
////
////
////        // 创建返回对象
////        SicmedTwxrayCheckBeans sicmedTwxrayCheckBeans = new SicmedTwxrayCheckBeans();
////        // 传入参数校验
////        if (AppParameterSimulation.isEmpty(classId)) {
////            sicmedTwxrayCheckBeans.setError("1");
////            sicmedTwxrayCheckBeans.setErrorMessage("参数不能为空");
////            return sicmedTwxrayCheckBeans;
////        } else if (AppParameterSimulation.simulationId(classId)) {
////            sicmedTwxrayCheckBeans.setError("1");
////            sicmedTwxrayCheckBeans.setErrorMessage("类别ID不正确");
////            return sicmedTwxrayCheckBeans;
////        }
////        // 获取检查类别
////        SicmedTwxrayClass sicmedTwxrayClass = new SicmedTwxrayClass();
////        sicmedTwxrayClass.setId(classId);
////        sicmedTwxrayClass = sicmedTwxrayClassService.get(sicmedTwxrayClass);
////        // 创建查询条件对象
////        SicmedTwxrayCheck sicmedTwxrayCheck = new SicmedTwxrayCheck();
////        // 创建分页查询条件
////        Page<SicmedTwxrayCheck> page = new Page<SicmedTwxrayCheck>();
////        page.setPageSize(PageUtils.PAGE_SIZE);
////        if (AppParameterSimulation.isEmpty(pageNo)) {
////            pageNo = "1";
////        }
////        page.setPageNo(Integer.parseInt(pageNo));
////        // 查询条件赋值
////        sicmedTwxrayCheck.setPage(page);
////        sicmedTwxrayCheck.setCheckCode(parameter);
////        sicmedTwxrayCheck.setSicmedTwxrayClass(sicmedTwxrayClass);
////        // 调用service方法查询检查信息
////        List<SicmedTwxrayCheck> sicmedTwxrayChecks = sicmedTwxrayCheckService.findListLike(sicmedTwxrayCheck);
////        // 判断查询结果
////        if (sicmedTwxrayChecks.size() == 0) {
////            sicmedTwxrayCheckBeans.setError("1");
////            sicmedTwxrayCheckBeans.setErrorMessage("查询结果为空");
////            return sicmedTwxrayCheckBeans;
////        } else {
////            // 遍历查询结果
////            sicmedTwxrayCheckBeans.setError("0");
////            sicmedTwxrayCheckBeans.setErrorMessage("查询成功");
////            for (SicmedTwxrayCheck sicmedTwxrayCheck2 : sicmedTwxrayChecks) {
////                SicmedTwxrayCheckBean sicmedTwxrayCheckBean = new SicmedTwxrayCheckBean();
////                sicmedTwxrayCheckBean.setSTCB(sicmedTwxrayCheck2);
////                sicmedTwxrayCheckBeans.getTwxrayCheckBeanList().add(sicmedTwxrayCheckBean);
////            }
////        }
////        return sicmedTwxrayCheckBeans;
////    }
//}
