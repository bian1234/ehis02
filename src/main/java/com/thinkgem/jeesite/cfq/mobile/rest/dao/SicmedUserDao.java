package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedUser;
import org.springframework.stereotype.Repository;

/**
 * 用户信息表DAO接口
 *
 * @author Max
 * @version 2016-07-12
 */
@Repository
public interface SicmedUserDao extends CrudDao<SicmedUser> {

    /**
     * 根据字段查询
     *
     * @param str
     * @return
     */

    public SicmedUser getByTel(String userTel);

    public SicmedUser getById(String str);

    /**
     * 根据科室查询
     *
     * @param sicmedUser
     * @return
     */

    public List<SicmedUser> findByBranch(SicmedUser sicmedUser);

    /**
     * 根据部门查询用户
     *
     * @param sicmedDept
     * @return
     */

    public List<SicmedUser> findByDept(SicmedUser sicmedUser);

    /**
     * 根据挂号类型选择医生
     *
     * @param sicmedUser
     * @return
     */
    public List<SicmedUser> findList1(SicmedUser sicmedUser);

    public SicmedUser login(SicmedUser sicmedUser);

    public List<SicmedUser> findDoctorByTypeAndBranch(SicmedUser sicmedUser);

    public List<SicmedUser> findByVersion(SicmedUser sicmedUser);
}

	
