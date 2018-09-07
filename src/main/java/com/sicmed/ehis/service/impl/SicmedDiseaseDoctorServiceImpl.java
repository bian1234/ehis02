package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDiseaseDoctor;
import com.sicmed.ehis.mapper.master.SicmedDiseaseDoctorWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedDiseaseDoctorReadMapper;
import com.sicmed.ehis.service.SicmedDiseaseDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 17:15
 * @Todo:
 */
@Transactional(readOnly = true)
@Service
public class SicmedDiseaseDoctorServiceImpl  implements SicmedDiseaseDoctorService {

    @Autowired
    private SicmedDiseaseDoctorReadMapper sicmedDiseaseDoctorReadMapper;

    @Autowired
    private SicmedDiseaseDoctorWriteMapper sicmedDiseaseDoctorWriteMapper;


    @Override
    @Transactional(readOnly = false)
    public int insertSelective(SicmedDiseaseDoctor sicmedDiseaseDoctor) {
        return sicmedDiseaseDoctorWriteMapper.insertSelective(sicmedDiseaseDoctor);
    }

    @Override
    public int insert(SicmedDiseaseDoctor entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedDiseaseDoctor entity) {
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
    public SicmedDiseaseDoctor selectById(String id) {
        return sicmedDiseaseDoctorReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public SicmedDiseaseDoctor selectOneByParams(SicmedDiseaseDoctor entity) {
        return null;
    }

    @Override
    public List<SicmedDiseaseDoctor> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedDiseaseDoctor> selectALLByParams(SicmedDiseaseDoctor sicmedDiseaseDoctor, Query query) {
        return null;
    }

    @Override
    public Page<SicmedDiseaseDoctor> findPage(Page<SicmedDiseaseDoctor> page, SicmedDiseaseDoctor entity) {
        return null;
    }

    @Override
    public List<SicmedDiseaseDoctor> selectByDoctorCode(String doctorCode) {
        return sicmedDiseaseDoctorReadMapper.selectByDoctorCode(doctorCode);
    }
}
