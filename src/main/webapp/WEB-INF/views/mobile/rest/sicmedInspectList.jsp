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
		<li class="active"><a href="${ctx}/web/sicmedInspect/">单表列表</a></li>
		<shiro:hasPermission name="rest:sicmedInspect:edit"><li><a href="${ctx}/web/sicmedInspect/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedInspect" action="${ctx}/web/sicmedInspect/" 
		   method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>检验编号：</label>
				<form:input path="inspectCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>检验名称：</label>
				<form:input path="inspectName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>检查拼音：</label>
				<form:input path="inspectNamePY" htmlEscape="false" maxlength="40" class="input-medium"/>
			</li>
			<%-- <li><label>检验类别：</label>
				<form:input path="sicmedInspectClass.inspectName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li><label>检验类别：</label>
				<sys:treeselect id="parent" 
					name="sicmedInspect.id" value="${sicmedInspect.sicmedInspectClass.id}" labelName="sicmedInspectClass.inspectName" labelValue="${sicmedInspect.sicmedInspectClass.inspectName}"
					title="父级编号" url="/web/sicmedInspect/treeData" extId="${sicmedInspect.sicmedInspectClass.id}" cssClass="" allowClear="true"/>
			
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>检验编号</th>
				<th>检验名称</th>
				<th>检验拼音</th>
				<th>检验价格</th>
				<th>检验类别名称</th>
				<th>检验名称详情</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedInspect:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedInspect">
			<tr>
				<td><a href="${ctx}/web/sicmedInspect/form?id=${sicmedInspect.id}">
					${sicmedInspect.inspectCode}
				</a></td>
				<td>
					${sicmedInspect.inspectName}
				</td>
				<td>
					${sicmedInspect.inspectNamePY}
				</td>
				<td>
					${sicmedInspect.sicmedInspectPrice.price}
				</td>
				<td>
					${sicmedInspect.sicmedInspectClass.inspectName}
				</td>
				<td>
					${sicmedInspect.inspectDetail}
				</td>
				<td>
					<fmt:formatDate value="${sicmedInspect.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedInspect.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedInspect:edit"><td>
    				<a href="${ctx}/web/sicmedInspect/form?id=${sicmedInspect.id}">修改</a>
					<a href="${ctx}/web/sicmedInspect/delete?id=${sicmedInspect.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>