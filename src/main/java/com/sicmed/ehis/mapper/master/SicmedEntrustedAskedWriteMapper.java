package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.SicmedEntrustedAsked;

public interface SicmedEntrustedAskedWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedEntrustedAsked record);

    int insertSelective(SicmedEntrustedAsked record);

    SicmedEntrustedAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedEntrustedAsked record);

    int updateByPrimaryKey(SicmedEntrustedAsked record);
}