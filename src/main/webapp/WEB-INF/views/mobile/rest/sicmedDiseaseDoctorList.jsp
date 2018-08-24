<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存成功管理</title>
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
		<li class="active"><a href="${ctx}/rest/sicmedDiseaseDoctor/">保存成功列表</a></li>
		<shiro:hasPermission name="rest:sicmedDiseaseDoctor:edit"><li><a href="${ctx}/rest/sicmedDiseaseDoctor/form">保存成功添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedDiseaseDoctor" action="${ctx}/rest/sicmedDiseaseDoctor/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>医生常用疾病表ID：</label>
				<form:input path="id" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>医生编号(对应医生表)：</label>
				<form:input path="doctorCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>疾病类别编码(对应疾病类别表)：</label>
				<form:input path="diseaseClassCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>疾病编码(对应疾病表)：</label>
				<form:input path="diseaseCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>创建人：</label>
				<form:input path="createBy.id" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>创建时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedDiseaseDoctor.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>修改人：</label>
				<form:input path="updateBy.id" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>更新时间：</label>
				<input name="updateDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedDiseaseDoctor.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>备注：</label>
				<form:input path="remarks" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>医生常用疾病表ID</th>
				<th>医生编号(对应医生表)</th>
				<th>疾病类别编码(对应疾病类别表)</th>
				<th>疾病编码(对应疾病表)</th>
				<th>创建人</th>
				<th>创建时间</th>
				<th>修改人</th>
				<th>更新时间</th>
				<th>备注</th>
				<shiro:hasPermission name="rest:sicmedDiseaseDoctor:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedDiseaseDoctor">
			<tr>
				<td><a href="${ctx}/rest/sicmedDiseaseDoctor/form?id=${sicmedDiseaseDoctor.id}">
					${sicmedDiseaseDoctor.id}
				</a></td>
				<td>
					${sicmedDiseaseDoctor.doctorCode}
				</td>
				<td>
					${sicmedDiseaseDoctor.diseaseClassCode}
				</td>
				<td>
					${sicmedDiseaseDoctor.diseaseCode}
				</td>
				<td>
					${sicmedDiseaseDoctor.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedDiseaseDoctor.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedDiseaseDoctor.updateBy.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedDiseaseDoctor.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedDiseaseDoctor.remarks}
				</td>
				<shiro:hasPermission name="rest:sicmedDiseaseDoctor:edit"><td>
    				<a href="${ctx}/rest/sicmedDiseaseDoctor/form?id=${sicmedDiseaseDoctor.id}">修改</a>
					<a href="${ctx}/rest/sicmedDiseaseDoctor/delete?id=${sicmedDiseaseDoctor.id}" onclick="return confirmx('确认要删除该保存成功吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>