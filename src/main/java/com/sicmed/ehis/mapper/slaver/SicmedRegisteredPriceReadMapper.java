package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedRegisteredPrice;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SicmedRegisteredPriceReadMapper extends BaseReadMapper<SicmedRegisteredPrice>{
    @Override
    SicmedRegisteredPrice selectById(String id);

    @Override
    SicmedRegisteredPrice selectOneByParams(SicmedRegisteredPrice entity);

    @Override
    List<SicmedRegisteredPrice> findAllList(Query query);

    @Override
    List<SicmedRegisteredPrice> selectALLByParams(SicmedRegisteredPrice e, Query query);
}