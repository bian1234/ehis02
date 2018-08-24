/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 疾病类别表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedDiseaseClassBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    // private List<SicmedDisease> diseaseList = Lists.newArrayList(); // 拥有疾病

    private List<SicmedDiseaseClassBean> sicmedDiseaseClassBeans = new ArrayList<SicmedDiseaseClassBean>();

    public List<SicmedDiseaseClassBean> getSicmedDiseaseClassBeans() {
        return sicmedDiseaseClassBeans;
    }

    public void setSicmedDiseaseClassBeans(List<SicmedDiseaseClassBean> sicmedDiseaseClassBeans) {
        this.sicmedDiseaseClassBeans = sicmedDiseaseClassBeans;
    }

}