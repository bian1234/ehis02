/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDoctorAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedDoctorAskedDao;

/**
 * 医生常用医嘱Service
 *
 * @author XUE
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedDoctorAskedService extends CrudService<SicmedDoctorAskedDao, SicmedDoctorAsked> {

    @Override
    public SicmedDoctorAsked get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedDoctorAsked> findList(SicmedDoctorAsked sicmedDoctorAsked) {
        return super.findList(sicmedDoctorAsked);
    }

    @Override
    public Page<SicmedDoctorAsked> findPage(Page<SicmedDoctorAsked> page, SicmedDoctorAsked sicmedDoctorAsked) {
        return super.findPage(page, sicmedDoctorAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedDoctorAsked sicmedDoctorAsked) {
        super.save(sicmedDoctorAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedDoctorAsked sicmedDoctorAsked) {
        super.delete(sicmedDoctorAsked);
    }

}