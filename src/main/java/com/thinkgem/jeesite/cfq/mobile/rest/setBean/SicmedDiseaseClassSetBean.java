package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseClassBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDiseaseClass;

/**
 * @author Max
 * @version 2016-07-12
 */
public class SicmedDiseaseClassSetBean {

    public static SicmedDiseaseClass setSDCB(SicmedDiseaseClassBean sicmedDiseaseClassBean) {

        SicmedDiseaseClass sicmedDiseaseClass = new SicmedDiseaseClass();

        sicmedDiseaseClass.setDiseaseClassCode(sicmedDiseaseClassBean.getDiseaseClassCode());
        sicmedDiseaseClass.setDiseaseClassName(sicmedDiseaseClassBean.getDiseaseClassName());

        // sicmedDiseaseClass.setCreateBy(sicmedDiseaseClassBean.get);
        // sicmedDiseaseClass.setCreateDate(sicmedDiseaseClassBean.get);
        // sicmedDiseaseClass.setCurrentUser(sicmedDiseaseClassBean.set);
        // sicmedDiseaseClass.setDelFlag(sicmedDiseaseClassBean.set);
        // sicmedDiseaseClass.setDiseaseList(sicmedDiseaseClassBean.get);
        // sicmedDiseaseClass.setId(sicmedDiseaseClassBean.get);
        // sicmedDiseaseClass.setIsNewRecord(isNewRecord);
        // sicmedDiseaseClass.setPage(page);
        // sicmedDiseaseClass.setRemarks(remarks);
        // sicmedDiseaseClass.setSqlMap(sqlMap);
        // sicmedDiseaseClass.setUpdateBy(updateBy);
        // sicmedDiseaseClass.setUpdateDate(updateDate);

        return sicmedDiseaseClass;

    }

}