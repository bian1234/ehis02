package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedCurePrice;

public interface SicmedCurePriceReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedCurePrice record);

    int insertSelective(SicmedCurePrice record);

    SicmedCurePrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedCurePrice record);

    int updateByPrimaryKey(SicmedCurePrice record);
}