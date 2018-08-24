package com.thinkgem.jeesite.cfq.mobile.rest.dao;


import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedRestart;
import org.springframework.stereotype.Repository;

@Repository
public interface SicmedRestartDao extends CrudDao<SicmedRestart> {

    public void restartPatientPrice();
}
