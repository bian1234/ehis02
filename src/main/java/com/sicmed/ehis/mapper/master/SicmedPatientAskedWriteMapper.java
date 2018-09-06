package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedPatientAsked;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedPatientAskedWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedPatientAsked record);

    int insertSelective(SicmedPatientAsked record);

    SicmedPatientAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedPatientAsked record);

    int updateByPrimaryKey(SicmedPatientAsked record);
}