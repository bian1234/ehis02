<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page import="com.thinkgem.jeesite.modules.cfq.mobile.rest.entity.*"%>
<%@ page import="java.util.List"%>
<html>
<head>
<title>收费处</title>
<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<meta name="decorator" content="default" />
<script type="text/javascript"> 
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
</script>
	<%
	Double checkPrice = 0.00;
	Double inspectPrice = 0.00;
	Double medicalPrice = 0.00;
	Double curePrice = 0.00;
	List<SicmedPatientPrice> checkPriceList = (List<SicmedPatientPrice>) request.getAttribute("checkList");
	List<SicmedPatientPrice> inspectPriceList = (List<SicmedPatientPrice>) request.getAttribute("inspectList");
	List<SicmedPatientPrice> medicalPriceList = (List<SicmedPatientPrice>) request.getAttribute("medicalList");
	List<SicmedPatientPrice> curePriceList = (List<SicmedPatientPrice>) request.getAttribute("cureList");
	
%>
</head>

<body>
	<div id="patientDetail" class="row"
		style="margin-left: 5pt; margin-bottom: 5pt; margin-top: -15pt">
		<div id="functionDetail" class="col-xs-12 col-sm-12"
			style="padding-bottom: 90%">
			<div class="row">
				<div class="col-xs-12 col-sm-12" style="margin-top: 20pt">
					<ul class="nav nav-tabs"><!--"${ctx}/web/user/sicmedPatient/list"  -->
						<c:choose>
							<c:when test="${isPay=='0'}">
								<li><a id="patientList" href="${ctx}/web/user/sicmedPatient/list">患者列表</a></li>
								<li class="active"><a href="">收费详情</a></li>
							</c:when>
							<c:otherwise>
								<li><a id="patientList" href="${ctx}/web/useRefunds/sicmedPatient/list">患者列表</a></li>
								<li class="active"><a href="">退费详情</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
				<div class="col-xs-12 col-sm-12" style="margin-top: 10pt">
					<p class="col-xs-4 col-sm-4">姓&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp名:&nbsp${patient.patientName}</p>
					<p class="col-xs-4 col-sm-4">性&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp别:&nbsp${patient.patientSex}</p>
					<p class="col-xs-4 col-sm-4">年&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp龄:&nbsp${patient.patientAge}</p>
				</div>
				<div class="col-xs-12 col-sm-12" style="margin-top: 10pt">
					<p class="col-xs-4 col-sm-4">科&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp室:&nbsp${patient.sicmedBranch.branchName}</p>
					<p class="col-xs-4 col-sm-4">患者编号:&nbsp${patient.patientNumber}</p>
					<!-- <p class="col-xs-4 col-sm-4">日&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp期:&nbsp${patient.patientFirstdate}</p> -->
					<p class="col-xs-4 col-sm-4">日&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp期:&nbsp${firstDate}</p>
				</div>

				<div class="col-xs-12 col-sm-12" style="margin-top: 10pt">
					<table class="table" >
						<c:if test="${checkList.size()>0}" >
							<thead<%-- class=<%= checkPriceList.size()>0?"show":"hidden"%> --%>>
								<tr style="margin-right: 5pt">
									<!-- <td style="color: #8BC7F5; font-size: 25px; margin-right: 25pt;padding-top: 20pt">检验收费</td> -->
									<th
										style="color: #8BC7F5; font-size: 25px; margin-right: 25pt; padding-top: 20pt">检验收费</th>
									<th></th>
									<th></th>
								</tr>
								<tr>
									<th style="color: #525252">收费名称详情</th>
									<th style="color: #525252">收费项目价格</th>
									<th style="color: #525252">收费状态</th>
								</tr>
							</thead>
							<tbody<%-- class=<%= checkPriceList.size()>0?"show":"hidden" %> --%>>
								<c:forEach items="${checkList}" var="sicmedPatientPrice"
									varStatus="tempIndex">
									<tr>
										<td style="color: #D4D4D4">${sicmedPatientPrice.priceName}</td>
										<td style="color: #D4D4D4">${sicmedPatientPrice.price}</td>
										<td style="color: #D4D4D4">${sicmedPatientPrice.payType}</td>
									</tr>
								</c:forEach>
								<%
									for (SicmedPatientPrice tempPatientPrice : checkPriceList) {
											checkPrice += Double.valueOf(tempPatientPrice.getPrice());
										}
										;
								%>
								<tr>
									<td>
										<!-- border-color: gray;border-width: 1pt;height: 10pt;width: 10pt -->
										<button id="checkPriceBtn" name="isSelect" type="button"
											class="btn"
											style="background-color: orange; border-color: gray"
											onclick="selectButtom(this)" value=<%=checkPrice%>></button>
									</td>
									<td></td>
									<td>小计:<span id="checkPriceSpan" style="color: orange;"><%=checkPrice%></span>元
									</td>
								</tr>
							</tbody>
						</c:if>
						<c:if test="${inspectList.size()>0}" >
							<thead  <%-- class=<%= inspectPriceList.size()>0?"show":"hidden" %> --%> style="border-color: black;">
							<tr style="height: 50pt">
								<th style="color: #8BC7F5; font-size: 25px;padding-top: 20pt;">检查收费</th>
								<th></th>
								<th></th>
							</tr>
							<tr>
								<th style="width:50%;color: #525252">收费名称详情</th>
								<th style="width:25%;color: #525252">收费项目价格</th>
								<th style="width:25%;color: #525252">收费状态</th>
							</tr>
						</thead>
						<tbody <%-- class=<%= inspectPriceList.size()>0?"show":"hidden" %> --%>>
							<c:forEach items="${inspectList}" var="sicmedPatientPrice">
								<tr>
									<td style="color: #D4D4D4">${sicmedPatientPrice.priceName}</td>
									<td style="color: #D4D4D4">${sicmedPatientPrice.price}</td>
									<td style="color: #D4D4D4">${sicmedPatientPrice.payType}</td>
								</tr>
							</c:forEach>
							<%
									for (SicmedPatientPrice tempPatientPrice : inspectPriceList) {
									inspectPrice += Double.valueOf(tempPatientPrice.getPrice());
									} ;
							%>
							<tr>
								<td>
									<!-- border-color: gray;border-width: 1pt;height: 10pt;width: 10pt -->
									<button id="inspectPriceBtn" name="isSelect" type="button" class="btn"
										style="background-color: orange; border-color: gray"
										onclick="selectButtom(this)" value=<%=inspectPrice%>></button>
								</td>
								<td></td>
								<td>小计:<span id="inspectPriceSpan" style="color: orange;"><%=inspectPrice%></span>元
								</td>
							</tr>
						</tbody>
						</c:if>	
						<c:if test="${cureList.size()>0}" >
							<thead <%-- class=<%= curePriceList.size()>0?"show":"hidden" %> --%>>
							<tr style="height: 50pt">
								<td style="color: #8BC7F5; font-size: 25px;padding-top: 20pt">治疗收费</th>
								<th></th>
								<th></th>
							</tr>
							<tr>
								<th style="color: #525252">收费名称详情</th>
								<th style="color: #525252">收费项目价格</th>
								<th style="color: #525252">收费状态</th>
							</tr>
						</thead>
						<tbody <%-- class=<%= curePriceList.size()>0?"show":"hidden" %> --%>>
							<c:forEach items="${cureList}" var="sicmedPatientPrice">
								<tr>
									<td style="color: #D4D4D4">${sicmedPatientPrice.priceName}</td>
									<td style="color: #D4D4D4">${sicmedPatientPrice.price}</td>
									<td style="color: #D4D4D4">${sicmedPatientPrice.payType}</td>
								</tr>
							</c:forEach>
							<%
								for (SicmedPatientPrice tempPatientPrice : curePriceList) {
									curePrice += Double.valueOf(tempPatientPrice.getPrice());
								} ;
							%>
							<tr>
								<td>
									<!-- border-color: gray;border-width: 1pt;height: 10pt;width: 10pt -->
									<button id="curePriceBtn" name="isSelect" type="button" class="btn"
										style="background-color: orange; border-color: gray"
										onclick="selectButtom(this)" value=<%=curePrice%>></button>
								</td>
								<td></td>
								<td>小计:<span id="curePriceSpan" style="color: orange;"><%=curePrice%></span>元
								</td>
							</tr>
						</tbody>
						</c:if>	
						
						<c:if test="${medicalList.size()>0}" >
							<thead<%-- class=<%= medicalPriceList.size()>0?"show":"hidden" %> --%>>
								<tr style="height: 50pt">
									<th
										style="color: #8BC7F5; font-size: 25px; margin-right: 25pt; padding-top: 20pt">药品收费</th>
									<th></th>
									<th></th>
								</tr>
								<tr>
									<th style="color: #525252">收费名称详情</th>
									<th style="color: #525252">收费项目价格</th>
									<th style="color: #525252">收费状态</th>
								</tr>
							</thead>
							<tbody<%-- class=<%= medicalPriceList.size()>0?"show":"hidden" %> --%>>

								<c:forEach items="${medicalList}" var="sicmedPatientPrice">
									<tr>
										<td style="color: #D4D4D4">${sicmedPatientPrice.priceName}</td>
										<td style="color: #D4D4D4">${sicmedPatientPrice.price}</td>
										<td style="color: #D4D4D4">${sicmedPatientPrice.payType}</td>
									</tr>
								</c:forEach>
								<%
									for (SicmedPatientPrice tempPatientPrice : medicalPriceList) {
											medicalPrice += Double.valueOf(tempPatientPrice.getPrice());
										}
										;
								%>
								<tr>
									<td>
										<!-- border-color: gray;border-width: 1pt;height: 10pt;width: 10pt -->
										<button id="medicalPriceBtn" name="isSelect" type="button"
											class="btn"
											style="background-color: orange; border-color: gray"
											onclick="selectButtom(this)" value=<%=medicalPrice%>></button>
									</td>
									<td></td>
									<td>小计:<span id="medicalPriceSpan" style="color: orange;"><%=medicalPrice%></span>元
									</td>
								</tr>
								<tr>
									<%
										Double allPrice = 0.00;
									%>
									<%
										allPrice = medicalPrice + checkPrice + inspectPrice + curePrice;
									%>
									<td></td>
									<td></td>
									<%-- <%=medicalPrice+checkPrice+inspectPrice+curePrice%>
 --%>
									<td>总价:<span id="allPriceSpan" style="color: orange;"><%=allPrice%></span>元
									</td>
								</tr>
							</tbody>
						</c:if>
						
					</table>
					<c:choose>
						<c:when test="${medicalList.size()>0||checkList.size()>0||inspectList.size()>0||cureList.size()>0}">
							<button type="button" class="btn" style="margin-left: 68%;width: 60pt;border-width: 0.8pt;border-color: black;" onClick="payBtn(${isPay},'${patientId}')">${buttonValue}</button>
						</c:when>
						<c:otherwise>
							<h1 style="color: red"> 无相关信息  </h1>
						</c:otherwise>
					</c:choose>
					<%-- <c:if test="${medicalList.size()>0||checkList.size()>0||inspectList.size()>0||cureList.size()>0}">
						<button id="payBtn" type="button" class="btn" style="margin-left: 68%;width: 60pt;border-width: 0.8pt;border-color: black;" >${buttonValue}</button>
					</c:if> --%>
				</div>
			</div>
		</div>
	</div>
	<script
	src="/jeesite/static/bootstrap3/js/tests/vendor/jquery.min.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js"
	type="text/javascript"></script>
<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"></script>
	<script src="/jeesite/static/sicmedEEC/patientPriceDetail.js" type="text/javascript"></script>

</body>
</html>