package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedBranch;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SicmedBranchReadMapper extends BaseReadMapper<SicmedBranch>{

    @Override
    SicmedBranch selectById(String id);

    @Override
    SicmedBranch selectOneByParams(SicmedBranch entity);

    @Override
    List<SicmedBranch> findAllList(Query query);

    @Override
    List<SicmedBranch> selectALLByParams(SicmedBranch sicmedBranch,Query query);

    List<SicmedBranch> selectRegistered(Query query);

}