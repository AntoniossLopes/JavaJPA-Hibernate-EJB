<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<strong>Publications Info!</strong>
		<div>Greetings This is the Info About the Publications!</div>
		<br />
		<c:forEach var="item" items="${lista}">
			<div>Publication is ${item.toString()}</div>
		</c:forEach>
	</body>
</html>