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
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCity;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedCityDao;

/**
 * 单表生成Service
 *
 * @author Max
 * @version 2016-08-10
 */
@Service
@Transactional(readOnly = true)
public class SicmedCityService extends CrudService<SicmedCityDao, SicmedCity> {

    @Autowired
    private SicmedCityDao sicmedCityDao;

    @Override
    public SicmedCity get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedCity> findList(SicmedCity sicmedCity) {
        return super.findList(sicmedCity);
    }

    @Override
    public Page<SicmedCity> findPage(Page<SicmedCity> page, SicmedCity sicmedCity) {
        return super.findPage(page, sicmedCity);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedCity sicmedCity) {
        super.save(sicmedCity);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedCity sicmedCity) {
        super.delete(sicmedCity);
    }

    public SicmedCity getById(String id) {

        return sicmedCityDao.getById(Integer.parseInt(id));
    }

}