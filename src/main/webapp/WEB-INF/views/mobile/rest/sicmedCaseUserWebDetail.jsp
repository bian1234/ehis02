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
		<li><a href="${ctx}/web/ask/sicmedPatient/">患者列表</a></li>
		<li class = "active"><a href="${ctx}/web/user/sicmedCase/caseDetail/">医嘱</a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedCase" action="${ctx}/web/user/sicmedCase/caseDetail" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">患者名称：</label>
			<div class="controls">
				<form:input path="sicmedPatient.patientName" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group ">
			<label class="control-label">主述：</label>
			<div class="controls col-sm-8 col-lg-8">
				<form:textarea path="caseTell" htmlEscape="false" rows="4" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">病史：</label>
			<div class="controls">
				<form:textarea path="caseHistory" htmlEscape="false" rows="4" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">过敏史：</label>
			<div class="controls">
				<form:textarea path="caseAllergy" htmlEscape="false" rows="4" maxlength="200" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">诊断：</label>
			<div class="controls">
					<sys:treeselect id="caseDiagnosis" 
					name="diagnosisDiseaseInitial.id" value="${sicmedCase.diagnosisDiseaseInitial.id}" labelName="diagnosisDiseaseInitial.diseaseNamee" labelValue="${sicmedCase.diagnosisDiseaseInitial.diseaseName}"
					title="搜索疾病" url="/web/user/sicmedCase/treeData" cssClass="" allowClear="true"/>			</div>
			</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedCase:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>