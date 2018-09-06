package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedCheckPrice;
import org.springframework.stereotype.Repository;


@Repository
public interface SicmedCheckPriceWriteMapper extends BaseWriteMapper<SicmedCheckPrice>{

    @Override
    int insertSelective(SicmedCheckPrice sicmedCheckPrice);

    @Override
    int insert(SicmedCheckPrice entity);

    @Override
    int updateSelective(SicmedCheckPrice entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}