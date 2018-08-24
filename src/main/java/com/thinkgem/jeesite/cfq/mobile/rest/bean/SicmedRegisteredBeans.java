package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 挂号信息表Entity
 *
 * @author Max
 * @version 2016-07-12
 */
public class SicmedRegisteredBeans extends BaseBean {

    private static final long serialVersionUID = 1L;
    // private SicmedBaseCodeBean sicmedBaseCodeBean; //
    // 医保类型(对应基础编码标准中的BUN(BI)_code)
    // private SicmedPatientBean sicmedPatientBean; // 患者编号(对应患者基本信息表)
    // private SicmedBranchBean sicmedBranchBean; // 科室编号(对应科室表)
    // private SicmedUserBean sicmedDoctorBean; // 医生(对应医生表)

    private List<SicmedRegisteredBean> sicmedRegisteredBeans = new ArrayList<SicmedRegisteredBean>();

    public List<SicmedRegisteredBean> getSicmedRegisteredBeans() {
        return sicmedRegisteredBeans;
    }

    public void setSicmedRegisteredBeans(List<SicmedRegisteredBean> sicmedRegisteredBeans) {
        this.sicmedRegisteredBeans = sicmedRegisteredBeans;
    }

}