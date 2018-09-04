package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedHospital;

public interface SicmedHospitalWriteMapper {
    int deleteByPrimaryKey(Short hospitalId);

    int insert(SicmedHospital record);

    int insertSelective(SicmedHospital record);

    SicmedHospital selectByPrimaryKey(Short hospitalId);

    int updateByPrimaryKeySelective(SicmedHospital record);

    int updateByPrimaryKey(SicmedHospital record);
}