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
					price:{
						isInteger:true
					},
					priceCutoffDate:{
				 		compareDate:"#priceInsertDate"
					} 
					
				},
				
				messages:{
					price:{
						isInteger:"金额格式不正确"
					},
					priceCutoffDate:{
						compareDate:"请核对起止时间，启用时间不能晚于截止时间" 
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
		<li><a href="${ctx}/web/sicmedCurePrice/">单表列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedCurePrice/form?id=${sicmedCurePrice.id}">单表<shiro:hasPermission name="rest:sicmedCurePrice:edit">${not empty sicmedCurePrice.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedCurePrice:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedCurePrice" action="${ctx}/web/sicmedCurePrice/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">治疗类型编号：</label>
			<%-- <div class="controls">
				<form:input path="sicmedCureCheck.id" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
			</div> --%>
			<div class="controls">
				<sys:treeselect id="parent" 
					name="sicmedCureCheck.id" value="${sicmedCurePrice.sicmedCureCheck.id}" labelName="sicmedCureCheck.cureName" labelValue="${sicmedCurePrice.sicmedCureCheck.cureName}"
					title="治疗项目" url="/web/sicmedCurePrice/treeData" extId="${sicmedCurePrice.sicmedCureCheck.id}" cssClass="" allowClear="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">价格：</label>
			<div class="controls">
				<form:input path="price" htmlEscape="false" maxlength="11" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">价格启用时间：</label>
			<div class="controls">
				<input id="priceInsertDate" name="priceInsertDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${sicmedCurePrice.priceInsertDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">价格截止时间：</label>
			<div class="controls">
				<input id="priceCutoffDate" name="priceCutoffDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${sicmedCurePrice.priceCutoffDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
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
			<shiro:hasPermission name="rest:sicmedCurePrice:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
		
	</form:form>
</body>
</html>