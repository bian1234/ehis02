package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import org.apache.ibatis.annotations.Update;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRegistered;
import org.springframework.stereotype.Repository;

/**
 * 挂号信息表DAO接口
 *
 * @author Max
 * @version 2016-07-12
 */
@Repository
public interface SicmedRegisteredDao extends CrudDao<SicmedRegistered> {

    //复制表 表结构和表数据一起复制
    @Update("CREATE TABLE ${copyTableName} LIKE sicmed_registered")
    public int copyTable(SicmedRegistered sicmedRegistered);

    @Update("INSERT INTO ${copyTableName} SELECT * FROM sicmed_registered")
    public int insertTable(SicmedRegistered sicmedRegistered);

    //重新命名表
    @Update("DELETE FROM sicmed_registered")
    public int clearTable();

    public List<SicmedRegistered> findList1(SicmedRegistered sicmedRegistered);

    //web挂号查询统计
    public List<SicmedRegistered> findList2(SicmedRegistered sicmedRegistered);

    public SicmedRegistered getByP(SicmedRegistered sicmedRegistered);

    public SicmedRegistered getByEntity(SicmedRegistered sicmedRegistered);

    public List<SicmedRegistered> findByDAndB(SicmedRegistered sicmedRegistered);

    public List<SicmedRegistered> findRefuntOrChange(SicmedRegistered sicmedRegistered);

    public List<SicmedRegistered> findHistoryListByUpdateUser(SicmedRegistered sicmedRegistered);

    public List<SicmedRegistered> findHistoryListByCreateUser(SicmedRegistered sicmedRegistered);

    public List<SicmedRegistered> findByParamAndD(SicmedRegistered sicmedRegistered);

    public List<SicmedRegistered> findHistoryListByDeleteUser(SicmedRegistered sicmedRegistered);


}