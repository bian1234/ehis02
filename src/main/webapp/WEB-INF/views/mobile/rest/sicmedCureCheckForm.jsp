<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>单表管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#inputForm").validate({
				rules:{
					cureCode:{
						isNumberAndEng:true
					},
					/* cureName:{
						isEngAndChi:true
					}, */
					cureNamePY:{
						isEnglish:true
					},
					"sicmedCurePrice.price":{
						isPrice:true
					}
					
				},
					messages:{
						/* cureCode:{
							isNumberAndEng:"编码格式不对长度为8的数字或英文+数字"
						}, */
						/* cureName:{
							isEngAndChi:"格式不正确 汉字或者英文+汉字"
						}, */
						cureNamePY:{
							isEnglish:"请填写拼音格式"
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
		<li><a href="${ctx}/web/sicmedCureCheck/">单表列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedCureCheck/form?id=${sicmedCureCheck.id}">单表<shiro:hasPermission name="rest:sicmedCureCheck:edit">${not empty sicmedCureCheck.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedCureCheck:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedCureCheck" action="${ctx}/web/sicmedCureCheck/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">治疗编码：</label>
			<div class="controls">
				<form:input path="cureCode" htmlEscape="false" maxlength="8" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">治疗名称：</label>
			<div class="controls">
				<form:input path="cureName" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">治疗拼音名称：</label>
			<div class="controls">
				<form:input path="cureNamePY" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
			<div class="control-group">
			<label class="control-label">治疗价格：</label>
			<div class="controls">
				<form:input path="sicmedCurePrice.price" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">治疗类别：</label>
			<div class="controls">
				<sys:treeselect id="parent" 
					name="sicmedCureClass.id" value="${sicmedCureCheck.sicmedCureClass.id}" labelName="sicmedCureClass.className" labelValue="${sicmedCureCheck.sicmedCureClass.className}"
					title="父级编号" url="/web/sicmedCureCheck/treeData" extId="${sicmedCureCheck.sicmedCureClass.id}" cssClass="required" allowClear="true"/>
			</div>
		</div>
	<%-- 	<div class="control-group">
			<label class="control-label">治疗价格(对应治疗价格表)：</label>
			<div class="controls">
				<form:input path="sicmedCurePrice.id" htmlEscape="false" minlength="32" maxlength="32" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">治疗类别(对应治疗大分类表)：</label>
			<div class="controls">
				<form:input path="sicmedCureClass.id" htmlEscape="false" minlength="32" maxlength="32" class="input-xlarge required"/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">治疗详情：</label>
			<div class="controls">
				<form:textarea path="cureDetail" htmlEscape="false" rows="4" maxlength="200" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedCureCheck:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>