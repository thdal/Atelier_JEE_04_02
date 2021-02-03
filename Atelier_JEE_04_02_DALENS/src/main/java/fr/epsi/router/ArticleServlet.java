package fr.epsi.router;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Article;
import fr.epsi.service.ArticleService;


@WebServlet("/articles")
public class ArticleServlet extends HttpServlet{
	
	@EJB
	private ArticleService service;
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		 		if(req.getParameter("action").equals("list")) {
		 			req.setAttribute("ArticlesList", this.getArticlesList());		
			 		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/Article/ListArticles.jsp").forward(req, resp);
		 		}else if(req.getParameter("action").equals("create")) {
			 		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/Article/FormArticle.jsp").forward(req, resp);
		 		}
		    }
		 	
		 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			        throws ServletException, IOException
			    {
			   		//controller.create(req.getParameter("nomClient"), req.getParameter("adresseClient"));					
					this.create(req.getParameter("nomArticle"), req.getParameter("cbArticle"), Integer.parseInt(req.getParameter("prixArticle")));	
		 			req.setAttribute("ArticlesList", this.getArticlesList());		
			 		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/Article/ListArticles.jsp").forward(req, resp);
			    }
		 
		 public List<Article> getArticlesList() {	
			 	//Init de la liste pour la première utilisation,
			 	// nous pourrons ajouter nos articles avec le formulaire par la suite.
				 if(service.getArticlesList().isEmpty()){
				 	this.create("Clavier sans fil", "CB663218796", 80); 
				 	this.create("Souris sans fil", "CB712", 75); 
				 }
			 	List<Article> articles=new ArrayList<Article>();		
			 	articles = service.getArticlesList();		
				return articles;			
			}
		 
		 public void create(String nom, String codeBarre, int prix) {
				Article a=new Article();
				a.setNom(nom);
				a.setCodeBarre(codeBarre);	
				a.setPrix(prix);
				service.createArticle(a);		
			}

}
