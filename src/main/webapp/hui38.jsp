<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>Hui Big Company</div>
		<hr>
		<jsp:include page="hui39.jsp">
			<jsp:param value="10" name="x"/>
		</jsp:include>
		<hr>
		<jsp:include page="hui39.jsp?x=100"></jsp:include>
		<hr>
		<jsp:include page="hui40.jsp"></jsp:include>
		<hr>
	</body>
</html>