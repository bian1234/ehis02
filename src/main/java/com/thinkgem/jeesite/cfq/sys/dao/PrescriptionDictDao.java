/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.sys.dao;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionDict;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 字典DAO接口
 *
 * @author ThinkGem
 * @version 2014-05-16
 */
@Repository
public interface PrescriptionDictDao extends CrudDao<PrescriptionDict> {

    public List<String> findTypeList(PrescriptionDict prescriptionDict);

}
