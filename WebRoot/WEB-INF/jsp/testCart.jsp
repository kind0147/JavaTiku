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
        			<div>
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
							<a href="#" class="list-group-item">
								<span class="glyphicon glyphicon-menu-right"></span> 已选题目
							</a>
							<a href="/Java-Tiku/edit?eid=" class="list-group-item">
								<span class="glyphicon glyphicon-menu-right"></span>录入题目
							</a>
							<a href="@{/logout}" class="list-group-item">
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
				<div class="row">
					<div class="col-md-12">
						<div class="panel-group" id="accordion">
						<ul>
						<c:forEach items="${exercisesView}" var="exercises">
						<li>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
									<input type="hidden" name="id" value="${exercises.getId()}"/>
									<input type="hidden" name="type" value="${exercises.getEtype()}"/>
									<p><c:out value="${exercises.getEdesc()}" /></p>
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapseOne">
										点击看答案
									</a>
									<button class="btn btn-default" type="submit" name="delete">删除</button>
									</h4>
								</div>
								<div id="collapseOne" class="panel-collapse collapse in">
									<div class="panel-body">
										<c:out value="${exercises.getEanswer()}" />
									</div>
								</div>
							</div>
							</li>
							</c:forEach>
							</ul>
						</div>
						
					</div>
					
				</div>
			</div>
			<div class="col-md-2">
			</br>
			</br>
			</br>
				<ul class="list-group">
    				<li class="list-group-item">选择题 <p name="countChose">${count.get("chose")}/5</p></li>
    				<li class="list-group-item">判断题<p id="countPd">${count.get("pd")}/5</p></li>
    				<li class="list-group-item">填空题 <p id="countTk">${count.get("tk")}/5</p></li>
    				<li class="list-group-item">简答题 <p id="countSaq">${count.get("saq")}/3</p></li>
    				<li class="list-group-item">程序设计题 <p id="countDesign">${count.get("design")}/5</p></li>
    				</br>
    				<!-- 导出试卷 -->
					<form action="/Java-Tiku/saveDoc" method="post">
						<input type="submit" value="导出试卷">
					</form>
				</ul>
			</div>
		</div>
	</div>
	<!-- /#page-content-wrapper -->
</div>
</body>
<script>window.jQuery || document.write('<script src="http://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"><\/script>')</script>
<script>
$("button[name='delete']").click(function() {
    var eid = $(this).siblings()[0].value;
    var type = $(this).siblings()[1].value;
    $(this).parent().parent().parent().remove();
    $.ajax({
        type: "POST",
        url: "/Java-Tiku/cartapi",
        data: {eid: eid, op:"delete"},
        success: function(data){
             alert("删除成功");
            //location.href = "/Java-Tiku/edit?eid=";
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.status + ":" + XMLHttpRequest.statusText);
            }
    })
})
</script>

<script src="js/bootstrap.min.js"></script>
</html>