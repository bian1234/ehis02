package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedMedical;

public interface SicmedMedicalReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedMedical record);

    int insertSelective(SicmedMedical record);

    SicmedMedical selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedMedical record);

    int updateByPrimaryKey(SicmedMedical record);
}