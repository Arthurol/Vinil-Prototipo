<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>VINIL - Cadastrar Long Play</title>

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
			<a href="AreaCaixa.jsp"><img src="LogoVinil.png" alt="LogoVinil"></a>
		</div>
	</div>

	<div id="nav">
		<ul class="menu">
			<li><a href="AreaCaixa.jsp">Home</a></li>
			<li><a href="CaixaRegistrarVenda.jsp">Registrar Venda</a></li>
		</ul>
	</div>

	<div class="formCadastro">
		<form class="cadastro-form">
			<input type="text" placeholder="Id do Long Play" /> <input
				type="text" placeholder="Id do(a) Vendedor(a)" /> <input
				type="text" placeholder="Valor Total da venda" /> <a
				href="AreaCaixa.jsp">
				<button>Finalizar venda</button>
			</a>
		</form>
	</div>

</body>
</html>