<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>医生工作站</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
  <style>
        .new-nav{
            background: #39a0ed;
            margin-bottom: 0%;
        }
    </style>
</head>
<body>
<!--导航-->
<nav class="new-nav" role="navigation" style="height: 80px;height: 80px;">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">
                <img alt="" class="img-responsive" src="img/logo.png">
            </a>
        </div>
        <p class="navbar-text" style="color: #fff;font-size: 18px;margin-top: 25px">医生工作站</p>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <div class="nav navbar-nav navbar-right">
                <p class="navbar-text" style="color: #fff ;margin-top: 25px;margin-right: 30px">2016/06/21</p>
                <p class="navbar-text" style="color: #fff ;margin-top: 25px">
                    <img src="img/user.png" alt="">
                    &nbsp;&nbsp; 张医生
                </p>
                <button type="button" class="btn btn-sm navbar-btn" style="margin-top: 21px;margin-left: 55px;background-color: #39a0ed; border:1px solid #1976d2; border-radius:8px;color: #1976d2;">退出</button>
            </div>
        </div>
    </div>
</nav>

	<script src="/jeesite/static/jquery/jquery-1.9.1.min.js"
		type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js"
		type="text/javascript"></script>
</body>
</html>