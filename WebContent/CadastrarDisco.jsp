<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>VINIL - Cadastrar Disco</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/signin.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="form-signin" style="background: #42dea4;">
				<h2 class="text-center">Cadastrar Disco</h2>
				
				<form method="POST" action="valida.php">
					<!--<label>T�tulo</label>-->
					<input type="text" name="usuario" placeholder="Digite o t�tulo" class="form-control"><br>
					
					<!--<label>Data de Grava��o</label>-->
					<input type="text" name="usuario" placeholder="Digite a data de grava��o" class="form-control"><br>
					
					<!--<label>Gravadora</label>-->
					<input type="password" name="senha" placeholder="Digite o nome da Gravadora" class="form-control"><br>
					
					<!--<label>G�nero</label>-->
					<input type="password" name="senha" placeholder="Digite o g�nero do disco" class="form-control"><br>
					
					<!--<label>Pre�o</label>-->
					<input type="password" name="senha" placeholder="Digite o pre�o" class="form-control"><br>
					
					<input type="submit" name="btnLogin" value="Efetuar Cadastro" class="btn btn-success btn-block">		
					
				</form>
			</div>
		</div>			
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>