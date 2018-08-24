<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存部门成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedDept/">部门列表</a></li>
		<shiro:hasPermission name="rest:sicmedDept:edit"><li><a href="${ctx}/web/sicmedDept/form">部门添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedDept" action="${ctx}/web/sicmedDept/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>基础编码：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li><label>部门名称：</label>
				<form:input path="deptName" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>部门编号：</label>
				<form:input path="deptNumber" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<%--<li><label>部门拼音简写：</label>
				<form:input path="deptPmpa" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			 <li><label>部门编码：</label>
				<form:input path="deptCode" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>部门名称</th>
				<th>部门编号</th>
				<th>部门拼音简写</th>
				<!-- <th>部门编码</th>
				<th>更新时间</th> -->
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedDept:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedDept">
			<tr>
				<%-- <td><a href="${ctx}/web/sicmedDept/form?id=${sicmedDept.id}">
					${sicmedDept.deptNumber}
				</a></td>
				<td>
					${sicmedDept.deptName}
				</td> --%>
				<td><a href="${ctx}/web/sicmedDept/form?id=${sicmedDept.id}">
					${sicmedDept.deptName}
				</a></td>
				<td>
					${sicmedDept.deptNumber}
				</td>
				<td>
					${sicmedDept.deptPmpa}
				</td>
				<%-- <td>
					${sicmedDept.deptCode}
				</td>
				<td>
					<fmt:formatDate value="${sicmedDept.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					${sicmedDept.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedDept:edit"><td>
    				<a href="${ctx}/web/sicmedDept/form?id=${sicmedDept.id}">修改</a>
					<a href="${ctx}/web/sicmedDept/delete?id=${sicmedDept.id}" onclick="return confirmx('确认要删除该保存部门成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>