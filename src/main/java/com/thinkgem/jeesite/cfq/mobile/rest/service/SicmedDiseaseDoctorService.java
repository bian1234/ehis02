/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseDoctor;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedDiseaseDoctorDao;

/**
 * 医生常用疾病表Service
 *
 * @author Max
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedDiseaseDoctorService extends CrudService<SicmedDiseaseDoctorDao, SicmedDiseaseDoctor> {

    @Override
    public SicmedDiseaseDoctor get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedDiseaseDoctor> findList(SicmedDiseaseDoctor sicmedDiseaseDoctor) {
        return super.findList(sicmedDiseaseDoctor);
    }

    @Override
    public Page<SicmedDiseaseDoctor> findPage(Page<SicmedDiseaseDoctor> page, SicmedDiseaseDoctor sicmedDiseaseDoctor) {
        return super.findPage(page, sicmedDiseaseDoctor);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedDiseaseDoctor sicmedDiseaseDoctor) {
        super.save(sicmedDiseaseDoctor);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedDiseaseDoctor sicmedDiseaseDoctor) {
        super.delete(sicmedDiseaseDoctor);
    }

}