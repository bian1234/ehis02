package com.thinkgem.jeesite.cfq.mobile.rest.utils;

import java.util.Date;
import java.util.Map;

import com.thinkgem.jeesite.cfq.common.web.BaseController;
import org.springframework.stereotype.Controller;


@Controller
public class SsidUtils extends BaseController{

	@SuppressWarnings("unchecked")
	public static String getSicmedUserId(String ssid){
		if(ssid.equals("666")){
			return null;
		}
		Map<Date, Map<String, String>> ssidMap = (Map<Date, Map<String, String>>) SessionIdCacheUtils.get(ssid);
		for (Date date : ssidMap.keySet()) {
			Map<String, String> userMap = ssidMap.get(date);
			for (String str : userMap.keySet()) {
				return str;
			}
		}
		return ssid;
	}

	@SuppressWarnings("unchecked")
	public static Date getCreateDate(String ssid){
		if(ssid.equals("666")){
			return null;
		}
		Map<Date, Map<String, String>> ssidMap = (Map<Date, Map<String, String>>) SessionIdCacheUtils.get(ssid);
		Date startDate = new Date();
		// 为查询条件的属性赋值
		for (Date date : ssidMap.keySet()) {
			startDate = date;
		}
		return startDate;

	}

}
