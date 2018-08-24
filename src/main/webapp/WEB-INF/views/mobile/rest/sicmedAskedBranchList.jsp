<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医嘱传送部门保存成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedAskedBranch/">医嘱传送部门保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedAskedBranch:edit"><li><a href="${ctx}/web/sicmedAskedBranch/form">医嘱传送部门保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedAskedBranch" action="${ctx}/web/sicmedAskedBranch/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>医嘱传送部门ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医嘱编号(对应医嘱表)：</label>
				<form:input path="sicmedAsked.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
 			<li><label>科室编码(对应科室表)：</label>
				<form:input path="sicmedbranch.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> 
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>医嘱编号(对应医嘱表)</th>
				<th>科室编码(对应科室表)</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedAskedBranch:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedAskedBranch">
			<tr>
				<td><a href="${ctx}/web/sicmedAskedBranch/form?id=${sicmedAskedBranch.id}">
					${sicmedAskedBranch.sicmedAsked.id}
				</a></td>
				<td>
					${sicmedAskedBranch.sicmedbranch.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedAskedBranch.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedAskedBranch.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedAskedBranch:edit"><td>
    				<a href="${ctx}/web/sicmedAskedBranch/form?id=${sicmedAskedBranch.id}">修改</a>
					<a href="${ctx}/web/sicmedAskedBranch/delete?id=${sicmedAskedBranch.id}" onclick="return confirmx('确认要删除该医嘱传送部门保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>