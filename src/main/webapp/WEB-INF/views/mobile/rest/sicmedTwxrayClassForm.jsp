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
					/* classCode:{
						isInteger:true
					}, */
					/* className:{
						isEngAndChi:true
					}, */
					pacsClass:{
						isEnglish:true
					},
					sort:{
						isInteger:true
					}
				},
				
				messages:{
					sort:{
						isInteger:"缩写格式不正确 例:1"
					},
					/* classCode:{
						isInteger:"编号类型为1-99"
					}, */
					/* className:{
						isEngAndChi:"名称类型格式不正确 例：CR普通造影"
					}, */
					pacsClass:{
						isEnglish:"学名格式不正确 例:CR"
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
		<li><a href="${ctx}/web/sicmedTwxrayClass/">单表列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedTwxrayClass/form?id=${sicmedTwxrayClass.id}">单表<shiro:hasPermission name="rest:sicmedTwxrayClass:edit">${not empty sicmedTwxrayClass.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedTwxrayClass:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedTwxrayClass" action="${ctx}/web/sicmedTwxrayClass/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">类别编号：</label>
			<div class="controls">
				<form:input path="classCode" htmlEscape="false" maxlength="2" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类别名称：</label>
			<div class="controls">
				<form:input path="className" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<font color="red">*</font> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">学名：</label>
			<div class="controls">
				<form:input path="pacsClass" htmlEscape="false" maxlength="3" class="input-xlarge required"/>
				<font color="red">*</font> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">缩写：</label>
			<div class="controls">
				<form:input path="sort" htmlEscape="false" maxlength="2" class="input-xlarge required"/>
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
			<shiro:hasPermission name="rest:sicmedTwxrayClass:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>