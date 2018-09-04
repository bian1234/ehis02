package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedMedicalUse;

public interface SicmedMedicalUseReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedMedicalUse record);

    int insertSelective(SicmedMedicalUse record);

    SicmedMedicalUse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedMedicalUse record);

    int updateByPrimaryKey(SicmedMedicalUse record);
}