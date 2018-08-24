package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;

/**
 * @author Max
 * @version 2016-08-11
 */
public class SicmedMedicalUseBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String useId;
    private String useGroup; // 用法分类
    private String useName; // 药品用法名称
    private String useBun; // 药品类型
    private String useUnit; // 药品计量单位
    private String useAmount; // 使用数量
    private String useDay; // 天数
    private String useBout; // 次数

    public void setSMUB(SicmedMedicalUse sicmedMedicalUse) {
        this.useId = sicmedMedicalUse.getId();
        this.useGroup = sicmedMedicalUse.getUseGroup();
        this.useName = sicmedMedicalUse.getUseName();
        this.useBun = sicmedMedicalUse.getUseBun();
        this.useUnit = sicmedMedicalUse.getUseUnit();
        this.useAmount = sicmedMedicalUse.getUseAmount();
        this.useDay = sicmedMedicalUse.getUseDay();
        this.useBout = sicmedMedicalUse.getUseBout();
    }


    public String getUseId() {
        return useId;
    }


    public void setUseId(String useId) {
        this.useId = useId;
    }


    public String getUseGroup() {
        return useGroup;
    }

    public void setUseGroup(String useGroup) {
        this.useGroup = useGroup;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getUseBun() {
        return useBun;
    }

    public void setUseBun(String useBun) {
        this.useBun = useBun;
    }

    public String getUseUnit() {
        return useUnit;
    }

    public void setUseUnit(String useUnit) {
        this.useUnit = useUnit;
    }

    public String getUseAmount() {
        return useAmount;
    }

    public void setUseAmount(String useAmount) {
        this.useAmount = useAmount;
    }

    public String getUseDay() {
        return useDay;
    }

    public void setUseDay(String useDay) {
        this.useDay = useDay;
    }

    public String getUseBout() {
        return useBout;
    }

    public void setUseBout(String useBout) {
        this.useBout = useBout;
    }
}