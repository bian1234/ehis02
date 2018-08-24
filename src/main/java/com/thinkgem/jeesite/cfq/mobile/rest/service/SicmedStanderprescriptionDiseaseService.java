package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStanderprescriptionDisease;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedStanderprescriptionDiseaseDao;

/**
 * 医生常用疾病表Service
 *
 * @author Max
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedStanderprescriptionDiseaseService extends CrudService<SicmedStanderprescriptionDiseaseDao, SicmedStanderprescriptionDisease> {

    @Autowired
    private SicmedStanderprescriptionDiseaseDao sicmedStanderprescriptionDiseaseDao;

    @Override
    public SicmedStanderprescriptionDisease get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedStanderprescriptionDisease> findList(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {
        return super.findList(sicmedStanderprescriptionDisease);
    }

    public List<SicmedStanderprescriptionDisease> findListLike(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {
        return sicmedStanderprescriptionDiseaseDao.findListLike(sicmedStanderprescriptionDisease);
    }

    @Override
    public Page<SicmedStanderprescriptionDisease> findPage(Page<SicmedStanderprescriptionDisease> page, SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {
        return super.findPage(page, sicmedStanderprescriptionDisease);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {
        super.save(sicmedStanderprescriptionDisease);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {
        super.delete(sicmedStanderprescriptionDisease);
    }

    @Transactional(readOnly = false)
    public void update(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {
        // TODO Auto-generated method stub
        sicmedStanderprescriptionDiseaseDao.update(sicmedStanderprescriptionDisease);
    }

    public List<SicmedStanderprescriptionDisease> findByVersion(
            SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {
        // TODO Auto-generated method stub
        return sicmedStanderprescriptionDiseaseDao.findByVersion(sicmedStanderprescriptionDisease);
    }

}