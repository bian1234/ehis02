/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;


import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAskedBranch;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedAskedBranchDao;

import java.util.List;

/**
 * 医嘱传送部门Service
 *
 * @author XUE
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedAskedBranchService extends CrudService<SicmedAskedBranchDao, SicmedAskedBranch> {

    @Override
    public SicmedAskedBranch get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedAskedBranch> findList(SicmedAskedBranch sicmedAskedBranch) {
        return super.findList(sicmedAskedBranch);
    }

    @Override
    public Page<SicmedAskedBranch> findPage(Page<SicmedAskedBranch> page, SicmedAskedBranch sicmedAskedBranch) {
        return super.findPage(page, sicmedAskedBranch);
    }

    @Transactional(readOnly = false)
    public void save(SicmedAskedBranch sicmedAskedBranch) {
        super.save(sicmedAskedBranch);
    }

    @Transactional(readOnly = false)
    public void delete(SicmedAskedBranch sicmedAskedBranch) {
        super.delete(sicmedAskedBranch);
    }

}