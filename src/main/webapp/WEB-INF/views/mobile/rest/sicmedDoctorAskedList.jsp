<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医生常用医嘱保存成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedDoctorAsked/">医生常用医嘱保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedDoctorAsked:edit"><li><a href="${ctx}/web/sicmedDoctorAsked/form">医生常用医嘱保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedDoctorAsked" action="${ctx}/web/sicmedDoctorAsked/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>医生常用医嘱表id：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医生编号(对应用户表)：</label>
				<form:input path="sicmedUser.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医嘱分类编码(对应医嘱分类编码表)：</label>
				<form:input path="sicmedAskedClass.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医嘱编码(对应医嘱编码表)：</label>
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
				<th>医生常用医嘱表id</th>
				<th>医生编号(对应用户表)</th>
				<th>医嘱分类编码(对应医嘱分类编码表)</th>
				<th>医嘱编码(对应医嘱编码表)</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedDoctorAsked:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedDoctorAsked">
			<tr>
				<td><a href="${ctx}/web/sicmedDoctorAsked/form?id=${sicmedDoctorAsked.id}">
					${sicmedDoctorAsked.id}
				</a></td>
				<td>
					${sicmedDoctorAsked.sicmedUser.id}
				</td>
				<td>
					${sicmedDoctorAsked.sicmedAskedClass.id}
				</td>
				<td>
					${sicmedDoctorAsked.sicmedAsked.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedDoctorAsked.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedDoctorAsked.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedDoctorAsked:edit"><td>
    				<a href="${ctx}/web/sicmedDoctorAsked/form?id=${sicmedDoctorAsked.id}">修改</a>
					<a href="${ctx}/web/sicmedDoctorAsked/delete?id=${sicmedDoctorAsked.id}" onclick="return confirmx('确认要删除该医生常用医嘱保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>