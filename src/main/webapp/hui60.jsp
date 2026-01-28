<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.sql" prefix="sql" %>
<c:catch var="err">
	<sql:setDataSource
		driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/iii"
		user="root"
		password="root"
	/>
	
	<sql:update var="num">
		INSERT INTO cust
			(cname,tel,birthday)
		VALUES
			('AAA5','BBB5','1998-06-05'),
			('AAA6','BBB6','1998-07-05'),
			('AAA7','BBB7','1998-08-05'),
			('AAA8','BBB8','1998-09-05')
	</sql:update>
</c:catch>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:choose>
			<c:when test="${!empty err }">${err }</c:when>
			<c:otherwise>${num }</c:otherwise>
		</c:choose>
	</body>
</html>