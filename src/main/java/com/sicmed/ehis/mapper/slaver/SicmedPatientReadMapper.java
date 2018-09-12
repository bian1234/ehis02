package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedPatient;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedPatientReadMapper extends BaseService<SicmedPatient>{
    int deleteByPrimaryKey(String id);

    int insert(SicmedPatient record);

    int insertSelective(SicmedPatient record);

    SicmedPatient selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedPatient record);

    int updateByPrimaryKey(SicmedPatient record);

    @Override
    List<SicmedPatient> selectALLByParams(@Param("sicmedPatient") SicmedPatient sicmedPatient, @Param("query") Query query);
}