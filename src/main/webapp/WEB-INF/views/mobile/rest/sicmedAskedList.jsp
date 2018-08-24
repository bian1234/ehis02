<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医嘱保存成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedAsked/">医嘱保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedAsked:edit"><li><a href="${ctx}/web/sicmedAsked/form">医嘱保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedAsked" action="${ctx}/web/sicmedAsked/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>医嘱信息表id：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
		 	<li><label>医嘱类别(对应医嘱分类编码表)：</label>
				<form:input path="sicmedAskedClass.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>  --%>
			<li><label>医嘱编码：</label>
				<form:input path="askedCode" htmlEscape="false" maxlength="8" class="input-medium"/>
			</li>
			<li><label>医嘱名称：</label>
				<form:input path="askedName" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<%-- <li><label>医嘱扩展名：</label>
				<form:input path="askedNameExtand" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li> --%>
			<li><label>医嘱编号：</label>
				<form:input path="orderCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<%-- <li><label>医嘱所属病例：</label>
				<form:input path="sicmedCase.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>患者价格表id：</label>
				<form:input path="sicmedPatientPrice.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>医嘱编码</th>
				<th>医嘱分类</th>
		<!-- 		<th>医嘱编号</th> -->
				<th>医嘱名称</th>
				<th>医嘱扩展名</th>
		<!-- 		<th>医嘱所属病例</th>
				<th>患者价格表id</th> -->
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedAsked:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedAsked">
			<tr>
				<td><a href="${ctx}/web/sicmedAsked/form?id=${sicmedAsked.id}">
					${sicmedAsked.askedCode}
				</a></td>
				<td>
					${sicmedAsked.sicmedAskedClass.askedCalss}
				</td>
			<%-- 	<td>
					${sicmedAsked.orderCode}
				</td> --%>
				<td>
					${sicmedAsked.askedName}
				</td>
				<td>
					${sicmedAsked.askedNameExtand}
				</td>
			<%-- 	<td>
					${sicmedAsked.sicmedCase.id}
				</td>
				<td>
					${sicmedAsked.sicmedPatientPrice.id}
				</td> --%>
				<td>
					${sicmedAsked.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedAsked:edit"><td>
    				<a href="${ctx}/web/sicmedAsked/form?id=${sicmedAsked.id}">修改</a>
					<a href="${ctx}/web/sicmedAsked/delete?id=${sicmedAsked.id}" onclick="return confirmx('确认要删除该医嘱保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>