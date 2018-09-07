package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.Query;
import com.sicmed.ehis.entity.SicmedDiseaseBranch;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SicmedDiseaseBranchReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(SicmedDiseaseBranch record);

    int insertSelective(SicmedDiseaseBranch record);

    SicmedDiseaseBranch selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SicmedDiseaseBranch record);

    int updateByPrimaryKey(SicmedDiseaseBranch record);

    List<SicmedDiseaseBranch> selectByBranch(Map map);
}