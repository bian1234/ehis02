package com.sicmed.ehis.entity;

import java.util.Date;

public class SicmedCase {
    private String id;

    private String patientCode;

    private String caseTell;

    private String caseHistory;

    private String caseAllergy;

    private String caseDiagnosis;

    private String updateUser;

    private String createUser;

    private String askedCode;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String remarks;

    private String delFlag;

    private String pastHistory;

    private String familyAllergy;

    private String diagnosisDiseaseInitial;

    private String diagnosisDiseaseSure;

    private String checkCodeBody;

    private String checkCodeAid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode == null ? null : patientCode.trim();
    }

    public String getCaseTell() {
        return caseTell;
    }

    public void setCaseTell(String caseTell) {
        this.caseTell = caseTell == null ? null : caseTell.trim();
    }

    public String getCaseHistory() {
        return caseHistory;
    }

    public void setCaseHistory(String caseHistory) {
        this.caseHistory = caseHistory == null ? null : caseHistory.trim();
    }

    public String getCaseAllergy() {
        return caseAllergy;
    }

    public void setCaseAllergy(String caseAllergy) {
        this.caseAllergy = caseAllergy == null ? null : caseAllergy.trim();
    }

    public String getCaseDiagnosis() {
        return caseDiagnosis;
    }

    public void setCaseDiagnosis(String caseDiagnosis) {
        this.caseDiagnosis = caseDiagnosis == null ? null : caseDiagnosis.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode == null ? null : askedCode.trim();
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

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory == null ? null : pastHistory.trim();
    }

    public String getFamilyAllergy() {
        return familyAllergy;
    }

    public void setFamilyAllergy(String familyAllergy) {
        this.familyAllergy = familyAllergy == null ? null : familyAllergy.trim();
    }

    public String getDiagnosisDiseaseInitial() {
        return diagnosisDiseaseInitial;
    }

    public void setDiagnosisDiseaseInitial(String diagnosisDiseaseInitial) {
        this.diagnosisDiseaseInitial = diagnosisDiseaseInitial == null ? null : diagnosisDiseaseInitial.trim();
    }

    public String getDiagnosisDiseaseSure() {
        return diagnosisDiseaseSure;
    }

    public void setDiagnosisDiseaseSure(String diagnosisDiseaseSure) {
        this.diagnosisDiseaseSure = diagnosisDiseaseSure == null ? null : diagnosisDiseaseSure.trim();
    }

    public String getCheckCodeBody() {
        return checkCodeBody;
    }

    public void setCheckCodeBody(String checkCodeBody) {
        this.checkCodeBody = checkCodeBody == null ? null : checkCodeBody.trim();
    }

    public String getCheckCodeAid() {
        return checkCodeAid;
    }

    public void setCheckCodeAid(String checkCodeAid) {
        this.checkCodeAid = checkCodeAid == null ? null : checkCodeAid.trim();
    }
}