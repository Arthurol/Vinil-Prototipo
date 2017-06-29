<%@include file="header.jsp"%>

<style>
table, th, td {
   border: 2px solid black;
   padding: 10px 0;
}
table {
	border-collapse: separate;
 	border-spacing: 5px 0;
 	 
}
th {
	font-size: 16px;
	color:red;
}
td {
	text-align:center;
}
</style>

	<div class="formCadastro">
		<form class="cadastro-form" action="Vinil">
			<input type="text" name="titulo" placeholder="ID do Long Play" />
			<input name="acao" type="hidden" value="consultarlp" />
			<input type="submit" value="Consultar"></input>

		</form>
	</div>
	
	<c:if test="${not empty listalongplays}">
		
		 <c:forEach items ="${listaAutores}" var="autor" varStatus="status">
			<%/* <c:forEach items ="${listalongplays}" var="longplay"> */%>
			
				<table>
		            <tr> 
		            	<th>ID</th>
		            	<th>Título</th> 
		            	<th>Autor(es) </th>
		            	<th>Ano</th> 
		            	<th>Gravadora</th> 
		            	<th>Genero</th> 
		            	<th>Quantidade</th>
		            	<th>Preço</th>
		            	
		            
		                <tr>
	            	
	                	<td><c:out value="${listalongplays[status.index].id}" /></td>
	                	   	
	               		<td><c:out value="${listalongplays[status.index].titulo}" /></td>
	               		
	            		<td><c:out value="${autor}" /></td>
	               		         
	               		<td><c:out value="${listalongplays[status.index].anoGravacao}" /></td>
	               		
	               		<td><c:out value="${listalongplays[status.index].idGravadora}" /></td>
	               		
	               		<td><c:out value="${listalongplays[status.index].genero}" /></td>
	               		
	               		<td><c:out value="${listalongplays[status.index].quantidadeEstoque}" /></td>
	               		
	               		<td><c:out value="${listalongplays[status.index].preco}" /></td>
	               		
	               		
	               		
	   				</tr>
	            <%//</c:forEach> %>
	       	</table>
            <br><br>
            	<% int contadorFaixas = 1; %>
            	
            	 <c:out value="Faixas:" /> <br><br>
            	 <c:forEach items ="${listalongplays[status.index].faixas}" var="faixa">
            		 <% out.print("Faixa" + String.valueOf(contadorFaixas) + ": "); %> <br>
            		  <% out.print("Título: "); %><c:out value= "${faixa.titulo}"/> <% out.print(" segundos"); %> <br>
            		 <% out.print("Duração: "); %><c:out value= "${faixa.duracaoSegundos}"/> <% out.print(" segundos"); %> <br>
            		 <% out.print("Compositores da Letra: "); %><c:out value= "${faixa.compositoresLetra}"/> <br><br>
            	 <% contadorFaixas ++; %>
            	 </c:forEach> 
        
		</c:forEach> 
	</c:if>
	
	
</body>
</html>