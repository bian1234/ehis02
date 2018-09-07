package com.sicmed.ehis.entity;

import com.google.common.collect.Lists;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

public class SicmedDiseaseClass {

    @NotNull(message = "id不能为空",groups = GroupID.class)
    @Pattern(regexp = "^[A-Za-z0-9]{32}",message = "id必须是32位字符串",groups = GroupID.class)
    private String id;


    @Length(min=0, max=50, message="疾病类别名称长度必须介于 0 和 50 之间",groups = GroupWithoutId.class)
    private String diseaseClassName;
    @Length(min=0, max=50, message="疾病类别编号长度必须介于 0 和 50 之间",groups = GroupWithoutId.class)
    private String diseaseClassCode;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private SicmedDiseaseClass parentDiseaseClass; //父类别

    private List<SicmedDisease> diseaseList = Lists.newArrayList(); // 拥有疾病

    public SicmedDiseaseClass getParentDiseaseClass() {
        return parentDiseaseClass;
    }

    public void setParentDiseaseClass(SicmedDiseaseClass parentDiseaseClass) {
        this.parentDiseaseClass = parentDiseaseClass;
    }

    public List<SicmedDisease> getDiseaseList() {
        return diseaseList;
    }

    public void setDiseaseList(List<SicmedDisease> diseaseList) {
        this.diseaseList = diseaseList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDiseaseClassName() {
        return diseaseClassName;
    }

    public void setDiseaseClassName(String diseaseClassName) {
        this.diseaseClassName = diseaseClassName == null ? null : diseaseClassName.trim();
    }

    public String getDiseaseClassCode() {
        return diseaseClassCode;
    }

    public void setDiseaseClassCode(String diseaseClassCode) {
        this.diseaseClassCode = diseaseClassCode == null ? null : diseaseClassCode.trim();
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