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

import fr.epsi.controller.ClientController;
import fr.epsi.entite.Client;
import fr.epsi.service.ClientService;

/*
 * Ma classe de Servlet qui contiendra les méthodes get et post ainsi que les appels aux services,
 * 	en effet je rencontre des problème en passant par un sous package Controller, de nombreux
 * 	  NullPointerException sont alors générés, pour ne pas perdre de temps le servlet fera les appels aux services,
 * 		comme nous l'avons vu lors de nos premières heures de cours. 
 * 
 * Je laisse quand même le package controller précèdemment crée pour le mettre à jour avec 
 * 		la correction et dans le cas où vous voudriez y jeter un oeil.
 */

@WebServlet("/clients")
public class ClientServlet extends HttpServlet{
	
	@EJB
	private ClientService service;
	
	ClientController controller = new ClientController();	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		 		if(req.getParameter("action").equals("list")) {
		 		//	req.setAttribute("listClient", controller.getClientsList());
		 			req.setAttribute("ClientsList", this.getClientsList());		 			
			 		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/Client/ListClients.jsp").forward(req, resp);
		 		}else if(req.getParameter("action").equals("create")) {
			 		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/Client/FormClient.jsp").forward(req, resp);
		 		}
		    }

	 	
	 protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {
		   		//controller.create(req.getParameter("nomClient"), req.getParameter("adresseClient"));					
				this.create(req.getParameter("nomClient"), req.getParameter("adresseClient"));
				req.setAttribute("ClientsList", this.getClientsList());		 			
		 		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/Client/ListClients.jsp").forward(req, resp);
		    }
	 
	 public List<Client> getClientsList() {	
		 	//Init de la liste pour la première utilisation,
		 	// nous pourrons ajouter nos clients avec le formulaire par la suite.
			 if(service.getClientsList().isEmpty()){
			 	this.create("Dupont", "543 rue victor hugo 66000 Perpignan"); 
			 	this.create("Alan", "54 rue de la mairie 11290 Alairac"); 
			 	this.create("Jonathan", "65 rue marcel pagnol"); 
			 }
		 	List<Client> clients=new ArrayList<Client>();		
			clients = service.getClientsList();		
			return clients;			
		}
	 
	 public void create(String nom, String adresse) {
			Client c=new Client();
			c.setNom(nom);
			c.setAdresse(adresse);				   
			service.createClient(c);		
		}
}
 