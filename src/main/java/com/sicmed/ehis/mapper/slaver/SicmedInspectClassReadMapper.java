package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedInspectClass;

public interface SicmedInspectClassReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedInspectClass record);

    int insertSelective(SicmedInspectClass record);

    SicmedInspectClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedInspectClass record);

    int updateByPrimaryKey(SicmedInspectClass record);
}