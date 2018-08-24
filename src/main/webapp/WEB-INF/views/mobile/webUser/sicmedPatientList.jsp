<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page import="com.thinkgem.jeesite.modules.cfq.mobile.rest.entity.*"%>
<%@ page import="java.util.List"%>

<html>
<head>
	<title>患者信息</title>
	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<script src="/jeesite/static/bootstrap3/js/tests/vendor/jquery.min.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"></script> 
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
	<div id="patientDetail" class="row"
		style="margin-left:5pt; margin-bottom:5pt; margin-top:-15pt">
		<div id="functionDetail" class="col-xs-12 col-sm-12">
			<div class="row">
				<div class="col-xs-12 col-sm-12" style="margin-top:20pt">
					<ul class="nav nav-tabs">
					<%-- 	<%
							int pageSize = 0; 
							List<SicmedPatient> patientList =  (List<SicmedPatient>)request.getAttribute("page");
						%> --%>
						<li class="active"><a href="#">患者列表 </a></li>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-12" style="margin-top:20pt">
				  <form:form id="searchForm" modelAttribute="sicmedPatient" action="${ctx}/web/user/sicmedPatient" method="post" class="breadcrumb form-search">
					<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
					<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
					<ul class="ul-form">
						<li style="height: 20px"><label style="width: 25pt">
							<i class="icon-search icon-white"></i>
							</label>
							<form:input path="searchContent" placeholder="请输入患者编号或名字" htmlEscape="false" style="height:25px" maxlength="15" class="input-medium"/>
						</li>
						<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
						<li class="clearfix"></li>
						</ul>
					</form:form>
					<%-- <form id="searchForm" action="${ctx}/web/user/sicmedPatient/searchPatient" method="post" class="breadcrumb form-search">
						<div class="input-group">
							<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
							<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
							<span class="input-group-addon" style="height: 25pt;width: 25pt">
								<i class="icon-search icon-white"></i>
							</span>
							<input id="searchContent" name="searchContent" type="text" class="form-control"  placeholder="请输入患者编号或名字" style="height:25pt;width:150pt" maxlength="15" class="input-medium"/>
							<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>	
						</div>
					</form> --%>
				</div>
				<div class="col-xs-12 col-sm-12" style="margin-top:10pt">
					<table id="contentTable"
						class="table table-hover">
						<thead>
							<tr>
								<th>名字</th>
								<th>编号</th>
								<th>性别</th>
								<th>身份证</th>
								<th>第一次就诊时间</th>
								<th>电话</th>
							<!-- 	<th>更新时间</th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.list}" var="sicmedPatient">
								<tr>
									<td><a
											href="${ctx}/web/user/sicmedPatientPrice/patientPriceDetail?id=${sicmedPatient.id}&isPay=0">
												${sicmedPatient.patientName} </a></td>
									<td>${sicmedPatient.patientNumber}</td>
									<td>${sicmedPatient.ptSex}</td>
									<%-- <td><fmt:formatDate
											value="${sicmedPatient.patientBirthday}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td> --%>
									<td>${sicmedPatient.patientCard}</td>
									<td><fmt:formatDate
											value="${sicmedPatient.patientFirstdate}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
									<td>${sicmedPatient.patientTel}</td>
							<%-- 		<td><fmt:formatDate value="${sicmedPatient.updateDate}"
											pattern="yyyy-MM-dd HH:mm:ss" /></td> --%>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="pagination">${page}</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/jeesite/static/sicmedEEC/patientList.js" type="text/javascript"></script>
</body>
</html>
