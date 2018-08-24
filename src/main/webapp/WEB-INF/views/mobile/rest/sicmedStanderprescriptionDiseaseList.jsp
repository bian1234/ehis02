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
		<li class="active"><a href="${ctx}/web/sicmedStanderprescriptionDisease/">保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedStanderprescriptionDisease:edit"><li><a href="${ctx}/web/sicmedStanderprescriptionDisease/form">保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedStanderprescriptionDisease" action="${ctx}/web/sicmedStanderprescriptionDisease/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>处方名：</label>
				<form:input path="prescriptionName" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>医嘱扩展名：</label>
				<form:input path="prescriptionNameEx" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<%-- <li><label>疾病编码(对应疾病编码表)：</label>
				<form:input path="sicmedDisease.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>处方名</th>
				<th>医嘱扩展名</th>
				<th>疾病编码(对应疾病编码表)</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedStanderprescriptionDisease:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedStanderprescriptionDisease">
			<tr>
				<td><a href="${ctx}/web/sicmedStanderprescriptionDisease/form?id=${sicmedStanderprescriptionDisease.id}">
					${sicmedStanderprescriptionDisease.prescriptionName}
				</a></td>
				<td>
					${sicmedStanderprescriptionDisease.prescriptionNameEx}
				</td>
				<td>
					${sicmedStanderprescriptionDisease.sicmedDisease.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedStanderprescriptionDisease.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedStanderprescriptionDisease.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedStanderprescriptionDisease:edit"><td>
    				<a href="${ctx}/web/sicmedStanderprescriptionDisease/form?id=${sicmedStanderprescriptionDisease.id}">修改</a>
					<a href="${ctx}/web/sicmedStanderprescriptionDisease/delete?id=${sicmedStanderprescriptionDisease.id}" onclick="return confirmx('确认要删除该保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>