package com.thinkgem.jeesite.cfq.mobile.rest.entity;

import java.util.List;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.DataEntity;
import org.hibernate.validator.constraints.Length;

import com.google.common.collect.Lists;

/**
 * 单表生成Entity
 *
 * @author Max
 * @version 2016-08-16
 */
public class SicmedMedicalUse extends DataEntity<SicmedMedicalUse> {

    private static final long serialVersionUID = 1L;
    private String askedCode;        // 药品医嘱ID
    private String useGroup;        // 用法分类
    private String useName;        // 药品用法名称
    private String useBun;        // 药品类型
    private String useUnit;        // 药品计量单位
    private String useAmount;        // 使用数量
    private String useDay;        // 天数
    private String useBout;        // 次数
    private String createUser;        // 创建人
    private String updateUser;        // 修改人

    private List<SicmedAsked> SicmedAskeds = Lists.newArrayList();

    public SicmedMedicalUse() {
        super();
    }

    public SicmedMedicalUse(String id) {
        super(id);
    }

    public List<SicmedAsked> getSicmedAskeds() {
        return SicmedAskeds;
    }

    public void setSicmedAskeds(List<SicmedAsked> sicmedAskeds) {
        SicmedAskeds = sicmedAskeds;
    }

    @Length(min = 1, max = 32, message = "药品医嘱ID长度必须介于 1 和 32 之间")
    public String getAskedCode() {
        return askedCode;
    }

    public void setAskedCode(String askedCode) {
        this.askedCode = askedCode;
    }

    @Length(min = 0, max = 20, message = "用法分类长度必须介于 0 和 20 之间")
    public String getUseGroup() {
        return useGroup;
    }

    public void setUseGroup(String useGroup) {
        this.useGroup = useGroup;
    }

    @Length(min = 0, max = 20, message = "药品用法名称长度必须介于 0 和 20 之间")
    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    @Length(min = 0, max = 15, message = "药品类型长度必须介于 0 和 15之间")
    public String getUseBun() {
        return useBun;
    }

    public void setUseBun(String useBun) {
        this.useBun = useBun;
    }

    @Length(min = 0, max = 12, message = "药品计量单位长度必须介于 0 和 12 之间")
    public String getUseUnit() {
        return useUnit;
    }

    public void setUseUnit(String useUnit) {
        this.useUnit = useUnit;
    }

    @Length(min = 0, max = 20, message = "使用数量长度必须介于 0 和 20 之间")
    public String getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(String useAmount) {
        this.useAmount = useAmount;
    }

    @Length(min = 0, max = 20, message = "天数长度必须介于 0 和 20 之间")
    public String getUseDay() {
        return useDay;
    }

    public void setUseDay(String useDay) {
        this.useDay = useDay;
    }

    @Length(min = 0, max = 20, message = "次数长度必须介于 0 和 20 之间")
    public String getUseBout() {
        return useBout;
    }

    public void setUseBout(String useBout) {
        this.useBout = useBout;
    }

    @Length(min = 0, max = 32, message = "创建人长度必须介于 0 和 32 之间")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Length(min = 0, max = 32, message = "修改人长度必须介于 0 和 32 之间")
    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

}