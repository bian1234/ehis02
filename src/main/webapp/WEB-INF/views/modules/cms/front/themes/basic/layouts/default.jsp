<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

<link href="static/bootstrap-3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script src="static/bootstrap-3.3.7/js/testsendor/jquery.min.js"
	type="text/javascript"></script>
<script src="static/bootstrap-3.3.7/dist/js/bootstrap.js"
	type="text/javascript"></script>
<script src="static/bootstrap-3.3.7/dist/js/bootstrap.min.js"></script>

<title>挂号窗口</title>
</head>
<body>
	<div
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100px; background-color: #39A0ED; text-align: center">
		<h1>挂号窗口</h1>
	</div>
	<div
		style="position: absolute; top: 100px; left: 0px; width: 10%; height: 900px; background-color: #545454">
		<div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/jeesite/f">挂号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/jeesite/a/webweb/sicmedRegistered/change">改号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a href="${ctx}/jeesite/a/webweb/sicmedRegistered/back">退号</a>
				</h2>
			</div>
		</div>
	</div>
	<div style="position: absolute; top: 100px; left: 20%; height: 600px;">

		<div class="header">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand"
							href="${ctx}/jeesite/a/webweb/sicmedRegistered/">挂号列表</a> <a
							class="navbar-brand" href="${ctx}/jeesite/f">挂号</a>
					</div>
				</div>
			</nav>
			<!--</div>-->
		</div>
		<br> <br>
		<form id="searchForm" action="${ctx}/jeesite/a/webweb/sicmedRegistered/save"
			method="post" class="breadcrumb form-search">
			<div class="container">
				<label style="background-color: deepskyblue; font-size: 20px">基本信息:</label>
				<hr
					style="height: 3px; border: none; border-top: 3px solid lightskyblue; margin-top: 0px">

				<div class="row">

					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">姓名：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" name="sicmedPatient.patientName">
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-4">
							<label style="font-size: 15px">性别：</label>
						</div>
						<div class="col-xs-8">
							<select name="sicmedPatient.patientSex" class="selectpicker"
								style="width: 120px; height: 26px">
								<option>男</option>
								<option>女</option>
							</select>
						</div>
					</div>
				</div>
				<br>
				<div class="row">

					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">年龄：</label>
						</div>
						<div class="col-xs-9">
							<input class="text" name="sicmedPatient.patientAge">
						</div>
					</div>
				</div>
			</div>

			<div class="container">


				<label style="background-color: deepskyblue; font-size: 20px">挂号信息</label>
				<hr
					style="height: 3px; border: none; border-top: 3px solid lightskyblue; margin-top: 0px">

				<div class="row">
					<div class="col-xs-6">
						<div class="col-xs-3">
							<label style="font-size: 15px">患者编号：</label>
						</div>
						<div class="col-xs-8">
							<input class="text" name="sicmedPatient.patientNumber">
						</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-4">
							<label style="font-size: 15px">挂号科室：</label>
						</div>
						<div class="col-xs-8">
						<select class="selectpicker" id="sicmedBranchId" onchange="getSicmedRegisteredType(this.value)"
							name="sicmedBranch.id" style="width: 120px; height: 26px" >
							<%-- <option >${sicmedBranch.branchName }</option> --%>
							<option value="">--请选择--</option>
							<c:forEach items="${sicmedBranch}" var="sicmedBranch">
								<option value="${sicmedBranch.id }">${sicmedBranch.branchName}</option>
							</c:forEach>
						</select>
					</div>
					</div>
				</div>
				<br>
				<div class="row">
					<div class="col-xs-6">
					<div class="col-xs-3">
						<label style="font-size: 15px">挂号类型：</label>
					</div>
					<div class="col-xs-8">
						<select class="selectpicker" id="sicmedRegistrationTypeId"
							name="sicmedRegistrationType.id"
							style="width: 120px; height: 26px">
							<option value="">--请选择--</option>
							<c:forEach items="${sicmedRegistrationType}" var="sicmedRegistrationType">
								<option value="${sicmedRegistrationType.id }">${sicmedRegistrationType.nameChina}</option>
							</c:forEach>
						</select>
					</div>
					</div>
					<div class="col-xs-6">
						<div class="col-xs-4">
							<label style="font-size: 15px">医生：</label>
						</div>
						<div class="col-xs-8">
						<select id="sicmedDoctorId" name="sicmedDoctor.id"
							class="selectpicker" style="width: 120px; height: 26px">
							<option>--请选择--</option>
							<c:forEach items="${sicmedDoctor}" var="sicmedDoctor">
								<option value="${sicmedDoctor.id}">${sicmedDoctor.userName}</option>
							</c:forEach>							
						</select>
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
						<input class="text"
							name="sicmedRegistered.registeredPric.materialFee" value="5"
							style="background-color: dodgerblue">
					</div>
				</div>
				<div class="col-xs-6">
					<div class="col-xs-4">
						<label style="font-size: 15px">挂号费：</label>
					</div>
					<div class="col-xs-8">
						<input class="text"
							name="sicmedRegistered.sicmedRegisteredType.sicmedRegisteredPrice.registeredFee" value="6"
							style="background-color: dodgerblue">
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
						<input class="text"
							name="sicmedRegistered..registeredPric.clinicsFee" value="${sicmedRegisteredPrice.clinicsFee }"
							style="background-color: dodgerblue">
					</div>
				</div>
				<div class="col-xs-6">
					<div class="col-xs-4">
						<label style="font-size: 15px">应收金额：</label>
					</div>
					<div class="col-xs-8">
						<input class="text" name="registeredPric"
							style="background-color: dodgerblue">
					</div>
				</div>
			</div>
		</div>
			<div class="container">
				<br> <br>
				<hr
					style="height: 3px; border: none; border-top: 3px solid lightskyblue; margin-top: 0px">
				<div class="row">
					<div class="col-xs-8"></div>
					<div class="col-xs-4">
						<input id="inputForm" type="submit" value="保存" class="btn btn-info">
					</div>
				</div>
			</div>
			<!-- </form> -->
		</form>
	</div>
	<script type="text/javascript">
	$.ajax({  
		  
	    type:"get",  
	    dataType:"json",  
	    contentType:"application/json;charset=utf-8",  
	    url:"/webweb/sicmedRegistered/branch",  
	    success:function(result){  
	            $.each(result,function(index,value){  
	              
	                    $("#sicmedBranchId").append("<option value='"+value.yxdm+"'>"+value.yxmc>+"</option>");  
	  
	            })  
	    },  
	    error : function(XMLHttpRequest, textStatus, errorThrown) {  
	                alert(errorThrown);  
	            },  
	    async:false             //false表示同步  
	});  
	
		/* $("#sicmedBranchId").click(function(){
			$.ajax({
				type: "post",
				cache: false,
				url: "${ctx}/webweb/sicmedRegistered/branch",
				data: "",
				dataType:"text",
				success:function(data){
						alert("清除记录成功");
					},
					error:function(){
						alert("清除记录失败");
						}
					});
			}); */

	</script>
	<!--科室对应挂号类型ajax 	 <script type="text/javascript">
	function getSicmedRegisteredType(sicmedB){
		$.ajax({
			url: "${ctx}/webweb/sicmedRegistered/type?BranchId="+sicmedBranchId.value,
			type:'POST',
			dataType:'text',
			success:function(data){
				 $("#sicmedRegistrationTypeId").empty();
				 $(data).each(function(i,data){
				 $("#sicmedRegistrationTypeId").sppend("<option value=" + sicmedRegistrationType.id + ">" +sicmedRegistrationType.nameChina + "</option>");	 
				 });
			},
		});
	}
</script> -->
	
</body>
</html>