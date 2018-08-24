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
<style type="text/css">
*{
margin: 0px;
padding: 0px;
}

.username{
width: 70%;

background: url("/jeesite/static/Pc/img/username2.png") 10% 50% no-repeat;
background-color:#ffffff;
border-radius:23px;
height: 12%;
margin-top: 2%;
border: 1px solid #eaeaea;
text-align: center;
font-family:STHeitiSC-Medium;
font-size:14px;
color:#212121;
letter-spacing:0px;
}

.password{
width: 70%;
background: url("/jeesite/static/Pc/img/password2.png") 10% 50% no-repeat;
background-color:#ffffff;
border-radius:23px;
height: 12%;
margin-top: 3%;
border:1px solid #eaeaea;
text-align: center;
font-family:STHeitiSC-Medium;
font-size:14px;
color:#212121;
letter-spacing:0px;
}
</style>
</head>
<script src="/jeesite/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">

$(document).ready(function(){
	re()
	var a=0;
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
	
	var bac_body = $("#bac_body").width();
	var bac_body_height = bac_body/12*5;
	$("#bac_body").css("height",bac_body_height)
	$("#body_center").css("height",bac_body_height)
	
	$("#sicmed_S_I_C").css("margin-top",w_height - bac_body_height-120)
}

</script>
<body style="background: #ffffff;border: 0px;">
<div style="height: 100%;">
	<div id="body_top" style="background:#ffffff;width:100%;height: 90px">
		<div  style="width:84%;margin-left: 8%;height: 100%;text-align: left;">
			<img alt="" src="/jeesite/static/Pc/img/logo3x.png" style="height: 46px;width: 46px;margin-top: 22px;float: left;">
			<div style="margin-top: 38px;height: 46px;width:70px; font-family:MicrosoftYaHei;font-size:18px;color:#36576F;letter-spacing:0px;text-align:left;float: left;font-weight: bold;margin-left:16px;">安智云</div>
			<div style="float: left;border-left:1px solid #979797;height: 16px; margin-top: 38px;"></div>
			<div style="margin-top: 38px;height: 46px;width:180px; font-family:MicrosoftYaHei;font-size:18px;color:#36576F;letter-spacing:0px;text-align:left;float: left;font-weight: bold;margin-left:16px;">EHIS-门诊应急系统</div>
		</div>
	</div>
	<div id="body_center" style="background:#34a2b8;width:100%;height:500px;">
		<div id="bac_body" style="width: 84%;height: 100%;margin-left: 8%;position: absolute;">
			<img id="bac_img" alt="" src="/jeesite/static/Pc/img/denglubanner.jpg" width="100%" height="100%">
			<div style=" background:#ffffff;box-shadow:2px 4px 11px 0px rgba(0,0,0,0.20);border-radius:10px;width:38%;height:76%;position: absolute; top: 12%;right: 6%;text-align: center;">
				<div style="font-family:STHeitiSC-Medium;font-size:24px;color:#36576f;letter-spacing:0px;text-align:center;font-weight: bold;margin-top: 10%;">EHIS-门诊应急系统</div>
				<div id="errorMessage_div" style="width: 70%;">
					<p id="errorMessage">${errorMessage}</p>
				</div>
				<form action="${ctx}/web/sicmedUser/login" style="height: 100%;width: 100%">
					<input type="text" name="userTel" class="username">
					<input type="password" name="password" class="password">
					<div style="text-align: left;width: 70%;margin-left: 15%;height: 3.6%;margin-top: 3%;">
						<input id="radio_repas" type="checkbox"  style="border-radius:100%"><a href="#" style="font-family:STHeitiSC-Medium;font-size:14px;color:#757575;letter-spacing:0px;margin-left: 10px;">记住密码</a>
					</div>
					<input type="submit" value="登录" style="background:#ffc107;border-radius:24px;width:40%;height:12%;margin-top: 10%;font-family:STHeitiSC-Medium;font-size:24px;color:#ffffff;text-align:center;border: none;">
				</form>
			</div>
		</div>
	</div>
<div id="sicmed_S_I_C" style="height: 16px;font-family:MicrosoftYaHei;font-size:14px;color:#bdbdbd;letter-spacing:0px;">公司版权所有©2016 S.I.C.Med</div>
</div>
	<%-- <form id="slick-login" action="${ctx}/web/sicmedUser/login">
		<p id="title_1">EHIS</p>
		<p id="title_2">门诊应急系统</p>
		<p id="title_3"></p>
		<p id="title_4">北京朝阳医院</p>
		<div id="errorMessage_div">
			<p id="errorMessage">${errorMessage}</p>
		</div>
		<input id="username" type="text" name="userTel" class="placeholder" ><br>
		<input id="password" type="password" name="password" class="placeholder">
		<div id="remember_p">
			<input id="remember_p_b" type="checkbox"><a id="remember_p_c">记住密码</a>
		</div>
		<input id="login" type="submit" value="登陆">
	</form>
	<div id="sicmed" style="position: absolute;bottom: 20px;left: 42%;">
		<div style="float: left;">
		<img alt="" src="/jeesite/static/Pc/img/sicmed.png" width="80%" height="80%">
		</div>
		<div  style="float: left;margin-left:6px; font-family:MicrosoftYaHei;font-size:14px;color:#ffffff;letter-spacing:0px;text-align:left;">
		<p>安智云（北京）科技有限公司</p>
		<p style="margin-top: 8px">公司版权所有©2016 S.I.C.Med</p>
		</div>
	</div> --%>
</body>
</html>