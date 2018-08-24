/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedMedicalAskedDao;

/**
 * 医嘱患者中间表Service
 *
 * @author 丁学志
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedMedicalAskedService extends CrudService<SicmedMedicalAskedDao, SicmedMedicalAsked> {

    @Override
    public SicmedMedicalAsked get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedMedicalAsked> findList(SicmedMedicalAsked sicmedMedicalAsked) {
        return super.findList(sicmedMedicalAsked);
    }

    @Override
    public Page<SicmedMedicalAsked> findPage(Page<SicmedMedicalAsked> page, SicmedMedicalAsked sicmedMedicalAsked) {
        return super.findPage(page, sicmedMedicalAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedMedicalAsked sicmedMedicalAsked) {
        super.save(sicmedMedicalAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedMedicalAsked sicmedMedicalAsked) {
        super.delete(sicmedMedicalAsked);
    }

}