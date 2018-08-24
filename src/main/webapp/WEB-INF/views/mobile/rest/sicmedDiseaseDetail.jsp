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
					diseaseName:{
						isEngAndChi:true
					},
					diseaseNameEnglish:{
						isEnglish:true
					},
					diseaseNamePmpa:{
						isEnglish:true
					},
					diseaseCode:{
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
		<li><a href="${ctx}/web/sicmedDisease/">疾病列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedDisease/form?id=${sicmedDisease.id}">疾病<shiro:hasPermission name="rest:sicmedDisease:edit">${not empty sicmedDisease.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedDisease:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedDisease" action="${ctx}/web/sicmedDisease/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
	<%-- 	<div class="control-group">
			<label class="control-label">疾病类别编码(对应疾病编码表)：</label>
			<div class="controls">
				<form:input path="diseaseClass.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">疾病类别：</label>
			<div class="controls">
				<%-- <form:input path="sicmedInspectClass.id" id="searchBut" type="button" value="测试"/> --%>
				<sys:treeselect id="office" 
					name="diseaseClass.id" value="${diseaseClass.id}" labelName="diseaseClass.name" labelValue="${sicmedDisease.diseaseClass.diseaseClassName}"
					title="父级编号" url="/web/sicmedDisease/diseaseClass" extId="${diseaseClass.id}" cssClass="" allowClear="true" />
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">疾病编码：</label>
			<div class="controls">
				<form:input path="diseaseCode" htmlEscape="false" maxlength="20" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">疾病名称：</label>
			<div class="controls">
				<form:input path="diseaseName" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">疾病英文名：</label>
			<div class="controls">
				<form:input path="diseaseNameEnglish" htmlEscape="false" maxlength="20" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">疾病拼音缩写名：</label>
			<div class="controls">
				<form:input path="diseaseNamePmpa" htmlEscape="false" minlength="1" maxlength="10" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedDisease:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>