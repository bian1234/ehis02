/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;


import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedAskedClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedClass;

import java.util.List;

/**
 * 医嘱分类编码Service
 *
 * @author XUE
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedAskedClassService extends CrudService<SicmedAskedClassDao, SicmedAskedClass> {

    @Autowired
    SicmedAskedClassDao sicmedAskedClassDao;


    @Override
    public SicmedAskedClass get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedAskedClass> findList(SicmedAskedClass sicmedAskedClass) {
        return super.findList(sicmedAskedClass);
    }

    @Override
    public Page<SicmedAskedClass> findPage(Page<SicmedAskedClass> page, SicmedAskedClass sicmedAskedClass) {
        return super.findPage(page, sicmedAskedClass);
    }

    @Override
    public Page<SicmedAskedClass> findPageLike(Page<SicmedAskedClass> page, SicmedAskedClass sicmedAskedClass) {
        return super.findPageLike(page, sicmedAskedClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedAskedClass sicmedAskedClass) {
        super.save(sicmedAskedClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedAskedClass sicmedAskedClass) {
        super.delete(sicmedAskedClass);
    }

    public SicmedAskedClass getAskedByAskedClass(String askedClass) {
        return sicmedAskedClassDao.getAskedByAskedClass(askedClass);
    }

    @Transactional(readOnly = false)
    public int update(SicmedAskedClass sicmedAskedClass) {
        return sicmedAskedClassDao.update(sicmedAskedClass);
    }

}