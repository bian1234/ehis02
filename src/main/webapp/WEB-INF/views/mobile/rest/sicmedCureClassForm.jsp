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
					sort:{
						isInteger:true
						},
					/* classCode:{
						isInteger:true
					}, */
					/* className:{
						isChi:true
					}, */
					pacsClass:{
						isEnglish:true
					}
				},
					
				messages:{
					sort:{
						sortEEC:"缩写格式不正确 例:1"
					},
					/* classCode:{
						isInteger:"编号类型为1-99"
					}, */
					/* className:{
						isChi:"名称类型格式不正确 例：皮肤治疗"
					}, */
					pacsClass:{
						isEnglish:"学名格式不正确 例:pf"
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
		<li><a href="${ctx}/web/sicmedCureClass/">单表列表</a></li>
		<li class="active">
			<a href="${ctx}/web/sicmedCureClass/form?id=${sicmedCureClass.id}">单表
				<shiro:hasPermission name="rest:sicmedCureClass:edit">${not empty sicmedCureClass.id?'修改':'添加'}
				</shiro:hasPermission>
				<shiro:lacksPermission name="rest:sicmedCureClass:edit">查看</shiro:lacksPermission>
			</a>
		</li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedCureClass" action="${ctx}/web/sicmedCureClass/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">类别编号：</label>
			<div class="controls">
				<form:input path="classCode" htmlEscape="false" minlength="1" maxlength="2" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类别名称：</label>
			<div class="controls">
				<form:input path="className" htmlEscape="false" minlength="1" maxlength="30" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">学名：</label>
			<div class="controls">
				<form:input path="pacsClass" htmlEscape="false" minlength="1" maxlength="3" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">缩写：</label>
			<div class="controls">
				<form:input path="sort" htmlEscape="false" maxlength="2" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedCureClass:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>