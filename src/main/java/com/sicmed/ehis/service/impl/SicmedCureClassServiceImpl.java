package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCureClass;
import com.sicmed.ehis.mapper.master.SicmedCureClassWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedCureClassReadMapper;
import com.sicmed.ehis.service.SicmedCureClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 17:39
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedCureClassServiceImpl  implements SicmedCureClassService {


    @Autowired
    private SicmedCureClassReadMapper sicmedCureClassReadMapper;

    @Autowired
    private SicmedCureClassWriteMapper sicmedCureClassWriteMapper;

    @Override
    public int insertSelective(SicmedCureClass sicmedCureClass) {
        return 0;
    }

    @Override
    public int insert(SicmedCureClass entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedCureClass entity) {
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
    public SicmedCureClass selectById(String id) {
        return sicmedCureClassReadMapper.selectById(id);
    }

    @Override
    public SicmedCureClass selectOneByParams(SicmedCureClass entity) {
        return null;
    }

    @Override
    public List<SicmedCureClass> findAllList(Query query) {
        return sicmedCureClassReadMapper.findAllList(query);
    }

    @Override
    public List<SicmedCureClass> selectALLByParams(SicmedCureClass sicmedCureClass, Query query) {
        return null;
    }

    @Override
    public Page<SicmedCureClass> findPage(Page<SicmedCureClass> page, SicmedCureClass entity) {
        return null;
    }
}
