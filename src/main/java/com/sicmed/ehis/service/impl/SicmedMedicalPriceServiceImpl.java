package com.sicmed.ehis.service.impl;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedMedicalPrice;
import com.sicmed.ehis.mapper.slaver.SicmedMedicalPriceReadMapper;
import com.sicmed.ehis.service.SicmedMedicalPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/7 10:01
 * @Todo:
 */
@Service
@Transactional(readOnly = true)
public class SicmedMedicalPriceServiceImpl  implements SicmedMedicalPriceService {

    @Autowired
    private SicmedMedicalPriceReadMapper sicmedMedicalPriceReadMapper;

    @Override
    public int insertSelective(SicmedMedicalPrice sicmedMedicalPrice) {
        return 0;
    }

    @Override
    public int insert(SicmedMedicalPrice entity) {
        return 0;
    }

    @Override
    public int updateSelective(SicmedMedicalPrice entity) {
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
    public SicmedMedicalPrice selectById(String id) {
        return sicmedMedicalPriceReadMapper.selectById(id);
    }

    @Override
    public SicmedMedicalPrice selectOneByParams(SicmedMedicalPrice entity) {
        return null;
    }

    @Override
    public List<SicmedMedicalPrice> findAllList(Query query) {
        return null;
    }

    @Override
    public List<SicmedMedicalPrice> selectALLByParams(SicmedMedicalPrice sicmedMedicalPrice, Query query) {
        return null;
    }

    @Override
    public Page<SicmedMedicalPrice> findPage(Page<SicmedMedicalPrice> page, SicmedMedicalPrice entity) {
        return null;
    }
}
