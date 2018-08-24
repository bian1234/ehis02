package com.thinkgem.jeesite.cfq.mobile.rest.setBean;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.SicmedDiseaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedDisease;

/**
 * @author Max
 * @version 2016-07-12
 */
public class SicmedDiseaseSetBean {

    public static SicmedDisease setSDB(SicmedDiseaseBean sicmedDiseaseBean) {

        SicmedDisease sicmedDisease = new SicmedDisease();
        // sicmedDisease.setCreateBy(sicmedDiseaseBean.get);
        // sicmedDisease.setCreateDate(sicmedDiseaseBean.get);
        // sicmedDisease.setCurrentUser(sicmedDiseaseBean.get);
        // sicmedDisease.setDelFlag(sicmedDiseaseBean.get);
        // sicmedDisease.setDiseaseClass(sicmedDiseaseBean.get);
        sicmedDisease.setDiseaseCode(sicmedDiseaseBean.getDiseaseCode());
        sicmedDisease.setDiseaseName(sicmedDiseaseBean.getDiseaseName());
        sicmedDisease.setDiseaseNameEnglish(sicmedDiseaseBean.getDiseaseNameEnglish());
        sicmedDisease.setDiseaseNamePmpa(sicmedDiseaseBean.getDiseaseNamePmpa());
        // sicmedDisease.setId(id);
        // sicmedDisease.setIsNewRecord(isNewRecord);
        // sicmedDisease.setPage(page)
        // sicmedDisease.setRemarks(remarks);
        // sicmedDisease.setSqlMap(sqlMap);
        // sicmedDisease.setUpdateBy(updateBy);
        // sicmedDisease.setUpdateDate(updateDate);

        return sicmedDisease;

    }

}