package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.entity.Sno;
import org.springframework.stereotype.Repository;

@Repository
public interface SnoReadMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sno record);

    int insertSelective(Sno record);

    Sno selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sno record);

    int updateByPrimaryKey(Sno record);
}