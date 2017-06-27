<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>VINIL - Cadastrar Funcionário</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/signin.css" rel="stylesheet">
	</head>
	<body>
		<div class="container">
			<div class="form-signin" style="background: #42dea4;">
				<h2 class="text-center">Cadastrar Funcionário</h2>
				
				<form method="POST" action="valida.php">
					<!--<label>Nome</label>-->
					<input type="text" name="nome" placeholder="Digite o Nome" class="form-control"><br>
					
					<!--<label>CPF</label>-->
					<input type="text" name="cpf" placeholder="Digite o CPF" class="form-control"><br>
					
					<!--<label>E-mail</label>-->
					<input type="password" name="e-mail" placeholder="Digite o e-mail" class="form-control"><br>
					
					<!--<label>Cargo</label>-->
					<input type="password" name="cargo" placeholder="Digite o cargo" class="form-control"><br>
					
					<!--<label>Senha</label>-->
					<input type="password" name="senha" placeholder="Digite a senha" class="form-control"><br>
					
					<!--<label>Redigite a senha</label>-->
					<input type="password" name="redigitarsenha" placeholder="Redigite a senha" class="form-control"><br>
					
					<input type="submit" name="btnLogin" value="Efetuar Cadastro" class="btn btn-success btn-block">		
					
				</form>
			</div>
		</div>			
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>