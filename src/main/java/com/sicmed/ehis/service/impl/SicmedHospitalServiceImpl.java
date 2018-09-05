package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedHospital;
import com.sicmed.ehis.mapper.master.SicmedHospitalWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedHospitalReadMapper;
import com.sicmed.ehis.service.SicmedHospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 10:40
 * @Todo:
 */
@Service
public class SicmedHospitalServiceImpl  implements SicmedHospitalService {

    @Autowired
    private SicmedHospitalReadMapper sicmedHospitalReadMapper;
    @Autowired
    private SicmedHospitalWriteMapper sicmedHospitalWriteMapper;
    @Override
    public int insertSelective(SicmedHospital sicmedHospital) {
        return 0;
    }

    @Override
    public int insert(SicmedHospital entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedHospital entity) {
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
    public SicmedHospital selectById(String id) {
        return null;
    }

    @Override
    public SicmedHospital selectOneByParams(SicmedHospital entity) {
        return null;
    }

    @Override
    public List<SicmedHospital> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedHospital> selectALLByParams(SicmedHospital sicmedHospital, Query query) {
        return null;
    }

    @Override
    public Page<SicmedHospital> findPage(Page<SicmedHospital> page, SicmedHospital entity) {
        return null;
    }

    @Override
    public List<SicmedHospital> selectALLByCityId(String cityId) {
        return sicmedHospitalReadMapper.selectALLByCityId(cityId);
    }
}
