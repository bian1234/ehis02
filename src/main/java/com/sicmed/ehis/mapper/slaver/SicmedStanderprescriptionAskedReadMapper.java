package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedStanderprescriptionAsked;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedStanderprescriptionAskedReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedStanderprescriptionAsked record);

    int insertSelective(SicmedStanderprescriptionAsked record);

    SicmedStanderprescriptionAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedStanderprescriptionAsked record);

    int updateByPrimaryKey(SicmedStanderprescriptionAsked record);
}