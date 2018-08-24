<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>病历单</title>
    <link href="${ctxStatic}/Pc/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link href="${ctxStatic}/Pc/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />
    <script src="${ctxStatic}/Pc/js/jquery-3.1.0.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/Pc/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/Pc/js/bootstrap-datetimepicker.fr.js" type="text/javascript"></script>
	<script src="${ctxStatic}/Pc/js/bootstrap-datetimepicker.js" type="text/javascript"></script>

    <style type="text/css">
        .scrollspy-example {
            height: 200px;
            overflow: auto;
            position: relative;
        }
    </style>

</head>
<body>
	<form:form id="inputForm" modelAttribute="sicmedCase" action="${ctx}/webweb/sicmedCase/save" method="post" class="form-horizontal">
<div class="header">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${ctx}/webweb/sicmedRegistered/medicalRecord">病历单</a>
            </div>
            <div class="navbar-header">
                <a class="navbar-brand" href="${ctx}/webweb/sicmedRegistered/elePrescription">电子处方</a>
            </div>
        </div>
    </nav>
    <!--</div>-->
</div>

<br>
<div class="container">
    <div class="col-xs-9">
        <label style="font-size: 20px">主述</label>
    </div>
    <div class="col-xs-3">
        <button type="button" class="btn btn-info">将当前病历保存为模板</button>
    </div>
    <br><br>

        <div class="row">
            <textarea name="caseTell" data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example" style="width: 1170px;height:100px;margin:auto">
             </textarea>
        </div>

    <br>

    <label style="font-size: 20px">体检</label>
    <div class="row" style="background-color:#ffffff;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
        <br>
          <div class="col-xs-2">
             <label>T</label>
              <input class="text" style="width: 100px">
             <label>℃</label>
          </div>
          <div class="col-xs-2" >
              <label>P</label>
              <input class="text" style="width: 100px">
              <label>次/分</label>
          </div>
          <div class="col-xs-2">
              <label>R</label>
              <input class="text" style="width: 100px">
              <label>次/分</label>
          </div>
          <div class="col-xs-6">
              <label>Bp</label>
              <input class="text" style="width: 100px">
              /
              <input class="text" style="width: 100px">
              <label>mmHg</label>
          </div>
        <br>
    </div>
    <div class="row">
            <textarea data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example" style="width: 1170px;height:70px;margin:auto">
             </textarea>
    </div>
    <label style="background-color:#ffffff;font-size: 20px">诊断</label>
    <!--<hr style="height:3px;border:none;border-top:3px  solid lightskyblue;margin-top: 0px">-->

    <div class="row" style="background-color:#ffffff;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;" style="width:100px;height:100px;margin-left: 0px;margin-right: 0px">
        <div class="row">

            <div data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example" style="width: 1170px;margin:auto">

                <table id="para_table2" class="table table-bordered" style="width: 1170px;margin:auto">
                    <tr style="padding-left: 0px;margin-left: 0px">
                        <th style="">序号</th>
                        <th>编码</th>
                        <th>疾病名称</th>
                        <th>操作&nbsp;&nbsp;&nbsp;&nbsp;(<button type="button" class="btn btn-xs btn-link" onclick="addtr()">添加</button>)</th>
                    </tr>
                    <tr>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="deletetr(this)">
                            <button type="button"  class="btn btn-xs btn-link">删除</button>

                        </td>
                    </tr>
                </table>
            </div>
            <!--1-->
            <!--<div class="col-xs-3">-->
            <!--</div>-->
            <!--<div class="col-xs-3">-->
            <!--</div>-->
        </div>
    </div>
    <div class="row">
            <textarea data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example" style="width: 1170px;height:70px;margin:auto">
             </textarea>
    </div>
    <br>

    <label style="background-color:#ffffff;font-size: 20px">处理意见</label>
    <!--<hr style="height:3px;border:none;border-top:3px  solid lightskyblue;margin-top: 0px">-->

    <div class="row" style="background-color:#ffffff;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;" style="width:100px;height:100px;margin-left: 0px;margin-right: 0px">
        <div class="row">

            <div data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example" style="width: 1170px;margin:auto">

                <table id="para_table3" class="table table-bordered" style="width: 1170px;margin:auto">
                    <tr style="padding-left: 0px;margin-left: 0px">
                        <th style="">序号</th>
                        <th>计划名称</th>
                        <th>内容</th>
                        <th>操作&nbsp;&nbsp;&nbsp;&nbsp;(<button type="button" class="btn btn-xs btn-link" onclick="addtr1()">添加</button>)</th>
                    </tr>
                    <tr>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="deletetr(this)">
                            <button type="button"  class="btn btn-xs btn-link">删除</button></td>

                    </tr>
                </table>
            </div>
            <!--1-->
            <!--<div class="col-xs-3">-->
            <!--</div>-->
            <!--<div class="col-xs-3">-->
            <!--</div>-->
        </div>
    </div>
    <div class="row">
            <textarea data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example" style="width: 1170px;height:70px;margin:auto">
             </textarea>
    </div>
    <br>

    <div class="row">
        <div class="col-xs-2">
           <!--  <button type="button" class="btn btn-info">保存病历(F5)</button> -->
           <input id="inputForm" type="submit" value="保存病例" class="btn btn-info">
        </div>
        <div class="col-xs-2" >
            <button type="button" class="btn btn-info">开处方(F6)</button>
        </div>
        <div class="col-xs-2" >
            <button type="button" class="btn btn-info">模板(F7)</button>
        </div>
        <div class="col-xs-2" >
            <button type="button" class="btn btn-info">打印</button>
        </div>
        <div class="col-xs-2" >
            <!--<button type="button" class="btn btn-info">添加行(F9)</button>-->
        </div>
        <div class="col-xs-2" >
            <!--<button type="button" class="btn btn-info">删除行(F10)</button>-->
        </div>
    </div>


</div>
</form:form>
</body>
</html>

<script>
    function save_para_table(){

        var tableinfo = gettableinfo();
        alert(tableinfo);
    }
    //get table infomation
    function gettableinfo(){
        var key = "";
        var value = "";
        var tabledata = "";
        var table = $("#para_table2");
        var table1 = $("#para_table3");
        var tbody = table.children();
        var trs = tbody.children();
        for(var i=1;i<trs.length;i++){
            var tds = trs.eq(i).children();
            for(var j=0;j<tds.length;j++){
                if(j==0){
                    if(tds.eq(j).text()==null||tds.eq(j).text()==""){
                        return null;
                    }
                    key = "key\":\""+tds.eq(j).text();
                }
                if(j==1){
                    if(tds.eq(j).text()==null||tds.eq(j).text()==""){
                        return null;
                    }
                    value = "value\":\""+tds.eq(j).text();
                }
            }
            if(i==trs.length-1){
                tabledata += "{\""+key+"\",\""+value+"\"}";
            }else{
                tabledata += "{\""+key+"\",\""+value+"\"},";
            }
        }
        tabledata = "["+tabledata+"]";
        return tabledata;
    }

    function tdclick(tdobject){
        var td=$(tdobject);
        td.attr("onclick", "");
        //1,取出当前td中的文本内容保存起来
        var text=td.text();
        //2,清空td里面的内容
        td.html(""); //也可以用td.empty();
        //3，建立一个文本框，也就是input的元素节点
        var input=$("<input>");
        //4，设置文本框的值是保存起来的文本内容
        input.attr("value",text);
        input.bind("blur",function(){
            var inputnode=$(this);
            var inputtext=inputnode.val();
            var tdNode=inputnode.parent();
            tdNode.html(inputtext);
            tdNode.click(tdclick);
            td.attr("onclick", "tdclick(this)");
        });
        input.keyup(function(event){
            var myEvent =event||window.event;
            var kcode=myEvent.keyCode;
            if(kcode==13){
                var inputnode=$(this);
                var inputtext=inputnode.val();
                var tdNode=inputnode.parent();
                tdNode.html(inputtext);
                tdNode.click(tdclick);
            }
        });

        //5，将文本框加入到td中
        td.append(input);
        var t =input.val();
        input.val("").focus().val(t);
//              input.focus();

        //6,清除点击事件
        td.unbind("click");
    }
    function addtr(){
        var table = $("#para_table2");
        var tr= $("<tr>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  align='center' onclick='deletetr(this)'><button type='button'  class='btn btn-xs btn-link' >"+"删除"+"</button></td></tr>");
        table.append(tr);
    }
    function deletetr(tdobject){
        var td=$(tdobject);
        td.parents("tr").remove();
    }


    //    1
    function addtr1(){
        var table = $("#para_table3");
        var tr= $("<tr>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  align='center' onclick='deletetr(this)'><button type='button'  class='btn btn-xs btn-link' >"+"删除"+"</button></td></tr>");
        table.append(tr);
    }
    function deletetr1(tdobject){
        var td=$(tdobject);
        td.parents("tr").remove();
    }
    
</script>

