package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedTwxrayCheck;

public interface SicmedTwxrayCheckWriteMapper {
    int insert(SicmedTwxrayCheck record);

    int insertSelective(SicmedTwxrayCheck record);
}