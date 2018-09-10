package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedPatientAsked;
import com.sicmed.ehis.mapper.master.SicmedPatientAskedWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedPatientAskedReadMapper;
import com.sicmed.ehis.service.SicmedPatientAskedService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 11:40
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedPatientAskedServiceImpl  implements SicmedPatientAskedService {


    @Autowired
    private SicmedPatientAskedReadMapper sicmedPatientAskedReadMapper;

    @Autowired
    private SicmedPatientAskedWriteMapper sicmedPatientAskedWriteMapper;


    @Override
    public int insertSelective(SicmedPatientAsked sicmedPatientAsked) {
        return 0;
    }

    @Override
    public int insert(SicmedPatientAsked entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedPatientAsked entity) {
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
    public SicmedPatientAsked selectById(String id) {
        return sicmedPatientAskedReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<SicmedPatientAsked> getByPatient(String patientId, String askedClass) {
        return sicmedPatientAskedReadMapper.getByPatient(patientId,askedClass);
    }

    @Override
    public SicmedPatientAsked selectOneByParams(SicmedPatientAsked entity) {
        return null;
    }

    @Override
    public List<SicmedPatientAsked> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedPatientAsked> selectALLByParams(SicmedPatientAsked sicmedPatientAsked, Query query) {
        return null;
    }

    @Override
    public Page<SicmedPatientAsked> findPage(Page<SicmedPatientAsked> page, SicmedPatientAsked entity) {
        return null;
    }
}
