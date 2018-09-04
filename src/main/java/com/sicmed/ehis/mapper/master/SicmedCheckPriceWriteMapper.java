package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedCheckPrice;

public interface SicmedCheckPriceWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedCheckPrice record);

    int insertSelective(SicmedCheckPrice record);

    SicmedCheckPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedCheckPrice record);

    int updateByPrimaryKey(SicmedCheckPrice record);
}