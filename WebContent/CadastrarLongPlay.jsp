<%@include file="header.jsp"%>

<div class="formCadastro"   id="cadastroLP">
	<form class="cadastro-form" id="cadastroLp" action="Vinil">
		<input name="acao" type="hidden" value="efetuarcadastrolp"/>
		<input name="titulo" type="text" placeholder="Título" />	
		<br>
	<div style="font-size:16px; text-align:left; margin-left:5px;">
		<label for="idautor">Autor do Long Play: </label>
		<select name="idautor" id="idautor">
			<option selected="selected">Escolha um Autor</option>
			
     			<c:forEach var="autor" items ="${listaAutores}">
         	 		<option value="<c:out value="${autor.id}" />">${autor.nome}</option>
     			</c:forEach>
		</select> 
	</div> <br>
	
	<div style="font-size:16px; text-align:left; margin-left:5px;">
		<label for="gravadora">Autor do Long Play: </label>
		<select name="gravadora" id="idautor">
			<option selected="selected">Escolha uma Gravadora</option>
			
     			<c:forEach var="gravad" items ="${listagravadoras}">
         	 		<option value="${gravad.id}">${gravad.nome}</option>
     			</c:forEach>
		</select> 
	</div> <br>
		
		<input name="anogravacao" id="anoLP" type="text" placeholder="Ano de gravação" />			
		<input name="genero" type="text" placeholder="Gênero" />
		<input name="preco" type="text" placeholder="Preço" />
		<input name="quantidade" type="text" placeholder="Quantidade" />

	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 1"); %></h2><br>
		<input name="titulofaixa1" type="text" placeholder="Título" />
		<input name="duracaosegundos1" type="text" placeholder="Duração em segundos" />
		<input name="compositores1" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 2"); %></h2><br>
		<input name="titulofaixa2" type="text" placeholder="Título" />
		<input name="duracaosegundos2" type="text" placeholder="Duração em segundos" />
		<input name="compositores2" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 3"); %></h2><br>
		<input name="titulofaixa3" type="text" placeholder="Título" />
		<input name="duracaosegundos3" type="text" placeholder="Duração em segundos" />
		<input name="compositores3" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 4"); %></h2><br>
		<input name="titulofaixa4" type="text" placeholder="Título" />
		<input name="duracaosegundos4" type="text" placeholder="Duração em segundos" />
		<input name="compositores4" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 5"); %></h2><br>
		<input name="titulofaixa5" type="text" placeholder="Título" />
		<input name="duracaosegundos5" type="text" placeholder="Duração em segundos" />
		<input name="compositores5" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 6"); %></h2><br>
		<input name="titulofaixa6" type="text" placeholder="Título" />
		<input name="duracaosegundos6" type="text" placeholder="Duração em segundos" />
		<input name="compositores6" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 7"); %></h2><br>
		<input name="titulofaixa7" type="text" placeholder="Título" />
		<input name="duracaosegundos7" type="text" placeholder="Duração em segundos" />
		<input name="compositores7" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 8"); %></h2><br>
		<input name="titulofaixa8" type="text" placeholder="Título" />
		<input name="duracaosegundos8" type="text" placeholder="Duração em segundos" />
		<input name="compositores8" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 9"); %></h2><br>
		<input name="titulofaixa9" type="text" placeholder="Título" />
		<input name="duracaosegundos9" type="text" placeholder="Duração em segundos" />
		<input name="compositores9" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="origem" align="center">
			<br><h2 style="text-align:left;margin-left:5px;"><% out.print("Faixa 10"); %></h2><br>
		<input name="titulofaixa10" type="text" placeholder="Título" />
		<input name="duracaosegundos10" type="text" placeholder="Duração em segundos" />
		<input name="compositores10" type="text" placeholder="Compositor(es)" />
	</div>
	
	 <br><br><br>
	 
	 <a href="Vinil?efetuarcadastrolp">
		<input type="submit" type="text" placeholder="Efetuar cadastro" />
	 </a>
	</form>
</div>

</body>
</html>