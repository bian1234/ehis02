package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureClass;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedCureClassDao;

/**
 * RESTful接口示例Service
 *
 * @author DING
 * @version 2016-07-23
 */
@Service
@Transactional(readOnly = true)
public class SicmedCureClassService extends CrudService<SicmedCureClassDao, SicmedCureClass> {

    @Autowired
    private SicmedCureClassDao sicmedCureClassDao;

    @Override
    public SicmedCureClass get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedCureClass> findList(SicmedCureClass sicmedCureClass) {
        return super.findList(sicmedCureClass);
    }

    @Override
    public Page<SicmedCureClass> findPage(Page<SicmedCureClass> page, SicmedCureClass sicmedCureClass) {
        return super.findPage(page, sicmedCureClass);
    }

    @Override
    //模糊查询带分页
    public Page<SicmedCureClass> findPageLike(Page<SicmedCureClass> page, SicmedCureClass sicmedCureClass) {
        return super.findPageLike(page, sicmedCureClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedCureClass sicmedCureClass) {
        super.save(sicmedCureClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedCureClass sicmedCureClass) {
        super.delete(sicmedCureClass);
    }

    public List<SicmedCureClass> findByVersion(SicmedCureClass sicmedCureClass) {
        // TODO Auto-generated method stub
        return sicmedCureClassDao.findByVersion(sicmedCureClass);
    }

}