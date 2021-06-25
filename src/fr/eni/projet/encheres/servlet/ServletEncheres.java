package fr.eni.projet.encheres.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.UtilisateurManager;
import fr.eni.projet.encheres.bo.Article;
import fr.eni.projet.encheres.bo.Categorie;

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
		List<Article> listeEnchere = new ArrayList<Article>();
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		
		if (request.getAttribute("ListeEnchere")==null) {
			try {
				listeEnchere = UtilisateurManager.getInstance().recupererListeEnchere();
				request.setAttribute("ListeEnchere", listeEnchere);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		
		try {
			listeCategorie = UtilisateurManager.getInstance().recupererListeCategorie();
			request.setAttribute("listeCategorie", listeCategorie);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/JSP/encheres.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int categorieFiltre = Integer.parseInt(request.getParameter("categorieFiltre"));
		
		List<Article> listeEnchereDesFiltresVentes = new ArrayList<>();
		
		try {
			listeEnchereDesFiltresVentes = UtilisateurManager.getInstance().filtreEnchereParCategorie(categorieFiltre);
			request.setAttribute("ListeEnchere", listeEnchereDesFiltresVentes);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
