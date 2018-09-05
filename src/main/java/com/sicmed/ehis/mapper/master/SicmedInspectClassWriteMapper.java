package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedInspectClass;
import org.springframework.stereotype.Repository;


@Repository
public interface SicmedInspectClassWriteMapper extends BaseWriteMapper<SicmedInspectClass>{
    @Override
    int insertSelective(SicmedInspectClass sicmedInspectClass);

    @Override
    int insert(SicmedInspectClass entity);

    @Override
    int updateSelective(SicmedInspectClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}