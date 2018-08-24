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
				rules:{
					diseaseClassName:{
						isEngAndChi:true
					},
					diseaseClassCode:{
						isNumberAndEng:true
					}
				},
				
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
		<li><a href="${ctx}/web/sicmedDiseaseClass/">疾病类别列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedDiseaseClass/form?id=${sicmedDiseaseClass.id}">疾病类别<shiro:hasPermission name="rest:sicmedDiseaseClass:edit">${not empty sicmedDiseaseClass.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedDiseaseClass:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedDiseaseClass" action="${ctx}/web/sicmedDiseaseClass/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">疾病类别名称：</label>
			<div class="controls">
				<form:input path="diseaseClassName" htmlEscape="false" maxlength="20" class="input-xlarge required"/>
				<font color="red">*</font> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">疾病类别编号：</label>
			<div class="controls">
				<form:input path="diseaseClassCode" htmlEscape="false" maxlength="8" class="input-xlarge required"/>
				<font color="red">*</font> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedDiseaseClass:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>