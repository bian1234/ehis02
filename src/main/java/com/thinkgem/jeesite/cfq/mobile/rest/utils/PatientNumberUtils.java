package com.thinkgem.jeesite.cfq.mobile.rest.utils;

public class PatientNumberUtils {

    /**
     * 患者编号
     *
     * @param str
     * @return String
     * @author Max
     */
    public static String getPatientNumber(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(DateTimeUtils.getDateStr());
        for (int i = 0; i < 4 - str.length(); i++) {
            stringBuffer.append("0");
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
