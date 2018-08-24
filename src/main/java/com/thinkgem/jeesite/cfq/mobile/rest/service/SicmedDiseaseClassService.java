package com.thinkgem.jeesite.cfq.mobile.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.cfq.common.Page;
import com.thinkgem.jeesite.cfq.common.service.CrudService;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseClass;
import com.thinkgem.jeesite.cfq.mobile.rest.dao.SicmedDiseaseClassDao;

/**
 * 疾病类别表Service
 *
 * @author Max
 * @version 2016-07-18
 */
@Service
@Transactional(readOnly = true)
public class SicmedDiseaseClassService extends CrudService<SicmedDiseaseClassDao, SicmedDiseaseClass> {

    @Autowired
    private SicmedDiseaseClassDao sicmedDiseaseClassDao;

    @Override
    public SicmedDiseaseClass get(String id) {
        return super.get(id);
    }

    @Override
    public List<SicmedDiseaseClass> findList(SicmedDiseaseClass sicmedDiseaseClass) {
        return super.findList(sicmedDiseaseClass);
    }

    @Override
    public Page<SicmedDiseaseClass> findPage(Page<SicmedDiseaseClass> page, SicmedDiseaseClass sicmedDiseaseClass) {
        return super.findPage(page, sicmedDiseaseClass);
    }

    @Override
    //模糊查询带分页web
    public Page<SicmedDiseaseClass> findPageLike(Page<SicmedDiseaseClass> page, SicmedDiseaseClass sicmedDiseaseClass) {
        return super.findPageLike(page, sicmedDiseaseClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(SicmedDiseaseClass sicmedDiseaseClass) {
        super.save(sicmedDiseaseClass);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(SicmedDiseaseClass sicmedDiseaseClass) {
        super.delete(sicmedDiseaseClass);
    }

    public List<SicmedDiseaseClass> findByVersion(SicmedDiseaseClass sicmedDiseaseClass) {
        // TODO Auto-generated method stub
        return sicmedDiseaseClassDao.findByVersion(sicmedDiseaseClass);
    }

}