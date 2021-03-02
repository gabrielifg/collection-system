<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Services</title>
</head>

<body>
	<form action="servicos" method="post">
		<input type="hidden" name="id" id="id" value="${service.getId()}" />
		<p><input required type="text" name="input-nome" placeholder="Digite o nome" size="70" value="${service.getName() }"/></p>
		
		<p><input type="submit" class="button" name="btn-salva" value="salvar"/></p>
	</form>
</body>
</html>