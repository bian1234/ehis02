<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>药品管理</title>
	<meta name="decorator" content="default"/>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
	<style type="text/css">
	table{
		width:"600px";
　　		table-layout: fixed;
		width:100em;
	}
	td{
		white-space: nowrap;
		overflow: hidden;
		width:100%;
  		word-break:keep-all;/* 不换行 */
  		white-space:nowrap;/* 不换行 */
  		overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */
 		 text-overflow:ellipsis;/* 当对象内文本溢出时显示省略标记(...) ；需与overflow:hidden;一起使用。*/
}
</style>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/web/sicmedMedical/">药品列表</a></li>
		<shiro:hasPermission name="rest:sicmedMedical:edit"><li><a href="${ctx}/web/sicmedMedical/form">药品添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sicmedMedical" action="${ctx}/web/sicmedMedical/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>药品编号：</label>
				<form:input path="medicalCode" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>药品名称：</label>
				<form:input path="medicalNameChina" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>类别一级：</label>
				<sys:treeselect id="medicalClassOne" 
					name="medicalClassOne.id" value="${sicmedMedical.medicalClassOne.id}"   labelName="medicalClassOne.name" labelValue="${sicmedMedical.medicalClassOne.name}"
					title="父级编号" url="/web/sicmedMedical/treeData" extId="${sicmedMedical.medicalClassOne.id}" cssClass="required" allowClear="true"/>
			</li>
			<li><label>类别二级：</label>
				<sys:treeselect id="medicalClassTwo" 
					name="medicalClassTwo.id" value="${sicmedMedical.medicalClassTwo.id}"   labelName="medicalClassTwo.name" labelValue="${sicmedMedical.medicalClassTwo.name}"
					title="父级编号" url="/web/sicmedMedical/treeData" extId="${sicmedMedical.medicalClassTwo.id}" cssClass="required" allowClear="true"/>
			</li>
			<li><label>类别三级：</label>
				<sys:treeselect id="medicalClassThree" 
					name="medicalClassThree.id" value="${sicmedMedical.medicalClassThree.id}"   labelName="medicalClassThree.name" labelValue="${sicmedMedical.medicalClassThree.name}"
					title="父级编号" url="/web/sicmedMedical/treeData" extId="${sicmedMedical.medicalClassThree.id}" cssClass="required" allowClear="true"/>
			</li>
		
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/><!-- style="white-space:nowrap" --><!-- class="table table-striped table-bordered table-condensed" -->
	<table id="contentTable" class="table table-striped table-bordered table-condensed" >
		<thead>
			<tr>
				<th>药品编号</th>
				<th>药品开始日期</th>
				<th>药品截止日期</th>
				<th>药品所属类别编号</th>
				<th>药品名称</th>
				<th>药品英文名</th>
				<th>拼音简写</th>
				<th>药品售价</th>
				<th style="width: 100pt">药品详情</th>
				<th style="width: 100pt">药品规格</th>
				<th>用药频次</th>
				<th>单次剂量</th>
				<th>给药途径</th>
				<th>单位</th>
				<th>单位2</th>
				<th>药品厂商</th>
				<th>药品类别编号</th>
				<th>更新时间</th>
				<th>药品类别3</th>
				<th>成分</th>
				<th>性状</th>
				<th>适应症</th>
				<th>规格</th>
				<th>用法用量</th>
				<th>不良反应</th>
				<th>禁忌</th>
				<th>注意事项</th>
				<th>孕妇及哺乳期妇女用药</th>
				<th>儿童用药</th>
				<th>老年用药</th>
				<th>药物相互作用</th>
				<th>药物过量</th>
				<th>临床试验</th>
				<th>药理毒理</th>
				<th>药代动力学</th>
				<th>包装</th>
				<th>有效期</th>
				<th style="width: 100pt">执行标准</th>
				<th>批准文号</th>
				<th>生产企业</th>
				<th style="width: 100pt">储藏</th>
				<th>备注</th>
				<%-- <shiro:hasPermission name="web:sicmedMedical:edit"> --%><th>操作</th><%-- </shiro:hasPermission> --%>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sicmedMedical">
			<tr>
				<td >
				<a href="${ctx}/web/sicmedMedical/form?id=${sicmedMedical.id}">
					${sicmedMedical.medicalCode}</a>
				</td>
				<td>
					<fmt:formatDate value="${sicmedMedical.medicalFrdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${sicmedMedical.medicalTodate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedMedical.medicalClassOne.name}
				</td>
				<td>
					${sicmedMedical.medicalNameChina}
				</td>
				<td>
					${sicmedMedical.medicalNameEnglish}
				</td>
				<td>
					${sicmedMedical.medicalNamePinyin}
				</td>
				<td>
					${sicmedMedical.medicalPrice.priceSale}
				</td>
				<td>
					${sicmedMedical.detail}
				</td>
				<td>
					${sicmedMedical.medicalStand}
				</td>
				<td>
					${sicmedMedical.medicalUseNumber}
				</td>
				<td>
					${sicmedMedical.medicalMeasure}
				</td>
				<td>
					${sicmedMedical.medicalUse}
				</td>
				<td>
					${sicmedMedical.unit1}
				</td>
				<td>
					${sicmedMedical.unit2}
				</td>
				<td>
					${sicmedMedical.medicalCompany}
				</td>
				<td>
					${sicmedMedical.medicalClassOne.id}
				</td>
				<td>
					<fmt:formatDate value="${sicmedMedical.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${sicmedMedical.medicalClassTwo.id}
				</td>
				<td>
					${sicmedMedical.medicalIngredient}
				</td>
				<td>
					${sicmedMedical.medicalTraits}
				</td>
				<td>
					${sicmedMedical.medicalIndications}
				</td>
				<td>
					${sicmedMedical.medicalSpecification}
				</td>
				<td>
					${sicmedMedical.medicalDosageUsage}
				</td>
				<td>
					${sicmedMedical.medicalAdverseReactions}
				</td>
				<td>
					${sicmedMedical.medicalTaboo}
				</td>
				<td>
					${sicmedMedical.medicalPrecautions}
				</td>
				<td>
					${sicmedMedical.medicalPregnantWomenLactatingWomen}
				</td>
				<td>
					${sicmedMedical.medicalPediatricUse}
				</td>
				<td>
					${sicmedMedical.medicalElderlyMedication}
				</td>
				<td>
					${sicmedMedical.medicalMedicineInteractions}
				</td>
				<td>
					${sicmedMedical.medicalDrugOverdose}
				</td>
				<td width="100">
					${sicmedMedical.medicalClinicalTrials}
				</td>
				<td width="100">
					${sicmedMedical.medicalPharmacologyToxicology}
				</td>
				<td>
					${sicmedMedical.medicalPharmacokinetics}
				</td>
				<td>
					${sicmedMedical.medicalPackage}
				</td>
				<td>
					${sicmedMedical.medicalPeriodValidity}
				</td>
				<td>
					${sicmedMedical.medicalImplementationStandards}
				</td>
				<td>
					${sicmedMedical.medicalApprovalNumber}
				</td>
				<td>
					${sicmedMedical.medicalManufacturer}
				</td>
				<td>
					${sicmedMedical.medicalStorage}
				</td>
				<td>
					${sicmedMedical.remarks}
				</td>
				<%-- <shiro:hasPermission name="web:sicmedMedical:edit"> --%><td>
    				<a href="${ctx}/web/sicmedMedical/form?id=${sicmedMedical.id}">修改</a>
					<a href="${ctx}/web/sicmedMedical/delete?id=${sicmedMedical.id}" onclick="return confirmx('确认要删除该药品吗？', this.href)">删除</a>
				</td><%-- </shiro:hasPermission> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>