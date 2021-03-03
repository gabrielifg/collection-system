<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Services</title>
</head>

<body>
	<form action="services" id="form" method="post">
		<input type="hidden" name="id" id="id" value="${service.getId()}" />
		<p><input required type="text" id="input-name" name="input-name" placeholder="Digite o nome" size="70" value="${service.getName()}"/></p>
		
		<p><input type="submit" id="save-button" name="btn-salva" value="salvar"/></p>
	</form>
</body>
</html>