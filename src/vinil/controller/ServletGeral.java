package vinil.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;

import vinil.model.Autor;
import vinil.model.Faixa;
import vinil.model.Funcionario;
import vinil.model.LongPlay;
import vinil.model.DAO.AutorDAO;
import vinil.model.DAO.FuncionarioDAO;

public class ServletGeral extends HttpServlet{

	private Map<String, Object> request;
    private Map<String, Object> session;
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		 HttpSession session = request.getSession();
		 session.setAttribute("erro", null);
		 session.setAttribute("alerta", null);

		  
		 if (request.getParameter("acao") != null)
		 {
			 String acao = request.getParameter("acao");
			 
			 switch (acao)
			 {
			 	case "login": 
			 		login(request, response, session);
			 		break;
			 		
			 	case "teste":	
			 		AutorDAO autorDAO = new AutorDAO();
			 		List<Faixa> faixas = new ArrayList<Faixa>();
			 		faixas.add(new Faixa("Sometimes I Feel Like Screaming", "Ian Gillian, Steve Morse"));
			 		faixas.add(new Faixa("Pictures of Home", "Ian Gillian, Roger Glover, Ritchie Blackmore"));

			 		Autor autor = autorDAO.getAutorByName("Deep Purple");
			 		ArrayList<Integer> listaAutores = new ArrayList<Integer>(autor.getId());
			 		LongPlay longPlay = new LongPlay("Deep Purple in Concert", listaAutores, 1999, 9, "Rock Internacional", 20, 60.00, faixas);
			 		
			 		session.setAttribute("longPlay", longPlay);
			 		response.sendRedirect("EfetuarLogin.jsp");
			 		break;
			 		
			 	case "logout":
			 		session.setAttribute("funcionario", null);
			 		response.sendRedirect("EfetuarLogin.jsp");
			 		break;
		 		
			 	case "cadastrarautor":
			 		cadastrarAutor(request, response, session);
			 		response.sendRedirect("CadastrarAutor.jsp");
			 		break;
			 	
			 }
		 }
		 
		 else if (session.getAttribute("funcionario") == null)
		 {
			 response.sendRedirect("EfetuarLogin.jsp");
		 }
		 else
			 response.sendRedirect("Homepage.jsp");
      
	 }
	 
	 public void login(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException
	 {	

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if (request.getParameter("email") != null && request.getParameter("senha") != null)
		{
			String email = request.getParameter("email");
			Funcionario funcionario = funcionarioDAO.getFuncionarioByEmail(email);
			
			if (funcionario != null)
			{
				if (funcionario.getSenha().equals(request.getParameter("senha")))
				{
					session.setAttribute("funcionario", funcionario);
					session.setAttribute("alerta", "Bem Vindo " + funcionario.getNome() + "!");
					response.sendRedirect("Homepage.jsp");
				}
				else 
				{
					session.setAttribute("erro", "Usuário ou senha incorretos");
					response.sendRedirect("EfetuarLogin.jsp");
				}
			}
			else
			{
				session.setAttribute("erro", "Usuário ou senha incorretos");
				response.sendRedirect("EfetuarLogin.jsp");
			}
	 	}
	 }
	 
	 public boolean cadastrarAutor(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	 {
		 AutorDAO autorDAO = new AutorDAO();
		 Autor autor = new Autor(request.getParameter("nomeautor"));
	
		 if (autorDAO.adicionarAutor(autor) == 0)
		 {
			 session.setAttribute("alerta", "Autor " + autor.getNome() + " cadastrado com sucesso!");
			 return true;
		 }	 
		 else
		 {
			 session.setAttribute("erro", "O autor " + autor.getNome() + " já está cadastrado. Entre com outro nome.");
			 return false;
		 }
	 }
	
}
