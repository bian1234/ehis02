package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedInspectPrice;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedInspectPriceReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedInspectPrice record);

    int insertSelective(SicmedInspectPrice record);

    SicmedInspectPrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedInspectPrice record);

    int updateByPrimaryKey(SicmedInspectPrice record);
}