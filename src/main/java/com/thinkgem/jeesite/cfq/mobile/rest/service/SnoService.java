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
import com.thinkgem.jeesite.cfq.mobile.rest.entity.Sno;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SnoDao;

/**
 * 单表生成Service
 *
 * @author Max
 * @version 2016-08-12
 */
@Service
@Transactional(readOnly = true)
public class SnoService extends CrudService<SnoDao, Sno> {

    @Autowired
    private SnoDao snoDao;

    @Override
    public Sno get(String id) {
        return super.get(id);
    }

    @Override
    public List<Sno> findList(Sno sno) {
        return super.findList(sno);
    }

    @Override
    public Page<Sno> findPage(Page<Sno> page, Sno sno) {
        return super.findPage(page, sno);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(Sno sno) {
        super.save(sno);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Sno sno) {
        super.delete(sno);
    }

    @Transactional(readOnly = false)
    public int update(Sno sno) {
        return snoDao.update(sno);

    }

}