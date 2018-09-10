package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedPatientDisease;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedPatientDiseaseReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedPatientDisease record);

    int insertSelective(SicmedPatientDisease record);

    SicmedPatientDisease selectByPrimaryKey(String id);

    List<SicmedPatientDisease> selectOneByParams(SicmedPatientDisease record);
    int updateByPrimaryKeySelective(SicmedPatientDisease record);

    int updateByPrimaryKey(SicmedPatientDisease record);
    List<SicmedPatientDisease> getByCase(String caseCode);


}