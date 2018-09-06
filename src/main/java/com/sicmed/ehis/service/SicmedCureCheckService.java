package com.sicmed.ehis.service;

import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.base.util.Page;
import com.sicmed.ehis.entity.SicmedCureCheck;

import java.util.List;
import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/9/6 9:23
 * @Todo:
 */

public interface SicmedCureCheckService  extends BaseService<SicmedCureCheck> {


    @Override
    int insertSelective(SicmedCureCheck sicmedCureCheck);

    @Override
    int insert(SicmedCureCheck entity);

    @Override
    int updateSelective(SicmedCureCheck entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    @Override
    SicmedCureCheck selectById(String id);

    @Override
    SicmedCureCheck selectOneByParams(SicmedCureCheck entity);

    @Override
    List<SicmedCureCheck> findAllList(Query query);

    @Override
    List<SicmedCureCheck> selectALLByParams(SicmedCureCheck sicmedCureCheck, Query query);

    @Override
    Page<SicmedCureCheck> findPage(Page<SicmedCureCheck> page, SicmedCureCheck entity);


    /**
     * 模糊查询
     */
    List<SicmedCureCheck> searchCure(Map map);
}
