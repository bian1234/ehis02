package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedMedicalAsked;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedMedicalAskedWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedMedicalAsked record);

    int insertSelective(SicmedMedicalAsked record);

    SicmedMedicalAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedMedicalAsked record);

    int updateByPrimaryKey(SicmedMedicalAsked record);
}