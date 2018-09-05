package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedInspectClass;
import com.sicmed.ehis.mapper.master.SicmedInspectClassWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedInspectClassReadMapper;
import com.sicmed.ehis.service.SicmedInspectClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 14:06
 * @Todo:   检验类别的服务
 */
@Service
public class SicmedInspectClassServiceImpl implements SicmedInspectClassService{


    @Autowired
    private SicmedInspectClassReadMapper sicmedInspectClassReadMapper;
    @Autowired
    private SicmedInspectClassWriteMapper sicmedInspectClassWriteMapper;


    @Override
    public int insertSelective(SicmedInspectClass sicmedInspectClass) {
        return 0;
    }

    @Override
    public int insert(SicmedInspectClass entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedInspectClass entity) {
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
    public SicmedInspectClass selectById(String id) {
        return sicmedInspectClassReadMapper.selectById(id);
    }

    @Override
    public SicmedInspectClass selectOneByParams(SicmedInspectClass entity) {
        return null;
    }

    @Override
    public List<SicmedInspectClass> findAllList(Query query) {
        return sicmedInspectClassReadMapper.findAllList(query);
    }

    @Override
    public List<SicmedInspectClass> selectALLByParams(SicmedInspectClass sicmedInspectClass, Query query) {
        return null;
    }

    @Override
    public Page<SicmedInspectClass> findPage(Page<SicmedInspectClass> page, SicmedInspectClass entity) {
        return null;
    }
}
