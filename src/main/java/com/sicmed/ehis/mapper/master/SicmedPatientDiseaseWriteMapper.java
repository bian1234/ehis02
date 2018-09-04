package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedPatientDisease;

public interface SicmedPatientDiseaseWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedPatientDisease record);

    int insertSelective(SicmedPatientDisease record);

    SicmedPatientDisease selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedPatientDisease record);

    int updateByPrimaryKey(SicmedPatientDisease record);
}