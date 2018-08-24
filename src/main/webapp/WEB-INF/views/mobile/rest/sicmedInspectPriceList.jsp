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
		<li class="active"><a href="${ctx}/web/sicmedInspectPrice/">单表列表</a></li>
		<%-- <shiro:hasPermission name="rest:sicmedInspectPrice:edit"><li><a href="${ctx}/web/sicmedInspectPrice/form">单表添加</a></li></shiro:hasPermission>
	 --%></ul>
	<form:form id="searchForm" modelAttribute="sicmedInspectPrice" action="${ctx}/web/sicmedInspectPrice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>检验名称：</label>
				<form:input path="sicmedInspect.inspectName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			
			<li><label>是否启用：</label>
				<select class="input-medium required" name="delFlag">
					<c:choose>
						<c:when test="${sicmedInspectPrice.delFlag==0}">
							<option value="999">全部</option>
				 			<option value="0" selected="selected">启用</option>
				 			<option value="1">未启用</option>
						</c:when>
						<c:when test="${sicmedInspectPrice.delFlag==1}">
							<option value="999">全部</option>
				 			<option value="0">启用</option>
				 			<option value="1" selected="selected">未启用</option>
						</c:when>
						<c:otherwise>
							<option value="999" selected="selected">全部</option>
				 			<option value="0">启用</option>
				 			<option value="1">未启用</option>
						</c:otherwise>
					</c:choose>
				</select>
			</li>
			
			<li><label>就诊时间：</label>
				<input name="startDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedInspectPrice.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			
			<li><label>截止时间：</label>
				<input name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedInspectPrice.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>检验名称</th>
				<th>价格</th>
				<th>是否启用</th>
				<th>价格启用时间</th>
				<th>价格截止时间</th>
				<th>创建时间</th>
				<th>更新时间</th>
				<th>备注</th>
				<%-- <shiro:hasPermission name="rest:sicmedInspectPrice:edit"><th>操作</th></shiro:hasPermission>
	 --%>		</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedInspectPrice">
			<tr>
				<%-- <td><a href="${ctx}/web/sicmedInspectPrice/form?id=${sicmedInspectPrice.id}">
					${sicmedInspectPrice.sicmedInspect.inspectName}
				</a></td> --%>
				<td>
					${sicmedInspectPrice.sicmedInspect.inspectName}
				</td>
				<td>
					${sicmedInspectPrice.price}
				</td>
				<td>
					${sicmedInspectPrice.isUsePrice}
				</td>
				<td>
					<fmt:formatDate value="${sicmedInspectPrice.priceInsertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${sicmedInspectPrice.priceCutoffDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
			<%-- 	<td>
					${sicmedInspectPrice.createBy.id}
				</td> --%>
				<td>
					<fmt:formatDate value="${sicmedInspectPrice.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${sicmedInspectPrice.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedInspectPrice.remarks}
				</td>
				<%-- <shiro:hasPermission name="rest:sicmedInspectPrice:edit"><td>
    				<a href="${ctx}/web/sicmedInspectPrice/form?id=${sicmedInspectPrice.id}">修改</a>
					<a href="${ctx}/web/sicmedInspectPrice/delete?id=${sicmedInspectPrice.id}" onclick="return confirmx('确认要删除该单表吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>