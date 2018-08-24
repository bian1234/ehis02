<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>患者医嘱保存成功管理</title>
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
		<li><a href="${ctx}/web/sicmedPatientAsked/">患者医嘱保存成功列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedPatientAsked/form?id=${sicmedPatientAsked.id}">患者医嘱保存成功<shiro:hasPermission name="rest:sicmedPatientAsked:edit">${not empty sicmedPatientAsked.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedPatientAsked:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedPatientAsked" action="${ctx}/web/sicmedPatientAsked/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">患者编号(关联患者表)：</label>
			<div class="controls">
				<form:input path="sicmedPatient.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">科室编号(对应科室表)：</label>
			<div class="controls">
				<form:input path="sicmedBranch.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">医生编号(对应用户表)：</label>
			<div class="controls">
				<form:input path="sicmedUser.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div> 
		</div>
		<div class="control-group">
			<label class="control-label">医嘱编号(对应医嘱信息表)：</label>
			<div class="controls">
				<form:input path="sicmedAsked.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品类型(对应基础编码表中的BUN)：</label>
			<div class="controls">
				<form:input path="sicmedBaseCode.id" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">附加医嘱信息：</label>
			<div class="controls">
				<form:input path="plusName" htmlEscape="false" maxlength="40" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">传送科室(对应科室表)：</label>
			<div class="controls">
				<form:input path="sicmedAskedBranch.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品编号(对应药品表)：</label>
			<div class="controls">
				<form:input path="sicmedMedical.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedPatientAsked:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>