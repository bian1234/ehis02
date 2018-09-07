package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedMedicalAsked;
import com.sicmed.ehis.mapper.slaver.SicmedMedicalAskedReadMapper;
import com.sicmed.ehis.service.SicmedMedicalAskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:22
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedMedicalAskedServiceImpl  implements SicmedMedicalAskedService {


    @Autowired
    private SicmedMedicalAskedReadMapper sicmedMedicalAskedReadMapper;

    @Override
    public SicmedMedicalAsked selectById(String id) {
        return sicmedMedicalAskedReadMapper.selectById(id);
    }

    @Override
    public int insertSelective(SicmedMedicalAsked sicmedMedicalAsked) {
        return 0;
    }

    @Override
    public int insert(SicmedMedicalAsked entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedMedicalAsked entity) {
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
    public SicmedMedicalAsked selectOneByParams(SicmedMedicalAsked entity) {
        return null;
    }

    @Override
    public List<SicmedMedicalAsked> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedMedicalAsked> selectALLByParams(SicmedMedicalAsked sicmedMedicalAsked, Query query) {
        return null;
    }

    @Override
    public Page<SicmedMedicalAsked> findPage(Page<SicmedMedicalAsked> page, SicmedMedicalAsked entity) {
        return null;
    }
}
