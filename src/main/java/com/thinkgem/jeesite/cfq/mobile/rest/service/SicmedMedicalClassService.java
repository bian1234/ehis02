package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedMedicalClassDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalClass;

/**
 * 药品分类Service
 *
 * @author XUE
 * @version 2016-09-02
 */
@Service
@Transactional(readOnly = true)
public class SicmedMedicalClassService extends CrudService<SicmedMedicalClassDao, SicmedMedicalClass> {

    @Autowired
    private SicmedMedicalClassDao sicmedMedicalClassDao;

    @Override
    public SicmedMedicalClass get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedMedicalClass> findList(SicmedMedicalClass sicmedMedicalClass) {
        return super.findList(sicmedMedicalClass);
    }

    @Override
    public Page<SicmedMedicalClass> findPage(Page<SicmedMedicalClass> page, SicmedMedicalClass sicmedMedicalClass) {
        return super.findPage(page, sicmedMedicalClass);
    }

    @Override
    public Page<SicmedMedicalClass> findPageLike(Page<SicmedMedicalClass> page, SicmedMedicalClass sicmedMedicalClass) {
        return super.findPageLike(page, sicmedMedicalClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedMedicalClass sicmedMedicalClass) {
        super.save(sicmedMedicalClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedMedicalClass sicmedMedicalClass) {
        super.delete(sicmedMedicalClass);
    }

    public List<SicmedMedicalClass> findByVersion(SicmedMedicalClass sicmedMedicalClass) {
        // TODO Auto-generated method stub
        return sicmedMedicalClassDao.findByVersion(sicmedMedicalClass);
    }

    @SuppressWarnings("deprecation")
    public List<SicmedMedicalClass> findAllList() {
        return sicmedMedicalClassDao.findAllList();
    }

}