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
					/* inspectName:{
						isEngAndChi:true
					}, */
					/* inspectNamePY:{
						isEnglish:true
					}, */
					inspectCode:{
						isNumberAndEng:true
					}/* ,
					parent:{
						required:true
					} */
				},
				messages:{
					/* inspectName:{
						isEngAndChi:"名字格式不正确 ex:血液检查或XY检查"
					}, */
					/* inspectNamePY:{
						isEnglish:"名字拼音格式不正确"
					}, */
					inspectCode:{
						isNumberAndEng:"编号格式不正确 ex:XY000001"
					}/* ,
					parent:{
						required:"不能为空"
					} */
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
		<li><a href="${ctx}/web/sicmedInspect/">单表列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedInspect/form?id=${sicmedInspect.id}">单表<shiro:hasPermission name="rest:sicmedInspect:edit">${not empty sicmedInspect.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedInspect:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedInspect" action="${ctx}/web/sicmedInspect/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<div class="control-group">
			<label class="control-label">检验名称：</label>
			<div class="controls">
				<form:input path="inspectName" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<font color="red">*</font>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">检验名称拼音：</label>
			<div class="controls">
				<form:input path="inspectNamePY" htmlEscape="false" maxlength="40" class="input-xlarge required"/>
				<font color="red">*</font>
			</div>
		</div>	
		<div class="control-group">
			<label class="control-label">检验编号：</label>
			<div class="controls">
				<form:input path="inspectCode" htmlEscape="false" maxlength="10" class="input-xlarge required"/>
				<font color="red">*</font>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">检验价格：</label>
			<div class="controls">
				<form:input  path="sicmedInspectPrice.price" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
				<font color="red">*</font>
			</div>
		</div>
		
		<%-- <div class="control-group">
			<label class="control-label">检验类别编号(对应类别表)：</label>
			<div class="controls">
				<form:input path="sicmedInspectClass.id" htmlEscape="false" maxlength="32" class="input-xlarge required"/>
			</div>
		</div> --%>
		
		<div class="control-group">
			<label class="control-label">检验类别：</label>
			<div class="controls">
				<%-- <form:input path="sicmedInspectClass.id" id="searchBut" type="button" value="测试"/> --%>
				<sys:treeselect id="parent" 
					name="sicmedInspectClass.id" value="${sicmedInspect.sicmedInspectClass.id}" labelName="sicmedInspectClass.inspectName" labelValue="${sicmedInspect.sicmedInspectClass.inspectName}"
					title="父级编号" url="/web/sicmedInspect/treeData" extId="${sicmedInspectClass.id}" cssClass="required" allowClear="true"/>
				<font color="red">*</font>
			</div>
		</div> 
		
		<div class="control-group">
			<label class="control-label">检验名称详情：</label>
			<div class="controls">
				<form:input path="inspectDetail" htmlEscape="false" maxlength="200" class="input-xlarge"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge"/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedInspect:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
	
	<script type="text/javascript">
	 $(document).ready(function(){
		$("#searchBut").click(
			function search(){
				alert("1");
			}		
		)			
	});
	/* 	$(document).ready(function(){
			function searchs(){
				alert("1");
			}				
		}); */
	</script>
</body>
</html>