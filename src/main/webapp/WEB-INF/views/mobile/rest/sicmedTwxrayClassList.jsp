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
		<li class="active"><a href="${ctx}/web/sicmedTwxrayClass/">单表列表</a></li>
		<shiro:hasPermission name="rest:sicmedTwxrayClass:edit"><li><a href="${ctx}/web/sicmedTwxrayClass/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedTwxrayClass" action="${ctx}/web/sicmedTwxrayClass/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>类别编号：</label>
				<form:input path="classCode" htmlEscape="false" maxlength="2" class="input-medium"/>
			</li>
			<li><label>类别名称：</label>
				<form:input path="className" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>学名：</label>
				<form:input path="pacsClass" htmlEscape="false" maxlength="3" class="input-medium"/>
			</li>
			<li><label>缩写：</label>
				<form:input path="sort" htmlEscape="false" maxlength="2" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>类别编号</th>
				<th>类别名称</th>
				<th>学名</th>
				<th>缩写</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedTwxrayClass:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedTwxrayClass">
			<tr>
				<td><a href="${ctx}/web/sicmedTwxrayClass/form?id=${sicmedTwxrayClass.id}">
					${sicmedTwxrayClass.classCode}
				</a></td>
				<td>
					${sicmedTwxrayClass.className}
				</td>
				<td>
					${sicmedTwxrayClass.pacsClass}
				</td>
				<td>
					${sicmedTwxrayClass.sort}
				</td>
				<td>
					${sicmedTwxrayClass.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedTwxrayClass:edit"><td>
    				<a href="${ctx}/web/sicmedTwxrayClass/form?id=${sicmedTwxrayClass.id}">修改</a>
					<a href="${ctx}/web/sicmedTwxrayClass/delete?id=${sicmedTwxrayClass.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>