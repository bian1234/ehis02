<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.css" type="text/css" rel="stylesheet" />
	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<script src="/jeesite/static/jquery/jquery-1.9.1.min.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>
	<title>疾病列表</title>
	<style type="text/css">
	
	*{
/* 	border: 1px solid red; */
	}
	/* 圆  */
 	.round{
 	border:#fff;
 	 text-align:center;
	 width:20px;
	 height:20px;
	 border-radius:20px
 }
 .row div{
 text-align:center;
 }
	</style>
</head>
<body style="overflow-x: hidden;">
<div class="row">
	<div id="medical_list_body" class="col-xs-4">
	<label>药品名称:</label>
	</div>
	<div id="medical_list_body" class="col-xs-2">
	</div>
	<div id="medical_list_body" class="col-xs-6">
	<label>${sicmedMedical.medicalNameChina}</label>
	</div>
</div>
<div class="row">
	<div class="col-xs-4">
	<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;剂型:</label>	
	</div>
	<div class="col-xs-2">
	</div>
	<div id="medical_list_body" class="col-xs-6">
	<label id="useBun_lable"><c:if test="${empty sicmedMedical.unit1}">${sicmedMedical.unit2}</c:if>${sicmedMedical.unit1}</label>
	</div>
</div>
<div class="row">
	<div class="col-xs-4">
	<label>给药途径:</label>
	</div>
	<div class="col-xs-2">
	</div>
	<div class="col-xs-6">
	<label>
		<select id="useGroup_lable">
			<option value="口服">口服</option>
			<option value="舌下给药">舌下给药</option>
			<option value="直肠给药">直肠给药</option>
			<option value="静脉滴注">静脉滴注</option>
			<option value="饭后服用">饭后服用</option>
			<option value="肌内注射">肌内注射</option>
			<option value="皮下注射">皮下注射</option>
			<option value="滴眼">滴眼</option>
			<option value="鼻腔喷雾">鼻腔喷雾</option>
			<option value="口腔喷雾">口腔喷雾</option>
			<option value="皮肤局部(表面)用药">皮肤局部(表面)用药</option>
			<option value="身(经皮)用药">身(经皮)用药</option>
		</select>
	</label>
	</div>
</div>
<div class="row">
	<div class="col-xs-4">
	<label>单次剂量:</label>
	</div>
	<div class="col-xs-2">
	<span id="useAmount_lable_less" class="round glyphicon glyphicon-minus"></span>
	</div>
	<div class="col-xs-2">
	<label id="useAmount_lable">0</label>
	</div>
	<div class="col-xs-2">
	<label id="useUnit_lable"><c:if test="${empty sicmedMedical.unit1}">${sicmedMedical.unit2}</c:if>${sicmedMedical.unit1}</label>
	</div>
	<div id="useAmount_lable_plus" class="col-xs-2">
	<span class="round glyphicon glyphicon-plus"></span>
	</div>
</div>
<div class="row">
	<div class="col-xs-4">
	<label>每日次数:</label>
	</div>
	<div class="col-xs-2">
	<span id="useBout_lable_less" class="round glyphicon glyphicon-minus"></span>
	</div>
	<div class="col-xs-2">
	<label id="useBout_lable">0</label>
	</div>
	<div class="col-xs-2">
	<label>次</label>
	</div>
	<div class="col-xs-2">
	<span id="useBout_lable_plus" class="round glyphicon glyphicon-plus"></span>
	</div>
</div>
<div class="row">
	<div class="col-xs-4">
	<label>用药天数:</label>
	</div>
	<div class="col-xs-2">
	<span id="useDay_lable_less" class="round glyphicon glyphicon-minus"></span>
	</div>
	<div class="col-xs-2">
	<label id="useDay_lable">0</label>
	</div>
	<div class="col-xs-2">
	<label>天</label>
	</div>
	<div class="col-xs-2">
	<span id="useDay_lable_plus" class="round glyphicon glyphicon-plus"></span>
	</div>
</div>

<div class="row">
	<div class="col-xs-3">
	</div>
	<div class="col-xs-3">
	<div class="btn-group dropup">
		<button id="medical_asked_submit" type="button" class="btn btn-default">保存医嘱</button>
	</div>
	</div>
	<div class="col-xs-3">
	<div class="btn-group dropup">
		<button id="" type="button" class="btn btn-default"></button>
	</div>
	</div>
	<div class="col-xs-3">
	</div>
</div>
<div style="display: none;">
		<input id="medicalId_h" type="text" value="${sicmedMedical.id}">
		<form id="medical_asked_form" >
			<input id="useBun_h" type="text" value="<c:if test="${empty sicmedMedical.unit1}">${sicmedMedical.unit2}</c:if>${sicmedMedical.unit1}">
			<input id="useGroup_h" type="text" value="口服">
			<input id="useAmount_h" type="text" value="0">
			<input id="useUnit_h" type="text" value="<c:if test="${empty sicmedMedical.unit1}">${sicmedMedical.unit2}</c:if>${sicmedMedical.unit1}">
			<input id="useBout_h" type="text" value="0">
			<input id="useDay_h" type="text" value="0">
		</form>
</div>
<!-- 获取所有可以诊疗的患者信息 -->	
<script type="text/javascript">
var ssid = parent.getSSID();
var pageno = 1;
$(document).ready(function(){
	var useAmount = "0";
	var useBout = "0";
	var useDay = "0";
	
	$("#useAmount_lable_less").click(function(){
		if(useAmount == 0){
			return;
		}
		useAmount = useAmount - 1;
		$("#useAmount_h").val(useAmount)
		$("#useAmount_lable").html(useAmount);
	});
	
	$("#useAmount_lable_plus").on("click",function(){
		
		useAmount = parseInt(useAmount) + 1;
		$("#useAmount_h").val(useAmount)
		$("#useAmount_lable").html(useAmount);
	});
	
	$("#useBout_lable_less").on("click",function(){
		if(useBout == 0){
			return;
		}
		
		useBout = useBout - 1;
		$("#useBout_h").val(useBout)
		$("#useBout_lable").html(useBout);
	});
	
	$("#useBout_lable_plus").on("click",function(){
		useBout = parseInt(useBout) + 1;
		$("#useBout_h").val(useBout)
		$("#useBout_lable").html(useBout);
	});
	
	$("#useDay_lable_less").on("click",function(){
		if(useDay == 0){
			return;
		}
		useDay = useDay - 1;
		$("#useDay_h").val(useDay)
		$("#useDay_lable").html(useDay);
	});
	
	$("#useDay_lable_plus").on("click",function(){
		useDay = parseInt(useDay) + 1;
		$("#useDay_h").val(useDay)
		$("#useDay_lable").html(useDay);
	});
	
	$("#useGroup_lable").on("change",function(){
		var useGroup = $("#useGroup_lable").val();
		$("#useGroup_lable_h").html(useGroup);
	})
})
	
	$(function(){
		$("#medical_asked_submit").click(function(){
			xx();
		});
	})
	function xx(){
	//var medicalUseStr = $("#medical_asked_form").serialize();
	
	var useBun = $("#useBun_h").val();
	var useGroup = $("#useGroup_h").val();
	var useAmount = $("#useAmount_h").val();
	var useUnit = $("#useUnit_h").val();
	var useBout = $("#useBout_h").val();
	var useDay = $("#useDay_h").val();
	
	var medicalUseStr = "useBun="+useBun+"&useGroup="+useGroup+"&useAmount="+useAmount+"&useUnit="+useUnit+"&useBout="+useBout+"&useDay="+useDay
	var askedClassId =  parent.getMedicalAskedId();
	var orderCode = $("#medicalId_h").val();
	
	alert(medicalUseStr);
	
	parent.addAsked(orderCode,askedClassId,medicalUseStr);
}
</script>
</body>
</html>