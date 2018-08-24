<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<title>医生工作站</title>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0">

<!-- <link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />-->
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.css" type="text/css" rel="stylesheet" />

<!-- textarea 高度自适应 -->
<script src="/jeesite/static/Pc/autosize/autosize.js" type="text/javascript"></script>
<script type="text/javascript">


</script>

<style>
/***** 引入字体图标 *****/
@font-face {
	font-family: 'iconfont';
	src: url('/jeesite/static/Pc/vectorDiagram/iconfont.eot'); /* IE9*/
	src: url('/jeesite/static/Pc/vectorDiagram/iconfont.eot?#iefix')
		format('embedded-opentype'), /* IE6-IE8 */
		    url('/jeesite/static/Pc/vectorDiagram/iconfont.woff')
		format('woff'), /* chrome、firefox */
		    url('/jeesite/static/Pc/vectorDiagram/iconfont.ttf')
		format('truetype'),
		/* chrome、firefox、opera、Safari, Android, iOS 4.2+*/
		    url('/jeesite/static/Pc/vectorDiagram/iconfont.svg#iconfont')
		format('svg'); /* iOS 4.1- */
}

.iconfont {
	font-family: "iconfont" !important;
	font-size: 18px;
	font-style: normal;
	-webkit-font-smoothing: antialiased;
	-webkit-text-stroke-width: 0.2px;
	-moz-osx-font-smoothing: grayscale;
}

/***** 通用样式 *****/
body, button, input, select, textarea, h1, h2, h3, h4, h5, h6 {
	font-family: Microsoft YaHei
}

ul, li {
	list-style: none;
}

label {
	font-weight: normal;
}

a:link, a:visited {
	text-decoration: none; /*超链接无下划线*/
}

a:hover {
	text-decoration: none; /*鼠标放上去有下划线*/
}

texearea {
	resize: none;
}

/*清除浮动影响*/
.clearfix :after {
	display: black;
	content: "";
	clear: both;
	visibility: hidden;
}

.margin-left10 {
	margin-left: 10px;
}

.margin-left20 {
	margin-left: 20px;
}

.margin-right10 {
	margin-right: 10px;
}

.margin-right20 {
	margin-right: 20px;
}

/* 字体颜色 */
.font-color75 {
	color: #757575;
}

.font-color21 {
	color: #212121;
}

.font-color12 {
	color: #124256;
}

.btn-sicmed {
	display: inline-block;
	padding: 6px 12px;
	margin-bottom: 0;
	font-size: 14px;
	font-weight: normal;
	line-height: 1.42857143;
	text-align: center;
	white-space: nowrap;
	vertical-align: middle;
	-ms-touch-action: manipulation;
	touch-action: manipulation;
	cursor: pointer;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	background-image: none;
	border: 1px solid transparent;
	border-radius: 6px;
}

.basc-bg {
	background-color: #05b3d9;
}

/***** 导航栏  *****/
.new-nav {
	background: #3cc5de;
	margin-bottom: 0%;
	height: 80px;
	margin-right: -15px;
}

/***** 左边侧边栏  *****/
#content_left {
	background: #efefef;
	padding-right: 0px;
}

#myTab li.lf_actives {
	background: #fff;
}

#myTab li.lf_actives>a {
	background: #fff;
}

#myTab li {
	height: 60px;
	line-height: 60px;
	padding: 0px 15px;
}

#myTab li a {
	height: 60px;
	line-height: 60px;
	padding: 0px;
	color: #124256;
	text-align: center;
}

#myTab li a span {
	font-size: 16px;
}

/***** 右边主体内容  *****/
/*标题文字（病历、医嘱）*/
.title-inne {
	font-size: 18px;
	color: #124256;
}
/* 标题文字下划线 */
.title-hr {
	height: 1px;
	border-bottom: 1px solid #124256;
	margin: auto
}

/* 患者列表 */
.btn-open {
	width: 104px;
	height: 26px;
	line-height: 26px;
	border: 1px solid #bdbdbd;
	color: #212121;
}

.btn-open-active {
	background-color: #124256;
	border-color: #124256;
	color: #fff;
}

#tab_price_patient tr td {
	padding: 0px;
	height: 38px;
	line-height: 38px;
	padding: 3px 0px;
	border: none;
}

#tab_price_patient thead tr {
	background-color: #124256;
	height: 44px;
	line-height: 44px;
}

#tab_price_patient thead tr td {
	color: #fff;
}

#tab_price_patient tbody tr td {
	color: #757575;
}

/* 初步诊断  */
#preliminaryDiagnosis_list {
	padding-left: 0px;
}

#preliminaryDiagnosis_list li {
	float: left;
	height: 26px;
	line-height: 26px;
	background-color: #05b3d9;
	border-radius: 6px;
	color: #fff;
	margin-right: 5px;
	margin-bottom: 5px;
}
/* 初步诊断添加按钮 */
#addPreliminaryDiagnosis {
	font-size: 28px;
	color: #05b3d9;
	font-size: 22px;
	cursor: pointer;
}

/* 医嘱 */
#tab_doctor, #standPrescription_doctor {
	border-top: none;
	border-left: none;
	border-right: none;
}

#standPrescription_doctor tbody tr ,#table_productItem tbody tr{
	cursor:pointer;
}

#tab_doctor thead tr:first-child td, #standPrescription_doctor thead tr:first-child td
	{
	line-height: 60px;
}

#tab_doctor tr td, #table_standProductItem tr td {
	border-bottom: none;
}

/* Table nav */
.doctor-list-th {
	background-color: #05b3d9;
	color: #fff;
}

/* 搜索医嘱项目 (医生、标准处方)*/
.search-doclist-item {
	background-color: #05b3d9;
	height: 46px;
	line-height: 46px;
	border-radius: 6px 6px 0px 0px;
}

/* 按钮状态切换（全部、检查、检验、治疗、药品） */
.doctype_bacg {
	color: #fff;
	background-color: #3cc5de;
}

.doctype_bacg_active {
	color: #fff;
	background-color: #124256;
}

.patient_info_head {
	font-size: 14px;
	color: #bdbdbd;
}

/* 查询历史标准处方 */
#historyStandPrescription_list li {
	border: none;
}

#historyStandPrescription_list li {
	background-color: #efefef;
}
/* 鼠标悬浮 */
#historyStandPrescription_list li:hover {
	background-color: #ffe17f;
	color: #212121;
}

/* BOOTSTRAP && btn */
.btn-warning:focus, .btn-warning.focus {
	color: #fff;
	background-color: #ffc300;
	border-color: #ffc300;
}

.btn-warning {
	background-color: #ffc300;
}

/* 分页 */
.pagination>li>a {
	color: #05b3d9;
}

.pagination>.active>a {
	background-color: #05b3d9;
	border-color: #05b3d9;
}



#previous_page_standard>a{
	
}
</style>
</head>
<body style='overflow: -Scroll; overflow-x: hidden'>
	<!--引：header.html-->
	<nav class="new-nav" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header" style="margin-left: 2%;">
			<a class="navbar-brand" href="#"> <img alt=""
				class="img-responsive" src="/jeesite/static/Pc/img/logo.png">
			</a>
		</div>
		<p class="navbar-text"
			style="color: #fff; font-size: 18px; margin-top: 27px; margin-left: 2%; font-weight: 500;">医生工作站</p>
		<ul class="nav navbar-nav navbar-right"
			style="margin-top: 17px; margin-right: 15px; color: #fff; font-weight: 500;">
			<li><p class="navbar-text">2016/06/21</p></li>
			<li>
				<p class="navbar-brand" style="padding-right: 0px;">
					<!-- <img src="/jeesite/static/Pc/img/user.png" alt=""> -->
					<i class="iconfont yonghuming" style="font-size: 20px;">&#xe614;</i>
				</p>
			</li>
			<li>
				<p class="navbar-text" style="margin-left: 7px;">${sicmedUserBean.userName}</p>
			</li>
			<li id="exit">
				<a href="javascript:;" class="btn btn-sm navbar-btn" style="margin-left: 15px; background-color: #3cc5de; color: #fff; border: 1px solid #fff; padding: 4px 19px; border-radius: 8px;">退出</a>
			</li>
		</ul>
	</div>
	</nav>


	<!--主体-->
	<div class="container-fluid" style="padding: 0px;">
		<div class="row">
			<!--左侧-->
			<div class="col-lg-2 col-sm-2">
				<div class="row" style="padding-right: 0px;">
					<div id="content_left" class="col-lg-8 col-sm-11">
						<ul id="myTab" class="nav" style="margin-top: 40px;">
							<li class="lf_actives" id="openWorkPre">
								<a href="#tab1" data-toggle="tab">
									<i class="iconfont kaishigongzuo">&#xe605;</i> 
									<span style="margin-left: 10%;">开始工作</span>
								</a>
							</li>
							<li id="standardPrescriptionPre">
								<a href="#tab2" data-toggle="tab"> <!-- <img id="tab2_img" style="width:17px;" src="/jeesite/static/Pc/img/standard-medical.png" alt=""> -->
									<i class="iconfont biaozhunchufang">&#xe600;</i> 
									<span style="margin-left: 10%;">标准处方</span>
								</a>
							</li>
							<li id="treatmentRecordPre">
								<a href="#tab3" data-toggle="tab"> 
									<i class="iconfont zhenliaojilu">&#xe60f;</i> 
									<span style="margin-left: 10%;">诊疗记录</span>
								</a>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--右侧-->
			<div id="content_right" class="col-lg-10 col-sm-10">
				<div class="tab-content" style="margin-top: 38px">
					<!--开始工作-->
					<div class="tab-pane fade in active" id="tab1">
						<div class="row" style="margin-bottom: 20px;">
							<div class="col-lg-4 col-sm-7 tab-a" style="margin-top: 4px;">
								<a href="#tab-patient" id="openWork_tab1" data-toggle="tab"
									class="btn-sicmed"
									style="margin-right: 10px; width: 104px; height: 26px; line-height: 26px; color: #fff; background-color: #124256; border-color: #124256; color: #fff; padding: 0px 25px;">患者列表</a>
								<a href="" id="openWork_tab2" data-toggle="tab"
									class="btn-sicmed"
									style="margin-right: 10px; width: 104px; height: 26px; line-height: 26px; padding: 0px 25px; border-color: #bdbdbd; color: #212121; cursor: default;">病历</a>
								<a href="" id="openWork_tab3" data-toggle="tab"
									class="btn-sicmed"
									style="width: 104px; height: 26px; line-height: 26px; padding: 0px 25px; border-color: #bdbdbd; color: #212121; cursor: default;">医嘱</a>
							</div>
							<div class="col-lg-4 col-lg-offset-2 col-sm-5" id="serPatientList">
								<div class="input-group">
									<span class="input-group-addon"
										style="background: #ffffff; border: none; font-size: 14px; color: #757575;">患者编号</span>
									<input type="text" class="form-control"
										onKeyUp="value=value.replace(/[\W]/g,'')"
										style="border-radius: 0px; border-top-left-radius: 6px; border-bottom-left-radius: 6px;">
									<span class="input-group-btn">
										<button class="btn" type="button"
											style="background-color: #3cc5de; color: #fff; border-radius: 0px; border-top-right-radius: 6px; border-bottom-right-radius: 6px; padding-left: 25px; padding-right: 25px;">搜索</button>
									</span>
								</div>
							</div>
						</div>
						<div class="tab-content">
							<!--1、患者列表-->
							<div class="tab-pane fade in active" id="tab-patient">
								<div class="row">
									<div class="col-lg-10 col-sm-12">
										<table id='tab_price_patient'
											class='table table-striped table-responsive'>
											<thead>
												<tr align="center">
													<td align='center' style='border-top-left-radius: 6px;'>患者编号</td>
													<td align='center'>姓名</td>
													<td>年龄</td>
													<td>性别</td>
													<td>就诊日期</td>
													<td>电话</td>
													<td
														style='border-top-right-radius: 6px; padding-left: 10px;'>操作</td>
												</tr>
											</thead>
											<tbody></tbody>
										</table>
									</div>
								</div>
								<div class="row" id="pagination_openwork">
									<div class="col-lg-10 col-sm-12 text-right">
										<nav>
										<ul class="pagination">
											<li id="prevpage_patientlist"><a href="javascript:;">上一页</a></li>
											<li class="active" id="currentpage_patientlist"><a
												href="">1</a></li>
											<li id="nextpage_patientlist"><a href="javascript:;">下一页</a></li>
										</ul>
										</nav>
									</div>
								</div>
							</div>

							<!--2、病历-->
							<div class="tab-pane fade in" id="tab-medical"
								style="padding-bottom: 20px;">
								<!--<div style="border: 1px solid #efefef;border-radius: 6px;margin-top: 20px;padding: 10px">-->
								<div class="row"
									style="margin-bottom: 30px; margin-top: 20px; margin-left: 0%; margin-right: 0%">
									<div class="col-lg-10 col-sm-12 text-center"
										style="border: 1px solid #efefef; border-radius: 6px; padding: 15px 0px;">
										<div class="title-inne text-center">
											<!--  <img src="/jeesite/static/Pc/img/patient-infor.png" alt="" style="margin-bottom: 6px;width:21px;"> -->
											<i class="iconfont huanzhexinxi">&#xe60a;</i> <span>患者信息</span>
										</div>
										<div class="title-hr" style="width: 101px;"></div>

										<div class="row text-left"
											style="color: #757575; margin-top: 20px">
											<div
												class="col-lg-3 col-lg-offset-1 col-sm-4 col-sm-offset-1">
												患者编号：<span id='patientNumber' class='font-color21'></span>
											</div>
											<div class="col-lg-2 col-sm-3">
												姓名：<span id='patientName' class='font-color21'></span>
											</div>
											<div class="col-lg-2 col-sm-2">
												年龄：<span id='patientAge' class='font-color21'></span>
											</div>
											<div class="col-lg-2 col-sm-2">
												性别：<span id='patientSex' class='font-color21'></span>
											</div>
											<div class="col-lg-2 visible-lg">
												挂号类型：<span class='font-color21'>自费</span>
											</div>
										</div>
										<div class="row text-left"
											style="color: #757575; margin-top: 15px;">
											<div
												class="col-lg-3 col-lg-offset-1 col-sm-4 col-sm-offset-1">
												联系电话：<span id='patientTel' class='font-color21'></span>
											</div>
											<div class=" hidden-lg col-sm-3 ">
												挂号类型：<span class='font-color21'>自费</span>
											</div>
											<div class="col-lg-2 col-sm-2">
												科室：<span id="patient_branch" class='font-color21'></span>
											</div>
											<div class="col-lg-2 col-sm-2">
												医生：${sicmedUserBean.userName}<span class='font-color21'></span>
											</div>
										</div>
										<!-- <form class="form-horizontal" role="form" style="margin-top: 20px">
                                                <div class="form-group">
                                                    <label class="col-sm-1 col-sm-offset-1 control-label" style="color: #dbdbdb;text-align:left;">过敏药物</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" id="caseAllergy" name="caseAllergy" class="form-control" placeholder="请填写" >
                                                    </div>
                                                </div>
                                            </form> -->
									</div>
								</div>
								<!--</div>-->
								<!--<div  style="border: 1px solid #efefef;border-radius: 6px;margin-top: 20px;padding: 10px">-->
								<div class="row"
									style="margin-bottom: 20px; margin-top: 20px; margin-left: 0%; margin-right: 0%">
									<div class="col-lg-10 col-sm-12 text-center"
										style="border: 1px solid #efefef; border-radius: 6px; padding: 15px 0px;">
										<div class="title-inne text-center">
											<!-- <img src="/jeesite/static/Pc/img/medical-infor.png" alt="" style="margin-bottom: 6px;width:17px;"> -->
											<i class="iconfont binglixinxi">&#xe612;</i> <span>病历信息</span>
										</div>
										<div class="title-hr" style="width: 101px;"></div>

										<form class="form-horizontal" id="case_form" role="form"
											style="margin-top: 20px">
											<!-- 病历id -->
											<input type="hidden" name="id" id="caseId_h"> <input
												type="hidden" id="caseAllergy_hide" name="caseAllergy">
											<div class="form-group">
												<label
													class="col-lg-1 col-sm-2 control-label font-color75 text-right">主诉</label>
												<div class="col-lg-10 col-sm-9">
													<!-- <input type="text" id="caseTell" class="form-control font-color21" name="caseTell" placeholder="请填写"> -->
													<textarea class="form-control font-color21" id="caseTell"
														name="caseTell" rows="2"></textarea>
												</div>
											</div>
											<div class="form-group">
												<label
													class="col-lg-1 col-sm-2 control-label font-color75 text-right">现病史</label>
												<div class="col-lg-10 col-sm-9">
													<!-- <input type="text" id="caseHistory" class="form-control font-color21" name="caseHistory" placeholder="请填写"> -->
													<textarea class="form-control font-color21"
														id="caseHistory" name="caseHistory" rows="2"></textarea>
												</div>
											</div>
											<div class="form-group">
												<label
													class="col-lg-1 col-sm-2 control-label font-color75 text-right">既往病史</label>
												<div class="col-lg-10 col-sm-9">
													<!-- <input type="text" id=pastHistory class="form-control font-color21" name="pastHistory" placeholder="请填写"> -->
													<textarea class="form-control font-color21"
														id="pastHistory" name="pastHistory" rows="2"></textarea>
												</div>
											</div>
											<!-- <div class="form-group">
                                                    <label class="col-sm-1 control-label" style="color: #dbdbdb;">体格检查</label>
                                                    <div class="col-sm-10">
                                                        <div class="row">
                                                            <div class="col-sm-4">
                                                                <div class="form-group">
                                                                    <label class="col-sm-2 control-label" style="color: #dbdbdb;">T/</label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" class="form-control">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <div class="form-group">
                                                                    <label class="col-sm-2 control-label" style="color: #dbdbdb;">P/</label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" class="form-control">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-sm-4">
                                                                <div class="form-group">
                                                                    <label class="col-sm-2 control-label" style="color: #dbdbdb;">R/</label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" class="form-control">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <div class="form-group">
                                                                    <label class="col-sm-2 control-label" style="color: #dbdbdb;">BP/</label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" class="form-control">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <div class="form-group">
                                                                    <label class="col-sm-2 control-label" style="color: #dbdbdb;"> / </label>
                                                                    <div class="col-sm-10">
                                                                        <input type="text" class="form-control">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div> -->
											<div class="form-group">
												<label
													class="col-lg-1 col-sm-2 control-label font-color75 text-right">过敏史</label>
												<div class="col-lg-10 col-sm-9">
													<!-- <input type="text" id=familyAllergy class="form-control font-color21" name="familyAllergy" placeholder="请填写"> -->
													<textarea class="form-control font-color21"
														id="familyAllergy" name="familyAllergy" rows="2"></textarea>
												</div>
											</div>
											<div class="form-group">
												<label
													class="col-lg-1 col-sm-2 control-label font-color75 text-right">体格检查</label>
												<div class="col-lg-10 col-sm-9">
													<!-- <input type="text" id=checkCodeBody class="form-control font-color21" name="checkCodeBody" placeholder="请填写"> -->
													<textarea class="form-control font-color21"
														id="checkCodeBody" name="checkCodeBody" rows="2"></textarea>
												</div>
											</div>
											<div class="form-group">
												<label
													class="col-lg-1 col-sm-2 control-label font-color75 text-right">辅助检查</label>
												<div class="col-lg-10 col-sm-9">
													<!-- <input type="text" id="checkCodeAid" class="form-control font-color21" name="checkCodeAid" placeholder="请填写"> -->
													<textarea class="form-control font-color21"
														id="checkCodeAid" name="checkCodeAid" rows="2"></textarea>
												</div>
											</div>

											<!-- 初步诊断 -->
											<!-- <div class="form-group">
                                                    <label class="col-lg-1 col-sm-2 control-label" style="color: #dbdbdb;">诊断</label>
                                                    <div class="col-lg-10 col-sm-9">
                                                        <input type="search" id="preliminaryDiagnosis_name" class="form-control" placeholder="请点击搜索" readonly style="background:#fff;">
                                                    </div>
                                                </div> -->
											<div class="form-group">
												<label class="col-lg-1 col-sm-2 font-color75 text-right">诊断</label>
												<div class="col-lg-10 col-sm-9">
													<!-- <div class="row">
                                                    		<div class="col-sm-12" style="padding-right:0px;"> -->
													<div class="panel panel-default" id="zhenduan">
														<div class="panel-body">
															<ul class="clearfix" id="preliminaryDiagnosis_list"></ul>
														</div>
													</div>
													<!-- 	</div>
                                                    	</div> -->

													<!-- 初步诊断 model -->
													<div class="modal fade" id="preliminaryDiagnosis_Modal"
														tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<p style="margin-top: 10px; text-align: center;">搜索初步诊断</p>
																<div class="form-group has-feedback"
																	style="padding: 6px; margin-left: 0px; margin-right: 0px; margin-bottom: 0px;">
																	<span
																		class="glyphicon glyphicon-search form-control-feedback"
																		style="right: 0px; top: 6px; color: #bdbdbd;"></span>
																	<input type="search" class="form-control"
																		id="serch_preliminaryDiagnosis" placeholder="搜索">
																</div>
																<ul id="preliminaryDiagnosis_droupmenu_item"
																	class="list-group"
																	style="overflow-y: auto; border: none; margin-bottom: 0px;"></ul>
																<button type="button" id="seeMore_preliminaryDiagnosis"
																	class="btn btn-primary"
																	style="display: none; background-color: #39a0ed; border-color: #39a0ed;">
																	查看更多...</button>
															</div>
														</div>
													</div>

												</div>
											</div>

											<!-- <div class="form-group">
												<label class="col-lg-1 col-sm-2 control-label font-color75">处理</label>
												<div class="col-lg-11 col-sm-10">
													<div class="row">
														<div class="col-sm-11">
															<table class="table table-striped table-responsive"
																id="tab_chuli">
																<tr style="background-color: #05b3d9; color: #fff;">
																	<td
																		style="border-top-left-radius: 6px; border-color: #fff;">名称</td>
																	<td>剂量</td>
																	<td>用法</td>
																	<td
																		style="border-top-right-radius: 6px; border-color: #fff;">日数</td>
																</tr>
																<tr>
																	<td>维C</td>
																	<td>维C</td>
																	<td>维C</td>
																	<td>维C</td>
																</tr>
																<tr>
																	<td>维C</td>
																	<td>维C</td>
																	<td>维C</td>
																	<td>维C</td>
																</tr>
																<tr>
																	<td>维C</td>
																	<td>维C</td>
																	<td>维C</td>
																	<td>维C</td>
																</tr>
																<tr>
																	<td>维C</td>
																	<td>维C</td>
																	<td>维C</td>
																	<td>维C</td>
																</tr>
															</table>
														</div>
													</div>
												</div>
											</div> -->
										</form>
									</div>
								</div>
								<!--</div>-->

								<div class='row'>
									<div class="col-lg-10 col-sm-12 text-right">
										<button id="case_form_submit" class="btn btn-warning"
											style="background-color: #ffc300; border-color: #ffc300;">保存</button>
										<a href="#tab-doctor" data-toggle="tab"
											class="btn btn-warning" onclick="openDoctor_advice()"
											style="background-color: #ffc300; border-color: #ffc300;">开医嘱</a>
										<button class="btn btn-warning"
											style="background-color: #ffc300; border-color: #ffc300;">打印</button>
									</div>
								</div>

							</div>

							<!--3、医嘱-->
							<div class="tab-pane fade in" id="tab-doctor">
								<!--<div  style="border: 1px solid #efefef;border-radius: 6px;margin-top: 20px;padding: 10px">-->
								<div class="row" style="margin: 20px 0px 30px 0px">
									<div class="col-lg-10 col-sm-12 text-center"
										style="border: 1px solid #efefef; border-radius: 6px; padding: 15px 5px;">
										<div class="title-inne text-center">
											<!-- <img src="/jeesite/static/Pc/img/patient-infor.png" alt="" style="margin-bottom: 6px;width:21px;"> -->
											<i class="iconfont huanzhexinxi">&#xe60a;</i> <span>患者信息</span>
										</div>
										<div class="title-hr" style="width: 101px;"></div>

										<div class="row text-left font-color75"
											style="margin-top: 20px">
											<input type="hidden" id="patientId_h">
											<div
												class="col-lg-3 col-lg-offset-1 col-sm-4 col-sm-offset-1">
												患者编号： <span id='doc-patientNumber' class='font-color21'></span>
											</div>
											<div class="col-lg-2 col-sm-3">
												姓名：<span id='doc-patientName' class='font-color21'></span>
											</div>
											<div class="col-lg-2 col-sm-2">
												年龄：<span id='doc-patientAge' class='font-color21'></span>
											</div>
											<div class="col-lg-2 col-sm-2">
												性别：<span id='doc-patientSex' class='font-color21'></span>
											</div>
											<div class="col-lg-2 visible-lg">
												挂号类型：<span class='font-color21'>自费</span>
											</div>
										</div>
										<div class="row text-left font-color75"
											style="margin-top: 15px;">
											<div class="col-lg-3 col-sm-4  col-sm-offset-1">
												联系电话：<span id='doc-patientTel' class='font-color21'></span>
											</div>
											<div class="hidden-lg col-sm-3">
												挂号类型：<span class='font-color21'>自费</span>
											</div>
											<div class="col-lg-2 col-sm-2">科室：</div>
											<div class="col-lg-2 col-sm-2">
												医生：${sicmedUserBean.userName}<span class='font-color21'></span>
											</div>
										</div>
										<!--  <div class="row text-left" style="color: #dbdbdb;margin-top:15px;">
                                                <div class="col-sm-2 col-sm-offset-1">过敏药物：<span class='font-color21'></span></div>                                               
                                            </div>
                                            <div class="row text-left" style="color: #dbdbdb;margin-top:15px;">
                                                <div class="col-sm-2 col-sm-offset-1">临床诊断：<span class='font-color21'></span></div>                                               
                                            </div>  -->
									</div>
								</div>
								<!--</div>-->

								<!--<div  style="border: 1px solid #efefef;border-radius: 6px;margin-top: 20px;padding: 10px">-->
								<div class="row" style="margin: 20px 0px 30px 0px">
									<div class="col-lg-10 col-sm-12 text-center"
										style="border: 1px solid #efefef; border-radius: 6px; padding-top: 15px; padding-left: 0px; padding-right: 0px;">
										<div class="title-inne text-center">
											<!-- <img src="/jeesite/static/Pc/img/doctor-list.png" alt="" style="margin-bottom: 6px;width:21px;"> -->
											<i class="iconfont yizhuliebiao">&#xe60d;</i> <span>已开医嘱列表</span>
										</div>
										<div class="title-hr" style="width: 141px;"></div>

										<div style="margin-top: 20px">
											<table
												class="table table-bordered table-striped table-responsive"
												id="tab_doctor">
												<thead></thead>
												<tbody class="font-color21"></tbody>
											</table>
										</div>
										<div class="row">
											<!-- <div class=col-sm-2>
                                            		金额：<span style="color:#ffc300;">19</span> 元
                                            	</div> -->
											<div class="col-sm-10 col-sm-offset-2 text-right"
												style="padding-right: 31px; margin-bottom: 15px;">
												<button id="onekeyPrescription" class="btn"
													data-toggle="modal" data-target="#onekey_prescription"
													style="background: #124256; border-color: #124256; color: #fff;">一键开处方</button>
												<button id="deleteRew" class="btn doctype_bacg">删除选择行</button>

												<!-- 一键开处方 摸态框 -->
												<div class="modal fade  text-left" id="onekey_prescription"
													tabindex="-1" role="dialog"
													aria-labelledby="onekey_prescriptionLabel"
													aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header"
																style="text-align: center; background-color: #ffc300; color: #fff;">
																<!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
																		&times;
																	</button> -->
																<h4 class="modal-title" id="onekey_prescriptionLabel" style="font-size:18px;">一键开处方</h4>
															</div>
															<div class="modal-body">
																<form class="form-horizontal" role="form">
																	<div class="form-group has-feedback">
																		<div class="col-sm-12">
																			<input type="search" class="form-control"
																				placeholder="搜索标准处方"
																				id="search_standardPrescription"> <span
																				class="glyphicon glyphicon-search form-control-feedback"></span>
																		</div>
																	</div>
																</form>
																<ul class="list-group" id="onekey_prescription_list"></ul>
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>
									</div>
								</div>
								<!--</div>-->

								<!-- 搜索医嘱 -->
								<div style="margin-top: 20px; padding: 10px">
									<div class="row">
										<div class="col-lg-10 col-sm-12">
											<div class="row search-doclist-item">
												<div class="col-lg-5 col-sm-4" style="padding-left: 0%">
													<form class="form-horizontal" role="form">
														<div class="form-group" style="margin-bottom: 0%">
															<label class="col-lg-4 col-sm-5 control-label"
																style="color: #fff; padding-top: 0%; text-align: center">搜索/品名</label>
															<div class="col-lg-8 col-sm-7" style="margin-top: 7px;">
																<input type="hidden" id="protuctItem_id"> <input
																	type="search" class="form-control" placeholder="搜索"
																	id="search_productName">
															</div>
														</div>
													</form>
												</div>
												<div class="col-lg-7 col-sm-8 text-right"
													id="btn_protuctItem">
													<span class="margin-right20" style="color: #fff;">类型/</span>
													<!-- <button class="margin-right10 btn doctype_bacg_active">全部</button> -->

													<button class="margin-right10 btn doctype_bacg">检查</button>
													<button class="margin-right10 btn doctype_bacg">检验</button>
													<button class="margin-right10 btn doctype_bacg">治疗</button>
													<button class="btn doctype_bacg">药品</button>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-12" style="padding: 0%">
													<table
														class="table table-bordered table-striped table-responsive font-color21"
														id="table_productItem">
														<thead>
															<tr align="center">
																<td>编码</td>
																<td>类别</td>
																<td>品名</td>
																<td>商品名</td>
																<td>规格</td>
																<td>单位</td>
																<td>产地</td>
																<td>库存</td>
																<td>零售价</td>
																<td>收费项目</td>
																<td>拆零比</td>
																<td>最小单位</td>
															</tr>
															<tr align="center" id="doc_tableSecTr">
																<td>-</td>
																<td>-</td>
																<td>-</td>
																<td>-</td>
																<td>-</td>
																<td>-</td>
																<td>-</td>
																<td>-</td>
																<td>-</td>
																<td>-</td>
																<td>-</td>
																<td>-</td>
															</tr>
														</thead>
														<tbody></tbody>
													</table>
												</div>
											</div>

											<!-- <div class="row">
                                            	<div class="col-sm-10 col-sm-offset-2 text-right">
                                            		<button class="btn btn-warning" style="background-color: #ffc300;border-color:#ffc300;">保存处方</button>
                                            		<button class="btn btn-warning" style="background-color: #ffc300;border-color:#ffc300;">关闭</button>
                                            	</div>
                                            </div> -->
											<!-- 分页 -->
											<div class="row" id="separate_pageNumber">
												<div class="col-sm-12 text-right">
													<nav>
													<ul class="pagination ">
														<li id="previous_page"><a href="#">上一页</a></li>
														<li id="page_now" class="active"><a href="">1</a></li>
														<li id="next_page"><a href="#">下一页</a></li>
													</ul>
													</nav>
												</div>
											</div>
										</div>
									</div>

									<!-- 医嘱下的药品用法弹出框 -->
									<div class="modal fade" id="myModal" tabindex="-1"
										role="dialog" aria-labelledby="myModalLabel"
										aria-hidden="true">
										<div class="modal-dialog">
											<div class="modal-content">
												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal">
														<span aria-hidden="true">&times;</span><span
															class="sr-only">Close</span>
													</button>
													<h4 class="modal-title text-center" id="myModalLabel1">添加药品</h4>
												</div>
												<div class="modal-body">
													<form class="form form-horizontal" role="form"
														id="doctorMedicalModel_form">
														<div class="form-group">
															<label class="col-sm-2 control-label">药品名</label>
															<div class="col-sm-9">
																<input type="text" class="form-control"
																	id="addDoctor_medicalName" readonly>
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-2 control-label">剂型</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="useBun"
																	readonly="">
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-2 control-label">单位</label>
															<div class="col-sm-9">
																<input type="text" class="form-control" name="useUnit"
																	id="addDoctor_medicalComp" readonly>
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-2 control-label">给药途径</label>
															<div class="col-sm-9">
																<select name="useGroup" class="form-control">
																	<option value="口服">口服</option>
																	<option value="舌下给药">舌下给药</option>
																	<option value="直肠给药">直肠给药</option>
																	<option value="静脉滴注">静脉滴注</option>
																	<option value="饭后服用">饭后服用</option>
																	<option value="肌内注射">肌内注射</option>
																	<option value="皮下注射">皮下注射</option>
																	<option value="滴眼">滴眼</option>
																	<option value="鼻腔喷雾">鼻腔喷雾</option>
																	<option value="口腔喷雾">口腔喷雾</option>
																	<option value="皮肤局部(表面)用药">皮肤局部(表面)用药</option>
																	<option value="身(经皮)用药">身(经皮)用药</option>
																</select>
															</div>
														</div>
														<div class="form-group">
															<label class="col-sm-2 control-label">用药频次</label>
															<div class="col-sm-7">
																<input type="number" class="form-control" name="useBout">
															</div>
															<span class="col-sm-2">次</span>
														</div>
														<div class="form-group">
															<label class="col-sm-2 control-label">单次剂量</label>
															<div class="col-sm-7">
																<input type="number" class="form-control"
																	name="useAmount">
															</div>
															<span class="col-sm-2" id="singleMeasurement"></span>
														</div>
														<div class="form-group" style="margin-bottom: 30px;">
															<label class="col-sm-2 control-label">用药天数</label>
															<div class="col-sm-7">
																<input type="number" class="form-control" name="useDay">
															</div>
															<span class="col-sm-2">日</span>
														</div>
														<div class="form-group">
															<div class="col-sm-offset-3 col-sm-3 text-center">
																<button type="button" id="savePrescription"
																	class="btn btn-default"
																	style="background-color: #ffc300; border-color: #ffc300; color: #fff;">保存处方</button>
															</div>
															<div class="col-sm-3 text-center">
																<button type="button" data-dismiss="modal"
																	class="btn btn-default"
																	style="background-color: #ffc300; border-color: #ffc300; color: #fff;">关闭</button>
															</div>
														</div>
													</form>
												</div>
												<!-- <div class="modal-footer">
									        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									        <button type="button" class="btn btn-default" data-dismiss="modal">保存处方</button>
									      </div> -->
											</div>
										</div>
									</div>

									<!-- 药品用法model -->
									<!-- <div id="doctorMedical_model" style="display:none;width:500px;height:418px;background:#fff; border-radius:6px;box-shadow:0px 2px 10px 0px; position:fixed;top:50%;left:50%;z-index:100000;margin-top:-209px;margin-left:-250px;">
			                        	<div style="height:56px;line-height:56px;text-align:center;background-color:#ffc300;color:#fff;font-size:18px;">
			                        		添加药品
			                        	</div>
			                        	<div style="margin:10px;margin-right:40px;color:#757575;">
			                        		<form class="form-horizontal" role="form" id="doctorMedicalModel_form">
			                        		 <div class="form-group">
											    <label class="col-sm-3 control-label">药品名</label>
											    <div class="col-sm-9">
											      <input type="text" class="form-control" id="addDoctor_medicalName" readonly>
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="inputPassword3" class="col-sm-3 control-label">商品名称</label>
											    <div class="col-sm-9">
											      <input type="text" class="form-control" id="inputPassword3">
											    </div>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">规格</label>
											    <div class="col-sm-9">
											      <input type="text" class="form-control" id="addDoctor_medicalSpec" readonly>
											    </div>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">单位</label>
											    <div class="col-sm-9">
											      <input type="text" class="form-control" name="useUnit" id="addDoctor_medicalComp" readonly>
											    </div>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">给药途径</label>
											    <div class="col-sm-9">
											      <select name="useGroup" class="selectpicker" style="width:100%;height:32px;">
											      		<option value="口服">口服</option>
														<option value="舌下给药">舌下给药</option>
														<option value="直肠给药">直肠给药</option>
														<option value="静脉滴注">静脉滴注</option>
														<option value="饭后服用">饭后服用</option>
														<option value="肌内注射">肌内注射</option>
														<option value="皮下注射">皮下注射</option>
														<option value="滴眼">滴眼</option>
														<option value="鼻腔喷雾">鼻腔喷雾</option>
														<option value="口腔喷雾">口腔喷雾</option>
														<option value="皮肤局部(表面)用药">皮肤局部(表面)用药</option>
														<option value="身(经皮)用药">身(经皮)用药</option>
												  </select>
											    </div>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">用药频次</label>
											    <div class="col-sm-7">
											      <input type="number" class="form-control"  name="useBout">
											    </div>
											    <span class="col-sm-2">次</span>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">单次剂量</label>
											    <div class="col-sm-7">
											      <input type="number" class="form-control" name="useAmount">
											    </div>
											    <span class="col-sm-2" id="singleMeasurement"></span>
											  </div>
											  <div class="form-group" style="margin-bottom:30px;">
											    <label class="col-sm-3 control-label">用药天数</label>
											    <div class="col-sm-7">
											      <input type="number" class="form-control" name="useDay">
											    </div>
											    <span class="col-sm-2">日</span>
											  </div>
											  
											  <div class="form-group">
											    <div class="col-sm-offset-3 col-sm-4 text-center">
											      <button type="button" id="savePrescription" class="btn btn-default" style="background-color:#ffc300;border-color:#ffc300;color:#fff;">保存处方</button>
											    </div>
											    <div class="col-sm-4">
											      <button id="close_doctorMedicalModel" type="button" class="btn btn-default" style="background-color:#ffc300;border-color:#ffc300;color:#fff;">关闭</button>
											    </div>
											  </div>
			                        		</form>
			                        	</div>
			                        </div> -->
								</div>
							</div>
						</div>
					</div>


					<!--标准处方-->
					<div class="tab-pane fade" id="tab2">
						<form class="form-horizontal" role="form">
							<div class="form-group has-feedback">
								<label class="col-lg-2 col-sm-2 control-label"
									style="text-align: left;"> 标准处方名称 </label>
								<div class="col-sm-4" style="padding-left: 0px;">
									<input type="search" class="form-control"
										id="standPrescription_name" placeholder="请输入标准处方名称">
									<!-- <input type="hidden" id="standPrescription_id"> -->
									<input type="hidden" id="exi_standPrescription">
									<!-- <span class="glyphicon glyphicon-search form-control-feedback"></span> -->
								</div>
								<div class="col-sm-2">
									<button id="query_historyStandPrescription" type="button"
										class="btn btn-default"
										style="background-color: #ffc300; color: #fff; border-color: #ffc300; font-size: 12px; padding: 7px 12px;">
										查询历史标准处方</button>
								</div>
							</div>
							<div class="form-group has-feedback">
								<label class="col-lg-2 col-sm-2 control-label"
									style="text-align: left;">对应病症</label>
								<div class="col-sm-4" style="padding-left: 0px;" id="dyzz_id">
									<input type="hidden" id="disease_item_id">
									<!-- <input type="search" class="form-control" id="disease_item_name"> -->
									<div class="panel panel-default">
										<div class="panel-body" id="alert-panel"
											style="padding-top: 7px; padding-bottom: 7px;">
											<p style="margin-bottom: 0px; color: #999;">点击添加对应病症</p>
											<!-- 对应症状下拉菜单 -->
											<div id="stand_disease_model"
												style="display: none; position: absolute; left: 0px; top: 37px; z-index: 100; padding: 10px; background-color: #efefef; border-radius: 6px;">
												<input type="search" class="form-control"
													id="disease_item_name">
												<!-- <span class="glyphicon glyphicon-search form-control-feedback" style="color:#bdbdbd;right:8px;top:11px;"></span> -->
												<span class="iconfont sousuo form-control-feedback"
													style="font-size: 16px; right: 8px; top: 11px;">&#xe607;</span>
												<ul class="list-group" id="search_standDisease_ul"
													style="margin-bottom: 0px; overflow-y: auto;"></ul>
												<!-- <button type="button" id="stand_seeMore_preliminaryDiagnosis" class="btn btn-primary" style="float:right;margin-right:104px;background-color: rgb(57, 160, 237); border-color: rgb(57, 160, 237);">
						                                                                                      查看更多...
						                        </button> -->
											</div>
										</div>
									</div>
								</div>
								<div class="col-sm-2">
									<button type="button" id="preservation_standSrescription"
										class="btn btn-default"
										style="background-color: #ffc300; color: #fff; border-color: #ffc300; font-size: 12px; padding: 7px 20chufpx;">保存</button>
								</div>
							</div>
						</form>

						<!-- 历史标准处方 model -->
						<div id="history_standPrescription"
							style="display: none; width: 250px; background: #efefef; border-radius: 6px; position: absolute; top: 70px; left: 51%; z-index: 100;">
							<div class="form-group has-feedback"
								style="padding: 0px 10px; margin-top: 10px; margin-bottom: 5px;">
								<span class="glyphicon glyphicon-search form-control-feedback"
									style="right: 8px; color: #bdbdbd;"></span> <input
									type="search" class="form-control"
									id="search_historyStandPrescription"
									style="border-radius: 6px;">
							</div>
							<ul class="list-group" id="historyStandPrescription_list"
								style="height: 251px; overflow-y: scroll; padding-left: 6px; margin-bottom: 0px;"></ul>
						</div>

						<!-- 对应症状下拉菜单 -->
						<!-- <div style="margin-top:-15px; display:none;position:absolute;left:18%;;z-index:100;width:38%;height:50px;overflow-y:scroll;overflow-x:hidden;background-color:#efefef;" id="stand_disease_model">                      
                      		<form class="form-horizontal" role="form">
               					<div class="form-group has-feedback">
                                    <input type="search" class="form-control" placeholder="搜索" id="search_standDisease" style="margin-left:30px;margin-top:10px;">
                                    <span class="glyphicon glyphicon-search form-control-feedback" style="margin-top:10px;"></span>
                            	</div>
               				</form>
               				<div style="margin-left:0px;margin-right:0px;">
               					<ul class="list-group" id="search_standDisease_ul"></ul>
               				</div>
                        </div>  -->

						<!--<div style="border: 1px solid #efefef;border-radius: 6px;margin-top: 20px;padding: 10px">-->
						<div class="row" style="margin: 20px 0px 30px 0px">
							<div class="col-lg-10 col-sm-12 text-center"
								style="border: 1px solid #efefef; border-radius: 6px; padding: 15px 0px">
								<div class="title-inne text-center">
									<!-- <img src="/jeesite/static/Pc/img/doctor-list.png" alt="" style="margin-bottom: 6px;width:21px;"> -->
									<i class="iconfont yizhuliebiao">&#xe60d;</i> <span>标准处方下的医嘱</span>
								</div>
								<div class="title-hr" style="width: 176px;"></div>

								<div style="margin-top: 20px;">
									<table cellpadding="0"
										class="table table-bordered table-striped"
										id="standPrescription_doctor">
										<thead>
											<tr align="center" class='doctor-list-th'>
												<!-- <td style="border-left:none;">序号</td> -->
												<td style="border-left: none;">组</td>
												<td>品名</td>
												<td>规格</td>
												<td>总数</td>
												<td>给药途径</td>
												<td>用药频次</td>
												<td>单次计量</td>
												<td>计量单位</td>
												<td>单位</td>
												<td>天数</td>
												<td style="border-right: none;">执行科室</td>
											</tr>
											<tr align="center" id="thead_secondTr" style="height: 50px;">
												<td style="border-left: none;">-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td>-</td>
												<td style="border-right: none;">-</td>
											</tr>
										</thead>
										<tbody></tbody>
									</table>
								</div>
								<div class="row">
									<!-- <div class=col-sm-2>
                                        	金额：<span style="color:#ffc300;">19</span> 元
                                        </div> -->
									<div class="col-sm-offset-2 col-sm-10 text-right"
										style="padding-right: 31px;">
										<!-- <button id="onekeyPrescription" class="btn btn-primary" data-toggle="modal" data-target="#onekey_prescription">一键开处方</button> -->
										<button id="deleteStandardPresriptionRew"
											class="btn doctype_bacg">删除选择行</button>
									</div>
								</div>

								<!-- 标准处方下的药品用法弹出框 -->
								<div class="modal fade" id="myModal2" tabindex="-1"
									role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">
													<span aria-hidden="true">&times;</span><span
														class="sr-only">Close</span>
												</button>
												<h4 class="modal-title text-center" id="myModalLabel2">添加药品</h4>
											</div>
											<div class="modal-body">
												<form class="form-horizontal" role="form"
													id="doctorMedicalModel_standform">
													<div class="form-group">
														<label class="col-sm-2 control-label">药品名</label>
														<div class="col-sm-9">
															<input type="text" class="form-control"
																id="medicalProductName_standard" readonly>
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-2 control-label">剂型</label>
														<div class="col-sm-9">
															<input type="text" class="form-control"
																id="medicalProductName_useBun" name="useBun" readonly>
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-2 control-label">单位</label>
														<div class="col-sm-9">
															<input type="text" class="form-control" name="useUnit"
																id="medicalCompany_standard" readonly>
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-2 control-label">给药途径</label>
														<div class="col-sm-9">
															<select name="useGroup" class="form-control selectpicker">
																<option value="口服">口服</option>
																<option value="舌下给药">舌下给药</option>
																<option value="直肠给药">直肠给药</option>
																<option value="静脉滴注">静脉滴注</option>
																<option value="饭后服用">饭后服用</option>
																<option value="肌内注射">肌内注射</option>
																<option value="皮下注射">皮下注射</option>
																<option value="滴眼">滴眼</option>
																<option value="鼻腔喷雾">鼻腔喷雾</option>
																<option value="口腔喷雾">口腔喷雾</option>
																<option value="皮肤局部(表面)用药">皮肤局部(表面)用药</option>
																<option value="身(经皮)用药">身(经皮)用药</option>
															</select>
														</div>
													</div>
													<div class="form-group">
														<label class="col-sm-2 control-label">用药频次</label>
														<div class="col-sm-7">
															<input type="number" class="form-control" name="useBout">
														</div>
														<span class="col-sm-2">次</span>
													</div>
													<div class="form-group">
														<label class="col-sm-2 control-label">单次剂量</label>
														<div class="col-sm-7">
															<input type="number" class="form-control"
																name="useAmount">
														</div>
														<span class="col-sm-2" id="stand_singleMeasurement"></span>
													</div>
													<div class="form-group" style="margin-bottom: 30px;">
														<label class="col-sm-2 control-label">用药天数</label>
														<div class="col-sm-7">
															<input type="number" class="form-control" name="useDay">
														</div>
														<span class="col-sm-2">日</span>
													</div>
													<div class="form-group">
														<div class="col-sm-offset-3 col-sm-3 text-center">
															<button type="button" id="savePrescriptionStand"
																class="btn btn-default"
																style="background-color: #ffc300; border-color: #ffc300; color: #fff;">保存处方</button>
														</div>
														<div class="col-sm-3">
															<button type="button" class="btn btn-default"
																data-dismiss="modal"
																style="background-color: #ffc300; border-color: #ffc300; color: #fff;">关闭</button>
														</div>
													</div>
												</form>
											</div>
											<!-- <div class="modal-footer">
									        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
									        <button type="button" class="btn btn-default" data-dismiss="modal">保存处方</button>
									      </div> -->
										</div>
									</div>
								</div>

								<!-- 标准处方 => 添加药品用法model -->
								<!-- <div id="medicalUse_model" style="display:none;width:500px;height:456px;background:#fff; border-radius:6px;box-shadow:0px 2px 10px 0px; position:fixed;top:50%;left:50%;z-index:100000;margin-top:-253px;margin-left:-250px;">
			                        	<div style="height:56px;line-height:56px;text-align:center;background-color:#ffc300;color:#fff;font-size:18px;">
			                        		添加药品
			                        	</div>
			                        	<div style="margin:10px;margin-right:40px;color:#757575;">
			                        		<form class="form-horizontal" role="form" id="doctorMedicalModel_standform">
			                        		 <div class="form-group">
											    <label class="col-sm-3 control-label">药品名</label>
											    <div class="col-sm-9">
											      <input type="text" class="form-control" id="medicalProductName_standard" readonly>
											    </div>
											  </div>
											  <div class="form-group">
											    <label for="inputPassword3" class="col-sm-3 control-label">商品名称</label>
											    <div class="col-sm-9">
											      <input type="text" class="form-control" id="inputPassword3">
											    </div>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">规格</label>
											    <div class="col-sm-9">
											      <input type="text" class="form-control" id="addDoctor_medicalSpec" readonly>
											    </div>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">剂型</label>
											    <div class="col-sm-9">
											      <input type="text" class="form-control" name="useBun" id="medicalDosage_standard" readonly>
											    </div>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">单位</label>
											    <div class="col-sm-9">
											      <input type="text" class="form-control" name="useUnit" id="medicalCompany_standard" readonly>
											    </div>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">给药途径</label>
											    <div class="col-sm-9">
											      <select name="useGroup" class="form-control selectpicker" style="width:100%;height:32px;">
											      		<option value="口服">口服</option>
														<option value="舌下给药">舌下给药</option>
														<option value="直肠给药">直肠给药</option>
														<option value="静脉滴注">静脉滴注</option>
														<option value="饭后服用">饭后服用</option>
														<option value="肌内注射">肌内注射</option>
														<option value="皮下注射">皮下注射</option>
														<option value="滴眼">滴眼</option>
														<option value="鼻腔喷雾">鼻腔喷雾</option>
														<option value="口腔喷雾">口腔喷雾</option>
														<option value="皮肤局部(表面)用药">皮肤局部(表面)用药</option>
														<option value="身(经皮)用药">身(经皮)用药</option>
												  </select>
											    </div>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">用药频次</label>
											    <div class="col-sm-7">
											      <input type="number" class="form-control"  name="useBout">
											    </div>
											    <span class="col-sm-2">次</span>
											  </div>
											  <div class="form-group">
											    <label class="col-sm-3 control-label">单次剂量</label>
											    <div class="col-sm-7">
											      <input type="number" class="form-control" name="useAmount">
											    </div>
											    <span class="col-sm-2" id="stand_singleMeasurement"></span>
											  </div>
											  <div class="form-group" style="margin-bottom:30px;">
											    <label class="col-sm-3 control-label">用药天数</label>
											    <div class="col-sm-7">
											      <input type="number" class="form-control" name="useDay">
											    </div>
											    <span class="col-sm-2">日</span>
											  </div>
											  
											  <div class="form-group">
											    <div class="col-sm-offset-3 col-sm-4 text-center">
											      <button type="button" id="savePrescriptionStand" class="btn btn-default" style="background-color:#ffc300;border-color:#ffc300;color:#fff;">保存处方</button>
											    </div>
											    <div class="col-sm-4">
											      <button id="close_medicalModel" type="button" class="btn btn-default" style="background-color:#ffc300;border-color:#ffc300;color:#fff;">关闭</button>
											    </div>
											  </div>
			                        		</form>
			                        	</div>
			                        </div>	 -->
							</div>
						</div>
						<!--</div>-->


						<!-- 搜索标准处方下的医嘱 -->
						<div style="margin-top: 20px; padding: 10px">
							<div class="row">
								<div class="col-lg-10 col-sm-12">
									<div class="row search-doclist-item">
										<div class="col-lg-5 col-sm-4" style="padding-left: 0%;">
											<form class="form-horizontal" role="form">
												<div class="form-group" style="margin-bottom: 0%;">
													<label class="col-lg-4 col-sm-5 control-label"
														style="color: #fff; padding-top: 0%; text-align: center;">搜索/品名</label>
													<div class="col-lg-8 col-sm-7" style="margin-top: 7px;">
														<input type="hidden" id="stand_protuctItem_id"> <input
															type="search" class="form-control" placeholder="搜索"
															id="search_standProductName">
													</div>
												</div>
											</form>
										</div>
										<div class="col-lg-7 col-sm-8 text-right"
											id="btn_standProtuctItem">
											<span class="margin-right20" style="color: #fff;">类型/</span>
											<!-- <button class="margin-right10 btn doctype_bacg_active">全部</button> -->

											<button class="margin-right10 btn doctype_bacg">检查</button>
											<button class="margin-right10 btn doctype_bacg">检验</button>
											<button class="margin-right10 btn doctype_bacg">治疗</button>
											<button class="btn doctype_bacg">药品</button>
										</div>
									</div>
									<div class="row">
										<div class="col-sm-12" style="padding: 0%">
											<table
												class="table table-bordered table-striped table-responsive"
												id="table_standProductItem">
												<thead>
													<tr style="text-align: center">
														<td>编码</td>
														<td>类别</td>
														<td>品名</td>
														<td>商品名</td>
														<td>规格</td>
														<td>单位</td>
														<td>产地</td>
														<td>库存</td>
														<td>零售价</td>
														<td>收费项目</td>
														<td>拆零比</td>
														<td>最小单位</td>
													</tr>
													<tr style="text-align: center" id="std_tableSecTr">
														<td>-</td>
														<td>-</td>
														<td>-</td>
														<td>-</td>
														<td>-</td>
														<td>-</td>
														<td>-</td>
														<td>-</td>
														<td>-</td>
														<td>-</td>
														<td>-</td>
														<td>-</td>
													</tr>
												</thead>
												<tbody></tbody>
											</table>
										</div>
									</div>

									<!-- 分页 -->
									<div class="row" id="separate_pageNumber_standard">
										<div class="col-sm-12 text-right">
											<nav>
											<ul class="pagination">
												<li id="previous_page_standard"><a href="#">上一页</a></li>
												<li id="page_now_standard" class="active"><a href="">1</a></li>
												<li id="next_page_standard"><a href="#">下一页</a></li>
											</ul>
											</nav>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<!--诊疗记录-->
					<div class="tab-pane fade" id="tab3">
						<div class="row">
							<div class="col-lg-3 col-sm-4 col-sm-offset-1">
								<!--  <div class="row">
                                    <div class="col-sm-4 text-right" style="color: #212121;">开始日期</div>
                                    <div class="col-sm-7">
                                        <p style="background:#ffffff;border:1px solid #efefef;border-radius:6px;width:152px;height:26px;line-height: 26px; text-align: center">
                                            2016-06-28 09:00
                                        </p>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-4 text-right" style="color: #212121;">结束日期</div>
                                    <div class="col-sm-5"><p style="background:#ffffff;border:1px solid #efefef;border-radius:6px;width:152px;height:26px;line-height: 26px; text-align: center">
                                        2016-06-28 09:00
                                    </p></div>
                                </div> -->
								<span class="patient_info_head"
									style="font-family: STHeitiSC-Medium; font-size: 14px; color: #bdbdbd; letter-spacing: 0px; margin-top: 8px;">开始日期:</span>&nbsp;&nbsp;&nbsp;&nbsp;
								<input readonly="readonly" placeholder="请选择"
									class="datainp dateInput" id="beginDate" type="text"
									onClick="jeDate({dateCell:'#beginDate',isTime:true,maxDate: jeDate.now(0),format:'YYYY-MM-DD hh:mm:ss'})"><br>
								<br> <span class="patient_info_head"
									style="font-family: STHeitiSC-Medium; font-size: 14px; color: #bdbdbd; letter-spacing: 0px; margin-top: 30px;">结束日期:</span>&nbsp;&nbsp;&nbsp;&nbsp;
								<input readonly="readonly" placeholder="请选择"
									style="margin-top: 0px;" class="datainp dateInput" id="endDate"
									type="text"
									onClick="jeDate({dateCell:'#endDate',maxDate: jeDate.now(0),isTime:true,format:'YYYY-MM-DD hh:mm:ss'})">
							</div>
							<div class="col-lg-2 col-sm-2">
								<button id="getCaseHistory_b"
									style="margin: auto; background: #ffffff; border: 1px solid #124256; border-radius: 6px; width: 78px; height: 70px; line-height: 70px; text-align: center; color: #124256; font-weight: bold;">开始统计</button>
							</div>
							<div class="col-lg-3 col-sm-4">
								<div class="row">
									<div class="col-sm-4 text-right" style="color: #212121;">总记录数</div>
									<div class="col-sm-5">
										<p id="total_No"
											style="background: #ffffff; border: 1px solid #efefef; border-radius: 6px; width: 110px; height: 26px; line-height: 26px; text-align: center; margin: auto">
											</p>
									</div>
									<div class="col-sm-1">人</div>
								</div>
							</div>
						</div>
						<div style="margin-top: 20px" class="row">
							<div class="col-lg-10 col-lg-12">
								<table class="table table-striped table-responsive table-bordered" id="diagnosis_records">
									<thead>
										<tr style="background-color: #124256; color: #fff;"
											align="center">
											<td style="border-top-left-radius: 6px;">患者编号</td>
											<td>姓名</td>
											<td>年龄</td>
											<td>性别</td>
											<td>挂号科室</td>
											<td>就诊日期</td>
											<!-- <td>状态</td> -->
											<td style="border-top-right-radius: 6px">操作</td>
										</tr>
									</thead>
									<tbody></tbody>
									<!-- <tbody style="color: #212121;">
										<tr align="center">
											<td>001</td>
											<td>张师傅</td>
											<td>27</td>
											<td>男</td>
											<td>皮肤科</td>
											<td>2016-09-03</td>
											<td>已挂号</td>
											<td><a href="" class="btn btn-warning"
												style="background-color: #ffc300; border-color: #ffc300;">查看</a>
											</td>
										</tr>
									</tbody> -->
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 页脚 -->
	<!-- <div id="footer" class="container-fluid" style="padding-left:0px;padding-right:0px;margin-top:50px;">
		<nav class="navbar navbar-default" style="margin-bottom:0px;background:#3cc5de;height:100px;">
			 <div class="navbar-inner navbar-content-center" style="color:#fff;">
			       <p class="text-muted credit text-center" style="padding: 10px;color:#fff;padding-top:20px;margin-bottom:0px;">
			                               电话：<span style="font-size:20px;">400-600-800</span>   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 地址：北京市丰台区汉威国际广场2号楼7M层                     
			       </p>
			        <p class="text-center">安智云（北京）科技有限公司</p>
			 </div>
		</nav>
	</div> -->
</body>

<script src="/jeesite/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>
<script type="text/javascript" src="/jeesite/static/Pc/jedate/jedate.js"></script>
<!-- <script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js" type="text/javascript"></script> -->

<!-- 引入弹窗插件bootbox.js -->
<script src="/jeesite/static/Pc/js/bootbox.min.js" type="text/javascript"></script>

<script>
	<!-- 开始工作 -->
    $(document).ready(function () {
    	// 判断当前设备是移动端还是电脑端
    	function browserRedirect() {
    	      var sUserAgent = navigator.userAgent.toLowerCase();
    	      var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    	      var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    	      var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    	      var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    	      var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    	      var bIsAndroid = sUserAgent.match(/android/i) == "android";
    	      var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    	      var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    	      if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) {
    	    	  // textarea获取焦点时键盘挡住输入框
    	    	  $("#case_form").delegate('textarea','focus',function(e){
    	      		var elemTop = $(e.target).offset().top-150;
    	      		$('body,html').animate({scrollTop:elemTop}, 2);
    	      	})
    	      } else {
    	        console.log("pc");
    	      }
    	    }
    	    browserRedirect();
    	    
    	// textarea 禁止拖拽改变大小
    	$.each($("#case_form textarea"),function(index,val){
    		$(val).css('resize','none');
    	});
    	
    	/* textarea自适应高度 */
    	autosize(document.querySelectorAll('textarea'));
    	
    	
    	/* ============================================================ */
    	var content_rightHeight = $("#content_right").height();
    	var documentHeight = $(window).height()-80;
    	$("#content_left").height(documentHeight)
    	
    	$(window).scroll(function(event){
    		var content_rightHeight = $("#content_right").height();
    		if(content_rightHeight > documentHeight){
    			$("#content_left").height(content_rightHeight)
    		}else{
    			$("#content_left").height(documentHeight)
    		}
        });
    	
    	
        /**==== 开始工作、标准处方、诊疗记录 Tabs ====**/
        $('#myTab li').click(function () {
        	$(this).addClass("lf_actives");
        	$(this).siblings("li").removeClass("lf_actives")
        	
        });
        
        /**==== 患者列表、病历、医嘱 Tabs ====**/
        $('#tab1 .tab-a a').click(function (e) {
            e.preventDefault();
            if(tab_blean == true){
            	$('#tab1 .tab-a a').css({"color":"#212121","background-color":"#fff","border-color":"#bdbdbd"});
            	$(this).css({"color":"#fff","background-color":"#124256","border-color":"#124256"});
            }
        });
        
        
        
	   // 患者编号搜索框的显示和隐藏			        
	   $("#openWork_tab1").click(function(){
		   $("#serPatientList").show()
	   })
	   $("#openWork_tab2").click(function(){
		   $("#serPatientList").hide()
	   })
	   $("#openWork_tab3").click(function(){
		   $("#serPatientList").hide()
	   })
        
        
        // 开始工作-默认患者列表 
    	var pageNo;
    	var patient_datalength;
    	pageNo = 1
        getPatientList(pageNo);
        
        function getPatientList(){
            $.ajax({
                type : 'get',
                url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedRegistered/findShow',
                data : "ssid=${sicmedUserBean.ssid}&pageNo="+pageNo,
                cache : false,
                dataType : 'json',
                success : function(data) {
                	     		console.log(data);
                	/*
                		json字符串转json对象：jQuery.parseJSON(jsonStr);
						json对象转json字符串：JSON.stringify(jsonObj);
                	*/
                    //	var a = JSON.stringify(data);//jsonObj 转 jsonStr
                    
                    $.each(data,function(name, value) {
                    	patient_datalength = data.sicmedPatientBeans.length;
                        $("#tab_price_patient tbody").children().remove();
                        
                        if(patient_datalength != 20){
                      		$("#pagination_openwork").remove()
                      	}
                        
                        if (name == "sicmedPatientBeans") {
                            $.each(value,function(name2,value2) {
                                var a = name2
                                if(a%2==0){
                                	// 对返回的数据为undefined的处理
                                	if(value2.patientTel == undefined || value2.patientCard == undefined){
                                		value2.patientTel = "未填写"
                                		value2.patientCard = "未填写"
                                	}
                                    $("#tab_price_patient").append("<tr align='center'>"
                                            +"<td align='center'>"+value2.patientNumber+"</td>"
                                            +"<td align='center'>"+value2.patientName+"</td>"
                                            +"<td>"+value2.patientAge+"</td>"
                                            +"<td>"+value2.patientSex+"</td>"
                                            +"<td>"+value2.patientFirstdate+"</td>"
                                            +"<td>"+value2.patientTel+"</td>"
                                            +"<td style='padding-top:6px;'><a href='#tab-medical' data-toggle='tab' id="+value2.id+ " style='background-color:#ffc107;border-color:#ffc107;box-shadow:0px 2px 10px 0px rgba(0, 0, 0, 0 , 50);padding:4px 16px;' class='btn btn-warning' onclick='getYesByPatient(this.id)'>病历</button></td>"
                                            +"</tr>");
                                }else{
                                	// 对返回的数据为undefined的处理
                                	if(value2.patientTel == undefined || value2.patientCard == undefined){
                                		value2.patientTel = "未填写"
                                		value2.patientCard = "未填写"
                                	}
                                    $("#tab_price_patient").append("<tr align='center'>"
                                            +"<td align='center'>"+value2.patientNumber+"</td>"
                                            +"<td align='center'>"+value2.patientName+"</td>"
                                            +"<td>"+value2.patientAge+"</td>"
                                            +"<td>"+value2.patientSex+"</td>"
                                            +"<td>"+value2.patientFirstdate+"</td>"
                                            +"<td>"+value2.patientTel+"</td>"
                                            +"<td style='padding-top:6px;'><a href='#tab-medical' data-toggle='tab' id="+value2.id+ " style='background-color:#ffc107;border-color:#ffc107;box-shadow:0px 2px 10px 0px rgba(0, 0, 0, 0 , 50);padding:4px 16px;' class='btn btn-warning' onclick='getYesByPatient(this.id)'>病历</button></td>"
                                            +"</tr>");
                                }
                            });
                        }
                    });                
                },
                error : function() {
                    alert("请求出错");
                }
            });

        }
      	
      	
      	// 患者列表 分页
      	// 上一页
      	$("#prevpage_patientlist").click(function(e){
      		if(pageNo > 1){
      			pageNo --;
          		getPatientList(pageNo);
          		$("#currentpage_patientlist a").html(pageNo)
      		}
      		e.preventDefault();
      	})
      	
      	// 下一页
      	$("#nextpage_patientlist").click(function(e){
      		if(patient_datalength == 20){
      			pageNo ++;
        		getPatientList(pageNo);
        		$("#currentpage_patientlist a").html(pageNo)
      		}
      		e.preventDefault();
      	})
      	
    });
    
    
    
    // 病历
    var tab_blean = false;
	function getYesByPatient(id){
		tab_blean = true;
		
		// 根据患者编号搜索患者
		$("#serPatientList").hide();
		
		
		$('#tab1 .tab-a a').css({'background-color':'#fff','color':'#212121','border-color':'#bdbdbd'});
		$('#tab1 .tab-a a:eq(1)').css({'background-color':'#124256','color':'#fff','border-color':'#124256','cursor':'pointer'});
		$('#tab1 .tab-a a:eq(2)').css({'cursor':'pointer'});
        
		$("#openWork_tab2").attr('href','#tab-medical');
		$("#openWork_tab3").attr('href','#tab-doctor');
		
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedCase/getByPatient',
			data : "ssid=${sicmedUserBean.ssid}&patientId="+id,
			cache : false,
			dataType : 'json',
			success : function(data) {
						console.log(data);
						
						/** 初步诊断信息  **/
						// 保存单个字的宽度
						var fontWidth = 14;
						$("#preliminaryDiagnosis_list").children().remove();
						if(data.sicmedPatientDiseaseBeans){
							$.each(data.sicmedPatientDiseaseBeans , function(index,val){
								/* a.replace(/,/g,''); */
								var charactersNumber = val.diseaseName.length;
								
								var preliminaryDiagnosisItem_width = fontWidth*charactersNumber+35;
								var preliminaryDiagnosisItem_span_width = preliminaryDiagnosisItem_width+18;
								$("#preliminaryDiagnosis_list").append(
										"<li style='width:"+preliminaryDiagnosisItem_width+"px;'>"+val.diseaseName+"&nbsp;<span id="+val.id+" onclick='deletePreliminaryDiagnosis(this.id)' style='position:absolute;left:"+preliminaryDiagnosisItem_span_width+";cursor:pointer;font-size:14px;' class='iconfont shanchu'>&#xe60e;</span></li>")	
							})
						}
						
						$("#preliminaryDiagnosis_list").append("<li style='background-color:#fff;'><span data-toggle='modal' data-target='#preliminaryDiagnosis_Modal' id='addPreliminaryDiagnosis' class='iconfont tianjia'>&#xe613;</span></li>")
						
						$.each(data,function(name, value) {
							//病历信息显示赋值 
							$("#caseTell").val(data.caseTell)
							$("#caseHistory").val(data.caseHistory)
							$("#pastHistory").val(data.pastHistory)
							$("#caseAllergy").val(data.caseAllergy)
							$("#familyAllergy").val(data.familyAllergy)
							$("#checkCodeBody").val(data.checkCodeBody)
							$("#checkCodeAid").val(data.checkCodeAid)
							$("#checkCodeBody").val(data.checkCodeBody)
							
							//病历信息隐藏域赋值
							$("#caseId_h").val(data.id) //病历id
							
							$("#caseTell_h").val(data.caseTell)
							$("#caseHistory_h").val(data.caseHistory)
							$("#pastHistory_h").val(data.pastHistory)
							$("#caseAllergy_h").val(data.caseAllergy)
							$("#familyAllergy_h").val(data.familyAllergy)
							$("#checkCodeBody_h").val(data.checkCodeBody)
							$("#checkCodeAid_h").val(data.checkCodeAid)
							
							//患者信息赋值
							if (name == "sicmedPatientBean") {
								//患者id
								$("#patientId_h").val(value.id)
								
								$("#patientAge").html(value.patientAge)
								$("#patientName").html(value.patientName)
								$("#patientNumber").html(value.patientNumber)
								$("#patientSex").html(value.patientSex)
								$("#patientTel").html(value.patientTel)
								$("#patient_branch").html(data.branchName)
								//医嘱
								$("#doc-patientAge").html(value.patientAge)
								$("#doc-patientName").html(value.patientName)
								$("#doc-patientNumber").html(value.patientNumber)
								$("#doc-patientSex").html(value.patientSex)
								$("#doc-patientTel").html(value.patientTel)
							}
							
							// 添加疾病
							if(name == "sicmedPatientDiseaseBeans"){
								
							}
							
							// 医嘱信息 
							if(name == "sicmedAskedBeans"){
								$("#tab_doctor thead").children().remove();
								$("#tab_doctor tbody").children().remove();
								$("#tab_doctor thead").append(
										"<tr align='center' class='doctor-list-th'>"+"<td style='border-left:none;'>组</td>"+"<td>品名</td>"+"<td>规格</td>"+"<td>总数</td>"+"<td>给药途径</td>"+"<td>用药频次</td>"+"<td>单次计量</td>"+"<td>计量单位</td>"+"<td>单位</td>"+"<td>天数</td>"+"<td style='border-right:none;'>执行科室</td>"+
										"</tr><tr id='thead_tr' style='height:50px;'>"+"<td style='border-left:none;'>-</td>"+"<td>-</td>"+"<td>-</td>"+"<td>-</td>"+"<td>-</td>"+"<td>-</td>"+"<td>-</td>"+"<td>-</td>"+"<td>-</td>"+"<td>-</td>"+"<td style='border-right:none;'>-</td>"+
										"</tr>"
										);
								$.each(value , function(named,valued){
									var indexNamed = named + 1 
									// 药品类型
									if(valued.sicmedAskedClassBean.classNumber == 3 && valued.sicmedMedicalBean != undefined){
										$("#thead_tr").hide();
										$("#tab_doctor tbody").append(
												"<tr id="+valued.id+" align='center' onclick=deleteDoctorItem(this.id)>"
												+"<td style='border-left:none;'>"+ valued.sicmedAskedClassBean.askedCalss +"</td>"
												+"<td>"+valued.sicmedMedicalBean.medicalNameChina+"</td>"
												+"<td>"+valued.sicmedMedicalBean.medicalStand+"</td>"
												+"<td>"+ 1 +"</td>"
												+"<td>"+valued.sicmedMedicalUseBean.useGroup+"</td>"
												+"<td>"+valued.sicmedMedicalUseBean.useBout+"</td>"
												+"<td>"+valued.sicmedMedicalUseBean.useAmount+"</td>"
												+"<td>"+valued.sicmedMedicalUseBean.useUnit+"</td>"
												+"<td>"+valued.sicmedMedicalUseBean.useUnit+"</td>"
												+"<td>"+valued.sicmedMedicalUseBean.useDay+"</td>"
												+"<td style='border-right:none;'>"+valued.sicmedMedicalBean.medicalCompany+"</td>"
												+"</tr>")	
									}
									//治疗类型
									if(valued.sicmedAskedClassBean.classNumber == 2 && valued.sicmedCureCheckBean != undefined){
										$("#thead_tr").hide();
										$("#tab_doctor tbody").append(
												"<tr id="+valued.id+" align='center' onclick=deleteDoctorItem(this.id) style='cursor:pointer;'>"
												+"<td style='border-left:none;'>"+ valued.sicmedAskedClassBean.askedCalss +"</td>"
												+"<td>"+valued.sicmedCureCheckBean.cureName+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+ 1 +"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td style='border-right:none;'>"+"-"+"</td>"
												+"</tr>")	
									}
									//检验类型
									if(valued.sicmedAskedClassBean.classNumber == 1 && valued.sicmedInspectBean != undefined){
										$("#thead_tr").hide();
										$("#tab_doctor tbody").append(
												"<tr id="+valued.id+" align='center' onclick=deleteDoctorItem(this.id)>"
												+"<td style='border-left:none;'>"+ valued.sicmedAskedClassBean.askedCalss +"</td>"
												+"<td>"+valued.sicmedInspectBean.inspectName+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+ 1 +"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td style='border-right:none;'>"+"-"+"</td>"
												+"</tr>")	
									}
									//检查类型
									if(valued.sicmedAskedClassBean.classNumber == 0 && valued.sicmedTwxrayCheckBean != undefined){
										$("#thead_tr").hide();
										$("#tab_doctor tbody").append(
												"<tr id="+valued.id+" align='center' onclick=deleteDoctorItem(this.id)>"
												+"<td style='border-left:none;'>"+ valued.sicmedAskedClassBean.askedCalss +"</td>"
												+"<td>"+valued.sicmedTwxrayCheckBean.checkName+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+ 1 +"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td>"+"-"+"</td>"
												+"<td style='border-right:none;'>"+"-"+"</td>"
												+"</tr>")	
									}
									indexNamed = null;
								})
							}
						});
					},
							
				error : function() {
					alert("请求出错");
				}
			});
	}
	
  
  
   
   $("#serch_preliminaryDiagnosis").click(function(event){
	   event.stopPropagation();
   })
 
  // 搜索初步诊断
  var disease_pageNo;
  var disease_name;
  var disease_data_length;
  $("#serch_preliminaryDiagnosis").on("input",function(){
	  //获取输入的关键字
	  disease_name = $(this).val();
	  disease_pageNo = 1;
	  serchPreliminaryDiagnosis(disease_name,disease_pageNo);
  })
  
// 获取初步诊断
function serchPreliminaryDiagnosis(disease,pageNo) {
	$.ajax({
		type : 'get',
		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedDisease/searchDisease',
		data : "ssid=${sicmedUserBean.ssid}&disease="+disease+"&pageNo="+pageNo,
		cache : false,
		dataType : 'json',
		success : function(data) { 
					console.log(data);
					
					$("#preliminaryDiagnosis_droupmenu_item").children().remove();
					if(data.error == 0){
						disease_data_length = data.sicmedDiseaseBeans.length;
						// 查看更多  显示/隐藏 
						if(disease_data_length == 20){
							$("#preliminaryDiagnosis_droupmenu_item").height(520);
							$("#seeMore_preliminaryDiagnosis").show();
						}else{
							$("#preliminaryDiagnosis_droupmenu_item").height(40*disease_data_length);
							$("#seeMore_preliminaryDiagnosis").hide();
						}
						$.each(data.sicmedDiseaseBeans,function(index,val){
							$("#preliminaryDiagnosis_droupmenu_item").append("<li onclick='addPatientDisease(this.id)' id="+val.id+" style='cursor:pointer;background-color:#efefef;border:none;' class='list-group-item text-left'>"+ val.diseaseName+"</li>")
						})
					}else{
						$("#preliminaryDiagnosis_droupmenu_item").height(0);
						$("#seeMore_preliminaryDiagnosis").hide();
					}
				},
		error : function() {
					alert("请求出错");
				}
		});
	}
 
  // 获取更多初步诊断
  $("#seeMore_preliminaryDiagnosis").click(function(){
	  if(disease_data_length == 20){
		  disease_pageNo ++;
		  serchPreliminaryDiagnosis(disease_name,disease_pageNo);
	  }
	  console.log("当前页码为：" + disease_pageNo)
  })
  
  // 添加初步诊断
  function addPatientDisease(id){
  	var caseId = $("#caseId_h").val();
  	var patientId = $("#patientId_h").val();
  		$.ajax({
  			type : 'get',
  			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatientDisease/add',
  			data : "ssid=${sicmedUserBean.ssid}&diseaseId="+id+"&caseId="+caseId,
  			cache : false,
  			dataType : 'json',
  			success : function(data) {
  						console.log(data);
  						if(data.error == 0){
  							getYesByPatient(patientId)
  							$('#preliminaryDiagnosis_Modal').modal('hide');
  						}else{
  							$('#preliminaryDiagnosis_Modal').modal('hide');
  							bootbox.alert({
  								buttons: {  
  									   ok: {  
  											label: '确定',  
  											className: 'btn-primary'  
  										}  
  									},  
  								message: data.errorMessage,
  							})
  						}
  				},
  			error : function() {
  				alert("请求出错");
  				}
  			});
  	}
  
  // 删除患者疾病(初步诊断) 
  function deletePreliminaryDiagnosis(id){
	  var patientId = $("#patientId_h").val();
	  bootbox.setLocale("zh_CN");
	  bootbox.confirm({ 
		  size: "small",
		  message: "确定要删除此项诊断吗?", 
		  /* buttons: {
		        confirm: {
		            label: '确定',
		            className: 'btn-success'
		        },
		        cancel: {
		            label: '取消',
		            className: 'btn-danger'
		        }
		    }, */
		  callback: function(result){ 
			  if(result==true){
				  $.ajax({
				  		type : 'get',
				  		url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedPatientDisease/delete',
				  		data : "ssid=${sicmedUserBean.ssid}&id="+id,
				  		cache : false,
				  		dataType : 'json',
				  		success : function(data) {
				  					console.log(data);
				  					if(data.error == 0){
											getYesByPatient(patientId)
									}else{
											alert(data.errorMessage)
									}
				  				},
				  		error : function() {
				  					alert("请求出错");
				  				}
				  		});
			  }
		  }
		})
  }
  
  
// 开医嘱 
function openDoctor_advice(){
	$('#tab1 .tab-a a').css({'background-color':'#fff','color':'#757575','border-color':'#ddd'});
	$('#tab1 .tab-a a:eq(2)').css({'background-color':'#124256','color':'#fff','border-color':'#124256'});
}
  
// 添加医嘱
function addAsked(orderCode,askedClassId,medicalUseStr){
	  bootbox.setLocale("zh_CN");  
	  bootbox.confirm({ 
		  size: "small",
		  message: "确定要添加此项诊断吗?", 
		  callback: function(result){ 
			  if(result==true){
				  var caseId = $("#caseId_h").val();
					var patientId = $("#patientId_h").val();
					var askedClassId = $("#protuctItem_id").val();
					console.log('病历id'+caseId)
					console.log("患者id"+ patientId)
					console.log(askedClassId)
					$.ajax({
						type : 'get',
						url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedAsked/add',
						data : "ssid=${sicmedUserBean.ssid}&orderCode="+orderCode+"&caseId="+caseId+"&patientId="+patientId+"&askedClassId="+askedClassId+"&"+medicalUseStr,
						cache : false,
						dataType : 'json',
						success : function(data) {
									console.log(data);
									if(data.error == "0"){
										var patientId = $("#patientId_h").val();
										
										getYesByPatient(patientId);
										
										$('#tab1 .tab-a a').css({'background-color':'#fff','color':'#212121','border-color':'#bdbdbd'});
										$('#tab1 .tab-a a:eq(2)').css({'background-color':'#124256','color':'#fff','border-color':'#124256'});
										
										/* if(!confirm(data.errorMessage+"是否继续添加!")){
											 $(".yz_popIframeDiv").remove();  
										     $(".yz_popTanChu").remove(); 
										} */
									}else{
										bootbox.alert({
											buttons: {  
									               ok: {  
									                    label: '确定',  
									                    className: 'btn-primary'  
									                }  
									            },  
										    message: data.errorMessage
										})
									}
								},
						error : function() {
							alert("请求出错");
							}
					});
			  }else{
				console.log("取消添加");
			  }
		  }
		})
}

	
	
// 删除医嘱
var leeId;
function deleteDoctorItem(id){
	leeId = id;
	$("#"+id).css({"border":"2px solid #3cc5de"});
	$("#"+id).siblings().css({"border":"1px solid #ddd"});
	
	$('#deleteRew').removeClass("doctype_bacg");
	$('#deleteRew').addClass("doctype_bacg_active");
}


$('#deleteRew').hover(function(){
	$(this).css('color','#fff')
});
$('#deleteRew').click(function(){
	 if(leeId){
		 	bootbox.setLocale("zh_CN");
			bootbox.confirm({ 
				  size: "small",
				  message: "确定要删除此项医嘱吗?", 
				  callback: function(result){ 
					  if(result==true){
						  $.ajax({
								type : 'get',
								url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedAsked/delete',
								data : "ssid=${sicmedUserBean.ssid}&id="+leeId,
								cache : false,
								dataType : 'json',
								success : function(data) {
										    console.log(data);
										    leeId = undefined;
											if(data.error == "0"){
												var patientId = $("#patientId_h").val();
												//replaceAsked(patientId);
												getYesByPatient(patientId);
												$('#tab1 .tab-a a').css({'background-color':'#fff','color':'#212121','border-color':'#bdbdbd'});
												$('#tab1 .tab-a a:eq(2)').css({'background-color':'#124256','color':'#fff','border-color':'#124256'});
												
												$('#deleteRew').removeClass("doctype_bacg_active");
												$('#deleteRew').addClass("doctype_bacg");
												
											}else{
												alert(data.errorMessage);
											}
										},
										error : function() {
											console.log("请求出错");
										}
								});
					  }else{
						console.log("取消删除");
					  }
				  }
				})
		}else{
			
		}
})
</script>


<!-- 医嘱 -->
<script>
	// 添加药品医嘱
	var medicalId ;
	function addAskedMedical(id){
		medicalId = id;
		
		/* $("#doctorMedical_model").toggle(100); */
		
		//药品名
		$("#addDoctor_medicalName").val( $('#'+id+'medicalNameChina').val() )
		//单位/规格
		$("#addDoctor_medicalComp").val( $('#'+id+'unit').val() )
		//单次计量
		$("#singleMeasurement").html( $('#'+id+'unit').val() )
	}
	
	
	$(document).ready(function(){
		
		$("#btn_protuctItem button").mouseover(function(){
			$(this).css('color',"#fff");
		})		
		
		// 记录检查、检验、治疗、药品四种状态
		var ab;
		// 记录页码
		var pageNo;
		$("#btn_protuctItem").delegate('button', 'click',function(e){
			
			$("#separate_pageNumber").hide();
			
			$("#search_productName").val("");
			
			$(e.target).css({"color":"#fff"})
			
			$(e.target).addClass('doctype_bacg_active');
			$(e.target).siblings("button").removeClass('doctype_bacg_active');
			$(e.target).siblings("button").addClass('doctype_bacg');
			
			$("#table_productItem tbody").children().remove();
			$("#doc_tableSecTr").show();
			
			// 医嘱类别id
			switch($(e.target).text())
			{
				case '检查':
					$("#protuctItem_id").val("164c945584b54037a8256767085ac8cd");
					ab = 1
				break;
				 	
				case '检验':
					$("#protuctItem_id").val("8bbdc6d6ab1b46059399e3b3171a7d6e");
					ab = 2
				break;
				
				case '治疗':
					$("#protuctItem_id").val("849a943dc31140308edef3bdcbc4894f");
					ab = 3
				break;
					
				case '药品':
					$("#protuctItem_id").val("385541b6553e440c9d90048742360e4a");
					ab = 4
				break;
			}
			//初始化页码
			pageNo = 1;
			$("#page_now a").html(pageNo)
		}) 
		
		/****** 搜索 ******/
		// 记录输入的关键字
		var parameter;
		// 记录医嘱类别id
		var classId;
		// 记录每次返回的数据（医嘱）个数
		var data_length;
		$("#search_productName").bind('input' , function(){
			classId = $("#protuctItem_id").val();
			parameter = $("#search_productName").val();
			// 初始化页码
			pageNo = 1;
			$("#page_now a").html(pageNo)
			
			switch(ab)
			{
				case 1:
					searchCheck(parameter,pageNo,classId);
				break;
				 	
				case 2:
					searchinspect(parameter,pageNo,classId);
				break;
				
				case 3:
					searchcure(parameter,pageNo,classId)
				break;
					
				case 4:
					searchmedical(parameter,pageNo,classId)
				break;
			}
		})
	
		
		// 检查
		function searchCheck(parameter,pageNo,classId) {
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedTwxrayCheck/searchCheck',
				data : "ssid=${sicmedUserBean.ssid}&parameter="+parameter+"&pageNo="+pageNo+"&classId="+classId,
				cache : false,
				dataType : 'json',
				success : function(data) { 
							console.log(data);
							$("#table_productItem tbody").children().remove();
							
							if(data.twxrayCheckBeanList){
								$("#doc_tableSecTr").hide();
								
								data_length = data.twxrayCheckBeanList.length;
								if(data_length == 20){
									$("#separate_pageNumber").show();
								}else{
									$("#separate_pageNumber").hide();
								}
								
								$.each(data.twxrayCheckBeanList,function(n,v){
									$("#table_productItem tbody").append(
											"<tr align='center' id="+ v.id +" onclick='addAsked(this.id)' style='cursor:pointer;'>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"检查类型"+"</td>"
											+"<td>"+v.checkName+"</td>"
											+"<td>"+v.checkName+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"
											); 
								})
							}
					},
				error : function() {
					alert("请求出错");
					}
			});
		}
		
		// 检验
		function searchinspect(inspect,pageNo,classId) {
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedInspect/searchInspect',
				data : "ssid=${sicmedUserBean.ssid}&parameter="+inspect+"&pageNo="+pageNo+"&classId="+classId,
				cache : false,
				dataType : 'json',
				success : function(data) { 
							console.log(data);
							$("#doc_tableSecTr").hide();
							
							$("#table_productItem tbody").children().remove();
							
							if(data.sicmedInspectBeans){
								data_length = data.sicmedInspectBeans.length;
								if(data_length == 20){
									$("#separate_pageNumber").show();
								}else{
									$("#separate_pageNumber").hide();
								}
								
								
								
								$.each(data.sicmedInspectBeans,function(n,v){
									$("#table_productItem tbody").append(
											"<tr align='center' id="+ v.id +" onclick='addAsked(this.id)' >"
											+"<td>"+"-"+"</td>"
											+"<td>"+"检验类型"+"</td>"
											+"<td>"+v.inspectName+"</td>"
											+"<td>"+v.inspectName+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"
											);
								})
							}
						},
					error : function() {
							alert("请求出错");
					   }
				});
		}
		
		// 治疗
		function searchcure(cure,pageNo,classId) {
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedCureCheck/searchCure',
				data : "ssid=${sicmedUserBean.ssid}&parameter="+cure+"&pageNo="+pageNo+"&classId"+classId,
				cache : false,
				dataType : 'json',
				success : function(data) { 
							console.log(data);
							$("#doc_tableSecTr").hide();
							
							$("#table_productItem tbody").children().remove();
							
							if(data.cureCheckBeanList){
								data_length = data.cureCheckBeanList.length;
								if(data_length == 20){
									$("#separate_pageNumber").show();
								}else{
									$("#separate_pageNumber").hide();
								}
								
								$.each(data.cureCheckBeanList,function(n,v){
									$("#table_productItem tbody").append(
											"<tr align='center' id="+ v.id +" onclick='addAsked(this.id)' >"
											+"<td>"+"-"+"</td>"
											+"<td>"+"治疗类型"+"</td>"
											+"<td>"+v.cureName+"</td>"
											+"<td>"+v.cureName+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"
											); 
								})
							}
					},
				error : function() {
					alert("请求出错");
				   }
			});
		}
		
		// 药品
		function searchmedical(medical,pageNo,classId) {
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedMedical/searchMedical',
				data : "ssid=${sicmedUserBean.ssid}&parameter="+medical+"&pageNo="+pageNo+"&classId="+classId,
				cache : false,
				dataType : 'json',
				success : function(data) { 
							console.log(data);
							$("#doc_tableSecTr").hide();
							
							$("#table_productItem tbody").children().remove();
							if(data.sicmedMedicalBeans){
								data_length = data.sicmedMedicalBeans.length;
								if(data_length == 20){
									$("#separate_pageNumber").show();
								}else{
									$("#separate_pageNumber").hide();
								}
								
								$.each(data.sicmedMedicalBeans,function(n,v){
									// 药品单位
									if(v.unit1 == ""){
										unit = v.unit2;
									}else{
										unit = v.unit1;
									}
									$("#table_productItem tbody").append(
											"	<tr align='center' id="+ v.id +" onclick='addAskedMedical(this.id)' data-toggle='modal' data-target='#myModal'>"
											+"<td>"+v.medicalCode+"</td>"
											+"<td>"+"药品类型"+"</td>"
											+"<td>"+v.medicalNameChina+"</td>"
											+"<td>"+v.medicalNameChina+"</td>"
											+"<td>"+v.medicalStand+"</td>"
											+"<td>"+unit+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"<input type='hidden' value="+v.medicalNameChina+" id="+v.id+'medicalNameChina'+">" +"</td>"
											+"<td>"+"-"+"<input type='hidden' value="+unit+" id="+v.id+'unit'+">" +"</td>"
											+"</tr>"
											);
								})
							}
					},
				error : function() {
					alert("请求出错");
					}
			});
		}
		
		// 保存药品医嘱
		$("#savePrescription").click(function(){
			var orderCode = medicalId;
			var caseId = $("#caseId_h").val();
			var patientId = $("#patientId_h").val();
			var askedClassId = $("#protuctItem_id").val();
			console.log('病历id'+caseId)
			console.log("患者id"+ patientId)
			console.log(orderCode)
			console.log(askedClassId)
			
			var medicalUseStr = $("#doctorMedicalModel_form").serialize();
			var jsonData = $("#doctorMedicalModel_form").serializeArray();//$ 序列化 表单 返回 json obj
			console.log(medicalUseStr)
			
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedAsked/add',
				data : "ssid=${sicmedUserBean.ssid}&orderCode="+orderCode+"&caseId="+caseId+"&patientId="+patientId+"&askedClassId="+askedClassId+"&"+medicalUseStr,
				cache : false,
				dataType : 'json',
				success : function(data) {
						console.log(data);
							if(data.error == "0"){
								var patientId = $("#patientId_h").val();
								getYesByPatient(patientId);
								$('#tab1 .tab-a a').css({'background-color':'#fff','color':'#212121','border-color':'#bdbdbd'});
								$('#tab1 .tab-a a:eq(2)').css({'background-color':'#124256','color':'#fff','border-color':'#124256'});
								
								// 隐藏药品用法摸态框
								$("#myModal").modal('hide');
								// 表单重置
								$('#doctorMedicalModel_form')[0].reset()
								

							}else{
								alert(data.errorMessage);
							}
						},
				error : function() {
				alert("请求出错");
				}
			});
		})
		
		
		
		
		/***** 分页 *****/
		$("#separate_pageNumber").hide();
		// 下一页
		$("#next_page").click(function(){
			/* console.log(classId)
			console.log("关键字："+ parameter)*/
			if(data_length >= 20){
				pageNo ++;
				switch(ab)
				{
					case 1:
						searchCheck(parameter,pageNo,classId);
					break;
					 	
					case 2:
						searchinspect(parameter,pageNo,classId);
					break;
					
					case 3:
						searchcure(parameter,pageNo,classId)
					break;
						
					case 4:
						searchmedical(parameter,pageNo,classId)
					break;
				}
				$("#page_now a").html(pageNo)
			}
			console.log("当前页码："+pageNo)
			return false;
		})
		
		// 上一页
		$("#previous_page").click(function(){
			if(pageNo > 1){
				pageNo --;
				switch(ab)
				{
					case 1:
						searchCheck(parameter,pageNo,classId);
					break;
					 	
					case 2:
						searchinspect(parameter,pageNo,classId);
					break;
					
					case 3:
						searchcure(parameter,pageNo,classId)
					break;
						
					case 4:
						searchmedical(parameter,pageNo,classId)
					break;
				}
				$("#page_now a").html(pageNo)
			}
			console.log("当前页码："+pageNo)
			return false;
		})
	})
</script>





<script>
	// 一键开处方
	function addStandAsked1(id){
		var caseId = $("#caseId_h").val();
		var patientId = $("#patientId_h").val();
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionAsked/addAsked',
			data : "ssid=${sicmedUserBean.ssid}&caseId="+caseId+"&patientId="+patientId+"&id="+id,
			cache : false,
			dataType : 'json',
			success : function(data) {
					console.log('添加标准处方成功返回的数据为：')
					console.log(data);
						if(data.error == "0"){
							getYesByPatient(patientId);
							$("#onekey_prescription").modal('hide');
							
							$('#tab1 .tab-a a').css({'background-color':'#fff','color':'#212121','border-color':'#bdbdbd'});
							$('#tab1 .tab-a a:eq(2)').css({'background-color':'#124256','color':'#fff','border-color':'#124256'});
						}else{
							alert(data.errorMessage);
						}
					},
			error : function() {
			alert("请求出错");
			}
		});
	}
	
	// 添加疾病
	function add_diseaseItem(id){
		console.log("所选疾病id为："+id)
		$("#disease_item_id").val(id)
		var newId = "#" + id;
		//$("#disease_item_name").val($(newId).html());
		
		$("#alert-panel p").html($(newId).html())
		
		$("#alert-panel").css({"padding-top":"8px","padding-bottom":"8px"})
		$("#stand_disease_model").hide(300);
	}
	
	
	$("#alert-panel").click(function(){
		var alert_panelWidth = $(this).width() + 12;
		if($("#stand_disease_model").is(":hidden")){
			$("#stand_disease_model").show();
			$("#stand_disease_model").width(alert_panelWidth);
		}else{
			$("#stand_disease_model").hide();
		}
		return false;
	})
	$("#stand_disease_model").click(function(){
		$("#stand_disease_model").show();
		return false;
	})
	$(document).click(function(){
		$("#stand_disease_model").hide();
	})
	
	$(document).ready(function(){
		// 修改病历
		$("#case_form_submit").click(function(){
			saveCase()
		})
		
		function saveCase(){
			var caseStr = $("#case_form").serialize();//$ 序列化 表单  str 
			var jsonData = $("#case_form").serializeArray();//$ 序列化 表单 返回 json obj
			/* console.log(jsonData) */
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedCase/update',
				data : "ssid=${sicmedUserBean.ssid}&"+caseStr,
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
						    message: "病历保存成功",
						    size: 'small'
						})
					}else{
						bootbox.alert({
							buttons: {  
					               ok: {  
					                    label: '确定',  
					                    className: 'btn-primary'  
					                }  
					            },   
						    message: "病历保存失败",
						    size: 'small'
						})
					}
					
				},
				error : function() {
					alert("请求出错");
				}
				});
			
		};
		
		$('#caseAllergy').on("input" , function(){
			var allergy_medical = $(this).val();
			console.log('药物过敏史' + allergy_medical)
			$('caseAllergy_hide').val(allergy_medical);
		})
		
		$("#onekeyPrescription").click(function(){
			getStand();
		})
		
		/* 获取医生个人的标准处方  */
		function getStand(){
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionDisease/get',
				data : "ssid=${sicmedUserBean.ssid}",
				cache : false,
				dataType : 'json',
				success : function(data) {
					console.log(data);
					
					if(data.sicmedStanderprescriptionDiseaseBeans){
						$("#onekey_prescription_list").children().remove();
						$.each(data.sicmedStanderprescriptionDiseaseBeans , function(index,val){
							$("#onekey_prescription_list").append(
									"<li onclick='addStandAsked1(this.id)' id="+val.id+" style='cursor:pointer;' class='list-group-item'>"
									+ val.prescriptionName +"<span style='float:right;'>"+ val.sicmedDiseaseBean.diseaseName+"</span>"
									+"</li>"
									)
						})
					}
				},
				error : function() {
					alert("请求出错");
				}
			});
		}
		
		
		$("#search_standardPrescription").on('input',function(){
			var name = $(this).val();
			console.log(name)
			searchStand(name);
		})
		/* 搜索医生个人的标准处方 */
		function searchStand(name){
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionDisease/findByName',
				data : "ssid=${sicmedUserBean.ssid}&name="+name,
				cache : false,
				dataType : 'json',
				success : function(data) {
					console.log('搜索到的标准处方有：')
					console.log(data);
					 
					if(data.error == 0){
						if(data.sicmedStanderprescriptionDiseaseBeans){
							$("#onekey_prescription_list").children().remove();
							$.each(data.sicmedStanderprescriptionDiseaseBeans , function(index,val){
								$("#onekey_prescription_list").append(
										"<li onclick='addStandAsked1(this.id)' id="+val.id+" style='cursor:pointer;' class='list-group-item'>"
										+ val.prescriptionName +"<span style='float:right;'>"+ val.sicmedDiseaseBean.diseaseName+"</span>"
										+"</li>"
										)
							})
						}
					}else{
						$("#onekey_prescription_list").children().remove();
					}
				},
				error : function() {
					alert("请求出错");
				}
			});
		}
		
		
		var stand_disease_pageNo
		var stand_disease;
		$("#disease_item_name").on('input' ,function(){
			stand_disease = $(this).val();
			stand_disease_pageNo = 1;
			searchDisease(stand_disease,stand_disease_pageNo);
		})
		
		// 获取疾病信息 
		var stand_diseaseData_length;
		function searchDisease(disease,pageNo) {
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedDisease/searchDisease',
				data : "ssid=${sicmedUserBean.ssid}&disease="+disease+"&pageNo="+pageNo,
				cache : false,
				dataType : 'json',
				success : function(data) {
							$("#stand_disease_model").show();
							console.log(data);
							$("#search_standDisease_ul").children().remove();
							if(data.error == 0){
								stand_diseaseData_length = data.sicmedDiseaseBeans.length;
								//$("#stand_disease_model").show();
								if(stand_diseaseData_length == 20){
									$("#search_standDisease_ul").height(420);
									$("#stand_seeMore_preliminaryDiagnosis").show();
								}else{
									$("#search_standDisease_ul").height(40*stand_diseaseData_length);
									$("#stand_seeMore_preliminaryDiagnosis").hide();
								}
								
								if(data.sicmedDiseaseBeans){
									$.each(data.sicmedDiseaseBeans , function(index,val){
										$("#search_standDisease_ul").append("<li onclick='add_diseaseItem(this.id)' id="+val.id+" style='cursor:pointer;border:none;background-color:#efefef;' class='list-group-item'>"+ val.diseaseName+"</li>")
									})
								}
							}else{
								//$("#stand_disease_model").hide();
							}
					},
				error : function() {
								alert("请求出错");
					}
				});
			}
		
		
		// 查看更多疾病
		$("#stand_seeMore_preliminaryDiagnosis").click(function(){
			if(stand_diseaseData_length = 20){
				stand_disease_pageNo ++;
				searchDisease(stand_disease,stand_disease_pageNo);
			}
			console.log("当前页码为：" + stand_disease_pageNo)
		})
	})
</script>


<script>
	//标准处方——添加药品医嘱
	var stand_medicalId ;
	function addMedicalStandAsked(id){
		stand_medicalId = id;
		//$("#medicalUse_model").toggle(100);
		
		//药品名
		$("#medicalProductName_standard").val( $('#'+id+'medicalNameChina').val() )
		//单位/规格
		$("#medicalCompany_standard").val( $('#'+id+'unit').val() )
		//单次计量
		$("#stand_singleMeasurement").html( $('#'+id+'unit').val() )
		
		// 剂型
		$("#medicalProductName_useBun").val($('#'+id+'unit').val())
	}
	

	//标准处方——添加医嘱
	function addStandAsked2(id){
		var askedClassId = $("#stand_protuctItem_id").val();
		/* var sicmedStanderprescriptionId = $("#exi_standPrescription").val() */
		var sicmedStanderprescriptionId =  $("#exi_standPrescription").val();
		var orderCode = id;
		
		addTostandAsked(askedClassId,sicmedStanderprescriptionId,orderCode);
	}
	
	function addTostandAsked(askedClassId,sicmedStanderprescriptionId,orderCode) {
		console.log("askedClassId为：" +askedClassId)
		console.log("sicmedStanderprescriptionId为：" + sicmedStanderprescriptionId)
		console.log("orderCode为：" + orderCode)
		
		var medicalUseStr = $("#doctorMedicalModel_standform").serialize();
		var jsonData = $("#doctorMedicalModel_standform").serializeArray();//$ 序列化 表单 返回 json obj
		console.log("序列化后的表单数据为：")
		console.log(jsonData)
		
		  bootbox.setLocale("zh_CN");  
		  bootbox.confirm({ 
			  size: "small",
			  message: "确定要添加此项医嘱吗?", 
			  /* buttons: {
			        confirm: {
			            label: '确定',
			            className: 'btn-success'
			        },
			        cancel: {
			            label: '取消',
			            className: 'btn-danger'
			        }
			    }, */
			  callback: function(result){ 
				  if(result==true){
					  $.ajax({
							type : 'get',
							url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionAsked/add',
							data : "ssid=${sicmedUserBean.ssid}&askedClassId="+askedClassId+"&sicmedStanderprescriptionId="+sicmedStanderprescriptionId+"&orderCode="+orderCode+"&"+medicalUseStr,
							cache : false,
							dataType : 'json',
							success : function(data) { 
										console.log(data)
										if(data.error == 0){
											/* if(!confirm(data.errorMessage+"是否继续添加!")){
												 $(".yz_popIframeDiv").remove();  
											     $(".yz_popTanChu").remove(); 
											} */
											// 添加成功后重新获取标准处方下的医嘱	
											getStandAsked();
											
											//隐藏药品用法摸态框
											$("#medicalUse_model").hide(500);
											
											//表单重置
											$("#doctorMedicalModel_standform")[0].reset();
											
										}else{
											bootbox.alert({
												buttons: {  
													   ok: {  
															label: '确定',  
															className: 'btn-primary'  
														}  
													},  
												message: data.errorMessage
											})
										}
									},
							error : function() {
								alert("请求出错");
							}
						});
				  }else{
					console.log("取消添加");
				  }
			  }
			})
	}

	
	//标准处方——添加药品医嘱
	$("#savePrescriptionStand").click(function(){
		var askedClassId = $("#stand_protuctItem_id").val();
		/* var sicmedStanderprescriptionId = $("#exi_standPrescription").val() */
		var sicmedStanderprescriptionId = $("#exi_standPrescription").val();
		var orderCode = stand_medicalId;
		
		addTostandAskedMedical(askedClassId,sicmedStanderprescriptionId,orderCode);
	})
	
	function addTostandAskedMedical(askedClassId,sicmedStanderprescriptionId,orderCode) {
		console.log("askedClassId为：" +askedClassId)
		console.log("sicmedStanderprescriptionId为：" + sicmedStanderprescriptionId)
		console.log("orderCode为：" + orderCode)
		
		var medicalUseStr = $("#doctorMedicalModel_standform").serialize();
		var jsonData = $("#doctorMedicalModel_standform").serializeArray();//$ 序列化 表单 返回 json obj
		console.log("序列化后的表单数据为：")
		console.log(jsonData)
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionAsked/add',
			data : "ssid=${sicmedUserBean.ssid}&askedClassId="+askedClassId+"&sicmedStanderprescriptionId="+sicmedStanderprescriptionId+"&orderCode="+orderCode+"&"+medicalUseStr,
			cache : false,
			dataType : 'json',
			success : function(data) { 
						console.log(data)
						if(data.error == 0){
							/* if(!confirm(data.errorMessage+"是否继续添加!")){
								 $(".yz_popIframeDiv").remove();  
							     $(".yz_popTanChu").remove(); 
							} */
							// 添加成功后重新获取标准处方下的医嘱	
							getStandAsked();
							
							//隐藏药品用法摸态框
							$("#myModal2").modal('hide');
							
							//表单重置
							$("#doctorMedicalModel_standform")[0].reset();
							
						}else{
							bootbox.alert({
								buttons: {  
									   ok: {  
											label: '确定',  
											className: 'btn-primary'  
										}  
									},  
								message: data.errorMessage
							})
						}
					},
			error : function() {
				alert("请求出错");
			}
		});
		  
	}
	
	
// 搜索标准处方下的医嘱
$(document).ready(function(){
	$("#btn_standProtuctItem button").mouseover(function(){
		$(this).css('color',"#fff");
	})
	
	
		// 记录检查、检验、治疗、药品四种状态
		var cd;
		// 记录页码
		var standard_pageNo;
		$("#btn_standProtuctItem").delegate('button', 'click',function(e){
			$("#separate_pageNumber").hide();
			
			
			// 清除搜索框内容
			$("#search_standProductName").val("");
			
			$("#separate_pageNumber_standard").hide();
			
			/* $(e.target).removeClass('disabled');
			$(e.target).siblings().addClass('disabled'); */
			$(e.target).css({"color":"#fff"})
			
			$(e.target).addClass('doctype_bacg_active');
			$(e.target).siblings("button").removeClass('doctype_bacg_active');
			$(e.target).siblings("button").addClass('doctype_bacg');
			
			$("#table_standProductItem tbody").children().remove();
			
			$("#std_tableSecTr").show();
			
			// 获取医嘱类别id
			switch($(e.target).text())
			{
				case '检查':
					$("#stand_protuctItem_id").val("164c945584b54037a8256767085ac8cd");
					cd = 1
				break;
				 	
				case '检验':
					$("#stand_protuctItem_id").val("8bbdc6d6ab1b46059399e3b3171a7d6e");
					cd = 2
				break;
				
				case '治疗':
					$("#stand_protuctItem_id").val("849a943dc31140308edef3bdcbc4894f");
					cd = 3
				break;
					
				case '药品':
					$("#stand_protuctItem_id").val("385541b6553e440c9d90048742360e4a");
					cd = 4
				break;
			}
			//初始化页码
			standard_pageNo = 1;
			$("#page_now_standard a").html(standard_pageNo)
		}) 
		
		
		/****** 搜索标准处方下的医嘱 ******/
		var stand_parameter;
		var stand_classId;
		//记录每次返回的数据（医嘱）个数
		var stand_data_length;
		$("#search_standProductName").bind('input' , function(){
			stand_parameter = $("#search_standProductName").val();
			stand_classId = $("#stand_protuctItem_id").val();
			// 初始化页码
			standard_pageNo = 1;
			$("#page_now_standard a").html(standard_pageNo);
			
			switch(cd)
			{
				case 1:
					stand_searchCheck(stand_parameter,standard_pageNo,stand_classId);
				break;
				 	
				case 2:
					stand_searchinspect(stand_parameter,standard_pageNo,stand_classId);
				break;
				
				case 3:
					stand_searchcure(stand_parameter,standard_pageNo,stand_classId)
				break;
					
				case 4:
					stand_searchmedical(stand_parameter,standard_pageNo,stand_classId)
				break;
			}
		})
		
		
		// 检查
		function stand_searchCheck(parameter,pageNo,classId) {
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedTwxrayCheck/searchCheck',
				data : "ssid=${sicmedUserBean.ssid}&parameter="+parameter+"&pageNo="+pageNo+"&classId="+classId,
				cache : false,
				dataType : 'json',
				success : function(data) { 
							console.log(data);
							$("#std_tableSecTr").hide();
							
							$("#table_standProductItem tbody").children().remove();
							if(data.twxrayCheckBeanList){
								stand_data_length = data.twxrayCheckBeanList.length;
								if(stand_data_length == 20){
									$("#separate_pageNumber_standard").show()
								}else{
									$("#separate_pageNumber_standard").hide()
								}
								
								$.each(data.twxrayCheckBeanList,function(n,v){
									$("#table_standProductItem tbody").append(
											"<tr style='text-align: center;cursor:pointer' id="+ v.id +" onclick='addStandAsked2(this.id)' >"
											+"<td>"+"-"+"</td>"
											+"<td>"+"检查类型"+"</td>"
											+"<td>"+v.checkName+"</td>"
											+"<td>"+v.checkName+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"
											); 
								})
							}
					},
				error : function() {
					alert("请求出错");
					}
			});
		}
		
		// 检验
		function stand_searchinspect(inspect,pageNo,classId) {
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedInspect/searchInspect',
				data : "ssid=${sicmedUserBean.ssid}&parameter="+inspect+"&pageNo="+pageNo+"&classId="+classId,
				cache : false,
				dataType : 'json',
				success : function(data) { 
							console.log(data);
							$("#std_tableSecTr").hide();
							$("#table_standProductItem tbody").children().remove();
							if(data.sicmedInspectBeans){
								stand_data_length = data.sicmedInspectBeans.length;
								if(stand_data_length == 20){
									$("#separate_pageNumber_standard").show()
								}else{
									$("#separate_pageNumber_standard").hide()
								}
								
								$.each(data.sicmedInspectBeans,function(n,v){
									$("#table_standProductItem tbody").append(
											"<tr style='text-align: center;cursor:pointer' id="+ v.id +" onclick='addStandAsked2(this.id)' >"
											+"<td>"+"-"+"</td>"
											+"<td>"+"检验类型"+"</td>"
											+"<td>"+v.inspectName+"</td>"
											+"<td>"+v.inspectName+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"
											);
								})
							}
						},
					error : function() {
						alert("请求出错");
						}
				});
		}
		
		// 治疗
		function stand_searchcure(cure,pageNo,classId) {
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedCureCheck/searchCure',
				data : "ssid=${sicmedUserBean.ssid}&parameter="+cure+"&pageNo="+pageNo+"&classId"+classId,
				cache : false,
				dataType : 'json',
				success : function(data) {
							console.log(data);
							$("#std_tableSecTr").hide();
							$("#table_standProductItem tbody").children().remove();
							if(data.cureCheckBeanList){
								stand_data_length = data.cureCheckBeanList.length;
								if(stand_data_length == 20){
									$("#separate_pageNumber_standard").show()
								}else{
									$("#separate_pageNumber_standard").hide()
								}
								
								$.each(data.cureCheckBeanList,function(n,v){
									$("#table_standProductItem tbody").append(
											"<tr style='text-align: center;cursor:pointer' id="+ v.id +" onclick='addStandAsked2(this.id)' >"
											+"<td>"+"-"+"</td>"
											+"<td>"+"治疗类型"+"</td>"
											+"<td>"+v.cureName+"</td>"
											+"<td>"+v.cureName+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"
											); 
									
								})
							}
					},
				error : function() {
					alert("请求出错");
					}
			});
		}
		
		// 药品
		function stand_searchmedical(medical,pageNo,classId) {
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedMedical/searchMedical',
				data : "ssid=${sicmedUserBean.ssid}&parameter="+medical+"&pageNo="+pageNo+"&classId="+classId,
				cache : false,
				dataType : 'json',
				success : function(data) {
							console.log(data);
							$("#std_tableSecTr").hide();
							$("#table_standProductItem tbody").children().remove();
							if(data.sicmedMedicalBeans){
								stand_data_length = data.sicmedMedicalBeans.length;
								if(stand_data_length == 20){
									$("#separate_pageNumber_standard").show()
								}else{
									$("#separate_pageNumber_standard").hide()
								}
								
								$.each(data.sicmedMedicalBeans,function(n,v){
									// 药品单位
									if(v.unit1 == ""){
										unit = v.unit2;
									}else{
										unit = v.unit1;
									}
									
									$("#table_standProductItem tbody").append(
											"<tr style='text-align: center;cursor:pointer' id="+ v.id +" onclick='addMedicalStandAsked(this.id)' data-toggle='modal' data-target='#myModal2'>"
											+"<td>"+v.medicalCode+"</td>"
											+"<td>"+"药品类型"+"</td>"
											+"<td>"+v.medicalNameChina+"</td>"
											+"<td>"+v.medicalNameChina+"</td>"
											+"<td>"+v.medicalStand+"</td>"
											+"<td>"+unit+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"<input type='hidden' value="+unit+" id="+v.id+'unit'+">" +"</td>"
											+"<td>"+"-"+"<input type='hidden' value="+v.medicalNameChina+" id="+v.id+'medicalNameChina'+">" +"</td>"
											+"</tr>"
											);
								})
							}
					},
				error : function() {
					alert("请求出错");
					}
			});
		}
		
		/***** 分页 *****/
		$("#separate_pageNumber_standard").hide();
		// 下一页
		$("#next_page_standard").click(function(){
			/* console.log(classId)
			console.log("关键字："+ parameter)*/
			if(stand_data_length >= 20){
				standard_pageNo ++;
				switch(cd)
				{
					case 1:
						stand_searchCheck(stand_parameter,standard_pageNo,stand_classId);
					break;
					 	
					case 2:
						stand_searchinspect(stand_parameter,standard_pageNo,stand_classId);
					break;
					
					case 3:
						stand_searchcure(stand_parameter,standard_pageNo,stand_classId)
					break;
						
					case 4:
						stand_searchmedical(stand_parameter,standard_pageNo,stand_classId)
					break;
				}
				$("#page_now_standard a").html(standard_pageNo)
			}
			console.log("当前页码："+standard_pageNo)
			return false;
		})
		
		// 上一页
		$("#previous_page_standard").click(function(){
			if(standard_pageNo > 1){
				standard_pageNo --;
				switch(cd)
				{
					case 1:
						stand_searchCheck(stand_parameter,standard_pageNo,stand_classId);
					break;
					 	
					case 2:
						stand_searchinspect(stand_parameter,standard_pageNo,stand_classId);
					break;
					
					case 3:
						stand_searchcure(stand_parameter,standard_pageNo,stand_classId)
					break;
						
					case 4:
						stand_searchmedical(stand_parameter,standard_pageNo,stand_classId)
					break;
				}
				$("#page_now_standard a").html(standard_pageNo)
			}
			console.log("当前页码："+standard_pageNo)
			return false;
		})
	})
</script>



<script>
function queryDoctorAskd(id){
	// 获取标准处方信息
	$("#standPrescription_name").val( $("#stand_prescription_name"+id).val() );
	$("#exi_standPrescription").val($("#standPrescription_id"+id).val());
	// 获取疾病信息
	//$("#disease_item_name").val( $("#disease_name"+id).val() );
	$("#disease_item_id").val( $("#disease_id"+id).val() );
	
	$("#alert-panel p").html($("#disease_name"+id).val());
	
	console.log('所选标准处方的名称为：' + $("#standPrescription_name").val() );
	console.log("所选标准处方的id为：" + $("#exi_standPrescription").val() );
	console.log('所选标准处方下的疾病名称为：' + $("#disease_item_name").val() );
	console.log('所选标准处方下的疾病id为：' + $("#disease_item_id").val() );
	
	getStandAsked();
	
	$("#history_standPrescription").hide()
}


$("#deleteStandardPresriptionRew").hover(function(){
	$(this).css('color','#fff');
})
// 删除标准处方中的医嘱
var delStandardId;
$("#deleteStandardPresriptionRew").click(function(){
	if(delStandardId){
		 bootbox.setLocale("zh_CN");  
		  bootbox.confirm({ 
			  size: "small",
			  message: "确定要删除此项诊断吗?", 
			  callback: function(result){ 
				  if(result==true){
					  id = delStandardId;
					  $.ajax({
							type : 'get',
							url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionAsked/delete',
							data : "ssid=${sicmedUserBean.ssid}&id="+id,
							cache : false,
							dataType : 'json',
							success : function(data){
								console.log(data);
								delStandardId = undefined;
								if(data.error == 0){
									// 删除成功后重新查询标准处方下的医嘱
									getStandAsked();
									
									$("#deleteStandardPresriptionRew").removeClass("doctype_bacg_active");
									$("#deleteStandardPresriptionRew").addClass("doctype_bacg");
								}else{
									console.log(data.errorMessage);
								}
							},
							error : function() {
								alert("请求出错");
							}
						})
						
				  }else{
					
				  }
			  }
			})
	}
})

function deleteStandardPrescription(id){
	delStandardId = id;
	$("#"+id).css({"border":"2px solid #39a0ed"});
	$("#"+id).siblings().css({"border":"1px solid #ddd"});
	
	$("#deleteStandardPresriptionRew").removeClass("doctype_bacg");
	$("#deleteStandardPresriptionRew").addClass("doctype_bacg_active");
}

/* 查看标准处方中的医嘱  */
function getStandAsked(){
	var id = $("#exi_standPrescription").val();
	 $.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionAsked/find',
			data : "ssid=${sicmedUserBean.ssid}&pid="+id,
			cache : false,
			dataType : 'json',
			success : function(data) {
				console.log('查询到的标准处方下的医嘱有：')
				console.log(data);
				$("#standPrescription_doctor tbody").children().remove();
				if(data.sicmedStanderprescriptionAskedBeans){
					$.each(data.sicmedStanderprescriptionAskedBeans,function(index,val){
						$("#thead_secondTr").show();
						if(data.error == 0){
							//药品
							if(val.sicmedMedicalBean){
								if(val.sicmedMedicalBean.medicalNameChina){
									var unit;
									if(val.sicmedMedicalBean.unit1 == ""){
										unit = val.sicmedMedicalBean.unit2;
									}else{
										unit = val.sicmedMedicalBean.unit1;
									}
									
									$("#thead_secondTr").hide();
									$("#standPrescription_doctor tbody").append(
											"<tr align='center' id="+ val.id +" onclick='deleteStandardPrescription(this.id)' >"
											+"<td style='border-left:none;'>"+val.sicmedAskedClassBean.askedCalss+"</td>"
											+"<td>"+val.sicmedMedicalBean.medicalNameChina+"</td>"
											+"<td>"+val.sicmedMedicalBean.medicalStand+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+unit+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"		
									)
								}
							}
							//治疗
							if(val.sicmedCureCheckBean){
								if(val.sicmedCureCheckBean.cureName){
									$("#thead_secondTr").hide();
									$("#standPrescription_doctor tbody").append(
											"<tr align='center' id="+ val.id +" onclick='deleteStandardPrescription(this.id)' >"
											+"<td style='border-left:none;'>"+val.sicmedAskedClassBean.askedCalss+"</td>"
											+"<td>"+val.sicmedCureCheckBean.cureName+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"		
									)
								}
							}
							//检验
							if(val.sicmedInspectBean){
								if(val.sicmedInspectBean.inspectName){
									$("#thead_secondTr").hide();
									$("#standPrescription_doctor tbody").append(
											"<tr align='center' id="+ val.id +" onclick='deleteStandardPrescription(this.id)' >"
											+"<td style='border-left:none;'>"+val.sicmedAskedClassBean.askedCalss+"</td>"
											+"<td>"+val.sicmedInspectBean.inspectName+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"		
									)
								}
							}
							//检查
							if(val.sicmedTwxrayCheckBean){
								if(val.sicmedTwxrayCheckBean.checkName){
									$("#thead_secondTr").hide();
									$("#standPrescription_doctor tbody").append(
											"<tr align='center' id="+ val.id +" onclick='deleteStandardPrescription(this.id)' >"
											+"<td style='border-left:none;'>"+val.sicmedAskedClassBean.askedCalss+"</td>"
											+"<td>"+val.sicmedTwxrayCheckBean.checkName+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"<td>"+"-"+"</td>"
											+"</tr>"		
									)
								}
							}
						}
					})
				}
				
			},
			error : function() {
				alert("请求出错");
			}
		});
}

$(document).ready(function(){
	// 历史标准处方
	$("#query_historyStandPrescription").click(function(){
		if($("#history_standPrescription").is(":hidden")){
			$("#history_standPrescription").show(100);
			 getStand1();
		}else{
			$("#history_standPrescription").hide(100);
		}
		return false;
	})
	$("#search_historyStandPrescription").click(function(){
		$("#history_standPrescription").show(100);
		return false;
	})
	
	/* $("#content_right").css("cursor","pointer"); */
	$("#content_right").click(function(){
		$("#history_standPrescription").hide(100);
	})
	
	// 搜索历史标准处方
	$("#search_historyStandPrescription").on("input" , function(){
		var name = $(this).val();
		console.log(name)
		searchStand_lee(name);
	})
	
	/* 搜索医生个人的标准处方 */
	function searchStand_lee(name){
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionDisease/findByName',
			data : "ssid=${sicmedUserBean.ssid}&name="+name,
			cache : false,
			dataType : 'json',
			success : function(data) {
				console.log(data);
				 
				if(data.error == 0){
					if(data.sicmedStanderprescriptionDiseaseBeans){
						$("#historyStandPrescription_list").children().remove();
						$.each(data.sicmedStanderprescriptionDiseaseBeans , function(index,val){
							//$("#onekey_prescription_list").children().remove();
							$("#historyStandPrescription_list").append(
									"<li onclick='queryDoctorAskd(this.id)' id="+val.id+" style='cursor:pointer;padding-top:5px;padding-bottom:5px;' class='list-group-item'>"+ val.prescriptionName 
									+"<input type='hidden' id="+'standPrescription_id'+ val.id +" value="+val.id+">"
									+"<input type='hidden' id="+'stand_prescription_name'+ val.id +" value="+val.prescriptionName+">"
									+"<input type='hidden' id="+'disease_id'+ val.id +" value="+val.sicmedDiseaseBean.id+">"
									+"<input type='hidden' id="+'disease_name'+ val.id +" value="+val.sicmedDiseaseBean.diseaseName+">"
									+"</li>")
						})
					}
				}else{
					$("#historyStandPrescription_list").children().remove();
				}
			},
			error : function() {
				alert("请求出错");
			}
		});
	}
	
	
	/* 获取医生个人的标准处方  */
	function getStand1(){
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionDisease/get',
			data : "ssid=${sicmedUserBean.ssid}",
			cache : false,
			dataType : 'json',
			success : function(data) {
					console.log('获取到的标准处方有：')
					console.log(data);
					if(data.error == 0){
						if(data.sicmedStanderprescriptionDiseaseBeans){
							$("#historyStandPrescription_list").children().remove();
							$.each(data.sicmedStanderprescriptionDiseaseBeans , function(index,val){
								//$("#onekey_prescription_list").children().remove();
								$("#historyStandPrescription_list").append(
										"<li onclick='queryDoctorAskd(this.id)' id="+val.id+" style='cursor:pointer;padding-top:5px;padding-bottom:5px;' class='list-group-item'>"+ val.prescriptionName 
										+"<input type='hidden' id="+'standPrescription_id'+ val.id +" value="+val.id+">"
										+"<input type='hidden' id="+'stand_prescription_name'+ val.id +" value="+val.prescriptionName+">"
										+"<input type='hidden' id="+'disease_id'+ val.id +" value="+val.sicmedDiseaseBean.id+">"
										+"<input type='hidden' id="+'disease_name'+ val.id +" value="+val.sicmedDiseaseBean.diseaseName+">"
									+"</li>")
							})
						}
					}
				},
			error : function() {
				alert("请求出错");
				}
		});
	}
})
</script>

<script>
	$(document).ready(function(){
		$("#preservation_standSrescription").click(function(){
			var prescriptionName = $("#standPrescription_name").val();
			var diseaseId = $("#disease_item_id").val();
			var id = $("#exi_standPrescription").val();
			
			console.log("标准处方名称为：" + prescriptionName)
			console.log("标准处方id为：" + id)
			
			bootbox.setLocale("zh_CN");  
			bootbox.confirm({
				size: "small",
			    message: "确定保存?",
			    /* buttons: {
			        confirm: {
			            label: 'Yes',
			            className: 'btn-success'
			        },
			        cancel: {
			            label: 'No',
			            className: 'btn-danger'
			        }
			    }, */
			    callback: function (result) {
			        if(result==true){
			        	if(prescriptionName){
			        		preservatStandSrescript(prescriptionName,diseaseId,id);
			        	}else{
			        		bootbox.alert({
			        			size: "small",
  								buttons: {  
  									   ok: {  
  											label: '确定',  
  											className: 'btn-primary'  
  										}  
  									},  
  								message: '请选择或编辑标准处方',
  							})
			        	}
			        }else{
			        	console.log('取消保存')
			        }
			    }
			}); 
		})
	})
	
	// 保存（修改）标准处方
	function preservatStandSrescript(prescriptionName,diseaseId,id){
			$.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedStanderprescriptionDisease/saveOrUpdate',
				data : "ssid=${sicmedUserBean.ssid}&prescriptionName="+prescriptionName+"&id="+id+"&diseaseId="+diseaseId,
				cache : false,
				dataType : 'json',
				success : function(data) {
					console.log(data);
						if(data.error == 0){
							$("#exi_standPrescription").val(data.id);
							
							$("#stand_disease_model").hide(100)
						}
					},
				error : function() {
					alert("请求出错");
					}
			});
		}
</script>
<script type="text/javascript">

function getYesByPatient1111(id){
	// 开始工作
	$("#openWorkPre").addClass("lf_actives active");
	$("#openWorkPre a").attr("aria-expanded","true");
	$("#openWork_tab2").css({
	    "background-color": "#124256",
	    "color":"#fff"
		
	});
	$("#tab1").addClass("active in");
	// 患者列表
	$("#tab-patient").removeClass("in active");
	// 病历
	$("#tab-medical").addClass("in active");
	
	$("#openWork_tab1").css({
	    "background-color": "#fff",
	    "color":"#212121",
	    "border-color": "#bdbdbd"
	});
	
	// 诊疗记录
	$("#treatmentRecordPre").removeClass("lf_actives active"); 
	$("#treatmentRecordPre a").attr("aria-expanded","false");
	$("#tab3").removeClass("active in");
	
	
	getYesByPatient(id)
} 

$(document).ready(function () {
	/* 获取诊疗记录  */
	 function getCaseHistory(){
		var pageNo  = "1";
		var startDateTime = $("#beginDate").val();
		var endDateTime = $("#endDate").val();
		 console.log(startDateTime);
		 console.log(endDateTime)
		$.ajax({
			type : 'get',
			url : 'http://127.0.0.1:8082/jeesite/a/rest/sicmedCase/zlSeachCase',
			data : "ssid=${sicmedUserBean.ssid}"+"&startDateTime="+startDateTime+"&endDateTime="+endDateTime+"&pageNo="+pageNo,
			cache : false,
			dataType : 'json', 
			success : function(data) {
					console.log(data);
					if(data.error == 0){
						$("#total_No").html(data.sicmedCaseBeans.length);
						$("#diagnosis_records tbody").children().remove();
						$.each(data.sicmedCaseBeans,function(index,val){
							
							$("#diagnosis_records tbody").append("<tr align='center'>"
									+"<td style='border-top-left-radius: 6px;'>"+val.sicmedPatientBean.patientNumber+"</td>"
									+"<td>"+val.sicmedPatientBean.patientName+"</td>"
									+"<td>"+val.sicmedPatientBean.patientAge+"</td>"
									+"<td>"+val.sicmedPatientBean.patientSex+"</td>"
									+"<td>"+val.branchName+"</td>"
									+"<td>"+val.sicmedPatientBean.patientFirstdate+"</td>"
									/* +"<td>状态</td>" */
									+"<td style='border-top-right-radius: 6px'><a href='javascript:;' id="+val.sicmedPatientBean.id+" style='background-color:#ffc107;border-color:#ffc107;box-shadow:0px 2px 10px 0px rgba(0, 0, 0, 0 , 50);padding:4px 16px;' class='btn btn-warning' onclick='getYesByPatient1111(this.id)'>查看</a></td></tr>"
									) 
						})
					}
				},
			error : function() {
				alert("请求出错");
				}
		});
	}
	
		
		$('#getCaseHistory_b').click(function () { 
		
			getCaseHistory();
		   	
		   }); 
		
		
		
		
		// 退出
		$("#exit").click(function(){
			$("#exit a").attr('target','_blank')
			/* $.ajax({
				type : 'get',
				url : 'http://127.0.0.1:8082/jeesite/a/web/sicmedUser/index?ssid=${sicmedUserBean.ssid}',
				data : "ssid=${sicmedUserBean.ssid}",
				cache : false,
				dataType : 'json', 
				success : function(data) {
						console.log(1)
						console.log(data);
						
					},
				error : function(error) {
					console.log(error);
					}
			});  */
			
			bootbox.setLocale("zh_CN");
			bootbox.confirm({ 
				  size: "small",
				  message: "确定要退出吗?", 
				  callback: function(result){ 
					  if(result==true){
						  //window.location.href="http://127.0.0.1:8082/jeesite/a/web/sicmedUser/index?ssid=${sicmedUserBean.ssid}";
						  location.replace("http://127.0.0.1:8082/jeesite/a/web/sicmedUser/index")
					  }else{
						console.log("取消退出");
					  }
				  }
				})
				
			
			return false;
		})
			
		
		
}) 
</script>
</html>