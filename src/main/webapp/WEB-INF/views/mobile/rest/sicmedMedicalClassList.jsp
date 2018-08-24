<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>药品类别管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedMedicalClass/">药品类别列表</a></li>
		<shiro:hasPermission name="rest:sicmedMedicalClass:edit"><li><a href="${ctx}/web/sicmedMedicalClass/form">药品类别添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedMedicalClass" action="${ctx}/web/sicmedMedicalClass/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>类别编号：</label>
				<form:input path="code" htmlEscape="false" maxlength="8" class="input-medium"/>
			</li>
			<li><label>药品类名：</label>
				<form:input path="name" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>缩写：</label>
				<form:input path="sort" htmlEscape="false" maxlength="2" class="input-medium"/>
			</li>
			<li><label>学名：</label>
				<form:input path="pace" htmlEscape="false" maxlength="3" class="input-medium"/>
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
				<th>药品类名</th>
				<th>缩写</th>
				<th>学名</th>
				<!-- <th>更新时间</th> -->
				<th>备注信息</th>
				<shiro:hasPermission name="rest:sicmedMedicalClass:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedMedicalClass">
			<tr>
				<td><a href="${ctx}/web/sicmedMedicalClass/form?id=${sicmedMedicalClass.id}">
					${sicmedMedicalClass.code}
				</a></td>
				<td>
					${sicmedMedicalClass.name}
				</td>
				<td>
					${sicmedMedicalClass.sort}
				</td>
				<td>
					${sicmedMedicalClass.pace}
				</td>
				<%-- <td>
					<fmt:formatDate value="${sicmedMedicalClass.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>--%>
				<td> 
					${sicmedMedicalClass.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedMedicalClass:edit"><td>
    				<a href="${ctx}/web/sicmedMedicalClass/form?id=${sicmedMedicalClass.id}">修改</a>
					<a href="${ctx}/web/sicmedMedicalClass/delete?id=${sicmedMedicalClass.id}" onclick="return confirmx('确认要删除该药品类别吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>