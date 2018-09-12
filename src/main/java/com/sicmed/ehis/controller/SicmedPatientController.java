package com.sicmed.ehis.controller;

import com.sicmed.ehis.base.BaseController;
import com.sicmed.ehis.base.Constant;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.AppParameterSimulation;
import com.sicmed.ehis.entity.*;
import com.sicmed.ehis.service.SicmedPatientPriceService;
import com.sicmed.ehis.service.SicmedPatientService;
import com.sicmed.ehis.service.SicmedRegisteredService;
import com.sicmed.ehis.service.SicmedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/11 15:18
 * @Todo:   患者管理
 */
@Controller
@RequestMapping(value = "/rest/sicmedPatient")
public class SicmedPatientController   extends BaseController {



    @Autowired
    private SicmedPatientService sicmedPatientService;

    @Autowired
    private SicmedRegisteredService sicmedRegisteredService;

    @Autowired
    private SicmedUserService sicmedUserService;

    @Autowired
    private SicmedPatientPriceService sicmedPatientPriceService;
    /**
     *@Author:      ykbian
     *@date_time:   2018/9/11 15:29
     *@Description:  查询可以退号的患者
    */
    @ResponseBody
    @GetMapping(value = "findCanReturn")
    public Map findCanReturn() {
        List<SicmedPatient> sicmedPatients = new ArrayList<>();
        // 创建查询对象
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 查询对象赋值
        sicmedRegistered.setRegisteredStatus(Constant.PATIENT_REGISTERED_RETURN);
        // 调用 service 查询 挂号信息
        List<SicmedRegistered> sicmedRegistereds = sicmedRegisteredService.findRefuntOrChange(sicmedRegistered);
        // 查询结果校验 处理
        if (sicmedRegistereds.isEmpty()) {
            return queryEmptyResponse();
        }
        for (SicmedRegistered sr : sicmedRegistereds) {
            // 获取挂号患者信息
            SicmedPatient sicmedPatient = sicmedPatientService.selectById(sr.getPatientCode());
            sicmedPatients.add(sicmedPatient);
        }
        return querySuccessResponse(sicmedPatients);

    }

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/11 15:29
     *@Description:  查询可以改号的患者
     */
    @ResponseBody
    @GetMapping(value = "findCanExchange")
    public Map findCanExchange() {
        List<SicmedPatient> sicmedPatients = new ArrayList<>();
        // 创建查询对象
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        // 查询对象赋值
        sicmedRegistered.setRegisteredStatus(Constant.PATIENT_REGISTERED_EXCHANGE);
        // 调用 service 查询 挂号信息
        List<SicmedRegistered> sicmedRegistereds = sicmedRegisteredService.findRefuntOrChange(sicmedRegistered);
        // 查询结果校验 处理
        if (sicmedRegistereds.isEmpty()) {
            return queryEmptyResponse();
        }
        for (SicmedRegistered sr : sicmedRegistereds) {
            // 获取挂号患者信息
            SicmedPatient sicmedPatient = sicmedPatientService.selectById(sr.getPatientCode());
            sicmedPatients.add(sicmedPatient);
        }
        return querySuccessResponse(sicmedPatients);

    }


    /**
     * 缺pc查询可以改号的患者信息
     *
     * 缺pc查询可以退号的患者信息
     *
     * *****这两个方法貌似是分页之前的查询方法加了分页参数
     *
     */

    /**
     *@Author:      ykbian
     *@date_time:   2018/9/11 16:59
     *@Description: 医生查询可以在本科室就诊的患者
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "findAllCheckPatient")
    public Map findAllCheckPatient(Integer offset,Integer limit) {
        List<SicmedPatient> sicmedPatients = new ArrayList<>();
        Query query = new Query(offset,limit);
        /**
         *   获取当前登录医生的用户信息
         */
        String userId = "0153de93336b4f9083ced23d043927fc";    //这是假数据，需要替换成当前登录的医生信息

        // 根据医生信息获取部门信息
        SicmedUser  sicmedUser= sicmedUserService.selectById(userId);
        //如果用户信息错误，直接返回。不用处理异常信息。
        if (sicmedUser == null){
            return queryEmptyResponse();
        }
        String branchId = sicmedUser.getUserBranch();
        // 根据部门信息获取挂号信息
        SicmedRegistered sicmedRegistered = new SicmedRegistered();
        sicmedRegistered.setBranchCode(branchId);
        List<SicmedRegistered> sicmedRegistereds= sicmedRegisteredService.selectALLByParams(sicmedRegistered,query);
        //根据挂号信息查询患者信息
        if (!sicmedRegistereds.isEmpty()){
            for (SicmedRegistered sicmedRegistered1:sicmedRegistereds) {
                SicmedPatient patient = sicmedPatientService.selectById(sicmedRegistered1.getPatientCode());
                sicmedPatients.add(patient);
            }
            return querySuccessResponse(sicmedPatients);
        }
        return queryEmptyResponse();
    }
//    /**
//     *@Author:      ykbian
//     *@date_time:   2018/9/11 17:27
//     *@Description:  医生模糊查询患者信息 ，返回的是医生所在科室的所有挂号患者
//     *@param:
//    */
//    @ResponseBody
//    @RequestMapping(value = "getByParam")
//    public Map getByParam(String param) {
//        /**
//         *  获取当前登录对象也就是医生的身份信息
//         */
//        String userId = "0153de93336b4f9083ced23d043927fc";    //这是假数据，需要替换成当前登录的医生信息
//
//
//
//
//        List<SicmedPatient> sicmedPatients = new ArrayList<>();
//        //校验参数类型
//        SicmedPatient sicmedPatient = new SicmedPatient();
//        if (AppParameterSimulation.simulationIsNumber(param)) {
//            // 如果是编号
//            sicmedPatient.setPatientNumber(param);
//        } else if (AppParameterSimulation.isChineseName(param)) {
//            // 如果是姓名
//            sicmedPatient.setPatientName(param);
//        } else {
//            //参数不正确的话直接返回查询失败
//            return queryEmptyResponse();
//        }
//        //1  根据医生信息查询其科室信息
//        SicmedUser  sicmedUser= sicmedUserService.selectById(userId);
//        //如果用户信息错误，直接返回。不用处理异常信息。
//        if (sicmedUser == null){
//            return queryEmptyResponse();
//        }
//        String branchId = sicmedUser.getUserBranch();
//        //2  根据前端参数查询这个科室中的所有挂号信息
//        // 根据部门信息获取挂号信息
//        SicmedRegistered sicmedRegistered = new SicmedRegistered();
//        sicmedRegistered.setBranchCode(branchId);
//        //查询挂号信息时查出所有的数据，之后根据传入的参数进行筛查
//        List<SicmedRegistered> sicmedRegistereds= sicmedRegisteredService.selectALLByParams(sicmedRegistered,null);
//        //根据挂号信息查询患者信息
//        if (!sicmedRegistereds.isEmpty()){
//            for (SicmedRegistered sicmedRegistered1:sicmedRegistereds) {
//                sicmedPatient.setId(sicmedRegistered1.getPatientCode());
//                SicmedPatient patient = sicmedPatientService.selectById();
//                sicmedPatients.add(patient);
//            }
//            return querySuccessResponse(sicmedPatients);
//        }
//
//    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/11 17:27
     *@Description:  收费退费查询患者信息
     *@param:
    */
    @ResponseBody
    @RequestMapping(value = "getByParams")
    public Map getByParams(String param,String isPay,Integer offset,Integer limit) {
        // 创建查询条件
        SicmedPatient sicmedPatient = new SicmedPatient();
        Query query = new Query(offset,limit);
        if (AppParameterSimulation.simulationIsNumber(param)) {
            // 查询条件赋值
            sicmedPatient.setPatientNumber(param);
        } else if (AppParameterSimulation.isChineseName(param)) {
            // 查询条件赋值
            sicmedPatient.setPatientName(param);
        } else {
            //参数错误直接返回
           return queryEmptyResponse();
        }
        //调用service方法查询患者信息
        List<SicmedPatient> sicmedPatients = sicmedPatientService.selectALLByParams(sicmedPatient,query);
        if (!sicmedPatients.isEmpty()) {
            for (SicmedPatient patient : sicmedPatients) {
                List<SicmedPatientPrice> sicmedPatientPrices = sicmedPatientPriceService.getByPatientAndPay(patient.getId(),isPay);
                patient.setSicmedPatientPrice(sicmedPatientPrices);
            }
            return querySuccessResponse(sicmedPatients);
        }
        return queryEmptyResponse();
    }


    /**
     *@Author:      ykbian
     *@date_time:   2018/9/11 17:00
     *@Description: 根据id查询患者信息
     *@param:
    */
    @ResponseBody
    @GetMapping(value = "selectById")
    public Map selectById(String patientId) {
        SicmedPatient sicmedPatient = sicmedPatientService.selectById(patientId);
        if (sicmedPatient == null){
            return queryEmptyResponse();
        }
        return querySuccessResponse(sicmedPatient);
    }
}
