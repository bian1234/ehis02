<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				$(this).attr("disabled",true); 
				top.$.jBox.confirm("确认要导出缴费信息吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/web/sicmedInviteNumber/inviteNumber");
						$("#searchForm").submit();
						$("#searchForm").attr("action","${ctx}/web/sicmedInviteNumber/");
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
	<ul class="nav nav-tabs">
		<li class="active"><a href="">验证码管理</a></li>
		<%-- <shiro:hasPermission name="rest:sicmedInviteNumber:edit"><li><a href="${ctx}/rest/sicmedInviteNumber/form">保存成功添加</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedInviteNumber" action="${ctx}/web/sicmedInviteNumber/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>账号激活码表ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> 
			<li><label>激活码：</label>
				<form:input path="inviteNumber" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>--%>
			<li><label>用户名：</label>
				<form:input path="sicmedUser.userName" htmlEscape="false" maxlength="6" class="input-medium"/>
			</li>
			<li><label>手机号：</label>
				<form:input path="sicmedUser.userTel" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<%-- <li><label>激活状态(0/1)：</label>
				<form:input path="inviteStatus" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li> --%>
			<li><label>激活状态：</label> 
				<%-- <sys:treeselect id="statusType"
					name="inviteStatus" value="${sicmedInviteNumber.inviteStatus}" labelName="statusType"
					labelValue="${sicmedInviteNumber.statusType}" title="父级编号"
					url="/web/sicmedInviteNumber/statusType" 
					cssClass="input-small" notAllowSelectParent="true" allowClear="true"/> --%>
						
				<select class="input-medium required" name="inviteStatus">
					<c:choose>
						<c:when test="${sicmedInviteNumber.inviteStatus==0}">
							<option value = "999">全部</option>
							<option value = "1">是</option>
							<option selected="selected" value = "0">否</option>
						</c:when>
						<c:when test="${sicmedInviteNumber.inviteStatus==1}">
							<option value = "999">全部</option>
							<option selected="selected" value = "1">是</option>
							<option value = "0">否</option>
						</c:when>
						<c:otherwise>
							<option selected="selected" value = "999">全部</option>
							<option value = "1">是</option>
							<option value = "0">否</option>
						</c:otherwise>
					</c:choose>
				</select>
			</li>
			<%-- <li><label>创建人：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedInviteNumber.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>修改人：</label>
				<form:input path="updateBy.id" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>备注：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>删除标记：</label>
				<form:radiobuttons path="delFlag" items="${fns:getDictList('del_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li> --%>
			<li class="btns">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			<input id="btnExport" class="btn btn-primary" type="button" value="导出" /></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<!-- <th>账号激活码表ID</th> -->
				<th>用户名</th>
				<th>手机号</th>
				<th>激活码</th>
				<th>是否激活</th>
				<!-- <th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>更新时间</th>
				<th>备注</th>
				<th>删除标记</th> -->
				<shiro:hasPermission name="rest:sicmedInviteNumber:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedInviteNumber">
			<tr>
				<%-- <td><a href="${ctx}/web/sicmedInviteNumber/form?id=${sicmedInviteNumber.id}">
					${sicmedInviteNumber.sicmedUser.userName}
				</a></td> --%>
				<%-- <td>
					${sicmedInviteNumber.id}
				</td> --%>
				<td>
					${sicmedInviteNumber.sicmedUser.userName}
				</td>
				<td>
					${sicmedInviteNumber.sicmedUser.userTel}
				</td>
				<td>
					${sicmedInviteNumber.inviteNumber}
				</td>
				<td>
					${sicmedInviteNumber.statusType}
				</td>
				<%-- <td>
					${sicmedInviteNumber.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedInviteNumber.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedInviteNumber.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedInviteNumber.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedInviteNumber.remarks}
				</td>
				<td>
					${fns:getDictLabel(sicmedInviteNumber.delFlag, 'del_flag', '')}
				</td> --%>
				<%-- <shiro:hasPermission name="rest:sicmedInviteNumber:edit"><td>
    				<a href="${ctx}/rest/sicmedInviteNumber/form?id=${sicmedInviteNumber.id}">修改</a>
					<a href="${ctx}/rest/sicmedInviteNumber/delete?id=${sicmedInviteNumber.id}" onclick="return confirmx('确认要删除该保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>