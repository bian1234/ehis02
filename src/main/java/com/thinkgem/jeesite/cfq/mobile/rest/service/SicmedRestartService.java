/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRestart;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedRestartDao;

/**
 * 医嘱信息Service
 *
 * @author XUE
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedRestartService extends CrudService<SicmedRestartDao, SicmedRestart> {

    @Autowired
    private SicmedPatientPriceService sicmedPatientPriceService; //患者价格表

    @Autowired
    private SicmedPatientService sicmedPatientService;            //患者表

    @Autowired
    private SicmedAskedService sicmedAskedService;        //医嘱表

    @Autowired
    private SicmedCaseService sicmedCaseService;        //病历表

    @Autowired
    private SicmedRegisteredService sicmedRegisteredService;        //挂号表

    //对数据表进行操作 进行
    @Transactional
    public void clearJDBC() {
        DateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//设置日期格式
        String nowDate = df.format(new Date());
        //清空患者价格表
        sicmedPatientPriceService.clearTable(nowDate + "sicmed_patient_price");
        //清空患者表
        sicmedPatientService.clearTable(nowDate + "sicmed_patient");
        //清空医嘱表
        sicmedAskedService.clearTable(nowDate + "sicmed_asked");
        //清空病历表
        sicmedCaseService.clearTable(nowDate + "sicmed_case");
        //清空挂号表
        sicmedRegisteredService.clearTable(nowDate + "sicmed_registered");
    }

}