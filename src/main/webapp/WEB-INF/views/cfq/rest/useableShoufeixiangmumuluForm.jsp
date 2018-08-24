<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>收费项目目录管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
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
		<li><a href="${ctx}/rest/useableShoufeixiangmumulu/">收费项目目录列表</a></li>
		<li class="active"><a href="${ctx}/rest/useableShoufeixiangmumulu/form?id=${useableShoufeixiangmumulu.id}">收费项目目录<shiro:hasPermission name="rest:useableShoufeixiangmumulu:edit">${not empty useableShoufeixiangmumulu.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:useableShoufeixiangmumulu:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="useableShoufeixiangmumulu" action="${ctx}/rest/useableShoufeixiangmumulu/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">leibie：</label>
			<div class="controls">
				<form:input path="leibie" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">fenlei_id：</label>
			<div class="controls">
				<form:input path="fenleiId" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">bianma：</label>
			<div class="controls">
				<form:input path="bianma" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">name：</label>
			<div class="controls">
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">guige：</label>
			<div class="controls">
				<form:input path="guige" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">chandi：</label>
			<div class="controls">
				<form:input path="chandi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jisuandanwei：</label>
			<div class="controls">
				<form:input path="jisuandanwei" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">shuoming：</label>
			<div class="controls">
				<form:input path="shuoming" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">xiangmutexing：</label>
			<div class="controls">
				<form:input path="xiangmutexing" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">shoufeileixing：</label>
			<div class="controls">
				<form:input path="shoufeileixing" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">fuwuduixiang：</label>
			<div class="controls">
				<form:input path="fuwuduixiang" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">pingbifeibie：</label>
			<div class="controls">
				<form:input path="pingbifeibie" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">shifoubianjia：</label>
			<div class="controls">
				<form:input path="shifoubianjia" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jiabanjiajia：</label>
			<div class="controls">
				<form:input path="jiabanjiajia" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">buchongzhaiyao：</label>
			<div class="controls">
				<form:input path="buchongzhaiyao" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">feiyongqueren：</label>
			<div class="controls">
				<form:input path="feiyongqueren" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhixingkeshi：</label>
			<div class="controls">
				<form:input path="zhixingkeshi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">biaoshizhuma：</label>
			<div class="controls">
				<form:input path="biaoshizhuma" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">biaoshizima：</label>
			<div class="controls">
				<form:input path="biaoshizima" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">beixuanma：</label>
			<div class="controls">
				<form:input path="beixuanma" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zuidixiandu：</label>
			<div class="controls">
				<form:input path="zuidixiandu" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zuigaoxiane：</label>
			<div class="controls">
				<form:input path="zuigaoxiane" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jiandangshijian：</label>
			<div class="controls">
				<form:input path="jiandangshijian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">chedangshijian：</label>
			<div class="controls">
				<form:input path="chedangshijian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">luruxianliang：</label>
			<div class="controls">
				<form:input path="luruxianliang" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jisuanfangshi：</label>
			<div class="controls">
				<form:input path="jisuanfangshi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhandian：</label>
			<div class="controls">
				<form:input path="zhandian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">binganfeimu：</label>
			<div class="controls">
				<form:input path="binganfeimu" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">qiyongyuanyin：</label>
			<div class="controls">
				<form:input path="qiyongyuanyin" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">tingyongyuanyin：</label>
			<div class="controls">
				<form:input path="tingyongyuanyin" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:useableShoufeixiangmumulu:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>