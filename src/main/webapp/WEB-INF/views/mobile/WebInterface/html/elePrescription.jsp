<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>电子处方</title>
    <script src="${ctxStatic}/Pc/js/jquery-3.1.0.min.js" type="text/javascript"></script>
    <script src="${ctxStatic}/Pc/js/bootstrap.min.js" type="text/javascript"></script>
    <link href="${ctxStatic}/Pc/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
    <link href="${ctxStatic}/Pc/css/bootstrap-datetimepicker.min.css" type="text/css" rel="stylesheet" />

    <script src="${ctxStatic}/Pc/js/bootstrap-datetimepicker.fr.js" type="text/javascript"></script>
	<script src="${ctxStatic}/Pc/js/bootstrap-datetimepicker.js" type="text/javascript"></script>

    <link href="${ctxStatic}/Pc/css/bootstrap-select.min.css" type="text/css" rel="stylesheet" />
    <script src="${ctxStatic}/Pc/js/bootstrap-select.js" type="text/javascript"></script>

    <style type="text/css">
        .scrollspy-example {
            height: 200px;
            overflow: auto;
            position: relative;
        }
    </style>

</head>
<body>
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

    <!--<label style="background-color:deepskyblue;font-size: 20px">基本信息</label>-->
    <!--<hr style="height:3px;border:none;border-top:3px  solid lightskyblue;margin-top: 0px">-->

    <div class="row" style="background-color:lightskyblue;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;" style="width:100px;height:100px">
        <br>
       <div class="row">
         <!--1-->
          <div class="col-xs-3">
              <div class="col-xs-4">
                  <label>门诊号</label>
              </div>
              <div class="col-xs-8">
                  <input class="text">
              </div>
          </div>
           <!--2-->
          <div class="col-xs-3">
              <button type="button" class="btn btn-info">新处方(F2)</button>
          </div>
           <!--3-->
           <div class="col-xs-3">
               <div class="col-xs-3">
                   <label>姓名</label>
               </div>
               <div class="col-xs-9">
                   <input class="text">
               </div>
           </div>
           <!--4-->
           <div class="col-xs-3">
               <div class="col-xs-3">
                   <label>性别</label>
               </div>
               <div class="col-xs-9">
                   <select style="width:100px;height:26px">
                       <option>男</option>
                       <option>女</option>
                   </select>
               </div>
           </div>

       </div>

       <div class="row">

           <!--6-->
           <div class="col-xs-3">
               <div class="col-xs-4">
                   <label>类别</label>
               </div>
               <div class="col-xs-8" style="width: 150px;height: 34px">
                   <select style="width:100px;height:26px">
                       <option>自费</option>
                       <option>公费</option>
                       <option>金卡会员</option>
                       <option>银卡会员</option>
                       <option>特殊用户</option>
                   </select>
               </div>
           </div>
           <!--5-->
           <div class="col-xs-3">
               <div class="col-xs-3">
                   <label>年龄</label>
               </div>
               <div class="col-xs-9">
                   <input class="text" style="width:100px;height:26px">
               </div>
           </div>
           <!--7-->
           <div class="col-xs-3">
               <div class="col-xs-3">
                   <label>科室</label>
               </div>
               <div class="col-xs-9" >
                   <select style="width:100px;height:26px">
                       <option>全科</option>
                       <option>妇科</option>
                       <option>中医科</option>
                   </select>
               </div>
           </div>
           <!--8-->
           <div class="col-xs-3">
               <div class="col-xs-3">
                   <label>医生</label>
               </div>
               <div class="col-xs-9">
                   <input class="text" placeholder="系统管理员">
               </div>
           </div>
       </div>

        <div class="row">
            <!--6-->
            <div class="col-xs-3">
                <div class="col-xs-4">
                    <label>过敏药物</label>
                </div>
                <div class="col-xs-8">
                    <!--<select style="width:100px;height:26px">-->
                        <!--<option>青霉素</option>-->
                        <!--<option>阿莫西林</option>-->
                    <!--</select>-->
                    <select id="usertype1" name="usertype" class="selectpicker show-tick form-control" multiple data-live-search="false">
                        <!--<option value="0"></option>-->
                        <option value="1">青霉素</option>
                        <option value="2">阿莫西林</option>

                    </select>
                </div>
            </div>
            <!--5-->
            <div class="col-xs-3">
                <div class="col-xs-3">
                    <label>临床诊断</label>
                </div>
                <div class="col-xs-9">
                    <select id="usertype" name="usertype" class="selectpicker show-tick form-control" multiple data-live-search="false">
                        <!--<option value="0"></option>-->
                        <option value="1">感冒</option>
                        <option value="2">肠炎</option>

                    </select>
                    <!--<select style="width:100px;height:26px">-->
                        <!--<option>肠炎</option>-->
                        <!--<option>感冒</option>-->
                    <!--</select>-->
                    <!--<button type="button" class="btn btn-info">多选</button>-->
                </div>
            </div>
            <!--7-->
            <div class="col-xs-3">
                <div class="col-xs-3">
                    <label>联系电话</label>
                </div>
                <div class="col-xs-9">
                    <input class="number">
                </div>
            </div>
            <!--8-->
            <div class="col-xs-3">
                <div class="col-xs-3">
                    <label>住址</label>
                </div>
                <div class="col-xs-9">
                    <input class="text" placeholder="">
                </div>
            </div>

        </div>
        <br>
    </div>
    <br>
    <label style="background-color:#ffffff;font-size: 20px">已开处方信息列表</label>
    <!--<hr style="height:3px;border:none;border-top:3px  solid lightskyblue;margin-top: 0px">-->

    <div class="row" style="background-color:#ffffff;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;" style="width:100px;height:100px;margin-left: 0px;margin-right: 0px">
        <div class="row">

            <div data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example" style="width: 1170px;margin:auto">
                <table class="table table-bordered" style="width: 1170px;margin:auto" id="para_table">
                    <tr style="padding-left: 0px;margin-left: 0px">
                        <th style="">序号</th>
                        <th>组</th>
                        <th>编码</th>
                        <th>品名</th>
                        <th>规格</th>
                        <th>总量</th>
                        <th>给药途径</th>
                        <th>用药频次</th>
                        <th>单次剂量</th>
                        <th>剂量单位</th>
                        <th>单位</th>
                        <th>天数</th>
                        <th>比例</th>
                        <th>执行科室</th>
                        <th>操作</th>
                    </tr>
                    <tr>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="tdclick(this)"></td>
                        <td  style="text-align:center; " onclick="deletetr(this)">
                            <button type="button"  class="btn btn-xs btn-link">删除</button></td>
                        </td>
                    </tr>
                </table>
                <!--<div id="addtrdiv" style="margin-top:-15px; width: 15%; float: right;">-->
                    <!--<button type="button" class="btn btn-xs btn-link" onclick="addtr()">添加</button>-->
                <!--</div>-->
            </div>
            <!--1-->
            <!--<div class="col-md-3">-->
             <!--</div>-->
            <!--<div class="col-md-3">-->
            <!--</div>-->
        </div>
        <div class="row">
           <div class="col-md-3">
               <button type="button" class="btn btn-info">删除选择行(D)</button>

           </div>
            <div class="col-md-2">
                <button type="button" class="btn btn-info">划价</button>

            </div>
            <div class="col-md-2">
                <button type="button" class="btn btn-info">一键开处方(F7)</button>

            </div>
            <div class="col-md-5">
                <div class="col-md-4">
                  <button type="button" class="btn btn-info">选择比例</button>
                </div>
                <div class="col-md-8">
                    <div class="col-md-6">
                       <div class="radio">
                         <label>
                             <input type="radio" name="optionsRadios" id="optionsRadios1"
                                  value="option1" checked>打印挂单号
                         </label>
                      </div>
                    </div>
                    <div class="col-md-6">
                               <button type="button" class="btn btn-info" onclick="addtr()">添加</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
<br>
    <div class="row" style="background-color:#ffffff;box-shadow:
         inset 1px -1px 1px #444, inset -1px 1px 1px #444;" style="width:100px;height:100px;margin-left: 0px;margin-right: 0px">
        <br>
        <div class="row" style="width:1170px;margin: auto">
            <div class="col-md-4">
                <label>品名(F3)</label>
                 <input class="text">
            </div>
            <div class="col-md-8">
              <div class="col-md-2">
                    <label>类型：</label>
              </div>
              <div class="col-md-10">
                <div class="radio">
                    <div class="col-md-3">
                    <input type="radio" name="optionsRadios" id="optionsRadios4" value="option1">全部
                        </div>
                    <div class="col-md-3">
                    <input type="radio" name="optionsRadios" id="optionsRadios5" value="option1">药品
                        </div>
                    <div class="col-md-3">
                    <input type="radio" name="optionsRadios" id="optionsRadios6" value="option1">中草药
                        </div>
                    <div class="col-md-3">
                    <input type="radio" name="optionsRadios" id="optionsRadios7" value="option1">检查
                        </div>
                </div>
               </div>
            </div>
            </div>
        <br>
        <div class="row">
            <div class="col-md-8">
                <div class="col-md-9">
                    <div class="col-md-4">
                      <label>搜索方式(F5)</label>
                    </div>
                    <div class="col-md-8">
                       <select class="selectpicker" style="width:60px;height:26px">
                         <option>编码</option>
                         <option>拼音码</option>
                         <option>五笔码</option>
                       </select>
                    </div>
                 </div>
                <div class="col-md-3">
                    <input type="radio" name="optionsRadios" id="optionsRadios8" value="option1">无库存不显示
                </div>
            </div>
            <div class="col-md-4">

                <div class="col-md-4">
                    <button type="button" class="btn btn-info">常规(F11)</button>
                </div>
                <div class="col-md-4">
                    <button type="button" class="btn btn-info">历史处方</button>
                </div>
            </div>
        </div>
        <div class="row">

            <div data-spy="scroll" data-target="#navbarExample" data-offset="50" class="scrollspy-example" style="width: 1170px;margin:auto">
                <table class="table table-bordered" style="width: 1170px;margin:auto" id="para_table1">
                    <tr style="padding-left: 0px;margin-left: 0px">
                        <th style=""></th>
                        <th>编码</th>
                        <th>类别</th>
                        <th>品名</th>
                        <th>商品名</th>
                        <th>规格</th>
                        <th>单位</th>
                        <th>产地</th>
                        <th>库存</th>
                        <th>收费项</th>
                        <th>拆零</th>
                        <th>最小单位</th>
                        <th>操作</th>
                    </tr>
                   <tr>
                       <td  style="text-align:center; " onclick="tdclick(this)"></td>
                       <td  style="text-align:center; " onclick="tdclick(this)"></td>
                       <td  style="text-align:center; " onclick="tdclick(this)"></td>
                       <td  style="text-align:center; " onclick="tdclick(this)"></td>
                       <td  style="text-align:center; " onclick="tdclick(this)"></td>
                       <td  style="text-align:center; " onclick="tdclick(this)"></td>
                       <td  style="text-align:center; " onclick="tdclick(this)"></td>
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
                <!--<div id="addtrdiv1" style="margin-top:-15px; width: 15%; float: right;">-->
                    <!--<button type="button" class="btn btn-xs btn-link" onclick="addtr1()">添加</button>-->
                <!--</div>-->
            </div>
            <!--1-->
            <!--<div class="col-md-3">-->
            <!--</div>-->
            <!--<div class="col-md-3">-->
            <!--</div>-->
        </div>
        <div class="row">
            <div class="col-md-2">
               <input type="radio" name="optionsRadios" id="optionsRadios9" value="option1">中药方
            </div>
            <div class="col-md-2">
                <input type="radio" name="optionsRadios" id="optionsRadios10" value="option1">打印当前病历及处方
            </div>
            <div class="col-md-2">
                <input type="radio" name="optionsRadios" id="optionsRadios11" value="option1">退处方
            </div>
            <div class="col-md-6">
                <button type="button" class="btn btn-info">绑定给药途径</button>
                <button type="button" class="btn btn-info">全屏(F6)</button>
                <button type="button" class="btn btn-info">刷卡(F8)</button>
                <button type="button" class="btn btn-info">保存处方(F9)</button>
                <button type="button" class="btn btn-info">关闭(Q)</button>
                <button type="button" class="btn btn-info" onclick="addtr1()">添加</button>
            </div>
        </div>
    </div>

</div>
</body>
</html>

<script>
    $(window).on('load', function () {
        $('#usertype').selectpicker({
            'selectedText': 'cat'
        });

        $('#usertype1').selectpicker({
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
        var table1 = $("#para_table1");
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


//    1
    function addtr1(){
        var table = $("#para_table1");
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
                "<td  align='center' onclick='deletetr(this)'><button type='button'  class='btn btn-xs btn-link' >"+"删除"+"</button></td></tr>");
        table.append(tr);
    }
    function deletetr1(tdobject){
        var td=$(tdobject);
        td.parents("tr").remove();
    }
</script>

