package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedPatient;
import com.sicmed.ehis.mapper.master.SicmedPatientWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedPatientReadMapper;
import com.sicmed.ehis.service.SicmedPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/11 15:21
 * @Todo:
 */
@Service
public class SicmedPatientServiceImpl  implements SicmedPatientService {


    @Autowired
    private SicmedPatientReadMapper sicmedPatientReadMapper;

    @Autowired
    private SicmedPatientWriteMapper sicmedPatientWriteMapper;


    @Override
    public int insertSelective(SicmedPatient sicmedPatient) {
        return 0;
    }

    @Override
    public int insert(SicmedPatient entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedPatient entity) {
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
    public SicmedPatient selectById(String id) {
        return sicmedPatientReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SicmedPatient> selectOneByParams(SicmedPatient entity) {
        return null;
    }

    @Override
    public List<SicmedPatient> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedPatient> selectALLByParams(SicmedPatient sicmedPatient, Query query) {
        return sicmedPatientReadMapper.selectALLByParams(sicmedPatient,query);
    }

    @Override
    public Page<SicmedPatient> findPage(Page<SicmedPatient> page, SicmedPatient entity) {
        return null;
    }
}
