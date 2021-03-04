<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Services</title>
</head>
<body>
	<h1>Services JSP</h1>
	<p><a href="go?page=services-form">add services</a></p>

	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th></th>
				<th></th>
			<tr>
		</thead>
		<tbody>
			<c:forEach items="${services}" var="s">
	 			<tr>
	 				<td> ${s.id} </td>
	 				<td> ${s.name} </td>
	 				<td><a href="services?id=${s.id}&operation=edit">edit</a></td>
	 				<td><a href="services?id=${s.id}&operation=delete">delete</a></td>
	 			</tr> 
			</c:forEach>
		</tbody>

	</table>
	
	<p><a href="go?page=dashboard">back</a></p>

</body>
</html>