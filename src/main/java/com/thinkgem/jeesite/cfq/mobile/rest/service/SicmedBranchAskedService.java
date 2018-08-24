/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedBranchAsked;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedBranchAskedDao;

/**
 * 科室常用医嘱Service
 *
 * @author XUE
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedBranchAskedService extends CrudService<SicmedBranchAskedDao, SicmedBranchAsked> {


    @Override
    public SicmedBranchAsked get(String id) {
        return super.get(id);
    }


    @Override
    public List<SicmedBranchAsked> findList(SicmedBranchAsked sicmedBranchAsked) {
        return super.findList(sicmedBranchAsked);
    }


    @Override
    public Page<SicmedBranchAsked> findPage(Page<SicmedBranchAsked> page, SicmedBranchAsked sicmedBranchAsked) {
        return super.findPage(page, sicmedBranchAsked);
    }

    @Transactional(readOnly = false)
    public void save(SicmedBranchAsked sicmedBranchAsked) {
        super.save(sicmedBranchAsked);
    }

    @Transactional(readOnly = false)
    public void delete(SicmedBranchAsked sicmedBranchAsked) {
        super.delete(sicmedBranchAsked);
    }

}