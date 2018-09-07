package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedDoctorAsked;
import com.sicmed.ehis.mapper.slaver.SicmedDoctorAskedReadMapper;
import com.sicmed.ehis.service.SicmedDoctorAskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/ 9/7 9:18
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedDoctorAskedServiceImpl  implements SicmedDoctorAskedService {

    @Autowired
    private SicmedDoctorAskedReadMapper sicmedDoctorAskedReadMapper;



    @Override
    public int insertSelective(SicmedDoctorAsked sicmedDoctorAsked) {
        return 0;
    }

    @Override
    public int insert(SicmedDoctorAsked entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedDoctorAsked entity) {
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
    public SicmedDoctorAsked selectById(String id) {
        return sicmedDoctorAskedReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public SicmedDoctorAsked selectOneByParams(SicmedDoctorAsked entity) {
        return null;
    }

    @Override
    public List<SicmedDoctorAsked> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedDoctorAsked> selectALLByParams(SicmedDoctorAsked sicmedDoctorAsked, Query query) {
        return null;
    }

    @Override
    public Page<SicmedDoctorAsked> findPage(Page<SicmedDoctorAsked> page, SicmedDoctorAsked entity) {
        return null;
    }
}
