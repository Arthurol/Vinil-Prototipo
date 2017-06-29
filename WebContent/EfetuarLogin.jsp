<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<link href="css/signin.css" rel="stylesheet">

<title>VINIL - Login</title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="media_css/estilo.css">

</head>


<body>
	<div class="container">
		<div class="info">
			<a href="EfetuarLogin.jsp"><img src="LogoVinil.png"
				alt="LogoVinil"></a>
		</div>
	</div>

	<div class="formLogin">
		<div class="thumbnail">
			<img src="person.png" />
		</div>

		<form class="login-form" action="Vinil">
			<input id="email" name="email" type="text"
				placeholder="ID de usuário" /> <input id="senha" name="senha"
				type="password" placeholder="Senha" /> <input name="acao"
				type="hidden" value="login" /> <input type="submit" value="Login"></input>
			<p class="message">
				<a href="#">Esqueceu sua senha?</a>
			</p>
			
			<c:if test="${not empty erro}">
			<br><br>
				<div style="font-size:20px; color:red; text-align:center">
					<c:out value="${erro}">
					</c:out>
					<%
						request.setAttribute("erro", null);
					%>
				</div>
			</c:if>
		</form>
	</div>

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>

	

</body>
</html>