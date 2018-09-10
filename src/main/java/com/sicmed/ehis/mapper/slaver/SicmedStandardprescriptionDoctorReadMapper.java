package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedStandardprescriptionDoctor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Repository
public interface SicmedStandardprescriptionDoctorReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedStandardprescriptionDoctor record);

    int insertSelective(SicmedStandardprescriptionDoctor record);

    SicmedStandardprescriptionDoctor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedStandardprescriptionDoctor record);

    int updateByPrimaryKey(SicmedStandardprescriptionDoctor record);


    List<SicmedStandardprescriptionDoctor> select(Map map);
}