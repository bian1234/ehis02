package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedRegisteredPrice;
import com.sicmed.ehis.mapper.master.SicmedRegisteredPriceWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedRegisteredPriceReadMapper;
import com.sicmed.ehis.service.SicmedRegisteredPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 18:28
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedRegisteredPriceServiceImpl  implements SicmedRegisteredPriceService {


    @Autowired
    private SicmedRegisteredPriceReadMapper sicmedRegisteredPriceReadMapper;

    @Autowired
    private SicmedRegisteredPriceWriteMapper sicmedRegisteredPriceWriteMapper;


    @Override
    public int insertSelective(SicmedRegisteredPrice sicmedRegisteredPrice) {
        return 0;
    }

    @Override
    public int insert(SicmedRegisteredPrice entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedRegisteredPrice entity) {
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
    public SicmedRegisteredPrice selectById(String id) {
        return sicmedRegisteredPriceReadMapper.selectById(id);
    }

    @Override
    public SicmedRegisteredPrice selectOneByParams(SicmedRegisteredPrice entity) {
        return null;
    }

    @Override
    public List<SicmedRegisteredPrice> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedRegisteredPrice> selectALLByParams(SicmedRegisteredPrice sicmedRegisteredPrice, Query query) {
        return null;
    }

    @Override
    public Page<SicmedRegisteredPrice> findPage(Page<SicmedRegisteredPrice> page, SicmedRegisteredPrice entity) {
        return null;
    }
}
