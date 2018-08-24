<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存患者信息成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedPatient/">患者信息列表</a></li>
		<%-- <shiro:hasPermission name="rest:sicmedPatient:edit"><li><a href="${ctx}/rest/sicmedPatient/form">保存患者信息成功添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedPatient" action="${ctx}/web/sicmedPatient/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>患者信息ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li><label>患者名字：</label>
				<form:input path="patientName" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>患者编号：</label>
				<form:input path="patientNumber" htmlEscape="false" maxlength="15" class="input-medium"/>
			</li>
			<%-- <li><label>患者性别：</label>
				<form:input path="patientSex" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>患者生日：</label>
				<input name="patientBirthday" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedPatient.patientBirthday}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li> --%>
		<%-- 	<li><label>患者身份证：</label>
				<form:input path="patientCard" htmlEscape="false" maxlength="18" class="input-medium"/>
			</li> --%>
			<%-- <li><label>患者第一次就诊时间：</label>
				<input name="patientFirstdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedPatient.patientFirstdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>患者最后一次就诊时间：</label>
				<input name="patientLastdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedPatient.patientLastdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>患者住址：</label>
				<form:input path="patientAddress" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li> 
			<li><label>患者电话：</label>
				<form:input path="patientTel" htmlEscape="false" maxlength="14" class="input-medium"/>
			</li>
			<li><label>就诊科室(对应科室表)：</label>
				<form:input path="sicmedBranch.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>诊疗医生(对应用户表)：</label>
				<form:input path="sicmedDoctor.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>--%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>患者名字</th>
				<th>患者编号</th>
				<th>患者性别</th>
				<th>患者年龄</th>
				<!-- <th>患者生日</th>-->
				<th>患者身份证</th> 
				<th>患者第一次就诊时间</th>
				<!-- <th>患者最后一次就诊时间</th> -->
				<!-- <th>患者住址</th> -->
				<!-- <th>患者电话</th> -->
				<!-- <th>就诊科室</th>
				<th>诊疗医生</th> -->
				<th>更新时间</th>
				<!-- <th>备注</th> -->
				<%-- <shiro:hasPermission name="rest:sicmedPatient:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedPatient">
			<tr>
				<td>
					${sicmedPatient.patientName}
				</td>
				<td>
					${sicmedPatient.patientNumber}
				</td>
				<td>
					${sicmedPatient.ptSex}
				</td>
				<td>
					${sicmedPatient.patientAge}
				</td>
				<%-- <td>
					<fmt:formatDate value="${sicmedPatient.patientBirthday}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>--%>
				<td>
					${sicmedPatient.patientCard}
				</td> 
				<td>
					<fmt:formatDate value="${sicmedPatient.patientFirstdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <td>
					<fmt:formatDate value="${sicmedPatient.patientLastdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedPatient.patientAddress}
				</td> --%>
				<%-- <td>
					${sicmedPatient.patientTel}
				</td> --%>
				<%-- <td>
					${sicmedPatient.sicmedBranch.branchName}
				</td>
				<td>
					${sicmedPatient.sicmedDoctor.userName}
				</td> --%>
				<td>
					<fmt:formatDate value="${sicmedPatient.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <td>
					${sicmedPatient.remarks}
				</td> --%>
				<%-- <shiro:hasPermission name="rest:sicmedPatient:edit"><td>
    				<a href="${ctx}/web/sicmedPatient/form?id=${sicmedPatient.id}">修改</a>
					<a href="${ctx}/web/sicmedPatient/delete?id=${sicmedPatient.id}" onclick="return confirmx('确认要删除该保存患者信息成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>