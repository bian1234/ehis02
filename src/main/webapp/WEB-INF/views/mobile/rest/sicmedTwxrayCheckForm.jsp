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
					/* checkCode:{
						isNumberAndEng:true
					},					
					checkNamePY:{
						isEnglish:true
					} ,
					checkName:{
						isEngAndChi:true
					} , */
					"sicmedCheckPrice.checkPrice":{
						isPrice:true
					}
					
			},
				messages:{
					/* checkCode:{
						isNumberAndEng:"请输入数字\英文\英文+数字"
					},
					checkNamePY:{
						isEnglish:"输入拼音"
					},
					checkName:{
						isEngAndChi:"请输入汉字\英文\英文+汉字"
					}, */
					"sicmedCheckPrice.checkPrice":{
						isPrice:"输入金额格式.如:5.0"
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
		<li><a href="${ctx}/web/sicmedTwxrayCheck/">单表列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedTwxrayCheck/form?id=${sicmedTwxrayCheck.id}">单表<shiro:hasPermission name="rest:sicmedTwxrayCheck:edit">${not empty sicmedTwxrayCheck.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedTwxrayCheck:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedTwxrayCheck" action="${ctx}/web/sicmedTwxrayCheck/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<div class="control-group">
			<label class="control-label required">检查类别：</label>
			<div class="controls">
				<sys:treeselect id="parent" 
					name="sicmedTwxrayClass.id" value="${sicmedTwxrayCheck.sicmedTwxrayClass.id}" labelName="sicmedInspect.inspectName" labelValue="${sicmedTwxrayCheck.sicmedTwxrayClass.className}"
					title="父级编号" url="/web/sicmedTwxrayCheck/treeData" extId="${sicmedTwxrayCheck.sicmedTwxrayClass.id}" cssClass="required" allowClear="true"/>
				<font color="red">*</font> 
			</div>
		</div>	
		<div class="control-group">
			<label class="control-label">检查编码：</label>
			<div class="controls">
				<form:input path="checkCode" htmlEscape="false" maxlength="10" class="input-xlarge required"/>
				<font color="red">*</font> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">检查名称：</label>
			<div class="controls">
				<form:input path="checkName" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<font color="red">*</font> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">检查拼音名称：</label>
			<div class="controls">
				<form:input path="checkNamePY" htmlEscape="false" maxlength="80" class="input-xlarge required"/>
				<font color="red">*</font> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">检查价格：</label>
			<div class="controls">
				<form:input path="sicmedCheckPrice.checkPrice" htmlEscape="false" maxlength="11" class="input-xlarge required"/>
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
			<shiro:hasPermission name="rest:sicmedTwxrayCheck:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>