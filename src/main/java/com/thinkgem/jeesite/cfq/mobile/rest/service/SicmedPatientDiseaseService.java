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


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientDisease;

import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedPatientDiseaseDao;

/**
 * 患者疾病表Service
 *
 * @author XUE
 * @version 2016-07-20
 */
@Service
@Transactional(readOnly = true)


public class SicmedPatientDiseaseService extends CrudService<SicmedPatientDiseaseDao, SicmedPatientDisease> {

    @Autowired
    private SicmedPatientDiseaseDao sicmedPatientDiseaseDao;

    @Override
    public SicmedPatientDisease get(String id) {
        return super.get(id);
    }

    public SicmedPatientDisease getOnly(SicmedPatientDisease sicmedPatientDisease) {
        return sicmedPatientDiseaseDao.getOnly(sicmedPatientDisease);
    }

    //通过医生id查询患者疾病信息
    public List<SicmedPatientDisease> getDoctorId(String id) {
        return sicmedPatientDiseaseDao.getDoctorId(id);
    }

    @Override
    public List<SicmedPatientDisease> findList(SicmedPatientDisease sicmedPatientDisease) {
        return super.findList(sicmedPatientDisease);
    }

    @Override
    public Page<SicmedPatientDisease> findPage(Page<SicmedPatientDisease> page, SicmedPatientDisease sicmedPatientDisease) {
        return super.findPage(page, sicmedPatientDisease);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedPatientDisease sicmedPatientDisease) {
        super.save(sicmedPatientDisease);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedPatientDisease sicmedPatientDisease) {
        super.delete(sicmedPatientDisease);
    }

}