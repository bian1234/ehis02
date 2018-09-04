package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedDept;

public interface SicmedDeptReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDept record);

    int insertSelective(SicmedDept record);

    SicmedDept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDept record);

    int updateByPrimaryKey(SicmedDept record);
}