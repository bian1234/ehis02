/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedDiseaseBranchDao;

/**
 * 科室常用疾病表Service
 *
 * @author Max
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedDiseaseBranchService extends CrudService<SicmedDiseaseBranchDao, SicmedDiseaseBranch> {

    @Override
    public SicmedDiseaseBranch get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedDiseaseBranch> findList(SicmedDiseaseBranch sicmedDiseaseBranch) {
        return super.findList(sicmedDiseaseBranch);
    }

    @Override
    public Page<SicmedDiseaseBranch> findPage(Page<SicmedDiseaseBranch> page, SicmedDiseaseBranch sicmedDiseaseBranch) {
        return super.findPage(page, sicmedDiseaseBranch);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedDiseaseBranch sicmedDiseaseBranch) {
        super.save(sicmedDiseaseBranch);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedDiseaseBranch sicmedDiseaseBranch) {
        super.delete(sicmedDiseaseBranch);
    }

}