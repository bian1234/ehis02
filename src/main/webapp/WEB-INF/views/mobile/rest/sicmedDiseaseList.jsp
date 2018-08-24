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
		<li class="active"><a href="${ctx}/web/sicmedDisease/">疾病列表</a></li>
		<shiro:hasPermission name="rest:sicmedDisease:edit"><li><a href="${ctx}/web/sicmedDisease/form">疾病添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedDisease" action="${ctx}/web/sicmedDisease/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		<%-- 	<li><label>疾病表id：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<%-- <li><label>疾病类别编码(对应疾病编码表)：</label>
				<form:input path="diseaseClass.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li><label>疾病名称：</label>
				<form:input path="diseaseName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>疾病编码：</label>
				<form:input path="diseaseCode" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>疾病类别：</label>
				<form:input path="diseaseClass.diseaseClassName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
		<%-- 	<li><label>疾病英文名：</label>
				<form:input path="diseaseNameEnglish" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>疾病拼音缩写名：</label>
				<form:input path="diseaseNamePmpa" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>疾病名称</th>
				<th>疾病编码</th>
				<th>疾病类别</th>
				<th>疾病英文名</th>
				<th>疾病拼音缩写名</th>
				<!-- <th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>更新时间</th> -->
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedDisease:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedDisease">
			<tr>
			<%-- 	<td><a href="${ctx}/web/sicmedDisease/form?id=${sicmedDisease.id}">
					${sicmedDisease.id}
				</a></td> --%>
				<td><a href="${ctx}/web/sicmedDisease/form?id=${sicmedDisease.id}">
					${sicmedDisease.diseaseName}
				</a></td>
				<%-- <td>
					${sicmedDisease.diseaseName}
				</td> --%>
				<td>
					${sicmedDisease.diseaseCode}
				</td>
				<td>
					${sicmedDisease.diseaseClass.diseaseClassName}
				</td>
				<td>
					${sicmedDisease.diseaseNameEnglish}
				</td>
				<td>
					${sicmedDisease.diseaseNamePmpa}
				</td>
				<%-- <td>
					${sicmedDisease.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedDisease.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedDisease.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedDisease.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					${sicmedDisease.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedDisease:edit"><td>
    				<a href="${ctx}/web/sicmedDisease/form?id=${sicmedDisease.id}">修改</a>
					<a href="${ctx}/web/sicmedDisease/delete?id=${sicmedDisease.id}" onclick="return confirmx('确认要删除该保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>