<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>

<head>
	<!-- <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script> -->
  	<!-- <script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script> -->
  	<script src="/jeesite/static/jquery/jquery-1.9.1.min.js"  type="text/javascript"></script>
  	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="/jeesite/static/bootstrap3/dist/js/bootstrap.js" type="text/javascript"></script>
</head>

<body>	
	<div class="btn-group">
  		<h2>提示</h2>
		<p class="lead">
			启动新实例之后，原数据库数据将要清空，请谨慎操作
		</p>
	</div>
	<div class="btn-group">
  		<button id="clearButton" type="button" style="width:100px;height:50px;font-size:1em">
  			链接按钮
  		</button>
	</div>
	
	<script type="text/javascript">
		
		$("#clearButton").click(function(){
			$.ajax({
				type: "post",
				cache: false,
				url: "${ctx}/web/sicmedRestart/restartAllJDBC",
				data: "",
				dataType:"text",
				success:function(data){
					var tempMap = data;
					//alert(tempMap);
					if(data=="0"){
						alert("清除记录成功");
						}else{
							alert("清除记录失败1");
							} 
						//alert(data);
					},
					error:function(){
						alert("清除记录失败");
						}
					});
			});

	</script>
		
</body>
</html>