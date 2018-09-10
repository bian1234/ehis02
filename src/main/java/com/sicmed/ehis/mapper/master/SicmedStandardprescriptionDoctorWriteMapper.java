package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedStandardprescriptionDoctor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;


@Repository
public interface SicmedStandardprescriptionDoctorWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedStandardprescriptionDoctor record);

    int insertSelective(SicmedStandardprescriptionDoctor record);

    SicmedStandardprescriptionDoctor selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedStandardprescriptionDoctor record);

    int updateByPrimaryKey(SicmedStandardprescriptionDoctor record);
}