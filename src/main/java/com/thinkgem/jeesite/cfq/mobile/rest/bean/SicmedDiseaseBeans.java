/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * 疾病表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    // private SicmedDiseaseClassBean diseaseClassBean; // 疾病类别编码(对应疾病编码表)

    private List<SicmedDiseaseBean> sicmedDiseaseBeans = new ArrayList<SicmedDiseaseBean>();

    public List<SicmedDiseaseBean> getSicmedDiseaseBeans() {
        return sicmedDiseaseBeans;
    }

    public void setSicmedDiseaseBeans(List<SicmedDiseaseBean> sicmedDiseaseBeans) {
        this.sicmedDiseaseBeans = sicmedDiseaseBeans;
    }

}