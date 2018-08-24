/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDept;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedDeptDao;

/**
 * 部门信息表Service
 *
 * @author Max
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedDeptService extends CrudService<SicmedDeptDao, SicmedDept> {

    @Override
    public SicmedDept get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedDept> findList(SicmedDept sicmedDept) {
        return super.findList(sicmedDept);
    }

    @Override
    public Page<SicmedDept> findPage(Page<SicmedDept> page, SicmedDept sicmedDept) {
        return super.findPage(page, sicmedDept);
    }

    @Override
    //模糊查询带分页web
    public Page<SicmedDept> findPageLike(Page<SicmedDept> page, SicmedDept sicmedDept) {
        return super.findPageLike(page, sicmedDept);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedDept sicmedDept) {
        super.save(sicmedDept);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedDept sicmedDept) {
        super.delete(sicmedDept);
    }

}