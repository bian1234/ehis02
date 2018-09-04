package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedMedicalClass;

public interface SicmedMedicalClassReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedMedicalClass record);

    int insertSelective(SicmedMedicalClass record);

    SicmedMedicalClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedMedicalClass record);

    int updateByPrimaryKey(SicmedMedicalClass record);
}