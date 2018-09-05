package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedRegisteredPrice;
import org.springframework.stereotype.Repository;


@Repository
public interface SicmedRegisteredPriceWriteMapper   extends BaseWriteMapper<SicmedRegisteredPrice>{
    @Override
    int insertSelective(SicmedRegisteredPrice sicmedRegisteredPrice);

    @Override
    int insert(SicmedRegisteredPrice entity);

    @Override
    int updateSelective(SicmedRegisteredPrice entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}