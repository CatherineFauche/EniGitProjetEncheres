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
import fr.eni.projet.encheres.bo.Categorie;

/**
 * Servlet implementation class ServletDeconnexion
 */
@WebServlet("/Deconnexion")
public class ServletDeconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); //il y a une session utilisateur
		session.invalidate();
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
		String inputFiltre = "%"+request.getParameter("inputFiltre")+"%"; // "%" pour sql pour dire il peut avoir un truc avant et après
		int categorieFiltre = Integer.parseInt(request.getParameter("categorieFiltre"));
		
		List<Article> listeEnchereDesFiltresDeconnecter = new ArrayList<>();
		
		try {
			listeEnchereDesFiltresDeconnecter = UtilisateurManager.getInstance().recupererListeEnchereDesFiltresDeconnecter(inputFiltre, categorieFiltre);
			request.setAttribute("ListeEnchere", listeEnchereDesFiltresDeconnecter);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
