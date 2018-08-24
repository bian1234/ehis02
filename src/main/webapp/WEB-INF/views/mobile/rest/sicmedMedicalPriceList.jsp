<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>药品价格信息保存成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedMedicalPrice/">药品价格信息保存成功列表</a></li>
		<%-- <shiro:hasPermission name="rest:sicmedMedicalPrice:edit"><li><a href="${ctx}/web/sicmedMedicalPrice/form">药品价格信息保存成功添加</a></li></shiro:hasPermission>
	 --%></ul>
	<!-- <script type="text/javascript">  
　　		window.open("","name1","width=100,height=200,toolbar=no,scrollbars=no,menubar=no,screenX=100,screenY=100");  
　　	</script> -->  
	<form:form id="searchForm" modelAttribute="sicmedMedicalPrice" action="${ctx}/web/sicmedMedicalPrice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>药品名称：</label>
				<form:input path="sicmedMedical.medicalNameChina" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>药品编号：</label>
				<form:input path="sicmedMedical.medicalCode" htmlEscape="false" maxlength="8" class="input-medium"/>
			</li>
			<li><label>是否启用：</label>
				<select class="input-medium required" name="delFlag">
				 	<option value="">查全部</option>
				 	<option value="0" selected="selected">启用</option>
				 	<option value="1">未启用</option>
				</select>
			</li>
			<li><label>起始时间：</label>
				<input name="startDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedMedicalPrice.startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li><label>截止时间：</label>
				<input name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedMedicalPrice.endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>药品名称</th>
				<th>药品编号</th>
				<th>药品进价</th>
				<th>药品售价</th>
				<th>是否启用</th>
				<th>价格启用时间</th>
				<th>价格截止时间</th>
				<th>备注</th>
				<%-- <shiro:hasPermission name="rest:sicmedMedicalPrice:edit"><th>操作</th></shiro:hasPermission>
			 --%></tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedMedicalPrice">
			<tr>
			<%-- 	<td><a href="${ctx}/web/sicmedMedicalPrice/form?id=${sicmedMedicalPrice.id}">
					${sicmedMedicalPrice.sicmedMedical.medicalNameChina}
				</a></td> --%>
				<td>
					${sicmedMedicalPrice.sicmedMedical.medicalNameChina}
				</td>
				<td>
					${sicmedMedicalPrice.sicmedMedical.medicalCode}
				</td>
				<td>
					${sicmedMedicalPrice.priceEnter}
				</td>
				<td>
					${sicmedMedicalPrice.priceSale}
				</td>
				<td>
					${sicmedMedicalPrice.isUsePrice}
				</td>
				
				<td>
					<fmt:formatDate value="${sicmedMedicalPrice.priceInsertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					
				</td>
				<td>
					<fmt:formatDate value="${sicmedMedicalPrice.priceCutoffDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					
				</td>  
				<td>
					${sicmedMedicalPrice.remarks}
				</td>
				<%-- <shiro:hasPermission name="rest:sicmedMedicalPrice:edit"><td>
    				<a href="${ctx}/web/sicmedMedicalPrice/form?id=${sicmedMedicalPrice.id}">修改</a>
					<a href="${ctx}/web/sicmedMedicalPrice/delete?id=${sicmedMedicalPrice.id}" onclick="return confirmx('确认要删除该药品价格信息保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>