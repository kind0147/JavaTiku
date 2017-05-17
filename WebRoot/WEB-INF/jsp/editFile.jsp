<%@page import="tiku.domain.Exercises"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>java试题库</title>
		<!-- Bootstrap -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="css/base.css" rel="stylesheet">
		<link rel="stylesheet" href="css/style.css">
		<script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
<body>
		<input type="hidden"
			name="${ _csrf.parameterName }" value="${ _csrf.token }" />
			<!-- Page Content -->
			<div class="row">
			<nav class="navbar navbar-inverse navbar-fixed-top" >
				<div class="container-fluid">
					<div class="navbar-header">
          				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
           					 <span class="sr-only">Toggle navigation</span>
            				 <span class="icon-bar"></span>
            				 <span class="icon-bar"></span>
            				 <span class="icon-bar"></span>
          				</button>
         				<a class="navbar-brand" href="#">欢迎来到java试题库</a>
        			</div>
				</div>
			</nav>
			</div>
			<div class="row">
				<div class="col-md-2">
					<a href="#">
						<img src="img/test.jpg" style="margin-left: 60px;margin-bottom: 30px;margin-top: 60px"; alt="..." class="img-circle">
					</a>
					<div>
						<div class = "list-group">
							<a href="/Java-Tiku/main?page=1" class="list-group-item">
								<span class="glyphicon glyphicon-menu-right"></span> 出题
							</a>
							<a href="/Java-Tiku/cart" class="list-group-item">
								<span class="glyphicon glyphicon-menu-right"></span> 已选题目
							</a>
							<a href="#" class="list-group-item">
								<span class="glyphicon glyphicon-menu-right"></span>录入题目
							</a>
							<a href="/login" class="list-group-item">
								<span class="glyphicon glyphicon-log-out"></span> 登出
							</a>
						</a>
					</div>
				</div>
			</div>
			<div class="col-md-8">
				<br>
				<br>
				<br>
				<table class="table">
					<tbody>
						<tr>
							<td><p>按难度：</p></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="diff" id="diff1" value="1"> 1
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="diff" id="diff2" value="2"> 2
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="diff" id="diff3" value="3"> 3
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="diff" id="diff4" value="4"> 4
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="diff" id="diff5" value="5"> 5
							</label></td>
						</tr>
						<tr>
							<td><p>按知识点：</p></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="point" id="point1" value="ft"> 前端
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="point" id="point2" value="bg"> 后台
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="point" id="point3" value="jexp"> Java语法
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="point" id="point4" value="oo"> 面向对象
							</label></td>
						</tr>
						<tr>
							<td><p>按类型：</p></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="type" id="tpye1" value="chose"> 选择题
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="type"  id="type2" value="pd"> 判断题
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="type"  id="type3" value="tk"> 填空题
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="type"  id="type4" value="saq"> 简答题
							</label></td>
							<td><label class="checkbox-inline">
								<input type="checkbox" name="type"  id="type5" value="design"> 程序设计题
							</label></td>
						</tr>
					</tbody>
				</table>
				<div class="row">
					<div class="col-md-12">
					</div>	
					
						<div class="form-group">
							<label for="name">题目</label>
							<textarea class="form-control" rows="3" id="desc">${exec.getEdesc()}</textarea>
						</div>
						<div class="form-group">
							<label for="name">答案</label>
							<textarea class="form-control" rows="3" id="answer">${exec.getEanswer()}</textarea>
						</div>
					
						<button class="btn btn-default" type="submit" id="update">
							输入
						</button>
					
					</div>
	</div>
	<!-- /#page-content-wrapper -->
</div>
</body>
<script type="text/javascript">
	var diff = document.getElementsByName('diff' ),
           maxNums = 1;
           for(var i in diff){
              diff[i]. onclick = function (){
                 var _diffSelect = document.getElementsByName('diff'),
                 cNums = 0;
                 for(var i in _diffSelect){
                   if(i == 'length') break ;
                   if(_diffSelect[i].checked){
                      cNums ++;
                   }
                }
                 if(cNums > maxNums){
                   this.checked = false;
                    alert('同一栏最多只能选择一项');
                }
              }
           }
    var point = document.getElementsByName('point' ),
           maxNums = 1;
           for(var i in point){
              point[i]. onclick = function (){
                 var _pointSelect = document.getElementsByName('point'),
                 cNums = 0;
                 for(var i in _pointSelect){
                   if(i == 'length') break ;
                   if(_pointSelect[i].checked){
                      cNums ++;
                   }
                }
                 if(cNums > maxNums){
                   this.checked = false;
                    alert('同一栏最多只能选择一项');
                }
              }
           }
    var type = document.getElementsByName('type' ),
           maxNums = 1;
           for(var i in type){
              type[i]. onclick = function (){
                 var _typeSelect = document.getElementsByName('type'),
                 cNums = 0;
                 for(var i in _typeSelect){
                   if(i == 'length') break ;
                   if(_typeSelect[i].checked){
                      cNums ++;
                   }
                }
                 if(cNums > maxNums){
                   this.checked = false;
                    alert('同一栏最多只能选择一项');
                }
              }
           }
$('#update').click(function(){ 
	//定义构造url时需要的三个元素，默认值为空
	var diff="", type="", point="";
	//获得用户选择的难度
	var s_diff = document.getElementsByName("diff");
	for(var i in s_diff){
		if(s_diff[i].checked){
			diff = s_diff[i].value;
		}
	}
	//获得用户选择的类型
	var s_type = document.getElementsByName("type");
	for(var i in s_type){
		if(s_type[i].checked){
			type = s_type[i].value;
		}
	}
	//获得用户选择的知识点
	var s_point = document.getElementsByName("point");
	for(var i in s_point){
		if(s_point[i].checked){
			point = s_point[i].value;
		}
	}
	var desc = document.getElementById("desc").value;
	var answer = document.getElementById("answer").value;
	var data = {
		edesc: desc,
		eanswer: answer,
		ediff: diff,
		etype: type,
		epoint:point
	};
	$.ajax({
		type: "POST",
		url: "/Java-Tiku/edit",
		data: {edesc: desc, eanswer: answer, ediff: diff, etype: type, epoint:point},
		success: function(data){
			alert("录入成功");
			//location.href = "/Java-Tiku/edit?eid=";
		},
		error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status + ":" + XMLHttpRequest.statusText);
            }
	})
});

</script>
<script src="js/bootstrap.min.js"></script>
</html>