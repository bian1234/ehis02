package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedTwxrayClass;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Repository
public interface SicmedTwxrayClassWriteMapper extends BaseWriteMapper<SicmedTwxrayClass>{

    @Override
    int updateSelective(SicmedTwxrayClass entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);

    int deleteByPrimaryKey(String id);

    int insert(SicmedTwxrayClass record);

    int insertSelective(SicmedTwxrayClass record);


    int updateByPrimaryKeySelective(SicmedTwxrayClass record);

    int updateByPrimaryKey(SicmedTwxrayClass record);
}