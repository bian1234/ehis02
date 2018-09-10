package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.entity.SicmedPatientAsked;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedPatientAskedReadMapper extends BaseReadMapper<SicmedPatientAsked>{
    int deleteByPrimaryKey(String id);

    int insert(SicmedPatientAsked record);

    int insertSelective(SicmedPatientAsked record);

    SicmedPatientAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedPatientAsked record);

    int updateByPrimaryKey(SicmedPatientAsked record);

    List<SicmedPatientAsked> getByPatient(@Param("patientCode") String patientId, @Param("askedClass") String askedClass);

}