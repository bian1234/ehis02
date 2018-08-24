<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医嘱统计</title>
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
		<li class="active"><a href="${ctx}/webweb/sicmedCase/">医嘱统计</a></li>
		<%-- <shiro:hasPermission name="rest:sicmedCase:edit"><li><a href="${ctx}/rest/sicmedCase/form">医嘱统计</a></li></shiro:hasPermission> --%>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedCase" action="${ctx}/webweb/sicmedCase/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>病历表ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>患者编号(管理患者表)：</label>
				<form:input path="sicmedPatient.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>主述：</label>
				<form:input path="caseTell" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>病史：</label>
				<form:input path="caseHistory" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>过敏史：</label>
				<form:input path="caseAllergy" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>诊断：</label>
				<form:input path="caseDiagnosis" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>医嘱编号(管理医嘱表)：</label>
				<form:input path="sicmedAsked.id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>创建人：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="beginCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedCase.beginCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endCreateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedCase.endCreateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>修改人：</label>
				<form:input path="updateBy.id" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="beginUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedCase.beginUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedCase.endUpdateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>删除标记：</label>
				<form:radiobuttons path="delFlag" items="${fns:getDictList('del_flag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>患者编号(管理患者表)</th>
				<th>主述</th>
				<th>病史</th>
				<th>过敏史</th>
				<th>诊断</th>
				<th>医嘱编号(管理医嘱表)</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedCase:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedCase">
			<tr>
				<td><a href="${ctx}/webweb/sicmedCase/form?id=${sicmedCase.id}">
					${sicmedCase.sicmedPatient.id}
				</a></td>
				<td>
					${sicmedCase.caseTell}
				</td>
				<td>
					${sicmedCase.caseHistory}
				</td>
				<td>
					${sicmedCase.caseAllergy}
				</td>
				<td>
					${sicmedCase.caseDiagnosis}
				</td>
				<td>
					${sicmedCase.sicmedAsked.id}
				</td>
				<td>
					${sicmedCase.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedCase.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedCase.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedCase.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedCase.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedCase:edit"><td>
    				<a href="${ctx}/webweb/sicmedCase/form?id=${sicmedCase.id}">修改</a>
					<a href="${ctx}/webweb/sicmedCase/delete?id=${sicmedCase.id}" onclick="return confirmx('确认要删除该保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>