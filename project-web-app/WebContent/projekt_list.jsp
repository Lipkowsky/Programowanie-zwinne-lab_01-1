<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="javatime" uri="http://sargue.net/jsptags/time"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Lista projektów</h2>
	<table border="1" cellpadding="3">
		<tr>
			<th>Lp.</th>
			<th>Id</th>
			<th>Nazwa</th>
			<th>Utworzony</th>
			<th>Data obrony</th>
			<th>Edycja</th>
		</tr>
		<c:forEach var="projekt" items="${requestScope.projekty}"
			varStatus="info">
			<tr>
				<td>${info.count}.</td>
				<td><c:out value="${projekt.projektId}" /></td>
				<td><c:out value="${projekt.nazwa}" /></td>

				<javatime:format value="${projekt.dataczasUtworzenia}"
					var="fmtDataczasUtworzenia" pattern="yyyy-MM-dd hh:mm:ss" />

				<td><c:out value="${fmtDataczasUtworzenia}" /></td>
				<javatime:format value="${projekt.dataOddania}" var="fmtDataOddania"
					pattern="yyyy-MM-dd" />
				<td><c:out value="${fmtDataOddania}" /></td>

				<c:url value="/zadania.jsp" var="linkZadaniaProjektu">
					<c:param name="x_projekt_id" value="${projekt.projektId}" />
				</c:url>
				<td><a href='<c:out value="${linkZadaniaProjektu}" />'>Zadania</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>