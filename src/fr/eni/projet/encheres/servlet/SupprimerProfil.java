package fr.eni.projet.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.BusinessException;


@WebServlet("/SupprimerProfil")
public class SupprimerProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UtilisateurManager utilisateurmanager = new UtilisateurManager();
		BusinessException be = new BusinessException();
		
		String pseudo = (String) request.getSession().getAttribute("pseudo");
		
		
	
		try {
			if(pseudo!=null && utilisateurmanager.pseudoExiste(pseudo, be) == true) {
				utilisateurmanager.supprimerProfil(pseudo);
				
				request.getSession().invalidate();
				
				request.getRequestDispatcher("inscription").forward(request, response);
			}
		} catch (BusinessException e) {
			e.printStackTrace();
			request.setAttribute("listeCodesErreur", e.getListeCodesErreur());
		}
		
		
		
		
		
	}

}
