package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedCheckPrice;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SicmedCheckPriceReadMapper extends BaseReadMapper<SicmedCheckPrice>{
    @Override
    SicmedCheckPrice selectById(String id);

    @Override
    SicmedCheckPrice selectOneByParams(SicmedCheckPrice entity);

    @Override
    List<SicmedCheckPrice> findAllList(Query query);

    @Override
    List<SicmedCheckPrice> selectALLByParams(SicmedCheckPrice e, Query query);
}