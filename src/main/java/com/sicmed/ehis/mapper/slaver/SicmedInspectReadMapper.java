package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedInspect;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SicmedInspectReadMapper   extends BaseReadMapper{
    @Override
    Object selectById(String id);

    @Override
    Object selectOneByParams(Object entity);

    @Override
    List findAllList(Query query);

    @Override
    List selectALLByParams(Object e, Query query);
}