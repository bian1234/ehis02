package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectClass;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedInspectClassDao;

/**
 * RESTful接口示例Service
 *
 * @author DING
 * @version 2016-07-22
 */
@Service
@Transactional(readOnly = true)
public class SicmedInspectClassService extends CrudService<SicmedInspectClassDao, SicmedInspectClass> {

    @Autowired
    private SicmedInspectClassDao sicmedInspectClassDao;

    @Override
    public SicmedInspectClass get(String id) {
        return super.get(id);
    }

    @Override
    //通过list得到包含SicmedInspectClass的list表
    public List<SicmedInspectClass> findList(SicmedInspectClass sicmedInspectClass) {
        return super.findList(sicmedInspectClass);
    }

    @Override
    public Page<SicmedInspectClass> findPage(Page<SicmedInspectClass> page, SicmedInspectClass sicmedInspectClass) {
        return super.findPage(page, sicmedInspectClass);
    }

    @Override
    //模糊查询带分页web
    public Page<SicmedInspectClass> findPageLike(Page<SicmedInspectClass> page, SicmedInspectClass sicmedInspectClass) {
        return super.findPageLike(page, sicmedInspectClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedInspectClass sicmedInspectClass) {
        super.save(sicmedInspectClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedInspectClass sicmedInspectClass) {
        super.delete(sicmedInspectClass);
    }

    public List<SicmedInspectClass> findByVersion(SicmedInspectClass sicmedInspectClass) {
        // TODO Auto-generated method stub
        return sicmedInspectClassDao.findByVersion(sicmedInspectClass);
    }
}