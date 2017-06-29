<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

	<div class="formLogin">
  		<div class="thumbnail">
			<img src="person.png" />
		</div>

		<form class="login-form" action="Vinil">
				<input id="email" name="email" type="text" placeholder="ID de usuário" /> 
				<input id="senha" name="senha" type="password" placeholder="Senha" /> 
				<input name="acao" type="hidden" value="login" />
				<input type="submit" value="Login"></input>
				<p class="message">
				<a href="#">Esqueceu sua senha?</a>
				</p>
			
			<c:if test="${not empty erro}">
			<br><br>
				<div style="font-size:20px; color:red; text-align:center">
					<c:out value="${erro}">
					</c:out>
					<%
						request.setAttribute("erro", null);
					%>
				</div>
			</c:if>
		</form>
	</div>

	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>

	

</body>
</html>