<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedStandardprescriptionDoctor/">保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedStandardprescriptionDoctor:edit"><li><a href="${ctx}/web/sicmedStandardprescriptionDoctor/form">保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedStandardprescriptionDoctor" action="${ctx}/web/sicmedStandardprescriptionDoctor/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>医生编号(对应用户表)：</label>
				<form:input path="sicmedUser.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>处方名：</label>
				<form:input path="prescriptionName" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>处方名(扩展)：</label>
				<form:input path="prescriptionNameEx" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>标准处方中的医嘱编码(对应标准处方中的医嘱表)：</label>
				<form:input path="standerprescriptionAsked.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>标准处方中的疾病编码(对应标准处方中的疾病表)：</label>
				<form:input path="standerprescriptionDisease.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>医生编号(对应用户表)</th>
				<th>处方名</th>
				<th>处方名(扩展)</th>
				<th>标准处方中的医嘱编码(对应标准处方中的医嘱表)</th>
				<th>标准处方中的疾病编码(对应标准处方中的疾病表)</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedStandardprescriptionDoctor:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedStandardprescriptionDoctor">
			<tr>
				<td><a href="${ctx}/web/sicmedStandardprescriptionDoctor/form?id=${sicmedStandardprescriptionDoctor.id}">
					${sicmedStandardprescriptionDoctor.sicmedUser.id}
				</a></td>
				<td>
					${sicmedStandardprescriptionDoctor.prescriptionName}
				</td>
				<td>
					${sicmedStandardprescriptionDoctor.prescriptionNameEx}
				</td>
				<td>
					${sicmedStandardprescriptionDoctor.standerprescriptionAsked.id}
				</td>
				<td>
					${sicmedStandardprescriptionDoctor.standerprescriptionDisease.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedStandardprescriptionDoctor.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedStandardprescriptionDoctor.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedStandardprescriptionDoctor:edit"><td>
    				<a href="${ctx}/web/sicmedStandardprescriptionDoctor/form?id=${sicmedStandardprescriptionDoctor.id}">修改</a>
					<a href="${ctx}/web/sicmedStandardprescriptionDoctor/delete?id=${sicmedStandardprescriptionDoctor.id}" onclick="return confirmx('确认要删除该保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>