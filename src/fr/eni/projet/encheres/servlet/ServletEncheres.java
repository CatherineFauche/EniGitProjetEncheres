package fr.eni.projet.encheres.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletEncheres
 */
@WebServlet("/encheres")
public class ServletEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/encheres.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String identifiant = request.getParameter("identifiant");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession(); //création d'un session utilisateur
		
		session.setAttribute("identifiant", identifiant); //mettre le parametre de session en mémoire
		session.setAttribute("password", password);
		
		session.invalidate();// requête de déconnection utilisateur
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/encheres.jsp");
		rd.forward(request, response);
	}

}
