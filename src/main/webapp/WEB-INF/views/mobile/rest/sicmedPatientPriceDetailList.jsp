<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>患者价格明细表保存成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#payBut").click(function(){
				$.ajax({
					type: "get",
					cache: false,
					url: "${ctx}/web/user/sicmedPatientPrice/pay?patientId=${patientId}&isPay=${isPay}",
					data: "",
					dataType:"text",
					success:function(data){
						if(data=="0"){
							alert("缴费成功");
							}else{
								alert("缴费失败");
								} 
						},
						error:function(){
							alert("缴费失败");
							}
						});
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
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/web/user/sicmedPatient/">患者列表</a></li>
		<li class="active"><a href="${ctx}/web/user/sicmedPatientPrice/patientPriceDetail">缴费明细</a></li>
	</ul><br/>
	<%-- <form:form id="searchForm" modelAttribute="sicmedPatientPrice" action="${ctx}/web/user/sicmedPatientPrice/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>患者姓名：</label> 
			<form:input path="sicmedPatient.patientName" htmlEscape="false" maxlength="30"
					class="input-medium" /></li>
				<sys:treeselect id="parent"
					name="sicmedPatient.patientNumber" value="${sicmedPatient.patientNumber}"
					labelName="sicmedPatientPrice.patientName" labelValue="${sicmedPatient.patientName}"
					title="患者搜索" url="/web/user/sicmedPatientPrice/patient" cssClass="" allowClear="true" /></li>		
			<li><label>收费项目：</label> 
				<sys:treeselect id="priceClassType"
					name="priceClassType" value="${sicmedPatientPrice.priceClassType}"
					labelName="priceClassTypeName" labelValue="${sicmedPatientPrice.priceClassTypeName}"
					title="父级编号" url="/web/user/sicmedPatientPrice/treeData" cssClass="" allowClear="true" /></li>
			<li><label>收费状态：</label> 
				<sys:treeselect id="isPay"
					name="isPay" value="${sicmedPatientPrice.isPay}" labelName="payType"
					labelValue="${sicmedPatientPrice.payType}" title="父级编号"
					url="/web/user/sicmedPatientPrice/selectIsPay"
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
	</form:form> --%>
	<sys:message content="${message}"/>
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th style="color:red;font-size:20px">检验</th>
			</tr>
			<tr>
				<th>患者名称</th>
				<th>收费分类</th>
				<th>收费名称详情</th>
				<th>收费项目价格</th>
				<th>收费状态</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${checkList}" var="sicmedPatientPrice">
			<tr>
				<td>
					${sicmedPatientPrice.sicmedPatient.patientName}
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
			</tr>
		</c:forEach>
		</tbody>
		<!-- ${not empty sicmedCity.id?'修改':'添加'} -->
		<thead>
			<tr>
				<th style="color:red;font-size:20px">检查</th>
			</tr>
			<tr>
				<th>患者名称</th>
				<th>收费分类</th>
				<th>收费名称详情</th>
				<th>收费项目价格</th>
				<th>收费状态</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${inspectList}" var="sicmedPatientPrice">
			<tr>
				<td>
					${sicmedPatientPrice.sicmedPatient.patientName}
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
			</tr>
		</c:forEach>
		</tbody>
		
		<thead>
			<tr>
				<th style="color:red;font-size:20px">治疗</th>
			</tr>
			<tr>
				<th>患者名称</th>
				<th>收费分类</th>
				<th>收费名称详情</th>
				<th>收费项目价格</th>
				<th>收费状态</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${cureList}" var="sicmedPatientPrice">
			<tr>
				<td>
					${sicmedPatientPrice.sicmedPatient.patientName}
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
			</tr>
		</c:forEach>
		</tbody>
		
		<thead>
			<tr>
				<th style="color:red;font-size:20px">药品</th>
			</tr>
			<tr>
				<th>患者名称</th>
				<th>收费分类</th>
				<th>收费名称详情</th>
				<th>收费项目价格</th>
				<th>收费状态</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${medicalList}" var="sicmedPatientPrice">
			<tr>
				<td>
					${sicmedPatientPrice.sicmedPatient.patientName}
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
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class = "pull-right" style = "margin-right: 125px">
		<button id="payBut" type="button" class="btn btn-primary" style = "width: 75px;height: 35px;font-size: 17px">${buttonValue}</button>
	</div>
	<div class="pagination">${pages}</div>
</body>
</html>