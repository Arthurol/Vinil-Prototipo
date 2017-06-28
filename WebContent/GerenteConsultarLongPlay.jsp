<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>VINIL - Consultar dados de Long Play</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
<link rel='stylesheet prefetch'
	href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
<link rel='stylesheet prefetch'
	href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="css/style.css">
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
					<li><a href="GerenteCadastrarAutor.jsp">Cadastrar Autor</a></li>
				</ul></li>
			<li><a href="#">Gravadoras</a>
				<ul class="submenu-1">
					<li><a href="GerenteCadastrarGravadora.jsp">Cadastrar Gravadora</a></li>
					<li><a href="GerenteListarGravadoras.jsp">Listar Gravadoras</a></li>
				</ul></li>
			<li><a href="#">Seções</a>
				<ul class="submenu-1">
					<li><a href="GerenteCadastrarSecao.jsp">Cadastrar Seções</a></li>
					<li><a href="GerenteListarSecao.jsp">Listar Seções</a></li>
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
			<input type="text" name="IdDisco" required pattern="[0-9]+$"
				placeholder="ID do Long Play" />
				<a href="DadosLongPlay.jsp"><button>Consultar</button></a>

		</form>
	</div>
</body>
</html>