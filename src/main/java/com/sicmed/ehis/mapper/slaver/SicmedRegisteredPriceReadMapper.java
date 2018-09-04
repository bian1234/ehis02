package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedRegisteredPrice;

public interface SicmedRegisteredPriceReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedRegisteredPrice record);

    int insertSelective(SicmedRegisteredPrice record);

    SicmedRegisteredPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedRegisteredPrice record);

    int updateByPrimaryKey(SicmedRegisteredPrice record);
}