<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>患者医嘱保存成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedPatientAsked/">患者医嘱保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedPatientAsked:edit"><li><a href="${ctx}/web/sicmedPatientAsked/form">患者医嘱保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedPatientAsked" action="${ctx}/web/sicmedPatientAsked/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>患者医嘱表ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>患者编号(关联患者表)：</label>
				<form:input path="sicmedPatient.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>科室编号(对应科室表)：</label>
				<form:input path="sicmedBranch.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医生编号(对应用户表)：</label>
				<form:input path="sicmedUser.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医嘱编号(对应医嘱信息表)：</label>
				<form:input path="sicmedAsked.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>药品类型(对应基础编码表中的BUN)：</label>
				<form:input path="sicmedBaseCode.id" htmlEscape="false" maxlength="2" class="input-medium"/>
			</li>
			<li><label>附加医嘱信息：</label>
				<form:input path="plusName" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<li><label>传送科室(对应科室表)：</label>
				<form:input path="sicmedAskedBranch.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>药品编号(对应药品表)：</label>
				<form:input path="sicmedMedical.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>患者编号(关联患者表)</th>
				<th>科室编号(对应科室表)</th>
				<th>医生编号(对应用户表)</th>
				<th>医嘱编号(对应医嘱信息表)</th>
				<th>药品类型(对应基础编码表中的BUN)</th>
				<th>附加医嘱信息</th>
				<th>传送科室(对应科室表)</th>
				<th>药品编号(对应药品表)</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedPatientAsked:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedPatientAsked">
			<tr>
				<td><a href="${ctx}/web/sicmedPatientAsked/form?id=${sicmedPatientAsked.id}">
					${sicmedPatientAsked.sicmedPatient.id}
				</a></td>
				<td>
					${sicmedPatientAsked.sicmedBranch.id}
				</td>
				<td>
					${sicmedPatientAsked.sicmedUser.id}
				</td>
				<td>
					${sicmedPatientAsked.sicmedAsked.id}
				</td>
				<td>
					${sicmedPatientAsked.sicmedBaseCode.id}
				</td>
				<td>
					${sicmedPatientAsked.plusName}
				</td>
				<td>
					${sicmedPatientAsked.sicmedAskedBranch.id}
				</td>
				<td>
					${sicmedPatientAsked.sicmedMedical.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedPatientAsked.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedPatientAsked.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedPatientAsked:edit"><td>
    				<a href="${ctx}/web/sicmedPatientAsked/form?id=${sicmedPatientAsked.id}">修改</a>
					<a href="${ctx}/web/sicmedPatientAsked/delete?id=${sicmedPatientAsked.id}" onclick="return confirmx('确认要删除该患者医嘱保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>