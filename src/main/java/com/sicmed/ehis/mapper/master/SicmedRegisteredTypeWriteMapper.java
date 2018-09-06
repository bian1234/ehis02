package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedRegisteredType;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedRegisteredTypeWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedRegisteredType record);

    int insertSelective(SicmedRegisteredType record);

    SicmedRegisteredType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedRegisteredType record);

    int updateByPrimaryKey(SicmedRegisteredType record);
}