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
		<li class="active"><a href="${ctx}/web/sicmedCureClass/">单表列表</a></li>
		<shiro:hasPermission name="rest:sicmedCureClass:edit"><li><a href="${ctx}/web/sicmedCureClass/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedCureClass" action="${ctx}/web/sicmedCureClass/" method="post" class="breadcrumb form-search">
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
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedCureClass:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedCureClass">
			<tr>
				<td><a href="${ctx}/web/sicmedCureClass/form?id=${sicmedCureClass.id}">
					${sicmedCureClass.classCode}
				</a></td>
				<td>
					${sicmedCureClass.className}
				</td>
				<td>
					${sicmedCureClass.pacsClass}
				</td>
				<td>
					${sicmedCureClass.sort}
				</td>
				<td>
					<fmt:formatDate value="${sicmedCureClass.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedCureClass.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedCureClass:edit"><td>
    				<a href="${ctx}/web/sicmedCureClass/form?id=${sicmedCureClass.id}">修改</a>
					<a href="${ctx}/web/sicmedCureClass/delete?id=${sicmedCureClass.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>