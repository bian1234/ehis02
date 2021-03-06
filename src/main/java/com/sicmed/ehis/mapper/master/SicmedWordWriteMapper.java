package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedWord;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedWordWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedWord record);

    int insertSelective(SicmedWord record);

    SicmedWord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedWord record);

    int updateByPrimaryKey(SicmedWord record);
}