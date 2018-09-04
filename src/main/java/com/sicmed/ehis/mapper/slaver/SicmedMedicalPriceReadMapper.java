package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedMedicalPrice;

public interface SicmedMedicalPriceReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedMedicalPrice record);

    int insertSelective(SicmedMedicalPrice record);

    SicmedMedicalPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedMedicalPrice record);

    int updateByPrimaryKey(SicmedMedicalPrice record);
}