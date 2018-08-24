package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;

public class SicmedInspectBean extends BaseBean {
    private static final long serialVersionUID = 1L;

    private String id; // 检验项目id
    private String inspectCode;    //检验编号
    private String inspectName; // 检验名称
    private String inspectPriceCode; // 检验价格表编号
    private String inspectClassCode; // 检验类别编号(对应类别表)
    private String inspectDetail; // 检验名称详情
    private String inspectNamePY;
    // 创建价格的Bean
    private SicmedInspectPriceBean sicmedInspectPriceBean = new SicmedInspectPriceBean();

    public void setSIB(SicmedInspect inspect) {

        if (inspect != null) {
            this.id = inspect.getId();
            this.inspectCode = inspect.getInspectCode();
            this.inspectName = inspect.getInspectName();
            this.inspectDetail = inspect.getInspectDetail();
            this.setInspectNamePY(inspect.getInspectNamePY());
            this.setSicmedInspectPriceBean(inspect.getInspectPrice());
        }
    }


    public String getInspectCode() {
        return inspectCode;
    }


    public void setInspectCode(String inspectCode) {
        this.inspectCode = inspectCode;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSicmedInspectPriceBean(SicmedInspectPriceBean sicmedInspectPriceBean) {
        this.sicmedInspectPriceBean = sicmedInspectPriceBean;
    }


    public String getInspectName() {
        return inspectName;
    }

    public void setInspectName(String inspectName) {
        this.inspectName = inspectName;
    }

    public String getInspectPriceCode() {
        return inspectPriceCode;
    }

    public void setInspectPriceCode(String inspectPriceCode) {
        this.inspectPriceCode = inspectPriceCode;
    }

    public String getInspectClassCode() {
        return inspectClassCode;
    }

    public void setInspectClassCode(String inspectClassCode) {
        this.inspectClassCode = inspectClassCode;
    }

    public String getInspectDetail() {
        return inspectDetail;
    }

    public void setInspectDetail(String inspectDetail) {
        this.inspectDetail = inspectDetail;
    }

    public SicmedInspectPriceBean getSicmedInspectPriceBean() {
        return sicmedInspectPriceBean;
    }

    public void setSicmedInspectPriceBean(SicmedInspectPrice sicmedInspectPrice) {
        SicmedInspectPriceBean sicmedInspectPriceBean = new SicmedInspectPriceBean();
        sicmedInspectPriceBean.setSicmedInspectPriceBean(sicmedInspectPrice);
        this.sicmedInspectPriceBean = sicmedInspectPriceBean;
    }

    public String getInspectNamePY() {
        return inspectNamePY;
    }

    public void setInspectNamePY(String inspectNamePY) {
        this.inspectNamePY = inspectNamePY;
    }

}
