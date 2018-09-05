package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedInspectClass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedInspectClassReadMapper extends BaseReadMapper<SicmedInspectClass>{

    @Override
    SicmedInspectClass selectById(String id);

    @Override
    SicmedInspectClass selectOneByParams(SicmedInspectClass entity);

    @Override
    List<SicmedInspectClass> findAllList(Query query);

    @Override
    List<SicmedInspectClass> selectALLByParams(SicmedInspectClass e, Query query);
}