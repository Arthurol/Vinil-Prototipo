<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>VINIL - Registrar Venda</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div class="container">
  		<div class="info">
    		<a href="ICaixa.jsp"><img src="LogoVinil.png" alt="LogoVinil"></a>
  		</div>
	</div>
	<div class="formCadastro">  			  			
  			<form class="cadastro-form">
			    <input type="text" name="IdDisco" required pattern="[0-9]+$" placeholder="ID do disco"/>
			    	<!-- Aqui entra o esquema do '+' -->
			    <input type="text" name="IdVendedor" required pattern="[0-9]+$" placeholder="ID do(a) Vendedor(a)">
			    <input type="text" name="ValorTotal" required pattern="[0-9]{1}.[0-9]{2}"placeholder="Valor total da venda em R$ X.XX"/>
			    <!-- Inserir data e hora da venda no arquivo gerado? -->	

			    <a href="ICaixa.jsp"><button>Finalizar venda</button></a>
			</form>
	</div>

  	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>

	</body>
</html>