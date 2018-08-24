<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>单表管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedInspectClass/">单表列表</a></li>
		<shiro:hasPermission name="rest:sicmedInspectClass:edit"><li><a href="${ctx}/web/sicmedInspectClass/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedInspectClass" action="${ctx}/web/sicmedInspectClass/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>检验分类：</label>
				<form:input path="inspectName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>类别编号：</label>
				<form:input path="inspectCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>检验分类</th>
				<th>检验类别编号</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedInspectClass:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedInspectClass">
			<tr>
				<td><a href="${ctx}/web/sicmedInspectClass/form?id=${sicmedInspectClass.id}">
					${sicmedInspectClass.inspectName}
				</a></td>
				<td>
					${sicmedInspectClass.inspectCode}
				</td>
				<td>
					<fmt:formatDate value="${sicmedInspectClass.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedInspectClass.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedInspectClass:edit"><td>
    				<a href="${ctx}/web/sicmedInspectClass/form?id=${sicmedInspectClass.id}">修改</a>
					<a href="${ctx}/web/sicmedInspectClass/delete?id=${sicmedInspectClass.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>