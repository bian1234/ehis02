package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedInspect;

public interface SicmedInspectReadMapper {
    int insert(SicmedInspect record);

    int insertSelective(SicmedInspect record);
}