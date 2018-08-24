<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.css" type="text/css" rel="stylesheet" />
	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<script src="/jeesite/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>
	<title>疾病列表</title>
</head>
<body style="overflow-x: hidden;">
<select id="medical_class_select">
	<c:forEach items="${sicmedMedicalClassBeans.sicmedMedicalClassBeans}" var="sicmedMedicalClassBean">
		<option value="${sicmedMedicalClassBean.id }">${sicmedMedicalClassBean.className }</option>
	</c:forEach>
</select>
<div class="row">
	<div id="medical_list_body" class="col-sm-12">
		<div class="input-group">
			<input id="search_medical_value" type="text" class="form-control" placeholder="检索疾病信息..."> 
				<span class="input-group-btn">
				<button id="search_medical_submit" class="btn btn-default" type="button">搜索!</button>
			</span>
		</div>
		<div id="medical_list" class="list-group">
		</div>
		<input id="search_medical_pageNo" type="hidden" value="1" >
	</div>
</div>

<!-- 获取所有可以诊疗的患者信息 -->	
<script type="text/javascript">
var ssid = parent.getSSID();
var pageno = 1;
$(document).ready(function(){
	$("#search_medical_value").on("input",function(){
		pageno = 1;
		$("#search_medical_pageNo").val(pageno);
		
		var classId = $("#medical_class_select").val();
		var medical = $("#search_medical_value").val(); 
		var pageNo = $("#search_medical_pageNo").val();
		searchmedical(medical,pageNo,classId,ssid);
	});
	
	$("#search_medical_submit").click(function(){
		pageno = 1;
		$("#search_medical_pageNo").val(pageno);
		
		var classId = $("#medical_class_select").val();
		var medical = $("#search_medical_value").val(); 
		var pageNo = $("#search_medical_pageNo").val();
		searchmedical(medical,pageNo,classId,ssid);
		
	});
	
})
//获取疾病信息 
function searchmedical(medical,pageNo,classId,ssid) {
	console.log(classId);
	$.ajax({
		type : 'get',
		url : 'http://localhost:8080/jeesite/a/rest/sicmedMedical/searchMedical',
		data : "ssid="+ssid+"&parameter="+medical+"&pageNo="+pageNo+"&classId="+classId,
		cache : false,
		dataType : 'json',
		success : function(data) { 
					console.log(data);
					$("#search_medical_more").remove();
					if(data.sicmedMedicalBeans.length == "20"){
						$("#medical_list_body").append("<a id='search_medical_more' href='#' class='list-group-item glyphicon glyphicon-option-horizontal' onclick='searchMore()' style='text-align: center;'>点击加载更多</a>");
					}
					$.each(data,function(name, value) {
						if(pageNo == "1" ){
						$("#medical_list").children().remove();
						}
						if (name == "sicmedMedicalBeans") {
							$.each(value,function(name2,value2) {
								$("#medical_list").append("<a id="+value2.id+" href='#' class='list-group-item' onclick='addMedicalAsked(this.id)'>"+value2.medicalNameChina+"</a>");
							});
						}
					});
					$("#medical_list a").bind('click', function() {  
					 });
					},
					error : function() {
						alert("请求出错");
					}
		});
		
	}
	
//添加患者疾病
function addMedicalAsked(id) {
	var inputId = "#"+id;
	var askedClassId =  parent.getMedicalAskedId();
	var orderCode = id;
	var medicalName = $(inputId).val();
	parent.showMedicalUseView(orderCode,askedClassId,medicalName);
	
	//parent.addAsked(id,askedClassId);
	
}
//查询更多的疾病 
function searchMore(){
	pageno = pageno + 1;
	$("#search_medical_pageNo").val(pageno);
	
	var classId = $("#medical_class_select").val();
	var medical = $("#search_medical_value").val(); 
	var pageNo = $("#search_medical_pageNo").val();
	searchmedical(medical,pageNo,classId,ssid);
}

</script>
</body>
</html>