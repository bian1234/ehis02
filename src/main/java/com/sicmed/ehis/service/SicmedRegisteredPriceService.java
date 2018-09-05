package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedRegisteredPrice;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 18:27
 * @Todo:   挂号价格
 */

public interface SicmedRegisteredPriceService   extends BaseService<SicmedRegisteredPrice> {

    @Override
    int insertSelective(SicmedRegisteredPrice sicmedRegisteredPrice);

    @Override
    int insert(SicmedRegisteredPrice entity);

    @Override
    int updateSelective(SicmedRegisteredPrice entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedRegisteredPrice selectById(String id);

    @Override
    SicmedRegisteredPrice selectOneByParams(SicmedRegisteredPrice entity);

    @Override
    List<SicmedRegisteredPrice> findAllList(Query query);

    @Override
    List<SicmedRegisteredPrice> selectALLByParams(SicmedRegisteredPrice sicmedRegisteredPrice, Query query);

    @Override
    Page<SicmedRegisteredPrice> findPage(Page<SicmedRegisteredPrice> page, SicmedRegisteredPrice entity);
}
