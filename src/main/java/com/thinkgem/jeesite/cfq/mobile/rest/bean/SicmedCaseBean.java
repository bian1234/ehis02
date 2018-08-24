package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;
import com.thinkgem.jeesite.cfq.mobile.rest.utils.DateTimeUtils;


/**
 * 病历表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedCaseBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String id;
    private String caseTell = ""; // 主述
    private String caseHistory = ""; // 现病史
    private String pastHistory = ""; // 既往史
    private String caseAllergy = ""; // 过敏史
    private String familyAllergy = "";// 家族过敏史
    private String checkCodeBody = "";// 体格检查
    private String checkCodeAid = "";// 辅助检查
    private String createDate;

    private SicmedPatientBean sicmedPatientBean = new SicmedPatientBean(); // 患者信息

    private String diagnosisDiseaseInitial;// 初步诊断

    private List<SicmedAskedBean> sicmedAskedBeans;
    private List<SicmedPatientDiseaseBean> sicmedPatientDiseaseBeans;

    private String branchName;            // 科室名称（数据库中没有对应字段）

    public void setSC(SicmedCase sicmedCase) {

        this.id = sicmedCase.getId();

        this.caseTell = sicmedCase.getCaseTell() == null ? "" : sicmedCase.getCaseTell();
        this.caseHistory = sicmedCase.getCaseHistory() == null ? "" : sicmedCase.getCaseHistory();
        this.pastHistory = sicmedCase.getPastHistory() == null ? "" : sicmedCase.getPastHistory();
        this.caseAllergy = sicmedCase.getCaseAllergy() == null ? "" : sicmedCase.getCaseAllergy();
        this.familyAllergy = sicmedCase.getFamilyAllergy() == null ? "" : sicmedCase.getFamilyAllergy();
        this.checkCodeBody = sicmedCase.getCheckCodeBody() == null ? "" : sicmedCase.getCheckCodeBody();
        this.checkCodeAid = sicmedCase.getCheckCodeAid() == null ? "" : sicmedCase.getCheckCodeAid();

        this.createDate = DateTimeUtils.getDateStr2(sicmedCase.getCreateDate());
        if (sicmedCase.getSicmedPatient() != null) {
            this.sicmedPatientBean.setSP(sicmedCase.getSicmedPatient());
        }

    }


    /*
     * 返回患者对象
     */
    public void setSicmedCase(SicmedCase sicmedCase) {

        if (sicmedCase == null) {
            this.setError("1");
            this.setErrorMessage("没有找到病历对象");
        }
        /*
		 * 对不返回数据进行操作
		 */
        this.caseTell = null;
        this.caseHistory = null;
        this.pastHistory = null;
        this.caseAllergy = null;
        this.familyAllergy = null;
        this.checkCodeBody = null;
        this.checkCodeAid = null;

        this.setBranchName("");
		/*
		 * 处理科室信息
		 */
        if (sicmedCase.getCreateUser() != null && sicmedCase.getCreateUser().getSicmedBranch() != null) {
            this.setBranchName(sicmedCase.getCreateUser().getSicmedBranch().getBranchName() == null ? "" : sicmedCase.getCreateUser().getSicmedBranch().getBranchName());
        }

        this.setId(sicmedCase.getId() != null ? sicmedCase.getId() : "");
        this.sicmedPatientBean.setSP(sicmedCase.getSicmedPatient());

    }

    public List<SicmedAskedBean> getSicmedAskedBeans() {
        return sicmedAskedBeans;
    }

    public void setSicmedAskedBeans(List<SicmedAskedBean> sicmedAskedBeans) {
        this.sicmedAskedBeans = sicmedAskedBeans;
    }

    public List<SicmedPatientDiseaseBean> getSicmedPatientDiseaseBeans() {
        return sicmedPatientDiseaseBeans;
    }

    public void setSicmedPatientDiseaseBeans(List<SicmedPatientDiseaseBean> sicmedPatientDiseaseBeans) {
        this.sicmedPatientDiseaseBeans = sicmedPatientDiseaseBeans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDiagnosisDiseaseInitial() {
        return diagnosisDiseaseInitial;
    }

    public void setDiagnosisDiseaseInitial(String diagnosisDiseaseInitial) {
        this.diagnosisDiseaseInitial = diagnosisDiseaseInitial;
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

    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // public Date getBeginCreateDate() {
    // return beginCreateDate;
    // }
    //
    // public void setBeginCreateDate(Date beginCreateDate) {
    // this.beginCreateDate = beginCreateDate;
    // }
    //
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // public Date getEndCreateDate() {
    // return endCreateDate;
    // }
    //
    // public void setEndCreateDate(Date endCreateDate) {
    // this.endCreateDate = endCreateDate;
    // }
    //
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // public Date getBeginUpdateDate() {
    // return beginUpdateDate;
    // }
    //
    // public void setBeginUpdateDate(Date beginUpdateDate) {
    // this.beginUpdateDate = beginUpdateDate;
    // }
    //
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    // public Date getEndUpdateDate() {
    // return endUpdateDate;
    // }
    //
    // public void setEndUpdateDate(Date endUpdateDate) {
    // this.endUpdateDate = endUpdateDate;
    // }

    public SicmedPatientBean getSicmedPatientBean() {
        return sicmedPatientBean;
    }

    public void setSicmedPatientBean(SicmedPatientBean sicmedPatientBean) {
        this.sicmedPatientBean = sicmedPatientBean;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }


    public String getBranchName() {
        return branchName;
    }


    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }


}