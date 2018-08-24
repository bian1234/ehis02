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
					checkPrice:{
						isInteger:true
					},
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
		<li><a href="${ctx}/web/sicmedCheckPrice/">单表列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedCheckPrice/form?id=${sicmedCheckPrice.id}">单表<shiro:hasPermission name="rest:sicmedCheckPrice:edit">${not empty sicmedCheckPrice.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedCheckPrice:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedCheckPrice" action="${ctx}/web/sicmedCheckPrice/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">价格变更截止时间：</label>
			<div class="controls">
				<input name="checkPriceCutoffDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${sicmedCheckPrice.checkPriceCutoffDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">价格变更开始时间：</label>
			<div class="controls">
				<input name="checkPriceInsertDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${sicmedCheckPrice.checkPriceInsertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">放射线检查编码：</label>
			<div class="controls">
				<sys:treeselect id="parent" 
					name="sicmedInspect.id" value="${sicmedCheckPrice.sicmedTwxrayCheck.id}" labelName="sicmedInspect.inspectName" labelValue="${sicmedCheckPrice.sicmedTwxrayCheck.checkName}"
					title="父级编号" url="/web/sicmedCheckPrice/treeData" extId="${sicmedCheckPrice.sicmedTwxrayCheck.id}" cssClass="" allowClear="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">检查价格：</label>
			<div class="controls">
				<form:input path="checkPrice" htmlEscape="false" maxlength="11" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedCheckPrice:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>