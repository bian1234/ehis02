<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/web/sicmedStandardprescriptionBranch/">保存成功列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedStandardprescriptionBranch/form?id=${sicmedStandardprescriptionBranch.id}">保存成功<shiro:hasPermission name="rest:sicmedStandardprescriptionBranch:edit">${not empty sicmedStandardprescriptionBranch.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedStandardprescriptionBranch:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedStandardprescriptionBranch" action="${ctx}/web/sicmedStandardprescriptionBranch/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">科室编号(对应科室表)：</label>
			<div class="controls">
				<form:input path="sicmedBranch.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处方名称：</label>
			<div class="controls">
				<form:input path="prescriptionName" htmlEscape="false" maxlength="40" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">处方名称(扩展)：</label>
			<div class="controls">
				<form:input path="prescriptionNameEx" htmlEscape="false" maxlength="40" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标准处方中医嘱编号(对应标准处方中医嘱表)：</label>
			<div class="controls">
				<form:input path="standerprescriptionAsked.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标准处方中的疾病编码(对应标准处方中的疾病表)：</label>
			<div class="controls">
				<form:input path="standerprescriptionDisease.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedStandardprescriptionBranch:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>