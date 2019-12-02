<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br/>


<c:forEach  items="${up}" var="i" > 
<form action="update2" method="post">
	<table>
	<tr> <input type="hidden" name="id" value="<c:out value="${i.id}"/>"></tr>
	<tr><th>name</th><td><input type ="text" value="<c:out value="${i.name}"/>" name="name"><td></tr>
	<tr><th>address</th><td><input type ="text" value="<c:out value="${i.address}"/>" name="address"><td></tr>
	<tr><th><input type ="submit" value="Update"></th><td></td></tr>
	</table>
</form>
</c:forEach>
</body>
</html>