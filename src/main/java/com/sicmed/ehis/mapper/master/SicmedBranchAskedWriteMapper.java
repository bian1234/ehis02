package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedBranchAsked;

public interface SicmedBranchAskedWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedBranchAsked record);

    int insertSelective(SicmedBranchAsked record);

    SicmedBranchAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedBranchAsked record);

    int updateByPrimaryKey(SicmedBranchAsked record);
}