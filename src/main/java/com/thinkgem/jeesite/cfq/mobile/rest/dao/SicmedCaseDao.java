/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import org.apache.ibatis.annotations.Update;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;
import org.springframework.stereotype.Repository;

/**
 * 病历表DAO接口
 *
 * @author Max
 * @version 2016-07-18
 */
@Repository
public interface SicmedCaseDao extends CrudDao<SicmedCase> {

    public List<SicmedCase> selectPatientCase(String patientId);

    public SicmedCase getByEntity(SicmedCase sicmedCase);

    public List<SicmedCase> findList1(SicmedCase sicmedCase);

    /*通过时间来查寻相应的病历信息*/
    public List<SicmedCase> findListWithDate(SicmedCase sicmedCase);

    //复制表 表结构和表数据一起复制
    @Update("CREATE TABLE ${copyTableName} LIKE sicmed_case")
    public int copyTable(SicmedCase sicmedCase);

    @Update("INSERT INTO ${copyTableName} SELECT * FROM sicmed_case")
    public int insertTable(SicmedCase sicmedCase);

    //重新命名表
    @Update("DELETE FROM sicmed_case")
    public int clearTable();

}