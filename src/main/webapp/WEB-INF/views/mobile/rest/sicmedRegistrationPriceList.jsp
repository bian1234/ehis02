<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>挂号价格管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedRegistrationPrice/">挂号价格列表</a></li>
		<shiro:hasPermission name="rest:sicmedRegistrationPrice:edit"><li><a href="${ctx}/web/sicmedRegistrationPrice/form">挂号价格添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedRegisteredPrice" action="${ctx}/web/sicmedRegistrationPrice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>挂号类别</label>
				<sys:treeselect id="sicmedRegisteredPrice" 
					name="sicmedRegisteredType.id" value="${sicmedRegisteredPrice.sicmedRegisteredType.id}" 
					labelName="sicmedRegisteredType.nameChina" labelValue="${sicmedRegisteredPrice.sicmedRegisteredType.nameChina}"
					title="普通门诊" url="/web/sicmedRegistrationPrice/treeData" cssClass="" allowClear="true"/></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>类别名称</th>
				<th>价格</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<%-- <shiro:hasPermission name="rest:sicmedRegistrationPrice:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedRegisteredPrice">
			<tr>
				<td><a href="${ctx}/web/sicmedRegistrationPrice/form?id=${sicmedRegisteredPrice.id}">
					${sicmedRegisteredPrice.sicmedRegisteredType.nameChina}
				</a></td>
				<%-- <td>
					${sicmedRegisteredPrice.sicmedRegisteredType.nameChina}
				</td> --%>
				<td>
					${sicmedRegisteredPrice.materialFee}
				</td>
				<td>
					<fmt:formatDate value="${sicmedRegisteredPrice.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedRegisteredPrice.remarks}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>