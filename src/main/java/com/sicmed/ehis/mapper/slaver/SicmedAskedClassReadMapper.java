package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedAskedClass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedAskedClassReadMapper extends BaseReadMapper<SicmedAskedClass>{


    @Override
    SicmedAskedClass selectById(String id);

    @Override
    SicmedAskedClass selectOneByParams(SicmedAskedClass entity);

    @Override
    List<SicmedAskedClass> findAllList(Query query);

    @Override
    List<SicmedAskedClass> selectALLByParams(SicmedAskedClass e, Query query);
}