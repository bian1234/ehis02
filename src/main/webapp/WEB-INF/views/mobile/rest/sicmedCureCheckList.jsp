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
		<li class="active"><a href="${ctx}/web/sicmedCureCheck/">单表列表</a></li>
		<shiro:hasPermission name="rest:sicmedCureCheck:edit"><li><a href="${ctx}/web/sicmedCureCheck/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedCureCheck" action="${ctx}/web/sicmedCureCheck/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>治疗编号</label>
				<form:input path="cureCode" htmlEscape="false" maxlength="8" class="input-medium"/>
			</li>
			<li><label>治疗名称</label>
				<form:input path="cureName" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>治疗类别</label>
				<sys:treeselect id="parent" 
					name="sicmedCureClass.id" value="${sicmedCureCheck.sicmedCureClass.id}" labelName="sicmedCureClass.className" labelValue="${sicmedCureCheck.sicmedCureClass.className}"
					title="父级编号" url="/web/sicmedCureCheck/treeData" cssClass="" allowClear="true"/></li>
			<li><label>治疗拼音</label>
				<form:input path="cureNamePY" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>			
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>治疗编号</th>
				<th>治疗名称</th>
				<th>价格详情</th>
				<th>所属类别</th>
				<th>治疗详情</th>
				<th>治疗拼音</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedCureCheck:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedCureCheck">
			<tr>
				<td><a href="${ctx}/web/sicmedCureCheck/form?id=${sicmedCureCheck.id}">
					${sicmedCureCheck.cureCode}
				</a></td>
				<td>
					${sicmedCureCheck.cureName}
				</td>
				<td>
					${sicmedCureCheck.sicmedCurePrice.price}
				</td>
				<td>
					${sicmedCureCheck.sicmedCureClass.className}
				</td>
				<td>
					${sicmedCureCheck.cureDetail}
				</td>
				<td>
					${sicmedCureCheck.cureNamePY}
				</td>
				<td>
					<fmt:formatDate value="${sicmedCureCheck.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedCureCheck.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedCureCheck:edit"><td>
    				<a href="${ctx}/web/sicmedCureCheck/form?id=${sicmedCureCheck.id}">修改</a>
					<a href="${ctx}/web/sicmedCureCheck/delete?id=${sicmedCureCheck.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>