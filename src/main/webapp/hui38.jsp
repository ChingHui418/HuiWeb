<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setAttribute("lottery", (int)(Math.random()*49 + 1));
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>Hui Big Company</div>
		<hr>
		<jsp:include page="hui39.jsp"></jsp:include>
		<hr>
		<jsp:include page="hui39.jsp"></jsp:include>
		<hr>
		<jsp:include page="hui40.jsp"></jsp:include>
		<hr>
	</body>
</html>