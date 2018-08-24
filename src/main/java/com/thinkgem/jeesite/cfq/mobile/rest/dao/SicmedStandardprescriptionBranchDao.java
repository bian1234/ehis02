/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import java.util.List;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedStandardprescriptionBranch;
import org.springframework.stereotype.Repository;

/**
 * 医生常用疾病表DAO接口
 *
 * @author Max
 * @version 2016-07-18
 */
@Repository
public interface SicmedStandardprescriptionBranchDao extends CrudDao<SicmedStandardprescriptionBranch> {
    public SicmedStandardprescriptionBranch getBranchid(String id);

    public List<SicmedStandardprescriptionBranch> findstandardbybranch(SicmedStandardprescriptionBranch sicmedStandardprescriptionBranch);
}