package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedRegisteredPrice;

public interface SicmedRegisteredPriceWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedRegisteredPrice record);

    int insertSelective(SicmedRegisteredPrice record);

    SicmedRegisteredPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedRegisteredPrice record);

    int updateByPrimaryKey(SicmedRegisteredPrice record);
}