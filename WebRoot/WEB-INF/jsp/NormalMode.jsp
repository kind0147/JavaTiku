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
		<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
		<link rel="stylesheet" href="css/style.css">
		<script src="js/jquery-1.7.min.js" type="text/javascript"></script>
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
		<![endif]-->

	</head>
	<body>
		<input type="hidden"
			name="${ _csrf.parameterName }" value="${ _csrf.token }" />
		<div id="wrapper">
			<div class="overlay"></div>
			
			<!-- Page Content -->
			<nav class="navbar navbar-inverse navbar-fixed-top">
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
			<div class="row">
				<div class="col-md-2">
					<a href="#">
						<img src="img/test.jpg" style="margin-left: 60px;margin-bottom: 30px;margin-top: 80px"; alt="..." class="img-circle">
					</a>
					<div>
						<div class = "list-group">
							<a href="#" class="list-group-item">
								<span class="glyphicon glyphicon-menu-right"></span> 出题
							</a>
							<a href="/Java-Tiku/cart" class="list-group-item">
								<span class="glyphicon glyphicon-menu-right"></span> 已选题目
							</a>
							<a href="Java-Tiku/login" class="list-group-item">
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
							<td><button class="btn btn-default" type="submit" style="margin-left: 30px;" onclick="getPage(1)">确定</button></td>
						</tr>
					</tbody>
				</table>
				<div class="row">
					<div class="col-md-12">
						<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading" >
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idOne" value="${exercises.get(0).getId()}"/>
									<p id="descOne"><c:out value="${exercises.get(0).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerOne"><c:out value="${exercises.get(0).getEanswer()}" /></p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading" >
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idTwo" value="${exercises.get(1).getId()}"/>
									<p id="descTwo"><c:out value="${exercises.get(1).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseTwo">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseTwo" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerTwo"><c:out value="${exercises.get(1).getEanswer()}" /></p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idThree" value="${exercises.get(2).getId()}"/>
									<p id="descThree"><c:out value="${exercises.get(2).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseThree">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseThree" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerThree"><c:out value="${exercises.get(2).getEanswer()}" /></p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idFour" value="${exercises.get(3).getId()}"/>
									<p id="descFour"><c:out value="${exercises.get(3).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseFour">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseFour" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerFour"><c:out value="${exercises.get(3).getEanswer()}" /></p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idFive" value="${exercises.get(4).getId()}"/>
									<p id="descFive"><c:out value="${exercises.get(4).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseFive">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseFive" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerFive"><c:out value="${exercises.get(4).getEanswer()}" /></p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idSix" value="${exercises.get(5).getId()}"/>
									<p id="descSix"><c:out value="${exercises.get(5).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseSix">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseSix" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerSix"><c:out value="${exercises.get(5).getEanswer()}" /></p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idSeven" value="${exercises.get(6).getId()}"/>
									<p id="descSeven"><c:out value="${exercises.get(6).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseSeven">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseSeven" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerSeven"><c:out value="${exercises.get(6).getEanswer()}" /></p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idEight" value="${exercises.get(7).getId()}"/>
									<p id="descEight"><c:out value="${exercises.get(7).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseEight">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseEight" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerEight"><c:out value="${exercises.get(7).getEanswer()}" /></p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idNine" value="${exercises.get(8).getId()}"/>
									<p id="descNine"><c:out value="${exercises.get(8).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseNine">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseNine" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerNine"><c:out value="${exercises.get(8).getEanswer()}" /></p>
									</div>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<input type="hidden" name="id" id="idTen" value="${exercises.get(9).getId()}"/>
									<p id="descTen"><c:out value="${exercises.get(9).getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseTen">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="add">添加</button>
									</h4>
								</div>
								<div id="collapseTen" class="panel-collapse collapse in">
									<div class="panel-body">
										<p id="answerTen"><c:out value="${exercises.get(9).getEanswer()}" /></p>
									</div>
								</div>
							</div>
						</div>
						<nav aria-label="Page navigation">
							<ul class="pagination">
								<li class="disabled">
									<a href="#" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<li onclick="getPage(1)"><a href="#">1</a></li>
								<li onclick="getPage(2)"><a href="#">2</a></li>
								<li onclick="getPage(3)"><a href="#">3</a></li>
								<li onclick="getPage(4)"><a href="#">4</a></li>
								<li onclick="getPage(5)"><a href="#">5</a></li>
								<li onclick="getPage(6)"><a href="#">6</a></li>
								<li onclick="getPage(7)"><a href="#">7</a></li>
								<li onclick="getPage(8)"><a href="#">8</a></li>
								<li onclick="getPage(9)"><a href="#">9</a></li>
								<li onclick="getPage(10)"><a href="#">10</a></li>
								<li >
									<a href="#" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /#page-content-wrapper -->
</div>
</body>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js" type="text/javascript"></script>
<script>window.jQuery || document.write('<script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"><\/script>')</script>

<script>
	$(function () { $('#collapseFour').collapse('hide')});
	$(function () { $('#collapseOne').collapse('hide')});
    $(function () { $('#collapseTwo').collapse('hide')});
    $(function () { $('#collapseThree').collapse('hide')});
    $(function () { $('#collapseFive').collapse('hide')});
    $(function () { $('#collapseSix').collapse('hide')});
    $(function () { $('#collapseSeven').collapse('hide')});
    $(function () { $('#collapseEight').collapse('hide')});
    $(function () { $('#collapseNine').collapse('hide')});   
    $(function () { $('#collapseTen').collapse('hide')});   
</script>

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

</script>

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="js/pageshow.js"></script>
</body>
</html>