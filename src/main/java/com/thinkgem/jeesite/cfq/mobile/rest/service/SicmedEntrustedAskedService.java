/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedEntrustedAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedEntrustedAskedDao;

/**
 * 单表生成Service
 *
 * @author yjx
 * @version 2016-07-28
 */
@Service
@Transactional(readOnly = true)
public class SicmedEntrustedAskedService extends CrudService<SicmedEntrustedAskedDao, SicmedEntrustedAsked> {

    @Override
    public SicmedEntrustedAsked get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedEntrustedAsked> findList(SicmedEntrustedAsked sicmedEntrustedAsked) {
        return super.findList(sicmedEntrustedAsked);
    }

    @Override
    public Page<SicmedEntrustedAsked> findPage(Page<SicmedEntrustedAsked> page, SicmedEntrustedAsked sicmedEntrustedAsked) {
        return super.findPage(page, sicmedEntrustedAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedEntrustedAsked sicmedEntrustedAsked) {
        super.save(sicmedEntrustedAsked);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedEntrustedAsked sicmedEntrustedAsked) {
        super.delete(sicmedEntrustedAsked);
    }

}