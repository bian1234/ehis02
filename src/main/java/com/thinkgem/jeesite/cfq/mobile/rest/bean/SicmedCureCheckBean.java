package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;

public class SicmedCureCheckBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;    //治疗项目ID
    private String cureCode;        // 治疗编码
    private String cureName;        // 治疗名称
    private String cureClassCode;        // 治疗类别(对应治疗大分类表)
    private String cureDetail;        // 治疗详情
    private String cureNamePY;

    private SicmedCurePriceBean sicmedCurePrice;

    public void setSCCB(SicmedCureCheck cureCheck) {

        if (cureCheck != null) {
            this.id = cureCheck.getId();
            this.cureCode = cureCheck.getCureCode();
            this.cureName = cureCheck.getCureName();
            this.cureDetail = cureCheck.getCureDetail();
            if (cureCheck.getSicmedCureClass() != null) {
                this.cureClassCode = cureCheck.getSicmedCureClass().getClassName();
            } else {
                this.cureClassCode = "未添加分类";
            }
            this.setSicmedCurePrice(cureCheck.getSicmedCurePrice());
            this.setCureNamePY(cureCheck.getCureNamePY());
        }

    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSicmedCurePrice(SicmedCurePriceBean sicmedCurePrice) {
        this.sicmedCurePrice = sicmedCurePrice;
    }

    public String getCureCode() {
        return cureCode;
    }

    public void setCureCode(String cureCode) {
        this.cureCode = cureCode;
    }

    public String getCureName() {
        return cureName;
    }

    public void setCureName(String cureName) {
        this.cureName = cureName;
    }

    public String getCureClassCode() {
        return cureClassCode;
    }

    public void setCureClassCode(String cureClassCode) {
        this.cureClassCode = cureClassCode;
    }

    public String getCureDetail() {
        return cureDetail;
    }

    public void setCureDetail(String cureDetail) {
        this.cureDetail = cureDetail;
    }

    public SicmedCurePriceBean getSicmedCurePrice() {
        return sicmedCurePrice;
    }

    public void setSicmedCurePrice(SicmedCurePrice sicmedCurePrice) {
        SicmedCurePriceBean curePriceBean = new SicmedCurePriceBean();
        curePriceBean.setSicmedCurePriceBean(sicmedCurePrice);
        this.sicmedCurePrice = curePriceBean;
    }

    public String getCureNamePY() {
        return cureNamePY;
    }

    public void setCureNamePY(String cureNamePY) {
        this.cureNamePY = cureNamePY;
    }

}
