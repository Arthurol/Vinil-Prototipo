package vinil.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletGeral extends HttpServlet{

	private Map<String, Object> request;
    private Map<String, Object> session;
	
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	 {
		 HttpSession session = request.getSession();
		 String acao = request.getParameter("acao");
		 
		 //switch (acao)
		 //{
		 	//case "login": 
		 		//login(request, response);
		 
		 //}
		 List<String> listaTeste = new ArrayList<String>();
		 
		 session.setAttribute("teste", listaTeste);
		 response.sendRedirect("CadastrarFuncionario.jsp");
		      
	 }
	 
	 public void login(HttpServletRequest request, HttpServletResponse response)
	 {
		 request.getAttribute("email");
	 }
	
}
