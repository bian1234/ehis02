<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存挂号信息成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
	
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	 <ul class="nav nav-tabs">
 		<shiro:hasPermission name="rest:sicmedRegistered:edit"><li><a href="${ctx}/webweb/sicmedRegistered/selectBranch">挂号患者列表</a></li>
		<%--<li class="active"><a href="${ctx}/webweb/sicmedRegistered">挂号列表</a></li>
	 --%></shiro:hasPermission></ul>
	<form:form id="searchForm" modelAttribute="sicmedRegistered" action="${ctx}/webweb/sicmedRegistered/selectBranch" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>患者名称：</label>
				<form:input path="sicmedPatient.patientName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>科室名称：</label>
				<form:input path="sicmedBranch.branchName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>挂号类型：</label>
				<form:input path="registeredStatus" htmlEscape="false" maxlength="7" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>患者名字</th>
				<th>科室名称</th>
				<th>医保卡号</th>
				<th>挂号费用</th>
				<th>挂号类型</th>
				<th>医生</th>
				<th>就诊开始时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedRegistered">
			<tr>
				<td>
					${sicmedRegistered.sicmedPatient.patientName}
				</td>
				<td>
					${sicmedRegistered.sicmedBranch.branchName}
				</td>
				<td>
					${sicmedRegistered.sicmedPatient.medicareNo}
				</td>
				<td>
					${sicmedRegistered.registeredPric}
				</td>
				<td>
					${sicmedRegistered.sicmedRegistrationType.nameChina}
				</td>
				<td>
					${sicmedRegistered.sicmedDoctor.userName}
				</td>
				<td>
					<fmt:formatDate value="${sicmedRegistered.registeredBeginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="rest:sicmedRegistered:edit"><td>
    				<a href="${ctx}/webweb/sicmedCase/form?patientNumber=${sicmedRegistered.sicmedPatient.medicareNo}">填写病例</a>
					<%-- <a href="${ctx}/webweb/sicmedRegistered/delete?id=${sicmedRegistered.id}" onclick="return confirmx('确认要退号吗？', this.href)">退号</a>
				</td> --%></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>