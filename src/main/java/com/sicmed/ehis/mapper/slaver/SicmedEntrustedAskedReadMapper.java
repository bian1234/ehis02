package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.SicmedEntrustedAsked;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedEntrustedAskedReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedEntrustedAsked record);

    int insertSelective(SicmedEntrustedAsked record);

    SicmedEntrustedAsked selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedEntrustedAsked record);

    int updateByPrimaryKey(SicmedEntrustedAsked record);
}