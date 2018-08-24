<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="/jeesite/static/bootstrap3/js/testsendor/jquery-3.1.0.min.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"></script>
<script src="/jeesite/static/sicmedEEC/sicmedEEC.js"
	type="text/javascript"></script>
<title>挂号窗口</title>
</head>
<body>
	<%-- <div
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100px; background-color: #39A0ED; text-align: center">
		<h1>挂号窗口</h1>
	</div>
	<div
		style="position: absolute; top: 100px; left: 0px; width: 10%; height: 740px; background-color: #545454">
		<div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/gridLayout"
						style="color: white">挂号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/" style="color: gray">改号</a>
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
			<ul class="nav nav-tabs">
				<li class="active"><a
					href="${ctx}/webweb/sicmedRegistered/gridLayout">挂号</a></li>
			</ul>
		</div>
		<br> <br>
		<form id="searchForm" action="${ctx}/webweb/sicmedRegistered/save"
			method="post" class="breadcrumb form-search">
			<br>
			<br>
			<div class="container">
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">患者编号：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" name="sicmedPatient.patientNumber"
								onkeyup="this.value=this.value.replace(/[^\d]/g,'')"
								required>
						</div>
					</div>
				
				</div>
				<br>
				<div class="row">

					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">姓名：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" name="sicmedPatient.patientName"
								onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')"
								required>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">性别：</label>
						</div>
						<div class="col-xs-8">
							男 <input type="radio" name="sicmedPatient.patientSex" checked="checked" value="男" /> &nbsp
							&nbsp &nbsp &nbsp 女 <input type="radio" 
								name="sicmedPatient.patientSex" value="女"/>
						</div>
					</div>
				</div>
				<br>
				<div class="row">

					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">年龄：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" name="sicmedPatient.patientAge"
								onkeyup="this.value=this.value.replace(/[^\d]/g,'')" required>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">身份证号：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" name="sicmedPatient.patientCard"
								onkeyup="this.value=this.value.replace(/[^\d]/g,'')" >
						</div>
					</div>
				</div>
			</div>
			<br> <br>
			<div class="container">



				<div class="row">
					<!-- <div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px;color:red">患者编号：</label>
						</div>
						<div class="col-xs-8">
							<input class="text" name="sicmedPatient.patientNumber" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" required>
						</div>
					</div> -->
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px; color: red">挂号科室：</label>
						</div>
						<div class="col-xs-8">
							<select class="selectpicker" id="sicmedBranchId"
								onchange="getBranch(this.value)" name="sicmedBranch.id"
								style="width: 120px; height: 26px" required>
								<%-- <option >${sicmedBranch.branchName }</option> --%>
								<option value="">--请选择--</option>
								<c:forEach items="${sicmedBranch}" var="sicmedBranch">
									<option value="${sicmedBranch.id }">${sicmedBranch.branchName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">挂号医生：</label>
						</div>
						<div class="col-xs-8">
							<select id="sicmedDoctorId" name="sicmedDoctor.id"
								class="selectpicker" style="width: 120px; height: 26px">
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
						<div class="col-xs-8">
							<select class="selectpicker" id="sicmedRegistrationTypeId"
								name="sicmedRegistrationType.id" onchange="getDoctor(this)"
								style="width: 120px; height: 26px" required>
							</select>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">付费类型：</label>
						</div>
						<div class="col-xs-8">
							<select id="type" name="type"
								class="selectpicker" style="width: 120px; height: 26px">
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
						<div class="col-xs-8">
							<input class="text" id="registeredFeeId"
								style="width: 60px; height: 26px;"
								name="sicmedRegistered.sicmedRegisteredType.sicmedRegisteredPrice.registeredFee"
								readonly>&nbsp &nbsp 元
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">费用小计：</label>
						</div>
						<div class="col-xs-8">
							<input class="text" name="registeredPric" id="sum"
								style="width: 60px; height: 26px;" readonly>&nbsp &nbsp
							元
						</div>
					</div>
				</div>

				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">工本费：</label>
						</div>
						<div class="col-xs-8">
							<input class="text" id="materialFeeId"
								style="width: 60px; height: 26px;"
								name="sicmedRegistered.registeredPric.materialFee" readonly>&nbsp
							&nbsp 元
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">实收金额:</label>
						</div>
						<div class="col-xs-8">
							<input class="text" id="price" name="price"
								onchange="getPrice(this.value)">
						</div>
					</div>
				</div>

				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">诊疗费：</label>
						</div>
						<div class="col-xs-8">
							<!-- alert(tempPrice); -->
							<input class="text" id="clinicsFeeId"
								style="width: 60px; height: 26px;" readonly>&nbsp &nbsp
							元
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">找零：</label>
						</div>
						<div class="col-xs-8">
							<input class="text" name="zhaoling" id="zhaoling"
								style="width: 60px; height: 26px;" readonly>&nbsp &nbsp
							元
						</div>
					</div>
				</div>
				<br> <br> <br>&nbsp &nbsp
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
						<input type="hidden" name="sicmedRegistered.createUser">
						${sicmedRegistered.createUser.userName}
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<br> <br>
				<div class="row">
					<div class="col-xs-8"></div>
					<div class="col-xs-3">
						<input id="searchForm" type="submit" value="保存"
							class="btn btn-info">
					</div>
				</div>
			</div>
			<!-- </form> -->
		</form>
	</div>
	<script type="text/javascript">
		function getPrice(price){
			 var price=document.getElementById("price").value;
			 var sum = document.getElementById("sum").value;
			 var zhaoling = document.getElementById("zhaoling");
			 zhaoling.value = price-sum;
			 
		}
	</script>
	<script type="text/javascript">
		/* function getType(id) {
			var x = document.getElementById("sicmedRegistrationTypeId");
			alert(x);
			alert(id);
		} */
		function getBranch(id) {
			$.ajax({
				url : "${ctx}/webweb/sicmedRegistered/type?BranchId=" + id,
				type : 'POST',
				dataType : 'json ',
				success : function(data) {
					$("#sicmedRegistrationTypeId").empty();
					$("#sicmedDoctorId").empty();
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
		function getDoctor(id) {
			var tempPrice = document.getElementById("sicmedRegistrationTypeId").value;
			var branch = document.getElementById("sicmedBranchId").value;
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
							tempPrice.value = data.clinicsFee;
							tempPrice1.value = data.materialFee;
							tempPrice2.value = data.registeredFee;
							tempPrice3.value = parseInt(data.clinicsFee)
									+ parseInt(data.materialFee)
									+ parseInt(data.registeredFee);

						},

					});
			$.ajax({
				url : "${ctx}/webweb/sicmedRegistered/doctor?typeId="
						+ tempPrice + "&branchId=" + branch,
				type : 'POST',
				dataType : 'json',
				success : function(data) {
					$("#sicmedDoctorId").empty();
					$.each(data, function(key, value) {
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