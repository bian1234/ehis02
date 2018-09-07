package com.sicmed.ehis.mapper.slaver;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedStanderprescriptionDisease;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedStanderprescriptionDiseaseReadMapper extends BaseReadMapper<SicmedStanderprescriptionDisease>{

    List<SicmedStanderprescriptionDisease> selectByName(String prescriptionName);

    @Override
    SicmedStanderprescriptionDisease selectById(String id);

    @Override
    SicmedStanderprescriptionDisease selectOneByParams(SicmedStanderprescriptionDisease entity);

    @Override
    List<SicmedStanderprescriptionDisease> findAllList(Query query);

    @Override
    List<SicmedStanderprescriptionDisease> selectALLByParams(SicmedStanderprescriptionDisease e, Query query);
}