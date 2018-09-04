package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedDiseaseBranch;

public interface SicmedDiseaseBranchWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDiseaseBranch record);

    int insertSelective(SicmedDiseaseBranch record);

    SicmedDiseaseBranch selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDiseaseBranch record);

    int updateByPrimaryKey(SicmedDiseaseBranch record);
}