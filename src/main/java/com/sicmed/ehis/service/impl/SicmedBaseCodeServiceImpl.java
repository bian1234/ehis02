package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedBaseCode;
import com.sicmed.ehis.mapper.master.SicmedBaseCodeWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedBaseCodeReadMapper;
import com.sicmed.ehis.service.SicmedBaseCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/4 13:56
 * @Todo:
 */
@Service
public class SicmedBaseCodeServiceImpl  implements SicmedBaseCodeService {

    @Autowired
    private SicmedBaseCodeWriteMapper sicmedBaseCodeWriteMapper;
    @Autowired
    private SicmedBaseCodeReadMapper sicmedBaseCodeReadMapper;
    @Override
    public int insertSelective(SicmedBaseCode sicmedBaseCode) {
        return sicmedBaseCodeWriteMapper.insertSelective(sicmedBaseCode);
    }

    @Override
    public int insert(SicmedBaseCode entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedBaseCode entity) {
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
    public List<SicmedBaseCode> selectALLByParams(SicmedBaseCode sicmedBaseCode, Query query) {
        return null;
    }

    @Override
    public SicmedBaseCode selectById(String id) {
        return sicmedBaseCodeReadMapper.selectById(id);
    }

    @Override
    public SicmedBaseCode selectOneByParams(SicmedBaseCode entity) {
        return null;
    }

    @Override
    public List<SicmedBaseCode> findAllList(Query query) {
        return null;
    }


    @Override
    public Page<SicmedBaseCode> findPage(Page<SicmedBaseCode> page, SicmedBaseCode entity) {
        return null;
    }
}
