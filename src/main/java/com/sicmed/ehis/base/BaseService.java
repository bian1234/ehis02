package com.sicmed.ehis.base;

import com.sicmed.ehis.base.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//@Transactional(readOnly = true)
public interface BaseService<E> {

    /**
     * 插入数据，优先使用这个方法
     */
    @Transactional(readOnly = false)
    int insertSelective(E e);


    /**
     * 插入数据
     * @param entity
     * @return
     */
    @Transactional(readOnly = false)
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
    @Transactional(readOnly = false)
    public int deleteById(String id);

    /**
     * 删除数据（一般为逻辑删除，更新del_flag字段为1）
     * @return
     */
    @Transactional(readOnly = false)
    public int logicDelete(String id);






    /**
     * 通过id获取单条数据
     */
    E selectById(String id);

    /**
     * 通过其他参数获取单条数据
     * @param entity
     * @return
     */
    E selectOneByParams(E entity);

    /**
     * 查询所有数据列表
     * @see public List<T> findAllList(T entity)
     * @return
     */
    @Deprecated
    List<E> findAllList(Query query);


    /**
     * 根据其他信息查询数据 ，如果需要分页，请设置分页对象，如：entity.setPage(new Page<T>());
     */
    List<E> selectALLByParams(E e,Query query);


    /**
     * 查询分页数据
     * @param page 分页对象
     * @param entity
     * @return
     */
    public Page<E> findPage(Page<E> page, E entity);




}
