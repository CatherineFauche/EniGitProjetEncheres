package fr.eni.projet.encheres.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projet.encheres.BusinessException;
import fr.eni.projet.encheres.bll.UtilisateurManager;

@WebServlet(urlPatterns = { "/connexion" })
public class Connexion extends HttpServlet {

		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Connexion() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    /**
		 * @param Utilisateur 
	     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			Cookie[] cookies = request.getCookies();
			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if (cookie.getName().equals("emailPseudo")) {
						request.setAttribute("emailPseudo", cookie.getValue());
				}
			}
			}
					
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/JSP/connexion.jsp");
			 
	        dispatcher.forward(request, response);
			
			
		}

		/**
		 * @param message 
		 * @throws IOException 
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        request.setCharacterEncoding("utf-8");
			String emailPseudo = request.getParameter("emailPseudo");
			String MotDePasse = request.getParameter("MotDePasse");
			
			Cookie cookie = new Cookie("emailPseudo", emailPseudo);
			cookie.setMaxAge(60 * 60 *24 * 30);
			response.addCookie(cookie);

				try {
					String pseudo = UtilisateurManager.getInstance().validateConnection(emailPseudo, MotDePasse);
					HttpSession  session = request.getSession();
					session.setAttribute("pseudo", pseudo);
					response.sendRedirect(request.getContextPath()+"/encheres");
				} catch (BusinessException e) {
					request.setAttribute("errors", e.getErrors());
					if(request.getAttribute("errors") != null)
					{
						request.getAttribute("errors");
						System.out.println(request.getAttribute("errors"));
					}
					request.getRequestDispatcher("/WEB-INF/JSP/connexion.jsp").forward(request, response);
				}
			}

		}
		
