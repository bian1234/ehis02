<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>收费价目管理</title>
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
		<li><a href="${ctx}/rest/useableShoufeijiamu/">收费价目列表</a></li>
		<li class="active"><a href="${ctx}/rest/useableShoufeijiamu/form?id=${useableShoufeijiamu.id}">收费价目<shiro:hasPermission name="rest:useableShoufeijiamu:edit">${not empty useableShoufeijiamu.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:useableShoufeijiamu:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="useableShoufeijiamu" action="${ctx}/rest/useableShoufeijiamu/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">yuanjia_id：</label>
			<div class="controls">
				<form:input path="yuanjiaId" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">shoufeixiangmu_id：</label>
			<div class="controls">
				<form:input path="shoufeixiangmuId" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">yuanjia：</label>
			<div class="controls">
				<form:input path="yuanjia" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">xianjia：</label>
			<div class="controls">
				<form:input path="xianjia" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">qushengjiage：</label>
			<div class="controls">
				<form:input path="qushengjiage" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">shouruxiangmu_id：</label>
			<div class="controls">
				<form:input path="shouruxiangmuId" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jiabanjiajialv：</label>
			<div class="controls">
				<form:input path="jiabanjiajialv" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">fushushoufeilv：</label>
			<div class="controls">
				<form:input path="fushushoufeilv" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">biandongyuanyin：</label>
			<div class="controls">
				<form:input path="biandongyuanyin" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">tiaojiaoshuoming：</label>
			<div class="controls">
				<form:input path="tiaojiaoshuoming" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">tiaojia_id：</label>
			<div class="controls">
				<form:input path="tiaojiaId" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">tiaojiaoren：</label>
			<div class="controls">
				<form:input path="tiaojiaoren" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhixingriqi：</label>
			<div class="controls">
				<form:input path="zhixingriqi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhongzhiriqi：</label>
			<div class="controls">
				<form:input path="zhongzhiriqi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">no：</label>
			<div class="controls">
				<form:input path="no" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">xuhao：</label>
			<div class="controls">
				<form:input path="xuhao" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">tiaojiahuizonghao：</label>
			<div class="controls">
				<form:input path="tiaojiahuizonghao" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:useableShoufeijiamu:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>