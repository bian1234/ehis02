/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedAsked;
import org.springframework.stereotype.Repository;

/**
 * 医嘱信息DAO接口
 *
 * @author XUE
 * @version 2016-07-12
 */
@Repository
public interface SicmedAskedDao extends CrudDao<SicmedAsked> {
    public List<SicmedAsked> getAskedbyClass(String askedClass);

    public SicmedAsked findaskedByaskedClass(String askedClass);

    public SicmedAsked getById(String id);

    //复制表 表结构和表数据一起复制
    @Update("CREATE TABLE ${copyTableName} LIKE sicmed_asked")
    public void copyTable(SicmedAsked sicmedAsked);

    @Insert("INSERT INTO ${copyTableName} SELECT * FROM sicmed_asked")
    public void insertTable(SicmedAsked sicmedAsked);

    //重新命名表
    @Update("DELETE FROM sicmed_asked")
    public void clearTable();

    public SicmedAsked getOnly(SicmedAsked sicmedAsked);

}