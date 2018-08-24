<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	 $(document).ready(function() {
		alert("111111111111");
	}
	var xmlhttp;
	var data;
	function createXMLHttpRequest() {
		// 如果是IE浏览器，采用该方式生成XMLHttpRequest对象
		if (window.ActiveXObject) {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} else if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}
	}
	function selec(parm, parm2) {
		t_mp = parm2;
		g = ++t_mp;
		//alert(g+t_mp);
		while (g < 5) {
			dws = "dw" + g;
			dwt = "sel" + g;
			var dw = document.getElementById(dws);
			var se = document.getElementById(dwt);
			dw.style.display = (dw.style.display == "none") ? "none" : "none";
			se.options[se.selectedIndex].value = "-1";
			g++;
		}
		if (parm == "-1") {
			return;
		} else {
			var url = "reg_action.jsp?parm=" + escape(parm);
			var cpro_psid = "u2572954";
			var cpro_pswidth = 966;
			var cpro_psheight = 120;
			createXMLHttpRequest();
			xmlhttp.onreadystatechange = handleStateChange;
			xmlhttp.open("GET", appendTimestamp(url), true);
			xmlhttp.send(null);
		}
	}
	function appendTimestamp(url) {
		if (url.indexOf("?") > 0) {
			return url + "&ajax_time=" + new Date().getTime();
		} else {
			return url + "?ajax_time=" + new Date().getTime();
		}
	}
	function handleStateChange() {
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.status == 200) {
				data = xmlhttp.responseText;
				da_ta = data.split(",");
				dwstr = "dw" + t_mp;
				var dw = document.getElementById(dwstr);

				sestr = "sel" + t_mp;
				var se = document.getElementById(sestr);
				count = da_ta.length;
				//alert(count);
				if (count != 1) {
					dw.style.display = (dw.style.display == "none") ? "block"
							: "block";
				} else {
					dw.style.display = (dw.style.display == "none") ? "none"
							: "none";
				}
				for (i = 0; i < (count - 1) / 2; i++) {
					se.options[i + 1] = new Option(da_ta[(count - 1) / 2 + i],
							da_ta[i]);
				}

				if (i <= se.options.length) {
					se.options.length = i + 1;
				}
			}
		}
	}  
</script>
<body>
	<table>
		<tr>
			<td height="22">
				<div align="center">名称：</div>
			</td>
			<td width="26%" align="left">
				<div align="left">
					<select name="dw" onChange='selec(this.value,"1")'>
						<option selected value="-1">--请选择--</option>
					</select>                                           
				</div>
			</td>
			<td width="18%" align="left">      
				<div id="dw2" style="display: none">
					<select name="sel2" id="sel2" onChange='selec(this.value,"2")'>
						<option value="-1">--请选择--</option>
					</select>
				</div>
			</td>
			<td width="20%" align="left">      
				<div id="dw3" style="display: none">
					<select name="sel3" id="sel3" onChange='selec(this.value,"3")'>
						<option value="-1">--请选择--</option>
					</select>
				</div>
			</td>
			<td width="21%" align="left"> 
				<div id="dw4" style="display: none">
					<select name="sel4" id="sel4" onChange='selec(this.value,"4")'>
						<option value="-1">--请选择--</option>
					</select>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>