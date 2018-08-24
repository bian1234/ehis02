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
		<li class="active"><a href="${ctx}/rest/sicmedEntrustedAsked/">单表列表</a></li>
		<shiro:hasPermission name="rest:sicmedEntrustedAsked:edit"><li><a href="${ctx}/rest/sicmedEntrustedAsked/form">单表添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedEntrustedAsked" action="${ctx}/rest/sicmedEntrustedAsked/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>嘱托医嘱Id：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>对应id：</label>
				<form:input path="orderCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>嘱托医嘱信息：</label>
				<form:input path="entrustedAsked" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>嘱托医嘱Id</th>
				<th>嘱托医嘱信息</th>
				<th>病例表外键</th>
				<th>医嘱类别(对应医嘱分类编码表)</th>
				<th>对应id</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedEntrustedAsked:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedEntrustedAsked">
			<tr>
				<td><a href="${ctx}/rest/sicmedEntrustedAsked/form?id=${sicmedEntrustedAsked.id}">
					${sicmedEntrustedAsked.id}
				</a></td>
				<td>
					${sicmedEntrustedAsked.entrustedAsked}
				</td>
				<td>
					${sicmedEntrustedAsked.askedCaseCode}
				</td>
				<td>
					${sicmedEntrustedAsked.askedClassCode}
				</td>
				<td>
					${sicmedEntrustedAsked.orderCode}
				</td>
				<td>
					<fmt:formatDate value="${sicmedEntrustedAsked.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedEntrustedAsked.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedEntrustedAsked:edit"><td>
    				<a href="${ctx}/rest/sicmedEntrustedAsked/form?id=${sicmedEntrustedAsked.id}">修改</a>
					<a href="${ctx}/rest/sicmedEntrustedAsked/delete?id=${sicmedEntrustedAsked.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>