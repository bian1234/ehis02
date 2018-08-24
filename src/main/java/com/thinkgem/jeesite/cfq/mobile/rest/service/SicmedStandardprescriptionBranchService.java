/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStandardprescriptionBranch;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedStandardprescriptionBranchDao;

/**
 * 医生常用疾病表Service
 *
 * @author Max
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedStandardprescriptionBranchService extends CrudService<SicmedStandardprescriptionBranchDao, SicmedStandardprescriptionBranch> {

    @Autowired
    SicmedStandardprescriptionBranchDao sicmedStandardprescriptionBranchDao;

    @Override
    public SicmedStandardprescriptionBranch get(String id) {
        return super.get(id);
    }

    public SicmedStandardprescriptionBranch getBranchid(String id) {
        SicmedStandardprescriptionBranch sicmedsb = new SicmedStandardprescriptionBranch();
        sicmedsb = sicmedStandardprescriptionBranchDao.getBranchid(id);
        return sicmedsb;
    }

    @Override
    public List<SicmedStandardprescriptionBranch> findList(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch) {
        return super.findList(sicmedStandardprescriptionBranch);
    }

    @Override
    public Page<SicmedStandardprescriptionBranch> findPage(Page<SicmedStandardprescriptionBranch> page, SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch) {
        return super.findPage(page, sicmedStandardprescriptionBranch);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch) {
        super.save(sicmedStandardprescriptionBranch);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch) {
        super.delete(sicmedStandardprescriptionBranch);
    }

    //通过部门找部门标准处方
    public List<SicmedStandardprescriptionBranch> findstandardbybranch(
            SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch) {

        return sicmedStandardprescriptionBranchDao.findstandardbybranch(sicmedStandardprescriptionBranch);
    }

}