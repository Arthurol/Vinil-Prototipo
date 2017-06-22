package vinil.controller;

import java.util.ArrayList;
import java.util.List;

import vinil.model.Autor;
import vinil.model.Gravadora;
import vinil.model.LongPlay;
import vinil.model.DAO.AutorDAO;
import vinil.model.DAO.GravadoraDAO;
import vinil.model.DAO.SecaoDAO;

public class Execucao {

	public static void main(String[] args)
	{
		int resultado;
		AutorDAO autorDSao = new AutorDAO();
		GravadoraDAO gravadoraDao = new GravadoraDAO();
		//resultado = autorDSao.adicionarAutor(new Autor("Autor Teste"));
		List<String> telefones = new ArrayList<String>();
		telefones.add("(21)1111-2222");
		telefones.add("(21)9999-9999");
		
		Gravadora gravadora =  new Gravadora("Sony", "12.111.222/1212-21", "Rua da Sony, 158 - Centro", telefones);
		resultado = gravadoraDao.adicionarGravadora(gravadora);
	}
}
