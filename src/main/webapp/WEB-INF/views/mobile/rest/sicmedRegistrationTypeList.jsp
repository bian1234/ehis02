<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>挂号类别管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedRegistrationType/">挂号类别列表</a></li>
		<%-- <shiro:hasPermission name="rest:sicmedRegistrationType:edit"><li><a href="${ctx}/web/sicmedRegistrationType/form">挂号类别添加</a></li></shiro:hasPermission>
 --%>	
 	</ul>
	<form:form id="searchForm" modelAttribute="sicmedRegisteredType" action="${ctx}/web/sicmedRegistrationType/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>类型：</label>
				<form:input path="nameChina" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>类型拼音：</label>
				<form:input path="nameEnglish" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<!-- <th>UUID</th> -->
				<!-- <th>编号</th> -->
				<th>挂号类型</th>
				<th>挂号类型拼音</th>
				<th>挂号等级</th>
				<!-- <th>挂号价格</th> -->
				<th>更新时间</th>
				<%--<th>备注</th>
				 <shiro:hasPermission name="rest:sicmedRegistrationType:edit"><th>操作</th></shiro:hasPermission>
		 --%>	</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedRegisteredType">
			<tr>
				<%-- <td><a href="${ctx}/web/sicmedRegistrationType/form?id=${sicmedRegisteredType.id}">
					${sicmedRegisteredType.nameChina}
				</a></td> --%>
			<%-- 	<td>
					${sicmedRegisteredType.code}
				</td> --%>
				<td>
					${sicmedRegisteredType.nameChina}
				</td>
				<td>
					${sicmedRegisteredType.nameEnglish}
				</td>
				<td>
					${sicmedRegisteredType.codeGrades}
				</td>
				<%-- <td>
					${sicmedRegisteredType.sicmedRegisteredPrice.materialFee}
				</td> --%>
				<td>
					<fmt:formatDate value="${sicmedRegisteredType.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedRegisteredType.remarks}
				</td>
				<%-- <shiro:hasPermission name="rest:sicmedRegistrationType:edit"><td>
    				<a href="${ctx}/web/sicmedRegistrationType/form?id=${sicmedRegisteredType.id}">修改</a>
					<a href="${ctx}/web/sicmedRegistrationType/delete?id=${sicmedRegisteredType.id}" onclick="return confirmx('确认要删除该挂号类别吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>