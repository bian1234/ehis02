package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedMedicalClass;
import com.sicmed.ehis.mapper.slaver.SicmedMedicalClassReadMapper;
import com.sicmed.ehis.service.SicmedMedicalClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 18:55
 * @Todo:
 */
@Service
public class SicmedMedicalClassServiceImpl  implements SicmedMedicalClassService {


    @Autowired
    private SicmedMedicalClassReadMapper sicmedMedicalClassReadMapper;


    @Override
    public List<SicmedMedicalClass> findAllList(Query query) {

        List<SicmedMedicalClass> sicmedMedicalClasses= sicmedMedicalClassReadMapper.findAllList(query);
        return sicmedMedicalClasses;
    }

    @Override
    public int insertSelective(SicmedMedicalClass sicmedMedicalClass) {
        return 0;
    }

    @Override
    public int insert(SicmedMedicalClass entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedMedicalClass entity) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public int logicDelete(String id) {
        return 0;
    }

    @Override
    public SicmedMedicalClass selectById(String id) {
        return sicmedMedicalClassReadMapper.selectById(id);
    }

    @Override
    public List<SicmedMedicalClass> selectOneByParams(SicmedMedicalClass entity) {
        return null;
    }

    @Override
    public List<SicmedMedicalClass> selectALLByParams(SicmedMedicalClass sicmedMedicalClass, Query query) {
        return null;
    }

    @Override
    public Page<SicmedMedicalClass> findPage(Page<SicmedMedicalClass> page, SicmedMedicalClass entity) {
        return null;
    }

    @Override
    public List<SicmedMedicalClass> firstClassification(SicmedMedicalClass sicmedMedicalClass) {
        return sicmedMedicalClassReadMapper.firstClassification(sicmedMedicalClass);
    }

    @Override
    public List<SicmedMedicalClass> findChild(Map map) {
        return sicmedMedicalClassReadMapper.findChild(map);
    }
}
