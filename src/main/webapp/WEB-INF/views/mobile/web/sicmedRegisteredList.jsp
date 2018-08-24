<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<meta charset="utf-8">

<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="/jeesite/static/bootstrap3/js/testsendor/jquery-3.1.0.min.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"></script>

<title>改号列表</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {

	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
</head>
<body>
	<%-- <div style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100px; background-color: #39A0ED; text-align: center">
		<h1>改号窗口</h1>
	</div>
	<div
		style="position: absolute; top: 100px; left: 0px; width: 10%; height: 1200px; background-color: #545454">
		<div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/gridLayout" style="color: gray">挂号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/" style="color: white">改号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/backList" style="color: gray">退号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/total" 
						style="color: gray">查询</a>
				</h2>
			</div>
		</div>
	</div> --%>
	<div class="col-xs-12 col-sm-12" id="patientDetail">
		<div class="header">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand"
							href="${ctx}/webweb/sicmedRegistered/">患者列表</a>
					</div>
				</div>
			</nav>
			<!--</div>-->
		</div>
	
	<%-- <form:form id="searchForm" modelAttribute="sicmedRegistered"
		action="${ctx}/webweb/sicmedRegistered/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>患者名称：</label> <form:input
					path="sicmedPatient" htmlEscape="false" maxlength="32" style="height:34px;"
					class="selectpicker" /></li>
			<li><label>患者编号：</label> <form:input
					path="sicmedPatient.patientNumber" htmlEscape="false" maxlength="32" style="height:34px;"
					class="selectpicker" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="clearfix"></li> 
		</ul>
	</form:form> --%>
	<form id="searchForm" action="${ctx}/webweb/sicmedRegistered/"  method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}" />
		<i class="icon-search icon-white">&nbsp;&nbsp;</i>
		<input id="String" class="selectpicker" name="regist" maxlength="32" style="height:34px;" placeholder="请输入患者编号或名字">
		<input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" />
	</form>
	<sys:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>患者编号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>挂号科室</th>
				<th>就诊日期</th> 
				<th>状态</th>
				<th>状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="sicmedRegistered">
				<tr>
					<td>${sicmedRegistered.sicmedPatient.patientNumber }</td>
					<td>${sicmedRegistered.sicmedPatient.patientName}</td>
					<td>${sicmedRegistered.sicmedPatient.patientAge }</td>
					<td>${sicmedRegistered.sicmedPatient.patientSex}</td>
					<td>${sicmedRegistered.sicmedBranch.branchName}</td>
					<td><fmt:formatDate
							value="${sicmedRegistered.registeredBeginDate}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>${sicmedRegistered.registeredStatusName}</td>
					<td><a href="${ctx}/webweb/sicmedRegistered/change?id=${sicmedRegistered.id}&doctor=${doctor}"><input class="btn btn-default"
				type="button" value="改号" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
	</div>
</body>
</html>