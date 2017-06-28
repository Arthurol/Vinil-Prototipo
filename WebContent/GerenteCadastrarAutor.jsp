<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>VINIL - Cadastrar Autor</title>

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
			<a href="AreaGerente.jsp"><img src="LogoVinil.png" alt="LogoVinil"></a>
		</div>
	</div>


	<div id="nav">
		<ul class="menu">
			<li><a href="AreaGerente.jsp">Home</a></li>
			<li><a href="CadastrarLongPlay.jsp">Long Plays</a>
				<ul class="submenu-1">
					<li><a href="ConsultarLongPlay.jsp">Consultar Long Play</a></li>
					<li><a href="CadastrarLongPlay.jsp">Cadastrar Long Play</a></li>
				</ul></li>
			<li><a href="#">Autores</a>
				<ul class="submenu-1">
					<li><a href="#">Cadastrar Autor</a></li>
				</ul></li>
			<li><a href="#">Gravadoras</a>
				<ul class="submenu-1">
					<li><a href="#">Cadastrar Gravadora</a></li>
					<li><a href="#">Listar Gravadoras</a></li>
				</ul></li>
			<li><a href="#">Seções</a>
				<ul class="submenu-1">
					<li><a href="#">Cadastrar Seções</a></li>
					<li><a href="#">Listar Seções</a></li>
				</ul></li>
			<li><a href="#">Funcionários</a>
				<ul class="submenu-1">
					<li><a href="CadastrarFuncionarios.jsp">Cadastrar
							Funcionários</a></li>
					<li><a href="ListarFuncionarios.jsp">Listar Funcionários</a></li>
				</ul></li>
		</ul>
	</div>

	<div class="formCadastro">
		<form class="cadastro-form">
			<input type="text" placeholder="Id" /> <input type="text"
				placeholder="Nome" /> <a href="AreaGerente.jsp"><button>Efetuar
					cadastro</button></a>
		</form>
	</div>

</body>
</html>