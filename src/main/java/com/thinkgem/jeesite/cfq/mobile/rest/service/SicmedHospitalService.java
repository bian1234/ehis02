/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedHospital;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedHospitalDao;

/**
 * 单表生成Service
 *
 * @author Max
 * @version 2016-08-10
 */
@Service
@Transactional(readOnly = true)
public class SicmedHospitalService extends CrudService<SicmedHospitalDao, SicmedHospital> {

    @Override
    public SicmedHospital get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedHospital> findList(SicmedHospital sicmedHospital) {
        return super.findList(sicmedHospital);
    }

    @Override
    public Page<SicmedHospital> findPage(Page<SicmedHospital> page, SicmedHospital sicmedHospital) {
        return super.findPage(page, sicmedHospital);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedHospital sicmedHospital) {
        super.save(sicmedHospital);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedHospital sicmedHospital) {
        super.delete(sicmedHospital);
    }

}