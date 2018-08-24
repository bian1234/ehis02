<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医嘱患者中间表方保存成功管理</title>
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
		<li class="active"><a href="${ctx}/rest/sicmedMedicalAsked/">医嘱患者中间表方保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedMedicalAsked:edit"><li><a href="${ctx}/rest/sicmedMedicalAsked/form">医嘱患者中间表方保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedMedicalAsked" action="${ctx}/rest/sicmedMedicalAsked/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>药品编号(对应药品表的编号)：</label>
				<form:input path="medicalCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医嘱编号(对应医嘱表数据)：</label>
				<form:input path="askedCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>备注：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>药品编号(对应药品表的编号)</th>
				<th>医嘱编号(对应医嘱表数据)</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedMedicalAsked:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedMedicalAsked">
			<tr>
				<td><a href="${ctx}/rest/sicmedMedicalAsked/form?id=${sicmedMedicalAsked.id}">
					${sicmedMedicalAsked.medicalCode}
				</a></td>
				<td>
					${sicmedMedicalAsked.askedCode}
				</td>
				<td>
					<fmt:formatDate value="${sicmedMedicalAsked.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedMedicalAsked.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedMedicalAsked:edit"><td>
    				<a href="${ctx}/rest/sicmedMedicalAsked/form?id=${sicmedMedicalAsked.id}">修改</a>
					<a href="${ctx}/rest/sicmedMedicalAsked/delete?id=${sicmedMedicalAsked.id}" onclick="return confirmx('确认要删除该医嘱患者中间表方保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>