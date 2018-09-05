package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.entity.SicmedAskedBranch;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedAskedBranchReadMapper   extends BaseReadMapper<SicmedAskedBranch>{
    @Override
    SicmedAskedBranch selectById(String id);
}