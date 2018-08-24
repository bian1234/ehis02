<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>挂号窗口</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">
<!-- <link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" /> -->
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.css" type="text/css" rel="stylesheet" />
<!-- <link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" /> -->

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


/* 通用字体样式——微软雅黑 */	
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
#tab_del_registered_patient tr{
	line-height:44px;
}
#tab_del_registered_patient tr td{
	border:none;
	font-family: Microsoft YaHei;
}
.tab_del_registered_patient_tr_1{
	height:44px;
	background:#ffffff;
}
.tab_del_registered_patient_tr_2{
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
font-size:16px;
color:#ffffff;
}

.registered_but_1{
 width: 100%;
 height:62px;
 float: right;
 background-color: #efefef;
 font-size:16px;
 border: 0px;
 text-align: center;
}

.registered_but_2{
	width: 100%;
	height:62px; 
	float: right;
	background-color: #fff;
	text-align: center;
	font-size:16px;
	letter-spacing:0px;
}

.del_registered_but_1{
 font-size:16px;
 width: 100%;
 height:62px;
 float: right;
 background-color: #efefef;
 border: 0px;
 text-align: center;
 font-size:16px;
}

.del_registered_but_2{
	width: 100%;
	height:62px; 
	float: right;
	background-color: #fff;
	text-align: center;
	font-size:16px;
	letter-spacing:0px;
}

.up_registered_but_1{
 font-size:16px;
 width: 100%;
 height:62px;
 float: right;
 background-color: #efefef;
 border: 0px;
 text-align: center;
}

.up_registered_but_2{
	width: 100%;
	height:62px; 
	float: right;
	background-color: #fff;
	text-align: center;
	font-size:16px;
	letter-spacing:0px;
}

.find_registered_but_1{
	font-size:16px;
	width: 100%;height:62px;
	float: right;
	background-color: #efefef;
	border: 0px;
	text-align: center;
}

.find_registered_but_2{
	width: 100%;
	height:62px; 
	float: right;
	background-color: #fff;
	text-align: center;
	font-size:16px;
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

.registered_his_but1{
background:#3cc5de;
border-radius:6px;
width:93px;
height:28px;
font-size:14px;
color:#ffffff;
}

.registered_his_but2{
background:#ffffff;
border-radius:6px;
border:1px solid #efefef;
width:93px;
height:28px;
font-size:14px;
color:#bdbdbd;
}

.del_registered_his_but1{
background:#3cc5de;
border-radius:6px;
width:93px;
height:28px;
font-size:14px;
color:#ffffff;
}

.del_registered_his_but2{
background:#ffffff;
border-radius:6px;
border:1px solid #efefef;
width:93px;
height:28px;
font-size:14px;
color:#bdbdbd;
}

.up_registered_his_but1{
background:#3cc5de;
border-radius:6px;
width:93px;
height:28px;
font-size:14px;
color:#ffffff;
}

.up_registered_his_but2{
background:#ffffff;
border-radius:6px;
border:1px solid #efefef;
width:93px;
height:28px;
font-size:14px;
color:#bdbdbd;
}

.registered_form_row1{
margin-top: 40px;
}
.registered_form_row2{
margin-top: 22px;
}

.registered_form_lable1{
font-family:Microsoft YaHei;
font-size:14px;
color:#05b3d9;
letter-spacing:28px;
text-align:right;
}

.registered_form_lable2{
font-family:Microsoft YaHei;
font-size:14px;
color:#bdbdbd;
letter-spacing:0px;
text-align:right;
}

.registered_form_input1{
background:#ffffff;
border:1px solid #bbdefb;
border-radius:6px;
width:178px;
height:26px;
font-family:Microsoft YaHei;
font-size:14px;
color:#757575;
letter-spacing:0px;
}

.registered_form_input2{
background:#ffffff;
border:1px solid #efefef;
border-radius:6px;
width:178px;
height:26px;

font-family:Microsoft YaHei;
font-size:14px;
color:#757575;
letter-spacing:0px;
}

.registered_form_input3{
background:#ffffff;
border:1px solid #efefef;
border-radius:6px;
width:178px;
height:26px;

font-family:Microsoft YaHei;
font-size:14px;
color:#ffc300;
letter-spacing:0px;
}
.up_registered_form_input2{
background:#ffffff;
border:1px solid #efefef;
border-radius:6px;
width:178px;
height:26px;

font-family:Microsoft YaHei;
font-size:14px;
color:#757575;
letter-spacing:0px;
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
       /*  background:url ("/jeesite/static/Pc/img/setect_down.png") no-repeat; */
        
}

.dateInput{
background:#ffffff;
border:1px solid #efefef;
border-radius:6px;
width:152px;
height:26px;
}

.tab_refund_patient_tr_1{
	height:44px;
	background:#ffffff;
	border:0px;
}
.tab_refund_patient_tr_2{
border:0px;
	height:44px;
	background:#efefef;
}

.table_his{
border-top-left-radius: 10px; 
border-top-right-radius: 10px; 
border-bottom-left-radius: 10px; 
border-bottom-right-radius: 10px;
}

/* 导航 */
.new-nav {
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
</style>
</head>
<body>
<div>
	<%-- <div style="width: 100%;height: 80px;background-color: #39A0ED;">
		<div style="width: 10%;height: auto;float: left;text-align: center;">
			<img class="sicmed" alt="sicmed" src="/jeesite/static/Pc/img/sicmed.png">
		</div>
		<div style="width: 88%;height: auto;float: left;">
			<label style="margin-left: 10px;margin-top: 26px;font-family:Microsoft YaHei;font-size:18px;font-weight:500;color:#ffffff;letter-spacing:0px;text-align:left;">挂号窗口</label>
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
            <p class="navbar-text" style="color: #fff;font-size: 18px;margin-top: 27px;margin-left:2%;font-weight:500;">挂号窗口</p>
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
    
	<div id="registered_body" style="width: 100%;height:auto;float: left;">
<!-- 左侧导航栏 -->	
		<div id="registered_left_bar" style="width: 11%;height:100%;float: left; background-color: #efefef;color:#124256;font-family:Microsoft YaHei;">
		<!-- 挂号按钮 -->
			<div style="background-color: #ffffff;margin-top: 40px;width:100%;height: auto;">
				<button id="registered_but" class="registered_but_2">
					<!-- <img src="/jeesite/static/Pc/img/registered2.png"> -->
					<i class="iconfont guahao">&#xe60c;</i>
					<span style="margin-left: 10%;font-family:Microsoft YaHei;">挂&nbsp;号</span>
				</button>
			</div>
			<!-- <div id="registered_but_line" style="float: left;border:1px solid #657d91;height:0px; width: 80%;margin-left: 10%;"></div> -->
		<!-- 退号按钮 -->
			<div style="background-color: #ffffff;width:100%;height: auto;">
				<button id="del_registered_but" class="del_registered_but_1">
					<!-- <img src="/jeesite/static/Pc/img/del_registered1.png"> -->
					<i class="iconfont tuihao">&#xe609;</i>
					<span style="margin-left: 10%;font-family:Microsoft YaHei;">退&nbsp;号</span>
				</button>
			</div>
			<!-- <div id="del_registered_but_line" style="float: left;border:1px solid #657d91;height:0px; width: 80%;margin-left: 10%;"></div> -->
		<!-- 改号按钮 -->
			<div style="background-color: #ffffff;width:100%;height: auto;">
				<button id="up_registered_but" class="up_registered_but_1">
					<!-- <img src="/jeesite/static/Pc/img/up_registered1.png"> -->
					<i class="iconfont gaihao">&#xe602;</i>
					<span style="margin-left: 10%;font-family:Microsoft YaHei;">改&nbsp;号</span>
				</button>
			</div>
			<!-- <div id="up_registered_but_line" style="float: left;border:1px solid #657d91;height:0px; width: 80%;margin-left: 10%;"></div> -->
		<!-- 查询按钮 -->
			<div style="background-color: #ffffff;width:100%;height: auto;">
				<button id="find_registered_but" class="find_registered_but_1">
					<!-- <img src="/jeesite/static/Pc/img/find_registered1.png"> -->
					<i class="iconfont chaxun">&#xe601;</i>
					<span style="margin-left: 10%;font-family:Microsoft YaHei;">查&nbsp;询</span>
				</button>
			</div>
			<!-- <div id="find_registered_but_line" style="float: left;border:1px solid #657d91;height:0px; width: 80%;margin-left: 10%;"></div> -->
		</div>
<!-- 挂号 -->		
		<div id="registered_view" style="width: 69%;height: 100%;float: left; margin-left: 6%;">
			<div style="margin-top: 56px;color: #757575;font-family:Microsoft YaHei;font-size:14px;letter-spacing:0px;">
				<span>收费员：</span><span>${sicmedUserBean.userName}</span>
			</div>
			<div style="margin-top: 18px;border:1px solid #efefef;border-radius:6px;height:406px;">
				<div style="float: left;margin-left: 14%;">
					<form id="registered_form1">
						<div class="registered_form_row1">
							<label class="registered_form_lable1">姓名</label>
							<input id="patientName_id" name="patientName" type="text" class="registered_form_input1" style="padding-left: 20px;"><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable1">性别</label>
							<input name="patientSex" value="男" id="registered_sex_boy" type="checkbox" checked="checked" style="margin-left: 20px;margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;&nbsp;男
							<input name="patientSex" value="女" id="registered_sex_girle" type="checkbox" style="margin-left: 30px;margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;&nbsp;女<br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable1" style="letter-spacing: 0px;">挂号科室</label>
							<select name="branchId" id="registered_branch_list" class="registered_form_input1" style="margin-left: 28px; padding-left: 20px;">
							</select><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable1" style="letter-spacing: 0px;">挂号类型</label>
							<select name="registeredTypeId" id="registered_type_list" class="registered_form_input1"  style="margin-left: 28px; padding-left: 20px;"></select><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable2" style="letter-spacing: 5.9px;">挂号费</label>
							<input id="registered_registeredFee" readonly="readonly" type="text" class="registered_form_input2"  style="margin-left: 24px; padding-left: 26px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable2" style="letter-spacing: 5.9px;">诊疗费</label>
							<input id="registered_clinicsFee" readonly="readonly" type="text" class="registered_form_input2"  style="margin-left: 24px; padding-left: 26px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable2">实收金额</label>
							<input id="registered_input_price" type="text" class="registered_form_input2"  style="margin-left: 28px; padding-left: 26px;"><br>
						</div>
					</form>
				</div>
				<div style="float: left;margin-left: 10%;">
					<form id="registered_form2">
						<div class="registered_form_row1">
							<label class="registered_form_lable1">年龄</label>
							<input id="patientAge" name="patientAge" type="number" class="registered_form_input1" style="width: 114px; padding-left: 20px;" value="0">
							<select class="registered_form_input1" style="width: 60px">
								<option value="1">岁</option>  
   								<option value="2">月</option>
   								<option value="2">周</option>
   								<option value="2">日</option>      
							</select><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable2">身份证号</label>
							<input id="patientCard_id" name="patientCard" type="text" class="registered_form_input2"  style="margin-left: 28px; padding-left: 20px;"><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable2">挂号医生</label>
							<select name="doctorId" id="registered_doctor_list" class="registered_form_input2"  style="margin-left: 28px; padding-left: 20px;">
							</select><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable2">付费类型</label>
							<select class="registered_form_input2"  style="margin-left: 28px; padding-left: 20px;">
							<option>自费</option>
							</select><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable2" style="letter-spacing: 5.9px;">工本费</label>
							<input id="registered_materialFee" readonly="readonly" type="text" class="registered_form_input2"  style="margin-left: 24px; padding-left: 26px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable2">费用小记</label>
							<input id="registered_totalPrice" readonly="readonly" type="text" class="registered_form_input2"  style="margin-left: 28px; padding-left: 26px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
						</div>
						<div class="registered_form_row2">
							<label class="registered_form_lable2" style="letter-spacing: 28px;">找零</label>
							<input id="registered_output_price" readonly="readonly" type="text" class="registered_form_input2" style=" padding-left: 26px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
						</div>
					</form>
				</div>
			</div>
			<div style="margin-top: 22px; text-align: right;">
				<span style="margin-right: 30px;font-family:Microsoft YaHei;font-size:14px;color:#05b3d9;letter-spacing:0px;">蓝色为必填</span>
				<input type="checkbox" checked="checked" style="margin-right: 14px;">
				<span style="font-family:Microsoft YaHei;font-size:14px;color:#757575;letter-spacing:0px;">打印挂号单</span>
			</div>
			<div style="margin-top: 42px;text-align: right;">
				<button id="registered_sure" class="but_save_print">保存</button>
				<br>
				<br>
			</div>
		</div>
<!-- 退号 -->
		<div id="del_registered_view" style="width: 69%;height: auto;float: left;display: none;margin-left: 6%;">
			<div style="margin-top: 38px;margin-bottom:20px;width: 100%;height: auto;">
				<button id="del_registered_patient_list_but" class="but-active" style="margin-right:10px;">患者列表</button>
				<button id="del_registered_delete_but" class="but-re-active">退号</button>
				<div id="del_registered_search" style="float: right;width:50%;">
					<button style="background:#3cc5de;border-radius:6px;width:12%;height:34px;float: right;border-top-left-radius:0px;border-bottom-left-radius:0px;color:#fff;">搜索</button>
					<input style="background:#ffffff;border:1px solid #ccc;border-radius:6px;width:50%;height:34px;padding:6px 12px;float: right;border-top-right-radius:0px;border-bottom-right-radius:0px;">
					<label style="font-size:14px;color:#757575;letter-spacing:0px;text-align:center;float: right;margin-top: 8px;margin-right: 2.8%">患者编号</label>
				</div>
				<div id="del_registered_create_user" style="float: right;width:50%;display: none;text-align: right;margin-top: 12px;">
					<span style="font-family:Microsoft YaHei;font-size:12px;color:#bdbdbd;">原操作员：</span><span id="del_registered_create_user_show" style="font-family:Microsoft YaHei;font-size:12px;color:#bdbdbd;"></span>
				</div>
			</div>
			<div id="del_registered_patient_view" style="width: 100%;">
				<!-- <table id="tab_del_registered_patient" style="width: 100%; margin-top: 27px;background-image: url('/jeesite/static/Pc/img/tab_round.png');-moz-background-size:100%; background-size:100%;" >
				</table> -->
				<table id="tab_del_registered_patient" style="width: 100%; margin-top: 27px;" >
				</table>
				<div class="row" id="page_del_registered_patient">
	               <div class="col-lg-12 col-sm-12 text-right">
		                 <nav>
							  <ul class="pagination ">
								    <li id="prevpage_backnumber_patientlist"><a href="#">上一页</a></li>
								    <li class="active" id="currentpage_backnumber_patientlist"><a href="">1</a></li>
								    <li id="nextpage_backnumber_patientlist"><a href="#">下一页</a></li>
							  </ul>
						</nav>
	               </div>
	            </div>
			</div>
			<div id="del_registered_delete_view" style="display: none;">
				<div style="margin-top: 18px;border:1px solid #efefef;border-radius:6px;height:466px;">
					<div style="margin-top:38px; width: 70%;margin-left: 15%;font-family:Microsoft YaHei;font-size:14px;color:#1976d2;letter-spacing:0px;">
						<label style="color: #05b3d9;">患者编号：</label><label id="del_registered_patientNumber" style="color: #05b3d9;"></label>
						<input type="hidden" id="del_registered_id_h">
					</div>
					<div style="width: 70%;margin-left: 15%">
						<div style="float: left;">
							<form id="del_registered_form1">
								<div class="registered_form_row1">
									<label class="registered_form_lable2" style="letter-spacing: 28px;">姓名</label>
									<input id="del_registered_patientName" readonly="readonly"  type="text" class="registered_form_input2" style="padding-left:20px; background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
								</div>
								<div class="registered_form_row2">
									<label class="registered_form_lable2" style="letter-spacing: 28px;">性别</label>
									<input id="del_registered_patientSex" readonly="readonly" type="text" class="registered_form_input2" style="padding-left:20px; background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
								</div>
								<div class="registered_form_row2">
									<label class="registered_form_lable2" style="letter-spacing: 0px;">挂号科室</label>
									<input id="del_registered_branch" readonly="readonly"  type="text" class="registered_form_input2" style="padding-left:20px; margin-left: 28px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
								</div>
								<div class="registered_form_row2">
									<label class="registered_form_lable2" style="letter-spacing: 0px;">挂号类型</label>
									<input id="del_registered_type" readonly="readonly"  type="text" class="registered_form_input2" style="padding-left:20px; margin-left: 28px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
									</div>
								<div class="registered_form_row2">
									<label class="registered_form_lable2" style="letter-spacing: 5.9px;">诊疗费</label>
									<input id="del_registered_clinicsFee" readonly="readonly" type="text" class="registered_form_input2"  style="padding-left:26px; margin-left: 24px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
								</div>
							</form>
						</div>
						<div style="float: right;text-align: right;">
							<form id="del_registered_form2">
								<div class="registered_form_row1">
									<label class="registered_form_lable2" style="letter-spacing: 28px;">年龄</label>
									<input id="del_registered_patientAge" readonly="readonly" name="patientAge" type="text" class="registered_form_input2" style="padding-left:20px; background: #EFEFEF;border: 1px solid #bdbdbd;">
								</div>
								<div class="registered_form_row2">
									<label class="registered_form_lable2">身份证号</label>
									<input id="del_registered_patientCard" readonly="readonly" name="patientCard" type="text" class="registered_form_input2"  style="padding-left:20px; margin-left: 28px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
								</div>
								<div class="registered_form_row2">
									<label class="registered_form_lable2">挂号医生</label>
									<input id="del_registered_doctor" readonly="readonly" name="patientName" type="text" class="registered_form_input2" style="padding-left:20px; margin-left: 28px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
								</div>
								<div class="registered_form_row2">
									<label class="registered_form_lable2">付费类型</label>
									<input value="自费(应急)" readonly="readonly" name="patientName" type="text" class="registered_form_input2" style="padding-left:20px; margin-left: 28px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
								</div>
							</form>
						</div>
					</div>
					<hr style="clear: both;width: 70%;margin-left: 15%;margin-top: 280px;">
					<div style="clear: both;width: 70%;margin-left: 15%;margin-top: 20px;">
						<div class="registered_form_row2" style="float: left;">
							<label class="registered_form_lable2">费用小记</label>
							<input id="del_registered_total_price" readonly="readonly" id="registered_totalPrice" readonly="readonly" type="text" class="registered_form_input2"  style="padding-left:26px; margin-left: 28px;background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
							<input id="oldTotalPrice" type="hidden">	
						</div>
						<div class="registered_form_row2" style="float: right;">
							<label class="registered_form_lable2">实收金额</label>
							<input id="del_registered_input_price" type="text" class="registered_form_input2"  style="padding-left:26px; margin-left: 28px;"><br>
						</div>
					</div>
					<div style="clear: both;width: 70%;margin-left: 15%;margin-top: 20px;">
						<div class="registered_form_row2" style="float: right;">
							<label class="registered_form_lable2" style="letter-spacing: 28px;">找零</label>
							<input readonly="readonly" id="del_registered_output_price" readonly="readonly" type="text" class="registered_form_input2" style="padding-left:26px; background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
						</div>
					</div>
				</div>
				<div style="margin-top: 22px; text-align: right;">
					<input type="checkbox" checked="checked" style="margin-right: 14px;">
					<span style="font-family:Microsoft YaHei;font-size:14px;color:#757575;letter-spacing:0px;">打印退号凭证</span>
				</div>
				<div style="margin-top: 22px; text-align: right;">
					<div style="margin-top: 42px;text-align: right;">
						<button id="del_registered_sure" class="but_save_print">退号</button>
					</div>
				</div>
			</div>
		</div>
<!-- 改号 -->
		<div id="up_registered_view" style="width: 69%;height: auto;float: left;display: none;margin-left: 6%;">
			<div style="margin-top: 38px;margin-bottom:20px;width: 100%;height: auto;">
				<button id="up_registered_patient_list_but" class="but-active" style="margin-right:10px;">患者列表</button>
				<button id="up_registered_update_but" class="but-re-active">改号</button>
				<div id="up_registered_search" style="float: right;width:50%;">
					<button style="background:#3cc5de;border-radius:6px;width:12%;height:34px;float: right;color:#fff;border-top-left-radius:0px;border-bottom-left-radius:0px;">搜索</button>
					<input style="background:#ffffff;border:1px solid #ccc;border-radius:6px;width:50%;height:34px;padding:6px 12px;float: right;border-top-right-radius:0px;border-bottom-right-radius:0px;">
					<label style="font-size:14px;color:#757575;letter-spacing:0px;text-align:center;float: right;margin-top: 8px;margin-right: 2.8%">患者编号</label>
				</div>
				<div id="up_registered_create_user" style="float: right;width:50%;display: none;text-align: right;margin-top: 12px;">
					<span style="font-family:Microsoft YaHei;font-size:12px;color:#bdbdbd;">原操作员：</span><span id="up_registered_create_user_show" style="font-family:Microsoft YaHei;font-size:12px;color:#bdbdbd;"></span>
				</div>
			</div>
			<div id="up_registered_patient_view" style="width: 100%;">
				<!-- <table id="tab_up_registered_patient" style="width: 100%; margin-top: 27px;background-image: url('/jeesite/static/Pc/img/tab_round.png');-moz-background-size:100%; background-size:100%;" >
				</table> -->
				<table id="tab_up_registered_patient" style="width: 100%; margin-top: 27px;font-family:Microsoft YaHei;" >
				</table>
				<div class="row" id="page_up_registered_patient">
	               <div class="col-lg-12 col-sm-12 text-right">
		                 <nav>
							  <ul class="pagination ">
								    <li id="prevpage_changenumber_patientlist"><a href="#">上一页</a></li>
								    <li class="active" id="currentpage_changenumber_patientlist"><a href="">1</a></li>
								    <li id="nextpage_changenumber_patientlist"><a href="#">下一页</a></li>
							  </ul>
						</nav>
	               </div>
	            </div>
			</div>
			<div id="up_registered_update_view" style="display: none;">
				<div style="margin-top: 18px;border:1px solid #efefef;border-radius:6px;height:466px;">
					<div style="margin-top:38px; width: 70%;margin-left: 15%;font-family:Microsoft YaHei;font-size:14px;color:#1976d2;letter-spacing:0px;color:#05b3d9;">
						<label>患者编号：</label><label id="up_registered_patientNumber"></label>
					</div>	
					<div style="float: left;margin-left: 15%;">
						<form id="up_registered_form1">
							<input id="up_registered_id_h" name="registeredId" type="hidden">
							<input id="up_patient_id_h" name="id" type="hidden">
							<div class="registered_form_row1">
								<label class="registered_form_lable1">姓名</label>
								<input id="up_registered_patientName" name="patientName" type="text" class="registered_form_input1" style="padding-left:20px;"><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable1">性别</label>
								<input id="up_registered_registered_sex_boy" name="patientSex" value="男"  type="checkbox"  style="margin-left: 20px;margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;&nbsp;男
								<input id="up_registered_registered_sex_girle" name="patientSex" value="女" type="checkbox" style="margin-left: 30px;margin-bottom: 0px;">&nbsp;&nbsp;&nbsp;&nbsp;女<br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable1" style="letter-spacing: 0px;">挂号科室</label>
								<select id="up_registered_branch_list" name="branchId" class="registered_form_input1" style="margin-left: 28px;padding-left:20px;">
								</select><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable1" style="letter-spacing: 0px;">挂号类型</label>
								<select id="up_registered_type_list" name="registeredTypeId" class="registered_form_input1"  style="margin-left: 28px;padding-left:20px;"></select><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable2" style="letter-spacing: 5.9px;">挂号费</label>
								<input id="up_registered_registeredFee" readonly="readonly" type="text" class="registered_form_input2"  style="margin-left: 24px;padding-left:26px; background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable2" style="letter-spacing: 5.9px;">诊疗费</label>
								<input id="up_registered_clinicsFee" readonly="readonly" type="text" class="registered_form_input2"  style="margin-left: 24px;padding-left:26px; background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable2">实收金额</label>
								<input id="up_registered_input_price" type="text" class="registered_form_input2"  style="margin-left: 28px;padding-left:26px;"><br>
							</div>
						</form>
					</div>
					<div style="float: left;margin-left: 10%;">
						<form id="up_registered_form2">
							<div class="registered_form_row1">
								<label class="registered_form_lable1">年龄</label>
								<input id="up_registered_patientAge" name="patientAge" type="text" class="registered_form_input1" style="width: 115px;padding-left:20px;">
								<select class="registered_form_input1" style="width: 60px">
									<option value="1">岁</option>  
	   								<option value="2">月</option>
	   								<option value="2">周</option>
	   								<option value="2">日</option>      
								</select><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable2">身份证号</label>
								<input id="up_registered_patientCard" name="patientCard" type="text" class="registered_form_input2"  style="margin-left: 28px;padding-left:20px;"><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable2">挂号医生</label>
								<select id="up_registered_doctor_list" name="doctorId" class="registered_form_input2"  style="margin-left: 28px;padding-left:20px;">
								</select><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable2">付费类型</label>
								<select class="up_registered_form_input2"  style="margin-left: 28px;padding-left:26px;">
								<option>自费</option>
								</select><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable2" style="letter-spacing: 5.9px;">工本费</label>
								<input id="up_registered_materialFee" readonly="readonly" type="text" class="registered_form_input2"  style="margin-left: 24px;padding-left:26px; background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable2">费用差价</label>
								<input id="up_registered_totalPrice" readonly="readonly" type="text" class="registered_form_input2"  style="margin-left: 27px;padding-left:26px; background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
							</div>
							<div class="registered_form_row2">
								<label class="registered_form_lable2" style="letter-spacing: 28px;">找零</label>
								<input id="up_registered_output_price" readonly="readonly" type="text" class="registered_form_input2" style="padding-left:26px; background: #EFEFEF;border: 1px solid #bdbdbd;"><br>
							</div>
						</form>
					</div>
				</div>
				<div style="margin-top: 22px; text-align: right;">
					<span style="margin-right: 30px;font-family:Microsoft YaHei;font-size:14px;color:#05b3d9;letter-spacing:0px;">蓝色为必填</span>
					<input type="checkbox" checked="checked" style="margin-right: 14px;">
					<span style="font-family:Microsoft YaHei;font-size:14px;color:#757575;letter-spacing:0px;">打印挂号单</span>
				</div>
				<div style="margin-top: 42px;text-align: right;">
					<button id="up_registered_sure" class="but_save_print">保存</button>
				</div>
			</div>
		</div>		
<!-- 挂号改号退号记录 -->		
		<div id="find_history_view" style="width: 69%;height: auto;float: left;display: none;margin-left: 6%;">
			<div id="find_patient_view">
				<div style="margin-top: 40px;background:#ffffff;border:1px solid #efefef;border-radius:6px;width:100%;height:135px;">
					<div style="width: 8%;height:48px; float: left;margin-top: 40px;text-align: center;">
						<span class="patient_info_head">筛选</span><br><br>
						<span class="patient_info_head">条件</span>
					</div>
					<label style="border-left:1px  solid #efefef;height:100%; float: left;"></label>
					<div style="width: 17%;float: left;margin-top: 16px;height: 62px;text-align: center;">
						<p class="patient_info_head" style="margin-bottom:10px;">
							<button id="registered_his" class="registered_his_but1">挂号记录</button>
						</p>
						<p class="patient_info_head" style="margin-bottom:10px;">
							<button id="del_registered_his" class="del_registered_his_but2">退号记录</button>
						</p>
						<p class="patient_info_head">
							<button id="up_registered_his" class="up_registered_his_but2">改号记录</button>
						</p>
						<input id="isPay_toll_refund_h" type="hidden" value="0">
					</div>
					<label style="border-left:1px solid #efefef;height:100%; float: left;"></label>
					<div style=" text-align: center;float: left;width:74%;margin-top: 31px; ">
						<div style="width: 46%;float: left;height: 74px;text-align: right;margin-right: 0px;">
							<span class="patient_info_head" style="font-family:STHeitiSC-Medium;font-size:14px;color:#bdbdbd;letter-spacing:0px;margin-top: 8px;">开始日期:</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input readonly="readonly" placeholder="请选择" style="padding-left: 8px; "  class="datainp dateInput" id="beginDate" type="text" onClick="jeDate({dateCell:'#beginDate',isTime:true,maxDate: jeDate.now(0),format:'YYYY-MM-DD hh:mm:ss'})"><br><br>						
							<span class="patient_info_head" style="font-family:STHeitiSC-Medium;font-size:14px;color:#bdbdbd;letter-spacing:0px;margin-top: 30px;">结束日期:</span>&nbsp;&nbsp;&nbsp;&nbsp;
							<input readonly="readonly" placeholder="请选择" style="margin-top:0px;padding-left: 8px; " class="datainp dateInput" id="endDate" type="text" onClick="jeDate({dateCell:'#endDate',isTime:true,maxDate: jeDate.now(0),format:'YYYY-MM-DD hh:mm:ss'})">
						</div>	
						<div style="width: 20%;float: left;height: 74px;text-align: center;">
							<span class="patient_info_head"><button id="history_registered" style="background:#ffffff;border:1px solid #124256;border-radius:6px;width:78px;height:70px;font-family:STHeitiSC-Medium;font-size:14px;color:#212121;line-height:24px;">开始<br>统计</button></span>
						</div>
						<div style="width: 34%;float: left;height: 74px;text-align: left;margin-left: 0px;">
							<span class="patient_info_head" style="margin-top:8px; font-family:STHeitiSC-Medium;font-size:14px;color:#bdbdbd;letter-spacing:0px;">人数:</span>
							<input id="total_patient" class="" style="background:#ffffff;border:1px solid #efefef;border-radius:6px;width:102px;height: 26px;text-align: center;"/>
							<span class="patient_info_head" >人</span><br><br>
							<span class="patient_info_head" style="margin-top:30px; font-family:STHeitiSC-Medium;font-size:14px;color:#bdbdbd;letter-spacing:0px;">金额:</span>
							<input id="total_price_his" class="" style="background:#ffffff;border:1px solid #efefef;border-radius:6px;width:102px;height: 26px;text-align: center;"/>
							<span class="patient_info_head" >元</span><br><br>
						</div>
					</div>
				</div>
				<table class="table_his" id="tab_patient_find"  style="border:1px solid #efefef;width: 100%; margin-top: 27px;border-radius: 180px 180px 0px 0px;" >
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
    //jeDate.skin('green');
	/* jeDate({
		dateCell:"#indate",//isinitVal:true,
		format:"YYYY-MM",
		isTime:false, //isClear:false,
		minDate:"2015-10-19 00:00:00",
		maxDate:"2016-11-8 00:00:00"
	})
    jeDate({
		dateCell:"#dateinfo",
		format:"YYYY年MM月DD日 hh:mm:ss",
		isinitVal:true,
		isTime:true, //isClear:false,
		minDate:"2014-09-19 00:00:00",
		okfun:function(val){alert(val)}
	}) */
</script>
<script type="text/javascript">
$(document).ready(function(){
	getRegisteredBranchList();
})


var backPageNo = 1;
var changePageNo = 1;
/* 点击事件 */
$(function(){
	/* 挂号视图显示 */
	$("#signOut").click(function(){
		signOut();
	})
	
	
	$("#registered_but").click(function(){
		
		$("#registered_but").removeClass("registered_but_1");
		$("#registered_but").addClass("registered_but_2");
		$("#del_registered_but").addClass("del_registered_but_1");
		$("#del_registered_but").removeClass("del_registered_but_2");
		$("#up_registered_but").addClass("up_registered_but_1");
		$("#up_registered_but").removeClass("up_registered_but_2");
		$("#find_registered_but").addClass("find_registered_but_1");
		$("#find_registered_but").removeClass("find_registered_but_2");
		
		$("#registered_but img").attr("src","/jeesite/static/Pc/img/registered2.png");
		$("#del_registered_but img").attr("src","/jeesite/static/Pc/img/del_registered1.png");
		$("#up_registered_but img").attr("src","/jeesite/static/Pc/img/up_registered1.png");
		$("#find_registered_but img").attr("src","/jeesite/static/Pc/img/find_registered1.png");
		
		getRegisteredBranchList(); 
		$("#del_registered_view").hide();
		$("#up_registered_view").hide();
		$("#find_history_view").hide();
		$("#registered_but_line").hide();
		$("#del_registered_but_line").show();
		$("#up_registered_but_line").show();
		$("#find_registered_but_line").show();
		$("#registered_view").show();
	})
	$("#price_patient_list_but").click(function(){
		$("#toll_price_view").hide();
		$("#tab_price_patient").show();
		$("#price_patient_list_but").removeClass("but-re-active");
		$("#price_patient_list_but").addClass("but-active");
		$("#patient_price_but").removeClass("but-active");
		$("#patient_price_but").addClass("but-re-active");
		resizeBar()
	})
	$("#patient_price_but").click(function(){
		$("#tab_price_patient").hide();
		$("#toll_price_view").show();
		$("#patient_price_but").removeClass("but-re-active");
		$("#patient_price_but").addClass("but-active");
		$("#price_patient_list_but").removeClass("but-active");
		$("#price_patient_list_but").addClass("but-re-active");
		resizeBar()
	})
	/* 退号 费视图显示 */
	$("#del_registered_but").click(function(){
		var del_registered_patientNumber =  $("#del_registered_patientNumber").html();
		if(del_registered_patientNumber = 'undefine' ){
			$("#del_registered_delete_but").attr({"disabled":"disabled"}); 
		}
		
		$("#del_registered_but").addClass("del_registered_but_2");
		$("#del_registered_but").removeClass("del_registered_but_1");
		
		$("#up_registered_but").addClass("up_registered_but_1");
		$("#up_registered_but").removeClass("up_registered_but_2");
		$("#registered_but").addClass("registered_but_1");
		$("#registered_but").removeClass("registered_but_2");
		$("#find_registered_but").addClass("find_registered_but_1");
		$("#find_registered_but").removeClass("find_registered_but_2");
		
		$("#del_registered_but img").attr("src","/jeesite/static/Pc/img/del_registered2.png");
		$("#registered_but img").attr("src","/jeesite/static/Pc/img/registered1.png");
		$("#up_registered_but img").attr("src","/jeesite/static/Pc/img/up_registered1.png");
		$("#find_registered_but img").attr("src","/jeesite/static/Pc/img/find_registered1.png");
		
		// 获取退号-患者列表
		findDeleteRegisteredPatientList(backPageNo); 
		
		
		$("#registered_view").hide();
		$("#up_registered_view").hide();
		$("#find_history_view").hide();
		$("#del_registered_but_line").hide();
		$("#registered_but_line").show();
		$("#up_registered_but_line").show();
		$("#find_registered_but_line").show();
		$("#del_registered_view").show();
	})
	$("#del_registered_patient_list_but").click(function(){
		
		$("#del_registered_create_user").hide();
		$("#del_registered_search").show();
		$("#del_registered_delete_view").hide();
		$("#del_registered_patient_view").show();
		
		$("#tab_del_registered_patient").show();
		$("#page_del_registered_patient").show();
		
		$("#del_registered_patient_list_but").removeClass("but-re-active");
		$("#del_registered_patient_list_but").addClass("but-active");
		$("#del_registered_delete_but").removeClass("but-active");
		$("#del_registered_delete_but").addClass("but-re-active");
		resizeBar()
	})
	$("#del_registered_delete_but").click(function(){
		$("#del_registered_search").hide();
		$("#del_registered_create_user").show();
		
		$("#tab_del_registered_patient").hide();
		$("#page_del_registered_patient").hide();
		
		$("#del_registered_delete_view").show();
		$("#del_registered_delete_but").removeClass("but-re-active");
		$("#del_registered_delete_but").addClass("but-active");
		$("#del_registered_patient_list_but").removeClass("but-active");
		$("#del_registered_patient_list_but").addClass("but-re-active");
		resizeBar()
	})
	
	/* 改号 费视图显示 */
	$("#up_registered_but").click(function(){
		var up_registered_patientNumber =  $("#up_registered_patientNumber").html();
		if(up_registered_patientNumber = 'undefine' ){
			$("#up_registered_update_but").attr({"disabled":"disabled"}); 
		}
		
		$("#up_registered_but").addClass("up_registered_but_2");
		$("#up_registered_but").removeClass("up_registered_but_1");
		$("#del_registered_but").addClass("del_registered_but_1");
		$("#del_registered_but").removeClass("del_registered_but_2");
		$("#registered_but").addClass("registered_but_1");
		$("#registered_but").removeClass("registered_but_2");
		$("#find_registered_but").addClass("find_registered_but_1");
		$("#find_registered_but").removeClass("find_registered_but_2");
		
		$("#up_registered_but img").attr("src","/jeesite/static/Pc/img/up_registered2.png");
		$("#registered_but img").attr("src","/jeesite/static/Pc/img/registered1.png");
		$("#del_registered_but img").attr("src","/jeesite/static/Pc/img/del_registered1.png");
		$("#find_registered_but img").attr("src","/jeesite/static/Pc/img/find_registered1.png");
		
		
		// 获取改号-患者列表
		findUpdateRegisteredPatientList(changePageNo); 
		
		
		$("#registered_view").hide();
		$("#find_history_view").hide();
		$("#del_registered_view").hide();
		$("#up_registered_but_line").hide();
		$("#del_registered_but_line").show();
		$("#registered_but_line").show();
		$("#find_registered_but_line").show();
		$("#up_registered_view").show();
	})
	$("#up_registered_patient_list_but").click(function(){
		$("#up_registered_search").show();
		$("#up_registered_create_user").hide();
		$("#up_registered_update_view").hide();
		$("#up_registered_patient_view").show();
		
		$("#tab_up_registered_patient").show();
		$("#page_up_registered_patient").show();
							
		$("#up_registered_patient_list_but").removeClass("but-re-active");
		$("#up_registered_patient_list_but").addClass("but-active");
		$("#up_registered_update_but").removeClass("but-active");
		$("#up_registered_update_but").addClass("but-re-active");
		resizeBar()
	})
	$("#up_registered_update_but").click(function(){
		$("#up_registered_search").hide();
		$("#up_registered_create_user").show();
		
		$("#tab_up_registered_patient").hide();
		$("#page_up_registered_patient").hide();
		
		$("#up_registered_update_view").show();
		$("#up_registered_update_but").removeClass("but-re-active");
		$("#up_registered_update_but").addClass("but-active");
		$("#up_registered_patient_list_but").removeClass("but-active");
		$("#up_registered_patient_list_but").addClass("but-re-active");
		resizeBar()
	})
	
	/* 历史记录视图显示 */
	$("#find_registered_but").click(function(){
		$("#del_registered_but").addClass("del_registered_but_1");
		$("#del_registered_but").removeClass("del_registered_but_2");
		$("#up_registered_but").addClass("up_registered_but_1");
		$("#up_registered_but").removeClass("up_registered_but_2");
		$("#registered_but").addClass("registered_but_1");
		$("#registered_but").removeClass("registered_but_2");
		$("#find_registered_but").addClass("find_registered_but_2");
		$("#find_registered_but").removeClass("find_registered_but_1");
		
		$("#registered_but img").attr("src","/jeesite/static/Pc/img/registered1.png");
		$("#del_registered_but img").attr("src","/jeesite/static/Pc/img/del_registered1.png");
		$("#up_registered_but img").attr("src","/jeesite/static/Pc/img/up_registered1.png");
		$("#find_registered_but img").attr("src","/jeesite/static/Pc/img/find_registered2.png");
		
		$("#registered_view").hide();
		$("#del_registered_view").hide();
		$("#up_registered_view").hide();
		$("#find_registered_but_line").hide();
		$("#del_registered_but_line").show();
		$("#up_registered_but_line").show();
		$("#registered_but_line").show();
		$("#find_history_view").show();
		resizeBar();
	})
							/* 挂号 点击事件  */
	/* 根据 挂号科室 获取  挂号类型 */
	$("#registered_branch_list").change(function(){
		var id = $(this).val();
		findRegisteredTypeByBranch(id);
	})
	$("#registered_type_list").change(function(){
		var id = $(this).val();
		getRegisteredTypeById(id);
	})
	$("#registered_sex_boy").click(function(){
		$("#registered_sex_girle").prop("checked",false);
		$("#registered_sex_boy").prop("checked",true);
		/* if($(this).is(":checked")){
			$("#registered_sex_girle").prop("checked",false);
		}else{
			$("#registered_sex_girle").prop("checked",true);
		} */
	})
	$("#registered_sex_girle").click(function(){
		$("#registered_sex_boy").prop("checked",false);
		$("#registered_sex_girle").prop("checked",true);
		/* if($(this).is(":checked")){
			$("#registered_sex_boy").prop("checked",false);
		}else{
			$("#registered_sex_boy").prop("checked",true);
		}; */
	})
	$("#registered_input_price").bind("input",function(){
		var input_price = $("#registered_input_price").val();
		var registered_totalPrice = $("#registered_totalPrice").val();
		var output_price = input_price - registered_totalPrice;
		$("#registered_output_price").val(output_price);
	})
	$("#registered_sure").click(function(){
		addRegistered();
	})
	
	$("#patientAge").on("blur",function(){
		var age = $(this).val(); 
		var myregexp = /^(((1|1\d|[1-9]))|1[0-4]\d|150|[1-9]\d|\d)$/;
		var match = myregexp.exec(age);
		if (match == null) {
			bootbox.alert({
			buttons: {  
					  ok: {  
						label: '确定',  
						className: 'btn-primary'  
						}  
					},  
				message: "请输入0 - 150之间的整数",
				size: 'small'
			})
		}
	})
	
						/* 退号点击事件 */
	$("#del_registered_sure").click(function(){
		deleteRegisteredById();
	})
	$("#del_registered_input_price").bind("input",function(){
		var del_registered_intput_price = $(this).val();
		var del_registered_total_price = $("#del_registered_total_price").val();
		var del_registered_output_price = del_registered_intput_price*1 + del_registered_total_price*1;
		$("#del_registered_output_price").val(del_registered_output_price);
	})
		
						/* 改号点击事件 */	
	/* 收费 总价 输入价格 找零 变更  */	
	$('#input_price').bind('input propertychange', function() {
		var total_price = $("#total_price").html();
		var input_price = $("#input_price").val();
		var refund_price = input_price - total_price;
		$("#refund_price").html(refund_price);
	})
	$("#up_registered_registered_sex_boy").click(function(){
		$("#up_registered_registered_sex_girle").prop("checked",false);
		$("#up_registered_registered_sex_boy").prop("checked",true);
		/* if($(this).is(":checked")){
			$("#up_registered_registered_sex_girle").prop("checked",false);
		}else{
			$("#up_registered_registered_sex_girle").prop("checked",true);
		} */
	})
	$("#up_registered_registered_sex_girle").click(function(){
		$("#up_registered_registered_sex_boy").prop("checked",false);
		$("#up_registered_registered_sex_girle").prop("checked",true);
		/* if($(this).is(":checked")){
			$("#up_registered_registered_sex_boy").prop("checked",false);
		}else{
			$("#up_registered_registered_sex_boy").prop("checked",true);
		}; */
	})
	$("#up_registered_branch_list").change(function(){
		findRegisteredTypeUpdate();
	})
	$("#up_registered_type_list").change(function(){
		getRegisteredTypeByIdUpdate();
		findRegisteredDoctorUpdate();
		var up_registered_intput_price = $(up_registered_input_price).val();
		var up_registered_totalPrice = $("#up_registered_totalPrice").val();
		var up_registered_output_price = up_registered_intput_price - up_registered_totalPrice;
		$("#up_registered_output_price").val(up_registered_output_price);
	})
	$("#up_registered_sure").click(function(){
		updateRegistered();
	})
		$("#up_registered_input_price").bind("input",function(){
		var up_registered_intput_price = $(up_registered_input_price).val();
		var up_registered_totalPrice = $("#up_registered_totalPrice").val();
		var up_registered_output_price = up_registered_intput_price - up_registered_totalPrice;
		$("#up_registered_output_price").val(up_registered_output_price);
	})
	
	/* 查询历史记录 */ 
	$('#history_registered').bind('click',function(){
		var isPay = $('#isPay_toll_refund_h').val();
		var beginDate = $('#beginDate').val();
		console.log(beginDate);
		var endDate = $('#endDate').val();
		if(isPay == 0){
			console.log(isPay);
			registeredHistory(beginDate,endDate);
		}else if(isPay == 1){
			console.log(isPay);
			delRegisteredHistory(beginDate,endDate);
		}else if(isPay == 2){
			console.log(isPay);
			upRegisteredHistory(beginDate,endDate);
		}
	})
	$('#registered_his').bind('click',function(){
		$('#registered_his').removeClass("registered_his_but2")
		$('#registered_his').addClass("registered_his_but1")
		$('#del_registered_his').removeClass("del_registered_his_but1")
		$('#del_registered_his').addClass("del_registered_his_but2")
		$('#up_registered_his').removeClass("up_registered_his_but1")
		$('#up_registered_his').addClass("up_registered_his_but2")
		$('#isPay_toll_refund_h').val(0);
	})
	$('#del_registered_his').bind('click',function(){
		$('#del_registered_his').removeClass("del_registered_his_but2")
		$('#del_registered_his').addClass("del_registered_his_but1")
		$('#registered_his').removeClass("registered_his_but1")
		$('#registered_his').addClass("registered_his_but2")
		$('#up_registered_his').removeClass("up_registered_his_but1")
		$('#up_registered_his').addClass("up_registered_his_but2")
		$('#isPay_toll_refund_h').val(1);
	})
	$('#up_registered_his').bind('click',function(){
		$('#up_registered_his').removeClass("up_registered_his_but2")
		$('#up_registered_his').addClass("up_registered_his_but1")
		$('#registered_his').removeClass("registered_his_but1")
		$('#registered_his').addClass("registered_his_but2")
		$('#del_registered_his').removeClass("del_registered_his_but1")
		$('#del_registered_his').addClass("del_registered_his_but2")
		$('#isPay_toll_refund_h').val(2);
	})
	
})

	/* AJAX请求 */
									/* 挂号模块 */	
 /* 获取可以挂号的科室列表 */ 
function getRegisteredBranchList(){
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedBranch/findAllRegisteredBranch',
		data : "ssid=${sicmedUserBean.ssid}",
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					$.each(data,function(name, value) {
						$("#registered_branch_list").children().remove();
						if (name == "sicmedBranchBeans") {
							$.each(value,function(name2,value2) {
								$("#registered_branch_list").append("<option value="+value2.id+">"+value2.branchName+"</option>");
							});
							var id = $("#registered_branch_list").val();
							findRegisteredTypeByBranch(id);
						}
					});
					resizeBar();
					},
					error : function() {
						alert("请求出错");
					}
		});
	}
/* 根据 挂号科室获取挂号类型  */
function findRegisteredTypeByBranch(branhId){
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegisteredType/findByBranch',
		data : "ssid=${sicmedUserBean.ssid}&branchId="+branhId,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					$.each(data,function(name, value) {
						$("#registered_type_list").children().remove();
						if (name == "sicmedRegisteredTypeBeans") {
							$.each(value,function(name2,value2) {
								$("#registered_type_list").append("<option value="+value2.id+">"+value2.typeName+"</option>");
							});
						}
					});
					var id = $("#registered_type_list").val();
					getRegisteredTypeById(id);
					},
					error : function() {
						alert("请求出错");
					}
		});
	}
/* 根据 挂号类型 获取挂号价格信息 科室下的医生信息 */
function getRegisteredTypeById(id){
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegisteredType/getById',
		data : "ssid=${sicmedUserBean.ssid}&id="+id,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					
					// 保存挂号类型id
					sicmedRegisteredTypeId = data.id;
					
					$.each(data,function(name, value) {
						//$("#registered_type_list").children().remove();
						var totalPrice = data.sicmedRegisteredPriceBean.registeredFee*1+data.sicmedRegisteredPriceBean.clinicsFee*1+data.sicmedRegisteredPriceBean.materialFee*1;
						$("#registered_registeredFee").val(data.sicmedRegisteredPriceBean.registeredFee);
						$("#registered_clinicsFee").val(data.sicmedRegisteredPriceBean.clinicsFee);
						$("#registered_materialFee").val(data.sicmedRegisteredPriceBean.materialFee);
						$("#registered_totalPrice").val(totalPrice);
					});
					findRegisteredDoctor(data.id);
				},
				error : function() {
					alert("请求出错");
				}
		});
	}
function findRegisteredDoctor(registeredTypeId){
	var branchId =  $("#registered_branch_list").val();
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedUser/findByRegisteredType',
		data : "ssid=${sicmedUserBean.ssid}&registeredTypeId="+registeredTypeId+"&branchId="+branchId,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					$("#registered_doctor_list").children().remove();
					$("#registered_doctor_list").append("<option value=''>"+"请选择"+"</option>");
					$.each(data,function(name, value) {
						if (name == "sicmedUserBeans") {
							$.each(value,function(name2,value2) {
								$("#registered_doctor_list").append("<option value="+value2.id+">"+value2.userName+"</option>");
							});
						}
					});
				},
				error : function() {
					alert("请求出错");
				}
		});
	}

/* 保存挂号信息  */
var sicmedRegisteredTypeId;
function addRegistered(){
	var str1 = $("#registered_form1").serialize();
	var str2 = $("#registered_form2").serialize();
	
	var str1obj = $("#registered_form1").serializeArray();
	var str2obj = $("#registered_form2").serializeArray();
	
	console.log(str1);
	console.log(str2);
	
	/* console.log(str1obj)
	console.log(str2obj) */
	
	// 姓名
	var registered_name;
	// 年龄
	var registered_age;
	
	$.each(str1obj,function(i,v){
		if(v.name == "patientName"){
			registered_name = v.value;
		}
	})
	$.each(str2obj,function(i,v){
		if(v.name == "patientAge"){
			registered_age = v.value;
		}
	})
	
	
	if(registered_name != "" && registered_age != "" && sicmedRegisteredTypeId != undefined){
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegistered/add',
			data : "ssid=${sicmedUserBean.ssid}&"+str1+"&"+str2,
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
								message: "挂号成功！",
								size: 'small'
							})
							$("#patientName_id").val("");
							$("#patientCard_id").val("");
							$("#patientAge").val("0");
							$("#registered_type_list").children().remove();
							$("#registered_doctor_list").children().remove();
							$("#registered_registeredFee").val("");
							$("#registered_clinicsFee").val("");
							$("#registered_materialFee").val("");
							$("#registered_totalPrice").val("");
							$("#registered_input_price").val("");
							$("#registered_output_price").val("");
						}else{
							bootbox.alert({
								buttons: {  
									   ok: {  
											label: '确定',  
											className: 'btn-primary'  
										}  
									},  
								message: "挂号失败，请重新挂号！！",
							})
						}
					},
					error : function() {
						alert("请求出错");
					}
			});
	}else{
		bootbox.alert({
			buttons: {  
				   ok: {  
						label: '确定',  
						className: 'btn-primary'  
					}  
				},  
			message: "请认真核对填入信息",
			size: 'small'
		})
	}
}
									/* 退号模块 */	 
/* 获取 可以退号的 患者列表  */
var dataBacknumberLength;
function findDeleteRegisteredPatientList(pageNo){
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatient/pc/findAllRefund',
		data : "ssid=${sicmedUserBean.ssid}&isPay=1&pageNo="+pageNo,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					if(data.error == 0){
						dataBacknumberLength = data.sicmedRegisteredBeans.length;
						$.each(data,function(name, value) {
							$("#tab_del_registered_patient").children().remove();
							$("#tab_del_registered_patient").append("<tr style='height:44px;line-height:44px;color:#fff;background-color:#124256;'>"
							+"<td align='center' style='border-radius:6px 0px 0px 0px;'>患者编号</td>"
							+"<td>姓名</td>"
							+"<td>年龄</td>"
							+"<td>性别</td>"
							+"<td>挂号科室</td>"
							+"<td>挂号日期</td>"
							+"<td align='center' style='border-radius:0px 6px 0px 0px;'>操作</td>"
							+"</tr>");
							if (name == "sicmedRegisteredBeans") {
								$.each(value,function(name2,value2) {
									var a = name2
									if(a%2==0){
									$("#tab_del_registered_patient").append("<tr style='color:#757575;' class='tab_del_registered_patient_tr_2'>"
											+"<td align='center'>"+value2.sicmedPatientBean.patientNumber+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientName+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientAge+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientSex+"</td>"
											+"<td>"+value2.sicmedBranchBean.branchName+"</td>"
											+"<td>"+value2.createDate+"</td>"
											+"<td align='center'><button id="+value2.sicmedPatientBean.id+ " class='toll_but_tab' onclick='getDeleteRegisteredByPatient(this.id)'>退号</button></td>"
											+"</tr>");
									}else{
									$("#tab_del_registered_patient").append("<tr style='color:#757575;'  class='tab_del_registered_patient_tr_1'>"
											+"<td align='center'>"+value2.sicmedPatientBean.patientNumber+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientName+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientAge+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientSex+"</td>"
											+"<td>"+value2.sicmedBranchBean.branchName+"</td>"
											+"<td>"+value2.createDate+"</td>"
											+"<td align='center'><button id="+value2.sicmedPatientBean.id+ " class='toll_but_tab' onclick='getDeleteRegisteredByPatient(this.id)'>退号</button></td>"
											+"</tr>");
									}
								
								});
							}
						resizeBar();
						});	
					}
				},
			error : function() {
				alert("请求出错");
				}
		});
}
	
/* 退号-患者列表 —分页 */	
// 下一页
$("#nextpage_backnumber_patientlist").click(function(e){
	if(dataBacknumberLength == 20){
		backPageNo ++;
		findDeleteRegisteredPatientList(backPageNo);
		$("#currentpage_backnumber_patientlist a").html(backPageNo);
	}
	e.preventDefault();
})

// 上一页
$("#prevpage_backnumber_patientlist").click(function(e){
	if(backPageNo>1){
		backPageNo --;
		findDeleteRegisteredPatientList(backPageNo);
		$("#currentpage_backnumber_patientlist a").html(backPageNo);
	}
	e.preventDefault();
})


									
function getDeleteRegisteredByPatient(id){
	$("#del_registered_sure").removeAttr("disabled");
	
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegistered/getByPatient',
		data : "ssid=${sicmedUserBean.ssid}&patientId="+id,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log("返回的数据为：")
					console.log(data);
					$("#del_registered_delete_but").removeAttr("disabled"); 
					$("#del_registered_search").hide();
					$("#del_registered_create_user").show();
					$("#tab_del_registered_patient").hide();
					$("#page_del_registered_patient").hide();
					
					$("#del_registered_delete_view").show();
					$("#del_registered_delete_but").removeClass("but-re-active");
					$("#del_registered_delete_but").addClass("but-active");
					$("#del_registered_patient_list_but").removeClass("but-active");
					$("#del_registered_patient_list_but").addClass("but-re-active");
					resizeBar();
					
					$("#del_registered_create_user_show").html("");
					$("#del_registered_patientNumber").html("");
					$("#del_registered_patientName").val("");
					$("#del_registered_patientAge").val("");
					$("#del_registered_patientSex").val("");
					$("#del_registered_patientCard").val("");
					$("#del_registered_doctor").val("");
					$("#del_registered_branch").val("");
					$("#del_registered_type").val("");
					$("#del_registered_clinicsFee").val("");
					$("#del_registered_total_price").val("");
					$("#del_registered_output_price").val("");
					$("#del_registered_intput_price").val("");
					
					$("del_registered_id_h").val("");
					
					$("#del_registered_create_user_show").html(data.createUserBean.userName);
					$("#del_registered_patientNumber").html(data.sicmedPatientBean.patientNumber);
					$("#del_registered_patientName").val(data.sicmedPatientBean.patientName);
					$("#del_registered_patientAge").val(data.sicmedPatientBean.patientAge);
					$("#del_registered_patientSex").val(data.sicmedPatientBean.patientSex);
					$("#del_registered_branch").val(data.sicmedBranchBean.branchName);
					$("#del_registered_type").val(data.sicmedRegisteredTypeBean.typeName);
					$("#del_registered_clinicsFee").val(data.sicmedRegisteredTypeBean.sicmedRegisteredPriceBean.clinicsFee);
					$("#del_registered_total_price").val(data.sicmedRegisteredTypeBean.sicmedRegisteredPriceBean.clinicsFee);
					$("#del_registered_id_h").val(data.id);
					
					$("#del_registered_patientCard").val(data.sicmedPatientBean.patientCard);
					
					if(data.sicmedDoctorBean){
						$("#del_registered_doctor").val(data.sicmedDoctorBean.userName);
					}
				},
				error : function() {
					alert("请求出错");
				}
		});
	
}			
function deleteRegisteredById(){
	var id = $("#del_registered_id_h").val();
	
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegistered/delete',
		data : "ssid=${sicmedUserBean.ssid}&registeredId="+id,
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
						    message: "退号成功",
						    size: 'small',
						    callback: function(){
						    	$("#del_registered_patientNumber").html("");
								$("#del_registered_patientName").val("");
								$("#del_registered_patientAge").val("");
								$("#del_registered_patientSex").val("");
								$("#del_registered_patientCard").val("");
								$("#del_registered_doctor").val("");
								$("#del_registered_branch").val("");
								$("#del_registered_type").val("");
								$("#del_registered_clinicsFee").val("");
								$("#del_registered_total_price").val("");
								$("#del_registered_output_price").val("");
								$("#del_registered_intput_price").val("");
								
								$("del_registered_id_h").val("");
								
								$("#del_registered_sure").attr({"disabled":"disabled"});
						    }
						})
					}
				},
				error : function() {
					console.log("请求出错");
				}
		});
}				
									/* 改号模块 */
/* 获取 可以改号的 患者列表  */
function findUpdateRegisteredPatientList(pageNo){
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatient/pc/findAllChange',
		data : "ssid=${sicmedUserBean.ssid}&isPay=1&pageNo="+pageNo,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					if(data.error == 0){
						dataChangenumberLength = data.sicmedRegisteredBeans.length;
						$.each(data,function(name, value) {
							$("#tab_up_registered_patient").children().remove();
							$("#tab_up_registered_patient").append("<tr style='height:44px;color:#fff;background-color:#124256;'>"
							+"<td align='center' style='border-radius:6px 0px 0px 0px;'>患者编号</td>"
							+"<td>姓名</td>"
							+"<td>年龄</td>"
							+"<td>性别</td>"
							+"<td>挂号科室</td>"
							+"<td>挂号日期</td>"
							+"<td align='center' style='border-radius:0px 6px 0px 0px;'>操作</td>"
							+"</tr>");
							if (name == "sicmedRegisteredBeans") {
								$.each(value,function(name2,value2) {
									var a = name2
									if(a%2==0){
									$("#tab_up_registered_patient").append("<tr class='tab_del_registered_patient_tr_2' style='color:#757575;'>"
											+"<td align='center' style='color:#757575;'>"+value2.sicmedPatientBean.patientNumber+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientName+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientAge+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientSex+"</td>"
											+"<td>"+value2.sicmedBranchBean.branchName+"</td>"
											+"<td>"+value2.createDate+"</td>"
											+"<td align='center'><button id="+value2.sicmedPatientBean.id+ " class='toll_but_tab' onclick='getUpdateRegisteredByPatient(this.id)'>改号</button></td>"
											+"</tr>");
									}else{
									$("#tab_up_registered_patient").append("<tr class='tab_del_registered_patient_tr_1' style='color:#757575;'>"
											+"<td align='center' style='color:#757575;'>"+value2.sicmedPatientBean.patientNumber+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientName+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientAge+"</td>"
											+"<td>"+value2.sicmedPatientBean.patientSex+"</td>"
											+"<td>"+value2.sicmedBranchBean.branchName+"</td>"
											+"<td>"+value2.createDate+"</td>"
											+"<td align='center'><button id="+value2.sicmedPatientBean.id+ " class='toll_but_tab' onclick='getUpdateRegisteredByPatient(this.id)'>改号</button></td>"
											+"</tr>");
									}
								
								});
							}
						});
						resizeBar();
					}
				},
		error : function() {
					alert("请求出错");
				}
		});
}
		
/* 改号-患者列表 —分页 */	
//下一页
$("#nextpage_changenumber_patientlist").click(function(e){
	if(dataChangenumberLength == 20){
		changePageNo ++;
		findUpdateRegisteredPatientList(changePageNo);
		$("#currentpage_changenumber_patientlist a").html(changePageNo);
	}
	e.preventDefault();
})

//上一页
$("#prevpage_changenumber_patientlist").click(function(e){
	if(changePageNo>1){
		changePageNo --;
		findUpdateRegisteredPatientList(changePageNo);
		$("#currentpage_changenumber_patientlist a").html(changePageNo);
	}
	e.preventDefault();
})
									
									
									
									
									
									
									
/* 获取改号患者信息 */
function getUpdateRegisteredByPatient(id){
	
	findRegisteredBranchUpdate();
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegistered/getByPatient',
		data : "ssid=${sicmedUserBean.ssid}&patientId="+id,
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					$("#up_registered_update_but").removeAttr("disabled"); 
					
					$("#up_registered_search").hide();
					$("#up_registered_create_user").show();
					$("#tab_up_registered_patient").hide();
					$("#page_up_registered_patient").hide();
					
					$("#up_registered_update_view").show();
					$("#up_registered_update_but").removeClass("but-re-active");
					$("#up_registered_update_but").addClass("but-active");
					$("#up_registered_patient_list_but").removeClass("but-active");
					$("#up_registered_patient_list_but").addClass("but-re-active");
					resizeBar();
					$("#up_registered_create_user_show").html("");
					$("#up_registered_patientNumber").html("");
					$("#up_registered_patientName").val("");
					$("#up_registered_patientAge").val("");
					$("#up_registered_registered_sex_boy").prop("checked",false);
					$("#up_registered_registered_sex_girle").prop("checked",false);
					$("#up_registered_patientCard").val("");
					$("#up_registered_clinicsFee").val("");
					$("#up_registered_materialFee").val("");
					$("#up_registered_registeredFee").val("");
					
					$("#up_registered_total_price").val("");
					$("#up_registered_output_price").val("");
					$("#up_registered_intput_price").val("");
					
					$("#up_registered_id_h").val("");
					$("#up_patient_id_h").val("");
					
					
					$("#up_registered_create_user_show").html(data.createUserBean.userName);
					
					$("#up_registered_branch_list").val(data.sicmedBranchBean.id);
					var oldTotalPrice = data.sicmedRegisteredTypeBean.sicmedRegisteredPriceBean.clinicsFee*1+data.sicmedRegisteredTypeBean.sicmedRegisteredPriceBean.materialFee*1+data.sicmedRegisteredTypeBean.sicmedRegisteredPriceBean.registeredFee*1;
					
					
					//$("#up_registered_type_list").append("<option value="+data.sicmedRegisteredTypeBean.id+">"+data.sicmedRegisteredTypeBean.typeName+"</option>");
					$("#oldTotalPrice").val(oldTotalPrice);
					
					
					$("#up_registered_patientNumber").html(data.sicmedPatientBean.patientNumber);
					$("#up_registered_patientName").val(data.sicmedPatientBean.patientName);
					$("#up_registered_patientAge").val(data.sicmedPatientBean.patientAge);
					$("#up_registered_patientSex").val(data.sicmedPatientBean.patientSex);
					$("#up_registered_clinicsFee").val(data.sicmedRegisteredTypeBean.sicmedRegisteredPriceBean.clinicsFee);
					$("#up_registered_materialFee").val(data.sicmedRegisteredTypeBean.sicmedRegisteredPriceBean.materialFee);
					$("#up_registered_registeredFee").val(data.sicmedRegisteredTypeBean.sicmedRegisteredPriceBean.registeredFee);
					$("#up_registered_total_price").val(data.sicmedRegisteredTypeBean.sicmedRegisteredPriceBean.clinicsFee);
					$("#up_registered_id_h").val(data.id);
					$("#up_patient_id_h").val(data.sicmedPatientBean.id);
					if(data.sicmedPatientBean.patientSex == "男"){
						$("#up_registered_registered_sex_boy").prop("checked",true);
					}else{
						$("#up_registered_registered_sex_girle").prop("checked",true);
					}
					$("#up_registered_patientCard").val(data.sicmedPatientBean.patientCard);
					
					var docId = "";
					if(data.sicmedDoctorBean){
						$("#up_registered_doctor_list").append("<option value="+data.sicmedDoctorBean.id+">"+data.sicmedDoctorBean.userName+"</option>");
						docId = data.sicmedDoctorBean.id;
					}
					//获取挂号类型
					findRegisteredTypeUpdate(data.sicmedRegisteredTypeBean.id,docId);
					
				},
					error : function() {
						alert("请求出错");
					}
		});
}	
/* 改号 页 获取 挂号科室列表  */
function findRegisteredBranchUpdate(){
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedBranch/findAllRegisteredBranch',
		data : "ssid=${sicmedUserBean.ssid}",
		cache : false,
		dataType : 'json',
		success : function(data) {
					console.log(data);
					$.each(data,function(name, value) {
						$("#up_registered_branch_list").children().remove();
						if (name == "sicmedBranchBeans") {
							$.each(value,function(name2,value2) {
								$("#up_registered_branch_list").append("<option value="+value2.id+">"+value2.branchName+"</option>");
							});
						}
					});
				},
				error : function() {
					alert("请求出错");
				}
		});
} 
/* 改号 页 获取 挂号类型列表  */
 function findRegisteredTypeUpdate(regTypId,docId){
	 var branchId = $("#up_registered_branch_list").val();
	 $.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegisteredType/findByBranch',
			data : "ssid=${sicmedUserBean.ssid}&branchId="+branchId,
			cache : false,
			dataType : 'json',
			success : function(data) {
						console.log(data);
						$.each(data,function(name, value) {
							$("#up_registered_type_list").children().remove();
							if (name == "sicmedRegisteredTypeBeans") {
								$.each(value,function(name2,value2) {
									$("#up_registered_type_list").append("<option value="+value2.id+">"+value2.typeName+"</option>");
								});
							}
							if(regTypId!=undefined){
								$("#up_registered_type_list").val(regTypId);
							}
						});
						findRegisteredDoctorUpdate(docId)
						},
						error : function() {
							alert("请求出错");
						}
			});
	 isReturn = true;
}

function getRegisteredTypeByIdUpdate(){
	var id =  $("#up_registered_type_list").val();
	 $.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegisteredType/getById',
			data : "ssid=${sicmedUserBean.ssid}&id="+id,
			cache : false,
			dataType : 'json',
			success : function(data) {
						console.log(data);
						$.each(data,function(name, value) {
							var oldTotalPrice = $("#oldTotalPrice").val()
							var totalPrice = data.sicmedRegisteredPriceBean.registeredFee*1+data.sicmedRegisteredPriceBean.clinicsFee*1+data.sicmedRegisteredPriceBean.materialFee*1;
							$("#up_registered_registeredFee").val(data.sicmedRegisteredPriceBean.registeredFee);
							$("#up_registered_clinicsFee").val(data.sicmedRegisteredPriceBean.clinicsFee);
							$("#up_registered_materialFee").val(data.sicmedRegisteredPriceBean.materialFee);
							$("#up_registered_totalPrice").val(totalPrice-oldTotalPrice);
						});
						findRegisteredDoctor(data.id);
					},
					error : function() {
						alert("请求出错");
					}
		});
}
 /* 改号 页 获取 挂号医生 列表  */
 function findRegisteredDoctorUpdate(docId){
	 var branchId =  $("#up_registered_branch_list").val();
	 var registeredTypeId = $("#up_registered_type_list").val();
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedUser/findByRegisteredType',
			data : "ssid=${sicmedUserBean.ssid}&registeredTypeId="+registeredTypeId+"&branchId="+branchId,
			cache : false,
			dataType : 'json',
			success : function(data) {
						console.log(data);
						$.each(data,function(name, value) {
							$("#up_registered_doctor_list").children().remove();
							$("#up_registered_doctor_list").append("<option value=''>请选择</option>");
							if (name == "sicmedUserBeans") {
								$.each(value,function(name2,value2) {
									$("#up_registered_doctor_list").append("<option value="+value2.id+">"+value2.userName+"</option>");
								});
							}
							
						});
						if(docId!=undefined){
						$("#up_registered_doctor_list").val(docId)
						}
					},
					error : function() {
						alert("请求出错");
					}
			});
}
 
 /* 改号接口  */
 function updateRegistered(){
		var str1 = $("#up_registered_form1").serialize();
		var str2 = $("#up_registered_form2").serialize();
		console.log(str1+"_"+str2);
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegistered/update',
			data : "ssid=${sicmedUserBean.ssid}&"+str1+"&"+str2,
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
							    message: "改号成功",
							    size: 'small'
							})
							//改号成功跳转
							$("#up_registered_search").show();
							$("#up_registered_create_user").hide();
							$("#up_registered_update_view").hide();
							$("#up_registered_patient_view").show();
							
							$("#tab_up_registered_patient").show();
							$("#page_up_registered_patient").show();
							
							$("#up_registered_patient_list_but").removeClass("but-re-active");
							$("#up_registered_patient_list_but").addClass("but-active");
							$("#up_registered_update_but").removeClass("but-active");
							$("#up_registered_update_but").addClass("but-re-active");
							resizeBar();
							//改号成功清空表单
							$("#up_registered_doctor_list").children().remove();
							$("#up_registered_type_list").children().remove();
							$("#up_registered_patientName").val("");
							$("#up_registered_patientAge").val("0");
							$("#up_registered_patientCard").val("");
							$("#up_registered_registeredFee").val("");
							$("#up_registered_clinicsFee").val("");
							$("#up_registered_materialFee").val("");
							$("#up_registered_totalPrice").val("");
							$("#up_registered_output_price").val("");
							$("#up_registered_input_price").val("");
							
							
							
							
						}
					},
					error : function() {
						alert("请求出错");
					}
			});
	}
 
 
 
 /* 挂号记录  */
 function registeredHistory(beginDate,endDate){
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegistered/pc/getRegisteredFlag',
			data : "ssid=${sicmedUserBean.ssid}&beginDate="+beginDate+"&endDate="+endDate,
			cache : false,
			dataType : 'json',
			success : function(data) {
					console.log(data);
					$.each(data,function(name, value) {
						if (name == "historyRecordBeans") {
							var totalPrice = 0;
							$("#tab_patient_find").children().remove();
							$("#tab_patient_find").append("<tr style='height:44px;background:#39a0ed;'>"
							+"<td style='border-top-left-radius: 8px; background:#39a0ed;' align='center'>患者姓名</td>"
							+"<td style='background:background:#39a0ed;;'>性别</td>"
							+"<td style='background:#39a0ed;'>年龄</td>"
							+"<td style='background:#39a0ed;'>日期</td>"
							+"<td style='border-top-right-radius: 8px; background:#39a0ed;'>金额</td>"
							+"</tr>");
							
							
							$.each(value,function(name2,value2) {
								var price = value2.clinicsFee*1+value2.materialFee*1+value2.registeredFee*1;
								totalPrice = totalPrice + price*1;
								var a = name2
								if(a%2==0){
								$("#tab_patient_find").append("<tr class='tab_refund_patient_tr_1'>"
										+"<td align='center'>"+value2.sicmedPatientName+"</td>"
										+"<td>"+value2.sicmedPatientSex+"</td>"
										+"<td>"+value2.sicmedPatientAge+"</td>"
										+"<td>"+value2.updateDate+"</td>"
										+"<td>"+price+"</td>"
										+"</tr>");
								}else{
								$("#tab_patient_find").append("<tr class='tab_refund_patient_tr_2'>"
										+"<td align='center'>"+value2.sicmedPatientName+"</td>"
										+"<td>"+value2.sicmedPatientSex+"</td>"
										+"<td>"+value2.sicmedPatientAge+"</td>"
										+"<td>"+value2.updateDate+"</td>"
										+"<td>"+price+"</td>"
										+"</tr>");
								}
							
							});
							$("#total_patient").val(value.length);
							$("#total_price_his").val(totalPrice);
						}
						$("#tab_patient_find").addClass("table_his");
					});
					resizeBar();
					},
					error : function() {
						alert("请求出错");
					}
			});
	}

 /* tui号记录  */
 function delRegisteredHistory(beginDate,endDate){
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegistered/pc/getDelRegisteredFlag',
			data : "ssid=${sicmedUserBean.ssid}&beginDate="+beginDate+"&endDate="+endDate,
			cache : false,
			dataType : 'json',
			success : function(data) {
					console.log(data);
					$.each(data,function(name, value) {
						if (name == "historyRecordBeans") {
							var totalPrice = 0;
							$("#tab_patient_find").children().remove();
							$("#tab_patient_find").append("<tr style='height:44px;background:#39a0ed;'>"
									+"<td style='border-top-left-radius: 8px; background:#39a0ed;' align='center'>患者姓名</td>"
									+"<td style='background:background:#39a0ed;;'>性别</td>"
									+"<td style='background:#39a0ed;'>年龄</td>"
									+"<td style='background:#39a0ed;'>日期</td>"
									+"<td style='border-top-right-radius: 8px; background:#39a0ed;'>金额</td>"
									+"</tr>")
							
							$.each(value,function(name2,value2) {
								var price = value2.clinicsFee*1;
								totalPrice = totalPrice + price*1;
								var a = name2
								if(a%2==0){
								$("#tab_patient_find").append("<tr class='tab_refund_patient_tr_1'>"
										+"<td align='center'>"+value2.sicmedPatientName+"</td>"
										+"<td>"+value2.sicmedPatientSex+"</td>"
										+"<td>"+value2.sicmedPatientAge+"</td>"
										+"<td>"+value2.updateDate+"</td>"
										+"<td>"+price+"</td>"
										+"</tr>");
								}else{
								$("#tab_patient_find").append("<tr class='tab_refund_patient_tr_2'>"
										+"<td align='center'>"+value2.sicmedPatientName+"</td>"
										+"<td>"+value2.sicmedPatientSex+"</td>"
										+"<td>"+value2.sicmedPatientAge+"</td>"
										+"<td>"+value2.updateDate+"</td>"
										+"<td>"+price+"</td>"
										+"</tr>");
								}
							
							});
							$("#total_patient").val(value.length);
							$("#total_price_his").val(totalPrice);
						}
					});
					resizeBar();
					},
					error : function() {
						alert("请求出错");
					}
			});
	}
 
 /*gai号记录  */
 function upRegisteredHistory(beginDate,endDate){
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegistered/pc/getUpRegisteredFlag',
			data : "ssid=${sicmedUserBean.ssid}&beginDate="+beginDate+"&endDate="+endDate,
			cache : false,
			dataType : 'json',
			success : function(data) {
					console.log(data);
					$.each(data,function(name, value) {
						if (name == "historyRecordBeans") {
							var totalPrice = 0;
							$("#tab_patient_find").children().remove();
							$("#tab_patient_find").append("<tr style='height:44px;background:#39a0ed;'>"
									+"<td style='border-top-left-radius: 8px; background:#39a0ed;' align='center'>患者姓名</td>"
									+"<td style='background:background:#39a0ed;;'>性别</td>"
									+"<td style='background:#39a0ed;'>年龄</td>"
									+"<td style='background:#39a0ed;'>日期</td>"
									+"<td style='border-top-right-radius: 8px; background:#39a0ed;'>金额</td>"
									+"</tr>")
							
							$.each(value,function(name2,value2) {
								var price = value2.clinicsFee*1;
								totalPrice = totalPrice + price*1;
								var a = name2
								if(a%2==0){
								$("#tab_patient_find").append("<tr class='tab_refund_patient_tr_1'>"
										+"<td align='center'>"+value2.sicmedPatientName+"</td>"
										+"<td>"+value2.sicmedPatientSex+"</td>"
										+"<td>"+value2.sicmedPatientAge+"</td>"
										+"<td>"+value2.updateDate+"</td>"
										+"<td>"+price+"</td>"
										+"</tr>");
								}else{
								$("#tab_patient_find").append("<tr class='tab_refund_patient_tr_2'>"
										+"<td align='center'>"+value2.sicmedPatientName+"</td>"
										+"<td>"+value2.sicmedPatientSex+"</td>"
										+"<td>"+value2.sicmedPatientAge+"</td>"
										+"<td>"+value2.updateDate+"</td>"
										+"<td>"+price+"</td>"
										+"</tr>");
								}
							
							});
							$("#total_patient").val(value.length);
							$("#total_price_his").val(totalPrice);
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
			
		$("#registered_left_bar").css("width","14%")
		$("#registered_view").css("width","82.9%")	
		$("#del_registered_view").css("width","82.9%")
		$("#up_registered_view").css("width","82.9%")
		$("#find_history_view").css("width","82.9%")
		$("#registered_view").css("margin-left","3%")	
		$("#del_registered_view").css("margin-left","3%")
		$("#up_registered_view").css("margin-left","3%")
		$("#find_history_view").css("margin-left","3%")
		
		}
	})
	
	function resizeBar(){
	$("#registered_left_bar").css("height",70)
	var height1 = $(window).height();
	var height = $("#registered_body").height();
	if(height<height1){
		
		$("#registered_left_bar").css("height",height1-80)
	}else{
		$("#registered_left_bar").css("height",height)
	}
	
 }
 //时间显示
 $(document).ready(function(){
	 setInterval(function() {
		    var now = (new Date()).toLocaleString();
		    $('#current-time').text(now);
		}, 1000); 
 })
 
</script>
</body>
</html>