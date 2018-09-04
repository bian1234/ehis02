package com.sicmed.ehis.base;

import java.util.List;

public interface BaseReadMapper<T>{


    /**
     * 通过id获取单条数据
     */
    T selectById(String id);

    /**
     * 通过其他参数获取单条数据
     * @param entity
     * @return
     */
     T selectOneByParams(T entity);

    /**
     * 查询所有数据列表
     * @see public List<T> findAllList(T entity)
     * @return
     */
    @Deprecated
     List<T> findAllList(Query query);


    /**
     * 根据其他信息查询数据 ，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     */
    List<T> selectALLByParams(T e,Query query);

//    /**
//     * 2016-11-28 薛宝松添加
//     * 模糊查询数据列表,如需分页,请设置分页对象,如:entity.setPage(new Page<T>());
//     * @param entity
//     * @return
//     */
//    public List<T> findLike(T entity);

//    /**
//     * 查询所有数据列表
//     * @param entity
//     * @return
//     */
//    public List<T> findAllList(T entity);




}