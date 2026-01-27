<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name1 = "Hui1";
	pageContext.setAttribute("name", name1);
	
	String name2 = "Hui2";
	request.setAttribute("name", name2);
	
	String name3 = "Hui3";
	session.setAttribute("name", name3);
	
	String name4 = "Hui4";
	application.setAttribute("name", name4);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		Name: ${name }<br />
		Name(page): ${pageScope.name}<br />
		Name(request) : ${requestScope.name }<br />
		Name(session) : ${sessionScope.name }<br />
		Name(application) : ${applicationScope.name }<br />
	</body>
</html>