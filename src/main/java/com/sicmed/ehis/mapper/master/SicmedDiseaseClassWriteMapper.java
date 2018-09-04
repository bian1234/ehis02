package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedDiseaseClass;

public interface SicmedDiseaseClassWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDiseaseClass record);

    int insertSelective(SicmedDiseaseClass record);

    SicmedDiseaseClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDiseaseClass record);

    int updateByPrimaryKey(SicmedDiseaseClass record);
}