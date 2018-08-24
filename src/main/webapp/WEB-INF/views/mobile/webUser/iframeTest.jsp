<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>患者信息</title>
	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<script src="/jeesite/static/bootstrap3/js/tests/vendor/jquery.min.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"></script> 
	
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
</head>
<body>
	<nav class="navbar navbar-default" role="navigation"
		style="height:120px; background-color:#39A0ED;width:auto;min-width: 890pt">
		<div class="container-fluid">
			<div class="navbar-header col-xs-9 col-sm-9">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#example-navbar-collapse">
					<span class="sr-only">切换导航</span> <span class="icon-bar"></span> <span
						class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"
					style="color:white; font-size:40px; margin-top:30px; margin-left:30px">EHIS</a>
			</div>
			<div class="collapse navbar-collapse col-xs-3 col-sm-3" id="example-navbar-collapse" style=" margin-top:30px;margin-right=10pt" >
				<ul class="nav navbar-nav">
					<li>
						<a class="navbar-brand" href="#"
					style="color:white; font-size:20px;margin-left:0pt">${dateStr}</a>
					</li>
					<li>
						<a class="navbar-brand" href="#"
					style="color:white; font-size:25px">${sicmedUserBean.userName}</a>
					</li>

				</ul>
			</div>
		</div>
	</nav>
	
	<div class="row"
		style="margin-left:5pt; margin-bottom:5pt; margin-top:-15pt">
		<div id="functionList" class="col-xs-2 col-sm-2"
			style="background-color: #597082;min-width: 100pt;min-height: 300pt">
			<div style="height:20pt; margin-top:25pt">
				<h2 id="payTitle" class="text-center"  style="color: white" onClick="payOnClick(this)">收费</h2>
			</div>

			<div style="height:20pt; margin-top:25pt">
				<h2 id="refundTitle" class="text-center" style="color: gray" onClick="refundsOnClick(this)">退费</h2>				
			</div><!-- id="refundsOnClick" -->

			<div style="height:20pt; margin-top:25pt">
				<h2 id="searchTitle" class="text-center"  style="color: gray" onClick="searchOnClick(this)">查询</h2>
			</div>

		</div>
		<div class="col-xs-10 col-sm-10">
			<iframe id="functionDetail" class="col-xs-12 col-sm-12" style="height:100%;border: hidden;min-width: 900pt" scrolling="no"
				src="/jeesite/a/web/user/sicmedPatient"  onload="endLoad(this)"> </iframe>
		</div>
	</div>
	<script src="/jeesite/static/sicmedEEC/patientList.js" type="text/javascript"></script>
	<script type="text/javascript">
		function endLoad(data){
			var obj = document.getElementById("functionList");  //取得父页面IFrame对象  
			 /*this.document.body.scrollHeight; .documentElement.scrollHeight*/
			var children = data.contentWindow.document;	//取到子页面对象
			var childrenDiv = children.getElementById("patientDetail");
			//alert(data.style.minHeight);
			data.style.height = childrenDiv.offsetHeight+"px";
			data.style.width = childrenDiv.offsetWidth+"px";
			//alert(obj.style.height);
			if(childrenDiv.offsetHeight<300){			//左侧导航栏
				obj.style.height = "800px";
			}
			obj.style.height = childrenDiv.offsetHeight+"px";
			
		};
	</script>
</body>
</html>
