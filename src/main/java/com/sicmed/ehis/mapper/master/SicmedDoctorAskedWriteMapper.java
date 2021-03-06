package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedDoctorAsked;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedDoctorAskedWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDoctorAsked record);

    int insertSelective(SicmedDoctorAsked record);

    SicmedDoctorAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDoctorAsked record);

    int updateByPrimaryKey(SicmedDoctorAsked record);
}