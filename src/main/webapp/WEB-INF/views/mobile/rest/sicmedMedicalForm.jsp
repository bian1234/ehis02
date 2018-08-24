<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>药品管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				rules:{
					medicalCode:{
						isNumberAndEng:true
					},
					medicalGroup:{
						isPositiveInt:true
					},
					medicalNameChina:{
						isEngAndChi:true
					},
					medicalNamePinyin:{
						isEnglish:true
					},
					medicalCompany:{
						isEngAndChi:true
					},
					medicalApprovalNumber:{
						isNumberAndEng:true
					}
					
					
				},
				message:{
					medicalGroup:{
						isPositiveInt:"请输入正确数字格式"
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
		<li><a href="${ctx}/web/sicmedMedical/">药品列表</a></li>
		<li class="active"><a href="${ctx}/web/sicmedMedical/form?id=${sicmedMedical.id}">药品<shiro:hasPermission name="rest:sicmedMedical:edit">${not empty sicmedMedical.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:sicmedMedical:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sicmedMedical" action="${ctx}/web/sicmedMedical/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">药品开始日期：</label>
			<div class="controls">
				<input name="medicalFrdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${sicmedMedical.medicalFrdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品截止日期：</label>
			<div class="controls">
				<input name="medicalTodate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${sicmedMedical.medicalTodate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品编号：</label>
			<div class="controls">
				<form:input path="medicalCode" htmlEscape="false" maxlength="32" class="input-xlarge required"/><span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">药品所属类别：</label>
			<div class="controls">
				<form:input path="medicalGroup" htmlEscape="false" maxlength="2" class="input-xlarge "/>
			</div>
		</div> --%>
		<%-- <div class="control-group">
			<label class="control-label">药品所属类别：</label>
			<div class="controls">
				<sys:treeselect id="parent" 
					name="medicalClassOne.id" value="${sicmedMedical.medicalClassOne.id}" labelName="medicalClassOne.name" labelValue="${sicmedMedical.medicalClassOne.name}"
					title="父级编号" url="/web/sicmedMedical/treeData" extId="${medicalClassOne.id}" cssClass="required" allowClear="true"/>
				<font color="red">*</font>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">药品名称：</label>
			<div class="controls">
				<form:input path="medicalNameChina" htmlEscape="false" maxlength="100" class="input-xlarge required"/><span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品英文名：</label>
			<div class="controls">
				<form:input path="medicalNameEnglish" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">拼音缩写：</label>
			<div class="controls">
				<form:input path="medicalNamePinyin" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品进价：</label>
			<div class="controls">
				<form:input path="medicalPrice.priceEnter" htmlEscape="false" maxlength="11" min="0" class="input-xlarge required"/><span class="help-inline"><font color="red">*</font> </span>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品售价：</label>
			<div class="controls">
				<form:input path="medicalPrice.priceSale" htmlEscape="false" maxlength="11" min="0" class="input-xlarge required"/><span class="help-inline"><font color="red">*</font> </span>
				
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品详情：</label>
			<div class="controls">
				<form:input path="detail" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品规格：</label>
			<div class="controls">
				<form:input path="medicalStand" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用药频次：</label>
			<div class="controls">
				<form:input path="medicalUseNumber" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单次剂量：</label>
			<div class="controls">
				<form:input path="medicalMeasure" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">给药途径：</label>
			<div class="controls">
				<form:input path="medicalUse" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单位：</label>
			<div class="controls">
				<form:input path="unit1" htmlEscape="false" maxlength="5" class="input-xlarge required"/><span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单位2：</label>
			<div class="controls">
				<form:input path="unit2" htmlEscape="false" maxlength="10" class="input-xlarge required"/><span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品厂商：</label>
			<div class="controls">
				<form:input path="medicalCompany" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">药品类别编号：</label>
			<div class="controls">
				<form:input path="medicalClassOne.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div> 
		<div class="control-group">
			<label class="control-label">治疗类别：</label>
			<div class="controls">
				<sys:treeselect id="parent" 
					name="sicmedCureClass.id" value="${sicmedCureCheck.sicmedCureClass.id}" labelName="sicmedCureClass.className" labelValue="${sicmedCureCheck.sicmedCureClass.className}"
					title="父级编号" url="/web/sicmedCureCheck/treeData" extId="${sicmedCureCheck.sicmedCureClass.id}" cssClass="required" allowClear="true"/>
			</div>
		</div>
		--%>
		<div class="control-group">
			<label class="control-label">药品所属类别一级：</label>
			<div class="controls">
				<sys:treeselect id="medicalClassOne" 
					name="medicalClassOne.id" value="${sicmedMedical.medicalClassOne.id}"   labelName="medicalClassOne.name" labelValue="${sicmedMedical.medicalClassOne.name}"
					title="父级编号" url="/web/sicmedMedical/treeData" extId="${sicmedMedical.medicalClassOne.id}" cssClass="required" allowClear="true"/>
				<font color="red">*</font>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品所属类别二级：</label>
			<div class="controls">
				<sys:treeselect id="medicalClassTwo" 
					name="medicalClassTwo.id" value="${sicmedMedical.medicalClassTwo.id}" labelName="medicalClassTwo.name" labelValue="${sicmedMedical.medicalClassTwo.name}"
					title="父级编号" url="/web/sicmedMedical/treeData" extId="${medicalClassTwo.id}" allowClear="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药品所属类别三级：</label>
			<div class="controls">
				<sys:treeselect id="medicalClassThree" 
					name="medicalClassThree.id" value="${sicmedMedical.medicalClassThree.id}" labelName="medicalClassThree.name" labelValue="${sicmedMedical.medicalClassThree.name}"
					title="父级编号" url="/web/sicmedMedical/treeData" extId="${medicalClassThree.id}" allowClear="true"/>
				
			</div>
		</div>
		<%-- <div class="control-group">
			<label class="control-label">medical_class_id_two：</label>
			<div class="controls">
				<form:input path="medicalClassTwo.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">medical_class_id_three：</label>
			<div class="controls">
				<form:input path="medicalClassThree.id" htmlEscape="false" maxlength="32" class="input-xlarge "/>
			</div>
		</div> --%>
		<div class="control-group">
			<label class="control-label">成分：</label>
			<div class="controls">
				<form:input path="medicalIngredient" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">性状：</label>
			<div class="controls">
				<form:input path="medicalTraits" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">适应症：</label>
			<div class="controls">
				<form:textarea path="medicalIndications" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalIndications" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">规格：</label>
			<div class="controls">
				<form:input path="medicalSpecification" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用法用量：</label>
			<div class="controls">
				<form:textarea path="medicalDosageUsage" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalDosageUsage" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">不良反应：</label>
			<div class="controls">
				<form:textarea path="medicalAdverseReactions" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalAdverseReactions" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">禁忌：</label>
			<div class="controls">
				<form:textarea path="medicalTaboo" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalTaboo" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">注意事项：</label>
			<div class="controls">
				<form:textarea path="medicalPrecautions" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalPrecautions" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">孕妇及哺乳期妇女用药：</label>
			<div class="controls">
				<form:textarea path="medicalPregnantWomenLactatingWomen" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalPregnantWomenLactatingWomen" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">儿童用药：</label>
			<div class="controls">
				<form:textarea path="medicalPediatricUse" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalPediatricUse" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">老年用药：</label>
			<div class="controls">
				<form:textarea path="medicalElderlyMedication" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalElderlyMedication" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药物相互作用：</label>
			<div class="controls">
				<form:textarea path="medicalMedicineInteractions" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalMedicineInteractions" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药物过量：</label>
			<div class="controls">
				<form:textarea path="medicalDrugOverdose" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalDrugOverdose" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">临床试验：</label>
			<div class="controls">
				<form:input path="medicalClinicalTrials" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药理毒理：</label>
			<div class="controls">
				<form:textarea path="medicalPharmacologyToxicology" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalPharmacologyToxicology" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">药代动力学：</label>
			<div class="controls">
				<form:textarea path="medicalPharmacokinetics" htmlEscape="false" rows="4" class="input-xxlarge "/>
				<%-- <form:input path="medicalPharmacokinetics" htmlEscape="false" class="input-xlarge "/> --%>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">包装：</label>
			<div class="controls">
				<form:input path="medicalPackage" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">有效期：</label>
			<div class="controls">
				<form:input path="medicalPeriodValidity" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">执行标准：</label>
			<div class="controls">
				<form:input path="medicalImplementationStandards" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">批准文号：</label>
			<div class="controls">
				<form:input path="medicalApprovalNumber" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">生产企业：</label>
			<div class="controls">
				<form:input path="medicalManufacturer" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">储藏：</label>
			<div class="controls">
				<form:input path="medicalStorage" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="200" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<%-- <shiro:hasPermission name="web:sicmedMedical:edit"> --%><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/><%-- &nbsp;</shiro:hasPermission> --%>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>