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
	
	<form:form id="searchForm" modelAttribute="sicmedPatientPrice" action="${ctx}/web/sicmedPatientPrice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>患者姓名：</label> <form:input
					path="sicmedPatient.patientName" htmlEscape="false" maxlength="30"
					class="input-medium" /></li>
			<li><label>身份证号：</label> <form:input
					path="sicmedPatient.patientCard" htmlEscape="false" maxlength="18"
					class="input-medium" /></li>
		<%-- 	<li><label>收费项目：</label> 
				<sys:treeselect id="priceClassTypeName"
					name="priceClassType" value="${sicmedPatientPrice.priceClassType}"
					labelName="priceClassTypeName" labelValue="${sicmedPatientPrice.priceClassType}"
					title="父级编号" url="/web/sicmedPatientPrice/treeData" cssClass="" allowClear="false" /></li> --%>
						<li><label>收费项目：</label> 
			<sys:treeselect id="priceClassType"
					name="priceClassType" value="${sicmedPatientPrice.priceClassType}"
					labelName="priceClassTypeName" labelValue="${sicmedPatientPrice.priceClassTypeName}"
					title="父级编号" url="/web/sicmedPatientPrice/treeData" cssClass="" allowClear="true" /></li>
			<li><label>收费状态：</label> 
				<sys:treeselect id="isPay"
					name="isPay" value="${sicmedPatientPrice.isPay}" labelName="payType"
					labelValue="${sicmedPatientPrice.payType}" title="父级编号"
					url="/web/sicmedPatientPrice/selectIsPay"
					cssClass="" allowClear="true" /></li>
			<li><label>就诊时间：</label> <input name="startDate" type="text"
				readonly="readonly" maxlength="20" class="input-medium Wdate"
				value="<fmt:formatDate value="${startDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
			</li>
			<li><label>截止时间：</label> <input name="endDate" type="text"
				readonly="readonly" maxlength="20" class="input-medium Wdate"
				value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
			</li>
			<li><label style="font-size: 14PX; color: red">数量：${page.count}</label>
			</li>
			<li><label style="font-size: 14PX; color: red">总价：${page.allNumber}</label>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary"
				type="submit" value="查询" /> <input id="btnExport"
				class="btn btn-primary" type="button" value="导出" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>患者名称</th>
				<th>患者身份证号</th>
				<th>收费分类</th>
				<th>收费名称详情</th>
				<th>收费项目价格</th>
				<th>收费状态</th>
 				<th>收费人员</th>
				<th>创建时间</th>
				<th>备注</th>
				</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedPatientPrice">
			<tr>
				<td>
					${sicmedPatientPrice.sicmedPatient.patientName}
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
				<td>
					${sicmedPatientPrice.remarks}
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
</body>
</html>