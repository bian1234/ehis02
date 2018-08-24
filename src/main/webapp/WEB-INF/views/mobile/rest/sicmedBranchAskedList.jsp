<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>科室常用医嘱保存成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedBranchAsked/">科室常用医嘱保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedBranchAsked:edit"><li><a href="${ctx}/web/sicmedBranchAsked/form">科室常用医嘱保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedBranchAsked" action="${ctx}/web/sicmedBranchAsked/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>科室常用医嘱表ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>科室编号(对应科室表)：</label>
				<form:input path="sicmedBranch.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医嘱分类编码(对应医嘱分类表)：</label>
				<form:input path="sicmedAskedClass.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医嘱编号(对应医嘱编码表)：</label>
				<form:input path="sicmedAsked.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>科室编号(对应科室表)</th>
				<th>医嘱分类编码(对应医嘱分类表)</th>
				<th>医嘱编号(对应医嘱编码表)</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedBranchAsked:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedBranchAsked">
			<tr>
				<td><a href="${ctx}/web/sicmedBranchAsked/form?id=${sicmedBranchAsked.id}">
					${sicmedBranchAsked.sicmedBranch.id}
				</a></td>
				<td>
					${sicmedBranchAsked.sicmedAskedClass.id}
				</td>
				<td>
					${sicmedBranchAsked.sicmedAsked.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedBranchAsked.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedBranchAsked.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedBranchAsked:edit"><td>
    				<a href="${ctx}/web/sicmedBranchAsked/form?id=${sicmedBranchAsked.id}">修改</a>
					<a href="${ctx}/web/sicmedBranchAsked/delete?id=${sicmedBranchAsked.id}" onclick="return confirmx('确认要删除该科室常用医嘱保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>