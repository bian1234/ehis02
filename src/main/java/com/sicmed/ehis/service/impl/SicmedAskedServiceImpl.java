//package com.sicmed.ehis.service.impl;
//
//import com.sicmed.ehis.base.util.Page;
//import com.sicmed.ehis.entity.SicmedAsked;
//import com.sicmed.ehis.mapper.master.SicmedAskedWriteMapper;
//
//import com.sicmed.ehis.mapper.slaver.SicmedAskedReadMapper;
//import com.sicmed.ehis.service.SicmedAskedService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//
///**
// * @Author: ykbian
// * @Date: 2018/9/3 16:31
// * @Todo:  医嘱信息服务实现类
// */
//@Service
//@Transactional(readOnly = true)
//public class SicmedAskedServiceImpl  implements SicmedAskedService {
//
//    @Autowired
//    SicmedAskedWriteMapper sicmedAskedWriteMapper;
//
//    @Autowired
//    SicmedAskedReadMapper sicmedAskedReadMapper;
//
//    @Override
//    public SicmedAsked get(String id) {
//        return sicmedAskedReadMapper.selectById(id);
//    }
//
//    //根据医嘱类别找到医嘱
//    @Override
//    public List<SicmedAsked> getAskedClass(String askedClass) {
//        return sicmedAskedReadMapper.getAskedbyClass(askedClass);
//    }
//    @Override
//    public List<SicmedAsked> findList(SicmedAsked sicmedAsked) {
//        return sicmedAskedReadMapper.findList(sicmedAsked);
//    }
//    @Override
//    public Page<SicmedAsked> findPage(Page<SicmedAsked> page, SicmedAsked sicmedAsked) {
//        return sicmedAskedReadMapper.findPage(page, sicmedAsked);
//    }
//    @Override
//    @Transactional(readOnly = false)
//    public int save(SicmedAsked sicmedAsked) {
//        return sicmedAskedWriteMapper.insert(sicmedAsked);
//    }
//    @Override
//    @Transactional(readOnly = false)
//    public int delete(SicmedAsked sicmedAsked) {
//        return sicmedAskedWriteMapper.delete(sicmedAsked.getId());
//    }
//    @Override
//    public SicmedAsked findaskedByaskedClass(String askedClass) {
//        return sicmedAskedReadMapper.findaskedByaskedClass(askedClass);
//    }
//    @Override
//    @Transactional(readOnly = false)
//    public int update(SicmedAsked sicmedAsked) {
//        return  sicmedAskedWriteMapper.updateByPrimaryKeySelective(sicmedAsked);
//    }
//    @Override
//    @Transactional(readOnly = false)
//    public SicmedAsked getById(String id) {
//        return sicmedAskedReadMapper.selectById(id);
//    }
//    @Override
//    //复制数据表 表结构和表中数据 复制 清空原表
//    @Transactional(readOnly=false)
//    public void clearTable(String copyName){
//        SicmedAsked sicmedAsked = new SicmedAsked();
//        sicmedAsked.setCopyTableName(copyName);
//        sicmedAskedWriteMapper.copyTable(sicmedAsked);
//        sicmedAskedWriteMapper.insertTable(sicmedAsked);
//        sicmedAskedWriteMapper.clearTable();
//        //patientPriceDao.clearTable();
//    }
//
//    @Override
//    public SicmedAsked getOnly(SicmedAsked sicmedAsked) {
//        return sicmedAskedReadMapper.getOnly(sicmedAsked);
//    }
//}
