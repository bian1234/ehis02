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


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;

import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedPatientDao;

/**
 * 患者信息表Service
 *
 * @author Max
 * @version 2016-07-12
 */
@Service
@Transactional(readOnly = true)
public class SicmedPatientService extends CrudService<SicmedPatientDao, SicmedPatient> {

    @Autowired
    private SicmedPatientDao sicmedPatientDao;


    @Override
    public SicmedPatient get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedPatient> findList(SicmedPatient sicmedPatient) {
        return super.findList(sicmedPatient);
    }

    /**
     * 模糊搜索患者 接口实现
     *
     * @param sicmedPatient
     * @return List<SicmedPatient>
     * @author Max
     */
    public List<SicmedPatient> findListLike(SicmedPatient sicmedPatient) {
        return sicmedPatientDao.findListLike(sicmedPatient);
    }

    /**
     * 模糊搜索患者 接口实现
     *
     * @param sicmedPatient
     * @return List<SicmedPatient>
     * @author Max
     */
    public List<SicmedPatient> findLike(SicmedPatient sicmedPatient) {
        return sicmedPatientDao.findLike(sicmedPatient);
    }

    @Override
    public Page<SicmedPatient> findPage(Page<SicmedPatient> page, SicmedPatient sicmedPatient) {
        Page<SicmedPatient> tempPage = sicmedPatient.setPage(page);
        tempPage.setList(dao.findList(sicmedPatient));
        for (SicmedPatient tempPatient : tempPage.getList()) {
            if (tempPatient.getPatientSex() != null) {
                tempPatient.setPtSex(tempPatient.getPatientSex());
            }
        }
        return tempPage;
    }

    @Override
    //模糊查询带分页
    public Page<SicmedPatient> findPageLike(Page<SicmedPatient> page, SicmedPatient sicmedPatient) {
        return super.findPageLike(page, sicmedPatient);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedPatient sicmedPatient) {
        super.save(sicmedPatient);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedPatient sicmedPatient) {
        super.delete(sicmedPatient);
    }

    @Transactional(readOnly = false)
    public SicmedPatient getByEntity(SicmedPatient sicmedPatient) {
        return sicmedPatientDao.getByEntity(sicmedPatient);
    }

    //复制数据表 表结构和表中数据 复制 清空原表
    @Transactional(readOnly = false)
    public void clearTable(String copyName) {
        SicmedPatient patient = new SicmedPatient();
        patient.setCopyTableName(copyName);
        sicmedPatientDao.copyTable(patient);
        sicmedPatientDao.insertTable(patient);
        sicmedPatientDao.clearTable();
        //patientPriceDao.clearTable();
    }

    @Transactional(readOnly = false)
    public void update(SicmedPatient sicmedPatient) {
        sicmedPatientDao.update(sicmedPatient);
    }

}