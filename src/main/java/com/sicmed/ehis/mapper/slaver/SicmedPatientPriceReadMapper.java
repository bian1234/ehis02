package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedPatientPrice;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedPatientPriceReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedPatientPrice record);

    int insertSelective(SicmedPatientPrice record);

    SicmedPatientPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedPatientPrice record);

    int updateByPrimaryKey(SicmedPatientPrice record);
}