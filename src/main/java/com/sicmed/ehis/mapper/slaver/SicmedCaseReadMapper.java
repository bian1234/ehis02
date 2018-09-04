package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedCase;

public interface SicmedCaseReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedCase record);

    int insertSelective(SicmedCase record);

    SicmedCase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedCase record);

    int updateByPrimaryKey(SicmedCase record);
}