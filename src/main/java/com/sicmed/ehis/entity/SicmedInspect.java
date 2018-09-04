package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedInspect {
    private String id;

    private String inspectCode;

    private String inspectName;

    private String inspectNamePy;

    private String inspectPriceCode;

    private String inspectClassCode;

    private String inspectDetail;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getInspectCode() {
        return inspectCode;
    }

    public void setInspectCode(String inspectCode) {
        this.inspectCode = inspectCode == null ? null : inspectCode.trim();
    }

    public String getInspectName() {
        return inspectName;
    }

    public void setInspectName(String inspectName) {
        this.inspectName = inspectName == null ? null : inspectName.trim();
    }

    public String getInspectNamePy() {
        return inspectNamePy;
    }

    public void setInspectNamePy(String inspectNamePy) {
        this.inspectNamePy = inspectNamePy == null ? null : inspectNamePy.trim();
    }

    public String getInspectPriceCode() {
        return inspectPriceCode;
    }

    public void setInspectPriceCode(String inspectPriceCode) {
        this.inspectPriceCode = inspectPriceCode == null ? null : inspectPriceCode.trim();
    }

    public String getInspectClassCode() {
        return inspectClassCode;
    }

    public void setInspectClassCode(String inspectClassCode) {
        this.inspectClassCode = inspectClassCode == null ? null : inspectClassCode.trim();
    }

    public String getInspectDetail() {
        return inspectDetail;
    }

    public void setInspectDetail(String inspectDetail) {
        this.inspectDetail = inspectDetail == null ? null : inspectDetail.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}