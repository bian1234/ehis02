/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatient;
import org.springframework.stereotype.Repository;

/**
 * 患者信息表DAO接口
 *
 * @author Max
 * @version 2016-07-12
 */
@Repository
public interface SicmedPatientDao extends CrudDao<SicmedPatient> {


    /**
     * 获取单条数据
     *
     * @param sicmedPatient
     * @return
     */
    public SicmedPatient getByEntity(SicmedPatient sicmedPatient);

    //复制表 表结构和表数据一起复制
    @Update("CREATE TABLE ${copyTableName} LIKE sicmed_patient")
    public void copyTable(SicmedPatient sicmedPatient);

    @Insert("INSERT INTO ${copyTableName} SELECT * FROM sicmed_patient")
    public void insertTable(SicmedPatient sicmedPatient);

    //重新命名表
    @Update("DELETE FROM sicmed_patient")
    public void clearTable();

    /**
     * 模糊搜索患者 接口
     *
     * @param sicmedPatient
     * @return List<SicmedPatient>
     * @author Max
     */
    public List<SicmedPatient> findListLike(SicmedPatient sicmedPatient);

    public List<SicmedPatient> findLike(SicmedPatient sicmedPatient);

}