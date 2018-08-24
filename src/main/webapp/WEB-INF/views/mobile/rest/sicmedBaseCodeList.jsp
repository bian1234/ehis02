<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存基础编码成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedBaseCode/">保存基础编码成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedBaseCode:edit"><li><a href="${ctx}/web/sicmedBaseCode/form">保存基础编码成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedBaseCode" action="${ctx}/rest/sicmedBaseCode/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>基础编码表id：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>业务类型：</label>
				<form:input path="codeBusiness" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>子业务类型：</label>
				<form:input path="codeBuns" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>业务编码：</label>
				<form:input path="code" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>名称：</label>
				<form:input path="codeName" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>扩展编码：</label>
				<form:input path="codeExtand" htmlEscape="false" maxlength="80" class="input-medium"/>
			</li>
			<li><label>适用日期：</label>
				<input name="codeDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedBaseCode.codeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>是否使用：</label>
				<form:input path="codeUse" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>基础编码表id</th>
				<th>业务类型</th>
				<th>子业务类型</th>
				<th>业务编码</th>
				<th>名称</th>
				<th>扩展编码</th>
				<th>适用日期</th>
				<th>是否使用</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedBaseCode:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedBaseCode">
			<tr>
				<td><a href="${ctx}/web/sicmedBaseCode/form?id=${sicmedBaseCode.id}">
					${sicmedBaseCode.id}
				</a></td>
				<td>
					${sicmedBaseCode.codeBusiness}
				</td>
				<td>
					${sicmedBaseCode.codeBuns}
				</td>
				<td>
					${sicmedBaseCode.code}
				</td>
				<td>
					${sicmedBaseCode.codeName}
				</td>
				<td>
					${sicmedBaseCode.codeExtand}
				</td>
				<td>
					<fmt:formatDate value="${sicmedBaseCode.codeDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedBaseCode.codeUse}
				</td>
				<td>
					<fmt:formatDate value="${sicmedBaseCode.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedBaseCode.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedBaseCode:edit"><td>
    				<a href="${ctx}/web/sicmedBaseCode/form?id=${sicmedBaseCode.id}">修改</a>
					<a href="${ctx}/web/sicmedBaseCode/delete?id=${sicmedBaseCode.id}" onclick="return confirmx('确认要删除该保存基础编码成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>