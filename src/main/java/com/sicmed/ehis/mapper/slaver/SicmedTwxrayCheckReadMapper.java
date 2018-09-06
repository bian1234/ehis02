package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedTwxrayCheck;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedTwxrayCheckReadMapper {
    int insert(SicmedTwxrayCheck record);

    int insertSelective(SicmedTwxrayCheck record);
}