package com.sicmed.ehis.entity;

public class SicmedDisease {
    private String id;

    private String diseaseClassCode;

    private String diseaseName;

    private String diseaseNameEnglish;

    private String diseaseNamePmpa;

    private String diseaseCode;

    private String createBy;

    private String createDate;

    private String updateBy;

    private String updateDate;

    private String remarks;

    private String delFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDiseaseClassCode() {
        return diseaseClassCode;
    }

    public void setDiseaseClassCode(String diseaseClassCode) {
        this.diseaseClassCode = diseaseClassCode == null ? null : diseaseClassCode.trim();
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName == null ? null : diseaseName.trim();
    }

    public String getDiseaseNameEnglish() {
        return diseaseNameEnglish;
    }

    public void setDiseaseNameEnglish(String diseaseNameEnglish) {
        this.diseaseNameEnglish = diseaseNameEnglish == null ? null : diseaseNameEnglish.trim();
    }

    public String getDiseaseNamePmpa() {
        return diseaseNamePmpa;
    }

    public void setDiseaseNamePmpa(String diseaseNamePmpa) {
        this.diseaseNamePmpa = diseaseNamePmpa == null ? null : diseaseNamePmpa.trim();
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode == null ? null : diseaseCode.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
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