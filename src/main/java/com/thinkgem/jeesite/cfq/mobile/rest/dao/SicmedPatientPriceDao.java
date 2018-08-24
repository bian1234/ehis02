package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import org.apache.ibatis.annotations.Update;


import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedPatientPrice;
import org.springframework.stereotype.Repository;

/**
 * 患者价格明细表DAO接口
 *
 * @author 丁学志
 * @version 2016-07-18
 */
@Repository
public interface SicmedPatientPriceDao extends CrudDao<SicmedPatientPrice> {

    public SicmedPatientPrice getPatientPrice(SicmedPatientPrice patientPrice);

    public List<SicmedPatientPrice> findListWithPatient(SicmedPatientPrice patientPrice);

    public SicmedPatientPrice getByEntity(SicmedPatientPrice sicmedPatientPrice);

    //复制表 表结构和表数据一起复制
    @Update("CREATE TABLE ${copyTableName} LIKE sicmed_patient_price")
    public int copyTable(SicmedPatientPrice sicmedPatientPrice);

    @Update("INSERT INTO ${copyTableName} SELECT * FROM sicmed_patient_price")
    public int insertTable(SicmedPatientPrice sicmedPatientPrice);

    //重新命名表
    @Update("DELETE FROM sicmed_patient_price")
    public int clearTable();

    //退号同时删除挂号费
    public void deletePrice(SicmedPatientPrice sicmedPatientPrice);

    public List<SicmedPatientPrice> findListUUID(SicmedPatientPrice patientPrice);

    public List<SicmedPatientPrice> findHistoryList(SicmedPatientPrice sicmedPatientPrice);

}