package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedInspect;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface SicmedInspectReadMapper   extends BaseReadMapper{
    @Override
    Object selectById(String id);

    @Override
    Object selectOneByParams(Object entity);

    @Override
    List findAllList(Query query);

    @Override
    List selectALLByParams(Object e, Query query);



    /**
     * 模糊查询
     */
    List<SicmedInspect>  findListLike(Map map);
}