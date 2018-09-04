package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedAskedBranch;

public interface SicmedAskedBranchReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedAskedBranch record);

    int insertSelective(SicmedAskedBranch record);

    SicmedAskedBranch selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedAskedBranch record);

    int updateByPrimaryKey(SicmedAskedBranch record);
}