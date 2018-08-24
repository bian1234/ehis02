package com.thinkgem.jeesite.cfq.mobile.rest.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;


public class VelocityUtil {

    public static void createDoc(VelocityContext vc, String templetePath, String uri, String fileName) throws Exception {

        System.err.println(uri + "---" + fileName);
        Properties ps = new Properties();
        ps.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        //ps.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, ".");// 这是模板所在路径
        VelocityEngine ve = new VelocityEngine();
        ve.init(ps);

        Template template = ve.getTemplate(templetePath, "utf-8");

        File srcFile = new File(uri);//输出路径
        if (srcFile.exists()) {
            System.out.println("创建目录" + uri + "失败，目标目录已经存在");
        }
        //创建目录
        if (srcFile.mkdirs()) {
            System.out.println("创建目录" + uri + "成功！");
        } else {
            System.out.println("创建目录" + uri + "失败！");
        }
        File demoFile = new File(fileName);//输出路径
        FileOutputStream fos = new FileOutputStream(demoFile);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"));
        template.merge(vc, writer);
        writer.flush();
        writer.close();
        fos.close();
    }

	/*public static void main(String[] args) {
        VelocityContext velocityContext = new VelocityContext();
		
		velocityContext.put("name", "张三");
		velocityContext.put("sex", "男");
		try {
			VelocityUtil.createDoc(velocityContext, "asked_cure.vm","./word/case/sjk/wys","./word/case/sjk/wys/abc.doc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
