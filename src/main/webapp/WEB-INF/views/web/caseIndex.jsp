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
<style type="text/css">
* {
	/* border: 1px red solid;    */
	margin: 0px;
	padding: 0px;
}

body {
	background: #fff;
}

textarea {
	min-height: 80px;
	overflow: hidden;
	border: none;
	resize: none;
}

/* input 输入框 清除边框  */
.inputBoderNone{
	border: none;
	text-align: center;
	width: auto;
}
/* 圆头像  */
 .roundHeadportrait{
	 width:100px;
	 height:100px;
	 border-radius:100px
 }
 /* 段落标签首行缩进  */
 #news_view p{
	text-indent: 2em; /*em是相对单位，2em即现在一个字大小的两倍*/ 
 }
</style>
</head>
<body style="overflow:scroll;">
	<div class="row">
		<!-- 顶部导航栏 -->
		<div class="col-sm-12">
			<nav class="navbar navbar-default navbar-inverse ">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Brand</a>
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
						<li><a href="#">Link</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">Submit</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">Link</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
					</ul>
				</div>
			</div>
			</nav>
		</div>
		<!-- 网页内容主体 -->
		<div class="col-sm-12">
			<div class="row">
				<!-- 左侧导航栏 -->
				<div class="col-sm-2">
					<div class="row">
						<div class="col-sm-12" style="text-align: center;">
							<div class="page-header">
							<img class="roundHeadportrait" alt="" src="/jeesite/static/Pc/img/headportrait.png">
								<p>${sicmedUserBean.userName}</p>
								<h3>医生工作站</h3>
							</div>
						</div>
					</div>
					<div class="list-group">
						<a id="start_job" href="#" class="list-group-item active">开始工作</a>
						<a id="stand_job" href="#" class="list-group-item">标准处方</a> <a
							id="history_job" href="#" class="list-group-item">诊疗记录</a> <a
							id="other_job" href="#" class="list-group-item">其他</a>
					</div>
				</div>
<!-- 新闻页 -->
				<div id="news_view" class="col-sm-8"
					style="border-left: 3px #EEEEEE solid;">
					<div class="jumbotron">
					  <h1>院内, 新闻!</h1>
					  <p>XXX人民医院简介  XXX人民医院是国有公立非营利性医院、保定市首批国家二级甲等综合医院、爱婴医院；建于1950年迄今已有60余年发展历程。先后获得“全国百姓放心医院”、“市卫生系统先进单位”、“市级信得过单位”、“县级先进基层党支部”等光荣称号。  
					  </p>
					  <p>几十年来，经过几代人的不懈努力，医院从小到大.由弱变强,实现了长足发展和质的飞跃,已发展成为一所集医疗、教学、科研、预防、康复、保健为一体的现代化县级综合医院，是XXX唯一一家二级甲等医院、全县120急救中心。  
					  </p>
					  <p>医院现有职工426名，其中卫生技术人员355名。副高职称16名，中级职称74名，初级职称247名。   
					  </p>
					  <p>医院开放床位400张，医疗科室33个，其中临床科室23个［内一科（心内、血液）、内二科（神内、免疫）、内三科（消化、内分泌）、内四科（呼吸、肾内）、外一科（普外、泌尿外）、外二科（骨外）、外三科（胸外、神外）、外四科（儿外、整形外科）、妇科、产科、儿科、感染性疾病科、急诊科、重症医学科、手术室、麻醉科、中医科、针灸科、理疗科、口腔科、眼科、耳鼻喉科、皮肤科］；医技功能科室10个（影像科、检验科、功能科、导管室、病理科、胃镜室、脑电图室、心电图室、高压氧、 供应室）。  
					  </p>
					  <p>医院拥有血管造影介入治疗系统、飞利浦螺旋CT、美国 GE彩色多普勒、日本产欧林巴斯内窥镜和腹腔镜、美国产核磁共振、美国产CR、DR、美国贝克曼LX20速全自动生化分析仪、全自动血球计数仪、德国莱卡快速冰冻病理仪、西门子新凤凰四维彩超、奥林巴斯电子胃镜、神经外科手术显微镜、手术动力系统装置等大型先进医疗仪器30余台（件）。 
					  </p>
					  <p> 脑血管内科,是河北省中医重点专科,拥有医师11人，其中副高级以上1人，中级5人，初级5人，每年收治脑梗塞病人300余例，采用中西医结合治疗方法,费用低,疗效显著；糖尿病科,是市级中医重点专科,获河北省科学技术二等奖两项,拥有医师12人，其中主任医师1人，副主任医师1名,中级4人，初级6人，科内配备有血糖仪，胰岛素泵，应用先进的治疗方案，对糖尿病人进行规范治疗，糖尿病患者病情都得到了良好的控制；普外、泌尿外科拥有医师8名，其中副高级以上1名，中级5名，初级2名，已成功独立完成腹腔镜下行直肠癌、结肠癌根治术，胃癌根治术和甲状腺切除术；心胸外科拥有医师8名，副高级以上1名，中级4名，初级3名，成功开展肺癌、食道癌外科手术；整形美容外科拥有医师8名，其中副高级以上1名，中级4名，初级3名， 10多年前已成功开展了唇腭裂手术，现积极迈向医学美容领域，皮肤伤口美容缝合术已广泛应用于临床；血液科拥有医师11名，副高级以上1名，中级5名，初级5名，在诊治慢性粒细胞白血病方面积累了一定经验。 
 					  </p>
					  <p>目前，无论在规模、病种诊治范围、设备仪器先进程度、特色专科、科技人才结构以及单病种治愈水平等方面，都达到了一定水平，真正做到了让老百姓大病不出县，切实减轻了群众负担，有效的解决了百姓看病难、看病贵的问题。</p>
					  <p><a style="text-indent: 0em;" class="btn btn-primary btn-lg" href="#" role="button">查看更多</a></p>
					</div>
				</div>
<!-- 开始工作 -->
				<div id="start_job_view" class="col-sm-8" style="border-left: 3px #EEEEEE solid;border-right: 3px #EEEEEE solid; display: none;">
					<div class="tabbable tabs-left">
						<ul class="nav nav-tabs">
							<li id="patient_view_title" class="active"><a href="#tab1" data-toggle="tab">患者列表</a></li>
							<li id="case_view_title"><a href="#tab2" data-toggle="tab">病历</a></li>
							<li id="asked_view_title"><a href="#tab3" data-toggle="tab">医嘱信息</a></li>
						</ul>
						<div class="tab-content">
						<!-- 患者信息搜索 -->	
							<br>						
	<!-- 医生可以诊疗的患者列表 -->	
							<div id="patient_view" class="tab-pane fade active in" id="tab1">
								<div class="row">
									<div class="col-sm-4">
										<div class="input-group">
											<input type="text" class="form-control" placeholder="输入患者姓名或者患者编号..."> 
												<span class="input-group-btn">
												<button class="btn btn-default" type="button">搜索!</button>
											</span>
										</div>
									</div>
								</div>
								<!-- 患者信息显示 -->
								<br>	
								<table id="tab_patient" class="table table-hover table-responsive">
									
								</table>
								<nav aria-label="Page navigation">
									<ul class="pagination pagination-lg">
								    	<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
								    	<li><a href="#">1</a></li>
								    	<li><a href="#">2</a></li>
								    	<li><a href="#">3</a></li>
								    	<li><a href="#">4</a></li>
								    	<li><a href="#">5</a></li>
								    	<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
								    </li>
								  </ul>
								</nav>
							</div>
							<!-- 开始工作 - 病历信息 -->							
							<div id="case_view" class="tab-pane fade" id="tab2">
								<form id="case_form" action="">
									<br /> 
									<span class="label label-default" style="font-size: x-large;">患者信息</span>
									<br /> 
									<br />
									<div  class="form-control" style="font-style: inherit;font-size: large; border: none;" >
										<div class="row">
											<input type="hidden" class="inputBoderNone" id="patientId_h" ></input>
											<div class="col-sm-4">患者编号:<input readOnly="true"  class="inputBoderNone" id="patientNumber" ></input></div>
											<div class="col-sm-4">患者姓名:<input readOnly="true"  class="inputBoderNone" id="patientName" ></input></div>
											<div class="col-sm-4">患者性别:<input readOnly="true"  class="inputBoderNone" id="patientSex" ></input></div>
										</div>
										<div class="row">
											<div class="col-sm-4">患者年龄:<input readOnly="true"  class="inputBoderNone" id="patientAge"></input></div>
											<div class="col-sm-4">联系电话:<input readOnly="true"  class="inputBoderNone" id="" ></input></div>
											<div class="col-sm-4">患者住址:<input readOnly="true"  class="inputBoderNone" id="" ></input></div>
										</div>
										<div class="row">
											<div class="col-sm-4">挂号科室:<input readOnly="true"  class="inputBoderNone" id="" ></input></div>
											<div class="col-sm-4">挂号类别:<input readOnly="true"  class="inputBoderNone" id="" ></input></div>
											<div class="col-sm-4">挂号医生:<input readOnly="true"  class="inputBoderNone" id="" ></input></div>
										</div>
									</div>
									<br />
									<br />
									<br /> 
									<br />
									<br /> 
									<span class="label label-primary" style="font-size: x-large;">病历信息</span> 
									<input type="hidden" name="id" id="caseId_h">
									<br /> 
									<br /> 
									<span class="label label-success" style="font-size: medium;">主诉</span>
									<input type="hidden" name="caseTell" id="caseTell_h">
									<br /> 
									<br />
									<textarea id="caseTell" class="form-control" style="border: none;"> </textarea>
									<br /> 
									<span class="label label-danger" style="font-size: medium;">现病史</span> 
									<input type="hidden" name="caseHistory" id="caseHistory_h">
									<br /> 
									<br />
									<textarea id="caseHistory" class="form-control" style="border: none;"> </textarea>
									<br /> 
									<span class="label label-danger" style="font-size: medium;">既往史</span> 
									<input type="hidden" name="caseAllergy" id="caseAllergy_h">
									<br /> 
									<br />
									<textarea id="caseAllergy" class="form-control" style="border: none;"></textarea>
									<br /> 
									<span class="label label-danger" style="font-size: medium;">个人及家族史</span> 
									<input type="hidden" name="familyAllergy" id="familyAllergy_h">
									<br /> 
									<br />
									<textarea id="familyAllergy" class="form-control" style="border: none;"> </textarea>
									<br /> 
									<span class="label label-info" style="font-size: medium;">体格检查</span> 
									<input type="hidden" name="checkCodeBody" id="checkCodeBody_h">
									<br /> 
									<br />
									<textarea id="checkCodeBody" class="form-control" style="border: none;"> </textarea>
									<br /> 
									<span class="label label-info" style="font-size: medium;">辅助检查</span> 
									<input type="hidden" name="checkCodeAid" id="checkCodeAid_h">
									<br /> 
									<br />
									<textarea id="checkCodeAid" class="form-control" style="border: none;"> </textarea>
									<br /> 
									<span class="label label-warning" style="font-size: medium;">诊断</span> 
									<br /> 
									<br />
									<div id="sicmedPatientDiseaseBeans" class="form-control" style="border: none;"> 
									<button id='disease_list' class='btn btn-primary glyphicon glyphicon-plus' type='button'>添加疾病</button>
									</div>
									<br />
								</form>
								<div class="row">
									<div class="col-sm-5">
									</div>
									<div class="col-sm-2">
										<div class="btn-group dropup">
											<button id="case_form_submit" type="button" class="btn btn-default">保存病历</button>
										</div>
										<div class="btn-group dropup">
											<button id="asked_view_show" type="button" class="btn btn-default">添加医嘱</button>
										</div>
									</div>
									<div class="col-sm-5">
									</div>
								</div>
							</div>
	<!-- 开始工作 - 医嘱信息 -->							
							<div id="asked_view" class="tab-pane fade" id="tab3">
								<button type="button" onclick="addStandAsked ()" data-loading-text="Loading..." class="btn btn-primary glyphicon glyphicon-plus" autocomplete="off" style="font-size: medium;float: right;">
								标准处方调用
								</button>
								<br><br><br> 
								<span class="label label-primary" style="font-size: x-large;background-color: #B082E2;">检查医嘱</span> 
								<input type="hidden" id="check_asked_class_h">
								<br /> 
								<br />
								<table id="tab_check" class="table table-hover table-responsive" style='margin 0;padding 0;border 0;'>
								</table>
								<span class="label label-primary" style="font-size: x-large;background-color: #37CAF5;">检验医嘱</span>
								<input type="hidden" id="inspect_asked_class_h">
								<br /> 
								<br />
								<table id="tab_inspect" class="table table-hover table-responsive">
								</table>
								<span class="label label-primary" style="font-size: x-large;background-color: #719CFA;">治疗医嘱</span>
								<input type="hidden" id="cure_asked_class_h">
								<br /> 
								<br /> 
								<table id="tab_cure" class="table table-hover table-responsive">
								</table>
								<span class="label label-primary" style="font-size: x-large;background-color: #FF985B;">药品医嘱</span>
								<input type="hidden" id="medical_asked_class_h">
								<br /> 
								<br /> 
								<table id="tab_medical" class="table table-hover table-responsive">
								</table>
								<br> 
								<br>
								<div class="row">
									<div class="col-sm-5">
									</div>
									<div class="col-sm-2">
										<div class="btn-group dropup">
											<button id="asked_form_submit" type="button" class="btn btn-default">保存医嘱</button>
										</div>
										<div class="btn-group dropup">
											<button id="asked_print_show" type="button" class="btn btn-default">打印医嘱</button>
										</div>
									</div>
									<div class="col-sm-5">
									</div>
								</div>
								<br> 
								<br>
								<br> 
								<br>
								<br> 
								<br> 
							</div>
						</div>
					</div>
				</div>
<!-- 标准处方 -->
				<div id="stand_job_view" class="col-sm-8"
					style="border-left: 3px #EEEEEE solid; display: none;">
					<div class="tabbable tabs-left">
						<ul class="nav nav-tabs">
							<li id="stand_view_title" class="active"><a href="#tab111" data-toggle="tab">标准处方列表</a></li>
							<li id="stand_asked_view_title"><a href="#tab222" data-toggle="tab">处方中的医嘱</a></li>
						</ul>
						<div class="tab-content">
	<!-- 标准处方 - 个人标准处方列表 -->
							<div id="stand_view" class="tab-pane fade active in" id="tab111">
							<br>
								<div class="row">
									<div class="col-sm-4">
										<div class="input-group">
											<input type="text" class="form-control" placeholder="输入处方名"> 
												<span class="input-group-btn">
												<button class="btn btn-default" type="button">搜索!</button>
											</span>
										</div>
									</div>
									<div class="col-sm-4">
									</div>
									<div class="col-sm-4">
									<button style="float: right;" type="button" id="myButton" data-loading-text="Loading..." class="btn btn-primary" autocomplete="off">
									  添加标准处方
									</button>
									</div>
								</div>
								<!-- 患者信息显示 -->
								<br>	
								<table id="tab_stand" class="table table-hover table-responsive">
									
								</table>
								<nav aria-label="Page navigation">
									<ul class="pagination pagination-lg">
								    	<li><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
								    	<li><a href="#">1</a></li>
								    	<li><a href="#">2</a></li>
								    	<li><a href="#">3</a></li>
								    	<li><a href="#">4</a></li>
								    	<li><a href="#">5</a></li>
								    	<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
								    </li>
								  </ul>
								</nav>
							</div>
	<!-- 标准处方 - 处方中的医嘱 -->						
							<div id="stand_asked_view" class="tab-pane fade" id="tab222">
							<br> <br> <br> 
								<span class="label label-primary" style="font-size: x-large;background-color: #B082E2;">检查</span> 
								<input type="hidden" id="stand_check_asked_class_h">
								<br> 
								<br />
								<table id="tab_stand_check" class="table table-hover table-responsive" style='margin 0;padding 0;border 0;'>
								</table>
								<span class="label label-primary" style="font-size: x-large;background-color: #37CAF5;">检验</span>
								<input type="hidden" id="stand_inspect_asked_class_h">
								<br /> 
								<br />
								<table id="tab_stand_inspect" class="table table-hover table-responsive">
								</table>
								<span class="label label-primary" style="font-size: x-large;background-color: #719CFA;">治疗</span>
								<input type="hidden" id="stand_cure_asked_class_h">
								<br /> 
								<br /> 
								<table id="tab_stand_cure" class="table table-hover table-responsive">
								</table>
								<span class="label label-primary" style="font-size: x-large;background-color: #FF985B;">药物</span>
								<input type="hidden" id="stand_medical_asked_class_h">
								<br /> 
								<br /> 
								<table id="tab_stand_medical" class="table table-hover table-responsive">
								</table>
								<br> 
								<br>
								<div class="row">
									<div class="col-sm-5">
									</div>
									<div class="col-sm-2">
										<div class="btn-group dropup">
											<button id="asked_form_submit" type="button" class="btn btn-default">保存</button>
										</div>
									</div>
									<div class="col-sm-5">
									</div>
								</div>
								<br> 
								<br>
								<br> 
								<br> 
							</div>
						</div>
					</div>
				</div>
				<!-- 诊疗记录 -->
				<div id="history_job_view" class="col-sm-8"
					style="border-left: 3px #EEEEEE solid; display: none;">
					<div class="tabbable tabs-left">
						<ul class="nav nav-tabs">
							<li><a href="#tab1111" data-toggle="tab">最近诊疗记录</a></li>
							<li><a href="#tab2222" data-toggle="tab">历史诊疗记录</a></li>
							<li><a href="#tab3333" data-toggle="tab">未完成记录</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active fade" id="tab1111"></div>
							<div class="tab-pane fade" id="tab2222"></div>
							<div class="tab-pane fade" id="tab3333"></div>
						</div>
					</div>
				</div>
				<!-- 其他工作 -->
				<div id="other_job_view" class="col-sm-8"
					style="border-left: 3px #EEEEEE solid; display: none;">
					<div class="tabbable tabs-left">
						<ul class="nav nav-tabs">
							<li><a href="#tab11111" data-toggle="tab">其他1</a></li>
							<li><a href="#tab22222" data-toggle="tab">其他2</a></li>
							<li><a href="#tab33333" data-toggle="tab">其他3</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active fade" id="tab11111"></div>
							<div class="tab-pane fade" id="tab22222"></div>
							<div class="tab-pane fade" id="tab33333"></div>
						</div>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="row">
						<div class="col-sm-12" style="text-align: center;">
							<div class="page-header">
								<h3>日历</h3>
								<button id="iframe_test" type="button" class="btn btn-default navbar-btn">弹窗</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/jeesite/static/jquery/jquery-1.9.1.min.js"
		type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js"
		type="text/javascript"></script>

<!-- 点击事件 -->
	<script type="text/javascript">
		$(function() {
	//----------- 开始工作 视图切换 begin ------------------------------------//
	//点击标签切换 
			$("#patient_view_title").click(function(){
			//隐藏其他视图
				$("#case_view_title").removeClass("active");
				$("#case_view_title").removeClass("in");
				$("#case_view").removeClass("active");
				$("#case_view").removeClass("in");
				
				$("#asked_view_title").removeClass("active");
				$("#asked_view_title").removeClass("in");
				$("#asked_view").removeClass("active");
				$("#asked_view").removeClass("in");
			//显示视图	
				$("#patient_view_title").addClass("active");
				$("#patient_view_title").addClass("in");
				$("#patient_view").addClass("active");
				$("#patient_view").addClass("in");
			})
		
			$("#case_view_title").click(function(){
				//判断是否已经选择患者
				var patientId = getPatientId();
				console.log(patientId);
				if(patientId == ""){
					alert("请先选择患者");
					return;
				}
			//隐藏其他视图
				$("#patient_view_title").removeClass("active");
				$("#patient_view_title").removeClass("in");
				$("#patient_view").removeClass("active");
				$("#patient_view").removeClass("in");
				
				$("#asked_view_title").removeClass("active");
				$("#asked_view_title").removeClass("in");
				$("#asked_view").removeClass("active");
				$("#asked_view").removeClass("in");
			//显示视图	
				$("#case_view_title").addClass("active");
				$("#case_view_title").addClass("in");
				$("#case_view").addClass("active");
				$("#case_view").addClass("in");
			})
			$("#asked_view_title").click(function(){
				//判断是否已经选择患者
				var patientId = getPatientId();
				if(patientId == ""){
					alert("请先选择患者");
					return;
				}else{
				//隐藏其他视图
				$("#patient_view_title").removeClass("active");
				$("#patient_view_title").removeClass("in");
				$("#patient_view").removeClass("active");
				$("#patient_view").removeClass("in");
				
				$("#case_view_title").removeClass("active");
				$("#case_view_title").removeClass("in");
				$("#case_view").removeClass("active");
				$("#case_view").removeClass("in");
			//显示视图	
				$("#asked_view_title").addClass("active");
				$("#asked_view_title").addClass("in");
				$("#asked_view").addClass("active");
				$("#asked_view").addClass("in");
				}
			})
			
	//点击按钮切换	
			$("#asked_view_show").click(function(){
			//隐藏其他视图
				$("#case_view_title").removeClass("active");
				$("#case_view_title").removeClass("in");
				$("#case_view").removeClass("active");
				$("#case_view").removeClass("in");
			//显示视图	
				$("#asked_view_title").addClass("active");
				$("#asked_view_title").addClass("in");
				$("#asked_view").addClass("active");
				$("#asked_view").addClass("in");
			})
			
			
	//----------- 开始工作 视图切换 end ------------------------------------//
	
	//-----------病历 textarea 转 input --begin------------------------------//
			$("#caseTell").change(function(){
				$("#caseTell_h").val($("#caseTell").val())
			})
			$("#caseHistory").change(function(){
				$("#caseHistory_h").val($("#caseHistory").val())
			})
			$("#pastHistory").change(function(){
				$("#pastHistory_h").val($("#pastHistory").val())
			})
			$("#caseAllergy").change(function(){
				$("#caseAllergy_h").val($("#caseAllergy").val())
			})
			$("#familyAllergy").change(function(){
				$("#familyAllergy_h").val($("#familyAllergy").val())
			})
			$("#checkCodeBody").change(function(){
				$("#checkCodeBody_h").val($("#checkCodeBody").val())
			})
			$("#checkCodeAid").change(function(){
				$("#checkCodeAid_h").val($("#checkCodeAid").val())
			})
	//-------------病历 textarea 转 input --end --------------------------------//
			
			$("#start_job").click(function() {
				aa();
				$("#stand_job_view").hide();
				$("#history_job_view").hide();
				$("#other_job_view").hide();
				$("#news_view").hide();
				$("#start_job_view").show();

			})
			$("#stand_job").click(function() {
				getStand();
				$("#start_job_view").hide();
				$("#history_job_view").hide();
				$("#other_job_view").hide();
				$("#news_view").hide();
				$("#stand_job_view").show();
			})
			$("#history_job").click(function() {
				getHistory();
				$("#start_job_view").hide();
				$("#stand_job_view").hide();
				$("#other_job_view").hide();
				$("#news_view").hide();
				$("#history_job_view").show();
			})
			$("#other_job").click(function() {
				$("#start_job_view").hide();
				$("#stand_job_view").hide();
				$("#history_job_view").hide();
				$("#news_view").hide();
				$("#other_job_view").show();
			})

		})
		
		$(function(){
			$("#stand_view_title").click(function(){
				//隐藏其他视图
					$("#stand_asked_view_title").removeClass("active");
					$("#stand_asked_view_title").removeClass("in");
					$("#stand_asked_view").removeClass("active");
					$("#stand_asked_view").removeClass("in");
					
				//显示视图	
					$("#stand_view_title").addClass("active");
					$("#stand_view_title").addClass("in");
					$("#stand_view").addClass("active");
					$("#stand_view").addClass("in");
				})
				
			$("#stand_asked_view_title").click(function(){
			//隐藏其他视图
				$("#stand_view_title").removeClass("active");
				$("#stand_view_title").removeClass("in");
				$("#stand_view").removeClass("active");
				$("#stand_view").removeClass("in");
				
			//显示视图	
				$("#stand_asked_view_title").addClass("active");
				$("#stand_asked_view_title").addClass("in");
				$("#stand_asked_view").addClass("active");
				$("#stand_asked_view").addClass("in");
			})
		})
		
	</script>
<!-- 获取所有可以诊疗的患者信息 -->	
	<script type="text/javascript">
	//获取所有可以诊疗的患者
	function aa() {
		$.ajax({
			type : 'get',
			url : 'http://localhost:8082/jeesite/a/rest/sicmedRegistered/findShow',
			data : "ssid=${sicmedUserBean.ssid}",
			cache : false,
			dataType : 'json',
			success : function(data) {
						//	var a = JSON.stringify(data);//jsonObj 转 jsonStr
						console.log(data);
						$.each(data,function(name, value) {
							$("#tab_patient").children().remove();
							$("#tab_patient").append("<tr align='center'><td class='active'>#</td><td class='success'>患者姓名</td><td class='warning'>患者编号</td><td class='danger'>患者性别</td><td class='info'>患者年龄</td></tr>");
							if (name == "sicmedPatientBeans") {
								$.each(value,function(name2,value2) {
									$("#tab_patient").append("<tr id="+ value2.id+ " align='center' onclick='bb(this.id)'>"
										+ '<td class="active">'+ name2+ '</td>'
										+ '<td class="success">'+ value2.patientName+ '</td>'
										+ '<td class="warning">'+ value2.patientNumber + '</td>'
										+ '<td class="danger">'+ value2.patientSex+ '</td>'
										+ '<td class="info">'+ value2.patientAge+ '</td>'
										+ "</tr>");
								});
							}
						});
						$("#tab_patient tr").bind('click', function() {
						});
						},
						error : function() {
							alert("请求出错");
						}
			});
			
		}
	</script>
<!-- 根据患者ID 获取 病历信息 和 医嘱信息 并跳转到病历页面 -->	
	<script type="text/javascript">
		//根据患者 id 获取患者病历 医嘱信息 
		function bb(id){
			$.ajax({
				type : 'get',
				url : 'http://localhost:8082/jeesite/a/rest/sicmedCase/getByPatient',
				data : "ssid=${sicmedUserBean.ssid}&patientId="+id,
				cache : false,
				dataType : 'json',
				success : function(data) {
							console.log(data);
							
							$.each(data,function(name, value) {
								//病历信息显示赋值 
								$("#caseTell").val(data.caseTell)
								$("#caseHistory").val(data.caseHistory)
								$("#pastHistory").val(data.pastHistory)
								$("#caseAllergy").val(data.caseAllergy)
								$("#familyAllergy").val(data.familyAllergy)
								$("#checkCodeBody").val(data.checkCodeBody)
								$("#checkCodeAid").val(data.checkCodeAid)
								//病历信息隐藏域赋值
								$("#caseId_h").val(data.id)
								$("#caseTell_h").val(data.caseTell)
								$("#caseHistory_h").val(data.caseHistory)
								$("#pastHistory_h").val(data.pastHistory)
								$("#caseAllergy_h").val(data.caseAllergy)
								$("#familyAllergy_h").val(data.familyAllergy)
								$("#checkCodeBody_h").val(data.checkCodeBody)
								$("#checkCodeAid_h").val(data.checkCodeAid)
								//患者信息赋值
								if (name == "sicmedPatientBean") {
									$("#patientId_h").val(value.id)
									$("#patientAge").val(value.patientAge)
									$("#patientName").val(value.patientName)
									$("#patientNumber").val(value.patientNumber)
									$("#patientSex").val(value.patientSex)
								}
								//清除疾病模块下的所有子元素
								$("#sicmedPatientDiseaseBeans").children().remove();
								//添加疾病
								if(name == "sicmedPatientDiseaseBeans"){
									$.each(value,function(name2, value2) {
										$("#sicmedPatientDiseaseBeans").append("<button id="+value2.diseaseName+ " class='btn btn-primary' type='button'>"
											+value2.diseaseName
											+"<span id="+value2.id+ " class='badge delete' onclick='deletePatientDisease(this.id)'>x</span></button>&nbsp;");
									});
									//给所有疾病删除图标绑定点击事件
									$("#sicmedPatientDiseaseBeans span").bind('click', function() {  
									 });
								}
								//疾病模块添加 添加疾病按钮
								$("#sicmedPatientDiseaseBeans").append("<button id='disease_list' onclick='showDiseaseList()' class='btn btn-primary glyphicon glyphicon-plus' type='button'>添加疾病</button>");
								$("#sicmedPatientDiseaseBeans button").bind('click', function() {  
								 });
								//医嘱信息显示
								if(name == "sicmedAskedBeans"){
									
									$("#tab_check").children().remove();
									$("#tab_inspect").children().remove();
									$("#tab_cure").children().remove();
									$("#tab_medical").children().remove();
									
									$("#tab_check").append(
											"<tr align='center'>"
											+"<td class='success'>检查编码</td>"
											+"<td class='active'>检查名称</td>"
											+"<td class='active'>检查详情</td>"
											+"<td class='active'>操作</td>"
											+"</tr>"
									);
									$("#tab_inspect").append(
											"<tr align='center'>"
											+"<td class='success'>检验编码</td>"
											+"<td class='active'>检验名称</td>"
											+"<td class='active'>检验详情</td>"
											+"<td class='active'>操作</td>"
											+"</tr>"
									);
									$("#tab_cure").append(
											"<tr align='center'>"
											+"<td class='success'>治疗编码</td>"
											+"<td class='active'>治疗名称</td>"
											+"<td class='active'>治疗详情</td>"
											+"<td class='active'>操作</td>"
											+"</tr>"
									);
									$("#tab_medical").append(
											"<tr align='center'>"
											+"<td class='success'>药品编码</td>"
											+"<td class='active'>药品名称</td>"
											+"<td class='danger'>剂型</td>"
											+"<td class='info'>给药途径</td>"
											+"<td class='success'>单次剂量</td>"
											+"<td class='active'>每日次数</td>"
											+"<td class='warning'>用药天数</td>"
											+"<td class='active'>操作</td>"
											+"</tr>"
									);
									$.each(value,function(name3, value3) {
										
										if(value3.sicmedAskedClassBean.classNumber == "0"){
											$("#check_asked_class_h").val(value3.sicmedAskedClassBean.id);
										}
										if(value3.sicmedAskedClassBean.classNumber == "1"){
											$("#inspect_asked_class_h").val(value3.sicmedAskedClassBean.id);											
										}
										if(value3.sicmedAskedClassBean.classNumber == "2"){
											$("#cure_asked_class_h").val(value3.sicmedAskedClassBean.id);
										}
										if(value3.sicmedAskedClassBean.classNumber == "3"){
											$("#medical_asked_class_h").val(value3.sicmedAskedClassBean.id);
										}
										
										if(value3.sicmedAskedClassBean.classNumber == "0"&&typeof(value3.sicmedTwxrayCheckBean)!="undefined"){
											$("#tab_check").append("<tr align='center'>"
													+"<td class='success'>"+value3.sicmedTwxrayCheckBean.checkCode+"</td>"
													+"<td class='active'>"+value3.sicmedTwxrayCheckBean.checkName+"</td>"
													+"<td class='warning'>"+value3.sicmedTwxrayCheckBean.checkDetail+"</td>"
													+"<td class='active'>"
													+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"
													+"删除"
													+"</button>"
													+"</td>"
													+"</tr>"
											);	
										}
										if(value3.sicmedAskedClassBean.classNumber == "1"&&typeof(value3.sicmedInspectBean)!="undefined"){
											$("#tab_inspect").append("<tr align='center'>"
													+"<td class='success'>"+value3.sicmedInspectBean.inspectCode+"</td>"
													+"<td class='active'>"+value3.sicmedInspectBean.inspectName+"</td>"
													+"<td class='warning'>"+value3.sicmedInspectBean.inspectDetail+"</td>"
													+"<td class='active'>"
													+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"
													+"删除"
													+"</button>"
													+"</td>"
													+"</tr>"
												);	
										}
										if(value3.sicmedAskedClassBean.classNumber == "2"&&typeof(value3.sicmedCureCheckBean)!="undefined"){
											$("#tab_cure").append("<tr align='center'>"
													+"<td class='success'>"+value3.sicmedCureCheckBean.cureCode+"</td>"
													+"<td class='active'>"+value3.sicmedCureCheckBean.cureName+"</td>"
													+"<td class='warning'>"+value3.sicmedCureCheckBean.cureDetail+"</td>"
													+"<td class='active'>"
													+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"
													+"删除"
													+"</button>"
													+"</td>"
													+"</tr>"
												);	
										}
										if(value3.sicmedAskedClassBean.classNumber == "3"&&typeof(value3.sicmedMedicalBean)!="undefined"){
											$("#tab_medical").append(
													"<tr align='center'>"
													+"<td class='success'>"+value3.sicmedMedicalBean.medicalCode+"</td>"
													+"<td class='active'>"+value3.sicmedMedicalBean.medicalNameChina+"</td>"
													+"<td class='danger'>"+value3.sicmedMedicalUseBean.useUnit+"</td>"
													+"<td class='info'>"+value3.sicmedMedicalUseBean.useGroup+"</td>"
													+"<td class='success'>"+value3.sicmedMedicalUseBean.useAmount+"</td>"
													+"<td class='active'>"+value3.sicmedMedicalUseBean.useBout+"</td>"
													+"<td class='warning'>"+value3.sicmedMedicalUseBean.useDay+"</td>"
													+"<td class='active'>"
													+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"
													+"删除"
													+"</button>"
													+"</td>"
													+"</tr>"
												);	
										}
									});
									$("#tab_check").append(
											"<tr align='center'>"
											+"<td class='' colspan='4'>"
											+"<button type='button' onclick='showCheckList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"
											+"添加检查医嘱"
											+"</button>"
											+"</td>"
											+"</tr>"
									);
									$("#tab_inspect").append(
											"<tr align='center'>"
											+"<td class='' colspan='4'>"
											+"<button type='button' onclick='showInspectList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"
											+"添加检验医嘱"
											+"</button>"
											+"</td>"
											+"</tr>"
									);
									$("#tab_cure").append(
											"<tr align='center'>"
											+"<td class='' colspan='4'>"
											+"<button type='button' onclick='showCureList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"
											+"添加治疗医嘱"
											+"</button>"
											+"</td>"
											+"</tr>"
									);
									$("#tab_medical").append(
											"<tr align='center'>"
											+"<td class='' colspan='8'>"
											+"<button type='button' onclick='showMedicalList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"
											+"添加药品医嘱"
											+"</button>"
											+"</td>"
											+"</tr>"
									);
								}
							});
							$("#patient_view_title").removeClass("active");
							$("#patient_view_title").removeClass("in");
							$("#patient_view").removeClass("active");
							$("#patient_view").removeClass("in");
							$("#case_view_title").addClass("active");
							$("#case_view_title").addClass("in");
							$("#case_view").addClass("active");
							$("#case_view").addClass("in");
							},
							error : function() {
								alert("请求出错");
							}
				});
		}
		
/* 添加患者疾病 */
function addPatientDisease(id){
	var caseId = $("#caseId_h").val();
		$.ajax({
			type : 'get',
			url : 'http://localhost:8082/jeesite/a/rest/sicmedPatientDisease/add',
			data : "ssid=${sicmedUserBean.ssid}&diseaseId="+id+"&caseId="+caseId,
			cache : false,
			dataType : 'json',
			success : function(data) {
			console.log(data);
			console.log(data.error);
			if(data.error == "1"){
				alert(data.errorMessage);
				return;
			}
			var patientId = $("#patientId_h").val();
			bb(patientId);
				if(!confirm("添加患者疾病成功!是否继续添加!")){
					 $(".yz_popIframeDiv").remove();  
				     $(".yz_popTanChu").remove(); 
				}
			},
			error : function() {
				alert("请求出错");
			}
			});
		
	}
/* 删除患者疾病  */
function deletePatientDisease(id){
	if(!confirm("是否删除诊断信息!")){
		return;
	}
	var spanId = "#"+id;
	$.ajax({
		type : 'get',
		url : 'http://localhost:8082/jeesite/a/rest/sicmedPatientDisease/delete',
		data : "ssid=${sicmedUserBean.ssid}&id="+id,
		cache : false,
		dataType : 'json',
		success : function(data) {
				console.log(data);
				$(spanId).parent().remove();
				},
				error : function() {
				alert("请求出错");
				}
		});
}

/* 添加医嘱  */
function addAsked(orderCode,askedClassId,medicalUseStr){
	/* if(!confirm("是否删除诊断信息!")){
		return;
	} */
	var caseId = $("#caseId_h").val();
	var patientId = $("#patientId_h").val();
	$.ajax({
		type : 'get',
		url : 'http://localhost:8082/jeesite/a/rest/sicmedAsked/add',
		data : "ssid=${sicmedUserBean.ssid}&orderCode="+orderCode+"&caseId="+caseId+"&patientId="+patientId+"&askedClassId="+askedClassId+"&"+medicalUseStr,
		cache : false,
		dataType : 'json',
		success : function(data) {
				console.log(data);
					if(data.error == "0"){
						var patientId = $("#patientId_h").val();
						replaceAsked(patientId);
						
						if(!confirm(data.errorMessage+"是否继续添加!")){
							 $(".yz_popIframeDiv").remove();  
						     $(".yz_popTanChu").remove(); 
						}
					}else{
						alert(data.errorMessage);
					}
				},
				error : function() {
				alert("请求出错");
				}
		});
}
/**
 * 删除医嘱
 */
 function deleteAsked(id){
	 /* if(!confirm("是否删除诊断信息!")){
		return;
	} */
	$.ajax({
		type : 'get',
		url : 'http://localhost:8082/jeesite/a/rest/sicmedAsked/delete',
		data : "ssid=${sicmedUserBean.ssid}&id="+id,
		cache : false,
		dataType : 'json',
		success : function(data) {
				console.log(data);
					if(data.error == "0"){
						alert(data.errorMessage);
						var patientId = $("#patientId_h").val();
						replaceAsked(patientId);
						
					}else{
						alert(data.errorMessage);
					}
				},
				error : function() {
				alert("请求出错");
				}
		});
}

//医嘱页面数据同步
function replaceAsked(id){
	$.ajax({
		type : 'get',
		url : 'http://localhost:8082/jeesite/a/rest/sicmedCase/getByPatient',
		data : "ssid=${sicmedUserBean.ssid}&patientId="+id,
		cache : false,
		dataType : 'json',
		success : function(data) {
			console.log(data);
			$.each(data,function(name, value) {
				//医嘱信息刷新
				if(name == "sicmedAskedBeans"){
					//移除表格信息
					$("#tab_check").children().remove();
					$("#tab_inspect").children().remove();
					$("#tab_cure").children().remove();
					$("#tab_medical").children().remove();
					
					//创建添加 表头
					$("#tab_check").append("<tr align='center'>"+"<td class='success'>检查编码</td>"+"<td class='active'>检查名称</td>"+"<td class='warning'>检查详情</td>"+"<td class='active'>操作</td>"+"</tr>");
					$("#tab_inspect").append("<tr align='center'>"+"<td class='success'>检验编码</td>"+"<td class='active'>检验名称</td>"+"<td class='warning'>检验详情</td>"+"<td class='active'>操作</td>"+"</tr>");
					$("#tab_cure").append("<tr align='center'>"+"<td class='success'>治疗编码</td>"+"<td class='active'>治疗名称</td>"+"<td class='warning'>治疗详情</td>"+"<td class='active'>操作</td>"+"</tr>");
					$("#tab_medical").append("<tr align='center'>"+"<td class='success'>药品编码</td>"+"<td class='active'>药品名称</td>"+"<td class='danger'>剂型</td>"+"<td class='info'>给药途径</td>"+"<td class='success'>单次剂量</td>"+"<td class='active'>每日次数</td>"+"<td class='warning'>用药天数</td>"+"<td class='active'>操作</td>"+"</tr>");
					
					//添加 表格中的数据
					$.each(value,function(name3, value3) {
						if(value3.sicmedAskedClassBean.classNumber == "0"){
							$("#check_asked_class_h").val(value3.sicmedAskedClassBean.id);
						}
						if(value3.sicmedAskedClassBean.classNumber == "1"){
							$("#inspect_asked_class_h").val(value3.sicmedAskedClassBean.id);											
						}
						if(value3.sicmedAskedClassBean.classNumber == "2"){
							$("#cure_asked_class_h").val(value3.sicmedAskedClassBean.id);
						}
						if(value3.sicmedAskedClassBean.classNumber == "3"){
							$("#medical_asked_class_h").val(value3.sicmedAskedClassBean.id);
						}
						
						if(value3.sicmedAskedClassBean.classNumber == "0"&&typeof(value3.sicmedTwxrayCheckBean)!="undefined"){
							$("#tab_check").append("<tr align='center'>"+"<td class='success'>"+value3.sicmedTwxrayCheckBean.checkCode+"</td>"+"<td class='active'>"+value3.sicmedTwxrayCheckBean.checkName+"</td>"+"<td class='warning'>"+value3.sicmedTwxrayCheckBean.checkDetail+"</td>"+"<td>"+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"+"删除"+"</button>"+"</td>"+"</tr>");	
						}
						if(value3.sicmedAskedClassBean.classNumber == "1"&&typeof(value3.sicmedInspectBean)!="undefined"){
							$("#tab_inspect").append("<tr align='center'>"+"<td class='success'>"+value3.sicmedInspectBean.inspectCode+"</td>"+"<td class='active'>"+value3.sicmedInspectBean.inspectName+"</td>"+"<td class='warning'>"+value3.sicmedInspectBean.inspectDetail+"</td>"+"<td>"+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"+"删除"+"</button>"+"</td>"+"</tr>");	
						}
						if(value3.sicmedAskedClassBean.classNumber == "2"&&typeof(value3.sicmedCureCheckBean)!="undefined"){
							$("#tab_cure").append("<tr align='center'>"+"<td class='success'>"+value3.sicmedCureCheckBean.cureCode+"</td>"+"<td class='active'>"+value3.sicmedCureCheckBean.cureName+"</td>"+"<td class='warning'>"+value3.sicmedCureCheckBean.cureDetail+"</td>"+"<td>"+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"+"删除"+"</button>"+"</td>"+"</tr>");	
						}
						if(value3.sicmedAskedClassBean.classNumber == "3"&&typeof(value3.sicmedMedicalBean)!="undefined"){
							$("#tab_medical").append("<tr align='center'>"+"<td class='success'>"+value3.sicmedMedicalBean.medicalCode+"</td>"+"<td class='active'>"+value3.sicmedMedicalBean.medicalNameChina+"</td>"+"<td class='danger'>"+value3.sicmedMedicalUseBean.useUnit+"</td>"+"<td class='info'>"+value3.sicmedMedicalUseBean.useGroup+"</td>"+"<td class='success'>"+value3.sicmedMedicalUseBean.useAmount+"</td>"+"<td class='active'>"+value3.sicmedMedicalUseBean.useBout+"</td>"+"<td class='warning'>"+value3.sicmedMedicalUseBean.useDay+"</td>"+"<td>"+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"+"删除"+"</button>"+"</td>"+"</tr>");	
						}
					});
					
					// 添加表个尾巴 (添加医嘱按钮)
					$("#tab_check").append("<tr align='center'>"+"<td class='' colspan='4'>"+"<button type='button' onclick='showCheckList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"+"添加检查医嘱"+"</button>"+"</td>"+"</tr>");
					$("#tab_inspect").append("<tr align='center'>"+"<td class='' colspan='4'>"+"<button type='button' onclick='showInspectList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"+"添加检验医嘱"+"</button>"+"</td>"+"</tr>");
					$("#tab_cure").append("<tr align='center'>"+"<td class='' colspan='4'>"+"<button type='button' onclick='showCureList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"+"添加治疗医嘱"+"</button>"+"</td>"+"</tr>");
					$("#tab_medical").append("<tr align='center'>"+"<td class='' colspan='8'>"+"<button type='button' onclick='showMedicalList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"+"添加药品医嘱"+"</button>"+"</td>"+"</tr>");
				
				}
			});
		},
		error : function() {
			alert("请求出错");
		}
	});
}
		
</script>
<!-- 保存病历 -->		
<script type="text/javascript">
//根据病历Id保存修改后的病历
$("#case_form_submit").click(function(){
	saveCase();
})
function saveCase(){
	var caseStr = $("#case_form").serialize();//$ 序列化 表单  str 
	var jsonData = $("#case_form").serializeArray();//$ 序列化 表单 返回 json obj
	$.ajax({
		type : 'get',
		url : 'http://localhost:8082/jeesite/a/rest/sicmedCase/update',
		data : "ssid=${sicmedUserBean.ssid}&"+caseStr,
		cache : false,
		dataType : 'json',
		success : function(data) {
		console.log(data);
		alert("修改病历信息成功!");
		},
		error : function() {
			alert("请求出错");
		}
		});
	
}
</script>

<script type="text/javascript">
/* 获取医生个人的标准处方  */
function getStand(){
	$.ajax({
		type : 'get',
		url : 'http://localhost:8082/jeesite/a/rest/sicmedStanderprescriptionDisease/get',
		data : "ssid=${sicmedUserBean.ssid}",
		cache : false,
		dataType : 'json',
		success : function(data) {
			console.log(data);
			$("#tab_stand").children().remove();
			$("#tab_stand").append(
					"<tr align='center'>"
					+"<td class='active'>#</td>"
					+"<td class='success'>处方名称</td>"
					+"<td class='warning'>处方对应疾病</td>"
					+"<td class='danger'>操作</td>"
					+"</tr>"
					);
			$.each(data,function(name,value) {
				if (name == "sicmedStanderprescriptionDiseaseBeans") {
					$.each(value,function(name2,value2) {
						$("#tab_stand").append("<tr align='center'>"
							+"<td class='active'>"+ name2+ "</td>"
							+"<td class='success'>"+value2.prescriptionName+"</td>"
							+"<td class='warning'>"+ value2.sicmedDiseaseBean.diseaseName+"</td>"
							+"<td class='active'>"
							+"<button id="+value2.id+" type='button' onclick='deleteStand(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' >"
							+"&nbsp;删除"
							+"</button>"
							+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
							+"<button id="+value2.id+" type='button' onclick='updateStand(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-wrench' autocomplete='off' >"
							+"&nbsp;修改"
							+"</button>"
							+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
							+"<button id="+value2.id+" type='button' onclick='getStandAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-eye-open' autocomplete='off' >"
							+"&nbsp;查看处方中的医嘱"
							+"</button>"
							+"</td>"
							+ "</tr>"
							);
						});
				}
			});
			$("#tab_stand tr").bind('click', function() {
			});
			
			},
		error : function() {
			alert("请求出错");
			}
	});
}

/* 删除医生个人的标准处方 */
 function deleteStand(id){
	 if(!confirm("是否删除标准处方!")){
		return;
	} 
	 $.ajax({
			type : 'get',
			url : 'http://localhost:8082/jeesite/a/rest/sicmedStanderprescriptionDisease/delete',
			data : "ssid=${sicmedUserBean.ssid}&id="+id,
			cache : false,
			dataType : 'json',
			success : function(data) {
				console.log(data);
				if(data.error == "0")
					getStand();
				},
			error : function() {
				alert("请求出错");
				}
		});
 }

/* 修改医生个人的标准处方  */
 function updateStand(id){
	 $.ajax({
			type : 'get',
			url : 'http://localhost:8082/jeesite/a/rest/sicmedStanderprescriptionDisease/delete',
			data : "ssid=${sicmedUserBean.ssid}&id="+id,
			cache : false,
			dataType : 'json',
			success : function(data) {
				console.log(data);
					if(data.error == "0"){
						getStand();
					}
				},
			error : function() {
				alert("请求出错");
				}
		});
 }
/* 查看标准处方中的医嘱  */
 function getStandAsked(id){
	 $.ajax({
			type : 'get',
			url : 'http://localhost:8082/jeesite/a/rest/sicmedStanderprescriptionAsked/find',
			data : "ssid=${sicmedUserBean.ssid}&pid="+id,
			cache : false,
			dataType : 'json',
			success : function(data) {
				console.log(data);
				$.each(data,function(name, value) {
					//医嘱信息刷新
					if(name == "sicmedStanderprescriptionAskedBeans"){
						//移除表格信息
						$("#tab_stand_check").children().remove();
						$("#tab_stand_inspect").children().remove();
						$("#tab_stand_cure").children().remove();
						$("#tab_stand_medical").children().remove();
						
						//创建添加 表头
						$("#tab_stand_check").append("<tr align='center'>"+"<td class='success'>检查编码</td>"+"<td class='active'>检查名称</td>"+"<td class='warning'>检查详情</td>"+"<td class='active'>操作</td>"+"</tr>");
						$("#tab_stand_inspect").append("<tr align='center'>"+"<td class='success'>检验编码</td>"+"<td class='active'>检验名称</td>"+"<td class='warning'>检验详情</td>"+"<td class='active'>操作</td>"+"</tr>");
						$("#tab_stand_cure").append("<tr align='center'>"+"<td class='success'>治疗编码</td>"+"<td class='active'>治疗名称</td>"+"<td class='warning'>治疗详情</td>"+"<td class='active'>操作</td>"+"</tr>");
						$("#tab_stand_medical").append("<tr align='center'>"+"<td class='success'>药品编码</td>"+"<td class='active'>药品名称</td>"+"<td class='danger'>剂型</td>"+"<td class='info'>给药途径</td>"+"<td class='success'>单次剂量</td>"+"<td class='active'>每日次数</td>"+"<td class='warning'>用药天数</td>"+"<td class='active'>操作</td>"+"</tr>");
						
						//添加 表格中的数据
						$.each(value,function(name3, value3) {
							if(value3.sicmedAskedClassBean.classNumber == "0"){
								$("#stand_check_asked_class_h").val(value3.sicmedAskedClassBean.id);
							}
							if(value3.sicmedAskedClassBean.classNumber == "1"){
								$("#stand_inspect_asked_class_h").val(value3.sicmedAskedClassBean.id);											
							}
							if(value3.sicmedAskedClassBean.classNumber == "2"){
								$("#stand_cure_asked_class_h").val(value3.sicmedAskedClassBean.id);
							}
							if(value3.sicmedAskedClassBean.classNumber == "3"){
								$("#stand_medical_asked_class_h").val(value3.sicmedAskedClassBean.id);
							}
							
							if(value3.sicmedAskedClassBean.classNumber == "0"&&typeof(value3.sicmedTwxrayCheckBean)!="undefined"){
								$("#tab_stand_check").append("<tr align='center'>"+"<td class='success'>"+value3.sicmedTwxrayCheckBean.checkCode+"</td>"+"<td class='active'>"+value3.sicmedTwxrayCheckBean.checkName+"</td>"+"<td class='warning'>"+value3.sicmedTwxrayCheckBean.checkDetail+"</td>"+"<td>"+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"+"删除"+"</button>"+"</td>"+"</tr>");	
							}
							if(value3.sicmedAskedClassBean.classNumber == "1"&&typeof(value3.sicmedInspectBean)!="undefined"){
								$("#tab_stand_inspect").append("<tr align='center'>"+"<td class='success'>"+value3.sicmedInspectBean.inspectCode+"</td>"+"<td class='active'>"+value3.sicmedInspectBean.inspectName+"</td>"+"<td class='warning'>"+value3.sicmedInspectBean.inspectDetail+"</td>"+"<td>"+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"+"删除"+"</button>"+"</td>"+"</tr>");	
							}
							if(value3.sicmedAskedClassBean.classNumber == "2"&&typeof(value3.sicmedCureCheckBean)!="undefined"){
								$("#tab_stand_cure").append("<tr align='center'>"+"<td class='success'>"+value3.sicmedCureCheckBean.cureCode+"</td>"+"<td class='active'>"+value3.sicmedCureCheckBean.cureName+"</td>"+"<td class='warning'>"+value3.sicmedCureCheckBean.cureDetail+"</td>"+"<td>"+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"+"删除"+"</button>"+"</td>"+"</tr>");	
							}
							if(value3.sicmedAskedClassBean.classNumber == "3"&&typeof(value3.sicmedMedicalBean)!="undefined"){
								$("#tab_stand_medical").append("<tr align='center'>"+"<td class='success'>"+value3.sicmedMedicalBean.medicalCode+"</td>"+"<td class='active'>"+value3.sicmedMedicalBean.medicalNameChina+"</td>"+"<td class='danger'>"+value3.sicmedMedicalUseBean.useUnit+"</td>"+"<td class='info'>"+value3.sicmedMedicalUseBean.useGroup+"</td>"+"<td class='success'>"+value3.sicmedMedicalUseBean.useAmount+"</td>"+"<td class='active'>"+value3.sicmedMedicalUseBean.useBout+"</td>"+"<td class='warning'>"+value3.sicmedMedicalUseBean.useDay+"</td>"+"<td>"+"<button id="+value3.id+" type='button' onclick='deleteAsked(this.id)' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-remove' autocomplete='off' style='font-size: medium;'>"+"删除"+"</button>"+"</td>"+"</tr>");	
							}
						});
						
						// 添加表个尾巴 (添加医嘱按钮)
						$("#tab_stand_check").append("<tr align='center'>"+"<td class='' colspan='4'>"+"<button type='button' onclick='showCheckList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"+"添加检查医嘱"+"</button>"+"</td>"+"</tr>");
						$("#tab_stand_inspect").append("<tr align='center'>"+"<td class='' colspan='4'>"+"<button type='button' onclick='showInspectList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"+"添加检验医嘱"+"</button>"+"</td>"+"</tr>");
						$("#tab_stand_cure").append("<tr align='center'>"+"<td class='' colspan='4'>"+"<button type='button' onclick='showCureList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"+"添加治疗医嘱"+"</button>"+"</td>"+"</tr>");
						$("#tab_stand_medical").append("<tr align='center'>"+"<td class='' colspan='8'>"+"<button type='button' onclick='showMedicalList()' data-loading-text='Loading...' class='btn btn-primary glyphicon glyphicon-plus' autocomplete='off' style='font-size: medium;'>"+"添加药品医嘱"+"</button>"+"</td>"+"</tr>");
					
					}
				});
				},
			error : function() {
				alert("请求出错");
				}
		});
 }
</script>
<!-- iframe弹出层 -->	
	<script type="text/javascript">
	
	/** 
	 * iframe弹出层 例子：openDialogByIframe(550,450,'新建单位','add.do'); 
	 *  
	 * @param width  宽 
	 * @param height  高 
	 * @param tit   标题 
	 * @param url  iframe的URL地址 
	 */
	 //检查项目选择窗口
	 function showCheckList(){
		 openDialogByIframe(350,650,'添加检查医嘱', "${ctx}/web/sicmedTwxrayClass/findCheckClassList")
	 }
	 
	 //检验项目选择窗口
	 function showInspectList(){
		 openDialogByIframe(350,650,'添加检验医嘱', "${ctx}/web/sicmedInspectClass/findInspectClassList")
	 }
	 
	 //治疗项目选择窗口
	 function showCureList(){
		 openDialogByIframe(350,650,'添加治疗医嘱', "${ctx}/web/sicmedCureClass/findCureClassList")
	 }
	 
	 //药品项目选择窗口
	 function showMedicalList(){
		 openDialogByIframe(350,650,'添加药品医嘱', "${ctx}/web/sicmedMedicalClass/findMedicalClassList")
	 }
	 
	 //药品用法窗口 
	 function showMedicalUseView(orderCode,askedClassId,medicalName){
		 var url = "${ctx}/web/sicmedMedical/getMedicalById?id="+orderCode;
		 openDialogByIframe(450,350,'添加药品用法信息', url)
	 }
	 
	 //疾病选择窗口
	 function showDiseaseList(){
		 openDialogByIframe(350,650,'添加诊断信息', "${ctx}/web/sicmedDiseaseClass/findDiseaseClassList")
	 }
	function openDialogByIframe(width, height, tit, url) {  
	    var winWinth = $(window).width(), winHeight = $(document).height();  
	    $("body").append("<div class='yz_popIframeDiv'></div>");  
	    $("body").append("<div class='yz_popTanChu'><div class='yz_popTanChutit'><span class='yz_popTanChuTxt'>"  
	                            + tit  
	                            + "</span><span class='yz_popTanChuClose'>关闭</span></div><iframe class='winIframe' frameborder='0' hspace='0' src="  
	                            + url + "></iframe></div>");  
	    $(".yz_popIframeDiv").css({  
	        width : winWinth,  
	        height : winHeight,  
	        background : "#000",  
	        position : "absolute",
	        left : "0",  
	        top : "0"  
	    });  
	    $(".yz_popIframeDiv").fadeTo(0, 0.5);  
	    var yz_popTanChuLeft = $(window).width() / 2 - width / 2;  
	    var yz_popTanChuTop = $(window).height() / 2 - height / 2  
	            + $(window).scrollTop();  
	    $(".yz_popTanChu").css({  
	        width : width,  
	        height : height,  
	        border : "3px #ccc solid",  
	        left : yz_popTanChuLeft,  
	        top : yz_popTanChuTop,  
	        background : "#fff",  
	        position : "absolute"  
	    });  
	    $(".yz_popTanChutit").css({  
	        width : width,  
	        height : "25px",  
	        "border-bottom" : "1px #ccc solid",  
	        background : "#eee",  
	        "line-height" : "25px"  
	    });  
	    $(".yz_popTanChuTxt").css({  
	        "text-indent" : "5px",  
	        "float" : "left",  
	        "font-size" : "14px"  
	    });  
	    $(".yz_popTanChuClose").css({  
	        "width" : "40px",  
	        "float" : "right",  
	        "font-size" : "12px",  
	        "color" : "#667",  
	        "cursor" : "pointer"  
	    });  
	    var winIframeHeight = height - 26;  
	    $(".winIframe").css({  
	        width : width,  
	        height : winIframeHeight,  
	        "border-bottom" : "1px #ccc solid",  
	        background : "#ffffff"  
	    });  
	    $(".yz_popTanChuClose").hover(function() {  
	        $(this).css("color", "#334");  
	    }, function() {  
	        $(this).css("color", "#667");  
	    });  
	    $(".yz_popTanChuClose").click(function() {  
	        $(".yz_popIframeDiv").remove();  
	        $(".yz_popTanChu").remove();  
	    });  
	}  
		
	 $("#iframe_test1").click(function(){
		 $("#iframe_test1").fadeOut(1000);
		 })
		 
	/*
	子页面获取ssid
	*/	 
	 function getSSID(){
		 return "${sicmedUserBean.ssid}";
	 }
	 //获取 检查医嘱类别id
	  function getCheckAskedId(){
		 return $("#check_asked_class_h").val();
	 }
	 //获取 检验医嘱类别id
	  function getInspectAskedId(){
		  return $("#inspect_asked_class_h").val();
	 }
	 //获取 治疗医嘱类别id
	  function getCureAskedId(){
		  return $("#cure_asked_class_h").val();
		  }
	 //获取 药品医嘱类别id
	  function getMedicalAskedId(){
		  return $("#medical_asked_class_h").val();
		  }
	 //获取 患者ID
	 function getPatientId(){
		  return  $("#patientId_h").val();
		  }
	</script>
</body>
</html>

