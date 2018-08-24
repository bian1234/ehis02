package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedWord;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedWordDao;

@Service
@Transactional(readOnly = true)
public class SicmedWordService extends CrudService<SicmedWordDao, SicmedWord> {

    @Autowired
    private SicmedWordDao sicmedWordDao;

    @Override
    public SicmedWord get(String id) {
        return super.get(id);
    }


    @Override
    public List<SicmedWord> findList(SicmedWord sicmedWord) {

        return super.findList(sicmedWord);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedWord sicmedWord) {
        super.save(sicmedWord);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedWord sicmedWord) {
        super.delete(sicmedWord);
    }


    @Transactional(readOnly = false)
    public void update(SicmedWord SicmedWord) {
        sicmedWordDao.update(SicmedWord);
    }


}