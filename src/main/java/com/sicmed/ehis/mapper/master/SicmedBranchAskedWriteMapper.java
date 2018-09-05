package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedBranchAsked;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedBranchAskedWriteMapper extends BaseWriteMapper<SicmedBranchAsked>{
    @Override
    int insertSelective(SicmedBranchAsked sicmedBranchAsked);

    @Override
    int insert(SicmedBranchAsked entity);

    @Override
    int updateSelective(SicmedBranchAsked entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}