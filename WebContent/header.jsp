<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VINIL</title>

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
	<!-- Logo -->
	<div class="container">
		<div class="info">
			<a href="index.jsp"><img src="LogoVinil.png" alt="LogoVinil"></a>
		</div>
	</div>
	<!-- /Logo -->

<<<<<<< HEAD
=======
	<!-- Botão Logout -->
	<div id="logout">
	<a href="AreaCaixa.jsp"><button class="sair">Sair</button></a>
	</div>
	<!-- /Botão Logout -->

>>>>>>> 4582d96f371559fba062082075fe7b88ae5b407d
	<!-- Menu Caixa -->
	<div id="nav">
		<ul class="menu">
			<li><a href="#">Home</a></li>
			<li><a href="CaixaRegistrarVenda.jsp">Registrar Venda</a></li>
		</ul>
	</div>
	<!-- /Menu Caixa -->

	<!-- Menu Vendedor -->
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
	<!-- /Menu Vendedor -->
<<<<<<< HEAD

=======
>>>>>>> 4582d96f371559fba062082075fe7b88ae5b407d

	<!-- Menu Gerente -->
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
			<li><a href="#">Seções</a>
				<ul class="submenu-1">
					<li><a href="CadastrarSecao.jsp">Cadastrar Seção</a></li>
					<li><a href="ListarSecoes.jsp">Listar Seções</a></li>
				</ul></li>
			<li><a href="#">Funcionários</a>
				<ul class="submenu-1">
					<li><a href="CadastrarFuncionario.jsp">Cadastrar
							Funcionários</a></li>
					<li><a href="ListarFuncionarios.jsp">Listar Funcionários</a></li>
				</ul></li>
		</ul>
	</div>
<<<<<<< HEAD


	<c:if test="${not empty erro}">
		<div style="font-size:16px; font-color:red; text-align:center">
			<c:out value="${erro}">
			</c:out>
			<%
				request.setAttribute("erro", null);
			%>
		</div>
	</c:if>

	<c:if test="${not empty alerta}">
	<div style="font-size:16px; color:red; text-align:center">
		<c:out value="${alerta}">
		</c:out>
		<%
			request.setAttribute("alerta", null);
		%>
	</div>
	</c:if>


=======
>>>>>>> 4582d96f371559fba062082075fe7b88ae5b407d
	<!-- /Menu Gerente -->