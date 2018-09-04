package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedInspect;

public interface SicmedInspectWriteMapper {
    int insert(SicmedInspect record);

    int insertSelective(SicmedInspect record);
}