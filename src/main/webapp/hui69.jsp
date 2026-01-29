<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="hui" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Hui Big Company</h1>
		<hr />
		<hui:test1 /><br />
		<hui:test2 /><br />
		<hui:test3 />
		<hui:test3 />
		<hui:test3 />
		<hui:hello /><br />
		Product: <hui:product pname="iPhone" price="32000.5"></hui:product>
		<hr />
		<hui:box title="">Hello, Hui1</hui:box>
		<hui:box title="Welcome">Hello, Hui2</hui:box>
	</body>
</html>