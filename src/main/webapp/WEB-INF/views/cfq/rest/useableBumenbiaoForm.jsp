<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>部门表管理</title>
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
		<li><a href="${ctx}/rest/useableBumenbiao/">部门表列表</a></li>
		<li class="active"><a href="${ctx}/rest/useableBumenbiao/form?id=${useableBumenbiao.id}">部门表<shiro:hasPermission name="rest:useableBumenbiao:edit">${not empty useableBumenbiao.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:useableBumenbiao:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="useableBumenbiao" action="${ctx}/rest/useableBumenbiao/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">fuleiid：</label>
			<div class="controls">
				<form:input path="fuleiid" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">biaoma：</label>
			<div class="controls">
				<form:input path="biaoma" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">mingzi：</label>
			<div class="controls">
				<form:input path="mingzi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jiancheng：</label>
			<div class="controls">
				<form:input path="jiancheng" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">adress：</label>
			<div class="controls">
				<form:input path="adress" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">moji：</label>
			<div class="controls">
				<form:input path="moji" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jiandangshijian：</label>
			<div class="controls">
				<form:input path="jiandangshijian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">chedanshijian：</label>
			<div class="controls">
				<form:input path="chedanshijian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">huanjingleixing：</label>
			<div class="controls">
				<form:input path="huanjingleixing" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">bumenfuzeren：</label>
			<div class="controls">
				<form:input path="bumenfuzeren" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhandian：</label>
			<div class="controls">
				<form:input path="zhandian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:useableBumenbiao:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>