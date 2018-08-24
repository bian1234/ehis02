<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>疾病科室管理</title>
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
		<li class="active"><a href="${ctx}/rest/useableDiseaseBranch/">疾病科室列表</a></li>
		<shiro:hasPermission name="rest:useableDiseaseBranch:edit"><li><a href="${ctx}/rest/useableDiseaseBranch/form">疾病科室添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="useableDiseaseBranch" action="${ctx}/rest/useableDiseaseBranch/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="rest:useableDiseaseBranch:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="useableDiseaseBranch">
			<tr>
				<shiro:hasPermission name="rest:useableDiseaseBranch:edit"><td>
    				<a href="${ctx}/rest/useableDiseaseBranch/form?id=${useableDiseaseBranch.id}">修改</a>
					<a href="${ctx}/rest/useableDiseaseBranch/delete?id=${useableDiseaseBranch.id}" onclick="return confirmx('确认要删除该疾病科室吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>