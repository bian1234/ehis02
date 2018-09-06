package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedCurePrice;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedCurePriceWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedCurePrice record);

    int insertSelective(SicmedCurePrice record);

    SicmedCurePrice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedCurePrice record);

    int updateByPrimaryKey(SicmedCurePrice record);
}