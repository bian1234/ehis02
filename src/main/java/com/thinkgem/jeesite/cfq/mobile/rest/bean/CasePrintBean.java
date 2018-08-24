package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;

/**
 * 病历表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class CasePrintBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String wordId;
    private String caseTell; // 主述
    private String caseHistory; // 现病史
    private String pastHistory; // 既往史
    private String caseAllergy; // 过敏史
    private String familyAllergy;// 家族过敏史
    private String checkCodeBody;// 体格检查
    private String checkCodeAid;// 辅助检查
    private String caseDiagnosis; // 诊断
    private SicmedPatientBean sicmedPatientBean; // 患者信息

    private SicmedUserBean sicmedDoctorBean;
    private SicmedRegisteredBean sicmedRegisteredBean;

    private CasePrintDealBeans casePrintDealBeans;// 处理集合

    public void setCPB(SicmedCase sicmedCase) {
        this.caseTell = sicmedCase.getCaseTell() == null ? "" : sicmedCase.getCaseTell();
        this.caseHistory = sicmedCase.getCaseHistory() == null ? "" : sicmedCase.getCaseHistory();
        this.pastHistory = sicmedCase.getPastHistory() == null ? "" : sicmedCase.getPastHistory();
        this.caseAllergy = sicmedCase.getCaseAllergy() == null ? "" : sicmedCase.getCaseAllergy();
        this.familyAllergy = sicmedCase.getFamilyAllergy() == null ? "" : sicmedCase.getFamilyAllergy();
        this.checkCodeBody = sicmedCase.getCheckCodeBody() == null ? "" : sicmedCase.getCheckCodeBody();
        this.checkCodeAid = sicmedCase.getCheckCodeAid() == null ? "" : sicmedCase.getCheckCodeAid();
        this.caseDiagnosis = sicmedCase.getDiagnosisDiseaseInitial() == null ? "" : sicmedCase.getDiagnosisDiseaseInitial().getDiseaseName();
        if (sicmedCase.getSicmedPatient() != null) {
            sicmedPatientBean = new SicmedPatientBean();
            sicmedPatientBean.setSP(sicmedCase.getSicmedPatient());
        }
    }

    public String getCaseTell() {
        return caseTell;
    }

    public void setCaseTell(String caseTell) {
        this.caseTell = caseTell;
    }

    public String getCaseHistory() {
        return caseHistory;
    }

    public void setCaseHistory(String caseHistory) {
        this.caseHistory = caseHistory;
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }

    public String getCaseAllergy() {
        return caseAllergy;
    }

    public void setCaseAllergy(String caseAllergy) {
        this.caseAllergy = caseAllergy;
    }

    public String getFamilyAllergy() {
        return familyAllergy;
    }

    public void setFamilyAllergy(String familyAllergy) {
        this.familyAllergy = familyAllergy;
    }

    public String getCheckCodeBody() {
        return checkCodeBody;
    }

    public void setCheckCodeBody(String checkCodeBody) {
        this.checkCodeBody = checkCodeBody;
    }

    public String getCheckCodeAid() {
        return checkCodeAid;
    }

    public void setCheckCodeAid(String checkCodeAid) {
        this.checkCodeAid = checkCodeAid;
    }

    public String getCaseDiagnosis() {
        return caseDiagnosis;
    }

    public void setCaseDiagnosis(String caseDiagnosis) {
        this.caseDiagnosis = caseDiagnosis;
    }

    public SicmedPatientBean getSicmedPatientBean() {
        return sicmedPatientBean;
    }

    public void setSicmedPatientBean(SicmedPatientBean sicmedPatientBean) {
        this.sicmedPatientBean = sicmedPatientBean;
    }

    public CasePrintDealBeans getCasePrintDealBeans() {
        return casePrintDealBeans;
    }

    public void setCasePrintDealBeans(CasePrintDealBeans casePrintDealBeans) {
        this.casePrintDealBeans = casePrintDealBeans;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public SicmedUserBean getSicmedDoctorBean() {
        return sicmedDoctorBean;
    }

    public void setSicmedDoctorBean(SicmedUserBean sicmedDoctorBean) {
        this.sicmedDoctorBean = sicmedDoctorBean;
    }

    public SicmedRegisteredBean getSicmedRegisteredBean() {
        return sicmedRegisteredBean;
    }

    public void setSicmedRegisteredBean(SicmedRegisteredBean sicmedRegisteredBean) {
        this.sicmedRegisteredBean = sicmedRegisteredBean;
    }

}