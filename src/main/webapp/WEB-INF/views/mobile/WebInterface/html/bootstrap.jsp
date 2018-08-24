<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>在线尝试 Bootstrap 实例</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link href="${ctxStatic}/Pc/css/example-fluid-layout.css" type="text/css" rel="stylesheet" />
    <script src="${ctxStatic}/Pc/js/jquery-3.1.0.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/Pc/js/bootstrap.min.js" type="text/javascript"></script>

    <link href="${ctxStatic}/Pc/css/bootstrap-table.min.css" type="text/css" rel="stylesheet" />
    <script src="${ctxStatic}/Pc/js/bootstrap-table-editable.js" type="text/javascript"></script>
	<script src="${ctxStatic}/Pc/js/bootstrap-table.js" type="text/javascript"></script>

    <link href="${ctxStatic}/Pc/css/bootstrap-select.min.css" type="text/css" rel="stylesheet" />
    <script src="${ctxStatic}/Pc/js/bootstrap-select.js" type="text/javascript"></script>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">Overview</a></li>
                <li><a href="#">Reports</a></li>
                <li><a href="#">Analytics</a></li>
                <li><a href="#">Export</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">Nav item</a></li>
                <li><a href="">Nav item again</a></li>
                <li><a href="">One more nav</a></li>
                <li><a href="">Another nav item</a></li>
                <li><a href="">More navigation</a></li>
            </ul>
            <ul class="nav nav-sidebar">
                <li><a href="">Nav item again</a></li>
                <li><a href="">One more nav</a></li>
                <li><a href="">Another nav item</a></li>
            </ul>
        </div>
        <!--<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">-->
            <!--<h1 class="page-header">Dashboard</h1>-->

            <!--<div class="row placeholders">-->
                <!--<div class="col-xs-6 col-sm-3 placeholder">-->
                    <!--<img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">-->
                    <!--<h4>Label</h4>-->
                    <!--<span class="text-muted">Something else</span>-->
                <!--</div>-->
                <!--<div class="col-xs-6 col-sm-3 placeholder">-->
                    <!--<img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">-->
                    <!--<h4>Label</h4>-->
                    <!--<span class="text-muted">Something else</span>-->
                <!--</div>-->
                <!--<div class="col-xs-6 col-sm-3 placeholder">-->
                    <!--<img data-src="holder.js/200x200/auto/sky" class="img-responsive" alt="Generic placeholder thumbnail">-->
                    <!--<h4>Label</h4>-->
                    <!--<span class="text-muted">Something else</span>-->
                <!--</div>-->
                <!--<div class="col-xs-6 col-sm-3 placeholder">-->
                    <!--<img data-src="holder.js/200x200/auto/vine" class="img-responsive" alt="Generic placeholder thumbnail">-->
                    <!--<h4>Label</h4>-->
                    <!--<span class="text-muted">Something else</span>-->
                <!--</div>-->
            <!--</div>-->

            <!--<h2 class="sub-header">Section title</h2>-->
            <!--<div class="table-responsive">-->
            <!--</div>-->
        <!--</div>-->
    </div>
</div>

<!--1-->
<table class="table  table-bordered" id="para_table">
    <tr>
        <th style="text-align:center" width="200">名称</th>
        <th style="text-align:center" width="200">值</th>
        <th style="text-align:center" width="100">操作</th>
        <th style="text-align:center" width="200">名称</th>
        <th style="text-align:center" width="200">值</th>
        <th style="text-align:center" width="100">操作</th>
    </tr>
    <tr>
        <td  style="text-align:center; " onclick="tdclick(this)"></td>
        <td  style="text-align:center; " onclick="tdclick(this)"></td>
        <td  style="text-align:center; " onclick="tdclick(this)"></td>
        <td  style="text-align:center; " onclick="tdclick(this)"></td>
        <td  style="text-align:center; " onclick="tdclick(this)"></td>
        <td  style="text-align:center; " onclick="deletetr(this)">
            <button type="button"  class="btn btn-xs btn-link">删除</button>
        </td>
    </tr>
</table>

<div id="addtrdiv" style="margin-top:-15px; width: 15%; float: right;">
    <button type="button" class="btn btn-xs btn-link" onclick="addtr()">添加</button>
</div>



<div class="form-group">
    <label class="col-sm-3 control-label">客资类型：</label>
    <div class="col-sm-4">
        <select id="usertype" name="usertype" class="selectpicker show-tick form-control" multiple data-live-search="false">
            <!--<option value="0"></option>-->
            <option value="1">感冒</option>
            <option value="2">肠炎</option>

        </select>
    </div>
</div>
</body>

</html>
<script>
    $(window).on('load', function () {
        $('#usertype').selectpicker({
            'selectedText': 'cat'
        });
    });
    </script>
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
        var table = $("#para_table");
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
        var table = $("#para_table");
        var tr= $("<tr>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
                "<td  onclick='tdclick(this)'>"+"</td>" +
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
</script>
