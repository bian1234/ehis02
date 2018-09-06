package com.sicmed.ehis.mapper.slaver;

import com.sicmed.ehis.base.BaseReadMapper;
import com.sicmed.ehis.entity.SicmedCureCheck;
import org.apache.ibatis.ognl.ASTSequence;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SicmedCureCheckReadMapper extends BaseReadMapper<SicmedCureCheck>{


    /**
     * 模糊查询
     */
    public List<SicmedCureCheck> searchCure(Map map);
}