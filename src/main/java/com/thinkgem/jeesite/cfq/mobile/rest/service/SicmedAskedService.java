/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedAskedDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 医嘱信息Service
 *
 * @author XUE
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedAskedService extends CrudService<SicmedAskedDao, SicmedAsked> {

    @Autowired
    SicmedAskedDao sicmedAskedDao;

    @Override
    public SicmedAsked get(String id) {
        return super.get(id);
    }

    //根据医嘱类别找到医嘱
    public List<SicmedAsked> getAskedClass(String askedClass) {
        return sicmedAskedDao.getAskedbyClass(askedClass);
    }

    @Override
    public List<SicmedAsked> findList(SicmedAsked sicmedAsked) {
        return super.findList(sicmedAsked);
    }

    @Override
    public Page<SicmedAsked> findPage(Page<SicmedAsked> page, SicmedAsked sicmedAsked) {
        return super.findPage(page, sicmedAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedAsked sicmedAsked) {
        super.save(sicmedAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedAsked sicmedAsked) {
        super.delete(sicmedAsked);
    }

    public SicmedAsked findaskedByaskedClass(String askedClass) {
        return sicmedAskedDao.findaskedByaskedClass(askedClass);
    }

    @Transactional(readOnly = false)
    public void update(SicmedAsked sicmedAsked) {
        sicmedAskedDao.update(sicmedAsked);
    }

    @Transactional(readOnly = false)
    public SicmedAsked getById(String id) {
        return sicmedAskedDao.getById(id);
    }

    //复制数据表 表结构和表中数据 复制 清空原表
    @Transactional(readOnly = false)
    public void clearTable(String copyName) {
        SicmedAsked sicmedAsked = new SicmedAsked();
        sicmedAsked.setCopyTableName(copyName);
        sicmedAskedDao.copyTable(sicmedAsked);
        sicmedAskedDao.insertTable(sicmedAsked);
        sicmedAskedDao.clearTable();
        //patientPriceDao.clearTable();
    }


    public SicmedAsked getOnly(SicmedAsked sicmedAsked) {
        return sicmedAskedDao.getOnly(sicmedAsked);
    }
}