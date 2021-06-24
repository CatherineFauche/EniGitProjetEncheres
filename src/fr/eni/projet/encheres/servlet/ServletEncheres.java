package fr.eni.projet.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Article;

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

		HttpSession session = request.getSession(); //il y a une session utilisateur
	

		List<Article> listeEnchere = new ArrayList<Article>();
		List<String> listeCategorie = new ArrayList<String>();
		
		try {
			listeEnchere = UtilisateurManager.getInstance().recupererListeEnchere();
			request.setAttribute("ListeEnchere", listeEnchere);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listeCategorie = UtilisateurManager.getInstance().recupererListeCategorie();
			request.setAttribute("listeCategorie", listeCategorie);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if (session.getAttribute("pseudo")!=null) {
//			String pseudo = (String) session.getAttribute("pseudo");
//			//TODO chercher les vente de cette utilisateur
//		}else {
//			//TODO afficher les ventes sans les lire
//		}
		request.getRequestDispatcher("/WEB-INF/JSP/encheres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
