package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedDoctorAsked;

public interface SicmedDoctorAskedWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDoctorAsked record);

    int insertSelective(SicmedDoctorAsked record);

    SicmedDoctorAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDoctorAsked record);

    int updateByPrimaryKey(SicmedDoctorAsked record);
}