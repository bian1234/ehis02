package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedInspect;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 13:49
 * @Todo:   检验服务
 */

public interface SicmedInspectService  extends BaseService<SicmedInspect> {


    @Override
    int insertSelective(SicmedInspect sicmedInspect);

    @Override
    int insert(SicmedInspect entity);

    @Override
    int updateSelective(SicmedInspect entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedInspect selectById(String id);

    @Override
    SicmedInspect selectOneByParams(SicmedInspect entity);

    @Override
    List<SicmedInspect> findAllList(Query query);

    @Override
    List<SicmedInspect> selectALLByParams(SicmedInspect sicmedInspect, Query query);

    @Override
    Page<SicmedInspect> findPage(Page<SicmedInspect> page, SicmedInspect entity);
}
