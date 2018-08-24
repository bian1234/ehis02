package com.thinkgem.jeesite.cfq.mobile.rest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTimeUtils {

    /**
     * 获取系统当前时间
     *
     * @return String
     */
    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

        return df.format(System.currentTimeMillis());
    }

    /**
     * 获取系统当前时间
     *
     * @return String
     */
    public static String getDateStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式

        return df.format(System.currentTimeMillis());
    }

    /**
     * 获取今天0点的 时间
     *
     * @return
     */
    public static Date getDayBeginDate() {
        Date date = new Date();
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        @SuppressWarnings("static-access")
        Date date2 = new Date(date.getTime() - gc.get(gc.HOUR_OF_DAY) * 60 * 60
                * 1000 - gc.get(gc.MINUTE) * 60 * 1000 - gc.get(gc.SECOND)
                * 1000);
        return date2;
    }

    /**
     * 判断是否是第二天
     *
     * @return
     */
    public static boolean getDayBeginDate(Date date) {

        Date date3 = DateTimeUtils.getDayBeginDate();
        String str1 = getDateStr2(date3);
        String str2 = getDateStr2(date);
        if (str1.equals(str2)) {
            return false;
        }
        return true;
    }

    public static String getDateStr2(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式

        return df.format(date);
    }

    /**
     * @return String
     */
    public static String getDateStr(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

        return df.format(date);
    }

    /**
     * 获取系统当前时间
     *
     * @return Date
     */
    public static Date getTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

        try {
            return df.parse(df.format(System.currentTimeMillis()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static Date getTime(String str) {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");// 设置日期格式

        try {
            return df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDate(String str) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

        try {
            return df.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date getDate1(String str) {
        String tempStr = str.replace("/", "-");
        if (tempStr.length() < 10) {
            tempStr = tempStr + " 00:00:00";
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

        try {
            return df.parse(tempStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断SSID是否过期
     *
     * @param String
     * @return Boolean
     */
    public static Boolean contrastDate(Date date) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式

        Boolean b = false;

        try {
            Date currentDate = df.parse(df.format(System.currentTimeMillis()));

            Long l1 = currentDate.getTime();
            Long l2 = date.getTime();

            Long l = l1 - l2;
            if (l > 86400000) {
                // 120000
                b = true;
            } else {
                b = false;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return b;
    }
}
