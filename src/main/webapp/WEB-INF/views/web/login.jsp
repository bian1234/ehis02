<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>EHIS-门诊应急系统</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="description" content="slick Login">
<meta name="author" content="Webdesigntuts+">
<link rel="stylesheet" type="text/css" href="/jeesite/static/Pc/css/style.css" />
<script type="text/javascript" src="/jeesite/static/Pc/js/placeholder.js"></script>
</head>
<script src="/jeesite/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function(){
	re()
	
})
$(window).resize(function(){
	re()
});
function re(){
	var w_height = $(window).height();
	var w_width = $(window).width();
	var width1 =  w_width - 528;
	var width2 =  width1/2;
	$("#slick-login").css("left",width2)	
	var width3 = $("#sicmed").width();
	var width4 = w_width - width3;
	var width5 = width4/2;
	$("#sicmed").css("left",width5)	
}

</script>
<body>
	<form id="slick-login" action="${ctx}/web/sicmedUser/login">
		<p id="title_1">EHIS-</p>
		<p id="title_2">门诊应急系统</p>
		<p id="title_3"></p>
		<p id="title_4">医院</p>
		<div id="errorMessage_div">
			<p id="errorMessage">${errorMessage}</p>
		</div>
		<input id="username" type="text" name="userTel" class="placeholder" ><br>
		<input id="password" type="password" name="password" class="placeholder">
		<div id="remember_p">
			<input id="remember_p_b" type="checkbox"><a id="remember_p_c">记住密码</a>
		</div>
		<input id="login" type="submit" value="登录">
	</form>
	<div id="sicmed" style="position: absolute;bottom: 20px;left: 42%;">
		<div style="float: left;">
		<img alt="" src="/jeesite/static/Pc/img/sicmed.png" width="80%" height="80%">
		</div>
		<div  style="float: left;margin-left:6px; font-family:MicrosoftYaHei;font-size:14px;color:#ffffff;letter-spacing:0px;text-align:left;">
		<p>安智云（北京）科技有限公司</p>
		<p style="margin-top: 8px">公司版权所有©2016 S.I.C.Med</p>
		</div>
	</div>
</body>
</html>