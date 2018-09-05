package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedDiseaseClass;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedDiseaseClassWriteMapper   extends BaseWriteMapper<SicmedDiseaseClass>{

    @Override
    int updateSelective(SicmedDiseaseClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    int deleteByPrimaryKey(String id);

    int insert(SicmedDiseaseClass record);

    int insertSelective(SicmedDiseaseClass record);


    int updateByPrimaryKeySelective(SicmedDiseaseClass record);

    int updateByPrimaryKey(SicmedDiseaseClass record);
}