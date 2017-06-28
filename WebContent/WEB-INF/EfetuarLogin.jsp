<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <title>VINIL - Login</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
  <link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
  <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="css/style.css">
</head>

<body>
	<div class="container">
  		<div class="info">
    		<a href="EfetuarLogin.jsp"><img src="LogoVinil.png" alt="LogoVinil"></a>
  		</div>
	</div>
	<div class="formLogin">
  		<div class="thumbnail"><img src="person.png"/></div>			
  			  			
  			<form class="login-form">
			    <input type="text" placeholder="ID de usuário"/>
			    <input type="password" placeholder="Senha"/>
			    <a href="IGerente.jsp"><button>Login</button></a>
			    <p class="message"><a href="#">Esqueceu sua senha?</a></p>
			</form>
	</div>

  	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script src="js/index.js"></script>

	</body>
</html>