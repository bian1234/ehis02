package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedDisease;

public interface SicmedDiseaseReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDisease record);

    int insertSelective(SicmedDisease record);

    SicmedDisease selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDisease record);

    int updateByPrimaryKey(SicmedDisease record);
}