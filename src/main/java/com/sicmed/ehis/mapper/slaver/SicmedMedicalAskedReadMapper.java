package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedMedicalAsked;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedMedicalAskedReadMapper extends BaseReadMapper<SicmedMedicalAsked>{
    @Override
    SicmedMedicalAsked selectById(String id);

    @Override
    SicmedMedicalAsked selectOneByParams(SicmedMedicalAsked entity);

    @Override
    List<SicmedMedicalAsked> findAllList(Query query);

    @Override
    List<SicmedMedicalAsked> selectALLByParams(SicmedMedicalAsked e, Query query);
}