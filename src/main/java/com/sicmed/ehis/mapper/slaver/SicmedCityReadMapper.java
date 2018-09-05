package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedCity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedCityReadMapper extends BaseReadMapper<SicmedCity>{

    @Override
    SicmedCity selectById(String cityId);

    @Override
    SicmedCity selectOneByParams(SicmedCity entity);

    @Override
    List<SicmedCity> findAllList(Query query);

    @Override
    List<SicmedCity> selectALLByParams(SicmedCity e, Query query);

    List<SicmedCity> getChild(String cityParentId);
}