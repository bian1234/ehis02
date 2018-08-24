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
		<li class="active"><a href="${ctx}/web/sicmedCurePrice/">单表列表</a></li>
		<%-- <shiro:hasPermission name="rest:sicmedCurePrice:edit"><li><a href="${ctx}/web/sicmedCurePrice/form">单表添加</a></li></shiro:hasPermission>
	 --%></ul>
	<form:form id="searchForm" modelAttribute="sicmedCurePrice" action="${ctx}/web/sicmedCurePrice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
 			<li><label>治疗名称：</label>
				<form:input path="sicmedCureCheck.cureName" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>是否启用：</label>
				<select class="input-medium required" name="delFlag">
				 	<option value="" >查全部</option>
				 	<option value="0" selected="selected">启用</option>
				 	<option value="1">未启用</option>
				</select>
			</li>
			<li><label>就诊时间：</label>
				<input name="startDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedCurePrice.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li><label>截止时间：</label>
				<input name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedCurePrice.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>治疗名称</th>
<!-- 				<th>治疗类型</th>
				<th>价格编号</th> -->
				<th>价格</th>
				<th>是否启用</th>
				<th>价格启用时间</th>
				<th>价格截止时间</th>
				<th>更新时间</th>
				<th>备注</th>
				<%-- <shiro:hasPermission name="rest:sicmedCurePrice:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedCurePrice">
			<tr>
			<%-- 	<td><a href="${ctx}/web/sicmedCurePrice/form?id=${sicmedCurePrice.id}">
					${sicmedCurePrice.sicmedCureCheck.cureName}
				</a></td> --%>
				<td>
					${sicmedCurePrice.sicmedCureCheck.cureName}
				</td>
				<%-- <td>
					${sicmedCurePrice.cureType}
				</td> --%>
			<%-- 	<td>
					${sicmedCurePrice.priceCode}
				</td> --%>
				<td>
					${sicmedCurePrice.price}
				</td>
				<td>
					${sicmedCurePrice.isUsePrice}
				</td>
				<td>
					<fmt:formatDate value="${sicmedCurePrice.priceInsertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${sicmedCurePrice.priceCutoffDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${sicmedCurePrice.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedCurePrice.remarks}
				</td>
			<%-- 	<shiro:hasPermission name="rest:sicmedCurePrice:edit"><td>
    				<a href="${ctx}/web/sicmedCurePrice/form?id=${sicmedCurePrice.id}">修改</a>
					<a href="${ctx}/web/sicmedCurePrice/delete?id=${sicmedCurePrice.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>