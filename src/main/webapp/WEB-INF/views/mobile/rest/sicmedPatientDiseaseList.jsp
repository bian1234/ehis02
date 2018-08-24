<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存成功管理</title>
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
		<li class="active"><a href="${ctx}/rest/sicmedPatientDisease/">保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedPatientDisease:edit"><li><a href="${ctx}/rest/sicmedPatientDisease/form">保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedPatientDisease" action="${ctx}/rest/sicmedPatientDisease/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>患者编号(对应患者疾病表)：</label>
				<form:input path="patient.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>疾病编号(对应疾病表)：</label>
				<form:input path="disease.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>科室编号(对应科室表)：</label>
				<form:input path="branch.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医生编号(对应医生表)：</label>
				<form:input path="doctor.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>患者编号(对应患者疾病表)</th>
				<th>疾病编号(对应疾病表)</th>
				<th>科室编号(对应科室表)</th>
				<th>医生编号(对应医生表)</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedPatientDisease:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedPatientDisease">
			<tr>
				<td><a href="${ctx}/rest/sicmedPatientDisease/form?id=${sicmedPatientDisease.id}">
					${sicmedPatientDisease.patient.id}
				</a></td>
				<td>
					${sicmedPatientDisease.disease.id}
				</td>
				<td>
					${sicmedPatientDisease.branch.id}
				</td>
				<td>
					${sicmedPatientDisease.doctor.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedPatientDisease.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedPatientDisease.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedPatientDisease:edit"><td>
    				<a href="${ctx}/rest/sicmedPatientDisease/form?id=${sicmedPatientDisease.id}">修改</a>
					<a href="${ctx}/rest/sicmedPatientDisease/delete?id=${sicmedPatientDisease.id}" onclick="return confirmx('确认要删除该保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>