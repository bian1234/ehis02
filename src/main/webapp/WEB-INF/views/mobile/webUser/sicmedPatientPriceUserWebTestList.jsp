<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page import="com.thinkgem.jeesite.modules.cfq.mobile.rest.entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.thinkgem.jeesite.common.persistence.*"%>
<html>
<head> 	
 	<title>患者列表</title>	
 	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<meta name="decorator" content="default" />
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
	<%	
		Double allPrice = 0.00;
		Page<SicmedPatientPrice> tempPage = (Page<SicmedPatientPrice>) request.getAttribute("page");
		List<SicmedPatientPrice> patientLiswt = (List<SicmedPatientPrice>)tempPage.getList();
		for (SicmedPatientPrice tempPatientPrice : patientLiswt) {
			allPrice += Double.valueOf(tempPatientPrice.getPrice());
		};
	%>
</head>
<body> 
	<div id="patientDetail" class="row">
		<div class="col-xs-12 col-sm-12">
			<ul class="nav nav-tabs" style="margin-top: 8pt"><li>
				<li class="active"><a href="#">收费列表</a></li>			
			</ul>
		</div>
		<div class="col-xs-12 col-sm-12">
			<span style="color: bule;font-size:20px">筛选条件</span>
		</div>
		<div class="col-xs-12 col-sm-12" style="padding-top: 10px">
			<form id="searchForm" action="${ctx}/web/user/sicmedPatientPrice/patientPriceTestList" method="post" class="breadcrumb form-search">
				<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
				<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		
			<div class="col-xs-2 col-sm-2">
				<div class="col-xs-12 col-sm-12" onClick="payNotes(this)">
					<input id="payNotes" name="isPay" type="radio" checked="checked" value="1" onchange="payNotes(this)"/>
						<label style="font-size: 20px;padding-left: 5px">
							收费记录
						</label>
				</div>
				<div class="col-xs-12 col-sm-12" style="margin-top: 15px" onClick="refundNotes(this)">
					<input id="refundNotes" name="isPay" type="radio" value="2" onchange="refundNotes(this)"/>
						<label style="font-size: 20px;padding-left: 5px">
							退费记录
						</label>
				</div>
			</div>
			<div class="col-xs-4 col-sm-4">
				<div class="col-xs-12 col-sm-12">
					<label style="font-size: 20px">
						开始时间
					</label>
					<input name="startDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
				value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
				</div>
				<div class="col-xs-12 col-sm-12" style="margin-top: 15px">
					<label style="font-size: 20px">
						截止时间
					</label>
					<input name="endDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
						value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
				</div>
			</div>
			<div class="col-xs-2 col-sm-2">
				<input id="searchForm" class="btn btn-primary" type="submit" value="统计按钮" style="height:80px"/>
			</div>
			<div class="col-xs-4 col-sm-4">
				<div class="col-xs-12 col-sm-12">
					<label style="font-size: 20px">
						人数:${page.count}
					</label>
				</div>
				<div class="col-xs-12 col-sm-12" style="margin-top: 15px">
					<label style="font-size: 20px">
						金额:<%=allPrice %>
					</label>
				</div>
			</div>
			</form>
			<div class="col-xs-12 col-sm-12">
				<table id="contentTable" class="table table-hover">
					<thead>
						<tr>
							<th>姓名</th>
							<th>编号</th>
							<th>身份证号</th>
							<th>项目价格</th>
							<th>收费人员</th>
							<th>创建时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list}" var="sicmedPatientPrice">
							<tr>
								<td>${sicmedPatientPrice.sicmedPatient.patientName}</td>
								<td>${sicmedPatientPrice.sicmedPatient.patientNumber}</td>
								<td>${sicmedPatientPrice.sicmedPatient.patientCard}</td>
								<td>${sicmedPatientPrice.price}</td>
								<td>${sicmedPatientPrice.createUser.userName}</td>
								<td><fmt:formatDate
										value="${sicmedPatientPrice.createDate}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="col-xs-12 col-sm-12">
				<div class="pagination">${page}</div>			
			</div>
		</div>
	</div>
	<script src="/jeesite/static/bootstrap3/js/tests/vendor/jquery.min.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"></script>
	<script src="/jeesite/static/sicmedEEC/patientPriceDetail.js" type="text/javascript"></script>
	
	<%-- <div id="patientDetail">
		<ul class="nav nav-tabs" style="margin-top: 8pt"><li>
			<c:choose>
				<c:when test="${isPay=='1'}">
					<li class="active"><a href="#">收费列表</a></li>
				</c:when>
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
				<shiro:hasPermission name="rest:sicmedPatientPrice:edit"><td>
    				<a href="${ctx}/web/sicmedPatientPrice/form?id=${sicmedPatientPrice.id}">修改</a>
					<a href="${ctx}/web/sicmedPatientPrice/delete?id=${sicmedPatientPrice.id}" onclick="return confirmx('确认要删除该患者价格明细表保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
		</table> --%>
	<%-- 	<div class="pagination">${page}</div>
	</div> --%>
</body>
</html>