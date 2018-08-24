/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.common.utils.excel.fieldtype;

import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionArea;
import com.thinkgem.jeesite.cfq.sys.utils.PrescriptionUserUtils;

/**
 * 字段类型转换
 *
 * @author ThinkGem
 * @version 2013-03-10
 */
public class AreaType {

    /**
     * 获取对象值（导入）
     */
    public static Object getValue(String val) {
        for (PrescriptionArea e : PrescriptionUserUtils.getPrescriptionAreaList()) {
            if (StringUtils.trimToEmpty(val).equals(e.getName())) {
                return e;
            }
        }
        return null;
    }

    /**
     * 获取对象值（导出）
     */
    public static String setValue(Object val) {
        if (val != null && ((PrescriptionArea) val).getName() != null) {
            return ((PrescriptionArea) val).getName();
        }
        return "";
    }
}
