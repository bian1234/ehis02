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
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedBranchDao;

/**
 * 科室信息表Service
 *
 * @author Max
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedBranchService extends CrudService<SicmedBranchDao, SicmedBranch> {

//	@Autowired
//	private SicmedBranchDao sicmedBranchDao;


    @Override
    public SicmedBranch get(String id) {
        return super.get(id);
    }


    @Override
    public List<SicmedBranch> findList(SicmedBranch sicmedBranch) {
        return super.findList(sicmedBranch);
    }


    @Override
    public Page<SicmedBranch> findPage(Page<SicmedBranch> page, SicmedBranch sicmedBranch) {
        return super.findPage(page, sicmedBranch);
    }


    @Override
    //模糊查询带分页web
    public Page<SicmedBranch> findPageLike(Page<SicmedBranch> page, SicmedBranch sicmedBranch) {
        return super.findPageLike(page, sicmedBranch);
    }


    @Override
    @Transactional(readOnly = false)
    public void save(SicmedBranch sicmedBranch) {
        super.save(sicmedBranch);
    }


    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedBranch sicmedBranch) {
        super.delete(sicmedBranch);
    }

}