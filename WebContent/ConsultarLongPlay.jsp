<%@include file="header.jsp"%>
 
	<div class="formCadastro">
		<form class="cadastro-form" action="Vinil">
			<input type="text" name="titulo" placeholder="Título do Long Play" />
			<input name="acao" type="hidden" value="consultarlp" />
			<input id="submit" style="color: WHITE" type="submit" value="Consultar"></input>

		</form>
	</div>
	
	<c:if test="${not empty listalongplays}">
		
		 <c:forEach items ="${listaAutores}" var="autor" varStatus="status">
			<%/* <c:forEach items ="${listalongplays}" var="longplay"> */%>
			
			<div style="overflow-x:auto;">
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
	       	</div>
	       	
            <br><br>
            <div class="formCadastro"   id="cadastroLP">
			<form class="cadastro-form">
            	<div style="text-align:left">
            	<% int contadorFaixas = 1; %>
            	
            	 <c:forEach items ="${listalongplays[status.index].faixas}" var="faixa">
            		 <% out.print("Faixa" + String.valueOf(contadorFaixas) + ": "); %> <br>
            		  <% out.print("Título: "); %><c:out value= "${faixa.titulo}"/> <br>
            		 <% out.print("Duração: "); %><c:out value= "${faixa.duracaoSegundos}"/> <% out.print(" segundos"); %> <br>
            		 <% out.print("Compositores da Letra: "); %><c:out value= "${faixa.compositoresLetra}"/> <br><br>
            	 <% contadorFaixas ++; %>
            	 </c:forEach> 
            	 </div>
        </form>
</div>
		</c:forEach> 
	</c:if>
	
	
</body>
</html>