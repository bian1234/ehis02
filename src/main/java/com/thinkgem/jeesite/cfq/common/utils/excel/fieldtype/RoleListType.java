/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.cfq.common.utils.excel.fieldtype;

import com.google.common.collect.Lists;

import com.thinkgem.jeesite.cfq.common.utils.Collections3;
import com.thinkgem.jeesite.cfq.common.utils.SpringContextHolder;
import com.thinkgem.jeesite.cfq.common.utils.StringUtils;
import com.thinkgem.jeesite.cfq.sys.entity.PrescriptionRole;
import com.thinkgem.jeesite.cfq.sys.service.PrescriptionSystemService;

import java.util.List;

/**
 * 字段类型转换
 *
 * @author ThinkGem
 * @version 2013-5-29
 */
public class RoleListType {

    private static PrescriptionSystemService systemService = SpringContextHolder.getBean(PrescriptionSystemService.class);

    /**
     * 获取对象值（导入）
     */
    public static Object getValue(String val) {
        List<PrescriptionRole> roleList = Lists.newArrayList();
        List<PrescriptionRole> allRoleList = systemService.findAllRole();
        for (String s : StringUtils.split(val, ",")) {
            for (PrescriptionRole e : allRoleList) {
                if (StringUtils.trimToEmpty(s).equals(e.getName())) {
                    roleList.add(e);
                }
            }
        }
        return roleList.size() > 0 ? roleList : null;
    }

    /**
     * 设置对象值（导出）
     */
    public static String setValue(Object val) {
        if (val != null) {
            @SuppressWarnings("unchecked")
            List<PrescriptionRole> roleList = (List<PrescriptionRole>) val;
            return Collections3.extractToString(roleList, "name", ", ");
        }
        return "";
    }

}
