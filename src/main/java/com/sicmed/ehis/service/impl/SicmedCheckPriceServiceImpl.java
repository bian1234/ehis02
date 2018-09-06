package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCheckPrice;
import com.sicmed.ehis.mapper.master.SicmedCheckPriceWriteMapper;
import com.sicmed.ehis.mapper.slaver.SicmedCheckPriceReadMapper;
import com.sicmed.ehis.service.SicmedCheckPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 9:02
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedCheckPriceServiceImpl  implements SicmedCheckPriceService {

    @Autowired
    private SicmedCheckPriceReadMapper sicmedCheckPriceReadMapper;

    @Autowired
    private SicmedCheckPriceWriteMapper sicmedCheckPriceWriteMapper;


    @Override
    public int insertSelective(SicmedCheckPrice sicmedCheckPrice) {
        return 0;
    }

    @Override
    public int insert(SicmedCheckPrice entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedCheckPrice entity) {
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
    public SicmedCheckPrice selectById(String id) {
        return sicmedCheckPriceReadMapper.selectById(id);
    }

    @Override
    public SicmedCheckPrice selectOneByParams(SicmedCheckPrice entity) {
        return null;
    }

    @Override
    public List<SicmedCheckPrice> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedCheckPrice> selectALLByParams(SicmedCheckPrice sicmedCheckPrice, Query query) {
        return null;
    }

    @Override
    public Page<SicmedCheckPrice> findPage(Page<SicmedCheckPrice> page, SicmedCheckPrice entity) {
        return null;
    }
}
