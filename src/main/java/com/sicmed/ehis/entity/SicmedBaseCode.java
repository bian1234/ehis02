package com.sicmed.ehis.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class SicmedBaseCode {

    //主键
    @NotNull(message = "id不能为空",groups = GroupID.class)
    @Pattern(regexp = "^[A-Za-z0-9]{32}",message = "id必须是32位字符串",groups = GroupID.class)
    private String id;

    @NotBlank(message =" 业务类型不能为空，且长度必须大于0" ,groups = {GroupWithoutId.class})
    private String codeBusiness;
    @NotBlank(message =" 子业务类型不能为空，且长度必须大于0" ,groups = {GroupWithoutId.class})
    private String codeBuns;


    @NotBlank(message =" 业务编码不能为空，且长度必须大于0" ,groups = {GroupWithoutId.class})
    private String code;
    @NotBlank(message =" 业务名称不能为空，且长度必须大于0" ,groups = {GroupWithoutId.class})
    private String codeName;

    @NotBlank(message =" 扩展编码不能为空，且长度必须大于0" ,groups = {GroupWithoutId.class})
    private String codeExtand;


    //适用日期
    private Date codeDate;


    //是否可用
    private String codeUse;

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

    public String getCodeBusiness() {
        return codeBusiness;
    }

    public void setCodeBusiness(String codeBusiness) {
        this.codeBusiness = codeBusiness == null ? null : codeBusiness.trim();
    }

    public String getCodeBuns() {
        return codeBuns;
    }

    public void setCodeBuns(String codeBuns) {
        this.codeBuns = codeBuns == null ? null : codeBuns.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    public String getCodeExtand() {
        return codeExtand;
    }

    public void setCodeExtand(String codeExtand) {
        this.codeExtand = codeExtand == null ? null : codeExtand.trim();
    }

    public Date getCodeDate() {
        return codeDate;
    }

    public void setCodeDate(Date codeDate) {
        this.codeDate = codeDate;
    }

    public String getCodeUse() {
        return codeUse;
    }

    public void setCodeUse(String codeUse) {
        this.codeUse = codeUse == null ? null : codeUse.trim();
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