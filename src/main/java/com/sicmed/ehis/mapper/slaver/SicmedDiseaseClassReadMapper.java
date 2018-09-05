package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedDiseaseClass;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedDiseaseClassReadMapper extends BaseReadMapper<SicmedDiseaseClass>{
    @Override
    SicmedDiseaseClass selectById(String id);

    @Override
    SicmedDiseaseClass selectOneByParams(SicmedDiseaseClass entity);

    @Override
    List<SicmedDiseaseClass> findAllList(Query query);

    @Override
    List<SicmedDiseaseClass> selectALLByParams(SicmedDiseaseClass e, Query query);


}