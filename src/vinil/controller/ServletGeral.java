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
import vinil.model.Gravadora;
import vinil.model.LongPlay;
import vinil.model.DAO.AutorDAO;
import vinil.model.DAO.FaixaDAO;
import vinil.model.DAO.FuncionarioDAO;
import vinil.model.DAO.GravadoraDAO;
import vinil.model.DAO.LongPlayDAO;

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
			 		
			 	case "cadastrargravadora":
			 		cadastrarGravadora(request, response, session);
			 		response.sendRedirect("CadastrarGravadora.jsp");
			 		break;
			 	case "cadastrarlp":
			 		cadastrarLongPlay(request, response, session);
			 		response.sendRedirect("CadastrarLongPlay.jsp");
			 		break;
			 		
			 	case "listargravadoras":
			 		GravadoraDAO gravadoraDAO = new GravadoraDAO();
			 		List<Gravadora> listaGravadoras = gravadoraDAO.listagemGravadoras();
			 		session.setAttribute("listagravadoras", listaGravadoras);
			 		response.sendRedirect("ListarGravadoras.jsp");
			 		break;
			 		
			 	case "consultarlp":
			 		consultarLongPlay(request, response, session);
			 		response.sendRedirect("ConsultarLongPlay.jsp");
			 		
			 	case "preparacadastrarlp":
			 		preparaCadastroLp(request, response, session);
			 		response.sendRedirect("CadastrarLongPlay.jsp");
			 	case "efetuarcadastrolp":
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
		 
		 if	(request.getParameter("nomeautor").isEmpty())
		 {
			 session.setAttribute("erro", "Preencha o nome do Autor");
			 return false;
		 }
		 
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
	 
	 public boolean cadastrarGravadora (HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	 {
		 GravadoraDAO gravadoraDAO = new GravadoraDAO();
		 
		 if	(request.getParameter("razaosocial").isEmpty() || request.getParameter("cnpj").isEmpty())
		 {
			 session.setAttribute("erro", "A razão social e o cnpj são obrigatórios");
			 return false;
		 }
		 
		 List<String> lista = new ArrayList<String>();
		 lista.add(request.getParameter("telefone"));
		 Gravadora gravadora = new Gravadora(request.getParameter("razaosocial"), request.getParameter("cnpj"), request.getParameter("endereco"), lista);
	
		 if (gravadoraDAO.adicionarGravadora(gravadora) == 0)
		 {
			 session.setAttribute("alerta", "Gravadora " + gravadora.getNome() + " cadastrada com sucesso!");
			 return true;
		 }	 
		 else
		 {
			 session.setAttribute("erro", "A gravadora " + gravadora.getNome() + " já está cadastrada. Entre com outras credenciais.");
			 return false;
		 }
			
	 }
	 
	 public boolean cadastrarLongPlay (HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	 {
		 LongPlayDAO longPlayDAO = new LongPlayDAO();
		 
		 if	(request.getParameter("titulo").isEmpty() || request.getParameter("anogravacao").isEmpty() || request.getParameter("gravadora").isEmpty() 
				 || request.getParameter("genero").isEmpty() || request.getParameter("quantidade").isEmpty() || request.getParameter("preco").isEmpty() || request.getParameter("titulofaixa1").isEmpty())
		 {
			 session.setAttribute("erro", "Erro de preenchimento do Long Play");
			 return false;
		 }
		 
		 List<LongPlay> listaLp = new ArrayList<LongPlay>();
		 List<Integer> listaIdAutores = new ArrayList<Integer>();
		 List<Faixa> faixas = new ArrayList<Faixa>();
		 int contadorAutores = 1, duracaoSegundos;
		 String parametroAutor, parametroTitulo, parametroDuracao, parametroCompositores, titulo, compositores;
		 
		 while(true)
		 {
			 parametroAutor = "autor" + String.valueOf(contadorAutores);
			 if (request.getParameterMap().containsKey(parametroAutor))
			 {
				 listaIdAutores.add(Integer.parseInt(request.getParameter(parametroAutor)));
				 contadorAutores++;
			 }
			 else
				 break;
		 }
		 
		 int contadorFaixas = 1;
		 
		 while(true)
		 {
			 parametroTitulo = "titulofaixa" + String.valueOf(contadorFaixas);
			 parametroDuracao = "duracao" + String.valueOf(contadorFaixas);
			 parametroCompositores = "compositores" + String.valueOf(contadorFaixas);
			 
			 if (request.getParameterMap().containsKey(parametroTitulo))
			 {
				 titulo = request.getParameter(parametroTitulo);
				 duracaoSegundos = request.getParameter(parametroDuracao).isEmpty() ? -1 : Integer.parseInt(request.getParameter(parametroDuracao)) ;
				 compositores = request.getParameter(parametroDuracao);
				 
				 faixas.add(new Faixa(titulo, duracaoSegundos, compositores));
				 contadorFaixas++;
			 }
			 else
				 break;
		 }
		 
		 int idSecao = request.getParameter("idsecao").isEmpty() ? -1 : Integer.parseInt(request.getParameter("idsecao"));
		 
		 
		 LongPlay longPlay = new LongPlay(request.getParameter("titulo"), listaIdAutores, Integer.parseInt(request.getParameter("anogravacao")), Integer.parseInt(request.getParameter("idgravadora")) ,idSecao, 
				 request.getParameter("genero"), Integer.parseInt(request.getParameter("quantidade")), Double.parseDouble(request.getParameter("preco")), faixas);
	
			
		 if (longPlayDAO.adicionaLongPlay(longPlay) == 0)
		 {
			 session.setAttribute("alerta", "Long Play " + longPlay.getTitulo() + " cadastrado com sucesso!");
			 return true;
		 }	 
		 else
		 {
			 session.setAttribute("erro", "Erro de preenchimento do Long Play");
			 return false;
		 }
			
	  }
	 
	 public boolean consultarLongPlay (HttpServletRequest request, HttpServletResponse response, HttpSession session) 
	 {
		 LongPlayDAO longPlayDAO = new LongPlayDAO();
		 AutorDAO autorDAO = new AutorDAO();
		 
		 List<LongPlay>listaLps = new ArrayList<LongPlay>();
		 //ArrayList<ArrayList<Autor>> listaDeListasAutores = new ArrayList<ArrayList<Autor>>();
		 List<Autor> listaAutores = new ArrayList<Autor>();
		 List<String> nomesAutores = new ArrayList<String>();
		 List<Integer> idsAutores = new ArrayList<Integer>();
		 String concatNomes = "";
		 
		 if	(request.getParameter("titulo").isEmpty() )
				
		 {
			 session.setAttribute("erro", "Erro");
			 return false;
		 }
		 
		 listaLps = longPlayDAO.getLongPlaysByTitulo(request.getParameter("titulo"));
		 
		 for (int i = 0; i < listaLps.size(); i++)
		 {
			 listaAutores = autorDAO.getAutoresByLongPlay(listaLps.get(i).getId());
			 for (int j = 0; j < listaAutores.size(); j++)
			 {
				 if (j > 0)
					 concatNomes += ", " + listaAutores.get(j).getNome();
				 else
					 concatNomes += listaAutores.get(j).getNome();
			 }
			 nomesAutores.add(concatNomes);
		 }
		 
		 session.setAttribute("listalongplays", listaLps);
		 session.setAttribute("listaAutores", nomesAutores);
		 
		 return true;
		 
	  }
	 
	 public boolean preparaCadastroLp(HttpServletRequest request, HttpServletResponse response, HttpSession session)
	 {
		 AutorDAO autorDAO = new AutorDAO();
		 List<Autor> autores = new ArrayList<Autor>();
		 autores = autorDAO.listagemAutores();
		 
		 session.setAttribute("listaAutores", autores);
		 return false;
	 }
	 
	
}
