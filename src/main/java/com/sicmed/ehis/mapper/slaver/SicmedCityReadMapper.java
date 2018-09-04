package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedCity;

public interface SicmedCityReadMapper {
    int deleteByPrimaryKey(Short cityId);

    int insert(SicmedCity record);

    int insertSelective(SicmedCity record);

    SicmedCity selectByPrimaryKey(Short cityId);

    int updateByPrimaryKeySelective(SicmedCity record);

    int updateByPrimaryKey(SicmedCity record);
}