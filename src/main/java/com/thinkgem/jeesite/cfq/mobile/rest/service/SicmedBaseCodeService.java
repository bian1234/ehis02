/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBaseCode;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedBaseCodeDao;

/**
 * 基础编码表Service
 *
 * @author Max
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedBaseCodeService extends CrudService<SicmedBaseCodeDao, SicmedBaseCode> {


    @Override
    public SicmedBaseCode get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedBaseCode> findList(SicmedBaseCode sicmedBaseCode) {
        return super.findList(sicmedBaseCode);
    }

    @Override
    public Page<SicmedBaseCode> findPage(Page<SicmedBaseCode> page, SicmedBaseCode sicmedBaseCode) {
        return super.findPage(page, sicmedBaseCode);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedBaseCode sicmedBaseCode) {
        super.save(sicmedBaseCode);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedBaseCode sicmedBaseCode) {
        super.delete(sicmedBaseCode);
    }

}