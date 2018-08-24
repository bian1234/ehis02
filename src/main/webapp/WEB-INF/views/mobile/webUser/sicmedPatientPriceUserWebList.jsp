<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>患者价格明细表保存成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				$(this).attr("disabled",true); 
				top.$.jBox.confirm("确认要导出缴费信息吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/web/sicmedPatientPrice/price");
						$("#searchForm").submit();
						$("#searchForm").attr("action","${ctx}/web/sicmedPatientPrice/");
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
				//$("#btnExport").click($("#btnExport").click(function(){});  //绑定其它函数
				$(this).attr("disabled",false);
			});
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
	<div id="patientDetail">
		<ul class="nav nav-tabs" style="margin-top: 8pt"><li>
			<c:choose>
				<c:when test="${isPay=='1'}">
					<li class="active"><a href="${ctx}/web/user/sicmedPatientPrice/patientPriceList?isPay=1">收费列表</a></li>
					<li><a href="${ctx}/web/user/sicmedPatientPrice/patientPriceList?isPay=2">退费列表</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx}/web/user/sicmedPatientPrice/patientPriceList?isPay=1">收费列表</a></li>
					<li class="active"><a href="${ctx}/web/user/sicmedPatientPrice/patientPriceList?isPay=2">退费列表</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	
	<form:form id="searchForm" modelAttribute="sicmedPatientPrice" action="${ctx}/web/user/sicmedPatientPrice/patientPriceList?isPay=${isPay}" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li style="height: 20px"><label style="width: 25pt"> <i
					class="icon-search icon-white"></i>
			</label> <form:input path="sicmedPatient.searchContent"
					placeholder="请输入患者编号或名字" htmlEscape="false" style="height:25px;margin-bottom:5pt"
					maxlength="15" class="input-medium" /></li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-hover">
		<thead>
			<tr>
				<th>患者名称</th>
				<th>患者编号</th>
				<th>患者身份证号</th>
				<th>收费分类</th>
				<th>收费名称详情</th>
				<th>收费项目价格</th>
				<th>收费状态</th>
 				<th>收费人员</th>
				<th>创建时间</th>
				</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedPatientPrice">
			<tr>
				<td>
					${sicmedPatientPrice.sicmedPatient.patientName}
				</td>
				<td>
					${sicmedPatientPrice.sicmedPatient.patientNumber}
				</td>
				<td>
					${sicmedPatientPrice.sicmedPatient.patientCard}
				</td>
				<td>
					${sicmedPatientPrice.priceClassTypeName}
				</td>
				<td>
					${sicmedPatientPrice.priceName}
				</td>
				<td>
					${sicmedPatientPrice.price}
				</td>
				<td>
					${sicmedPatientPrice.payType}
				</td>
				<td>
					${sicmedPatientPrice.createUser.userName}
				</td>
				<td>
					<fmt:formatDate value="${sicmedPatientPrice.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <shiro:hasPermission name="rest:sicmedPatientPrice:edit"><td>
    				<a href="${ctx}/web/sicmedPatientPrice/form?id=${sicmedPatientPrice.id}">修改</a>
					<a href="${ctx}/web/sicmedPatientPrice/delete?id=${sicmedPatientPrice.id}" onclick="return confirmx('确认要删除该患者价格明细表保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
		</table>
		<div class="pagination">${page}</div>
	</div>
</body>
</html>