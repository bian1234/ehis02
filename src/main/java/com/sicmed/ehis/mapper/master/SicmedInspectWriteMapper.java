package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import org.springframework.stereotype.Repository;


@Repository
public interface SicmedInspectWriteMapper extends BaseWriteMapper{


    @Override
    int insertSelective(Object o);

    @Override
    int insert(Object entity);

    @Override
    int updateSelective(Object entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}