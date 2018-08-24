<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医生添加</title>
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
		<li class="active"><a href="${ctx}/web/sicmedUser/">医生列表</a></li>
		<shiro:hasPermission name="rest:sicmedUser:edit"><li><a href="${ctx}/web/sicmedUser/form">医生添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedUser" action="${ctx}/web/sicmedUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>用户编码：</label>
				<form:input path="userNumber" htmlEscape="false" maxlength="6" class="input-medium"/>
			</li> --%>
			<li><label>用户名：</label>
				<form:input path="userName" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>所属科室：</label>
				<form:input path="sicmedBranch.branchName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>工作组：</label>
				<form:input path="jobGroupType" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<%-- <li><label>密码：</label>
				<form:input path="password" htmlEscape="false" maxlength="8" class="input-medium"/>
			</li> 
			<li><label>入职日期：</label>
				<input name="userFodate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedUser.userFodate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>离职时间：</label>
				<input name="userTodate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedUser.userTodate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>--%>
			<%-- <li><label>工作组：</label>
				<form:input path="userJobGroup" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li> --%>
			<%--<li><label>工作等级：</label>
				<form:input path="userJobGrade" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>所属部门：</label>
				<form:input path="sicmedDept.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>所属科室科室：</label>
				<form:input path="sicmedBranch.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			 <li><label>医生编号：</label>
				<form:input path="doctorCode" htmlEscape="false" maxlength="6" class="input-medium"/>
			</li> --%>
			<%--<li><label>医生等级：</label>
				<form:input path="doctorGrade" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>优先级：</label>
				<form:input path="printranking" htmlEscape="false" maxlength="2" class="input-medium"/>
			</li>
			 <li><label>上午挂号人数：</label>
				<form:input path="doctorRegisteredAm" htmlEscape="false" maxlength="3" class="input-medium"/>
			</li>
			<li><label>下午挂号人数：</label>
				<form:input path="doctorRegisteredPm" htmlEscape="false" maxlength="3" class="input-medium"/>
			</li>
			<li><label>是否可挂号：</label>
				<form:input path="doctorRegistered" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>挂号区分：</label>
				<form:input path="registeredDifference" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li> --%>
		<%-- 	<li><label>许可证编码：</label>
				<form:input path="license" htmlEscape="false" maxlength="15" class="input-medium"/>
			</li>
			<li><label>特需许可证编号：</label>
				<form:input path="licenseSpc" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li> --%>
			<li><label>电话：</label>
				<form:input path="userTel" htmlEscape="false" maxlength="14" class="input-medium"/>
			</li>
			 <%--<li><label>邮箱：</label>
				<form:input path="userEmail" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li> --%>
			<%-- <li><label>在职状态：</label>
				<form:input path="userStatus" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li>
			<li><label>变更开始日期：</label>
				<input name="changeFdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedUser.changeFdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>变更结束日期：</label>
				<input name="changeOdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedUser.changeOdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li> --%>
			<%-- <li><label>所属科室编码1：</label>
				<form:input path="doctorBranch1" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<li><label>所属科室编码2：</label>
				<form:input path="doctorBranch2" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<li><label>医生所属科室3：</label>
				<form:input path="doctorBranch3" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<!-- <th>基础编码ID</th> -->
				<th>用户名</th>
				<th>部门</th>
				<th>科室</th>
				<!-- <th>用户编码</th> -->
				
				
				<th>入职日期</th>
				<!-- <th>离职时间</th> -->
				<th>工作组</th>
				<!-- <th>工作等级</th> -->
			<!-- 	<th>医生编号</th> -->
				<th>医生等级</th>
				<!-- <th>优先级</th> -->
				<th>是否可挂号</th>
			<!-- 	<th>上午挂号人数</th>
				<th>下午挂号人数</th>
				<th>挂号区分</th> 
				<th>许可证编码</th>
				<th>特需许可证编号</th>-->
				<th>电话</th>
				<th>密码</th>
				<th>邮箱</th>
				<th>在职状态</th>
				<!-- <th>变更开始日期</th>
				<th>变更结束日期</th> -->
			<!-- 	<th>激活码</th>
				<th>是否激活</th> -->
				<!-- <th>更新时间</th> -->
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedUser">
			<tr>
				<td><a href="${ctx}/web/sicmedUser/form?id=${sicmedUser.id}">
					${sicmedUser.userName}
				</a></td>
				<td>
					${sicmedUser.sicmedDept.deptName}
				</td>
				<td>
					${sicmedUser.sicmedBranch.branchName}
				</td>
			<%-- 	<td>
					${sicmedUser.userNumber}
				</td> --%>
				<%-- <td>
					${sicmedUser.userName}
				</td> --%>
				
				<td>
					<fmt:formatDate value="${sicmedUser.userFodate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <td>
					<fmt:formatDate value="${sicmedUser.userTodate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					${sicmedUser.jobGroupType}
				</td>
				<%--<td>
					${sicmedUser.userJobGrade}
				</td>
			 	<td>
					${sicmedUser.doctorCode}
				</td> --%>
				<td>
					${sicmedUser.doctorGradeType}
				</td>
				<%-- <td>
					${sicmedUser.printranking}
				</td> --%>
				<td>
					${sicmedUser.registeredType}
				</td>
				<%-- <td>
					${sicmedUser.doctorRegisteredAm}
				</td>
				<td>
					${sicmedUser.doctorRegisteredPm}
				</td>
				<td>
					${sicmedUser.registeredDifference}
				</td> 
				<td>
					${sicmedUser.license}
				</td>
				<td>
					${sicmedUser.licenseSpc}
				</td>--%>
				<td>
					${sicmedUser.userTel}
				</td>
				<td>
					${sicmedUser.password}
				</td>
				<td>
					${sicmedUser.userEmail}
				</td>
				<td>
					${sicmedUser.userStatusType}
				</td>
				<%-- <td>
					<fmt:formatDate value="${sicmedUser.changeFdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${sicmedUser.changeOdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
<%-- 				<td>
					${sicmedUser.doctorBranch1}
				</td>
				<td>
					${sicmedUser.doctorBranch2}
				</td> --%>
				<%-- <td>
					${sicmedUser.doctorBranch3}
				</td> --%>
				<%-- <td>
					${sicmedUser.sicmedInviteNumber.inviteNumber}
				</td>
				<td>
					${sicmedUser.sicmedInviteNumber.inviteStatus}
				</td> --%>
				<%-- <td>
					<fmt:formatDate value="${sicmedUser.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					${sicmedUser.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedUser:edit"><td>
    				<a href="${ctx}/web/sicmedUser/form?id=${sicmedUser.id}">修改</a>
					<a href="${ctx}/web/sicmedUser/delete?id=${sicmedUser.id}" onclick="return confirmx('确认要删除该保存用户成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>