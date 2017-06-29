<%@include file="header.jsp"%>

<div class="formCadastro"   id="cadastroLP">
	<form class="cadastro-form">
		<input name="tituloLP" type="text" placeholder="Título" />	
		<input name="anoGravacao" id="anoLP" type="text" placeholder="Ano de gravação" />
		
		<div class="dropdown" id="dropAutor">
			<button class="dropbtn">Autor(es)</button>
				<div class="dropdown-content">
					<a href="javascript:void(0)">
						<input name="autor" placeholder="Autor">
					</a>
				</div>
		</div>
	
		<div class="dropdown" id="dropGravadora">
			<button class="dropbtn">Gravadora</button>
			<div class="dropdown-content">
				<a href="javascript:void(0)">
					<input name="gravadora" placeholder="Gravadora">
				</a>
			</div>
		</div>
		
		<input name="genero" type="text" placeholder="Gênero" />
		<input name="preco" type="text" placeholder="Preço" />

		<script type="text/javascript">
			function duplicarCampos() {
				var clone = document.getElementById('origem').cloneNode(true);
				var destino = document.getElementById('destino');
				destino.appendChild(clone);
				var camposClonados = clone.getElementsByTagName('input');
				for (i = 0; i < camposClonados.length; i++) {
					camposClonados[i].value = '';
				}
			}
			function removerCampos(id) {
				var node1 = document.getElementById('destino');
				node1.removeChild(node1.childNodes[0]);
			}
			
		</script>
<!-- 
		<script type="text/javascript">
			function limpaCampo(id_campo1, id_campo2) {
				document.getElementById(id_campo1).value = "";
				document.getElementById(id_campo2).value = "";
			}
		</script>
		 -->

	<div id="origem" align="center">
		<input name="tituloFaixa" type="text" placeholder="Título da faixa" />
		<input name="duracaoSegundos" type="text" placeholder="Duração da faixa em segundos" />
		<input name="compositores" type="text" placeholder="Compositor(es)" />
	</div>
	
	<div id="destino">
	</div>
	
	<!-- 
	<img  src="../img/add.gif" style="cursor: pointer;" onclick="duplicarCampos();">
	<img  src="../img/cross.gif" style="cursor: pointer;" onclick="removerCampos(this);">
	 -->
	
	<img  id="maisfaixas" src="+faixas.png" style="cursor: pointer;" onclick="duplicarCampos();">
	<!-- 
		<button style="cursor: pointer;" onclick="removerCampos(this);">Remover faixa</button>
	 -->
	 <br><br><br>
	 
	 <a href="AreaGerente.jsp">
		<input type="submit" type="text" placeholder="Efetuar cadastro" />
	 </a>
	</form>
</div>

</body>
</html>