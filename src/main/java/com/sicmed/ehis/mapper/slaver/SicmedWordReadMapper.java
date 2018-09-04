package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedWord;

public interface SicmedWordReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedWord record);

    int insertSelective(SicmedWord record);

    SicmedWord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedWord record);

    int updateByPrimaryKey(SicmedWord record);
}