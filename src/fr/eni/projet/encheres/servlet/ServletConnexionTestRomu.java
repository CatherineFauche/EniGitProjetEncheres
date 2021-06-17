package fr.eni.projet.encheres.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.encheres.bll.ConnexionTestRomu;
import fr.eni.projet.encheres.bo.Utilisateur;


@WebServlet("/Connexion")
public class ServletConnexionTestRomu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public final String objetSession = "session";
	public final String objetUtilisateur = "utilisateur";
	public final String objetInscription = "inscription";
   
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	request.getRequestDispatcher("/WEB-INF/JSP/ConnexionTestRomu.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnexionTestRomu inscription= new ConnexionTestRomu();
		
		Utilisateur utilisateur = inscription.connecterUtilisateur(request);
		
		HttpSession session = request.getSession();
		
		if(inscription.getErreurs().isEmpty()) {
			session.setAttribute(objetSession, utilisateur);
		}else {
			session.setAttribute(objetSession, null);
		}
		request.setAttribute(objetInscription, inscription);
		request.setAttribute (objetUtilisateur, utilisateur);
		
		request.getRequestDispatcher("WEB-INF/JSP/encheres.jsp").forward(request, response);
		
	}

}
