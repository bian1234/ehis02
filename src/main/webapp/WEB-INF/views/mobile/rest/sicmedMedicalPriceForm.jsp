<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>药品价格信息保存成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
		 	$("#inputForm").validate({
				rules:{
					priceEnter:{
						isInteger:true
					},
					priceSale:{
						isInteger:true
					},
					priceInsertDate:{
						required:true
					},
				 	priceCutoffDate:{
						compareDate:"#priceInsertDate" 
					} 
				},
			 	messages:{
					priceCutoffDate:{
						compareDate:"结束日期必须大于开始日期"
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
		<li><a href="${ctx}/web/sicmedMedicalPrice/">药品价格信息保存成功列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedMedicalPrice/form?id=${sicmedMedicalPrice.id}">药品价格信息保存成功<shiro:hasPermission name="rest:sicmedMedicalPrice:edit">${not empty sicmedMedicalPrice.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedMedicalPrice:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedMedicalPrice" action="${ctx}/web/sicmedMedicalPrice/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>			
		<div class="control-group">
			<label class="control-label">药品编码(对应药品表中的主键)：</label>
			<div class="controls">
				<sys:treeselect id="parent" 
					name="sicmedInspect.id" value="${sicmedMedicalPrice.sicmedMedical.id}" labelName="sicmedInspect.inspectName" labelValue="${sicmedMedicalPrice.sicmedMedical.medicalNameChina}"
					title="父级编号" url="/web/sicmedMedicalPrice/medicalPrice" extId="${sicmedMedicalPrice.sicmedMedical.id}" cssClass="" allowClear="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品进价：</label>
			<div class="controls">
				<form:input path="priceEnter" htmlEscape="false" maxlength="11" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品售价：</label>
			<div class="controls">
				<form:input path="priceSale" htmlEscape="false" maxlength="11" class="input-xlarge required"/>
			</div>
		</div>			
		<div class="control-group">
			<label class="control-label">价格变更开始时间：</label>
			<div class="controls">
				<input id="priceInsertDate" name="priceInsertDate" type="text"  maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${sicmedMedicalPrice.priceInsertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">价格变更截止时间：</label>
			<div class="controls">
				<input name="priceCutoffDate" type="text"  maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${sicmedMedicalPrice.priceCutoffDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedMedicalPrice:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>