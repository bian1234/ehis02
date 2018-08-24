package com.thinkgem.jeesite.modules.cfq.mobile.rest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PersonCardUtils {

    /**
     * 根据身份证获取性别
     *
     * @param card
     * @return
     */
    public static String getSex(String card) {

        String patientSex = "";

        String str = card.substring(16, 17);

        int i = Integer.parseInt(str);
        if (i % 2 == 0) {
            patientSex = "0";
        } else {
            patientSex = "1";
        }
        return patientSex;

    }

    /**
     * 根据身份证获取年龄
     *
     * @param card
     * @return
     */
    public static Integer getAge(String card) {
        int patientAge = 0;

        String yearStr = card.substring(6, 10);

        //取出系统当前时间
        Calendar cal = Calendar.getInstance();
        Integer newYear = cal.get(Calendar.YEAR);

        patientAge = newYear - Integer.valueOf(yearStr);

        return patientAge;

    }

    /**
     * 根据身份证获取生日
     *
     * @param card
     * @return
     */
    public static Date getBirthday(String card) {
        String yearStr = card.substring(6, 10);
        String monthStr = card.substring(10, 12);
        String dayStr = card.substring(12, 14);

        String dateStr = yearStr + "-" + monthStr + "-" + dayStr;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date patientBirthday = null;
        try {
            patientBirthday = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return patientBirthday;

    }
}
