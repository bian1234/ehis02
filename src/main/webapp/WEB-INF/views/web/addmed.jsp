<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>药品添加</title>
</head>
<body>
<form action="" id="med_form">
<input type="hidden" name="ssid" value="${sicmedUserBean.ssid}">
	<input type="text" name="str">
	<select id="medicalClassOne_s" name="medicalClassOne"></select>
	<select id="medicalClassTwo_s" name="medicalClassTwo"></select>
	<select id="medicalClassThree_s" name="medicalClassThree"></select>
	<input type="text" name="medicalGroup"  id="medicalGroup">
	<input type="text" name="code"  id="code">
</form>
	
	<button id="addMed">添加药品</button>
</body>
	<script src="/jeesite/static/jquery/jquery-1.9.1.min.js"  type="text/javascript"></script>
	<script type="text/javascript">
	
	function saveCase(){
//		var str = $("#med_form").serialize();//$ 序列化 表单  str 
		var jsonData = $("#med_form").serializeArray();//$ 序列化 表单 返回 json obj
			$.ajax({
			type : 'post',
			url : 'http://192.168.0.105:8082/jeesite/a/rest/sicmedMedical/addMedical',
			data : jsonData,
			cache : false,
			dataType : 'json',
			success : function(data) {
			console.log(data);
			},
			error : function() {
			}
			});
	}
	function getOneClass(){
		var str = $("#med_form").serialize();//$ 序列化 表单  str 
		console.log(str)
		//var jsonData = $("#case_form").serializeArray();//$ 序列化 表单 返回 json obj
		$.ajax({
			type : 'get',
			url : 'http://192.168.0.105:8082/jeesite/a/rest/sicmedMedicalClass/findOne',
			data : "ssid=${sicmedUserBean.ssid}",
			cache : false,
			dataType : 'json',
			success : function(data) {
			console.log(data);
			$.each(data,function(name, value) {
				$("#medicalClassOne_s").children().remove();
				if (name == "sicmedMedicalClassBeans") {
					$.each(value,function(name2,value2) {
						$("#medicalClassOne_s").append("<option value="+value2.id+">"+value2.className+"</option>");
					});
				}
			});
			},
			error : function() {
			}
			});
	}
	function getTwoClass(pid){
		$.ajax({
			type : 'get',
			url : 'http://192.168.0.105:8082/jeesite/a/rest/sicmedMedicalClass/findchild',
			data : "ssid=${sicmedUserBean.ssid}&pid="+pid,
			cache : false,
			dataType : 'json',
			success : function(data) {
			console.log(data);
			$.each(data,function(name, value) {
				$("#medicalClassTwo_s").children().remove();
				if (name == "sicmedMedicalClassBeans") {
					$.each(value,function(name2,value2) {
						$("#medicalClassTwo_s").append("<option value="+value2.id+">"+value2.className+"</option>");
					});
				}
			});
			},
			error : function() {
			}
			});
	}
	function getThreeClass(pid){
		$.ajax({
			type : 'get',
			url : 'http://192.168.0.105:8082/jeesite/a/rest/sicmedMedicalClass/findchild',
			data : "ssid=${sicmedUserBean.ssid}&pid="+pid,
			cache : false,
			dataType : 'json',
			success : function(data) {
			console.log(data);
			$.each(data,function(name, value) {
				$("#medicalClassThree_s").children().remove();
				if (name == "sicmedMedicalClassBeans") {
					$.each(value,function(name2,value2) {
						$("#medicalClassThree_s").append("<option value="+value2.id+">"+value2.className+"</option>");
					});
				}
			});
			},
			error : function() {
			}
			});
	}
	$("#medicalClassOne_s").change(function (){
		var pid = $(this).val();
		console.log(pid);
		getTwoClass(pid);
	})
	$("#medicalClassTwo_s").change(function (){
		var pid = $(this).val();
		console.log(pid);
		getThreeClass(pid);
	})
	$("#medicalClassOne").click(function (){
		saveCase();
	})
	
	$("#addMed").click(function (){
		saveCase();
	})
	$(document).ready(function(){
		getOneClass();
	})
	
	</script>
</html>