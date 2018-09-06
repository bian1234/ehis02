package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedPatientPrice;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedPatientPriceWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedPatientPrice record);

    int insertSelective(SicmedPatientPrice record);

    SicmedPatientPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedPatientPrice record);

    int updateByPrimaryKey(SicmedPatientPrice record);
}