package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedDiseaseDoctor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedDiseaseDoctorReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDiseaseDoctor record);

    int insertSelective(SicmedDiseaseDoctor record);

    SicmedDiseaseDoctor selectByPrimaryKey(String id);

    List<SicmedDiseaseDoctor> selectByDoctorCode(String doctorCode);

    int updateByPrimaryKeySelective(SicmedDiseaseDoctor record);

    int updateByPrimaryKey(SicmedDiseaseDoctor record);
}