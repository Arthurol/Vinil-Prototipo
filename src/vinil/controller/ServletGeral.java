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
			 		
			 	case "listargravadoras":
			 		GravadoraDAO gravadoraDAO = new GravadoraDAO();
			 		List<Gravadora> listaGravadoras = gravadoraDAO.listagemGravadoras();
			 		session.setAttribute("listagravadoras", listaGravadoras);
			 		response.sendRedirect("ListarGravadoras.jsp");
			 		break;
			 		
			 	case "consultarlp":
			 		consultarLongPlay(request, response, session);
			 		response.sendRedirect("ConsultarLongPlay.jsp");
			 		break;
			 		
			 	case "preparacadastrarlp":
			 		preparaCadastroLp(request, response, session);
			 		response.sendRedirect("CadastrarLongPlay.jsp");
			 		break;
			 		
			 	case "efetuarcadastrolp":
			 		cadastrarLongPlay(request, response, session);
			 		response.sendRedirect("CadastrarLongPlay.jsp");
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
		 
		 if	(request.getParameter("titulo").isEmpty() || request.getParameter("anogravacao").isEmpty() || request.getParameter("idautor").isEmpty() || request.getParameter("gravadora").isEmpty() 
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
		 
		 listaIdAutores.add(Integer.parseInt(request.getParameter("idautor")));
		 
		 
		 int contadorFaixas = 1;
		 
		 while(true)
		 {
			 parametroTitulo = "titulofaixa" + String.valueOf(contadorFaixas);
			 parametroDuracao = "duracaosegundos" + String.valueOf(contadorFaixas);
			 parametroCompositores = "compositores" + String.valueOf(contadorFaixas);
			 
			 if (!request.getParameter(parametroTitulo).isEmpty())
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
		 
		 int idSecao;
		 if (request.getParameter("idsecao") == null || request.getParameter("idsecao").isEmpty())
			 	idSecao =  -1 ;
		 else
			 	idSecao = Integer.parseInt(request.getParameter("idsecao"));
		 
		 
		 LongPlay longPlay = new LongPlay(request.getParameter("titulo"), listaIdAutores, Integer.parseInt(request.getParameter("anogravacao")), Integer.parseInt(request.getParameter("gravadora")) ,idSecao, 
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
		 GravadoraDAO gravadoraDAO = new GravadoraDAO();
		 List<Autor> autores = new ArrayList<Autor>();
		 List<Gravadora> gravadoras = new ArrayList<Gravadora>();
		 autores = autorDAO.listagemAutores();
		 gravadoras = gravadoraDAO.listagemGravadoras();
		 
		 session.setAttribute("listaAutores", autores);
		 session.setAttribute("listagravadoras", gravadoras);
		 return false;
	 }
	 
	
}
