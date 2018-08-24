/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.dao;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import org.springframework.stereotype.Repository;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionRole;

/**
 * 角色DAO接口
 *
 * @author ThinkGem
 * @version 2013-12-05
 */
@Repository
public interface PrescriptionRoleDao extends CrudDao<PrescriptionRole> {

    public PrescriptionRole getByName(PrescriptionRole prescriptionRole);

    public PrescriptionRole getByEnname(PrescriptionRole prescriptionRole);

    /**
     * 维护角色与菜单权限关系
     *
     * @param role
     * @return
     */
    public int deleteRoleMenu(PrescriptionRole prescriptionRole);

    public int insertRoleMenu(PrescriptionRole prescriptionRole);

    /**
     * 维护角色与公司部门关系
     *
     * @param role
     * @return
     */
    public int deleteRoleOffice(PrescriptionRole prescriptionRole);

    public int insertRoleOffice(PrescriptionRole prescriptionRole);

}
