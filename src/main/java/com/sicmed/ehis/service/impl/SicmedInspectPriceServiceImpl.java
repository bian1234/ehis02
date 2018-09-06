package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedInspectPrice;
import com.sicmed.ehis.mapper.slaver.SicmedInspectPriceReadMapper;
import com.sicmed.ehis.service.SicmedInspectPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:07
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedInspectPriceServiceImpl  implements SicmedInspectPriceService {

    @Autowired
    private SicmedInspectPriceReadMapper sicmedInspectPriceReadMapper;



    @Override
    public SicmedInspectPrice selectById(String id) {
        return sicmedInspectPriceReadMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(SicmedInspectPrice sicmedInspectPrice) {
        return 0;
    }

    @Override
    public int insert(SicmedInspectPrice entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedInspectPrice entity) {
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
    public SicmedInspectPrice selectOneByParams(SicmedInspectPrice entity) {
        return null;
    }

    @Override
    public List<SicmedInspectPrice> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedInspectPrice> selectALLByParams(SicmedInspectPrice sicmedInspectPrice, Query query) {
        return null;
    }

    @Override
    public Page<SicmedInspectPrice> findPage(Page<SicmedInspectPrice> page, SicmedInspectPrice entity) {
        return null;
    }
}
