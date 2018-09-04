package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedAskedClass;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedAskedClassWriteMapper extends BaseWriteMapper<SicmedAskedClass>{


    @Override
    int insertSelective(SicmedAskedClass sicmedAskedClass);

    @Override
    int insert(SicmedAskedClass entity);

    @Override
    int updateSelective(SicmedAskedClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}