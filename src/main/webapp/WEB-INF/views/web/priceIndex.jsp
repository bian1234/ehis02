<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>收费窗口</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.css" type="text/css" rel="stylesheet" />
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />

<style type="text/css">
		@font-face {font-family: 'iconfont';
		    src: url('/jeesite/static/Pc/vectorDiagram/iconfont.eot'); /* IE9*/
		    src: url('/jeesite/static/Pc/vectorDiagram/iconfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */
		    url('/jeesite/static/Pc/vectorDiagram/iconfont.woff') format('woff'), /* chrome、firefox */
		    url('/jeesite/static/Pc/vectorDiagram/iconfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/
		    url('/jeesite/static/Pc/vectorDiagram/iconfont.svg#iconfont') format('svg'); /* iOS 4.1- */
		}
    
	  .iconfont{
		    font-family:"iconfont" !important;
		    font-size:18px;font-style:normal;
		    -webkit-font-smoothing: antialiased;
		    -webkit-text-stroke-width: 0.2px;
		    -moz-osx-font-smoothing: grayscale;
		}


body,button, input, select, textarea,h1 ,h2, h3, h4, h5, h6 { font-family: Microsoft YaHei}
* {
	 border: 0px red solid; 
	margin: 0px;
	padding: 0px;
	
}
button{outline:none;}
label{font-weight:normal;}

.but{
	background-color: #39A0ED;
	border:1px solid #1976d2;
	border-radius:8px;
	width:70px;
	height:28px;
	float: right;
	font-family:Microsoft YaHei;
	font-size:14px;
	color:#1976d2;
	padding-top:5px;
	padding-left:20px;
	margin-top:24px;
	margin-left: 3%;
}
.but:hover {
text-decoration: none;
border:1px solid #ffffff;
color: #ffffff;
}
.sicmed{
	margin-bottom:13px;
	margin-top:15px;
}

#time{
	float: right;
	/* font-family:HelveticaNeue; */
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
	font-family:Microsoft YaHei;
	font-size:16px;
	color:#6e8ba3;
	letter-spacing:0px;
	text-align:left;
}

.tab_header{
	background:#39a0ed;
	height:44px;
}

.but-active{
	background:#124256;
	border-radius:6px;
	width:106px;
	height:28px;
	font-family:Microsoft YaHei;
	font-size:14px;
	color:#ffffff;
	letter-spacing:0px;
}

.but-re-active{
	background:#ffffff;
	border:1px solid #bdbdbd;
	border-radius:6px;
	width:106px;
	height:28px;
	font-family:Microsoft YaHei;
	font-size:14px;
	color:#212121;
	letter-spacing:0px;
	text-align:center;
}

.tit-active{
	background:#3e637e;
	width:100%;
	height:61px;
	font-family:Microsoft YaHei;
	font-size:16px;
	color:#ffffff;
	letter-spacing:0px;
}

.tit-re-active{
	background:#36576f;
	width:100%;
	height:61px;
	font-family:Microsoft YaHei;
	font-size:16px;
	color:#6e8ba3;
	letter-spacing:0px;
}

.tab_refund_patient_tr_1{
	height:44px;
	background:#ffffff;
}
.tab_refund_patient_tr_2{
	height:44px;
	background:#f9f9f9;
}

.toll_but_tab{
	background:#ffc300;
	border-radius:4px;
	width:62px;
	height:30px;
	/* font-family:STHeitiSC-Medium; */
	font-size:14px;
	color:#ffffff;
	letter-spacing:0px;
}

.pp_td_bg{
border:1px solid #efefef;
background:#ffffff;
text-align: center;
}

.pp_td_hed_bg{
border:1px solid #efefef;
text-align: center;
}

.pp_td_1{

font-size:14px;
color:#bdbdbd;
}

.pp_td_2{
font-size:14px;
color:#212121;
text-align: left;
padding-left: 20px;
}

.pp_td_3{
font-size:14px;
color:#757575;
}

.pp_td_5{
font-size:14px;
color:#ffc300;
}

.checkBox_my{
background:#f9f9f9;
border:1px solid #bdbdbd;
border-radius:6px;
width:14px;
height:14px;
}

.total_price{
font-size:20px;
color:#ffc300;
}

.total_price_money{
font-size:18px;
color:#bdbdbd;
}

.price_input{
background:#ffffff;
border:1px solid #efefef;
border-radius:6px;
width:67px;
height:28px;
font-size:18px;
color:#212121;
text-align: center;
}

.but_save_print{
background:#ffc300;
border-radius:6px;
width:120px;
height:30px;
font-size:14px;
color:#ffffff;
}

.toll_but_1{
color:#124256;
 width: 100%;
 height:62px;
 float: right;
 background-color: #efefef;
 border: 0px;
 text-align: center;
 font-size:16px;
}

.toll_but_2{
width: 100%;
height:62px; 
float: right;
background-color: #fff;
/* border-left: 4px solid #ffffff; */
text-align: center;

	font-size:16px;
	color:#124256;
	letter-spacing:0px;

}

.refund_but_1{
 color:#124256;
 width: 100%;
 height:62px;
 float: right;
 background-color: #efefef;
 border: 0px;
 text-align: center;
 font-size:16px;
}

.refund_but_2{
	width: 100%;
	height:62px; 
	float: right;
	background-color: #fff;
	/* border-left: 4px solid #ffffff; */
	text-align: center;
	
	font-size:16px;
	color:#124256;
	letter-spacing:0px;
}

.find_but_1{
font-size:16px;
	color:#124256;
	width: 100%;height:62px;
	float: right;
	background-color: #efefef;
	border: 0px;
	text-align: center;

}

.find_but_2{
font-size:16px;
	width: 100%;
	height:62px; 
	float: right;
	background-color: #fff;
	/* border-left: 4px solid #ffffff; */
	text-align: center;
	font-size:16px;
	color:#124256;
	letter-spacing:0px;

}

.patient_info_head{
font-size:14px;
color:#bdbdbd;
}

.patient_info_content{
font-size:14px;
color:#757575;
}


.toll_his_but1{
background:#3cc5de;
border-radius:6px;
width:93px;
height:28px;
font-size:14px;
color:#ffffff;
}

.toll_his_but2{
background:#ffffff;
border-radius:6px;
border:1px solid #efefef;
width:93px;
height:28px;
font-size:14px;
color:#bdbdbd;
}

.refund_his_but1{
background:#3cc5de;
border-radius:6px;
width:93px;
height:28px;
font-size:14px;
color:#ffffff;
margin-top: 4px;
}

.refund_his_but2{
background:#ffffff;
border-radius:6px;
border:1px solid #efefef;
width:93px;
height:28px;
font-size:14px;
color:#bdbdbd;
margin-top: 4px;
}
input[type=checkbox],input[type=radio]{
        -webkit-appearance: none;
        appearance: none;
        background:#f9f9f9;
		border:1px solid #bdbdbd;
		width:16px;
		height:16px;
        cursor: pointer;
        vertical-align: bottom;
        -webkit-border-radius: 1px;
        -moz-border-radius: 1px;
        border-radius: 6px;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        position: relative;
}

input[type=checkbox]:active,input[type=radio]:active {
        background: #ffc300;
}       
        

input[type=checkbox]:checked,input[type=radio]:checked {
        background:#ffc300;
        
}

#refund_his{
margin-top: 10px;
}
.dateInput{
background:#ffffff;
border:1px solid #efefef;
border-radius:6px;
width:174px;
height:26px;
padding-left: 20px;
}

/* 导航 */
 .new-nav{
      	background: #3cc5de;
      	 margin-bottom: 0%;
      	 height: 80px;
      	 margin-right:-15px;
      	 font-family: Microsoft YaHei
 }
 /* 分页 */
.pagination>li>a{
	color:#05b3d9;
}
.pagination>.active>a{
	background-color:#05b3d9;
	border-color:#05b3d9;
}
body,button, input, select, textarea,h1 ,h2, h3, h4, h5, h6 { font-family: Microsoft YaHei}

#tab_refund_patient tr td{ font-family: Microsoft YaHei }
</style>
</head>
<body>
<div>
	<%-- <div style="width: 100%;height: 80px;background-color: #39A0ED;">
		<div style="width: 10%;height: auto;float: left;text-align: center;">
			<img class="sicmed" alt="sicmed" src="/jeesite/static/Pc/img/sicmed.png">
		</div>
		<div style="width: 88%;height: auto;float: left;">
			<label style="margin-left: 10px;margin-top: 26px;font-family:Microsoft YaHei;font-size:18px;font-weight:500;color:#ffffff;letter-spacing:0px;text-align:left;">收费窗口</label>
			<a class="but" href="http://127.0.0.1:8082/jeesite/a/web/sicmedUser/index">退出</a>
			<label id="user_name" style="font-weight:500;">${sicmedUserBean.userName}</label>
			<!-- <img id="user_icon"  alt="head" src="/jeesite/static/Pc/img/head.png"> -->
			<i id="user_icon" class="iconfont yonghuming" style="font-size:20px;color:#fff;">&#xe614;</i>
			<span id="time" style="font-weight:500;">2016/09/21 10:00</span>
		</div>
	</div> --%>
	
	<!--引：header.html-->
    <nav class="new-nav" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header" style="margin-left:2%;">
                <span class="navbar-brand" href="#">
                    <img alt="" class="img-responsive" src="/jeesite/static/Pc/img/logo.png">
                </span>
            </div>
            <p class="navbar-text" style="color: #fff;font-size: 18px;margin-top: 27px;margin-left:2%;font-weight:500;">收费窗口</p>
            <ul class="nav navbar-nav navbar-right" style="margin-top:17px;margin-right:15px;color:#fff;font-weight:500;">
            	 <li><p class="navbar-text" id="current-time"></p></li>
            	  <li>
            	  	<p class="navbar-brand" style="padding-right:0px;">
        				<!-- <img src="/jeesite/static/Pc/img/user.png" alt=""> -->
        				<i class="iconfont yonghuming" style="font-size:20px;">&#xe614;</i>
      				</p>
                  </li>
                  <li><p class="navbar-text" style="margin-left:7px;">${sicmedUserBean.userName}</p></li>
            	  <li>
					<a href="http://127.0.0.1:8082/jeesite/a/web/sicmedUser/index" class="btn btn-sm navbar-btn" style="margin-left:15px;background-color: #3cc5de;color:#fff;border:1px solid #fff;padding:4px 19px;border-radius:8px;">退出</a>
				  </li>
            </ul>
        </div>
    </nav>
	
	<div id="price_body" style="width: 100%;height: auto;float: left;">
<!-- 左侧导航栏 -->	
		<div id="price_left_bar" style="width: 11%;height: 100%;float: left; background-color: #efefef;font-family:Microsoft YaHei;">
			<div style="margin-top: 40px;width:100%;height: auto;">
				<button id="toll_show_patientList" class="toll_but_2">
					<!-- <img src="/jeesite/static/Pc/img/toll2.png"> -->
					<i class="iconfont shoufei">&#xe606;</i>
					<span style="margin-left: 10%;font-family:Microsoft YaHei;">收&nbsp;费</span>
				</button>
			</div>
			<!-- <div id="toll_show_patientList_line" style="float: left;border:1px solid #657d91;height:0px; width: 80%;margin-left: 10%;"></div> -->
			<div style="width:100%;height: auto;">
				<button id="refund_show_patientList" class="refund_but_1">
					<!-- <img src="/jeesite/static/Pc/img/refund1.png"> -->
					<i class="iconfont tuifei">&#xe608;</i>
					<span style="margin-left: 10%;font-family:Microsoft YaHei;">退&nbsp;费</span>
				</button>
			</div>
			<!-- <div id="refund_show_patientList_line" style="float: left;border:1px solid #657d91;height:0px; width: 80%;margin-left: 10%;"></div> -->
			<div style="width:100%;height: auto;">
				<button id="find_show_patientList" class="find_but_1">
					<!-- <img src="/jeesite/static/Pc/img/find1.png"> -->
					<i class="iconfont chaxun">&#xe601;</i>
					<span style="margin-left: 10%;font-family:Microsoft YaHei;">查&nbsp;询</span>
				</button>
			</div>
			<!-- <div id="find_show_patientList_line" style="float: left;border:1px solid #657d91;height:0px; width: 80%;margin-left: 10%;"></div> -->
		</div>
<!-- 收费 -->		
		<div id="toll_view" style="width: 69%;height: auto;float: left;margin-left: 6%;">
			<div style="margin-top: 38px;margin-bottom:20px;width: 100%;height: auto;margin-bottom:20px;">
				<button id="price_patient_list_but" class="but-active" style='margin-right:10px;'>患者列表</button>
				<button id="patient_price_but" class="but-re-active">收费</button>
				<div id="toll_patient_search" style="float: right;width: 50%;">
					<button style="background:#3cc5de;border-radius:6px;width:12%;height:34px;float: right;color:#fff;border-top-left-radius:0px;border-bottom-left-radius:0px;">搜索</button>
					<input style="background:#ffffff;border:1px solid #ccc;border-radius:6px;border-top-right-radius:0px;border-bottom-right-radius:0px;width:50%;height:34px;padding:6px 12px;float: right;">
					<span style="font-size:14px;color:#757575;letter-spacing:0px;text-align:center;float: right;margin-top: 8px;margin-right: 2.8%">患者编号</span>
				</div>
			</div>
			<div id="toll_patient_view" style="width: 100%;">
				<!-- <table id="tab_price_patient" style="width: 100%; margin-top: 27px;background-image: url('/jeesite/static/Pc/img/tab_round.png');-moz-background-size:100%; background-size:100% ;" >
				</table> -->
				<table id="tab_price_patient" style="width: 100%; margin-top: 27px;font-family:Microsoft YaHei;" ></table>
				
				<div class="row" id="page_del_toll_patient">
   					<div class="col-lg-12 col-sm-12 text-right">
						 <nav>
							  <ul class="pagination ">
									<li id="prevpage_toll_patientlist"><a href="#">上一页</a></li>
									<li class="active" id="currentpage_toll_patientlist"><a href="">1</a></li>
									<li id="nextpage_toll_patientlist"><a href="#">下一页</a></li>
							  </ul>
						</nav>
					</div>
   				</div>
			</div>
			
			<div id="toll_price_view" style="display: none;width:100%; ">
				<div style="margin-top: 40px;background:#ffffff;border:1px solid #efefef;border-radius:6px;width:100%;height:105px;">
					<input type="hidden" id="toll_patientId_h">
					<div style="width: 22%;float: left;margin-top: 28px;margin-left: 2%;">
						<span class="patient_info_head">患者编号:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientNumber_toll" class="patient_info_content"></span><br><br>
						<span class="patient_info_head">姓名:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientName_toll" class="patient_info_content"></span>
					</div>
					<div style="width: 22%;float: left;margin-top: 28px;margin-left: 2%;">
						<span class="patient_info_head">科室:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientBranch_toll" class="patient_info_content"></span><br><br>
						<span class="patient_info_head">年龄:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientAge_toll" class="patient_info_content"></span>
					</div>
					<div style="width: 22%;float: left;margin-top: 28px;margin-left: 2%;">
						<span class="patient_info_head">医生:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientDoctor_toll" class="patient_info_content"></span><br><br>
						<span class="patient_info_head">性别:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientSex_toll" class="patient_info_content"></span>
					</div>	
					<div style="width: 22%;float: left;margin-top: 28px;margin-left: 2%;">
						<span class="patient_info_head">挂号类型:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientRegistered_toll" class="patient_info_content"></span><br><br>
					</div>
					<br>
				</div>
				<!-- <table id="tab_patient_price_unit"  style="border:1px solid #efefef;width: 100%; margin-top: 27px;background-image: url('/jeesite/static/Pc/img/tab_round.png');-moz-background-size:100%; background-size:100% ;" >
				</table> -->
				<table id="tab_patient_price_unit"  style="border:1px solid #efefef;width: 100%; margin-top: 27px;" >
				</table>
				<div style="text-align:right;margin-top: 44px;">
					<label class="total_price">总计:</label>&nbsp;&nbsp;&nbsp;&nbsp;<label id="total_price" class="total_price">0.00</label>&nbsp;&nbsp;&nbsp;&nbsp;<label class="total_price">元</label>
				</div>
				<div style="text-align:right;margin-top: 30px;">
					<label class="total_price_money">实收:</label>&nbsp;&nbsp;&nbsp;&nbsp;<input id="input_price" class="price_input" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<label class="total_price_money">元</label>&nbsp;&nbsp;&nbsp;&nbsp;
					<label class="total_price_money">找零:</label>&nbsp;&nbsp;&nbsp;&nbsp;<label id="refund_price" class="" style="font-size:18px;color:#212121;">0.00</label>&nbsp;&nbsp;&nbsp;&nbsp;<label class="total_price_money">元</label>
				</div>
				<div style="text-align:right;margin-top: 30px;">
					<button id="toll_sure" class="but_save_print">保存</button>
					<button id="toll_print" class="but_save_print">打印</button>
				</div>
			</div>
		</div>
<!-- 退费 -->
		<div id="refund_view" style="width: 69%;height: auto;float: left;display: none;margin-left: 6%;">
			<div style="margin-top: 38px;margin-bottom:20px;width: 100%;height: auto;">
				<button id="refund_patient_list_but" class="but-active" style='margin-right:10px;'>患者列表</button>
				<button id="patient_refund_but" class="but-re-active">退费</button>
				<div id="refund_patient_search" style="float: right;width: 50%;">
					<button style="background:#3cc5de;border-radius:6px;width:12%;height:34px;float: right;color:#fff;border-top-left-radius:0px;border-bottom-left-radius:0px;">搜索</button>
					<input style="background:#ffffff;border:1px solid #ccc;border-radius:6px;width:50%;height:34px;padding:6px 12px;float: right;border-top-right-radius:0px;border-bottom-right-radius:0px;">
					<label style="font-size:14px;color:#757575;letter-spacing:0px;text-align:center;float: right;margin-top: 8px;margin-right: 2.8%">患者编号</label>
				</div>
			</div>
			<div id="refund_patient_view" style="width: 100%;">
				<!-- <table id="tab_refund_patient" style="width: 100%; margin-top: 27px;background-image: url('/jeesite/static/Pc/img/tab_round.png');-moz-background-size:100%; background-size:100%;" >
				</table> -->
				<table id="tab_refund_patient" style="width: 100%; margin-top: 27px;"></table>
				<div class="row" id="page_del_refund_patient">
				   <div class="col-lg-12 col-sm-12 text-right">
						 <nav>
							  <ul class="pagination ">
									<li id="prevpage_refund_patientlist"><a href="#">上一页</a></li>
									<li class="active" id="currentpage_refund_patientlist"><a href="">1</a></li>
									<li id="nextpage_refund_patientlist"><a href="#">下一页</a></li>
							  </ul>
						</nav>
				   </div>
			   </div>
			</div>
			<div id="refund_price_view" style="display: none;">
				<div style="margin-top: 40px;background:#ffffff;border:1px solid #efefef;border-radius:6px;width:100%;height:105px;">
					<input type="hidden" id="refund_patientId_h">
					<div style="width: 22%;float: left;margin-top: 28px;margin-left: 2%;">
						<span class="patient_info_head">患者编号:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientNumber_refund" class="patient_info_content"></span><br><br>
						<span class="patient_info_head">姓名:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientName_refund" class="patient_info_content"></span>
					</div>
					<div style="width: 22%;float: left;margin-top: 28px;margin-left: 2%;">
						<span class="patient_info_head">科室:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientBranch_refund" class="patient_info_content"></span><br><br>
						<span class="patient_info_head">年龄:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientAge_refund" class="patient_info_content"></span>
					</div>
					<div style="width: 22%;float: left;margin-top: 28px;margin-left: 2%;">
						<span class="patient_info_head">医生:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientDoctor_refund" class="patient_info_content"></span><br><br>
						<span class="patient_info_head">性别:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientSex_refund" class="patient_info_content"></span>
					</div>	
					<div style="width: 22%;float: left;margin-top: 28px;margin-left: 2%;">
						<span class="patient_info_head">挂号类型:</span>&nbsp;&nbsp;&nbsp;&nbsp;<span id="patientRegistered_refund" class="patient_info_content"></span><br><br>
					</div>
					<br>
				</div>
				<!-- <table id="tab_patient_refund_unit"  style="border:1px solid #efefef;width: 100%; margin-top: 27px;background-image: url('/jeesite/static/Pc/img/tab_round.png');-moz-background-size:100%; background-size:100% ;" >
				</table> -->
				<table id="tab_patient_refund_unit"  style="border:1px solid #efefef;width: 100%; margin-top: 27px;" >
				</table>
				<div style="text-align:right;margin-top: 44px;">
					<label class="total_price">退费总计:</label>&nbsp;&nbsp;&nbsp;&nbsp;<label id="total_refund_price" class="total_price">0.00</label>&nbsp;&nbsp;&nbsp;&nbsp;<label class="total_price">元</label>
				</div>
				<div style="text-align:right;margin-top: 30px;">
					<button id="refund_sure" class="but_save_print">保存</button>
					<button id="refund_print" class="but_save_print">打印</button>
				</div>
			</div>
		</div>
<!-- 收费退费记录 -->		
		<div id="find_view" style="width: 69%;height: auto;float: left;display: none;margin-left: 6%;">
			<div id="find_patient_view">
				<div style="margin-top: 40px;background:#ffffff;border:1px solid #efefef;border-radius:6px;width:100%;height:108px;">
					<div style="width: 8%;height:48px; float: left;margin-top: 30px;text-align: center;">
						<span class="patient_info_head">筛选</span><br><br>
						<span class="patient_info_head" >条件</span>
					</div>
					<label style="border-left:1px  solid #efefef;height:100%; float: left;"></label>
					<div style="width: 17%;float: left;margin-top: 20px;height: 62px;text-align: center;">
						<p class="patient_info_head">
							<button id="toll_his" class="toll_his_but1">收费记录</button>
						</p>
						<p class="patient_info_head">
							<button id="refund_his" class="refund_his_but2">退费记录</button>
						</p>
						<input id="isPay_toll_refund_h" type="hidden" value="0">
					</div>
					<label style="border-left:1px solid #efefef;height:100%; float: left;"></label>
					<div style=" text-align: center;float: left;width:74%; ">
						<div style="width: 46%;float: left;margin-top: 19px;height: 74px;text-align: right;margin-right: 0px;">
							<span class="patient_info_head" style="font-family:STHeitiSC-Medium;font-size:14px;color:#bdbdbd;letter-spacing:0px;margin-top: 8px;">开始日期:</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input readonly="readonly" placeholder="请选择"  class="datainp dateInput" id="beginDate" type="text" onClick="jeDate({dateCell:'#beginDate',isTime:true,maxDate: jeDate.now(0),format:'YYYY-MM-DD hh:mm:ss'})"><br><br>						
							<span class="patient_info_head" style="font-family:STHeitiSC-Medium;font-size:14px;color:#bdbdbd;letter-spacing:0px;margin-top: 30px;">结束日期:</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input readonly="readonly" placeholder="请选择" style="margin-top:0px; " class="datainp dateInput" id="endDate" type="text" onClick="jeDate({dateCell:'#endDate',isTime:true,maxDate: jeDate.now(0),format:'YYYY-MM-DD hh:mm:ss'})">
						</div>	
						<div style="width: 20%;float: left;margin-top: 19px;height: 74px;text-align: center;">
							<span class="patient_info_head"><button id="history_toll_refund" style="background:#ffffff;border:1px solid #124256;border-radius:6px;width:78px;height:70px;font-family:STHeitiSC-Medium;font-size:14px;color:#212121;line-height:24px;">开始<br>统计</button></span>
						</div>
						<div style="width: 34%;float: left;margin-top: 19px;height: 74px;text-align: left;margin-left: 0px;">
							<span class="patient_info_head" style="margin-top:8px; font-family:STHeitiSC-Medium;font-size:14px;color:#bdbdbd;letter-spacing:0px;">人数:</span>
							<input  id="total_patient" class="" style="background:#ffffff;border:1px solid #efefef;border-radius:6px;width:102px;height: 26px;text-align: center;"/>
							<span class="patient_info_head" >人</span><br><br>
							<span class="patient_info_head" style="margin-top:30px; font-family:STHeitiSC-Medium;font-size:14px;color:#bdbdbd;letter-spacing:0px;">金额:</span>
							<input  id="total_price_his" class="" style="background:#ffffff;border:1px solid #efefef;border-radius:6px;width:102px;height: 26px;text-align: center;"/>
							<span class="patient_info_head" >元</span><br><br>
						</div>
					</div>
					<br>
				</div>
				<table id="tab_patient_find"  style="border:1px solid #efefef;width: 100%; margin-top: 27px;background-image: url('/jeesite/static/Pc/img/tab_round.png');-moz-background-size:100%; background-size:100% ;" >
					
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="/jeesite/static/Pc/jedate/jedate.js"></script>
<script src="/jeesite/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js" type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>

<!-- 引入弹窗插件bootbox.js -->
<script src="/jeesite/static/Pc/js/bootbox.min.js" type="text/javascript"></script>

<script type="text/javascript">
var tollPageNo = 1;
var refundPageNo = 1;

$(document).ready(function(){
	getTollPatientList(tollPageNo);
})

/* 点击事件 */
$(function(){
	/* 收费视图显示 */
	$("#toll_show_patientList").click(function(){
		var a = $("#toll_patientId_h").val();
		if(a = 'undefine' ){
			$("#patient_price_but").attr({"disabled":"disabled"}); 
		}else{
			$("#patient_price_but").removeAttr("disabled"); 
		}
		
		$("#toll_show_patientList").removeClass("toll_but_1");
		$("#toll_show_patientList").addClass("toll_but_2");
		$("#refund_show_patientList").addClass("refund_but_1");
		$("#refund_show_patientList").removeClass("refund_but_2");
		$("#find_show_patientList").addClass("find_but_1");
		$("#find_show_patientList").removeClass("find_but_2");
		
		$("#toll_show_patientList img").attr("src","/jeesite/static/Pc/img/toll2.png");
		$("#refund_show_patientList img").attr("src","/jeesite/static/Pc/img/refund1.png");
		$("#find_show_patientList img").attr("src","/jeesite/static/Pc/img/find1.png");
		
		getTollPatientList(tollPageNo); 
		$("#refund_view").hide();
		$("#find_view").hide();
		$("#toll_show_patientList_line").hide();
		$("#refund_show_patientList_line").show();
		$("#find_show_patientList_line").show();
		$("#toll_view").show();
	})
	$("#price_patient_list_but").click(function(){
		$("#toll_price_view").hide();
		$("#toll_patient_search").show();
		
		$("#tab_price_patient").show();
		$("#page_del_toll_patient").show();
		
		$("#price_patient_list_but").removeClass("but-re-active");
		$("#price_patient_list_but").addClass("but-active");
		$("#patient_price_but").removeClass("but-active");
		$("#patient_price_but").addClass("but-re-active");
		resizeBar()
	})
	$("#patient_price_but").click(function(){
		
		$("#toll_patient_search").hide();
		
		$("#tab_price_patient").hide();
		$("#page_del_toll_patient").hide();
		
		$("#toll_price_view").show();
		$("#patient_price_but").removeClass("but-re-active");
		$("#patient_price_but").addClass("but-active");
		$("#price_patient_list_but").removeClass("but-active");
		$("#price_patient_list_but").addClass("but-re-active");
		resizeBar()
	})
	/* 退费视图显示 */
	$("#refund_show_patientList").click(function(){
		var a = $("#refund_patientId_h").val();
		if(a = 'undefine' ){
			$("#patient_refund_but").attr({"disabled":"disabled"}); 
		}else{
			$("#patient_refund_but").removeAttr("disabled"); 
		}
		
		$("#refund_show_patientList").addClass("refund_but_2");
		$("#refund_show_patientList").removeClass("refund_but_1");
		$("#toll_show_patientList").addClass("toll_but_1");
		$("#toll_show_patientList").removeClass("toll_but_2");
		$("#find_show_patientList").addClass("find_but_1");
		$("#find_show_patientList").removeClass("find_but_2");
		
		$("#toll_show_patientList img").attr("src","/jeesite/static/Pc/img/toll1.png");
		$("#refund_show_patientList img").attr("src","/jeesite/static/Pc/img/refund2.png");
		$("#find_show_patientList img").attr("src","/jeesite/static/Pc/img/find1.png");
		
		getRefundPatientList(); 
		$("#toll_view").hide();
		$("#find_view").hide();
		$("#refund_show_patientList_line").hide();
		$("#toll_show_patientList_line").show();
		$("#find_show_patientList_line").show();
		$("#refund_view").show();
	})
	$("#refund_patient_list_but").click(function(){
		$("#refund_price_view").hide();
		$("#refund_patient_search").show();
		$("#refund_patient_view").show();
		
		$("#tab_refund_patient").show();
		$("#page_del_refund_patient").show();
		
		$("#refund_patient_list_but").removeClass("but-re-active");
		$("#refund_patient_list_but").addClass("but-active");
		$("#patient_refund_but").removeClass("but-active");
		$("#patient_refund_but").addClass("but-re-active");
		resizeBar()
	})
	$("#patient_refund_but").click(function(){
		$("#tab_refund_patient").hide();
		$("#page_del_refund_patient").hide();
		
		$("#refund_patient_search").hide();
		$("#refund_price_view").show();
		$("#patient_refund_but").removeClass("but-re-active");
		$("#patient_refund_but").addClass("but-active");
		$("#refund_patient_list_but").removeClass("but-active");
		$("#refund_patient_list_but").addClass("but-re-active");
		resizeBar()
	})
	/* 历史记录视图显示 */
	$("#find_show_patientList").click(function(){
		
		$("#refund_show_patientList").addClass("refund_but_1");
		$("#refund_show_patientList").removeClass("refund_but_2");
		$("#toll_show_patientList").addClass("toll_but_1");
		$("#toll_show_patientList").removeClass("toll_but_2");
		$("#find_show_patientList").addClass("find_but_2");
		$("#find_show_patientList").removeClass("find_but_1");
		
		$("#toll_show_patientList img").attr("src","/jeesite/static/Pc/img/toll1.png");
		$("#refund_show_patientList img").attr("src","/jeesite/static/Pc/img/refund1.png");
		$("#find_show_patientList img").attr("src","/jeesite/static/Pc/img/find2.png");
		
		$("#toll_view").hide();
		$("#refund_view").hide();
		$("#find_show_patientList_line").hide();
		$("#refund_show_patientList_line").show();
		$("#toll_show_patientList_line").show();
		$("#find_view").show();
		resizeBar()
	})
	
	/* 收费 总价 输入价格 找零 变更  */	
	function totalPrice(){
		var total_price = $("#total_price").html();
		var input_price = $("#input_price").val();
		var refund_price = input_price - total_price;
		var refund = refund_price/1;
		refund = refund.toFixed(2)
		$("#refund_price").html(refund);
	}
	$('#input_price').bind('input propertychange', function() {
		var total_price = $("#total_price").html();
		var input_price = $("#input_price").val();
		var refund_price = input_price - total_price;
		var refund = refund_price/1;
		refund = refund.toFixed(2)
		$("#refund_price").html(refund);
	})
	/* 点击收费 保存按钮 */
	$('#toll_sure').bind('click',function(){
		var ids = "";
		$(".check_checkbox").each(function(){
			if($(this).is(':checked')){
				var a = $(this).attr("id");
				ids = ids+a+"$";
			}
		})
		$(".inspect_checkbox").each(function(){
			if($(this).is(':checked')){
				var a = $(this).attr("id");
				ids = ids+a+"$";
			}
		})
		$(".cure_checkbox").each(function(){
			if($(this).is(':checked')){
				var a = $(this).attr("id");
				ids = ids+a+"$";
			}
		})
		$(".medical_checkbox").each(function(){
			if($(this).is(':checked')){
				var a = $(this).attr("id");
				ids = ids+a+"$";
			}
		})
		updatePatientPrice(ids);
	})
	
	/* 点击收费 打印按钮 */
	$('#toll_print').bind('click',function(){
		
	})
	
	/* 点击收退费 保存按钮 */
	$('#refund_sure').bind('click',function(){
		var ids = "";
		$(".refund_check_checkbox").each(function(){
			if($(this).is(':checked')){
				var a = $(this).attr("id");
				ids = ids+a+"$";
			}
		})
		$(".refund_inspect_checkbox").each(function(){
			if($(this).is(':checked')){
				var a = $(this).attr("id");
				ids = ids+a+"$";
			}
		})
		$(".refund_cure_checkbox").each(function(){
			if($(this).is(':checked')){
				var a = $(this).attr("id");
				ids = ids+a+"$";
			}
		})
		$(".refund_medical_checkbox").each(function(){
			if($(this).is(':checked')){
				var a = $(this).attr("id");
				ids = ids+a+"$";
			}
		})
		deletePatientPrice(ids);
	})
	
	/* 点击退费 打印按钮 */
	$('#refund_print').bind('click',function(){
		
	})
	
	/* 查询历史记录 */ 
	$('#history_toll_refund').bind('click',function(){
		var isPay = $('#isPay_toll_refund_h').val();
		var beginDate = $('#beginDate').val();
		var endDate = $('#endDate').val();
		getHistory(isPay,beginDate,endDate);
	})
	$('#toll_his').bind('click',function(){
		$('#toll_his').removeClass("toll_his_but2")
		$('#toll_his').addClass("toll_his_but1")
		$('#refund_his').removeClass("refund_his_but1")
		$('#refund_his').addClass("refund_his_but2")
		 $('#isPay_toll_refund_h').val(0);
	})
	$('#refund_his').bind('click',function(){
		$('#toll_his').removeClass("toll_his_but1")
		$('#toll_his').addClass("toll_his_but2")
		$('#refund_his').removeClass("refund_his_but2")
		$('#refund_his').addClass("refund_his_but1")
		$('#isPay_toll_refund_h').val(1);
	})
	
})
/* 收费项选择 多选 */
function getChecked(id){
	var i = "."+id;
	var j = "#"+id;
	if($(j).is(':checked')){
		$(i).prop("checked",true);
		$(i).each(function(){
			var s = $(this).attr("alt");
			plusTotalPrice(s);
		})
	}else{
		$(i).prop("checked",false);
		$(i).each(function(){
			var p = $(this).attr("alt");
			lessTotalPrice(p);
		})
	}
}
/* 收费项选择 反选*/
function getCheckeds(cla,id){
	var i = "."+cla;
	var j = "#"+cla;
	var m = "."+id;
	var n = "#"+id;
	var s = $(n).attr("alt");
	if($(n).is(':checked')){
		plusTotalPrice(s);
		var a = 0;
		var l = $(i).length;
		$(i).each(function(){
			if($(this).is(':checked')){
				a = a+1;
			}else{
				$(j).prop("checked",false);
			}
		})
		if(a == l){
			$(j).prop("checked",true);
		}
	}else{
		lessTotalPrice(s);
		$(j).prop("checked",false);	
	}
}

/* 根据 选择的 收费 项目 算总价 */
 function plusTotalPrice(selectPrice){
	 var total_price = $("#total_price").html();
	 total_price = total_price*1 + selectPrice*1;
	 $("#total_price").html(total_price);
		var input_price = $("#input_price").val();
		var refund_price = input_price - total_price;
	 var refund = refund_price/1;
		refund = refund.toFixed(2)
		$("#refund_price").html(refund);
 }
 function lessTotalPrice(selectPrice){
	 var total_price = $("#total_price").html();
	 total_price = total_price - selectPrice;
	 $("#total_price").html(total_price);
	 
	 
	 var input_price = $("#input_price").val();
		var refund_price = input_price - total_price;
		var refund = refund_price/1;
		refund = refund.toFixed(2)
		$("#refund_price").html(refund);
 }
 
 /* 退费 多选 */
 function getCheckedRefund(id){
 	var i = "."+id;
 	var j = "#"+id;
 	if($(j).is(':checked')){
 		$(i).prop("checked",true);
 		$(i).each(function(){
 			var s = $(this).attr("alt");
 			plusTotalPriceRefund(s);
 		})
 	}else{
 		$(i).prop("checked",false);
 		$(i).each(function(){
 			var p = $(this).attr("alt");
 			lessTotalPriceRefund(p);
 		})
 	}
 }
 /* 退费 反选*/
 function getCheckedRefunds(cla,id){
 	var i = "."+cla;
 	var j = "#"+cla;
 	var m = "."+id;
 	var n = "#"+id;
 	var s = $(n).attr("alt");
 	if($(n).is(':checked')){
 		plusTotalPriceRefund(s);
 		var a = 0;
 		var l = $(i).length;
 		$(i).each(function(){
 			if($(this).is(':checked')){
 				a = a+1;
 			}else{
 				$(j).prop("checked",false);
 			}
 		})
 		if(a == l){
 			$(j).prop("checked",true);
 		}
 	}else{
 		lessTotalPriceRefund(s);
 		$(j).prop("checked",false);	
 	}
 }

 /* 根据 选择的 退费 项目 算总价 */
  function plusTotalPriceRefund(selectPrice){
 	 var total_price = $("#total_refund_price").html();
 	 total_price = total_price*1 + selectPrice*1;
 	 $("#total_refund_price").html(total_price);
  }
  function lessTotalPriceRefund(selectPrice){
 	 var total_price = $("#total_refund_price").html();
 	 total_price = total_price - selectPrice;
 	 $("#total_refund_price").html(total_price);
  }
 	

/* 获取可以缴费的患者列表 */ 
var toll_data_length;
function getTollPatientList(pageNo){
	var a = $("#toll_patientId_h").val();
	if(a = 'undefine' ){
		$("#patient_price_but").attr({"disabled":"disabled"}); 
	}else{
		$("#patient_price_but").removeAttr("disabled"); 
	}
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatient/getByParams',
		data : "ssid=${sicmedUserBean.ssid}&isPay=0&pageNo="+pageNo,
		cache : false,
		dataType : 'json',
		success : function(data) {
					//	var a = JSON.stringify(data);//jsonObj 转 jsonStr
					console.log(data);
					toll_data_length = data.sicmedPatientBeans.length;
					
					$.each(data,function(name, value) {
						$("#tab_price_patient").children().remove();
						$("#tab_price_patient").append("<tr style='height:44px;color:#fff;background-color:#124256;'>"
						+"<td align='center' style='border-radius:6px 0px 0px 0px;'>患者编号</td>"
						+"<td>姓名</td>"
						+"<td>性别</td>"
						+"<td>身份证</td>"
						+"<td>就诊时间</td>"
						+"<td>电话</td>"
						+"<td style='padding-left:10px;border-radius:0px 6px 0px 0px;'>操作</td>"
						+"</tr>");
						if (name == "sicmedPatientBeans") {
							$.each(value,function(name2,value2) {
								var a = name2
								var patientCard = value2.patientCard;
								if(value2.patientCard==undefined){
								 patientCard = "未填写"; 
								}
								var patientTel = value2.patientTel;
								if(value2.patientTel==undefined){
									patientTel = "未填写"; 
								}
								if(a%2==0){
								$("#tab_price_patient").append("<tr class='tab_refund_patient_tr_2' style='color:#757575;'>"
										+"<td align='center'>"+value2.patientNumber+"</td>"
										+"<td>"+value2.patientName+"</td>"
										+"<td>"+value2.patientSex+"</td>"
										+"<td>"+patientCard+"</td>"
										+"<td>"+value2.patientFirstdate+"</td>"
										+"<td>"+patientTel+"</td>"
										+"<td><button id="+value2.id+ " class='toll_but_tab' onclick='getYesByPatient(this.id)'>收费</button></td>"
										+"</tr>");
								}else{
								$("#tab_price_patient").append("<tr class='tab_refund_patient_tr_1' style='color:#757575;'>"
										+"<td align='center'>"+value2.patientNumber+"</td>"
										+"<td>"+value2.patientName+"</td>"
										+"<td>"+value2.patientSex+"</td>"
										+"<td>"+patientCard+"</td>"
										+"<td>"+value2.patientFirstdate+"</td>"
										+"<td>"+patientTel+"</td>"
										+"<td><button id="+value2.id+ " class='toll_but_tab' onclick='getYesByPatient(this.id)'>收费</button></td>"
										+"</tr>");
								}
							
							});
						}
					});
					resizeBar();
					$("#tab_price_patient tr").bind('click', function() {
					});
					},
					error : function() {
						alert("请求出错");
					}
		});
}

/* 收费-患者列表分页 */
// 下一页
$("#nextpage_toll_patientlist").click(function(e){
	if(toll_data_length == 20){
		tollPageNo ++;
		getTollPatientList(tollPageNo);
		$("#currentpage_toll_patientlist a").html(tollPageNo);
	}
	e.preventDefault();
})

// 上一页
$("#prevpage_toll_patientlist").click(function(e){
	if(tollPageNo>1){
		tollPageNo --;
		getTollPatientList(tollPageNo);
		$("#currentpage_toll_patientlist a").html(tollPageNo);
	}
	e.preventDefault();
})








/* 获取 可以退费的 患者列表  */
function getRefundPatientList(){
	$.ajax({
		type : 'get',
url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatient/getByParams',
data : "ssid=${sicmedUserBean.ssid}&isPay=1",
		cache : false,
		dataType : 'json',
		success : function(data) {
					//	var a = JSON.stringify(data);//jsonObj 转 jsonStr
					console.log(data);
					$.each(data,function(name, value) {
						$("#tab_refund_patient").children().remove();
						$("#tab_refund_patient").append("<tr style='height:44px;color:#fff;background-color:#124256;'>"
						+"<td align='center' style='border-radius:6px 0px 0px 0px;'>患者编号</td>"
						+"<td>姓名</td>"
						+"<td>性别</td>"
						+"<td>身份证</td>"
						+"<td>就诊时间</td>"
						+"<td>电话</td>"
						+"<td style='padding-left:10px;border-radius:0px 6px 0px 0px;'>操作</td>"
						+"</tr>");
						if (name == "sicmedPatientBeans") {
							$.each(value,function(name2,value2) {
								var a = name2
								if(a%2==0){
								$("#tab_refund_patient").append("<tr class='tab_refund_patient_tr_1' style='color:#757575;'>"
										+"<td align='center'>"+value2.patientNumber+"</td>"
										+"<td>"+value2.patientName+"</td>"
										+"<td>"+value2.patientSex+"</td>"
										+"<td>"+value2.patientCard+"</td>"
										+"<td>"+value2.patientFirstdate+"</td>"
										+"<td>"+value2.patientTel+"</td>"
										+"<td><button id="+value2.id+ " class='toll_but_tab' onclick='getRefundByPatient(this.id)'>退费</button></td>"
										+"</tr>");
								}else{
								$("#tab_refund_patient").append("<tr class='tab_refund_patient_tr_2' style='color:#757575;'>"
										+"<td align='center'>"+value2.patientNumber+"</td>"
										+"<td>"+value2.patientName+"</td>"
										+"<td>"+value2.patientSex+"</td>"
										+"<td>"+value2.patientCard+"</td>"
										+"<td>"+value2.patientFirstdate+"</td>"
										+"<td>"+value2.patientTel+"</td>"
										+"<td><button id="+value2.id+ " class='toll_but_tab' onclick='getRefundByPatient(this.id)'>退费</button></td>"
										+"</tr>");
								}
							
							});
						}
					});
					resizeBar();
					$("#tab_refund_patient tr").bind('click', function() {
					});
					},
					error : function() {
						alert("请求出错");
					}
		});
} 
/* 根据患者 ID获取 缴费信息  */
function getYesByPatient(patientId){
	$.ajax({
		type : 'get',
url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatientPrice/getYesByPatient',
data : "ssid=${sicmedUserBean.ssid}&isPay=0&patientId="+patientId,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					$.each(data,function(key, value) {
						$("#toll_patient_search").hide();
						$("#patient_price_but").removeAttr("disabled"); 
						if(data.error == 1){
							$("#tab_patient_price_unit").children().remove();
						}
						if (key == "sicmedRegisteredBean"){
							$("#toll_patientId_h").val(value.sicmedPatientBean.id);
							$("#patientNumber_toll").html(value.sicmedPatientBean.patientNumber);
							$("#patientBranch_toll").html(value.sicmedBranchBean.branchName);
							
							if(value.sicmedDoctorBean){
								$("#patientDoctor_toll").html(value.sicmedDoctorBean.userName);
							}
							
							$("#patientRegistered_toll").html(value.sicmedRegisteredTypeBean.typeName);
							$("#patientName_toll").html(value.sicmedPatientBean.patientName);
							$("#patientAge_toll").html(value.sicmedPatientBean.patientAge);
							$("#patientSex_toll").html(value.sicmedPatientBean.patientSex);
							
						}
						if (key == "sicmedPatientUnitPriceBeans") {
							$("#tab_patient_price_unit").children().remove();
							$("#tab_patient_price_unit").append("<tr style='height:44px;color:#fff;background-color:#05b3d9;'>"
							+"<td class='pp_td_hed_bg' align='center'>类别</td>"
							+"<td class='pp_td_hed_bg' align='center'>名称</td>"
							+"<td class='pp_td_hed_bg' align='center'>数量</td>"
							+"<td class='pp_td_hed_bg' align='center'>价格</td>"
							+"<td class='pp_td_hed_bg' align='center'>小计</td>"
							+"</tr>");
							var checkNo = 0;
							var inspectNo = 0;
							var cureNo = 0;
							var medicalNo = 0;
							$.each(value,function(key2,value2) {
								if(value2.sicmedTwxrayCheckBean!=undefined){
									if(checkNo==0){
									$("#tab_patient_price_unit").append("<tr style='height:44px;'>"
											+"<td rowspan="+data.checkNo+" class='pp_td_bg pp_td_1' align='center'><input type='checkbox' id='check_checkbox'  onclick='getChecked(this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;检查</td>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value2.checkPrice+" name='check_checkbox' class='check_checkbox' id="+value2.priceId+"  onclick='getCheckeds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value2.sicmedTwxrayCheckBean.checkName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value2.checkPrice+"</td>"
											+"<td rowspan="+data.checkNo+" class='pp_td_bg pp_td_5'>¥"+data.totalCheckPrice+"</td>"
											+"</tr>");
									}else{
									$("#tab_patient_price_unit").append("<tr style='height:44px;'>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value2.checkPrice+" name='check_checkbox' class='check_checkbox' id="+value2.priceId+"  onclick='getCheckeds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value2.sicmedTwxrayCheckBean.checkName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value2.checkPrice+"</td>"
											+"</tr>");
									}
									checkNo = checkNo+1;
								}
							});
							$.each(value,function(key3,value3) {
								if(value3.sicmedInspectBean!=undefined){
									if(inspectNo==0){
									$("#tab_patient_price_unit").append("<tr style='height:44px;'>"
											+"<td rowspan="+data.inspectNo+" class='pp_td_bg pp_td_1' align='center'><input type='checkbox' id='inspect_checkbox'  onclick='getChecked(this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;检验</td>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value3.inspectPrice+" name='inspect_checkbox' class='inspect_checkbox' id="+value3.priceId+"  onclick='getCheckeds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value3.sicmedInspectBean.inspectName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value3.inspectPrice+"</td>"
											+"<td rowspan="+data.inspectNo+" class='pp_td_bg pp_td_5'>¥"+data.totalInspectPrice+"</td>"
											+"</tr>");
									}else{
									$("#tab_patient_price_unit").append("<tr style='height:44px;'>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value3.inspectPrice+" name='inspect_checkbox' class='inspect_checkbox' id="+value3.priceId+"  onclick='getCheckeds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value3.sicmedInspectBean.inspectName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value3.inspectPrice+"</td>"
											+"</tr>");
									}
									inspectNo = inspectNo+1;
								}
							});
							$.each(value,function(key4,value4) {
								if(value4.sicmedCureCheckBean!=undefined){
									if(cureNo==0){
									$("#tab_patient_price_unit").append("<tr style='height:44px;'>"
											+"<td rowspan="+data.cureNo+" class='pp_td_bg pp_td_1' align='center'><input type='checkbox' id='cure_checkbox'  onclick='getChecked(this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;治疗</td>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value4.curePrice+" name='cure_checkbox'  class='cure_checkbox' id="+value4.priceId+" onclick='getCheckeds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value4.sicmedCureCheckBean.cureName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value4.curePrice+"</td>"
											+"<td rowspan="+data.cureNo+" class='pp_td_bg pp_td_5'>¥"+data.totalCurePrice+"</td>"
											+"</tr>");
									}else{
									$("#tab_patient_price_unit").append("<tr style='height:44px;'>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value4.curePrice+" name='cure_checkbox' class='cure_checkbox' id="+value4.priceId+" onclick='getCheckeds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value4.sicmedCureCheckBean.cureName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value4.curePrice+"</td>"
											+"</tr>");
									}
									cureNo = cureNo+1;
								}
							});
							$.each(value,function(key5,value5) {
								if(value5.sicmedMedicalBean!=undefined){
									if(medicalNo==0){
									$("#tab_patient_price_unit").append("<tr style='height:44px;'>"
											+"<td rowspan="+data.medicalNo+" class='pp_td_bg pp_td_1' align='center'><input type='checkbox' id='medical_checkbox' onclick='getChecked(this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;药品</td>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value5.medicalPrice+" name='medical_checkbox' class='medical_checkbox' id="+value5.priceId+" onclick='getCheckeds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value5.sicmedMedicalBean.medicalNameChina+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value5.medicalPrice+"</td>"
											+"<td rowspan="+data.medicalNo+" class='pp_td_bg pp_td_5'>¥"+data.totalMedicalPrice+"</td>"
											+"</tr>");
									}else{
									$("#tab_patient_price_unit").append("<tr style='height:44px;'>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value5.medicalPrice+" name='medical_checkbox' class='medical_checkbox' id="+value5.priceId+" onclick='getCheckeds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value5.sicmedMedicalBean.medicalNameChina+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value5.medicalPrice+"</td>"
											+"</tr>");
									}
									medicalNo = medicalNo+1;
								}
							});
						}
					});
						$("#tab_price_patient").hide();
						$("#page_del_toll_patient").hide();
						
						$("#toll_price_view").show();
						$("#patient_price_but").removeClass("but-re-active");
						$("#patient_price_but").addClass("but-active");
						$("#price_patient_list_but").removeClass("but-active");
						$("#price_patient_list_but").addClass("but-re-active");
						resizeBar()			
					},
					error : function() {
						alert("请求出错");
					}
		});
} 

/* 确认 收费  */
function updatePatientPrice(ids){
	var id = ids;
	$.ajax({
		type : 'get',
url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatientPrice/toll',
data : "ssid=${sicmedUserBean.ssid}&ids="+id,
		cache : false,
		dataType : 'json',
		success : function(data) {
			 	$("#total_price").html("");
	            $("#refund_price").html("");
	            $("#input_price").val("");
					console.log(data);
					if(data.error == 0){
						bootbox.alert({
							buttons: {  
					               ok: {  
					                    label: '确定',  
					                    className: 'btn-primary'  
					                }  
					            },   
						    message: "收费成功",
						    size: 'small',
						    callback: function(){
						    	var patientId = $("#toll_patientId_h").val();
						    	getYesByPatient(patientId)
						    }
					           
						})
					}
				},
		error : function() {
					alert("请求出错");
				}
		});
}


/* 根据患者 ID获取 退费 信息  */
function getRefundByPatient(patientId){
	$.ajax({
		type : 'get',
url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatientPrice/getYesByPatient',
data : "ssid=${sicmedUserBean.ssid}&isPay=1&patientId="+patientId,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					$("#refund_patient_search").hide();
					$("#patient_refund_but").removeAttr("disabled"); 
					$.each(data,function(key, value) {
						if(data.error == 1){
							$("#tab_patient_refund_unit").children().remove();
						}
						if (key == "sicmedRegisteredBean"){
							$("#refund_patientId_h").val(value.sicmedPatientBean.id);
							$("#patientNumber_refund").html(value.sicmedPatientBean.patientNumber);
							$("#patientBranch_refund").html(value.sicmedBranchBean.branchName);
							
							if(value.sicmedDoctorBean){
								$("#patientDoctor_refund").html(value.sicmedDoctorBean.userName);
							}
							
							$("#patientRegistered_refund").html(value.sicmedRegisteredTypeBean.typeName);
							$("#patientName_refund").html(value.sicmedPatientBean.patientName);
							$("#patientAge_refund").html(value.sicmedPatientBean.patientAge);
							$("#patientSex_refund").html(value.sicmedPatientBean.patientSex);
							
						}
						if (key == "sicmedPatientUnitPriceBeans") {
							$("#tab_patient_refund_unit").children().remove();
							$("#tab_patient_refund_unit").append("<tr style='height:44px;color:#fff;background-color:#05b3d9;'>"
							+"<td class='pp_td_hed_bg' align='center' style='border-radius:6px 0px 0px 0px;'>类别</td>"
							+"<td class='pp_td_hed_bg' align='center'>名称</td>"
							+"<td class='pp_td_hed_bg' align='center'>数量</td>"
							+"<td class='pp_td_hed_bg' align='center'>价格</td>"
							+"<td class='pp_td_hed_bg' align='center' style='border-radius:0px 6px 0px 0px;'>小计</td>"
							+"</tr>");
							var checkNo = 0;
							var inspectNo = 0;
							var cureNo = 0;
							var medicalNo = 0;
							$.each(value,function(key2,value2) {
								if(value2.sicmedTwxrayCheckBean!=undefined){
									if(checkNo==0){
									$("#tab_patient_refund_unit").append("<tr style='height:44px;'>"
											+"<td rowspan="+data.checkNo+" class='pp_td_bg pp_td_1' align='center'><input type='checkbox' id='refund_check_checkbox'  onclick='getCheckedRefund(this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;检查</td>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value2.checkPrice+" name='refund_check_checkbox' class='refund_check_checkbox' id="+value2.priceId+"  onclick='getCheckedRefunds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value2.sicmedTwxrayCheckBean.checkName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value2.checkPrice+"</td>"
											+"<td rowspan="+data.checkNo+" class='pp_td_bg pp_td_5'>¥"+data.totalCheckPrice+"</td>"
											+"</tr>");
									}else{
									$("#tab_patient_refund_unit").append("<tr style='height:44px;'>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value2.checkPrice+" name='refund_check_checkbox' class='refund_check_checkbox' id="+value2.priceId+"  onclick='getCheckedRefunds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value2.sicmedTwxrayCheckBean.checkName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value2.checkPrice+"</td>"
											+"</tr>");
									}
									checkNo = checkNo+1;
								}
							});
							$.each(value,function(key3,value3) {
								if(value3.sicmedInspectBean!=undefined){
									if(inspectNo==0){
									$("#tab_patient_refund_unit").append("<tr style='height:44px;'>"
											+"<td rowspan="+data.inspectNo+" class='pp_td_bg pp_td_1' align='center'><input type='checkbox' id='refund_inspect_checkbox'  onclick='getCheckedRefund(this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;检验</td>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value3.inspectPrice+" name='refund_inspect_checkbox' class='refund_inspect_checkbox' id="+value3.priceId+"  onclick='getCheckedRefunds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value3.sicmedInspectBean.inspectName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value3.inspectPrice+"</td>"
											+"<td rowspan="+data.inspectNo+" class='pp_td_bg pp_td_5'>¥"+data.totalInspectPrice+"</td>"
											+"</tr>");
									}else{
									$("#tab_patient_refund_unit").append("<tr style='height:44px;'>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value3.inspectPrice+" name='refund_inspect_checkbox' class='refund_inspect_checkbox' id="+value3.priceId+"  onclick='getCheckedRefunds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value3.sicmedInspectBean.inspectName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value3.inspectPrice+"</td>"
											+"</tr>");
									}
									inspectNo = inspectNo+1;
								}
							});
							$.each(value,function(key4,value4) {
								if(value4.sicmedCureCheckBean!=undefined){
									if(cureNo==0){
									$("#tab_patient_refund_unit").append("<tr style='height:44px;'>"
											+"<td rowspan="+data.cureNo+" class='pp_td_bg pp_td_1' align='center'><input type='checkbox' id='refund_cure_checkbox'  onclick='getCheckedRefund(this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;治疗</td>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value4.curePrice+" name='refund_cure_checkbox'  class='refund_cure_checkbox' id="+value4.priceId+" onclick='getCheckedRefunds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value4.sicmedCureCheckBean.cureName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value4.curePrice+"</td>"
											+"<td rowspan="+data.cureNo+" class='pp_td_bg pp_td_5'>¥"+data.totalCurePrice+"</td>"
											+"</tr>");
									}else{
									$("#tab_patient_refund_unit").append("<tr style='height:44px;'>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value4.curePrice+" name='refund_cure_checkbox' class='refund_cure_checkbox' id="+value4.priceId+" onclick='getCheckedRefunds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value4.sicmedCureCheckBean.cureName+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value4.curePrice+"</td>"
											+"</tr>");
									}
									cureNo = cureNo+1;
								}
							});
							$.each(value,function(key5,value5) {
								if(value5.sicmedMedicalBean!=undefined){
									if(medicalNo==0){
									$("#tab_patient_refund_unit").append("<tr style='height:44px;'>"
											+"<td rowspan="+data.medicalNo+" class='pp_td_bg pp_td_1' align='center'><input type='checkbox' id='refund_medical_checkbox' onclick='getCheckedRefund(this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;药品</td>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value5.medicalPrice+" name='refund_medical_checkbox' class='refund_medical_checkbox' id="+value5.priceId+" onclick='getCheckedRefunds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value5.sicmedMedicalBean.medicalNameChina+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value5.medicalPrice+"</td>"
											+"<td rowspan="+data.medicalNo+" class='pp_td_bg pp_td_5'>¥"+data.totalMedicalPrice+"</td>"
											+"</tr>");
									}else{
									$("#tab_patient_refund_unit").append("<tr style='height:44px;'>"
											+"<td class='pp_td_bg pp_td_2'><input type='checkbox' alt="+value5.medicalPrice+" name='refund_medical_checkbox' class='refund_medical_checkbox' id="+value5.priceId+" onclick='getCheckedRefunds(this.name,this.id)'>&nbsp;&nbsp;&nbsp;&nbsp;"+value5.sicmedMedicalBean.medicalNameChina+"</td>"
											+"<td class='pp_td_bg pp_td_3'>"+1+"</td>"
											+"<td class='pp_td_bg pp_td_3'>¥"+value5.medicalPrice+"</td>"
											+"</tr>");
									}
									medicalNo = medicalNo+1;
								}
							});
						}
					});
						$("#refund_patient_view").hide();
						$("#refund_price_view").show();
						$("#patient_refund_but").removeClass("but-re-active");
						$("#patient_refund_but").addClass("but-active");
						$("#refund_patient_list_but").removeClass("but-active");
						$("#refund_patient_list_but").addClass("but-re-active");
						resizeBar()
					},
					error : function() {
						alert("请求出错");
					}
		});
} 

/* 确认 退费  */
function deletePatientPrice(ids){
	var id = ids;
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatientPrice/refund',
		data : "ssid=${sicmedUserBean.ssid}&ids="+id,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					
					if(data.error == 0){
						bootbox.alert({
							buttons: {  
					               ok: {  
					                    label: '确定',  
					                    className: 'btn-primary'  
					                }  
					            },   
						    message: "退费成功",
						    size: 'small',
						    callback : function(){
						    	var patientId = $("#refund_patientId_h").val();
								getRefundByPatient(patientId);
						    }
						})
					}
				},
		error : function() {
					alert("请求出错");
				}
		});
}


function getHistory(isPay,beginDate,endDate){
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatientPrice/pc/getHistory',
		data : "ssid=${sicmedUserBean.ssid}&isPay="+isPay+"&beginDate="+beginDate+"&endDate="+endDate,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					$("#tab_patient_find").children().remove();
					$("#total_patient").val("0");
					$("#total_price_his").val("0");
					if(data.error == "1"){
						$("#tab_patient_find").append("<tr style='height:44px;'>"
								+"<td align='center'>姓名</td>"
								+"<td>性别</td>"
								+"<td>年龄</td>"
								+"<td>日期</td>"
								+"<td>收/退费金额</td>"
								+"</tr>");
					}
					$.each(data,function(name, value) {
						if (name == "historyRecordBeans") {
							$("#tab_patient_find").append("<tr style='height:44px;'>"
							+"<td align='center'>姓名</td>"
							+"<td>性别</td>"
							+"<td>年龄</td>"
							+"<td>日期</td>"
							+"<td>收/退费金额</td>"
							+"</tr>");
							
							
							$("#total_patient").val(value.length);
							$("#total_price_his").val(data.totalPrice);
							$.each(value,function(name2,value2) {
								var a = name2
								if(a%2==0){
								$("#tab_patient_find").append("<tr class='tab_refund_patient_tr_1'>"
										+"<td align='center'>"+value2.sicmedPatientName+"</td>"
										+"<td>"+value2.sicmedPatientSex+"</td>"
										+"<td>"+value2.sicmedPatientAge+"</td>"
										+"<td>"+value2.updateDate+"</td>"
										+"<td>"+value2.unitPrice+"</td>"
										+"</tr>");
								}else{
								$("#tab_patient_find").append("<tr class='tab_refund_patient_tr_2'>"
										+"<td align='center'>"+value2.sicmedPatientName+"</td>"
										+"<td>"+value2.sicmedPatientSex+"</td>"
										+"<td>"+value2.sicmedPatientAge+"</td>"
										+"<td>"+value2.updateDate+"</td>"
										+"<td>"+value2.unitPrice+"</td>"
										+"</tr>");
								}
							
							});
						}
					});
					resizeBar();
					},
					error : function() {
						alert("请求出错");
					}
		});
}

$(document).ready(function(){
	var w_width = $(window).width();
	if(w_width<=1024){
		
	$("#price_left_bar").css("width","14%")
	$("#toll_view").css("width","82.9%")	
	$("#refund_view").css("width","82.9%")
	$("#find_view").css("width","82.9%")
	$("#toll_view").css("margin-left","3%")	
	$("#refund_view").css("margin-left","3%")
	$("#find_view").css("margin-left","3%")
	
	}
})
function resizeBar(){
	$("#price_left_bar").css("height",70)
	var height1 = $(window).height();
	var height = $("#price_body").height();
	if(height<height1){
		
		$("#price_left_bar").css("height",height1-80)
	}else{
		$("#price_left_bar").css("height",height)
	}
	
}

$(document).ready(function(){
	 setInterval(function() {
		    var now = (new Date()).toLocaleString();
		    $('#current-time').text(now);
		}, 1000); 
})

</script>
</body>
</html>