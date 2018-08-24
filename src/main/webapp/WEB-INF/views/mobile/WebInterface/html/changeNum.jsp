<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<!-- <link href="/jeesite/static/bootstrap-3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="/jeesite/static/bootstrap-3.3.7/dist/css/bootstrap-datetimepicker.min.css"
	type="text/css" rel="stylesheet" />
	<script src="/jeesite/static/bootstrap-3.3.7/js/testsendor/jquery-3.1.0.min.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap-3.3.7/dist/js/bootstrap.min.js"
	type="text/javascript"></script>

<script
	src="/jeesite/static/bootstrap-3.3.7/dist/js/bootstrap-datetimepicker.fr.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap-3.3.7/dist/js/bootstrap-datetimepicker.js"
	type="text/javascript"></script> -->

<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="/jeesite/static/bootstrap3/js/testsendor/jquery-3.1.0.min.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"></script>

<title>改号窗口</title>
</head>
<body>
	<%-- <div
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100px; background-color: #39A0ED; text-align: center">
		<h1>改号窗口</h1>
	</div>
	<div
		style="position: absolute; top: 100px; left: 0px; width: 10%; height: 900px; background-color: #545454">
		<div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/gridLayout"
						style="color: gray">挂号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/" style="color: white">改号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/backList"
						style="color: gray">退号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/total" style="color: gray">查询</a>
				</h2>
			</div>
		</div>
	</div> --%>
	<div class="col-xs-12 col-sm-12" id="patientDetail">

		<div class="header">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="${ctx}/webweb/sicmedRegistered/"
							style="color: gray">患者列表</a> <a class="navbar-brand"
							href="${ctx}/webweb/sicmedRegistered/change" style="color: black">改号</a>
					</div>
				</div>
			</nav>
		</div>
		<br> <br>
		<form id="inputForm" action="${ctx}/webweb/sicmedRegistered/save"
			method="post" class="breadcrumb form-search">
			<input type="hidden" name="id" value="${sicmedRegistered.id }">
			<br> <br>
			<div class="container">
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">患者编号：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedPatient.patientNumber}
						</div>
					</div>
				</div>
				<%-- <div class="row">
				<div class="col-xs-6">
					<div class="col-xs-3">
						<label style="font-size: 15px">患者编号：</label>
					</div>
					<div class="col-xs-9">
						<input class="text"
							name="sicmedPatient.patientNumber" style="border:0px;"
							value="${sicmedRegistered.sicmedPatient.patientNumber}" readonly>
					</div>
				</div> --%>
				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">姓名：</label>
						</div>
						<div class="col-xs-9">
							<input class="text"
								value="${sicmedRegistered.sicmedPatient.patientName}"
								onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')"
								name="sicmedPatient.patientName" required>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">性别：</label>
						</div>
						<div class="col-xs-8">
							<%-- ${sicmedRegistered.sicmedPatient.patientSex } --%>
							<c:choose>
								<c:when test="${sicmedRegistered.sicmedPatient.patientSex=='男'}">
									男 <input type="radio" name="sicmedPatient.patientSex" checked="checked" value="男" /> &nbsp &nbsp &nbsp &nbsp 女 
							 		<input type="radio" name="sicmedPatient.patientSex" value="女" />		
								</c:when>
								<c:otherwise>
									男 <input type="radio" name="sicmedPatient.patientSex" value="男" /> &nbsp &nbsp &nbsp &nbsp 女 
							 		<input type="radio" name="sicmedPatient.patientSex" checked="checked" value="女" />
								</c:otherwise>
							</c:choose>
							
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<!-- <div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">性别：</label>
						</div>
						<div class="col-xs-8">
							男 <input type="radio" name="sicmedPatient.patientSex" checked="checked" value="男" /> &nbsp
							&nbsp &nbsp &nbsp 女 <input type="radio" 
								name="sicmedPatient.patientSex" value="女"/>
						</div>
					</div> -->
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">年龄：</label>
						</div>
						<div class="col-xs-9">
							<input class="text"
								value="${sicmedRegistered.sicmedPatient.patientAge}"
								onkeyup="this.value=this.value.replace(/[^\d]/g,'')"
								name="sicmedPatient.patientAge" required>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">身份证号：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" name="sicmedPatient.patientCard"
								onkeyup="this.value=this.value.replace(/[^\d]/g,'')">
						</div>
					</div>
				</div>
				<br>
				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">挂号科室：</label>
						</div>
						<div class="col-xs-9">
							<select id="sicmedBranchId" onchange="getBranch(this.value)"
								name="sicmedBranch.id" class="selectpicker"
								style="width: 174px; height: 26px" required>
								<option value="${sicmedRegistered.sicmedBranch.id}">${sicmedRegistered.sicmedBranch.branchName}</option>
								<c:forEach items="${sicmedBranch }" var="sicmedBranch">
									<c:if
										test="${sicmedRegistered.sicmedBranch.branchName != sicmedBranch.branchName}">
										<option value="${sicmedBranch.id }">${sicmedBranch.branchName}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">挂号医生：</label>
						</div>
						<div class="col-xs-9">
							<select id="sicmedDoctorId" name="sicmedDoctor.id"
								class="selectpicker" style="width: 174px; height: 26px">
								<option value="${sicmedRegistered.sicmedDoctor.id }">${sicmedRegistered.sicmedDoctor.userName}</option>
								<c:forEach items="${sicmedUser}" var="sicmedUser">
									<c:if
										test="${sicmedRegistered.sicmedDoctor.userName != sicmedUser.userName}">
										<option value="${sicmedUser.id }">${sicmedUser.userName}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">挂号类型：</label>
						</div>
						<div class="col-xs-9">
							<select id="sicmedRegistrationTypeId"
								name="sicmedRegistrationType.id" onchange="getDoctor(this)"
								class="selectpicker" style="width: 174px; height: 26px" required>
								<option value="${sicmedRegistered.sicmedRegistrationType.id}">${sicmedRegistered.sicmedRegistrationType.nameChina}</option>
								<c:forEach items="${sicmedRegisteredType}"
									var="sicmedRegistrationType">
									<c:if
										test="${sicmedRegistered.sicmedRegistrationType.nameChina!=sicmedRegistrationType.nameChina}">
										<option value="${sicmedRegistrationType.id}">${sicmedRegistrationType.nameChina}</option>
									</c:if>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">付费类型：</label>
						</div>
						<div class="col-xs-8">
							<select id="type" name="type" class="selectpicker"
								style="width: 120px; height: 26px">
								<option>自费</option>
							</select>
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">挂号费：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" id="registeredFeeId"
								style="width: 60px; height: 26px;" name=""
								value="${sicmedRegistered.sicmedRegistrationType.sicmedRegisteredPrice.registeredFee }"
								readonly>&nbsp &nbsp 元
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">差价：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" value="" id="difference"
								style="width: 60px; height: 26px;" readonly>&nbsp &nbsp 元
						</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">工本费：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" id="materialFeeId"
								name="sicmedRegistered.registeredPric.materialFee"
								style="width: 60px; height: 26px;"
								value="${sicmedRegistered.sicmedRegistrationType.sicmedRegisteredPrice.materialFee }"
								readonly>&nbsp &nbsp 元
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">实收金额:</label>
						</div>
						<div class="col-xs-8">
							<input class="text" id="price" name="price"
								onchange="getPrice(this.value)">&nbsp &nbsp 元
						</div>
					</div>
				</div>

				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">诊疗费：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" id="clinicsFeeId"
								style="width: 60px; height: 26px;"
								name="${sicmedRegisteredPrice.clinicsFee }"
								value="${sicmedRegistered.sicmedRegistrationType.sicmedRegisteredPrice.clinicsFee }"
								readonly>&nbsp &nbsp 元
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">找零：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" 
								id="zhaoling" style="width: 60px; height: 26px;"
								name="registeredPric" readonly>&nbsp &nbsp 元
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-9">
							<input class="text" hidden="true"
								id="sum" style="width: 60px; height: 26px;"
								name="registeredPric" readonly>
						</div>
					</div>
					<br>
					<br>
					<br>
					<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<input type="radio" name="sicmedPatient" />&nbsp
							打印挂号凭证
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-2">
							<label style="font-size: 15px">收费员:</label>
						</div>
						<div class="col-xs-8">
						<input type="hidden" name="sicmedRegistered.updateUser">
						${sicmedRegistered.createUser.userName}
						</div>
						</div>
					</div>
				</div>
					<div class="container">
						<br> <br>
						<div class="row">
							<div class="col-xs-8"></div>
							<div class="col-xs-4">
								<input id="inputForm" type="submit" value="改号"
									class="btn btn-info">
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>

	</div>
	<script type="text/javascript">
		function getPrice(price){
			var price = document.getElementById("price").value;
			var difference = document.getElementById("difference").value;
			var zhaoling = document.getElementById("zhaoling");
			zhaoling.value = parseInt(price) + parseInt(difference);
		}
	</script>
	<script type="text/javascript">
		/* 通过所选部门获取挂号类型列表 */
		function getBranch(id) {
			$.ajax({
				url : "${ctx}/webweb/sicmedRegistered/type?BranchId=" + id,
				type : 'POST',
				dataType : 'json ',
				success : function(data) {
					$("#sicmedRegistrationTypeId").empty();
					$("#sicmedDoctorId").empty();
					$("#sicmedRegistrationTypeId").find("option").remove();
					$.each(data, function(key, value) {
						if (key == 'sicmedRegisteredTypeBeans') {
							$("#sicmedRegistrationTypeId").append(
									"<option value=" + " " + ">" + "--请选择--"
											+ "</option>")
							$.each(value, function(key2, value2) {

								$("#sicmedRegistrationTypeId")
										.append(
												"<option value=" + value2.id + ">"
														+ value2.typeName
														+ "</option>");
							})
						}
					})
				},
			});
		}
	</script>
	<script type="text/javascript">
		/* 通过所选挂号类型获取价格 tempPrice=挂号类型id*/
		function getDoctor(id) {
			var tempPrice = document.getElementById("sicmedRegistrationTypeId").value;
			var branch = document.getElementById("sicmedBranchId").value;
			var chajia = ${sicmedRegistered.sicmedRegistrationType.sicmedRegisteredPrice.clinicsFee };
			
			$
					.ajax({
						url : "${ctx}/webweb/sicmedRegistered/price?typeId="
								+ tempPrice,
						type : 'POST',
						dataType : 'json',
						success : function(data) {
							var tempPrice = document
									.getElementById("clinicsFeeId");
							var tempPrice1 = document
									.getElementById("materialFeeId");
							var tempPrice2 = document
									.getElementById("registeredFeeId");
							var tempPrice3 = document.getElementById("sum");
							var tempPrice4 = document
									.getElementById("difference");
							tempPrice.value = data.clinicsFee;
							tempPrice1.value = data.materialFee;
							tempPrice2.value = data.registeredFee;
							tempPrice3.value = parseInt(data.clinicsFee)
									+ parseInt(data.materialFee)
									+ parseInt(data.registeredFee);
							tempPrice4.value = parseInt(chajia)
									- parseInt(data.clinicsFee);
						},

					});
			/* 通过所选挂号类型获取对应医生下拉菜单 tempPrice=挂号类型id  branch = 所选科室id  */
			$.ajax({
				url : "${ctx}/webweb/sicmedRegistered/doctor?typeId="
						+ tempPrice + "&branchId=" + branch,
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					$.each(data, function(key, value) {
						$("#sicmedDoctorId").empty();
						if (key == 'sicmedUserBeans') {
							$("#sicmedDoctorId").append(
									"<option value=" + " " + ">" + "--请选择--"
											+ "</option>")
							$.each(value, function(key2, value2) {
								$("#sicmedDoctorId")
										.append(
												"<option value=" + value2.id + ">"
														+ value2.userName
														+ "</option>");
							})
						}
					})

				},

			});
		}
	</script>
</body>
</html>

