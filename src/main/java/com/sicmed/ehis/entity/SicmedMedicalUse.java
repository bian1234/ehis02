package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedMedicalUse {
    private String id;

    private String askedCode;

    private String useGroup;

    private String useName;

    private String useBun;

    private String useUnit;

    private Integer useAmount;

    private Integer useDay;

    private Integer useBout;

    private String createUser;

    private String updateUser;

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

    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode == null ? null : askedCode.trim();
    }

    public String getUseGroup() {
        return useGroup;
    }

    public void setUseGroup(String useGroup) {
        this.useGroup = useGroup == null ? null : useGroup.trim();
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName == null ? null : useName.trim();
    }

    public String getUseBun() {
        return useBun;
    }

    public void setUseBun(String useBun) {
        this.useBun = useBun == null ? null : useBun.trim();
    }

    public String getUseUnit() {
        return useUnit;
    }

    public void setUseUnit(String useUnit) {
        this.useUnit = useUnit == null ? null : useUnit.trim();
    }

    public Integer getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(Integer useAmount) {
        this.useAmount = useAmount;
    }

    public Integer getUseDay() {
        return useDay;
    }

    public void setUseDay(Integer useDay) {
        this.useDay = useDay;
    }

    public Integer getUseBout() {
        return useBout;
    }

    public void setUseBout(Integer useBout) {
        this.useBout = useBout;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
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