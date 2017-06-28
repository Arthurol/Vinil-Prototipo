<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>VINIL - Cadastrar Long Play</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div class="container">
  		<div class="info">
    		<a href="IVendedor.jsp"><img src="LogoVinil.png" alt="LogoVinil"></a>
  		</div>
	</div>
	<div class="formCadastro">  			  			
  			<form class="cadastro-form">
			    <input type="text" placeholder="Título"/>
			    <input type="text" placeholder="Data de gravação"/>
			    <input type="text" placeholder="Nome de gravadora"/>
			    <input type="text" placeholder="Data de gravação"/>
			    <input type="text" placeholder="Gênero"/>
			    <input type="text" placeholder="Preço"/>	

			    <a href="IVendedor.jsp"><button>Efetuar cadastro de Long Play</button></a>
			</form>
	</div>

  	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>

	</body>
</html>