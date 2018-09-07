package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedStanderprescriptionAsked;
import com.sicmed.ehis.mapper.master.SicmedStanderprescriptionAskedWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedStanderprescriptionAskedReadMapper;
import com.sicmed.ehis.service.SicmedStanderprescriptionAskedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 18:00
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedStanderprescriptionAskedServiceImpl  implements SicmedStanderprescriptionAskedService {


    @Autowired
    private SicmedStanderprescriptionAskedReadMapper sicmedStanderprescriptionAskedReadMapper;

    @Autowired
    private SicmedStanderprescriptionAskedWriteMapper sicmedStanderprescriptionAskedWriteMapper;


    @Override
    public int insertSelective(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked) {
        return 0;
    }

    @Override
    public int insert(SicmedStanderprescriptionAsked entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedStanderprescriptionAsked entity) {
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
    public SicmedStanderprescriptionAsked selectById(String id) {
        return null;
    }

    @Override
    public SicmedStanderprescriptionAsked selectOneByParams(SicmedStanderprescriptionAsked entity) {
        return null;
    }

    @Override
    public List<SicmedStanderprescriptionAsked> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedStanderprescriptionAsked> selectALLByParams(SicmedStanderprescriptionAsked sicmedStanderprescriptionAsked, Query query) {
        return null;
    }

    @Override
    public Page<SicmedStanderprescriptionAsked> findPage(Page<SicmedStanderprescriptionAsked> page, SicmedStanderprescriptionAsked entity) {
        return null;
    }
}
