<%@include file="header.jsp"%>

	<div class="formCadastro">
		<form class="cadastro-form" action="Vinil">
			<input id="razaosocial" name="razaosocial" type="text" placeholder="Razão Social" />
			<input id="cnpj" name="cnpj" type="text" placeholder="CNPJ" />
			<input id="endereco" name="endereco" type="text" placeholder="Endereço" />
			<input id="telefone" name="telefone" type="text" placeholder="Telefone" />
			<input name="acao" type="hidden" value="cadastrargravadora" /> 
				<input id="submit" style="color: WHITE" type="submit" value="Efetuar Cadastro"></input>
		</form>
		
	</div>

</body>
</html>