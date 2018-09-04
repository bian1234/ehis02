package com.sicmed.ehis.entity;


/**
 * 医嘱信息Entity
 * 
 * @author XUE
 * @version 2016-07-12
 */
public class SicmedTempEntity  {

	private static final long serialVersionUID = 1L;
	private String tempCode;
	private String firstPrice;
	private String secondPrice;
	private String detailCode;
	public String getTempCode() {
		return tempCode;
	}
	public void setTempCode(String tempCode) {
		this.tempCode = tempCode;
	}
	public String getFirstPrice() {
		return firstPrice;
	}
	public void setFirstPrice(String firstPrice) {
		this.firstPrice = firstPrice;
	}
	public String getDetailCode() {
		return detailCode;
	}
	public void setDetailCode(String detailCode) {
		this.detailCode = detailCode;
	}
	public String getSecondPrice() {
		return secondPrice;
	}
	public void setSecondPrice(String secondPrice) {
		this.secondPrice = secondPrice;
	}
	

}