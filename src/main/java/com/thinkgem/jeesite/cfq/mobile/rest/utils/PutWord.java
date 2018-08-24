package com.thinkgem.jeesite.cfq.mobile.rest.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.*;

import com.google.common.collect.Lists;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCase;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedCureCheck;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedInspect;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedical;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedMedicalUse;
import com.thinkgem.jeesite.cfq.mobile.rest.entity.SicmedTwxrayCheck;

public class PutWord {
    public String path;
    private int fontSize = 9;

    //打印处方
    public void printAsk(List list) throws Exception {

        Map<String, String> params = new HashMap<String, String>();
        params = writeAskMap(list);//写入处方相关信息
        String filePath = "C:\\Users\\Administrator\\Desktop\\style\\ask_style.docx";
        InputStream is = new FileInputStream(filePath);
        XWPFDocument doc = new XWPFDocument(is);
        // 替换段落里面的变量
        this.replaceInPara(doc, params);
        // 替换表格里面的变量
        this.replaceInTable(doc, params);
        OutputStream os = new FileOutputStream(path + "\\ask_style.docx");
        doc.write(os);
        this.close(os);
        this.close(is);

    }

    //打印病历
    public void printCase(List list) throws Exception {

        Map<String, String> params = new HashMap<String, String>();
        params = writeCaseMap(list);//写入处方相关信息
        String filePath = "C:\\Users\\Administrator\\Desktop\\style\\case_style.docx";
        InputStream is = new FileInputStream(filePath);
        XWPFDocument doc = new XWPFDocument(is);
        // 替换段落里面的变量
        this.replaceInPara(doc, params);
        // 替换表格里面的变量
        this.replaceInTable(doc, params);
        OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\style1\\case_style.docx");
        doc.write(os);
        this.close(os);
        this.close(is);
    }

    //打印挂号信息
    public void printRegistered(List list) throws Exception {

        Map<String, String> params = new HashMap<String, String>();
        params = writeRegisteredMap(list);//写入处方相关信息
        String filePath = "C:\\Users\\Administrator\\Desktop\\style\\registered_style.docx";
        InputStream is = new FileInputStream(filePath);
        XWPFDocument doc = new XWPFDocument(is);
        // 替换段落里面的变量
        this.replaceInPara(doc, params);
        // 替换表格里面的变量
        this.replaceInTable(doc, params);
        OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\style1\\registered_style.docx");
        doc.write(os);
        this.close(os);
        this.close(is);
    }

    //打印详情
    public void printDetail(List list) throws Exception {

        Map<String, String> params = new HashMap<String, String>();
        params = writeDetailMap(list);//写入处方相关信息
        String filePath = "C:\\Users\\Administrator\\Desktop\\style\\detail_style.docx";
        InputStream is = new FileInputStream(filePath);
        XWPFDocument doc = new XWPFDocument(is);
        // 替换段落里面的变量
        this.replaceInPara(doc, params);
        // 替换表格里面的变量
        this.replaceInTable(doc, params);
        OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\style1\\detail_style.docx");
        doc.write(os);
        this.close(os);
        this.close(is);
    }

    /**
     * 替换段落里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private void replaceInPara(XWPFDocument doc, Map<String, String> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            this.replaceInPara(para, params);
        }
    }

    /**
     * 替换段落里面的变量
     *
     * @param para   要替换的段落
     * @param params 参数
     */
    private void replaceInPara(XWPFParagraph para, Map<String, String> params) {
        List<XWPFRun> runs = Lists.newArrayList();
        Matcher matcher;
        if (this.matcher(para.getParagraphText()).find() && para.getParagraphText().startsWith("${")
                && para.getParagraphText().endsWith("}")) {
            runs = para.getRuns();
            String tempStr = new String();
            tempStr = para.getParagraphText().substring(2, para.getParagraphText().length() - 1);
            for (int i = runs.size() - 1; i > -1; i--) {

                // 直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
                // 所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
                para.removeRun(i);
                if (i == 0) {
                    XWPFRun tempRun = para.insertNewRun(i);
                    tempRun.setText(params.get(tempStr));
                    tempRun.setFontSize(fontSize);
                }
            }
            /*
			 * runs = para.getRuns(); for (int i=0; i<runs.size(); i++) {
			 * XWPFRun run = runs.get(i); String runText = run.toString();
			 * System.out.println("runText-------------->"+runText); matcher =
			 * this.matcher(runText); if (matcher.find()) { while ((matcher =
			 * this.matcher(runText)).find()) { runText =
			 * matcher.replaceFirst(String.valueOf(params.get(matcher.group(1)))
			 * ); }
			 * //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
			 * //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。 para.removeRun(i);
			 * para.insertNewRun(i).setText(runText); } }
			 */
        }
    }

    /**
     * 替换表格里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private void replaceInTable(XWPFDocument doc, Map<String, String> params) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        this.replaceInPara(para, params);
                    }
                }
            }
			/*
			 * if(table.getRows().size()<100){ //table.insertNewTableRow(0);
			 * table.addRow(new XWPFTableRow(null, table)); }
			 */
        }
    }

    /**
     * 正则匹配字符串
     *
     * @param str
     * @return CASE_INSENSITIVE
     */
    private Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

    /**
     * 关闭输入流
     *
     * @param is
     */
    private void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 关闭输出流
     *
     * @param os
     */
    private void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //打印病历
    private Map<String, String> writeCaseMap(List<SicmedCase> list) {
        Map<String, String> params = new HashMap<String, String>();
        String medicalName = new String();
        String stand = new String();
        String use = new String();
        String day = new String();
        for (int i = 0; i < list.size(); i++) {
            SicmedCase sicmedCase = (SicmedCase) list.get(i);
            if (i == 0) {// 给word文本的患者基本信息赋值
                if (sicmedCase.getSicmedPatient() != null) {
                    params.put("name", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientName()));
                    params.put("code", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientNumber()));
                    params.put("sex", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientSex()));
                    params.put("age", String.valueOf(sicmedCase.getSicmedPatient().getPatientAge()));
                }
                if (sicmedCase.getSicmedPatient().getSicmedBranch() != null) {
                    params.put("dept",
                            this.detailIsNull(sicmedCase.getSicmedPatient().getSicmedBranch().getBranchName()));
                }

                SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
                params.put("date", dataFormat.format(new Date()));
                if (sicmedCase.getCreateUser() != null && sicmedCase.getCreateUser().getUserName() != null) {
                    params.put("doctor", sicmedCase.getCreateUser().getUserName());
                }
                //写入收费类别
                params.put("style", "自费");
                //写入病历信息
                params.put("tell", this.detailIsNull(sicmedCase.getCaseTell()));
                params.put("history", this.detailIsNull(sicmedCase.getCaseHistory()));
                params.put("pastHistory", this.detailIsNull(sicmedCase.getPastHistory()));
                params.put("caseAllergy", this.detailIsNull(sicmedCase.getCaseAllergy()));
                params.put("familyAllergy", this.detailIsNull(sicmedCase.getFamilyAllergy()));
                params.put("checkCodeBody", this.detailIsNull(sicmedCase.getCheckCodeBody()));
                params.put("checkCodeAid", this.detailIsNull(sicmedCase.getCheckCodeAid()));
            }
            //写入药品的相关信息
            if ((sicmedCase.getDataEntity() instanceof SicmedMedical)
                    && (sicmedCase.getDataEntityUse() instanceof SicmedMedicalUse)) {    //
                SicmedMedical tempMedical = (SicmedMedical) sicmedCase.getDataEntity();
                SicmedMedicalUse tempMedicalUse = (SicmedMedicalUse) sicmedCase.getDataEntityUse();

                medicalName = this.detailIsNull(tempMedical.getMedicalNameChina());
                stand = this.detailIsNull(tempMedical.getMedicalStand());
                use = this.detailIsNull(tempMedicalUse.getUseGroup());
                day = this.detailIsNull(tempMedicalUse.getUseBout());

            }

            //写入检查相关信息
            if ((sicmedCase.getDataEntity() instanceof SicmedTwxrayCheck)) {
                SicmedTwxrayCheck twxrayCheck = (SicmedTwxrayCheck) sicmedCase.getDataEntity();
                medicalName = this.detailIsNull(twxrayCheck.getCheckName());
            }

            //写入检验相关信息
            if ((sicmedCase.getDataEntity() instanceof SicmedInspect)) {
                SicmedInspect sicmedInspect = (SicmedInspect) sicmedCase.getDataEntity();
                medicalName = this.detailIsNull(sicmedInspect.getInspectName());
            }

            //写入治疗相关信息
            if ((sicmedCase.getDataEntity() instanceof SicmedCureCheck)) {
                SicmedCureCheck sicmedCureCheck = (SicmedCureCheck) sicmedCase.getDataEntity();
                medicalName = this.detailIsNull(sicmedCureCheck.getCureName());
            }

            //写入门诊病历
            params.put("MZmedicalName" + i, this.detailIsNull(medicalName));
            params.put("MZstand" + i, this.detailIsNull(stand));
            params.put("MZuse" + i, this.detailIsNull(use));
            params.put("MZday" + i, this.detailIsNull(day));
            stand = "";
            use = "";
            day = "";
        }
        return params;
    }

    //打印处方
    private Map<String, String> writeAskMap(List<SicmedCase> list) {
        Map<String, String> params = new HashMap<String, String>();
        int j = 1;//普通处方签使用
        Double allPrice = 0.00;
        for (int i = 0; i < list.size(); i++) {
            SicmedCase sicmedCase = (SicmedCase) list.get(i);
            if (i == 0) {// 给word文本的患者基本信息赋值
                if (sicmedCase.getSicmedPatient() != null) {
                    params.put("name", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientName()));
                    params.put("code", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientNumber()));
                    params.put("sexAge", sicmedCase.getSicmedPatient().getPatientAge() + "/"
                            + this.detailIsNull(sicmedCase.getSicmedPatient().getPatientSex()));
                    params.put("path", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientAddress()));
                }
                if (sicmedCase.getSicmedPatient().getSicmedBranch() != null) {
                    params.put("dept",
                            this.detailIsNull(sicmedCase.getSicmedPatient().getSicmedBranch().getBranchName()));
                }
                if (sicmedCase.getDiagnosisDiseaseInitial() != null) {// 初步诊断
                    params.put("disease", this.detailIsNull(sicmedCase.getDiagnosisDiseaseInitial().getDiseaseName()));
                }
                SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
                params.put("date", dataFormat.format(new Date()));
                if (sicmedCase.getCreateUser() != null && sicmedCase.getCreateUser().getUserName() != null) {
                    params.put("doctor", sicmedCase.getCreateUser().getUserName());
                }
                //写入收费类别
                params.put("style", "自费");
            }
            //写入药品的相关信息
            if ((sicmedCase.getDataEntity() instanceof SicmedMedical)
                    && (sicmedCase.getDataEntityUse() instanceof SicmedMedicalUse)) {
                //在普通处方签中写入信息
                SicmedMedical tempMedical = (SicmedMedical) sicmedCase.getDataEntity();
                params.put("medicalName" + j, this.detailIsNull(tempMedical.getMedicalNameChina()));
                params.put("stand" + j, this.detailIsNull(tempMedical.getMedicalStand()));
                params.put("unit" + j, this.detailIsNull(tempMedical.getUnit1()));
                SicmedMedicalUse tempMedicalUse = (SicmedMedicalUse) sicmedCase.getDataEntityUse();
                params.put("use" + j, "用法：" + this.detailIsNull(tempMedicalUse.getUseGroup()));
                params.put("UseAmount" + j, this.detailIsNull(tempMedicalUse.getUseAmount()));
                params.put("UseBout" + j, this.detailIsNull(tempMedicalUse.getUseBout()));
                if (tempMedical.getMedicalPrice() != null && tempMedical.getMedicalPrice().getPriceSale() != null) {
                    params.put("price" + j, tempMedical.getMedicalPrice().getPriceSale());
                    allPrice += Double.valueOf(tempMedical.getMedicalPrice().getPriceSale());
                    params.put("allPrice", String.valueOf(allPrice));
                }
                j++;
            }

        }
        return params;
    }

    //打印挂号信息
    private Map<String, String> writeRegisteredMap(List<SicmedCase> list) {
        Map<String, String> params = new HashMap<String, String>();

        SicmedCase sicmedCase = (SicmedCase) list.get(0);

        if (sicmedCase.getSicmedPatient() != null) {
            params.put("name", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientName()));
            params.put("code", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientNumber()));
            if ((!params.get("code").equals("")) && params.get("code").length() > 5) {
                params.put("MZNumber", params.get("code").substring(params.get("code").length() - 4, params.get("code").length() - 1));
            }
        }
        if (sicmedCase.getSicmedPatient().getSicmedBranch() != null) {
            params.put("dept", this.detailIsNull(sicmedCase.getSicmedPatient().getSicmedBranch().getBranchName()));
            params.put("deptAdress",
                    this.detailIsNull(sicmedCase.getSicmedPatient().getSicmedBranch().getBranchLocation()));
            if (sicmedCase.getSicmedPatient().getCreateUser() != null) {
                params.put("GHCode", this.detailIsNull(sicmedCase.getSicmedPatient().getCreateUser().getDoctorCode()));
            }
        }
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
        params.put("date", dataFormat.format(new Date()));

        SimpleDateFormat dataDetailFormat = new SimpleDateFormat("HH:mm:ss");
        params.put("dateDetail", dataDetailFormat.format(new Date()));
        String tempString = dataDetailFormat.format(new Date()).substring(0, 2);
        if (Integer.valueOf(tempString) > 12) {
            params.put("AMPM", "下午");
        } else {
            params.put("AMPM", "上午");
        }

        if (sicmedCase.getCreateUser() != null && sicmedCase.getCreateUser().getUserName() != null) {
            params.put("doctor", sicmedCase.getCreateUser().getUserName());
        }
        // 写入收费类别
        params.put("style", "自费");

        return params;
    }

    //打印详情
    private Map<String, String> writeDetailMap(List<SicmedCase> list) {
        Map<String, String> params = new HashMap<String, String>();
        String detName = new String();
        String detPrice = new String();
        String number = "1";

        for (int i = 0; i < list.size(); i++) {
            SicmedCase sicmedCase = (SicmedCase) list.get(i);
            if (i == 0) {// 给word文本的患者基本信息赋值
                if (sicmedCase.getSicmedPatient() != null) {
                    params.put("name", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientName()));
                    params.put("code", this.detailIsNull(sicmedCase.getSicmedPatient().getPatientNumber()));
                }
                if (sicmedCase.getSicmedPatient().getSicmedBranch() != null) {
                    params.put("dept",
                            this.detailIsNull(sicmedCase.getSicmedPatient().getSicmedBranch().getBranchName()));
                }

                SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
                params.put("date", dataFormat.format(new Date()));
                if (sicmedCase.getCreateUser() != null && sicmedCase.getCreateUser().getUserName() != null) {
                    params.put("doctor", sicmedCase.getCreateUser().getUserName());
                }
                //写入收费类别
                params.put("style", "自费");

            }
            //写入药品的相关信息
            if ((sicmedCase.getDataEntity() instanceof SicmedMedical)
                    && (sicmedCase.getDataEntityUse() instanceof SicmedMedicalUse)) {    //
                SicmedMedical tempMedical = (SicmedMedical) sicmedCase.getDataEntity();

                detName = this.detailIsNull(tempMedical.getMedicalNameChina());
                detPrice = this.detailIsNull(tempMedical.getMedicalPrice().getPriceSale());

            }

            //写入检查相关信息
            if ((sicmedCase.getDataEntity() instanceof SicmedTwxrayCheck)) {
                SicmedTwxrayCheck twxrayCheck = (SicmedTwxrayCheck) sicmedCase.getDataEntity();
                detName = this.detailIsNull(twxrayCheck.getCheckName());
                detPrice = this.detailIsNull(twxrayCheck.getSicmedCheckPrice().getCheckPrice());
            }

            //写入检验相关信息
            if ((sicmedCase.getDataEntity() instanceof SicmedInspect)) {
                SicmedInspect sicmedInspect = (SicmedInspect) sicmedCase.getDataEntity();
                detName = this.detailIsNull(sicmedInspect.getInspectName());
                detPrice = this.detailIsNull(sicmedInspect.getSicmedInspectPrice().getPrice());
            }

            //写入治疗相关信息
            if ((sicmedCase.getDataEntity() instanceof SicmedCureCheck)) {
                SicmedCureCheck sicmedCureCheck = (SicmedCureCheck) sicmedCase.getDataEntity();
                detName = this.detailIsNull(sicmedCureCheck.getCureName());
                detPrice = this.detailIsNull(sicmedCureCheck.getSicmedCurePrice().getPrice());
            }

            //写入门诊病历
            params.put("DetName" + i, this.detailIsNull(detName));
            params.put("DetType" + i, "无自付");
            params.put("DetPrice" + i, this.detailIsNull(detPrice));
            params.put("DetNumber" + i, this.detailIsNull(number));
            if (detPrice != null && !detPrice.equals("")) {
                Double tempDouble = Double.valueOf(detPrice) * Double.valueOf(number);
                params.put("allPrice" + i, String.valueOf(tempDouble));
            } else {
                params.put("allPrice" + i, this.detailIsNull(detPrice));
            }
            detName = "";
            detPrice = "";

        }
        return params;
    }

    private String detailIsNull(String string) {
        return string == null ? "" : string;
    }

	/*
	 * private Configuration configuration = null;
	 * 
	 * public PutWord() { configuration = new Configuration();
	 * configuration.setDefaultEncoding("utf-8"); }
	 * 
	 * public void createDoc() { // 要填入模本的数据文件 Map dataMap = new HashMap();
	 * getData(dataMap); //
	 * 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载， //
	 * 这里我们的模板是放在com.havenliu.document.template包下面
	 * configuration.setClassForTemplateLoading(this.getClass(),
	 * "/src/main/webapp/web");
	 * //configuration.setDirectoryForTemplateLoading(new
	 * File("D:\\emergencyHIS\\src\\main\\webapp\\WEB-INF\\putWord.ftl"));
	 * Template t = null; try { // test.ftl为要装载的模板 t =
	 * configuration.getTemplate("putWord.ftl"); } catch (IOException e) {
	 * e.printStackTrace(); } // 输出文档路径及名称 File outFile = new
	 * File("C:\\Users\\Administrator\\Desktop\\simple.docx"); Writer out =
	 * null; try { out = new BufferedWriter(new OutputStreamWriter(new
	 * FileOutputStream(outFile))); } catch (FileNotFoundException e1) {
	 * e1.printStackTrace(); }
	 * 
	 * try { t.process(dataMap, out); } catch (TemplateException e) {
	 * e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); } }
	 * 
	 * 
	 *//**
     * 注意dataMap里存放的数据Key值要与模板中的参数相对应
     *
     * @param dataMap
     *//*
		 * private void getData(Map dataMap) { dataMap.put("patientName", "张三");
		 * dataMap.put("patientNumber", "这是测试备注信息"); List _table1 = new
		 * ArrayList();
		 * 
		 * Table1 t1 = new Table1(); t1.setDate("2010-10-1");
		 * t1.setText("制定10月开发计划内容。"); _table1.add(t1);
		 * 
		 * Table1 t2 = new Table1(); t2.setDate("2010-10-2");
		 * t2.setText("开会讨论开发计划"); _table1.add(t2);
		 * 
		 * dataMap.put("table1", _table1);
		 * 
		 * List _table2 = new ArrayList(); for (int i = 0; i < 5; i++) { Table2
		 * _t2 = new Table2(); _t2.setDetail("测试开发计划" + i); _t2.setPerson("张三——"
		 * + i); _t2.setBegindate("2010-10-1"); _t2.setFinishdate("2010-10-31");
		 * _t2.setRemark("备注信息"); _table2.add(_t2); } dataMap.put("table2",
		 * _table2); }
		 */
}

/*
 * public class PutWord {
 * 
 * @Test public void testWrite() throws Exception { String templatePath =
 * "D:\\word\\template.doc"; InputStream is = new FileInputStream(templatePath);
 * HWPFDocument doc = new HWPFDocument(is); Range range = doc.getRange(); //
 * 把range范围内的${reportDate}替换为当前的日期 range.replaceText("${reportDate}", new
 * SimpleDateFormat("yyyy-MM-dd").format(new Date()));
 * range.replaceText("${appleAmt}", "100.00"); range.replaceText("${bananaAmt}",
 * "200.00"); range.replaceText("${totalAmt}", "300.00"); OutputStream os = new
 * FileOutputStream("D:\\word\\write.doc"); // 把doc输出到输出流中 doc.write(os);
 * this.closeStream(os); this.closeStream(is); }
 * 
 *//**
 * 关闭输入流
 *
 * @param is
 * <p>
 * 关闭输出流
 * @param os
 */
/*
 * private void closeStream(InputStream is) { if (is != null) { try {
 * is.close(); } catch (IOException e) { e.printStackTrace(); } } }
 * 
 *//**
 * 关闭输出流
 *
 * @param os
 *//*
	 * private void closeStream(OutputStream os) { if (os != null) { try {
	 * os.close(); } catch (IOException e) { e.printStackTrace(); } } }
	 * 
	 * }
	 */
