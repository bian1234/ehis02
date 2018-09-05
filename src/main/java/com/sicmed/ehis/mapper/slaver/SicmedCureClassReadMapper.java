package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedCureClass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedCureClassReadMapper   extends BaseReadMapper<SicmedCureClass>{
    @Override
    SicmedCureClass selectById(String id);

    @Override
    SicmedCureClass selectOneByParams(SicmedCureClass entity);

    @Override
    List<SicmedCureClass> findAllList(Query query);

    @Override
    List<SicmedCureClass> selectALLByParams(SicmedCureClass e, Query query);
}