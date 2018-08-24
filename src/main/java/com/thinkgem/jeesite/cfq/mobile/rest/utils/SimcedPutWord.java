package com.thinkgem.jeesite.cfq.mobile.rest.utils;


import org.junit.Test;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class SimcedPutWord {

	@Test
	public void test1() {
		SimcedPutWord.putWord("word.Application","C:\\Users\\Administrator\\Desktop\\演示账号.docx");
		//testExcel();
		//testWord();
		/*try {
			//Runtime.getRuntime().exec("cmd.exe /c start /min winword " +"C:\\Users\\Administrator\\Desktop\\word\\asked\\cmedical\\XWKS\\null\\957b8493-9eb6-4c50-b5e7-3d3573a935c5");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
public void testWord(){
	 String path="C:\\Users\\Administrator\\Desktop\\word\\asked\\cmedical\\XWKS\\null\\957b8493-9eb6-4c50-b5e7-3d3573a935c5.doc";
     ComThread.InitSTA();
     ActiveXComponent word =new ActiveXComponent("word.Application");
     System.out.println("开始打印");
     Dispatch doc=null;
     Dispatch.put(word, "Visible", new Variant(false));
     Dispatch docs=word.getProperty("Documents").toDispatch();
     doc=Dispatch.call(docs, "Open", path).toDispatch();

     try {
         Dispatch.call(doc, "PrintOut");//打印
     } catch (Exception e) {
         e.printStackTrace();
         System.out.println("打印失败");
     }finally{
         try {
             if(doc!=null){
                 Dispatch.call(doc, "Close",new Variant(0));
             }
         } catch (Exception e2) {
             e2.printStackTrace();
         }
         //释放资源
         ComThread.Release();
     }
}
public void testExcel(){
	 String path="C:\\Users\\Administrator\\Desktop\\aaa.xlsx";
	ComThread.InitSTA();
	ActiveXComponent xl = new ActiveXComponent("Excel.Application");
	try {
	// System.out.println("version=" + xl.getProperty("Version"));
	//不打开文档
	Dispatch.put(xl, "Visible", new Variant(true));
	Dispatch workbooks = xl.getProperty("Workbooks").toDispatch();
	//打开文档
	Dispatch excel=Dispatch.call(workbooks,"Open",path).toDispatch();
	//开始打印
	Dispatch.get(excel,"PrintOut");
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	//始终释放资源
	ComThread.Release();
	}
}

	public static void putWord(String fileType, String filePath) {

		ComThread.InitSTA();
		ActiveXComponent wd = new ActiveXComponent(fileType);

		// 打开word文档
		Dispatch.put(wd, "Visible", new Variant(true));
		// 这里Visible是控制文档打开后是可见还是不可见，若是静默打印，那么第三个参数就设为false就好了
		Dispatch document = wd.getProperty("Documents").toDispatch();
		Dispatch doc = Dispatch.invoke(document, "Open", Dispatch.Method, new Object[] { filePath }, new int[1]).toDispatch();

		// 设置打印机
		wd.setProperty("ActivePrinter", new Variant("Lenovo M7206"));

		// 设置打印参数并打印
		Dispatch.callN(doc, "PrintOut", new Object[] {});

		// 关闭word文档
		wd.invoke("Quit", new Variant[] {});

		ComThread.Release();
	}

}
