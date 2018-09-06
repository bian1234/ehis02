package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCurePrice;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 14:53
 * @Todo:
 */

public interface SicmedCurePriceService  extends BaseService<SicmedCurePrice> {

    @Override
    int insertSelective(SicmedCurePrice sicmedCurePrice);

    @Override
    int insert(SicmedCurePrice entity);

    @Override
    int updateSelective(SicmedCurePrice entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedCurePrice selectById(String id);

    @Override
    SicmedCurePrice selectOneByParams(SicmedCurePrice entity);

    @Override
    List<SicmedCurePrice> findAllList(Query query);

    @Override
    List<SicmedCurePrice> selectALLByParams(SicmedCurePrice sicmedCurePrice, Query query);

    @Override
    Page<SicmedCurePrice> findPage(Page<SicmedCurePrice> page, SicmedCurePrice entity);
}
