/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import com.thinkgem.jeesite.cfq.common.utils.excel.annotation.ExcelField;
import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Lists;

/**
 * 病历表Entity
 *
 * @author Max
 * @version 2016-07-18
 */
public class SicmedCase extends DataEntity<SicmedCase> {

    private static final long serialVersionUID = 1L;
    private String caseTell; // 主述
    private String caseHistory; // 病史
    private String caseAllergy; // 过敏史
    private String caseDiagnosis; // 诊断

    private Date beginCreateDate; // 开始 创建时间
    private Date endCreateDate; // 结束 创建时间
    private Date beginUpdateDate; // 开始 更新时间
    private Date endUpdateDate; // 结束 更新时间

    private SicmedAsked sicmedAsked; // 医嘱信息

    private String pastHistory; // 既往史
    private String familyAllergy;// 家族过敏史
    private String checkCodeBody;// 体格检查
    private String checkCodeAid;// 辅助检查
    private String remarks;//备注

    private SicmedPatient sicmedPatient; // 患者信息
    private SicmedDisease diagnosisDiseaseInitial;// 初步诊断
    private SicmedDisease diagnosisDiseaseSure;// 诊断

    private SicmedUser createUser; //创建人(对应医生表)
    private SicmedUser updateUser; //修改人(对应医生表)

    private Date createDate; //创建时间

    private String detailStr; //医嘱详情,自定义
    private List<SicmedAsked> sicmedAskedList = Lists.newArrayList();

    private String copyTableName; //清空新实例 记录备份表名

    private DataEntity dataEntity; //记录类型对象（检查/检验/治疗）
    private DataEntity dataEntityUse;    //用法对象

    public SicmedCase() {
        super();
    }

    public SicmedCase(String id) {
        super(id);
    }

    @ExcelField(title = "医嘱类型", align = 2, sort = 20)
    public String getnameString() {
        return sicmedAsked.getSicmedAskedClass().getAskedCalss();
    }


    @Override
    @ExcelField(title = "备注", align = 2, sort = 60)
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @ExcelField(title = "医嘱详情", align = 2, sort = 22)
    public String getDetailStr() {
        return detailStr;
    }

    public void setDetailStr(String detailStr) {
        this.detailStr = detailStr;
    }

    @Override
    @ExcelField(title = "创建时间", align = 2, sort = 35)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSicmedAskedStr() {
        return sicmedAsked.getAskedName();
    }

    public SicmedAsked getSicmedAsked() {
        return sicmedAsked;
    }

    public void setSicmedAsked(SicmedAsked sicmedAsked) {
        this.sicmedAsked = sicmedAsked;
    }

    @ExcelField(title = "治疗医生", align = 2, sort = 15)
    public String getCreateUserStr() {
        return createUser.getUserName();
    }

    public SicmedUser getCreateUser() {
        return createUser;
    }

    public void setCreateUser(SicmedUser createUser) {
        this.createUser = createUser;
    }

    public SicmedUser getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(SicmedUser updateUser) {
        this.updateUser = updateUser;
    }

    public List<SicmedAsked> getSicmedAskedList() {
        return sicmedAskedList;
    }

    public void setSicmedAskedList(List<SicmedAsked> sicmedAskedList) {
        this.sicmedAskedList = sicmedAskedList;
    }

    @Length(min = 0, max = 200, message = "主述长度必须介于 0 和 200 之间")
    public String getCaseTell() {
        return caseTell;
    }

    public void setCaseTell(String caseTell) {
        this.caseTell = caseTell;
    }

    @Length(min = 0, max = 100, message = "病史长度必须介于 0 和 100 之间")
    public String getCaseHistory() {
        return caseHistory;
    }

    public void setCaseHistory(String caseHistory) {
        this.caseHistory = caseHistory;
    }

    @Length(min = 0, max = 100, message = "过敏史长度必须介于 0 和 100 之间")
    public String getCaseAllergy() {
        return caseAllergy;
    }

    public void setCaseAllergy(String caseAllergy) {
        this.caseAllergy = caseAllergy;
    }

    @Length(min = 0, max = 100, message = "诊断长度必须介于 0 和 100 之间")
    public String getCaseDiagnosis() {
        return caseDiagnosis;
    }

    public void setCaseDiagnosis(String caseDiagnosis) {
        this.caseDiagnosis = caseDiagnosis;
    }

    public Date getBeginCreateDate() {
        return beginCreateDate;
    }

    public void setBeginCreateDate(Date beginCreateDate) {
        this.beginCreateDate = beginCreateDate;
    }

    public Date getEndCreateDate() {
        return endCreateDate;
    }

    public void setEndCreateDate(Date endCreateDate) {
        this.endCreateDate = endCreateDate;
    }

    public Date getBeginUpdateDate() {
        return beginUpdateDate;
    }

    public void setBeginUpdateDate(Date beginUpdateDate) {
        this.beginUpdateDate = beginUpdateDate;
    }

    public Date getEndUpdateDate() {
        return endUpdateDate;
    }

    public void setEndUpdateDate(Date endUpdateDate) {
        this.endUpdateDate = endUpdateDate;
    }

    @ExcelField(title = "患者名称", align = 2, sort = 10)
    public String getSicmedPatientStr() {
        return sicmedPatient.getPatientName();
    }

    public SicmedPatient getSicmedPatient() {
        return sicmedPatient;
    }

    public void setSicmedPatient(SicmedPatient sicmedPatient) {
        this.sicmedPatient = sicmedPatient;
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
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

    public SicmedDisease getDiagnosisDiseaseInitial() {
        return diagnosisDiseaseInitial;
    }

    public void setDiagnosisDiseaseInitial(SicmedDisease diagnosisDiseaseInitial) {
        this.diagnosisDiseaseInitial = diagnosisDiseaseInitial;
    }

    public SicmedDisease getDiagnosisDiseaseSure() {
        return diagnosisDiseaseSure;
    }

    public void setDiagnosisDiseaseSure(SicmedDisease diagnosisDiseaseSure) {
        this.diagnosisDiseaseSure = diagnosisDiseaseSure;
    }

    public String getCopyTableName() {
        return copyTableName;
    }

    public void setCopyTableName(String copyTableName) {
        this.copyTableName = copyTableName;
    }

    public DataEntity getDataEntity() {
        return dataEntity;
    }

    public void setDataEntity(DataEntity dataEntity) {
        this.dataEntity = dataEntity;
    }

    public DataEntity getDataEntityUse() {
        return dataEntityUse;
    }

    public void setDataEntityUse(DataEntity dataEntityUse) {
        this.dataEntityUse = dataEntityUse;
    }

}