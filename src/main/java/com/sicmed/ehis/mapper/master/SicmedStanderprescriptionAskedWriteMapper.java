package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedStanderprescriptionAsked;

public interface SicmedStanderprescriptionAskedWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedStanderprescriptionAsked record);

    int insertSelective(SicmedStanderprescriptionAsked record);

    SicmedStanderprescriptionAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedStanderprescriptionAsked record);

    int updateByPrimaryKey(SicmedStanderprescriptionAsked record);
}