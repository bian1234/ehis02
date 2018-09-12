package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedEntrustedAsked;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/10 13:35
 * @Todo:   嘱托医嘱服务
 */

public interface SicmedEntrustedAskedService   extends BaseService<SicmedEntrustedAsked> {

    @Override
    int insertSelective(SicmedEntrustedAsked sicmedEntrustedAsked);

    @Override
    int insert(SicmedEntrustedAsked entity);

    @Override
    int updateSelective(SicmedEntrustedAsked entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedEntrustedAsked selectById(String id);



    @Override
    List<SicmedEntrustedAsked> findAllList(Query query);

    @Override
    List<SicmedEntrustedAsked> selectALLByParams(SicmedEntrustedAsked sicmedEntrustedAsked, Query query);

    @Override
    Page<SicmedEntrustedAsked> findPage(Page<SicmedEntrustedAsked> page, SicmedEntrustedAsked entity);
}
