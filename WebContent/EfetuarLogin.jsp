<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="header.jsp"%>

	<div class="formLogin">
  		<div class="thumbnail"><img src="person.png"/></div>			
  			  			
  			<form class="login-form">
			    <input type="text" placeholder="ID de usuário"/>
			    <input type="password" placeholder="Senha"/>
			    <a href="IGerente.jsp"><button>Login</button></a>
			    <p class="message"><a href="#">Esqueceu sua senha?</a></p>
			</form>
	</div>
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
	</body>
</html>