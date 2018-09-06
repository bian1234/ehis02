package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedDisease;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedDiseaseReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDisease record);

    int insertSelective(SicmedDisease record);

    SicmedDisease selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDisease record);

    int updateByPrimaryKey(SicmedDisease record);
}