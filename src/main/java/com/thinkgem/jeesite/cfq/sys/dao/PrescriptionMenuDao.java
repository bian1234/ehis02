/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.dao;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单DAO接口
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Repository
public interface PrescriptionMenuDao extends CrudDao<PrescriptionMenu> {

    public List<PrescriptionMenu> findByParentIdsLike(PrescriptionMenu prescriptionMenu);

    public List<PrescriptionMenu> findByUserId(PrescriptionMenu prescriptionMenu);

    public int updateParentIds(PrescriptionMenu prescriptionMenu);

    public int updateSort(PrescriptionMenu prescriptionMenu);

}
