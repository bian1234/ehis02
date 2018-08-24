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
<select id="check_class_select">
	<c:forEach items="${sicmedTwxrayClassBeans.sicmedTwxrayClassBeans}" var="sicmedTwxrayClassBean">
		<option value="${sicmedTwxrayClassBean.id }">${sicmedTwxrayClassBean.className }</option>
	</c:forEach>
</select>
<div class="row">
	<div id="check_list_body" class="col-sm-12">
		<div class="input-group">
			<input id="search_check_value" type="text" class="form-control" placeholder="检索检查信息..."> 
				<span class="input-group-btn">
				<button id="search_check_submit" class="btn btn-default" type="button">搜索!</button>
			</span>
		</div>
		<div id="check_list" class="list-group">
		</div>
		<input id="search_check_pageNo" type="hidden" value="1" >
	</div>
</div>

<!-- 获取所有可以诊疗的患者信息 -->	
<script type="text/javascript">
var ssid = parent.getSSID();
var pageno = 1;
$(document).ready(function(){
	$("#search_check_value").on("input",function(){
		pageno = 1;
		$("#search_check_pageNo").val(pageno);
		var classId = $("#check_class_select").val();
		var parameter = $("#search_check_value").val(); 
		var pageNo = $("#search_check_pageNo").val();
		searchCheck(parameter,pageNo,classId,ssid);
	});
	
	$("#search_check_submit").click(function(){
		pageno = 1;
		$("#search_check_pageNo").val(pageno);
		var classId = $("#check_class_select").val();
		var parameter = $("#search_check_value").val(); 
		var pageNo = $("#search_check_pageNo").val();
		searchCheck(parameter,pageNo,classId,ssid);
		
	});
	
})
//获取疾病信息 
function searchCheck(parameter,pageNo,classId,ssid) {
	console.log(classId);
	$.ajax({
		type : 'get',
		url : 'http://localhost:8082/jeesite/a/rest/sicmedTwxrayCheck/searchCheck',
		data : "ssid="+ssid+"&parameter="+parameter+"&pageNo="+pageNo+"&classId="+classId,
		cache : false,
		dataType : 'json',
		success : function(data) { 
					console.log(data);
					$("#search_check_more").remove();
					if(data.twxrayCheckBeanList.length == "20"){
						$("#check_list_body").append("<a id='search_check_more' href='#' class='list-group-item glyphicon glyphicon-option-horizontal' onclick='searchMore()' style='text-align: center;'>点击加载更多</a>");
					}
					$.each(data,function(name, value) {
						if(pageNo == "1" ){
						$("#check_list").children().remove();
						}
						if (name == "twxrayCheckBeanList") {
							$.each(value,function(name2,value2) {
								$("#check_list").append("<a id="+value2.id+" href='#' class='list-group-item' onclick='addCheckAsked(this.id)'>"+value2.checkName+"</a>");
							});
						}
					});
					$("#check_list a").bind('click', function() {  
					 });
					},
					error : function() {
						alert("请求出错");
					}
		});
		
	}
	
//添加患者疾病
function addCheckAsked(id) {
	var askedClassId =  parent.getCheckAskedId();
	parent.addAsked(id,askedClassId);
}
//查询更多的疾病 
function searchMore(){
	pageno = pageno + 1;
	$("#search_check_pageNo").val(pageno);
	var classId = $("#check_class_select").val();
	var check = $("#search_check_value").val(); 
	var pageNo = $("#search_check_pageNo").val();
	searchCheck(check,pageNo,classId,ssid);
}
</script>
</body>
</html>