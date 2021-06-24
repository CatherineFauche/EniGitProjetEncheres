package fr.eni.projet.encheres.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Utilisateur;

@WebServlet(urlPatterns = { "/MonProfil" })
public class MonProfil extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MonProfil() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param Utilisateur
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		HttpSession session = request.getSession();

		if (session.getAttribute("pseudo") != null) {
			String pseudo = (String) session.getAttribute("pseudo") ;
			try {
				Utilisateur user = UtilisateurManager.getInstance().afficherProfil(pseudo);
				request.setAttribute("userProfil", user);

			} catch (BusinessException e) {
				request.setAttribute("errors", e.getErrors());

			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/MonProfil.jsp");
			rd.forward(request, response);

		}

		else {
			request.getRequestDispatcher("/WEB-INF/JSP/connexion.jsp").forward(request, response);

		}
	}

	/**
	 * @param message
	 * @throws IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
