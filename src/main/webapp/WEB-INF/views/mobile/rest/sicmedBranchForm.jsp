<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>保存科室成功管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				rules:{
					branchNameEnglish:{
						isEnglish:true
					},
					branchName:{
						isEngAndChi:true
					},
					branchNumber:{
						isNumberAndEng:true
					}
				},
				
				messages:{  
					branchNameEnglish:{
						isEnglish:"请输入英文格式"
					},
					branchName:{
						isEngAndChi:"请输入英文+汉字格式"
					},
					branchNumber:{
						isNumberAndEng:"请输入英文+数字格式"
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
		<li><a href="${ctx}/web/sicmedBranch/">科室列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedBranch/form?id=${sicmedBranch.id}">科室<shiro:hasPermission name="rest:sicmedBranch:edit">${not empty sicmedBranch.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedBranch:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedBranch" action="${ctx}/web/sicmedBranch/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">科室编码：</label>
			<div class="controls">
				<form:input path="branchCode" htmlEscape="false" minlength="4" maxlength="4" class="input-xlarge required"/>
				<span style="color:red">*</span>
			</div>
			
		</div>
		<div class="control-group">
			<label class="control-label">科室排序：</label>
			<div class="controls">
				<form:input path="branchNumber" htmlEscape="false" maxlength="3" class="input-xlarge required"/>
				<span style="color:red">*</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">科室名称：</label>
			<div class="controls">
				<form:input path="branchName" htmlEscape="false" maxlength="30" class="input-xlarge required"/>
				<span style="color:red">*</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">科室英文名称：</label>
			<div class="controls">
				<form:input path="branchNameEnglish" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span style="color:red">*</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">科室所在物理位置：</label>
			<div class="controls">
				<form:input path="branchLocation" htmlEscape="false" maxlength="60" class="input-xlarge required"/>
				<span style="color:red">*</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="id_label_single">是否可挂号：</label>
			<div class="controls">
			<%-- 	<form:input path="branchRegistered" htmlEscape="false" maxlength="1" class="input-xlarge required"/> --%>
				 <select class="input-medium required" name="branchRegistered">
				 	<%-- <option value="0">不可挂号</option>
				 	<option value="1">可挂号</option>
				 	<option selected="selected" value="${sicmedBranch.branchRegistered}">${sicmedBranch.registeredType}</option> --%>
				 	<c:choose>
				 		<c:when test="${sicmedBranch.branchRegistered == 0}">
							<option value="1">可挂号</option>
							<option selected="selected" value="${sicmedBranch.branchRegistered}">${sicmedBranch.registeredType}</option>	
       					</c:when>
       					<c:when test="${sicmedBranch.branchRegistered == 1}">
							<option selected="selected" value="${sicmedBranch.branchRegistered}">${sicmedBranch.registeredType}</option>
							<option value="0">不可挂号</option>
       					</c:when>
       					<c:otherwise>
       						<option value="1">可挂号</option>
       						<option value="0">不可挂号</option>
       					</c:otherwise>
       				</c:choose>
				 </select>
				 <span class="help-inline">确认所选内容无误后提交</span>
				<span style="color:red">*</span>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">上午挂号人数：</label>
			<div class="controls">
				<form:input path="branchRegisteredAm" htmlEscape="false" maxlength="3" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">下午挂号人数：</label>
			<div class="controls">
				<form:input path="branchRegisteredPm" htmlEscape="false" maxlength="3" class="input-xlarge required"/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">是否为住院科室：</label>
			<div class="controls">
				<%-- <form:input path="branchIpd" htmlEscape="false" maxlength="1" class="input-xlarge required"/> --%>
				<select class="input-medium required" name="branchIpd">
					<%-- <c:if test="${sicmedBranch.branchIpd = 0}">
						<option selected="selected" value="${sicmedBranch.branchIpd}">${sicmedBranch.ipdType}</option>
				 		<option value="1">是</option>
					</c:if> --%>
				 <c:choose>
				 		<c:when test="${sicmedBranch.branchIpd == 0}">
							<option value="1">是</option>
							<option selected="selected" value="0">否</option>	
       					</c:when>
       					<c:when test="${sicmedBranch.branchIpd == 1}">
							<option selected="selected" value="1">是</option>
							<option value="0">否</option>
       					</c:when>
       					<c:otherwise>
       						<option value="1">是</option>
       						<option value="0">否</option>
       					</c:otherwise>
       				</c:choose>
				 </select><span class="help-inline">确认所选内容无误后提交</span>
				<span style="color:red">*</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedBranch:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>