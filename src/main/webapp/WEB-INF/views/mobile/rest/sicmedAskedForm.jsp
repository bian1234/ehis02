<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医嘱保存成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				rules:{
					orderCode:{
						isNumberAndEng:true
					},
					askedName:{
						isEngAndChi:true
					},
					askedNameExtand:{
						isEngAndChi:true
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
		<li><a href="${ctx}/web/sicmedAsked/">医嘱保存成功列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedAsked/form?id=${sicmedAsked.id}">医嘱保存成功<shiro:hasPermission name="rest:sicmedAsked:edit">${not empty sicmedAsked.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedAsked:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedAsked" action="${ctx}/web/sicmedAsked/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<%-- <div class="control-group">
			<label class="control-label">医嘱类别(对应医嘱分类编码表)：</label>
			<div class="controls">
				<form:input path="sicmedAskedClass.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">医嘱编号：</label>
			<div class="controls">
				<form:input path="askedCode" htmlEscape="false" maxlength="8" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">医嘱类别：</label>
			<div class="controls">
				<%-- <form:input path="sicmedInspectClass.id" id="searchBut" type="button" value="测试"/> --%>
				<sys:treeselect id="office" 
					name="sicmedAskedClass.id" value="${sicmedAskedClass.id}" labelName="sicmedAskedClass.name" labelValue="${sicmedAsked.sicmedAskedClass.askedCalss}"
					title="父级编号" url="/web/sicmedAsked/sicmedAskedClass" extId="${sicmedAskedClass.id}" cssClass="" allowClear="true"/>
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">医嘱名称：</label>
			<div class="controls">
				<form:input path="askedName" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">医嘱扩展名：</label>
			<div class="controls">
				<form:input path="askedNameExtand" htmlEscape="false" maxlength="200" class="input-xlarge required"/>
			</div>
		</div>
	<%-- 	<div class="control-group">
			<label class="control-label">患者价格表id：</label>
			<div class="controls">
				<form:input path="sicmedPatientPrice.id" htmlEscape="false" maxlength="8" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">医嘱所属病例：</label>
			<div class="controls">
				<form:input path="sicmedCase.id" htmlEscape="false" maxlength="8" class="input-xlarge "/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedAsked:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>