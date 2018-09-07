package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedMedicalPrice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedMedicalPriceReadMapper extends BaseReadMapper<SicmedMedicalPrice>{
    @Override
    SicmedMedicalPrice selectById(String id);

    @Override
    SicmedMedicalPrice selectOneByParams(SicmedMedicalPrice entity);

    @Override
    List<SicmedMedicalPrice> findAllList(Query query);

    @Override
    List<SicmedMedicalPrice> selectALLByParams(SicmedMedicalPrice e, Query query);
}