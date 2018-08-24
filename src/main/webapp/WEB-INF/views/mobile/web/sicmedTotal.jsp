<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page import="com.thinkgem.jeesite.modules.cfq.mobile.rest.entity.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.thinkgem.jeesite.common.persistence.*"%>
<html>
<head>
<meta charset="utf-8">
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="/jeesite/static/bootstrap3/js/testsendor/jquery.min.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"></script>
<title>查询列表</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(function() {

	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
	<%	
		Double allPrice = 0.00;
		Page<SicmedRegistered> tempPage = (Page<SicmedRegistered>) request.getAttribute("page");
		List<SicmedRegistered> patientLiswt = (List<SicmedRegistered>)tempPage.getList();
		for (SicmedRegistered tempPrice : patientLiswt) {
			allPrice += Double.valueOf(tempPrice.getRegisteredPric());
		};
	%>
</head>
<body>
	<%-- <div
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100px; background-color: #39A0ED; text-align: center">
		<h1>查询窗口</h1>
	</div>
	<div
		style="position: absolute; top: 100px; left: 0px; width: 10%; height: 1200px; background-color: #545454">
		<div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/gridLayout"
						style="color: gray">挂号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/" style="color: gray">改号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/backList"
						style="color: gray">退号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/total" style="color: white">查询</a>
				</h2>
			</div>
		</div>
	</div> --%>
	<div class="col-xs-12 col-sm-12" id="patientDetail">
		<div class="header">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand"
							href="${ctx}/webweb/sicmedRegistered/total">查询列表</a>
					</div>
				</div>
			</nav>
		</div>
		<div>
			<form id="searchForm" action="${ctx}/webweb/sicmedRegistered/total"
				method="post">
				<input id="pageNo" name="pageNo" type="hidden"
					value="${page.pageNo}" /> <input id="pageSize" name="pageSize"
					type="hidden" value="${page.pageSize}" />
				<div>筛选条件:</div>
				<br>
				<div class="col-xs-12 col-sm-12">
					<div class="col-xs-2 col-sm-2">
						<c:choose>
							<c:when test="${sicmedRegistered.registeredStatus ==null }">
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="0"
										checked="checked" />挂号记录
								</div>
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="1" />改号记录
								</div>
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="2" />退号记录
								</div>
							</c:when>
							<c:when test="${sicmedRegistered.registeredStatus =='0' }">
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="0"
										checked="checked" />挂号记录
								</div>
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="1" />改号记录
								</div>
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="2" />退号记录
								</div>
							</c:when>
							<c:when test="${sicmedRegistered.registeredStatus =='1' }">
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="0" />挂号记录
								</div>
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="1"
										checked="checked" />改号记录
								</div>
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="2" />退号记录
								</div>
							</c:when>
							<c:when test="${sicmedRegistered.registeredStatus =='2' }">
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="0"
										 />挂号记录
								</div>
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="1" />改号记录
								</div>
								<div class="col-xs-12 col-sm-12">
									<input type="radio" name="registeredStatus" value="2" checked="checked"/>退号记录
								</div>
							</c:when>
						</c:choose>
					</div>
					<div class="col-xs-3 col-sm-3">
						<div class="col-xs-12 col-sm-12 ">
							<div class="col-xs-7">
								<label style="font-size: 15px">开始日期：</label>
							</div>
							<div class="col-xs-5">
								<input name="registeredBeginDate" type="text"
									readonly="readonly" maxlength="20" class="input-medium Wdate"
									value="<fmt:formatDate value="${sicmedRegistered.registeredBeginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
									onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
							</div>
						</div>
						<p>
						<div class="col-xs-12 col-sm-12">
							<div class="col-xs-7">
								<label style="font-size: 15px">结束日期：</label>
							</div>
							<div class="col-xs-5">
								<input name="registeredEndDate" type="text" readonly="readonly"
									maxlength="20" class="input-medium Wdate"
									value="<fmt:formatDate value="${sicmedRegistered.registeredEndDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
									onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
							</div>
						</div>
					</div>
					<div class="col-xs-3 col-sm-3"
						style="text-align: center; height: 50px; line-height: 50px;">
						<input id="searchForm" type="submit" class="btn btn-info"
							value="开始统计">
					</div>
					<div class="col-xs-3 col-sm-3">
						<div class="col-xs-3 col-sm-12">人数: ${page.count} 人</div>
						<div class="col-xs-3 col-sm-12">金额: <%=allPrice %> 元</div>
					</div>
				</div>

			</form>
		</div>
		<br> <br> <br> <br>
		<table id="contentTable"
			class="table table-striped table-bordered table-condensed">
			<thead>
				<tr>
					<td>患者姓名</td>
					<td>性别</td>
					<td>年龄</td>
					<td>挂号日期</td>
					<td>金额</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.list}" var="sicmedRegistered">
					<tr>
						<td>${sicmedRegistered.sicmedPatient.patientName}</td>
						<td>${sicmedRegistered.sicmedPatient.patientSex}</td>
						<td>${sicmedRegistered.sicmedPatient.patientAge}</td>
						<td><fmt:formatDate
								value="${sicmedRegistered.registeredBeginDate}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${sicmedRegistered.registeredPric}</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

		<div class="pagination">${page}</div>
	</div>
</body>
</html>