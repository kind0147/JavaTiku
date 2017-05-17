<%@page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>登录判断页面</title>
	</head>
	
	<body>
		<c:choose>
			<%--如果用户输入的用户名是root，则为合法用户名 --%>
			<c:when test="${param.username =='root' }">
				<%--判断用户密码是否合法，合法就直接跳转到登录成功页面 --%>
				<c:if test="${param.upassword =='admin' }">
					<jsp:forward page="test.html"></jsp:forward>
				</c:if>
				<jsp:forward page="loginFailure.jsp"></jsp:forward>
			</c:when>
			<%--如果用户输入的用户名不是root，则为非法用户名，直接跳转到登陆失败页面 --%>
			<c:otherwise>
				<jsp:forward page="loginFailure.jsp"></jsp:forward>
			</c:otherwise>
		</c:choose>
	</body>
</html>