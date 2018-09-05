package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedCureClass;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedCureClassWriteMapper extends BaseWriteMapper<SicmedCureClass>{
    @Override
    int insertSelective(SicmedCureClass sicmedCureClass);

    @Override
    int insert(SicmedCureClass entity);

    @Override
    int updateSelective(SicmedCureClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}