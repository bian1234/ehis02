package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedBaseCode;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedBaseCodeWriteMapper extends BaseWriteMapper<SicmedBaseCode>{
    @Override
    int insertSelective(SicmedBaseCode sicmedBaseCode);

    @Override
    int insert(SicmedBaseCode entity);

    @Override
    int updateSelective(SicmedBaseCode entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}