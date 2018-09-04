package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedInspectClass;

public interface SicmedInspectClassWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedInspectClass record);

    int insertSelective(SicmedInspectClass record);

    SicmedInspectClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedInspectClass record);

    int updateByPrimaryKey(SicmedInspectClass record);
}