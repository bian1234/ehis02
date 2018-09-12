package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedEntrustedAsked;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedEntrustedAskedWriteMapper extends BaseWriteMapper<SicmedEntrustedAsked>{
    int deleteByPrimaryKey(String id);

    int insert(SicmedEntrustedAsked record);

    int insertSelective(SicmedEntrustedAsked record);


    SicmedEntrustedAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedEntrustedAsked record);

    int updateByPrimaryKey(SicmedEntrustedAsked record);

    int logicDelete(String id);

}