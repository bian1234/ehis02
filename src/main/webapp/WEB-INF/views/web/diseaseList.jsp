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
<%-- <select>
	<c:forEach items="${sicmedDiseaseClassBeans.sicmedDiseaseClassBeans}" var="sicmedDiseaseClassBean">
		<option value="${sicmedDiseaseClassBean.id }">${sicmedDiseaseClassBean.diseaseClassName }</option>
	</c:forEach>
</select> --%>
<div class="row">
	<div id="disease_list_body" class="col-sm-12">
		<div class="input-group">
			<input id="search_disease_value" type="text" class="form-control" placeholder="检索疾病信息..."> 
				<span class="input-group-btn">
				<button id="search_disease_submit" class="btn btn-default" type="button">搜索!</button>
			</span>
		</div>
		<div id="disease_list" class="list-group">
		</div>
		<input id="search_disease_pageNo" type="hidden" value="1" >
	</div>
</div>

<!-- 获取所有可以诊疗的患者信息 -->	
<script type="text/javascript">
var ssid = parent.getSSID();
var pageno = 1;
$(document).ready(function(){
	$("#search_disease_value").on("input",function(){
		pageno = 1;
		$("#search_disease_pageNo").val(pageno);
		
		var disease = $("#search_disease_value").val(); 
		var pageNo = $("#search_disease_pageNo").val();
		searchDisease(disease,pageNo,ssid);
	});
	
	$("#search_disease_submit").click(function(){
		pageno = 1;
		$("#search_disease_pageNo").val(pageno);
		
		var disease = $("#search_disease_value").val(); 
		var pageNo = $("#search_disease_pageNo").val();
		searchDisease(disease,pageNo,ssid);
		
	});
	
})
//获取疾病信息 
function searchDisease(disease,pageNo,ssid) {
	$.ajax({
		type : 'get',
		url : 'http://localhost:8082/jeesite/a/rest/sicmedDisease/searchDisease',
		data : "ssid="+ssid+"&disease="+disease+"&pageNo="+pageNo,
		cache : false,
		dataType : 'json',
		success : function(data) { 
					console.log(data);
					$("#search_disease_more").remove();
					if(data.sicmedDiseaseBeans.length == "20"){
						$("#disease_list_body").append("<a id='search_disease_more' href='#' class='list-group-item glyphicon glyphicon-option-horizontal' onclick='searchMore()' style='text-align: center;'>点击加载更多</a>");
					}
					$.each(data,function(name, value) {
						if(pageNo == "1" ){
						$("#disease_list").children().remove();
						}
						if (name == "sicmedDiseaseBeans") {
							$.each(value,function(name2,value2) {
								$("#disease_list").append("<a id="+value2.id+" href='#' class='list-group-item' onclick='addPatientDisease(this.id)'>"+value2.diseaseName+"</a>");
							});
						}
					});
					$("#disease_list a").bind('click', function() {  
					 });
					},
					error : function() {
						alert("请求出错");
					}
		});
		
	}
	
//添加患者疾病
function addPatientDisease(id) {
	parent.addPatientDisease(id);
}
//查询更多的疾病 
function searchMore(){
	pageno = pageno + 1;
	$("#search_disease_pageNo").val(pageno);
	var disease = $("#search_disease_value").val(); 
	var pageNo = $("#search_disease_pageNo").val();
	searchDisease(disease,pageNo,ssid);
}
</script>
</body>
</html>