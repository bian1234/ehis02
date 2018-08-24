<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<meta charset="utf-8">
	<link href="/jeesite/static/bootstrap3/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<script src="/jeesite/static/bootstrap3/js/testsendor/jquery.min.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js"></script>
	<title>退号列表</title>
	<meta name="decorator" content="default" />
	<script type="text/javascript">
		$(document).ready(function() {
	
		});
		function page(n, s) {
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
			return false;
		}
	</script>
</head>
<body><!-- class="col-xs-12 col-sm-12" -->
	<div class="col-xs-12 col-sm-12"
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100px; background-color: #39A0ED; text-align: center">
		<h1>挂号窗口</h1>${dateStr1}  ${sicmedUserBean.userName}
		<div class="collapse navbar-collapse col-xs-3 col-sm-3" id="example-navbar-collapse" style=" margin-top:30px;margin-right=10pt" >
				<ul class="nav navbar-nav">
					<li>
						<a class="navbar-brand" href="#"
					style="color:white; font-size:20px;margin-left:0pt">${dateStr1}</a>
					</li>
					<li>
						<a class="navbar-brand" href="#"
					style="color:white; font-size:25px">${sicmedUserBean.userName}</a>
					</li>

				</ul>
			</div>
	</div>
	<div class="col-xs-3 col-sm-3"
		style="position: absolute; top: 100px; left: 0px; width: 10%; height: 1200px; background-color: #545454">
		<div>
			<div style="text-align: center">
				<h2>
					<a id="gridLayout" onClick="gridLayoutOnClick(this)"
						style="color: white">挂号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a id="change" onClick="changeOnClick(this)" style="color: gray">改号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a id="back" onClick="backOnClick(this)" style="color: gray">退号</a>
				</h2>
			</div>
			<div style="text-align: center">
				<h2>
					<a id="find" onClick="findOnClick(this)" style="color: gray">查询</a>
				</h2>
			</div>
		</div>
	</div>
	<div class="col-xs-9 col-sm-9" style="position: absolute; top: 100px; left: 20%; height: 600px;">

		
		<div>
			<iframe id="functionDetail" class="col-xs-12 col-sm-12"
				style="height: 100%; border: hidden" scrolling="no"
				src="/jeesite/a/webweb/sicmedRegistered/gridLayout?doctor=${sicmedUserBean.id}"
				onload="endLoad(this)" name="${sicmedUserBean.userName}"> </iframe>
		</div>
	</div>
<!-- 	<script src="/jeesite/static/sicmedEEC/registeredList.js" type="text/javascript"></script> -->
	<script type="text/javascript">
		function endLoad(data){
			var obj = document.getElementById("functionDetail");  //取得父页面IFrame对象  
			 /*this.document.body.scrollHeight; .documentElement.scrollHeight*/
			var children = data.contentWindow.document;	//取到子页面对象
			var childrenDiv = children.getElementById("patientDetail");
			//alert(childrenDiv.offsetHeight);
			/* alert(data.style.height);
			alert(childrenHeight); */
			data.style.height = childrenDiv.offsetHeight+"px";
			if(childrenDiv.offsetHeight<300){			//左侧导航栏
				obj.style.height = "300px";
			}
			obj.style.height = childrenDiv.offsetHeight+"px";
		};
	</script>
	<script type="text/javascript">
	var gridLayout = "/jeesite/a/webweb/sicmedRegistered/gridLayout?doctor=${sicmedUserBean.id}";   //挂号
	var change = "/jeesite/a/webweb/sicmedRegistered/list?doctor=${sicmedUserBean.id}";       		//改号
	var back = "/jeesite/a/webweb/sicmedRegistered/backList?doctor=${sicmedUserBean.id}";           //退号
	var find = "/jeesite/a/webweb/sicmedRegistered/total";        		//查询
	

	//挂号点击事件
	function gridLayoutOnClick(data){
		if(data.style.color != "white"){
			var refundTitle = document.getElementById("find");
			refundTitle.style.color = "gray";
			var refundTitle = document.getElementById("change");
			refundTitle.style.color = "gray";
			var refundTitle = document.getElementById("back");
			refundTitle.style.color = "gray";
			
			//改变挂号颜色为白色
			data.style.color ="white";
			
			var refundTitle = document.getElementById("functionDetail");
			refundTitle.src = gridLayout;
		}
		
		
	};
	//改号点击事件
	function changeOnClick(data){
		if(data.style.color != "white"){
			var refundTitle = document.getElementById("find");
			refundTitle.style.color = "gray";
			var refundTitle = document.getElementById("gridLayout");
			refundTitle.style.color = "gray";
			var refundTitle = document.getElementById("back");
			refundTitle.style.color = "gray";
			
			//改变挂号颜色为白色
			data.style.color ="white";
			
			var refundTitle = document.getElementById("functionDetail");
			refundTitle.src = change;
			alert(doctor=${sicmedUserBean.id});
		}
	};
	//退号点击事件
	function backOnClick(data){
		if(data.style.color != "white"){
			var refundTitle = document.getElementById("find");
			refundTitle.style.color = "gray";
			var refundTitle = document.getElementById("change");
			refundTitle.style.color = "gray";
			var refundTitle = document.getElementById("gridLayout");
			refundTitle.style.color = "gray";
			
			//改变挂号颜色为白色
			data.style.color ="white";
			
			var refundTitle = document.getElementById("functionDetail");
			refundTitle.src = back;
		
		}
	};
	//查询点击事件
	function findOnClick(data){
		if(data.style.color != "white"){
			var refundTitle = document.getElementById("gridLayout");
			refundTitle.style.color = "gray";
			var refundTitle = document.getElementById("change");
			refundTitle.style.color = "gray";
			var refundTitle = document.getElementById("back");
			refundTitle.style.color = "gray";
			
			//改变挂号颜色为白色
			data.style.color ="white";
			
			var refundTitle = document.getElementById("functionDetail");
			refundTitle.src = find;
		}
	};

	</script>
</body>
</html>