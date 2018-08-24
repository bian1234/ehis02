<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>人员表管理</title>
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
		<li><a href="${ctx}/rest/useableRenyuanbiao/">人员表列表</a></li>
		<li class="active"><a href="${ctx}/rest/useableRenyuanbiao/form?id=${useableRenyuanbiao.id}">人员表<shiro:hasPermission name="rest:useableRenyuanbiao:edit">${not empty useableRenyuanbiao.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="rest:useableRenyuanbiao:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="useableRenyuanbiao" action="${ctx}/rest/useableRenyuanbiao/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">biaoha：</label>
			<div class="controls">
				<form:input path="biaoha" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">bumenid：</label>
			<div class="controls">
				<form:input path="bumenid" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">xingming：</label>
			<div class="controls">
				<form:input path="xingming" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">bianma：</label>
			<div class="controls">
				<form:input path="bianma" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">shenfenzhenghao：</label>
			<div class="controls">
				<form:input path="shenfenzhenghao" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">chushengriqi：</label>
			<div class="controls">
				<form:input path="chushengriqi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">xingbie：</label>
			<div class="controls">
				<form:input path="xingbie" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">minzu：</label>
			<div class="controls">
				<form:input path="minzu" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">gongzuoriqi：</label>
			<div class="controls">
				<form:input path="gongzuoriqi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">bangongshidianhua：</label>
			<div class="controls">
				<form:input path="bangongshidianhua" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">dianziyoujian：</label>
			<div class="controls">
				<form:input path="dianziyoujian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhiyeleibie：</label>
			<div class="controls">
				<form:input path="zhiyeleibie" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhiyefanwei：</label>
			<div class="controls">
				<form:input path="zhiyefanwei" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhiyezhenghao：</label>
			<div class="controls">
				<form:input path="zhiyezhenghao" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">gulizhiwu：</label>
			<div class="controls">
				<form:input path="gulizhiwu" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhuanyejishuzhiwu：</label>
			<div class="controls">
				<form:input path="zhuanyejishuzhiwu" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">pinrenjishuzhiwu：</label>
			<div class="controls">
				<form:input path="pinrenjishuzhiwu" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">xueli：</label>
			<div class="controls">
				<form:input path="xueli" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">suoxuezhuanye：</label>
			<div class="controls">
				<form:input path="suoxuezhuanye" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">liuxueshijian：</label>
			<div class="controls">
				<form:input path="liuxueshijian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">liuxuequdao：</label>
			<div class="controls">
				<form:input path="liuxuequdao" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">jieshoupeixun：</label>
			<div class="controls">
				<form:input path="jieshoupeixun" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">keyanketi：</label>
			<div class="controls">
				<form:input path="keyanketi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">gerenjianjie：</label>
			<div class="controls">
				<form:input path="gerenjianjie" htmlEscape="false" maxlength="255" class="input-xlarge "/>
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
			<label class="control-label">chedangyuanyin：</label>
			<div class="controls">
				<form:input path="chedangyuanyin" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">bieming：</label>
			<div class="controls">
				<form:input path="bieming" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">qianming：</label>
			<div class="controls">
				<form:input path="qianming" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">qianmingtupian：</label>
			<div class="controls">
				<form:input path="qianmingtupian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zigezhengshuhao：</label>
			<div class="controls">
				<form:input path="zigezhengshuhao" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhiyekaishishijian：</label>
			<div class="controls">
				<form:input path="zhiyekaishishijian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">chufangquanbiaozhi：</label>
			<div class="controls">
				<form:input path="chufangquanbiaozhi" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">zhandian：</label>
			<div class="controls">
				<form:input path="zhandian" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">shoushudengji：</label>
			<div class="controls">
				<form:input path="shoushudengji" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="rest:useableRenyuanbiao:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>