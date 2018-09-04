package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedTwxrayCheck;

public interface SicmedTwxrayCheckReadMapper {
    int insert(SicmedTwxrayCheck record);

    int insertSelective(SicmedTwxrayCheck record);
}