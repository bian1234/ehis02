package com.sicmed.ehis.base;


public interface BaseWriteMapper<E> {

    /**
     * 插入数据，优先使用这个方法
     */
    int insertSelective(E e);


    /**
     * 插入数据
     * @param entity
     * @return
     */
    public int insert(E entity);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    public int updateSelective(E entity);

    /**
     * 删除数据
     * @param id
     * @see public int delete(T entity)
     * @return
     */
    @Deprecated
    public int deleteById(String id);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * @return
     */
    public int logicDelete(String id);
}