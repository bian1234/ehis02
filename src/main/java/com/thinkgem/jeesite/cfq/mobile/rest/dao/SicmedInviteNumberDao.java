/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.dao;

import com.thinkgem.jeesite.cfq.common.persistence.CrudDao;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInviteNumber;
import org.springframework.stereotype.Repository;

/**
 * 账号激活码DAO接口
 *
 * @author Max
 * @version 2016-07-19
 */
@Repository
public interface SicmedInviteNumberDao extends CrudDao<SicmedInviteNumber> {

    public SicmedInviteNumber getByEntity(SicmedInviteNumber sicmedInviteNumber);

}