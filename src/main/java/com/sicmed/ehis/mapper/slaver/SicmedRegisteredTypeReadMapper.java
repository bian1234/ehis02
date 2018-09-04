package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedRegisteredType;

public interface SicmedRegisteredTypeReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedRegisteredType record);

    int insertSelective(SicmedRegisteredType record);

    SicmedRegisteredType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedRegisteredType record);

    int updateByPrimaryKey(SicmedRegisteredType record);
}