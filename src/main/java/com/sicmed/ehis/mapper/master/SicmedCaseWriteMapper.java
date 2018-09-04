package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedCase;

public interface SicmedCaseWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedCase record);

    int insertSelective(SicmedCase record);

    SicmedCase selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedCase record);

    int updateByPrimaryKey(SicmedCase record);
}