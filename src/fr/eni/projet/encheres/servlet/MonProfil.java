package fr.eni.projet.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MonProfil")
public class MonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupérer l'utilsateur par la session.
		
	//	request.setAttribute("utilisateur", utilisateur);
		
		
		request.getRequestDispatcher("/WEB-INF/JSP/MonProfil.jsp").forward(request, response);
	}

	
	
}