package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedStandardprescriptionDoctor;
import com.sicmed.ehis.mapper.master.SicmedStandardprescriptionDoctorWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedStandardprescriptionDoctorReadMapper;
import com.sicmed.ehis.service.SicmedStandardprescriptionDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 17:36
 * @Todo:
 */
@Service
public class SicmedStandardprescriptionDoctorServiceImpl  implements SicmedStandardprescriptionDoctorService {

    @Autowired
    private SicmedStandardprescriptionDoctorReadMapper sicmedStandardprescriptionDoctorReadMapper;

    @Autowired
    private SicmedStandardprescriptionDoctorWriteMapper sicmedStandardprescriptionDoctorWriteMapper;

    @Override
    public SicmedStandardprescriptionDoctor selectById(String id) {
        return sicmedStandardprescriptionDoctorReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor) {
        return 0;
    }

    @Override
    public int insert(SicmedStandardprescriptionDoctor entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedStandardprescriptionDoctor entity) {
        return 0;
    }

    @Override
    public List<SicmedStandardprescriptionDoctor> select(Map map) {
        return sicmedStandardprescriptionDoctorReadMapper.select(map);
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
    public List<SicmedStandardprescriptionDoctor> selectOneByParams(SicmedStandardprescriptionDoctor entity) {
        return null;
    }

    @Override
    public List<SicmedStandardprescriptionDoctor> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedStandardprescriptionDoctor> selectALLByParams(SicmedStandardprescriptionDoctor sicmedStandardprescriptionDoctor, Query query) {
        return null;
    }

    @Override
    public Page<SicmedStandardprescriptionDoctor> findPage(Page<SicmedStandardprescriptionDoctor> page, SicmedStandardprescriptionDoctor entity) {
        return null;
    }
}
