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
		<li class="active"><a href="${ctx}/rest/sicmedHospital/">单表列表</a></li>
		<shiro:hasPermission name="rest:sicmedHospital:edit"><li><a href="${ctx}/rest/sicmedHospital/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedHospital" action="${ctx}/rest/sicmedHospital/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>hospital_id：</label>
				<form:input path="hospitalId" htmlEscape="false" maxlength="5" class="input-medium"/>
			</li>
			<li><label>hospital_name：</label>
				<form:input path="hospitalName" htmlEscape="false" maxlength="120" class="input-medium"/>
			</li>
			<li><label>hospital_grade：</label>
				<form:input path="hospitalGrade" htmlEscape="false" maxlength="120" class="input-medium"/>
			</li>
			<li><label>hospital_add：</label>
				<form:input path="hospitalAdd" htmlEscape="false" maxlength="120" class="input-medium"/>
			</li>
			<li><label>city_code：</label>
				<form:input path="cityCode" htmlEscape="false" maxlength="5" class="input-medium"/>
			</li>
			<li><label>创建者：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedHospital.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>更新者：</label>
				<form:input path="updateBy.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="updateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedHospital.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>备注信息：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>删除标记：</label>
				<form:radiobuttons path="delFlag" items="${fns:getDictList('del_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>hospital_id</th>
				<th>hospital_name</th>
				<th>hospital_grade</th>
				<th>hospital_add</th>
				<th>city_code</th>
				<th>创建者</th>
				<th>创建时间</th>
				<th>更新者</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<th>删除标记</th>
				<shiro:hasPermission name="rest:sicmedHospital:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedHospital">
			<tr>
				<td><a href="${ctx}/rest/sicmedHospital/form?id=${sicmedHospital.id}">
					${sicmedHospital.hospitalId}
				</a></td>
				<td>
					${sicmedHospital.hospitalName}
				</td>
				<td>
					${sicmedHospital.hospitalGrade}
				</td>
				<td>
					${sicmedHospital.hospitalAdd}
				</td>
				<td>
					${sicmedHospital.cityCode}
				</td>
				<td>
					${sicmedHospital.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedHospital.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedHospital.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedHospital.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedHospital.remarks}
				</td>
				<td>
					${fns:getDictLabel(sicmedHospital.delFlag, 'del_flag', '')}
				</td>
				<shiro:hasPermission name="rest:sicmedHospital:edit"><td>
    				<a href="${ctx}/rest/sicmedHospital/form?id=${sicmedHospital.id}">修改</a>
					<a href="${ctx}/rest/sicmedHospital/delete?id=${sicmedHospital.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>