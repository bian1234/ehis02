package com.thinkgem.jeesite.cfq.mobile.rest.entity;


import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;

/**
 * 患者疾病表Entity
 *
 * @author XUE
 * @version 2016-07-20
 */
public class SicmedPatientDisease extends DataEntity<SicmedPatientDisease> {

    private static final long serialVersionUID = 1L;
    private SicmedPatient patientCode;        // 患者编号(对应患者疾病表)
    private SicmedDisease diseaseCode;        // 疾病编号(对应疾病表)
    private SicmedBranch branchCode;        // 科室编号(对应科室表)
    private SicmedCase caseCode;        // 病历编号

    public SicmedPatientDisease() {
        super();
    }

    public SicmedPatientDisease(String id) {
        super(id);
    }

    public SicmedPatient getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(SicmedPatient patientCode) {
        this.patientCode = patientCode;
    }

    public SicmedDisease getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(SicmedDisease diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public SicmedBranch getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(SicmedBranch branchCode) {
        this.branchCode = branchCode;
    }

    public SicmedCase getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(SicmedCase caseCode) {
        this.caseCode = caseCode;
    }

}