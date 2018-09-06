package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedTwxrayCheck;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedTwxrayCheckWriteMapper {
    int insert(SicmedTwxrayCheck record);

    int insertSelective(SicmedTwxrayCheck record);
}