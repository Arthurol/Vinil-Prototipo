package vinil.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vinil.model.Autor;
import vinil.model.Faixa;
import vinil.model.Funcionario;
import vinil.model.Gravadora;
import vinil.model.LongPlay;
import vinil.model.Secao;
import vinil.model.DAO.AutorDAO;
import vinil.model.DAO.FuncionarioDAO;
import vinil.model.DAO.GravadoraDAO;
import vinil.model.DAO.LongPlayDAO;
import vinil.model.DAO.SecaoDAO;

public class Execucao {

	public static void main(String[] args)
	{
		int resultado;
		AutorDAO autorDAO = new AutorDAO();
		GravadoraDAO gravadoraDao = new GravadoraDAO();
		SecaoDAO secaoDAO = new SecaoDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		LongPlayDAO longPlayDAO = new LongPlayDAO();
				
		//resultado = autorDSao.adicionarAutor(new Autor("Autor Teste"));
		//List<String> telefones = new ArrayList<String>();
		//telefones.add("(21)1111-2222");
		//telefones.add("(21)9999-9999");
		
		//Gravadora gravadora =  new Gravadora("Sony", "12.111.222/1212-21", "Rua da Sony, 158 - Centro", telefones);
		//resultado = gravadoraDao.adicionarGravadora(gravadora);
		
		//Secao secao1 = new Secao("Blues");
		//Secao secao2 = new Secao("Jazz");
		
		//resultado = secaoDAO.adicionaSecao(secao1);
		//System.out.println("Resultado 1: " + resultado );
		//resultado = secaoDAO.adicionaSecao(secao2);
		//System.out.println("Resultado 2: " + resultado );
		
		//Funcionario funcionario = new Funcionario("Arthur Lopes", "111.111.111-13", "arthur@vinil.com.br", "senha", "Vendedor");
		
		//resultado = funcionarioDAO.cadastrarFuncionario(funcionario);
		//System.out.println("Resultado: " + resultado );
		
		//Autor autor = autorDAO.getAutorByName("Teste");
		//System.out.println("Id: " + autor.getId() + '\n' + "Nome: " + autor.getNome());

		autorDAO.adicionarAutor(new Autor("Whitesnake"));
		
		
		
		System.out.println("Fim");
		
		//longPlayDAO.adicionaLongPlay(longPlay);
	}
}
