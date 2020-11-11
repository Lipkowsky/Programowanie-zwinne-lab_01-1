<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Lista zadań</h2>
	<table border="1" cellpadding="3">
		<tr>
			<th>Lp.</th>
			<th>Id</th>
			<th>Nazwa</th>
			<th>Opis</th>
			<th>Projekt_id</th>
		</tr>
		<c:forEach var="zadanie" items="${requestScope.zadania}"
			varStatus="info">
			<tr>
				<td>${info.count}.</td>
				<td><c:out value="${zadanie.zadanieId}" /></td>
				<td><c:out value="${zadanie.nazwa}" /></td>
				<td><c:out value="${zadanie.opis}" /></td>
				<td><c:out value="${zadanie.projekt.projektId}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>