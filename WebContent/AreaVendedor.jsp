<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Área do Vendedor</title>

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
			<a href="Gerente.jsp"><img src="LogoVinil.png" alt="LogoVinil"></a>
		</div>
	</div>

	<div id="nav">
		<ul class="menu">
			<li><a href="#">Home</a></li>
			<li><a href="#">Long Plays</a>
				<ul class="submenu-1">
					<li><a href="ConsultarLongPlay.jsp">Consultar Long Play</a></li>
					<li><a href="CadastrarLongPlay.jsp">Cadastrar Long Play</a></li>
				</ul></li>
			<li><a href="#">Autores</a>
				<ul class="submenu-1">
					<li><a href="CadastrarAutor.jsp">Cadastrar Autor</a></li>
				</ul></li>
			<li><a href="#">Gravadoras</a>
				<ul class="submenu-1">
					<li><a href="CadastrarGravadora.jsp">Cadastrar Gravadora</a></li>
					<li><a href="ListarGravadoras.jsp">Listar Gravadoras</a></li>
				</ul></li>
		</ul>
	</div>

	<div class="formCadastro">
		<form class="cadastro-form">
			<h1>Bem-vindo(a)!</h1>
		</form>
	</div>

</body>
</html>