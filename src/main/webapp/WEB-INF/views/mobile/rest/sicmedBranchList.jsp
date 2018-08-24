<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存科室成功管理</title>
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
		<li class="active"><a href="${ctx}/web/sicmedBranch/">科室列表</a></li>
		<shiro:hasPermission name="rest:sicmedBranch:edit"><li><a href="${ctx}/web/sicmedBranch/form">科室添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedBranch" action="${ctx}/web/sicmedBranch/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<%-- <li><label>科室主键：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li> --%>
			<li><label>科室名称：</label>
				<form:input path="branchName" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>科室编码：</label>
				<form:input path="branchCode" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<%-- <li><label>科室排序：</label>
				<form:input path="branchNumber" htmlEscape="false" maxlength="3" class="input-medium"/>
			</li> --%>
			<%--<li><label>科室英文名称：</label>
				<form:input path="branchNameEnglish" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			 <li><label>科室所在物理位置：</label>
				<form:input path="branchLocation" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li> --%>
			<%-- <li><label>是否可挂号(0/1)：</label>
				<form:input path="branchRegistered" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li> --%>
			<li><label>是否可挂号：</label> 
			<%-- <sys:treeselect id="registeredType"
					name="branchRegistered" value="${branchRegistered}" labelName="registeredType"
					labelValue="${sicmedBranch.registeredType}" title="父级编号"
					url="/web/sicmedBranch/registeredType" 
					cssClass="input-small" notAllowSelectParent="true" allowClear="true"/> --%>
				<select class="input-medium required" name="branchRegistered">
				 	<%-- <option value="0">不可挂号</option>
				 	<option value="1">可挂号</option>
				 	<option selected="selected" value="${sicmedBranch.branchRegistered}">${sicmedBranch.registeredType}</option> --%>
				 	<c:choose>
				 		<c:when test="${sicmedBranch.branchRegistered == 0}">
							<option value="3">全部</option>
							<option value="1">可挂号</option>
							<option value="2">不可挂号</option>
							<%-- <option selected="selected" value="${sicmedBranch.branchRegistered}">${sicmedBranch.registeredType}</option>	 --%>
       					</c:when>
       					<c:when test="${sicmedBranch.branchRegistered == 1}">
							<option value="3">全部</option>
							<option value="1">可挂号</option>
							<option value="0">不可挂号</option>
       					</c:when>
       					<c:otherwise>
       						<option value="3">全部</option>
       						<option value="1">可挂号</option>
       						<option value="0">不可挂号</option>
       					</c:otherwise>
       				</c:choose>
				 </select>
					</li>
			<%-- <li><label>是否为住院科室：</label>
				<form:input path="branchIpd" htmlEscape="false" maxlength="1" class="input-medium"/>
			</li> --%>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
		<!-- 		<th>科室主键</th> -->
				<th>科室编码</th>
				<th>科室名称</th>
				<th>科室排序</th>
				<th>科室英文名称</th>
				<th>科室所在物理位置</th>
				<th>是否可挂号</th>
				<!-- <th>上午挂号人数</th>
				<th>下午挂号人数</th> 
				<th>更新时间</th>-->
				<th>是否为住院科室</th>
				
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedBranch:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedBranch">
			<tr>
				<td><a href="${ctx}/web/sicmedBranch/form?id=${sicmedBranch.id}">
					${sicmedBranch.branchName}
				</a></td>
				<%-- <td>
					${sicmedBranch.branchName}
				</td> --%>
				<td>
					${sicmedBranch.branchCode}
				</td>
				<td>
					${sicmedBranch.branchNumber}
				</td>
				<%-- <td>
					${sicmedBranch.branchName}
				</td> --%>
				<td>
					${sicmedBranch.branchNameEnglish}
				</td>
				<td>
					${sicmedBranch.branchLocation}
				</td>
				<td>
					${sicmedBranch.registeredType}
				</td>
				<%-- <td>
					${sicmedBranch.branchRegisteredAm}
				</td>
				<td>
					${sicmedBranch.branchRegisteredPm}
				</td>
				<td>
					<fmt:formatDate value="${sicmedBranch.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> --%>
				<td>
					${sicmedBranch.ipdType}
				</td>
				
				<td>
					${sicmedBranch.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedBranch:edit"><td>
    				<a href="${ctx}/web/sicmedBranch/form?id=${sicmedBranch.id}">修改</a>
					<a href="${ctx}/web/sicmedBranch/delete?id=${sicmedBranch.id}" onclick="return confirmx('确认要删除该保存科室成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>