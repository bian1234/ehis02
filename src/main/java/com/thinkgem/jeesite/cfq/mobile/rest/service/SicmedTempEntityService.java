/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTempEntity;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedTempEntityDao;

/**
 * 病历表Service
 *
 * @author Max
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedTempEntityService extends CrudService<SicmedTempEntityDao, SicmedTempEntity> {

    @Override
    public SicmedTempEntity get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedTempEntity> findList(SicmedTempEntity sicmedTempEntity) {
        return super.findList(sicmedTempEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedTempEntity sicmedTempEntity) {
        super.save(sicmedTempEntity);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedTempEntity sicmedTempEntity) {
        super.delete(sicmedTempEntity);
    }

}