package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedUserWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedUser record);

    int insertSelective(SicmedUser record);

    SicmedUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedUser record);

    int updateByPrimaryKeyWithBLOBs(SicmedUser record);

    int updateByPrimaryKey(SicmedUser record);
}