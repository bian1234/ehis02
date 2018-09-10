package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedPatientDisease;
import com.sicmed.ehis.mapper.master.SicmedPatientDiseaseWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedPatientDiseaseReadMapper;
import com.sicmed.ehis.service.SicmedPatientDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 15:02
 * @Todo:
 */
@Service
public class SicmedPatientDiseaseServiceImpl  implements SicmedPatientDiseaseService {


    @Autowired
    private SicmedPatientDiseaseReadMapper sicmedPatientDiseaseReadMapper;

    @Autowired
    private SicmedPatientDiseaseWriteMapper sicmedPatientDiseaseWriteMapper;

    @Override
    public int insertSelective(SicmedPatientDisease sicmedPatientDisease) {
        return sicmedPatientDiseaseWriteMapper.insertSelective(sicmedPatientDisease);
    }

    @Override
    public int insert(SicmedPatientDisease entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedPatientDisease entity) {
        return 0;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }

    @Override
    public int logicDelete(String id) {
        return sicmedPatientDiseaseWriteMapper.logicDelete(id);
    }

    @Override
    public SicmedPatientDisease selectById(String id) {
        return null;
    }

    @Override
    public List<SicmedPatientDisease> selectOneByParams(SicmedPatientDisease sicmedPatientDisease) {
        return sicmedPatientDiseaseReadMapper.selectOneByParams(sicmedPatientDisease);
    }

    @Override
    public List<SicmedPatientDisease> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedPatientDisease> selectALLByParams(SicmedPatientDisease sicmedPatientDisease, Query query) {
        return null;
    }

    @Override
    public Page<SicmedPatientDisease> findPage(Page<SicmedPatientDisease> page, SicmedPatientDisease entity) {
        return null;
    }

    @Override
    public List<SicmedPatientDisease> getByCase(String caseCode) {
        return sicmedPatientDiseaseReadMapper.getByCase(caseCode);
    }
}
