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
		<li class="active"><a href="${ctx}/web/sicmedStandardprescriptionBranch/">保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedStandardprescriptionBranch:edit"><li><a href="${ctx}/web/sicmedStandardprescriptionBranch/form">保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedStandardprescriptionBranch" action="${ctx}/web/sicmedStandardprescriptionBranch/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>科室编号(对应科室表)：</label>
				<form:input path="sicmedBranch.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>处方名称：</label>
				<form:input path="prescriptionName" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>处方名称(扩展)：</label>
				<form:input path="prescriptionNameEx" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>标准处方中医嘱编号(对应标准处方中医嘱表)：</label>
				<form:input path="standerprescriptionAsked.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>标准处方中的疾病编码(对应标准处方中的疾病表)：</label>
				<form:input path="standerprescriptionDisease.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>科室标准处方表ID</th>
				<th>科室编号(对应科室表)</th>
				<th>处方名称</th>
				<th>处方名称(扩展)</th>
				<th>标准处方中医嘱编号(对应标准处方中医嘱表)</th>
				<th>标准处方中的疾病编码(对应标准处方中的疾病表)</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedStandardprescriptionBranch:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedStandardprescriptionBranch">
			<tr>
				<td><a href="${ctx}/web/sicmedStandardprescriptionBranch/form?id=${sicmedStandardprescriptionBranch.id}">
					${sicmedStandardprescriptionBranch.id}
				</a></td>
				<td>
					${sicmedStandardprescriptionBranch.sicmedBranch.id}
				</td>
				<td>
					${sicmedStandardprescriptionBranch.prescriptionName}
				</td>
				<td>
					${sicmedStandardprescriptionBranch.prescriptionNameEx}
				</td>
				<td>
					${sicmedStandardprescriptionBranch.standerprescriptionAsked.id}
				</td>
				<td>
					${sicmedStandardprescriptionBranch.standerprescriptionDisease.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedStandardprescriptionBranch.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedStandardprescriptionBranch.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedStandardprescriptionBranch:edit"><td>
    				<a href="${ctx}/web/sicmedStandardprescriptionBranch/form?id=${sicmedStandardprescriptionBranch.id}">修改</a>
					<a href="${ctx}/web/sicmedStandardprescriptionBranch/delete?id=${sicmedStandardprescriptionBranch.id}" onclick="return confirmx('确认要删除该保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>