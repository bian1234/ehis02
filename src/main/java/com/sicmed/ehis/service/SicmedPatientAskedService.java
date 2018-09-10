package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.entity.SicmedPatientAsked;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 11:39
 * @Todo:   患者医嘱表
 */
public interface SicmedPatientAskedService  extends BaseService<SicmedPatientAsked> {

    @Override
    SicmedPatientAsked selectById(String id);

    List<SicmedPatientAsked> getByPatient(String patientId, String askedClass);
}
