<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>患者列表</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<style type="text/css">
*{
/* border: 1px solid red ; */
}
.patient{
font-family:STHeitiSC-Medium;
font-size:14px;
color:#bdbdbd;
letter-spacing:0px;
text-align:left;
}
</style>
</head>
<body>
<div style="height: 1200px;width: 950px;">
	<div style="width: 84%;height: auto;margin-top: 38px;margin-left:6%; ">
		<button style="width: 12%;height: 26px; border-radius:6px">患者列表</button>
		<button style="width: 12%;height: 26px; border-radius:6px">病历</button>
		<button style="width: 12%;height: 26px; border-radius:6px">医嘱</button>
		<button style="background:#bbdefb;border-radius:6px;width:8%;height:28px;float: right;">搜索</button>
		<input style="background:#ffffff;border:1px solid #efefef;border-radius:6px;width:18%;height:26px;float: right;">
		<label style="font-family:STHeitiSC-Medium;font-size:12px;color:#757575;letter-spacing:0px;text-align:center;float: right;margin-top: 4px;margin-right: 2.8%">患者列表</label>
	</div>	
	<div style="width: 84%;height: auto;margin-top: 26px;margin-left:6%;background:#ffffff;border:1px solid #efefef;border-radius:6px;height:213px;">
		<div style="border-bottom:2px solid #1976d2;width:105px;height: auto;margin-top: 16px;margin-left: auto;margin-right: auto;">
			<img style="" alt="" src="/jeesite/static/Pc/img/patient.png">
			<label style="font-family:STHeitiSC-Medium;font-size:18px;color:#1976d2;letter-spacing:0px;text-align:center;">患者信息</label>
		</div>
		<div style="margin-top: 40px;">
			<label class="patient" style="margin-left: 4%">患者编号:</label><label style="width: ">000000001</label>
			<label class="patient" style="margin-left: 8%">姓名:</label><label>张先生</label>
			<label class="patient" style="margin-left: 8%">年龄:</label><label>36</label>
			<label class="patient" style="margin-left: 8%">性别:</label><label>男</label>
			<label class="patient" style="margin-left: 8%">挂号类型:</label><label>普通门诊</label>
			<br>
			<label class="patient" style="margin-left: 4%">科室:</label><label>胸外科</label>
			<label class="patient" style="margin-left: 8%">医生:</label><label>刘医生</label>
			<label class="patient" style="margin-left: 8%">联系电话:</label><label>13555255555</label>
		</div>
	</div>
	<div style="width: 84%;height: auto;margin-top: 0px;margin-left:6%;background:#ffffff;border:1px solid #efefef;border-radius:6px;height:736px; ">
	</div>
</div>
<script src="/jeesite/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>



</body>
</html>