package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedStanderprescriptionDisease;

public interface SicmedStanderprescriptionDiseaseWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedStanderprescriptionDisease record);

    int insertSelective(SicmedStanderprescriptionDisease record);

    SicmedStanderprescriptionDisease selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedStanderprescriptionDisease record);

    int updateByPrimaryKey(SicmedStanderprescriptionDisease record);
}