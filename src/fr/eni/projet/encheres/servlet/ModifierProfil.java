package fr.eni.projet.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.BusinessException;

@WebServlet("/ModifierProfil")
public class ModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/JSP/ModifierProfil.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = (String) request.getSession().getAttribute("pseudo");
		
		
		
		String newPseudo = request.getParameter("pseudo");
		String newNom = request.getParameter("nom");
		String newPrenom = request.getParameter("prenom");
		String newEmail = request.getParameter("email");
		String newTelephone = request.getParameter("tel");
		String newRue = request.getParameter("rue");
		String newCp = request.getParameter("cp");
		String newVille = request.getParameter("ville");
		String motDePasseActuel = request.getParameter("motdepasseactuel");
		String nouveauMotDePasse = request.getParameter("nouveaumotdepasse");
		String nouveauMotDePasseConfirmation = request.getParameter("nouveaumotdepasseconfirmation");

		UtilisateurManager utilisateurmanager = new UtilisateurManager();

		if(pseudo==null) {pseudo= newPseudo;}
		try {
			
			utilisateurmanager.modifierProfil(pseudo,newPseudo,newNom,newPrenom,newEmail,newTelephone,newRue,newCp,newVille,motDePasseActuel,nouveauMotDePasse,nouveauMotDePasseConfirmation);
			response.sendRedirect("./encheres");
			
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}
	

		

	}

}