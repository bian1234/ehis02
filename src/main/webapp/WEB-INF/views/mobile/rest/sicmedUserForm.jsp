<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>医生信息列表</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				rules:{
					/* userNumber:{
						isInteger:true
					}, */
					userName:{
						isChi:true
					},
					/* password:{
						isInteger:true
					}, */
					doctorCode:{
						isInteger:true
					},
					/* printranking:{
						is0or1:true
					}, */
					doctorRegisteredAm:{
						isInteger:true
					},
					doctorRegisteredPm:{
						isInteger:true
					},
					doctorRegistered:{
						is0or1:true
					},
					userTel:{
						isMobile:true
					},
					userEmail:{
						email:true
					},
					userStatus:{
						is0or1:true
					},
					userFodate:{
						required:true,
					},
					/* userTodate:{
						compareDate:"#userFodate"
					},
					changeOdate:{
						compareDate:"#changeFdate"
					}, */
					/* doctorGrade:{
						is1or5:true
					}, */
					userJobGroup:{
						is0or2:true
					}
					/* userJobGrade:{
						is0or2:true
					} */
				},
				
				messages:{
					/* password:{
						minlength:"密码为八位数字"
					}, */
					doctorCode:{
						minlength:"编号是6位数字"
					},
					userName:{
						minlength:"用户名至少是两个字"
					}
					/* userTodate:{
						compareDate:"结束日期必须大于开始日期"
					},
					changeOdate:{
						compareDate:"结束日期必须大于开始日期"
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
		<li><a href="${ctx}/web/sicmedUser/list">医生列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedUser/form?id=${sicmedUser.id}">医生<shiro:hasPermission name="rest:sicmedUser:edit">${not empty sicmedUser.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedUser:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedUser" action="${ctx}/web/sicmedUser/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<%-- <div class="control-group">
			<label class="control-label">部门(外键)：</label>
			<div class="controls">
				<form:input path="sicmedDept.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>  --%>
		<div class="control-group">
			<label class="control-label">部门：</label>
			<div class="controls">
				<%-- <form:input path="sicmedInspectClass.id" id="searchBut" type="button" value="测试"/> --%>
				<sys:treeselect id="id"
					name="sicmedDept.id" value="${sicmedUser.sicmedDept.id}" labelName="sicmedDept.name" labelValue="${sicmedUser.sicmedDept.deptName}"
					title="部门" url="/web/sicmedUser/treeData" extId="${sicmedUser.id}" cssClass="" allowClear="true"/>
				<span class="help-inline">
					<font color="red">*</font> 
				</span>
			</div>
		</div> 
		<%-- <div class="control-group">
			<label class="control-label">科室编码(外键)：</label>
			<div class="controls">
				<form:input path="sicmedBranch.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">科室：</label>
			<div class="controls">
				<%-- <form:input path="sicmedInspectClass.id" id="searchBut" type="button" value="测试"/> --%>
				<sys:treeselect id="parent" 
					name="sicmedBranch.id" value="${sicmedUser.sicmedBranch.id}" labelName="sicmedBranch.name" labelValue="${sicmedUser.sicmedBranch.branchName}"
					title="科室" url="/web/sicmedUser/branch" extId="${sicmedUser.id}" cssClass="" allowClear="true"/>
				<span class="help-inline">
					<font color="red">*</font> 
				</span>
			</div>
		</div> 
		<%-- <div class="control-group">
			<label class="control-label">用户编码：</label>
			<div class="controls">
				<form:input path="userNumber" htmlEscape="false" minlength="6" maxlength="6" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">入职日期：</label>
			<div class="controls">
				<input id="userFodate" name="userFodate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate required"
					value="<fmt:formatDate value="${sicmedUser.userFodate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户名：</label>
			<div class="controls">
				<form:input path="userName" htmlEscape="false" minlength="2" maxlength="4" class="input-xlarge required"/>
				<span class="help-inline">
					<font color="red">*</font> 
				</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">密码：</label>
			<div class="controls">
				<form:input path="password" htmlEscape="false" minlength="8" maxlength="16" class="input-xlarge required"/>
				<span class="help-inline">默认密码12345678</span>
				<span class="help-inline">
					<font color="red">*</font> 
				</span>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">离职时间：</label>
			<div class="controls">
				<input name="userTodate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sicmedUser.userTodate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div> --%>
	<%-- 	<div class="control-group">
			<label class="control-label">工作等级：</label>
			<div class="controls">
				<form:input path="userJobGrade" htmlEscape="false" maxlength="1" class="input-xlarge "/>
				<select class="js-example-basic-single js-states form-control" name="userJobGroup">
				 	<option value="1">是</option>
				 	<option value="2">否</option>
				 	<option value="3">否</option>
				 	<option value="">否</option>
				 	<option value="1">否</option>
				 </select>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">工作组：</label>
			<div class="controls">
				<%-- <form:input path="userJobGrade" htmlEscape="false" maxlength="1" class="input-xlarge "/> --%>
				<select class="input-medium" name="userJobGroup" >
<%-- 				 	<option value="${sicmedUser.userJobGroup}">${sicmedUser.jobGroupType }</option>
 --%>				 	<c:choose>
				 		<c:when test="${sicmedUser.userJobGroup == 0}">
				 			<option value="0" selected="selected">挂号</option>
				 			<option value="1">医生</option>
				 			<option value="2">收费</option>
				 		</c:when>
				 		<c:when test="${sicmedUser.userJobGroup == 1}">
				 			<option value="0">挂号</option>
				 			<option value="1" selected="selected">医生</option>
				 			<option value="2">收费</option>
				 		</c:when>
				 		<c:when test="${sicmedUser.userJobGroup == 2}">
				 			<option value="0">挂号</option>
				 			<option value="1">医生</option>
				 			<option value="2" selected="selected">收费</option>
				 		</c:when>
				 		<c:otherwise>
				 			<option value="3" selected="selected">请选择</option>
       						<option value="0">挂号</option>
				 			<option value="1">医生</option>
				 			<option value="2">收费</option>	
       					</c:otherwise>
				 	</c:choose>
				 </select>
				 <span class="help-inline">确认所选内容无误后提交</span>
				 <font color="red">*</font> 
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">医生编号：</label>
			<div class="controls">
				<form:input path="doctorCode" htmlEscape="false" minlength="6" maxlength="6" class="input-xlarge "/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">医生等级：</label>
			<div class="controls">
				<%-- <form:input path="doctorGrade" htmlEscape="false" maxlength="1" class="input-xlarge "/> --%>
				<select class="input-medium" name="doctorGrade">
					<%-- <option value="${sicmedUser.doctorGrade}">${sicmedUser.doctorGradeType }</option> --%>
					<c:choose>
						<c:when test="${sicmedUser.doctorGrade == 0}">
							<option selected="selected" value="0">没有医生等级权限</option>
				 			<option value="1">普通门诊</option>
				 			<option value="2">副主任专家门诊</option>
				 			<option value="3">主任专家门诊</option>
				 			<option value="4">知名专家门诊</option>
				 			<option value="5">特需门诊</option>
						</c:when>
						<c:when test="${sicmedUser.doctorGrade == 1}">
							<option value="0">没有医生等级权限</option>
				 			<option selected="selected" value="1">普通门诊</option>
				 			<option value="2">副主任专家门诊</option>
				 			<option value="3">主任专家门诊</option>
				 			<option value="4">知名专家门诊</option>
				 			<option value="5">特需门诊</option>
						</c:when>
						<c:when test="${sicmedUser.doctorGrade == 2}">
							<option value="0">没有医生等级权限</option>
				 			<option value="1">普通门诊</option>
				 			<option selected="selected" value="2">副主任专家门诊</option>
				 			<option value="3">主任专家门诊</option>
				 			<option value="4">知名专家门诊</option>
				 			<option value="5">特需门诊</option>
						</c:when>
						<c:when test="${sicmedUser.doctorGrade == 3}">
							<option value="0">没有医生等级权限</option>
				 			<option value="1">普通门诊</option>
				 			<option value="2">副主任专家门诊</option>
				 			<option selected="selected" value="3">主任专家门诊</option>
				 			<option value="4">知名专家门诊</option>
				 			<option value="5">特需门诊</option>
						</c:when>
						<c:when test="${sicmedUser.doctorGrade == 4}">
							<option value="0">没有医生等级权限</option>
				 			<option value="1">普通门诊</option>
				 			<option value="2">副主任专家门诊</option>
				 			<option value="3">主任专家门诊</option>
				 			<option selected="selected" value="4">知名专家门诊</option>
				 			<option value="5">特需门诊</option>
						</c:when>
						<c:when test="${sicmedUser.doctorGrade == 5}">
							<option value="0">没有医生等级权限</option>
				 			<option value="1">普通门诊</option>
				 			<option value="2">副主任专家门诊</option>
				 			<option value="3">主任专家门诊</option>
				 			<option value="4">知名专家门诊</option>
				 			<option selected="selected" value="5">特需门诊</option>
						</c:when>
						<c:otherwise>
							<option value="0">没有医生等级权限</option>
				 			<option value="1">普通门诊</option>
				 			<option value="2">副主任专家门诊</option>
				 			<option value="3">主任专家门诊</option>
				 			<option value="4">知名专家门诊</option>
				 			<option value="5">特需门诊</option>
						</c:otherwise>
					</c:choose>
				 </select>
				 <span class="help-inline">只有医生可选医生等级</span>
				 <font color="red">*</font> 
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">帐号是否激活：</label>
			<div class="controls">
				<form:input path="printranking" htmlEscape="false" maxlength="2" class="input-xlarge" />
				<select class="js-example-basic-single js-states form-control" name="printranking">
				 	<option value="1">是</option>
				 	<option value="0">否</option>
				 </select><span class="help-inline">确认所选内容无误后提交</span>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">是否可挂号：</label>
			<div class="controls">
			<%-- 	<form:input path="doctorRegistered" htmlEscape="false" maxlength="1" class="input-xlarge required"/> --%>
			<select class="input-medium" name="doctorRegistered">
				<c:choose>
					<c:when test="${sicmedUser.doctorRegistered == 0}">
						<option value="0">不可挂号</option>
				 		<option value="1">可挂号</option>
					</c:when>
					<c:when test="${sicmedUser.doctorRegistered == 1}">
						<option value="0">不可挂号</option>
				 		<option value="1">可挂号</option>
					</c:when>
					<c:otherwise>
						<option value="3">请选择</option>
						<option value="0">不可挂号</option>
				 		<option value="1">可挂号</option>
					</c:otherwise>
				</c:choose>
			</select>
			<span class="help-inline">只有医生可选挂号</span>
			<font color="red">*</font> 
			</div>
		</div> 
	<%-- 	<div class="control-group">
			<label class="control-label">上午挂号人数：</label>
			<div class="controls">
				<form:input path="doctorRegisteredAm" htmlEscape="false" maxlength="3" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">下午挂号人数：</label>
			<div class="controls">
				<form:input path="doctorRegisteredPm" htmlEscape="false" maxlength="3" class="input-xlarge required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">挂号区分：</label>
			<div class="controls">
				<form:input path="registeredDifference" htmlEscape="false" maxlength="1" class="input-xlarge "/>
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">许可证编码：</label>
			<div class="controls">
				<form:input path="license" htmlEscape="false" maxlength="15" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">特需许可证编号：</label>
			<div class="controls">
				<form:input path="licenseSpc" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>--%>
		<div class="control-group">
			<label class="control-label">在职状态：</label>
			<div class="controls">
				<%-- <form:input path="userStatus" htmlEscape="false" maxlength="1" class="input-xlarge required" /> --%>
				<select class="input-medium" name="userStatus">
					<%-- <option selected="selected" value="${sicmedUser.userStatus}">${sicmedUser.userStatusType }</option>
				 	<option value="1">在职</option>
				 	<option value="0">离职</option> --%>
				 	<c:choose>
				 		<c:when test="${sicmedUser.userStatus==0}">
				 			<option value="1">在职</option>
				 			<option selected="selected" value="0">离职</option>
				 		</c:when>
				 		<c:when test="${sicmedUser.userStatus==1}">
				 			<option selected="selected" value="1">在职</option>
				 			<option value="0">离职</option>
				 		</c:when>
				 		<c:otherwise>
				 			<option value="1">在职</option>
				 			<option value="0">离职</option>
				 			<option selected="selected" value="3">请选择</option>
				 		</c:otherwise>
				 	</c:choose>
				</select>
			<span class="help-inline">确认所选内容无误后提交</span>
			<span class="help-inline">
					<font color="red">*</font> 
				</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话：</label>
			<div class="controls">
				<form:input path="userTel" htmlEscape="false" maxlength="14" class="input-xlarge required" />
			</div>
			<font color="red">*</font> 
		</div>
		<div class="control-group">
			<label class="control-label">邮箱：</label>
			<div class="controls">
				<form:input path="userEmail" htmlEscape="false" maxlength="50" class="input-xlarge " />
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">变更开始日期：</label>
			<div class="controls">
				<input id="changeFdate" name="changeFdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${sicmedUser.changeFdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">变更结束日期：</label>
			<div class="controls">
				<input name="changeOdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${sicmedUser.changeOdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">所属科室编码1：</label>
			<div class="controls">
				<form:input path="doctorBranch1" htmlEscape="false" maxlength="4" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属科室编码2：</label>
			<div class="controls">
				<form:input path="doctorBranch2" htmlEscape="false" maxlength="4" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">医生所属科室3：</label>
			<div class="controls">
				<form:input path="doctorBranch3" htmlEscape="false" maxlength="4" class="input-xlarge "/>
			</div>
		</div>--%>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:sicmedUser:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>