package com.thinkgem.jeesite.cfq.mobile.rest.bean;

import java.io.Serializable;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String error;
    private String errorMessage;
    private String successMessage;
    private String pageNo;

    public void success() {
        this.error = "0";
        this.errorMessage = "请求成功";
    }

    public void failure() {
        this.error = "1";
        this.errorMessage = "请求失败";
    }

    public void failureWithParameter() {
        this.error = "1";
        this.errorMessage = "请求失败,请核实参数信息";
    }

    public void successNotFoundData() {
        this.error = "0";
        this.errorMessage = "请求成功,并未找到数据";
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
