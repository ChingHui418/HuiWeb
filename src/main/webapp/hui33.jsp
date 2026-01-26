<%@page import="org.json.*"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	// System.out.println(x);
	// System.out.println(y);
	
	int result = Integer.parseInt(x) + Integer.parseInt(y);
	
	JSONObject obj = new JSONObject();
	obj.put("result", result);
	out.print(obj);
	
%>