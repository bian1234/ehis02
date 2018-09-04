package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedUser;

public interface SicmedUserReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedUser record);

    int insertSelective(SicmedUser record);

    SicmedUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedUser record);

    int updateByPrimaryKeyWithBLOBs(SicmedUser record);

    int updateByPrimaryKey(SicmedUser record);
}