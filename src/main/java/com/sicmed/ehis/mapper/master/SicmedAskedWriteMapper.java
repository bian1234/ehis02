//package com.sicmed.ehis.mapper.master;
//
//import com.sicmed.ehis.base.BaseWriteMapper;
//import com.sicmed.ehis.entity.SicmedAsked;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Update;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface SicmedAskedWriteMapper   extends BaseWriteMapper<SicmedAsked>{
//
//
//    //复制表 表结构和表数据一起复制
//    @Update("CREATE TABLE ${copyTableName} LIKE sicmed_asked")
//    public void copyTable(SicmedAsked sicmedAsked);
//
//    @Insert("INSERT INTO ${copyTableName} SELECT * FROM sicmed_asked")
//    public void insertTable(SicmedAsked sicmedAsked);
//
//    //重新命名表
//    @Update("DELETE FROM sicmed_asked")
//    public void clearTable();
//
//
//}