<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>疾病类别管理</title>
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
		<li><a href="${ctx}/rest/useableDiseaseClass/">疾病类别列表</a></li>
		<li class="active"><a href="${ctx}/rest/useableDiseaseClass/form?id=${useableDiseaseClass.id}">疾病类别<shiro:hasPermission name="rest:useableDiseaseClass:edit">${not empty useableDiseaseClass.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:useableDiseaseClass:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="useableDiseaseClass" action="${ctx}/rest/useableDiseaseClass/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">parent_id：</label>
			<div class="controls">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">disease_class_code：</label>
			<div class="controls">
				<form:input path="diseaseClassCode" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">disease_class_name：</label>
			<div class="controls">
				<form:input path="diseaseClassName" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">disease_class_papm：</label>
			<div class="controls">
				<form:input path="diseaseClassPapm" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">leibie：</label>
			<div class="controls">
				<form:input path="leibie" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:useableDiseaseClass:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>