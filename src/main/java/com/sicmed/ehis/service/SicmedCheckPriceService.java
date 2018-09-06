package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCheckPrice;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 9:01
 * @Todo:   放射线检查价格表
 */

public interface SicmedCheckPriceService  extends BaseService<SicmedCheckPrice> {

    @Override
    int insertSelective(SicmedCheckPrice sicmedCheckPrice);

    @Override
    int insert(SicmedCheckPrice entity);

    @Override
    int updateSelective(SicmedCheckPrice entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedCheckPrice selectById(String id);

    @Override
    SicmedCheckPrice selectOneByParams(SicmedCheckPrice entity);

    @Override
    List<SicmedCheckPrice> findAllList(Query query);

    @Override
    List<SicmedCheckPrice> selectALLByParams(SicmedCheckPrice sicmedCheckPrice, Query query);

    @Override
    Page<SicmedCheckPrice> findPage(Page<SicmedCheckPrice> page, SicmedCheckPrice entity);
}
