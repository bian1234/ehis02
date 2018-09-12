package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedStanderprescriptionDisease;
import com.sicmed.ehis.mapper.master.SicmedStanderprescriptionDiseaseWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedStanderprescriptionDiseaseReadMapper;
import com.sicmed.ehis.service.SicmedStanderprescriptionDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 18:03
 * @Todo:
 */
@Service
public class SicmedStanderprescriptionDiseaseServiceImpl  implements SicmedStanderprescriptionDiseaseService {


    @Autowired
    private SicmedStanderprescriptionDiseaseReadMapper sicmedStanderprescriptionDiseaseReadMapper;
    @Autowired
    private SicmedStanderprescriptionDiseaseWriteMapper sicmedStanderprescriptionDiseaseWriteMapper;


    @Override
    public List<SicmedStanderprescriptionDisease> selectByCreate(String createUser) {
        return sicmedStanderprescriptionDiseaseReadMapper.selectByCreate(createUser);
    }

    @Override
    public List<SicmedStanderprescriptionDisease> selectByName(String prescriptionName) {
        return sicmedStanderprescriptionDiseaseReadMapper.selectByName(prescriptionName);
    }

    @Override
    public int insertSelective(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease) {
        return sicmedStanderprescriptionDiseaseWriteMapper.insertSelective(sicmedStanderprescriptionDisease);
    }

    @Override
    public int insert(SicmedStanderprescriptionDisease entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedStanderprescriptionDisease entity) {
        return sicmedStanderprescriptionDiseaseWriteMapper.updateSelective(entity);
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
    public SicmedStanderprescriptionDisease selectById(String id) {
        return sicmedStanderprescriptionDiseaseReadMapper.selectById(id);
    }

    @Override
    public List<SicmedStanderprescriptionDisease> selectOneByParams(SicmedStanderprescriptionDisease entity) {
        return null;
    }

    @Override
    public List<SicmedStanderprescriptionDisease> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedStanderprescriptionDisease> selectALLByParams(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease, Query query) {
        return null;
    }

    @Override
    public Page<SicmedStanderprescriptionDisease> findPage(Page<SicmedStanderprescriptionDisease> page, SicmedStanderprescriptionDisease entity) {
        return null;
    }
}
