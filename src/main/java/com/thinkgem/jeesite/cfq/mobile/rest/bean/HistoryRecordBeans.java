package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Max
 */

public class HistoryRecordBeans extends BaseBean {

    private static final long serialVersionUID = 1L;

    private String benginDate;
    private String endDate;
    List<HistoryRecordBean> historyRecordBeans = new ArrayList<HistoryRecordBean>();

    private String totalPrice;

    public void addHis(HistoryRecordBean historyRecordBean) {
        String id = historyRecordBean.getSicmedPatientId();
        int i = 0;
        if (this.historyRecordBeans.size() > 0) {
            for (HistoryRecordBean historyRecordBean2 : this.historyRecordBeans) {
                if (id.equals(historyRecordBean2.getSicmedPatientId())) {
                    Double price1 = Double.parseDouble(historyRecordBean2.getUnitPrice());
                    Double price2 = Double.parseDouble(historyRecordBean.getUnitPrice());
                    Double unitPrice = price1 + price2;
                    historyRecordBean2.setUnitPrice(unitPrice.toString());
                    break;
                } else {
                    i = i + 1;
                    continue;
                }
            }
            if (this.historyRecordBeans.size() == i) {
                this.historyRecordBeans.add(historyRecordBean);
            }
        } else {
            this.historyRecordBeans.add(historyRecordBean);
        }

    }


    public String getBenginDate() {
        return benginDate;
    }

    public void setBenginDate(String benginDate) {
        this.benginDate = benginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<HistoryRecordBean> getHistoryRecordBeans() {
        return historyRecordBeans;
    }

    public void setHistoryRecordBeans(List<HistoryRecordBean> historyRecordBeans) {
        this.historyRecordBeans = historyRecordBeans;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

}