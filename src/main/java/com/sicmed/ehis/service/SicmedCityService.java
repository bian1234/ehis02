package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCity;

import java.util.List;

/**
 * @Author: ykbian
 * @Date: 2018/9/5 10:38
 * @Todo:  城市服务
 */

public interface SicmedCityService extends BaseService<SicmedCity>{

    @Override
    int insertSelective(SicmedCity sicmedCity);

    @Override
    int insert(SicmedCity entity);

    @Override
    int updateSelective(SicmedCity entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedCity selectById(String id);

    @Override
    SicmedCity selectOneByParams(SicmedCity entity);

    @Override
    List<SicmedCity> findAllList(Query query);

    @Override
    List<SicmedCity> selectALLByParams(SicmedCity sicmedCity, Query query);

    @Override
    Page<SicmedCity> findPage(Page<SicmedCity> page, SicmedCity entity);
    List<SicmedCity>  getChild(String cityParentId);
}
