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
		<li class="active"><a href="${ctx}/rest/sicmedMedicalUse/">单表列表</a></li>
		<shiro:hasPermission name="rest:sicmedMedicalUse:edit"><li><a href="${ctx}/rest/sicmedMedicalUse/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedMedicalUse" action="${ctx}/rest/sicmedMedicalUse/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>药品用法表ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>药品医嘱ID：</label>
				<form:input path="askedCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>用法分类：</label>
				<form:input path="useGroup" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>药品用法名称：</label>
				<form:input path="useName" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>药品类型：</label>
				<form:input path="useBun" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<li><label>药品计量单位：</label>
				<form:input path="useUnit" htmlEscape="false" maxlength="12" class="input-medium"/>
			</li>
			<li><label>使用数量：</label>
				<form:input path="useAmount" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>天数：</label>
				<form:input path="useDay" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>次数：</label>
				<form:input path="useBout" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>创建人：</label>
				<form:input path="createUser" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>修改人：</label>
				<form:input path="updateUser" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>创建人：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedMedicalUse.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>修改人：</label>
				<form:input path="updateBy.id" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="updateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedMedicalUse.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>备注：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="200" class="input-medium"/>
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
				<th>药品用法表ID</th>
				<th>药品医嘱ID</th>
				<th>用法分类</th>
				<th>药品用法名称</th>
				<th>药品类型</th>
				<th>药品计量单位</th>
				<th>使用数量</th>
				<th>天数</th>
				<th>次数</th>
				<th>创建人</th>
				<th>修改人</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>更新时间</th>
				<th>备注</th>
				<th>删除标记</th>
				<shiro:hasPermission name="rest:sicmedMedicalUse:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedMedicalUse">
			<tr>
				<td><a href="${ctx}/rest/sicmedMedicalUse/form?id=${sicmedMedicalUse.id}">
					${sicmedMedicalUse.id}
				</a></td>
				<td>
					${sicmedMedicalUse.askedCode}
				</td>
				<td>
					${sicmedMedicalUse.useGroup}
				</td>
				<td>
					${sicmedMedicalUse.useName}
				</td>
				<td>
					${sicmedMedicalUse.useBun}
				</td>
				<td>
					${sicmedMedicalUse.useUnit}
				</td>
				<td>
					${sicmedMedicalUse.useAmount}
				</td>
				<td>
					${sicmedMedicalUse.useDay}
				</td>
				<td>
					${sicmedMedicalUse.useBout}
				</td>
				<td>
					${sicmedMedicalUse.createUser}
				</td>
				<td>
					${sicmedMedicalUse.updateUser}
				</td>
				<td>
					${sicmedMedicalUse.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedMedicalUse.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedMedicalUse.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedMedicalUse.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedMedicalUse.remarks}
				</td>
				<td>
					${fns:getDictLabel(sicmedMedicalUse.delFlag, 'del_flag', '')}
				</td>
				<shiro:hasPermission name="rest:sicmedMedicalUse:edit"><td>
    				<a href="${ctx}/rest/sicmedMedicalUse/form?id=${sicmedMedicalUse.id}">修改</a>
					<a href="${ctx}/rest/sicmedMedicalUse/delete?id=${sicmedMedicalUse.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>