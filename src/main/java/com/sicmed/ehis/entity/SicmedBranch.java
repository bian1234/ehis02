package com.sicmed.ehis.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class SicmedBranch {

    //主键
    @NotNull(message = "id不能为空",groups = GroupID.class)
    @Pattern(regexp = "^[A-Za-z0-9]{32}",message = "id必须是32位字符串",groups = GroupID.class)
    private String id;

//    @NotNull(message = "科室编码不能为空",groups = GroupWithoutId.class)
//    @Pattern(regexp = "^[A-Za-z0-9]{32}",message = "id必须是32位字符串",groups = GroupWithoutId.class)
    private String branchCode;

    private String branchNumber;  //科室等级

    @NotNull(message = "科室名称不能为空",groups = GroupWithoutId.class)
    @Length(min=1,max=32,message = "科室名称长度不能超过32") // 被注释的字符串的大小必须在指定的范围内
    private String branchName;

//    @NotNull(message = "科室名称不能为空",groups = GroupWithoutId.class)
    @Length(max=50,message = "科室英文名称长度不能超过50") // 被注释的字符串的大小必须在指定的范围内
    private String branchNameEnglish;

    @Length(max=60,message = "位置描述长度不能超过50") // 被注释的字符串的大小必须在指定的范围内
    private String branchLocation;

    @Pattern(regexp = "^[0-9]{1}",message = "挂号标记必须是1位数字",groups = GroupWithoutId.class)
    private String branchRegistered;

    @Min(0)
    @Max(1000)   //挂号认识不超过四位数
    private Integer branchRegisteredAm;
    @Min(0)
    @Max(1000)
    private Integer branchRegisteredPm;

    private String branchIpd;

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

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode == null ? null : branchCode.trim();
    }

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber == null ? null : branchNumber.trim();
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName == null ? null : branchName.trim();
    }

    public String getBranchNameEnglish() {
        return branchNameEnglish;
    }

    public void setBranchNameEnglish(String branchNameEnglish) {
        this.branchNameEnglish = branchNameEnglish == null ? null : branchNameEnglish.trim();
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation == null ? null : branchLocation.trim();
    }

    public String getBranchRegistered() {
        return branchRegistered;
    }

    public void setBranchRegistered(String branchRegistered) {
        this.branchRegistered = branchRegistered == null ? null : branchRegistered.trim();
    }

    public Integer getBranchRegisteredAm() {
        return branchRegisteredAm;
    }

    public void setBranchRegisteredAm(Integer branchRegisteredAm) {
        this.branchRegisteredAm = branchRegisteredAm;
    }

    public Integer getBranchRegisteredPm() {
        return branchRegisteredPm;
    }

    public void setBranchRegisteredPm(Integer branchRegisteredPm) {
        this.branchRegisteredPm = branchRegisteredPm;
    }

    public String getBranchIpd() {
        return branchIpd;
    }

    public void setBranchIpd(String branchIpd) {
        this.branchIpd = branchIpd == null ? null : branchIpd.trim();
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