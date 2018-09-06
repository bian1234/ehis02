package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedMedicalPrice;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedMedicalPriceWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedMedicalPrice record);

    int insertSelective(SicmedMedicalPrice record);

    SicmedMedicalPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedMedicalPrice record);

    int updateByPrimaryKey(SicmedMedicalPrice record);
}