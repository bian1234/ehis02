package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedBranchAsked;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedBranchAskedReadMapper extends BaseReadMapper<SicmedBranchAsked>{


    @Override
    SicmedBranchAsked selectById(String id);

    @Override
    SicmedBranchAsked selectOneByParams(SicmedBranchAsked entity);

    @Override
    List<SicmedBranchAsked> findAllList(Query query);

    @Override
    List<SicmedBranchAsked> selectALLByParams(SicmedBranchAsked e, Query query);
}