<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<link
	href="/jeesite/static/bootstrap3/dist/css/bootstrap-datetimepicker.min.css"
	type="text/css" rel="stylesheet" />
<script
	src="/jeesite/static/bootstrap3/dist/js/jquery-3.1.0.min.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"
	type="text/javascript"></script>

<script
	src="/jeesite/static/bootstrap3/dist/js/bootstrap-datetimepicker.fr.js"
	type="text/javascript"></script>
<script
	src="/jeesite/static/bootstrap3/dist/js/bootstrap-datetimepicker.js"
	type="text/javascript"></script>

<title>退号窗口</title>
</head>
<body>
	<%-- <div
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100px; background-color: #39A0ED; text-align: center">
		<h1>退号窗口</h1>
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
					<a href="${ctx}/webweb/sicmedRegistered/" style="color: gray">改号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/webweb/sicmedRegistered/backList"
						style="color: white">退号</a>
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
						<a class="navbar-brand"
							href="${ctx}/webweb/sicmedRegistered/backList">退号列表</a> <a
							class="navbar-brand" href="${ctx}/webweb/sicmedRegistered/back">退号</a>
					</div>
				</div>
			</nav>
		</div>
		<br> <br>
		<form id="inputForm"
			action="${ctx}/jeesite/a/webweb/sicmedRegistered/delete">
			<br>
			<div class="container" style="background-color: #f5f5f5">
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">患者编号：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedPatient.patientNumber}</div>
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
							<label style="font-size: 15px">姓名：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedPatient.patientName}</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">性别：</label>
						</div>
						<div class="col-xs-8">
							${sicmedRegistered.sicmedPatient.patientSex}</div>
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
							<label style="font-size: 15px">年龄：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedPatient.patientAge}</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">身份证号：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedPatient.patientCard}</div>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">挂号科室：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedBranch.branchName}</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">挂号医生：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedDoctor.userName}</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">挂号类型：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedRegistrationType.nameChina}</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">付费类型：</label>
						</div>
						<div class="col-xs-8">自费</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">诊疗费：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedRegistrationType.sicmedRegisteredPrice.clinicsFee }
							&nbsp元</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">退费小计：</label>
						</div>
						<div class="col-xs-9">
							${sicmedRegistered.sicmedRegistrationType.sicmedRegisteredPrice.clinicsFee }&nbsp
							元</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">实收金额:</label>
						</div>
						<div class="col-xs-8">
							<input class="text" id="price" name="price"
								style="width: 60px; height: 26px;"
								onchange="getPrice(this.value)"> &nbsp 元
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">找零：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" id="zhaoling"
								style="width: 60px; height: 26px;" name="registeredPric"
								readonly> &nbsp 元
						</div>
					</div>
				</div>

				<br> <br> <br>&nbsp &nbsp
				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<input type="radio" name="sicmedPatient" />&nbsp 打印退号凭证
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-2">
							<label style="font-size: 15px">收费员:</label>
						</div>
						<div class="col-xs-8">${sicmedRegistered.createUser.userName}</div>
					</div>
				</div>
			</div>
			<br>
			<div class="container">
				<br>
				<div class="row">
					<div class="col-xs-8"></div>
					<div class="col-xs-4">
						<!--   <button type="button" class="btn btn-info">退号(T)</button> -->
						<input id="inputForm" type="submit" class="btn btn-info"
							value="退号">
					</div>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function getPrice(price) {
			var zhaoling = document.getElementById("zhaoling");
			var sum = ${sicmedRegistered.sicmedRegistrationType.sicmedRegisteredPrice.clinicsFee }
			zhaoling.value = parseInt(price) - parseInt(sum);
		}
	</script>
</body>
</html>