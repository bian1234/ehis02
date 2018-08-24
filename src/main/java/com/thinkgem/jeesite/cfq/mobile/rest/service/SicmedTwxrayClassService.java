package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayClass;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedTwxrayClassDao;

/**
 * RESTful接口示例Service
 *
 * @author DING
 * @version 2016-07-22
 */
@Service
@Transactional(readOnly = true)
public class SicmedTwxrayClassService extends CrudService<SicmedTwxrayClassDao, SicmedTwxrayClass> {

    @Autowired
    private SicmedTwxrayClassDao sicmedTwxrayClassDao;


    @Override
    public SicmedTwxrayClass get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedTwxrayClass> findList(SicmedTwxrayClass sicmedTwxrayClass) {
        return super.findList(sicmedTwxrayClass);
    }

    @Override
    public Page<SicmedTwxrayClass> findPage(Page<SicmedTwxrayClass> page, SicmedTwxrayClass sicmedTwxrayClass) {
        return super.findPage(page, sicmedTwxrayClass);
    }


    @Override
    @Transactional(readOnly = false)
    public void save(SicmedTwxrayClass sicmedTwxrayClass) {
        super.save(sicmedTwxrayClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedTwxrayClass sicmedTwxrayClass) {
        super.delete(sicmedTwxrayClass);
    }

    public List<SicmedTwxrayClass> findByVersion(SicmedTwxrayClass sicmedTwxrayClass) {
        // TODO Auto-generated method stub
        return sicmedTwxrayClassDao.findByVersion(sicmedTwxrayClass);
    }

}