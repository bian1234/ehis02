package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedCureCheck;

public interface SicmedCureCheckReadMapper {
    int insert(SicmedCureCheck record);

    int insertSelective(SicmedCureCheck record);
}