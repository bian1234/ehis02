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

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInviteNumber;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedInviteNumberDao;

/**
 * 账号激活码Service
 *
 * @author Max
 * @version 2016-07-19
 */
@Service
@Transactional(readOnly = true)
public class SicmedInviteNumberService extends CrudService<SicmedInviteNumberDao, SicmedInviteNumber> {

    @Autowired
    private SicmedInviteNumberDao sicmedInviteNumberDao;

    @Override
    public SicmedInviteNumber get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedInviteNumber> findList(SicmedInviteNumber sicmedInviteNumber) {
        return super.findList(sicmedInviteNumber);
    }

    @Override
    public Page<SicmedInviteNumber> findPage(Page<SicmedInviteNumber> page, SicmedInviteNumber sicmedInviteNumber) {
        return super.findPage(page, sicmedInviteNumber);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedInviteNumber sicmedInviteNumber) {
        super.save(sicmedInviteNumber);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedInviteNumber sicmedInviteNumber) {
        super.delete(sicmedInviteNumber);
    }

    public SicmedInviteNumber getByEntity(SicmedInviteNumber sicmedInviteNumber) {
        return sicmedInviteNumberDao.getByEntity(sicmedInviteNumber);
    }

    @Transactional(readOnly = false)
    public void update(SicmedInviteNumber sicmedInviteNumber) {
        sicmedInviteNumberDao.update(sicmedInviteNumber);
    }
}