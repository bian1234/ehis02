<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>单表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				
				rules:{
					inspectName:{
						isSuperChi:true
					},
					inspectCode:{
						isNumberAndEng:true
					}
				},
				messages:{
					inspectName:{
						isSuperChi:"检查名称格式不正确 ex:血液检查5项"
					},
					inspectCode:{
						isNumberAndEng:"检查编号格式不正确 ex:00000001或者XY000001"
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
		<li><a href="${ctx}/web/sicmedInspectClass/">单表列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedInspectClass/form?id=${sicmedInspectClass.id}">单表<shiro:hasPermission name="rest:sicmedInspectClass:edit">${not empty sicmedInspectClass.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedInspectClass:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedInspectClass" action="${ctx}/web/sicmedInspectClass/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">检验分类：</label>
			<div class="controls">
				<form:input path="inspectName" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<font color="red">*</font>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">检验类别编号：</label>
			<div class="controls">
				<form:input path="inspectCode" htmlEscape="false" maxlength="8" class="input-xlarge required"/>
				<font color="red">*</font>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedInspectClass:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>