<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存部门成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				rules:{
					deptNumber:{
						isInteger:true
					},
					deptName:{
						isEngAndChi:true
					},
					deptPmpa:{
						isEnglish:true
					},
					deptCode:{
						isNumberAndEng:true
					}
				},
				messages:{
					deptNumber:{
						minlength:"输入十位数字编号"
					},
					deptPmpa:{
						isEnglish:"请输入正确拼音"
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
		<li><a href="${ctx}/web/sicmedDept/">部门列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedDept/form?id=${sicmedDept.id}">部门<shiro:hasPermission name="rest:sicmedDept:edit">${not empty sicmedDept.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedDept:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedDept" action="${ctx}/web/sicmedDept/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">部门编号：</label>
			<div class="controls">
				<form:input path="deptNumber" htmlEscape="false" minlength="10" maxlength="10" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门名称：</label>
			<div class="controls">
				<form:input path="deptName" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门拼音简写：</label>
			<div class="controls">
				<form:input path="deptPmpa" htmlEscape="false" maxlength="4" class="input-xlarge required"/>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">部门编码：</label>
			<div class="controls">
				<form:input path="deptCode" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedDept:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>