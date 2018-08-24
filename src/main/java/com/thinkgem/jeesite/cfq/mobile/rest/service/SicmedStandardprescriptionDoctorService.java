/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStandardprescriptionDoctor;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedStandardprescriptionDoctorDao;

/**
 * 医生常用疾病表Service
 *
 * @author Max
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedStandardprescriptionDoctorService extends CrudService<SicmedStandardprescriptionDoctorDao, SicmedStandardprescriptionDoctor> {

    @Autowired
    private SicmedStandardprescriptionDoctorDao sicmedStandardprescriptionDoctorDao;
    @Override
    public SicmedStandardprescriptionDoctor get(String id) {
        return super.get(id);
    }

    //通过医生id查找医嘱
    public List<SicmedStandardprescriptionDoctor> getDoctorid(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor) {
        return sicmedStandardprescriptionDoctorDao.getDoctorid(sicmedStandardprescriptionDoctor);
    }
    @Override
    public List<SicmedStandardprescriptionDoctor> findList(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor) {
        return super.findList(sicmedStandardprescriptionDoctor);
    }
    @Override
    public Page<SicmedStandardprescriptionDoctor> findPage(Page<SicmedStandardprescriptionDoctor> page, SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor) {
        return super.findPage(page, sicmedStandardprescriptionDoctor);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor) {
        super.save(sicmedStandardprescriptionDoctor);
    }
    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor) {
        super.delete(sicmedStandardprescriptionDoctor);
    }

}