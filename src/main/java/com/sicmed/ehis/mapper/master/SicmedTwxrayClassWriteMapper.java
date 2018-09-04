package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedTwxrayClass;

public interface SicmedTwxrayClassWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedTwxrayClass record);

    int insertSelective(SicmedTwxrayClass record);

    SicmedTwxrayClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedTwxrayClass record);

    int updateByPrimaryKey(SicmedTwxrayClass record);
}