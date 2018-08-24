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
		<li class="active"><a href="${ctx}/web/sicmedDiseaseClass/">疾病类别列表</a></li>
		<shiro:hasPermission name="rest:sicmedDiseaseClass:edit"><li><a href="${ctx}/web/sicmedDiseaseClass/form">疾病类别添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedDiseaseClass" action="${ctx}/web/sicmedDiseaseClass/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>疾病类别表id：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li><label>类别名称：</label>
				<form:input path="diseaseClassName" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>类别编号：</label>
				<form:input path="diseaseClassCode" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<%-- <li><label>创建人：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedDiseaseClass.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>修改人：</label>
				<form:input path="updateBy.id" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="updateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedDiseaseClass.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>备注：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>删除标记：</label>
				<form:radiobuttons path="delFlag" items="${fns:getDictList('del_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
		<!-- 		<th>疾病类别表id</th> -->
				<th>疾病类别名称</th>
				<th>疾病类别编号</th>
			<!-- 	<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>更新时间</th> -->
				<th>备注</th>
				<!-- <th>删除标记</th> -->
				<shiro:hasPermission name="rest:sicmedDiseaseClass:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedDiseaseClass">
			<tr>
				<%-- <td><a href="${ctx}/web/sicmedDiseaseClass/form?id=${sicmedDiseaseClass.id}">
					${sicmedDiseaseClass.id}
				</a></td> --%>
				<td><a href="${ctx}/web/sicmedDiseaseClass/form?id=${sicmedDiseaseClass.id}">
					${sicmedDiseaseClass.diseaseClassName}
				</a></td>
				<%-- <td>
					${sicmedDiseaseClass.diseaseClassName}
				</td> --%>
				<td>
					${sicmedDiseaseClass.diseaseClassCode}
				</td>
				<%-- <td>
					${sicmedDiseaseClass.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedDiseaseClass.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedDiseaseClass.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedDiseaseClass.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					${sicmedDiseaseClass.remarks}
				</td>
				<%-- <td>
					${fns:getDictLabel(sicmedDiseaseClass.delFlag, 'del_flag', '')}
				</td> --%>
				<shiro:hasPermission name="rest:sicmedDiseaseClass:edit"><td>
    				<a href="${ctx}/web/sicmedDiseaseClass/form?id=${sicmedDiseaseClass.id}">修改</a>
					<a href="${ctx}/web/sicmedDiseaseClass/delete?id=${sicmedDiseaseClass.id}" onclick="return confirmx('确认要删除该保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>