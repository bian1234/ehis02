package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedDtandardprescriptionDoctor;

public interface SicmedDtandardprescriptionDoctorReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDtandardprescriptionDoctor record);

    int insertSelective(SicmedDtandardprescriptionDoctor record);

    SicmedDtandardprescriptionDoctor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDtandardprescriptionDoctor record);

    int updateByPrimaryKey(SicmedDtandardprescriptionDoctor record);
}