package com.thinkgem.jeesite.cfq.mobile.rest.bean.print;

import com.thinkgem.jeesite.cfq.mobile.rest.bean.BaseBean;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCheckPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCurePrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspectPrice;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalPrice;

public class TollPrintBean extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String name;

    private String price;

    public void setTPB(SicmedCheckPrice sicmedCheckPrice) {
        this.name = sicmedCheckPrice.getSicmedTwxrayCheck().getCheckName();
        this.price = sicmedCheckPrice.getCheckPrice();
    }

    public void setTPB(SicmedCurePrice sicmedCurePrice) {
        this.name = sicmedCurePrice.getSicmedCureCheck().getCureName();
        this.price = sicmedCurePrice.getPrice();
    }

    public void setTPB(SicmedInspectPrice sicmedInspectPrice) {
        this.name = sicmedInspectPrice.getSicmedInspect().getInspectName();
        this.price = sicmedInspectPrice.getPrice();
    }

    public void setTPB(SicmedMedicalPrice sicmedMedicalPrice) {
        this.name = sicmedMedicalPrice.getSicmedMedical().getMedicalNameChina();
        this.price = sicmedMedicalPrice.getPriceSale();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}