package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedStanderprescriptionDisease;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedStanderprescriptionDiseaseWriteMapper   extends BaseWriteMapper<SicmedStanderprescriptionDisease>{
    @Override
    int insertSelective(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease);

    @Override
    int insert(SicmedStanderprescriptionDisease entity);

    @Override
    int updateSelective(SicmedStanderprescriptionDisease sicmedStanderprescriptionDisease);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}