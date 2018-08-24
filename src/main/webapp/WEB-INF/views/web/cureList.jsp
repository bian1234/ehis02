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
<select id="cure_class_select">
	<c:forEach items="${sicmedCureClassBeans.sicmedCureClassBeans}" var="sicmedCureClassBean">
		<option value="${sicmedCureClassBean.id }">${sicmedCureClassBean.className }</option>
	</c:forEach>
</select>
<div class="row">
	<div id="cure_list_body" class="col-sm-12">
		<div class="input-group">
			<input id="search_cure_value" type="text" class="form-control" placeholder="检索疾病信息..."> 
				<span class="input-group-btn">
				<button id="search_cure_submit" class="btn btn-default" type="button">搜索!</button>
			</span>
		</div>
		<div id="cure_list" class="list-group">
		</div>
		<input id="search_cure_pageNo" type="hidden" value="1" >
	</div>
</div>

<!-- 获取所有可以诊疗的患者信息 -->	
<script type="text/javascript">
var ssid = parent.getSSID();
var pageno = 1;
$(document).ready(function(){
	$("#search_cure_value").on("input",function(){
		pageno = 1;
		$("#search_cure_pageNo").val(pageno);
		
		var classId = $("#cure_class_select").val();
		var cure = $("#search_cure_value").val(); 
		var pageNo = $("#search_cure_pageNo").val();
		searchcure(cure,pageNo,classId,ssid);
	});
	
	$("#search_cure_submit").click(function(){
		pageno = 1;
		$("#search_cure_pageNo").val(pageno);
		
		var classId = $("#cure_class_select").val();
		var cure = $("#search_cure_value").val(); 
		var pageNo = $("#search_cure_pageNo").val();
		searchcure(cure,pageNo,classId,ssid);
		
	});
	
})
//获取疾病信息 
function searchcure(cure,pageNo,classId,ssid) {
	console.log(classId);
	$.ajax({
		type : 'get',
		url : 'http://localhost:8082/jeesite/a/rest/sicmedCureCheck/searchCure',
		data : "ssid="+ssid+"&parameter="+cure+"&pageNo="+pageNo+"&classId"+classId,
		cache : false,
		dataType : 'json',
		success : function(data) { 
					console.log(data);
					$("#search_cure_more").remove();
					if(data.cureCheckBeanList.length == "20"){
						$("#cure_list_body").append("<a id='search_cure_more' href='#' class='list-group-item glyphicon glyphicon-option-horizontal' onclick='searchMore()' style='text-align: center;'>点击加载更多</a>");
					}
					$.each(data,function(name, value) {
						if(pageNo == "1" ){
						$("#cure_list").children().remove();
						}
						if (name == "cureCheckBeanList") {
							$.each(value,function(name2,value2) {
								$("#cure_list").append("<a id="+value2.id+" href='#' class='list-group-item' onclick='addCureAsked(this.id)'>"+value2.cureName+"</a>");
							});
						}
					});
					$("#cure_list a").bind('click', function() {  
					 });
					},
					error : function() {
						alert("请求出错");
					}
		});
		
	}
	
//添加患者疾病
function addCureAsked(id) {
	var askedClassId =  parent.getCureAskedId();
	parent.addAsked(id,askedClassId);
}
//查询更多的疾病 
function searchMore(){
	pageno = pageno + 1;
	$("#search_cure_pageNo").val(pageno);
	
	var classId = $("#cure_class_select").val();
	var cure = $("#search_cure_value").val(); 
	var pageNo = $("#search_cure_pageNo").val();
	searchcure(cure,pageNo,classId,ssid);
}
</script>
</body>
</html>