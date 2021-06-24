package fr.eni.projet.encheres.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.BusinessException;

@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/JSP/Inscription.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String telephone = request.getParameter("tel");
		String rue = request.getParameter("rue");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		String motDePasse = request.getParameter("motdepasse");
		String confirmation = request.getParameter("confirmation");

		UtilisateurManager utilisateurmanager = new UtilisateurManager();

		try {
			utilisateurmanager.creerUtilisateur(pseudo, nom, prenom, email, telephone, rue, cp, ville, motDePasse, confirmation);
			
			HttpSession session = request.getSession();
			session.setAttribute("pseudo",pseudo);
			
			response.sendRedirect("./encheres");
			
		} catch (BusinessException e) {
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
			request.getRequestDispatcher("/WEB-INF/JSP/Inscription.jsp").forward(request, response);
		}
	}
}


