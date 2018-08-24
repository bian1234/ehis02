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


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedDiseaseDao;

/**
 * 疾病表Service
 *
 * @author Max
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedDiseaseService extends CrudService<SicmedDiseaseDao, SicmedDisease> {

    @Autowired
    private SicmedDiseaseDao sicmedDiseaseDao;

    @Override
    public SicmedDisease get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedDisease> findList(SicmedDisease sicmedDisease) {
        return super.findList(sicmedDisease);
    }

    /**
     * 模糊查询疾病 Service
     *
     * @param sicmedDisease
     * @return List<SicmedDisease>
     * @author Max
     */
    public List<SicmedDisease> findListLike(SicmedDisease sicmedDisease) {
        return sicmedDiseaseDao.findListLike(sicmedDisease);
    }

    @Override
    public Page<SicmedDisease> findPage(Page<SicmedDisease> page, SicmedDisease sicmedDisease) {
        return super.findPage(page, sicmedDisease);
    }

    @Override
    //模糊查询带分页web
    public Page<SicmedDisease> findPageLike(Page<SicmedDisease> page, SicmedDisease sicmedDisease) {
        return super.findPageLike(page, sicmedDisease);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedDisease sicmedDisease) {
        super.save(sicmedDisease);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedDisease sicmedDisease) {
        super.delete(sicmedDisease);
    }

    public List<SicmedDisease> findByVersion(SicmedDisease sicmedDisease) {
        // TODO Auto-generated method stub
        return sicmedDiseaseDao.findByVersion(sicmedDisease);
    }

}