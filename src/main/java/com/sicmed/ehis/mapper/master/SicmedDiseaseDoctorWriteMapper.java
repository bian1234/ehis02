package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedDiseaseDoctor;

public interface SicmedDiseaseDoctorWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDiseaseDoctor record);

    int insertSelective(SicmedDiseaseDoctor record);

    SicmedDiseaseDoctor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDiseaseDoctor record);

    int updateByPrimaryKey(SicmedDiseaseDoctor record);
}