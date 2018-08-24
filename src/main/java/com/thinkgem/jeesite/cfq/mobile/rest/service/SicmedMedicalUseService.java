/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedMedicalUseDao;

/**
 * 单表生成Service
 *
 * @author Max
 * @version 2016-08-16
 */
@Service
@Transactional(readOnly = true)
public class SicmedMedicalUseService extends CrudService<SicmedMedicalUseDao, SicmedMedicalUse> {

    @Override
    public SicmedMedicalUse get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedMedicalUse> findList(SicmedMedicalUse sicmedMedicalUse) {
        return super.findList(sicmedMedicalUse);
    }

    @Override
    public Page<SicmedMedicalUse> findPage(Page<SicmedMedicalUse> page, SicmedMedicalUse sicmedMedicalUse) {
        return super.findPage(page, sicmedMedicalUse);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedMedicalUse sicmedMedicalUse) {
        super.save(sicmedMedicalUse);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedMedicalUse sicmedMedicalUse) {
        super.delete(sicmedMedicalUse);
    }

}