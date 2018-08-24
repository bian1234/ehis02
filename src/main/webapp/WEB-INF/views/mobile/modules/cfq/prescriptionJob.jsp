<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>处方作业界面</title>
<%@include file="/WEB-INF/views/include/dialog.jsp" %>
<%@include file="/WEB-INF/views/include/head.jsp" %>
<style type="text/css">
*{
margin: 0px;
padding: 0px;
/* border: 1px solid red; */
text-align: center;
}
body{
padding-top: 50px;
}
#bg{
background-color: #f1f1f1;
height: 500px;
}
.row-fluid div{
text-align: center;
}
#top_bar ul{
background-color: #EFEFDE;
}
#top_bar li{
width: 9.09%;
}

#line-2{
background-color: #EFEFDE;
}
#img_but img{
width: 50px;
height: 50px;
}
#img_but div{
margin: 0.5px;
padding: 0.5px;
}
</style>
</head>
<script type="text/javascript">
  $(function () {
	  $('#myTab a').click(function (e) {
			e.preventDefault();
			$(this).tab('show');
		})
  })
</script>
<body>
	<!-- 顶部导航栏 -->
	<div id="top_bar" class="navbar-fixed-top">
		<ul class="nav nav-pills" style="width: 100%;">
		  <li class=""><a href="#">退出</a></li>
		  <li class=""><a href="#">在院处方作业</a></li>
		  <li class=""><a href="#">检查结果查询</a></li>
		  <li class=""><a href="#">患者现状</a></li>
		  <li class=""><a href="#">手术作业</a></li>
		  <li class=""><a href="#">医嘱单打印</a></li>
		  <li class=""><a href="#">变更使用者</a></li>
		  <li class=""><a href="#">通知单管理</a></li>
		  <li class=""><a href="#">患者费用查询/打印</a></li>
		  <li class=""><a href="#">临床路径</a></li>
		  <li class=""><a href="#">不良事件上报</a></li>
		</ul>
	</div>
	<!-- 处方操作导航栏 -->
	<div id="line-2" class="container-fluid">
		<div class="row-fluid">
			<div class="span7">
				<div class="container-fluid">
					<ul id="img_but" class="nav nav-pills">
					  <li><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/patient_inquiry.jpg"><br>患者查询</a></li>
					  <li><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/disease_inquiry.jpg"><br>选择疾病</a></li>
					  <li><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/select_prescription.jpg"><br>选择处方</a></li>
					  <li><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/standard_prescription.jpg"><br>标准处方</a></li>
					  <li><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/transfer_prescription.jpg"><br>传送处方</a></li>
					  <li><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/useful_expressions.jpg"><br>常用语句</a></li>
					  <li><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/special_considerations.jpg"><br>特殊事项</a></li>
					  <li><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/calculation_prescription.jpg"><br>计算处方</a></li>
					  <li><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/drop_out.jpg"><br>退出</a></li>
					</ul>
					<%-- <div  class="row-fluid">
						<div class=""><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/patient_inquiry.jpg"><br>患者查询</a></div>
						
						<div class=""><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/disease_inquiry.jpg"><br>选择疾病</a></div>
						
						<div class=""><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/select_prescription.jpg"><br>选择处方</a></div>
						
						<div class=""><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/standard_prescription.jpg"><br>标准处方</a></div>
						<div class=""><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/transfer_prescription.jpg"><br>传送处方</a></div>
						<div class=""><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/useful_expressions.jpg"><br>常用语句</a></div>
						<div class=""><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/special_considerations.jpg"><br>特殊事项</a></div>
						<div class=""><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/calculation_prescription.jpg"><br>计算处方</a></div>
						<div class=""><a class="btn" href=""><img class="" alt="" src="${ctxStatic}/web/images/drop_out.jpg"><br>退出</a></div>
					</div> --%>
				</div>	
			</div>	
			<div class="span1">等级标准处方</div>	
			<div class="span4">
				<div class="container-fluid">
					<div class="row-fluid">
						<div class="span1">删除药品处方</div>
						<div class="span1">删除检验医嘱</div>
						<div class="span1">删除其他医嘱</div>
						<div class="span1">删除全部医嘱</div>
						<div class="span1">删除全部疾病</div>
						<div class="span1">取消所有选择</div>
						<div class="span1">删除选择医嘱</div>
						<div class="span1">医嘱重新排列</div>
						<div class="span1">临床路径</div>
						<div class="span1">不良事件上报</div>
					</div>
				</div>	
			</div>	
		</div>	
	</div>
	<!-- 患者信息显示区域 -->
	<table class="table table-bordered table-hover table-condensed">
		<tr>
			<td>患者编号</td>
			<td>患者姓名</td>
			<td>出生日期</td>
			<td>性别/年龄</td>
			<td>住院日期</td>
			<td>患者区分</td>
			<td>天数</td>
			<td>最近长期医嘱日期</td>
			<td>负责医师</td>
			<td>住院病区</td>
			<td>病床</td>
		</tr>
		<tr>
			<td>0000001</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<!-- 医嘱操作区域 -->
	<div class="container-fluid">
	  <div class="row-fluid">
	    <div class="span2">
	    	<label>医嘱日期:</label>
	    	<select>
	    		<option>1111</option>
	    		<option>2222</option>
	    		<option>3333</option>
	    		<option>4444</option>
	    	</select>
	    </div>
	    <div class="span1">
	    </div>
	    <div class="span2">
		    <div class="btn-group">
			  <button class="btn">DRG患者</button>
			  <button class="btn">临床路径患者</button>
			</div>
	    </div>
	    <div class="span6">
		    <div class="btn-group">
			  <button class="btn">当日住院医嘱</button>
			  <button class="btn">长期医嘱</button>
			  <button class="btn">临时医嘱</button>
			  <button class="btn">术前医嘱</button>
			  <button class="btn">出院医嘱</button>
			  <button class="btn">会诊医嘱</button>
			</div>
	    </div>
	  </div>
	</div>
	<!-- 费用显示区域 -->
	<div class="container-fluid">
	  <div class="row-fluid">
	    <div class="span7">
	    </div>
	    <div class="span5">
	    </div>
	  </div>
	</div>
	<!-- 中间导航栏 -->
	<ul class="nav nav-tabs" id="myTab" style="width: 100%">
	  <li style="width: 25%;background-color: #EFEFDE;" class="active" ><a href="#settings">确定诊断</a></li>
	  <li style="width: 25%;background-color: #EFEFDE;"><a href="#profile">疑似/待查诊断</a></li>
	  <li style="width: 25%;background-color: #EFEFDE;"><a href="#messages">嘱托医嘱</a></li>
	  <li style="width: 25%;background-color: #EFEFDE;"><a href="#home">处方</a></li>
	</ul>
 
	<div class="tab-content">
		<!-- 确认诊断-->
		<div class="tab-pane" id="profile">
		bbb
		</div>
		<!-- 疑似/待查诊断-->
		<div class="tab-pane" id="messages">
		ccc
		</div>
		<!-- 嘱托医嘱 -->
		<div class="tab-pane" id="settings">
		ddd
		</div>
		<!-- 处方 -->
		<div class="tab-pane active" id="home">
			<!-- 表格显示区域 1-->
			<table class="table table-bordered table-hover table-condensed">
			<tr>
				<td>区分</td>
				<td>医嘱名称</td>
				<td>药品用法/检验标本</td>
				<td>单次剂量/总量</td>
				<td>单位</td>
				<td>单次数量</td>
				<td>次数</td>
				<td>天数</td>
				<td>数量合计</td>
				<td>单位</td>
				<td>加急</td>
				<td>参保</td>
				<td>备注</td>
				<td>prn</td>
				<td>便捷</td>
				<td>粉末</td>
				<td>状态</td>
				<td>区分停嘱</td>
				<td>传送部门</td>
				<td>打印</td>
				<td>医嘱医生</td>
				<td>自动发生日期</td>
			</tr>
			<tr>
				<td>HZ231</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>2</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>2</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			<tr>
				<td>2</td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</table>
			<!-- 表格显示区域2 -->
			<table class="table table-bordered table-hover table-condensed">
		<tr>
			<td>D</td>
			<td>类型</td>
			<td>区分</td>
			<td>医嘱名称</td>
			<td>药品用法/检验标本</td>
			<td>单次剂量/总量</td>
			<td>单位</td>
			<td>单次数量</td>
			<td>次数</td>
			<td>天数</td>
			<td>数量合计</td>
			<td>单位</td>
			<td>计算数量</td>
			<td>金额</td>
			<td>加急</td>
			<td>参保</td>
			<td>备注</td>
			<td>prn</td>
			<td>便捷</td>
			<td>粉末</td>
			<td>状态</td>
			<td>区分停嘱</td>
			<td>传送部门</td>
		</tr>
		<tr>
			<td>HZ231</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>HZ231</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>HZ231</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>2</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
		</div>
	</div>
 

</body>
</html>