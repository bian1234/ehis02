package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedDept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedDeptReadMapper extends BaseReadMapper<SicmedDept>{
    @Override
    SicmedDept selectById(String id);

    @Override
    SicmedDept selectOneByParams(SicmedDept entity);

    @Override
    List<SicmedDept> findAllList(Query query);

    @Override
    List<SicmedDept> selectALLByParams(SicmedDept e, Query query);
}