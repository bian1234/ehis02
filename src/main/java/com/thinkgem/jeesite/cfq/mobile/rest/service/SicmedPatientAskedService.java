/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedPatientAskedDao;

/**
 * 患者医嘱表Service
 *
 * @author XUE
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedPatientAskedService extends CrudService<SicmedPatientAskedDao, SicmedPatientAsked> {

    @Autowired
    private SicmedPatientAskedDao sicmedPatientAskedDao;


    @Override
    public SicmedPatientAsked get(String id) {
        return super.get(id);
    }

    /**
     * 添加患者医嘱信息
     */
    public SicmedPatientAsked addPatientAsked(String patientId, String askedCode, String medicalId) {
        SicmedPatientAsked sicmedPatientAsked = new SicmedPatientAsked();
        sicmedPatientAsked = sicmedPatientAskedDao.addPatientAsked(patientId, askedCode, medicalId);
        return sicmedPatientAsked;
    }

    @Override
    public List<SicmedPatientAsked> findList(SicmedPatientAsked sicmedPatientAsked) {
        return super.findList(sicmedPatientAsked);
    }

    @Override
    public Page<SicmedPatientAsked> findPage(Page<SicmedPatientAsked> page, SicmedPatientAsked sicmedPatientAsked) {
        return super.findPage(page, sicmedPatientAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedPatientAsked sicmedPatientAsked) {
        super.save(sicmedPatientAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedPatientAsked sicmedPatientAsked) {
        super.delete(sicmedPatientAsked);
    }

    //通过患者医嘱对象查询患者集合
    public List<SicmedPatientAsked> findPatientAsked(SicmedPatientAsked sicmedPatientAsked) {
        return sicmedPatientAskedDao.findPatientAsked(sicmedPatientAsked);
    }


}