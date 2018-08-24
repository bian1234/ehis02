<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>挂号统计</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				$(this).attr("disabled",true);
				top.$.jBox.confirm("确认要导出挂号数据吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/web/sicmedStatistics/registered");
						$("#searchForm").submit();
						$("#searchForm").attr("action","${ctx}/web/sicmedStatistics/");
					}
				},{buttonsFocus:1});
				top.$('.jbox-body .jbox-icon').css('top','55px');
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
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/web/sicmedStatistics/">挂号统计</a></li>
<%-- 		<shiro:hasPermission name="rest:sicmedRegistered:edit"><li><a href="${ctx}/web/sicmedRegistered/form">保存挂号信息成功添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedRegistered" action="${ctx}/web/sicmedStatistics/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
		<%-- 	<li><label>挂号基本信息表ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/> 
			</li> --%>
			<li><label>患者名称：</label>
				<form:input path="sicmedPatient.patientName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>患者编号：</label>
				<form:input path="sicmedPatient.patientNumber" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>科室名称：</label>
				<form:input path="sicmedBranch.branchName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			
			<%-- <li><label>医保类型(对应基础编码标准中的BUN(BI)_code)：</label>
				<form:input path="sicmedBaseCode.id" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li> --%>
			<%-- <li><label>挂号费用：</label>
				<form:input path="registeredPric" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li> --%>
			<%-- <li><label>缴费状态：</label>
				<form:input path="pricStatus" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li> --%>
			<%-- <li><label>缴费状态：</label> <sys:treeselect id="statusType"
					name="pricStatus" value="${sicmedRegistered.pricStatus}" labelName="statusType"
					labelValue="${sicmedRegistered.statusType}" title="父级编号"
					url="/web/sicmedRegistered/statusType" 
					cssClass="input-small" notAllowSelectParent="true" allowClear="true"/></li> --%>
			<li><label>挂号类型：</label>
				<form:input path="sicmedRegistrationType.nameChina" htmlEscape="false" maxlength="6" class="input-medium"/>
			</li>
			<li><label>医生：</label>
				<form:input path="sicmedDoctor.userName" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>挂号时间：</label>
				<input name="registeredBeginDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedRegistered.registeredBeginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li><label>截止时间：</label>
				<input name="registeredEndDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedRegistered.registeredEndDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:true});"/>
			</li>
			<li><label style="color:red" >查询到${page.count}条</label></li>
			<li class="btns"><input id="searchForm" class="btn btn-primary" type="submit" value="查询"/>
			<input id="btnExport" class="btn btn-primary" type="button" value="导出"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<!-- <th>挂号基本信息表ID</th> -->
				<th>患者名字</th>
				<th>患者编号</th>
				<th>科室名称</th>
		<!-- 		<th>医保类型(对应基础编码标准中的BUN(BI)_code)</th> 
				<th>挂号费用</th> -->
				<!-- <th>缴费状态</th> -->
				<th>挂号类型</th>
				<th>医生</th>
				<th>挂号时间</th>
			<!--	<th>挂号结束时间</th>
			 	<th>更新时间</th> -->
				<th>备注</th>
				<%-- <shiro:hasPermission name="rest:sicmedRegistered:edit"><th>操作</th></shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedRegistered">
			<tr>
				<%-- <td><a href="${ctx}/web/sicmedRegistered/form?id=${sicmedRegistered.id}">
					${sicmedRegistered.id}
				</a></td> --%>
				<td>
					${sicmedRegistered.sicmedPatient.patientName}
				</td>
				<td>
					${sicmedRegistered.sicmedPatient.patientNumber}
				</td>
				<td>
					${sicmedRegistered.sicmedBranch.branchName}
				</td>
				<%-- <td>
					${sicmedRegistered.sicmedBaseCode.id}
				</td> 
				<td>
					${sicmedRegistered.registeredPric}
				</td>--%>
				<%-- <td>
					${sicmedRegistered.statusType}
				</td> --%>
				<td>
				${sicmedRegistered.sicmedRegistrationType.nameChina }
				</td>
				<td>
					${sicmedRegistered.sicmedDoctor.userName}
				</td>
				<td>
					<fmt:formatDate value="${sicmedRegistered.registeredBeginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<%-- <td>
					<fmt:formatDate value="${sicmedRegistered.registeredEndDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${sicmedRegistered.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					${sicmedRegistered.remarks}
				</td>
				<%-- <shiro:hasPermission name="rest:sicmedRegistered:edit"><td>
    				<a href="${ctx}/web/sicmedRegistered/form?id=${sicmedRegistered.id}">修改</a>
					<a href="${ctx}/web/sicmedRegistered/delete?id=${sicmedRegistered.id}" onclick="return confirmx('确认要删除该保存挂号信息成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>