//package com.sicmed.ehis.mapper.slaver;
//
//import com.sicmed.ehis.base.BaseReadMapper;
//import com.sicmed.ehis.base.util.Page;
//import com.sicmed.ehis.entity.SicmedAsked;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Update;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface SicmedAskedReadMapper   extends BaseReadMapper<SicmedAsked>{
//
//    public List<SicmedAsked> getAskedbyClass(String askedClass);
//
//    public SicmedAsked findaskedByaskedClass(String askedClass);
//
//    public SicmedAsked getById(String id);
//
//
//
//    public SicmedAsked getOnly(SicmedAsked sicmedAsked);
//}