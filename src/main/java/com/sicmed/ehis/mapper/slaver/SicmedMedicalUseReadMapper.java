package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedMedicalUse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedMedicalUseReadMapper extends BaseReadMapper<SicmedMedicalUse>{
    @Override
    SicmedMedicalUse selectById(String id);

    @Override
    SicmedMedicalUse selectOneByParams(SicmedMedicalUse entity);

    @Override
    List<SicmedMedicalUse> findAllList(Query query);

    @Override
    List<SicmedMedicalUse> selectALLByParams(SicmedMedicalUse e, Query query);
}