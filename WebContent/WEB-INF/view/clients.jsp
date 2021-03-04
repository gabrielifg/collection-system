<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients</title>
</head>
<body>
	<h1>Clients JSP</h1>
	<p><a href="go?page=clients-form">add clients</a></p>
	
	<table>
		<thead>
			<tr>
				<th>CNPJ</th>
				<th>NAME</th>
				<th>NOME FANTASY</th>
				<th>CEP</th>
				<th>PUBLIC PLACE</th>
				<th>NUMBER</th>
				<th>COMPLEMENT</th>
				<th>UF</th>
				<th>COUNTY</th>
				<th>EDITAR</th>
				<th>EXCLUIR</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clients}" var="c">
 				<tr class="tblHover">
 					<td>${c.cnpj}</td>
 					<td>${c.name}</td>
 					<td>${c.nameFantasy}</td>
 					<td>${c.cep}</td>
 					<td>${c.publicPlace}</td>
 					<td>${c.number}</td>
 					<td>${c.complement}</td>
 					<td>${c.uf}</td>
 					<td>${c.county}</td>
 					<td><a href="clients?cnpj=${c.cnpj}&operation=edit">edit</a></td>
	 				<td><a href="clients?cnpj=${c.cnpj}&operation=delete">delete</a></td>
 					<!-- <td><a class="" href="contratos?cnpj=${a.cnpj}&acao=contratos"> CONTRATOS </a></td>  -->
 				</tr>
 				</c:forEach>
		</tbody>
	</table>
	<p><a href="go?page=dashboard">back</a></p>
</body>
</html>