/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.dao;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户DAO接口
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Repository
public interface PrescriptionUserDao extends CrudDao<PrescriptionUser> {

    /**
     * 根据登录名称查询用户
     *
     * @param loginName
     * @return
     */
    public PrescriptionUser getByLoginName(PrescriptionUser prescriptionUser);

    /**
     * 通过OfficeId获取用户列表，仅返回用户id和name（树查询用户时用）
     *
     * @param user
     * @return
     */
    public List<PrescriptionUser> findUserByOfficeId(PrescriptionUser prescriptionUser);

    /**
     * 查询全部用户数目
     *
     * @return
     */
    public long findAllCount(PrescriptionUser prescriptionUser);

    /**
     * 更新用户密码
     *
     * @param user
     * @return
     */
    public int updatePasswordById(PrescriptionUser prescriptionUser);

    /**
     * 更新登录信息，如：登录IP、登录时间
     *
     * @param user
     * @return
     */
    public int updateLoginInfo(PrescriptionUser prescriptionUser);

    /**
     * 删除用户角色关联数据
     *
     * @param user
     * @return
     */
    public int deleteUserRole(PrescriptionUser prescriptionUser);

    /**
     * 插入用户角色关联数据
     *
     * @param user
     * @return
     */
    public int insertUserRole(PrescriptionUser prescriptionUser);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public int updateUserInfo(PrescriptionUser prescriptionUser);

}
