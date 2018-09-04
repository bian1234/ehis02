package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedCureClass;

public interface SicmedCureClassWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedCureClass record);

    int insertSelective(SicmedCureClass record);

    SicmedCureClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedCureClass record);

    int updateByPrimaryKey(SicmedCureClass record);
}