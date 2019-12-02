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


<table border="1px">
<tr>
<th>Id</th><th>Name</th><th>Address</th></tr>
<c:forEach items="${kk}" var="j">



<td><c:out value="${j.id}"></c:out></td>
<td><c:out value="${j.address}"></c:out></td>
<td><c:out value="${j.name}"></c:out></td>



</c:forEach>
</table>


</body>
</html>