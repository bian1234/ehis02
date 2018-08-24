<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EHIS-门诊应急系统</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

<style type="text/css">
* {
	/* border: 1px red solid;  */
	margin: 0px;
	padding: 0px;
	
}
.but{
	background-color: #39A0ED;
	border:1px solid #1976d2;
	border-radius:8px;
	width:60px;
	height:24px;
	float: right;
	font-family:MicrosoftYaHei;
	font-size:12px;
	color:#1976d2;
	text-align:center;
	margin-top:26px;
	margin-left: 3%;
}
.sicmed{
margin-bottom:13px;
margin-top:15px;
}

#time{
float: right;
font-family:HelveticaNeue;
font-size:14px;
color:#ffffff;
text-align:center;
margin-top:28px;
}
#user_icon{
float: right;
margin-top:24px;
margin-left: 2%;
}
#user_name{
float: right;
font-family:STHeitiSC-Medium;
font-size:14px;
color:#ffffff;
text-align:left;
margin-top:28px;
margin-left: 1%;
}

.price_left_font{
font-family:MicrosoftYaHei;
font-size:16px;
color:#6e8ba3;
letter-spacing:0px;
text-align:left;
}
</style>
</head>
<body style="background:#f9f9f9;">
<div>
	<div style="width: 100%;height: 80px;background-color: #39A0ED;">
		<div style="width: 8%;height: auto;float: left;text-align: center;">
			<img class="sicmed" alt="sicmed" src="/jeesite/static/Pc/img/sicmed.png">
		</div>
		<div style="width: 90%;height: auto;float: left;">
			<label style="margin-left: 10px;margin-top: 26px;font-family:MicrosoftYaHei;font-size:18px;color:#ffffff;letter-spacing:0px;text-align:left;">收费窗口</label>
			<button class="but">退出</button>
			<label id="user_name" >张医生</label>
			<img id="user_icon"  alt="head" src="/jeesite/static/Pc/img/head.png">
			<label id="time" >2016/09/21 10:00</label>
		</div>
	</div>
	<div style="width: 100%;height: auto;">
		<div style="width: 8%;height: 1000px;float: left; background-color: #36576f;">
			<div style="background-color: #ffffff;margin-top: 58px;width:100%;height: auto;">
				<button id="toll_show_patientList" class="price_left_font" style="width: 98%;height:58px; float: right;background-color: #3e637e;border: 0px;text-align: center;"><img alt="" src="/jeesite/static/Pc/img/toll.png"><span style="margin-left: 10%">收费</span></button>
			</div>
			<div style="background-color: #ffffff;width:100%;height: auto;">
				<button id="refund_show_patientList" class="price_left_font" style="width: 100%;height:58px; float: right;background-color: #36576f;border: 0px;text-align: center;"><img alt="" src="/jeesite/static/Pc/img/refund.png"><span style="margin-left: 10%">退费</span></button>
			</div>
			<div style="background-color: #ffffff;width:100%;height: auto;">
				<button id="find_show_patientList" class="price_left_font" style="width: 100%;height:58px; float: right;background-color: #36576f;border: 0px;text-align: center;"><img alt="" src="/jeesite/static/Pc/img/find.png"><span style="margin-left: 10%">查询</span></button>
			</div>
		</div>
		<div style="width: 68%;height: auto;float: left;">
		 &nbsp;
		</div>
	</div>
</div>

<script src="/jeesite/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
	
	$("#toll_show_patientList").click(function{
		alert(11);
		$("#toll_show_patientList").css(width:"95%");
	})
})
function aa(){
	alert(11);
	$("#toll_show_patientList").css(width:"95%");
}
</script>
</body>
</html>