<%@ page language="java" contentType="text/html; charset=charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>

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
			<a href="EfetuarLogin.jsp"><img src="media_imagens/LogoVinil.png"
				alt="LogoVinil"></a>
		</div>
	</div>

	<div class="formLogin">
  		<div class="thumbnail">
			<img src="media_imagens/person.png" />
		</div>

		<form class="login-form" action="Vinil">
				<input id="email" name="email" type="text" placeholder="ID de usuário" /> 
				<input id="senha" name="senha" type="password" placeholder="Senha" /> 
				<input name="acao" type="hidden" value="login" />
				<input id="submit" style="color: WHITE" type="submit" value="Login"></input>
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

</body>
</html>