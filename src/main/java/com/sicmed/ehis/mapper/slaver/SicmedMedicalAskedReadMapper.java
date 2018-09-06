package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedMedicalAsked;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedMedicalAskedReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedMedicalAsked record);

    int insertSelective(SicmedMedicalAsked record);

    SicmedMedicalAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedMedicalAsked record);

    int updateByPrimaryKey(SicmedMedicalAsked record);
}