package com.sicmed.ehis.base;


/**
 *@Author:      ykbian
 *@date_time:   2018/9/4 17:35
 *@Description:  常量配置
 *@param:
*/
public class Constant {
    /**
     *   del_flag  删除标记
     */
    public static String DEL_FLAG_USABLE = "0";
    public static String DEL_FLAG_DISUSABLE = "1";

    /**
     *   可以挂号的科室
     */
    public static String Branch_Registered_YES = "1";
    public static String Branch_Registered_NO = "0";

    /**
     *   分页查询配置 ，如果前端配置了分页信息，这个配置不起作用
     */
    public static  int PAGE_NO = 1;   //默认要显示的页码
    public static  int PAGE_SIZE = 10;  //默认每页显示的数据量


    /**
     *  药品分类的中一级分类的父id
     */

    public static String Medical_FRIST_Classes_PARENT_ID = "0";
}
