package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedTwxrayClass;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface SicmedTwxrayClassReadMapper   extends BaseReadMapper<SicmedTwxrayClass>{

    @Override
    SicmedTwxrayClass selectById(String id);

    @Override
    SicmedTwxrayClass selectOneByParams(SicmedTwxrayClass entity);

    @Override
    List<SicmedTwxrayClass> findAllList(Query query);

    @Override
    List<SicmedTwxrayClass> selectALLByParams(SicmedTwxrayClass e, Query query);

    int deleteByPrimaryKey(String id);

    int insert(SicmedTwxrayClass record);

    int insertSelective(SicmedTwxrayClass record);

    SicmedTwxrayClass selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedTwxrayClass record);

    int updateByPrimaryKey(SicmedTwxrayClass record);
}