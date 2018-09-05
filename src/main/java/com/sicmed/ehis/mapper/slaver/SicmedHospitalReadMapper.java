package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedHospital;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SicmedHospitalReadMapper extends BaseReadMapper<SicmedHospital>{

    @Override
    SicmedHospital selectById(String id);

    @Override
    SicmedHospital selectOneByParams(SicmedHospital entity);

    @Override
    List<SicmedHospital> findAllList(Query query);

    @Override
    List<SicmedHospital> selectALLByParams(SicmedHospital e, Query query);

    List<SicmedHospital> selectALLByCityId(String cityCode);





}