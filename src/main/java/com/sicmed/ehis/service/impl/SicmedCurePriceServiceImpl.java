package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCurePrice;
import com.sicmed.ehis.mapper.slaver.SicmedCurePriceReadMapper;
import com.sicmed.ehis.service.SicmedCurePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:54
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedCurePriceServiceImpl  implements SicmedCurePriceService {

    @Autowired
    private SicmedCurePriceReadMapper sicmedCurePriceReadMapper;


    @Override
    public int insertSelective(SicmedCurePrice sicmedCurePrice) {
        return 0;
    }

    @Override
    public int insert(SicmedCurePrice entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedCurePrice entity) {
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
    public SicmedCurePrice selectById(String id) {
        return sicmedCurePriceReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public SicmedCurePrice selectOneByParams(SicmedCurePrice entity) {
        return null;
    }

    @Override
    public List<SicmedCurePrice> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedCurePrice> selectALLByParams(SicmedCurePrice sicmedCurePrice, Query query) {
        return null;
    }

    @Override
    public Page<SicmedCurePrice> findPage(Page<SicmedCurePrice> page, SicmedCurePrice entity) {
        return null;
    }
}
