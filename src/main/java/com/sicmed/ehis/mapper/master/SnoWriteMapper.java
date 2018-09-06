package com.sicmed.ehis.mapper.master;

import com.sicmed.ehis.entity.Sno;
import org.springframework.stereotype.Repository;

@Repository
public interface SnoWriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sno record);

    int insertSelective(Sno record);

    Sno selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sno record);

    int updateByPrimaryKey(Sno record);
}