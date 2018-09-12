package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.base.BaseService;
import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedTwxrayCheck;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SicmedTwxrayCheckReadMapper   extends BaseReadMapper<SicmedTwxrayCheck> {

    @Override
    SicmedTwxrayCheck selectById(String id);

    @Override
    SicmedTwxrayCheck selectOneByParams(SicmedTwxrayCheck entity);

    @Override
    List<SicmedTwxrayCheck> findAllList(Query query);

    @Override
    List<SicmedTwxrayCheck> selectALLByParams(@Param("sicmedTwxrayCheck") SicmedTwxrayCheck sicmedTwxrayCheck,
                                              @Param("query") Query query);
}