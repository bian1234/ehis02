<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>保存挂号信息成功管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	function handledata() {
		var a = $("#sicmedBranchId1").val();
		alert(a);
	}
	$(document).ready(
			function() {
				$("#inputForm").validate(
								{
									submitHandler : function(form) {
										loading('正在提交，请稍等...');
										form.submit();
									},
									errorContainer : "#messageBox",
									errorPlacement : function(error, element) {
										$("#messageBox").text("输入有误，请先更正。");
										if (element.is(":checkbox")
												|| element.is(":radio")
												|| element.parent().is(
														".input-append")) {
											error.appendTo(element.parent()
													.parent());
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
		<li class="active"><a
			href="${ctx}/webweb/sicmedRegistered/form?id=${sicmedRegistered.id}">挂号信息<shiro:hasPermission
					name="rest:sicmedRegistered:edit">${not empty sicmedRegistered.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="rest:sicmedRegistered:edit">查看</shiro:lacksPermission></a></li>
		<li><a href="${ctx}/webweb/sicmedRegistered/">挂号列表</a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="sicmedRegistered"
		action="${ctx}/webweb/sicmedRegistered/save" method="post"
		class="breadcrumb form-search">
		<form:hidden path="id" />
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<ul class="ul-form">
			<li><label>姓名：</label> <form:input
					path="sicmedPatient.patientName" htmlEscape="false" maxlength="32"
					class="input-xlarge required" /></li>
			<li><label>患者编号：</label> <form:input
					path="sicmedPatient.patientNumber" htmlEscape="false"
					maxlength="32" class="input-xlarge required" /></li>
		</ul>
		<ul class="ul-form">
			<li><label>性别：</label> <form:input
					path="sicmedPatient.patientSex" htmlEscape="false" maxlength="32"
					class="input-xlarge required" /></li>
			<li><label>年龄:</label> <form:input
					path="sicmedPatient.patientAge" htmlEscape="false" maxlength="32"
					class="input-xlarge required" /></li>
		</ul>
		<ul class="ul-form">

			<li><label class="control-label">挂号科室：</label> <sys:treeselect
					id="sicmedBranch" name="sicmedBranch.id"
					value="${sicmedRegistered.sicmedBranch.id}"
					labelName="sicmedBranch.branchName"
					labelValue="${sicmedRegistered.sicmedBranch.branchName}" title="科室"
					url="/webweb/sicmedRegistered/branch"
					extId="${sicmedRegistered.sicmedPatient.patientName}" cssClass=""
					allowClear="true" /></li>
			<li><label class="control-label">挂号类型：</label> <sys:treeselect
					id="sicmedRegistrationType" name="sicmedRegistrationType.id"
					value="${sicmedRegistered.sicmedRegistrationType.id}"
					labelName="sicmedRegistrationType.nameChina"
					labelValue="${sicmedRegistered.sicmedRegistrationType.nameChina}"
					title="挂号类型" url="/webweb/sicmedRegistered/type"
					extId="${sicmedRegistered.sicmedBranch.id }" cssClass=""
					allowClear="true" /></li>
		</ul>
		<li id="sicmedBranchId_bod" onclick="handledata()">
			<label class="control-label">挂号科室：</label> <select id="sicmedBranchId" name="sicmedBranchId" style="width: 152px">
				<option value="" style="color: #999999">-请选择-</option>
				<c:forEach items="${mapList}" var="sicmedBranch">
					<option value="${sicmedRegistered.sicmedBranch.id}">${sicmedRegistered.sicmedBranch.branchName}</option>
				</c:forEach>
		</select>
		</li>
		<li><label class="control-label">挂号类型:</label> <select
			id="sicmedRegisteredTypeId" name="sicmedRegisteredTypeId"
			style="width: 152px" onchange="getBranch(this.value)">
				<option value="" style="color: #999999">请选择</option>
		</select></li>
		<ul class="ul-form">
			<li><label class="control-label">医生：</label> <sys:treeselect
					id="sicmedDoctor" name="sicmedDoctor.id"
					value="${sicmedRegistered.sicmedDoctor.id}"
					labelName="sicmedDoctor.userName"
					labelValue="${sicmedRegistered.sicmedDoctor.userName}" title="医生"
					url="/webweb/sicmedRegistered/doctor"
					extId="${sicmedRegistered.sicmedDoctor.id}" cssClass=""
					allowClear="true" /></li>
		</ul>
		<ul class="ul-form">
			<li><label>应收金额:</label> <form:input path="registeredPric"
					htmlEscape="false" maxlength="32" class="input-xlarge"
					disabled="true" /></li>
		</ul>
		&#12288; &#12288; &#12288; &#12288; &#12288;
		<li class="btns"><input id="btnSubmit" class="btn btn-primary"
			type="submit" value="挂号" /></li> &nbsp;<input id="btnCancel" class="btn"
			type="button" value="返 回" onclick="history.go(-1)" />
	</form:form>
	<div style="border: 1px soid red;"></div>
</body>
</html>