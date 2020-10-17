<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%="Hello world!" %><br/>
Data: <%= new SimpleDateFormat("dd-MM-yyyy").format(new Date()) %>
ID Studenta: <%=request.getParameter("x_student_id")%><br/>
Informacja przekierowana z serwletu: <%= request.getAttribute("x_redirect")%>
</body>
</html>
