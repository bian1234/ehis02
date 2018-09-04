package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedBranch;
import org.springframework.stereotype.Repository;


@Repository
public interface SicmedBranchWriteMapper extends BaseWriteMapper<SicmedBranch>{

    @Override
    int insertSelective(SicmedBranch sicmedBranch);

    @Override
    int insert(SicmedBranch entity);

    @Override
    int updateSelective(SicmedBranch entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}