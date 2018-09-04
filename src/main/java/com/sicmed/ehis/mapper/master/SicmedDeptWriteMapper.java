package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.base.BaseWriteMapper;
import com.sicmed.ehis.entity.SicmedDept;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedDeptWriteMapper  extends BaseWriteMapper<SicmedDept> {
    @Override
    int insertSelective(SicmedDept sicmedDept);

    @Override
    int insert(SicmedDept entity);

    @Override
    int updateSelective(SicmedDept entity);

    @Override
    int deleteById(String id);

    @Override
    int logicDelete(String id);
}