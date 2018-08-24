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
		<li class="active"><a href="${ctx}/web/sicmedTwxrayCheck/">单表列表</a></li>
		<shiro:hasPermission name="rest:sicmedTwxrayCheck:edit"><li><a href="${ctx}/web/sicmedTwxrayCheck/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedTwxrayCheck" action="${ctx}/web/sicmedTwxrayCheck/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>检查名称：</label>
				<form:input path="checkName" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>检查编号：</label>
				<form:input path="checkCode" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>名称拼音：</label>
				<form:input path="checkNamePY" htmlEscape="false" maxlength="80" class="input-medium"/>
			</li>
			<%-- <li><label>检查类别：</label>
				<form:input path="sicmedTwxrayClass.className" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li><label>检验类别：</label>
				<sys:treeselect id="parent" 
					name="sicmedTwxrayCheck.id" value="${sicmedTwxrayCheck.sicmedTwxrayClass.id}" labelName="sicmedTwxrayClass.className" labelValue="${sicmedTwxrayCheck.sicmedTwxrayClass.className}"
					title="父级编号" url="/web/sicmedTwxrayCheck/treeData" extId="${sicmedTwxrayCheck.sicmedTwxrayClass.id}" cssClass="" allowClear="true"/>
			
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>检查编码</th>
				<th>检查名称</th>
				<th>名称拼音</th>
				<th>检查价格</th>
				<th>检查类别</th>
				<th>修改人</th>
				<shiro:hasPermission name="rest:sicmedTwxrayCheck:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedTwxrayCheck">
			<tr>
				<td><a href="${ctx}/web/sicmedTwxrayCheck/form?id=${sicmedTwxrayCheck.id}">
					${sicmedTwxrayCheck.checkCode}
				</a></td>
				<td>
					${sicmedTwxrayCheck.checkName}
				</td>
				<td>
					${sicmedTwxrayCheck.checkNamePY}
				</td>
				<td>
					${sicmedTwxrayCheck.sicmedCheckPrice.checkPrice}
				</td>
				<td>
					${sicmedTwxrayCheck.sicmedTwxrayClass.className}
				</td>
				<td>
					${sicmedTwxrayCheck.updateBy.id}
				</td>
				<shiro:hasPermission name="rest:sicmedTwxrayCheck:edit"><td>
    				<a href="${ctx}/web/sicmedTwxrayCheck/form?id=${sicmedTwxrayCheck.id}">修改</a>
					<a href="${ctx}/web/sicmedTwxrayCheck/delete?id=${sicmedTwxrayCheck.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>