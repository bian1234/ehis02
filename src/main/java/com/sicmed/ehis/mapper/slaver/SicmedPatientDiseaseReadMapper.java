package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedPatientDisease;

public interface SicmedPatientDiseaseReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedPatientDisease record);

    int insertSelective(SicmedPatientDisease record);

    SicmedPatientDisease selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedPatientDisease record);

    int updateByPrimaryKey(SicmedPatientDisease record);
}