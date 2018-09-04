package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedDept;

public interface SicmedDeptWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDept record);

    int insertSelective(SicmedDept record);

    SicmedDept selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDept record);

    int updateByPrimaryKey(SicmedDept record);
}