//package com.sicmed.ehis.service;
//
//import com.sicmed.ehis.base.util.Page;
//import com.sicmed.ehis.entity.SicmedAsked;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// * @Author: ykbian
// * @Date: 2018/9/3 16:30
// * @Todo:
// */
//
//public interface SicmedAskedService {
//
//    public SicmedAsked get(String id);
//
//    //根据医嘱类别找到医嘱
//    public List<SicmedAsked> getAskedClass(String askedClass);
//
//    public List<SicmedAsked> findList(SicmedAsked sicmedAsked);
//
//    public Page<SicmedAsked> findPage(Page<SicmedAsked> page, SicmedAsked sicmedAsked);
//
//    public int save(SicmedAsked sicmedAsked);
//
//    public int delete(SicmedAsked sicmedAsked);
//
//    public SicmedAsked findaskedByaskedClass(String askedClass);
//
//    public int update(SicmedAsked sicmedAsked);
//
//    public SicmedAsked getById(String id);
//
//    //复制数据表 表结构和表中数据 复制 清空原表
//    public void clearTable(String copyName);
//
//
//    public SicmedAsked getOnly(SicmedAsked sicmedAsked);
//}
