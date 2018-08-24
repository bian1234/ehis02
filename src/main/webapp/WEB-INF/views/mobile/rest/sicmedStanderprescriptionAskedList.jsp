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
		<li class="active"><a href="${ctx}/web/sicmedStanderprescriptionAsked/">标准处方列表</a></li>
		<%-- <shiro:hasPermission name="web:sicmedStanderprescriptionAsked:edit"><li><a href="${ctx}/web/sicmedStanderprescriptionAsked/form">单表添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedStanderprescriptionAsked" action="${ctx}/web/sicmedStanderprescriptionAsked/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>处方名称：</label>
				<form:input path="sicmedStanderprescription.prescriptionName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医嘱类别：</label>
				<form:input path="sicmedAskedClass.askedCalss" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>治疗疾病：</label>
				<form:input path="sicmedStanderprescription.sicmedDisease.diseaseName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<%-- <li><label>医嘱项目：</label>
				<form:input path="orderCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			<!-- 	<th>标准处方中的医嘱id</th> -->
				<th>标准处方名称</th>
				<th>医嘱类别</th>
				<th>医嘱详情</th>
				<th>治疗疾病</th>
			<!-- 	<th>药品用法</th> -->
				<th>医生名字</th>
			<!-- 	<th>修改的医生</th> -->
				<th>备注</th>
				<shiro:hasPermission name="web:sicmedStanderprescriptionAsked:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedStanderprescriptionAsked">
			<tr>
				<%-- <td><a href="${ctx}/web/sicmedStanderprescriptionAsked/form?id=${sicmedStanderprescriptionAsked.id}">
					${sicmedStanderprescriptionAsked.id}
				</a></td> --%>
				<td>
					${sicmedStanderprescriptionAsked.sicmedStanderprescription.prescriptionName}
				</td>
				<td>
					${sicmedStanderprescriptionAsked.sicmedAskedClass.askedCalss}
				</td>
				<td>
					${sicmedStanderprescriptionAsked.detailStr}
				</td>
				<%-- <td>
					${sicmedStanderprescriptionAsked.sicmedMedicalUse.useName}
				</td> --%>
				<td>
					${sicmedStanderprescriptionAsked.sicmedStanderprescription.sicmedDisease.diseaseName}
				</td>
				<td>
					${sicmedStanderprescriptionAsked.createUser.id}
				</td>
				<%-- <td>
					${sicmedStanderprescriptionAsked.updateUser.id}
				</td> --%>
				<td>
					${sicmedStanderprescriptionAsked.remarks}
				</td>
				<%-- <shiro:hasPermission name="web:sicmedStanderprescriptionAsked:edit"><td>
    				<a href="${ctx}/web/sicmedStanderprescriptionAsked/form?id=${sicmedStanderprescriptionAsked.id}">修改</a>
					<a href="${ctx}/web/sicmedStanderprescriptionAsked/delete?id=${sicmedStanderprescriptionAsked.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>