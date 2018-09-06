package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedAskedBranch;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedAskedBranchWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedAskedBranch record);

    int insertSelective(SicmedAskedBranch record);

    SicmedAskedBranch selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedAskedBranch record);

    int updateByPrimaryKey(SicmedAskedBranch record);
}