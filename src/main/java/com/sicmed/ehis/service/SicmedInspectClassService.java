package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedInspectClass;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 13:50
 * @Todo:
 */

public interface SicmedInspectClassService  extends BaseService<SicmedInspectClass>{

    @Override
    int insertSelective(SicmedInspectClass sicmedInspectClass);

    @Override
    int insert(SicmedInspectClass entity);

    @Override
    int updateSelective(SicmedInspectClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedInspectClass selectById(String id);

    @Override
    SicmedInspectClass selectOneByParams(SicmedInspectClass entity);

    @Override
    List<SicmedInspectClass> findAllList(Query query);

    @Override
    List<SicmedInspectClass> selectALLByParams(SicmedInspectClass sicmedInspectClass, Query query);

    @Override
    Page<SicmedInspectClass> findPage(Page<SicmedInspectClass> page, SicmedInspectClass entity);
}
