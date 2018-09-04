package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedBaseCode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedBaseCodeReadMapper extends BaseReadMapper<SicmedBaseCode>{
    @Override
    SicmedBaseCode selectById(String id);

    @Override
    SicmedBaseCode selectOneByParams(SicmedBaseCode entity);

    @Override
    List<SicmedBaseCode> findAllList(Query query);

    @Override
    default List<SicmedBaseCode> selectALLByParams(SicmedBaseCode e, Query query) {
        return null;
    }
}