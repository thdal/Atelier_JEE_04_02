package fr.epsi.router;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.entite.Facture;
import fr.epsi.service.FactureService;

@WebServlet("/factures")
public class FactureServlet extends HttpServlet{
	
	@EJB
	private FactureService service;
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		        throws ServletException, IOException
		    {		 		
		 		req.setAttribute("FacturesList", this.getFacturesList());
		 		this.getServletContext().getRequestDispatcher("/WEB-INF/pages/Facture/ListFactures.jsp").forward(req, resp);		 		
		    }	 
	 
	 public ArrayList<Map<String, String>> getFacturesList() {	
		 
		 /*		  
		  * Comme demandé les données des factures seront toutes tapées en dur dans le code pour l'atelier
		  * cependant je vous invite à consulter les entités crées, Facture.java et LigneFacture.java
		  * vous y trouverez les annotations ManyToOne et OneToMany. De plus l'application est prête
		  * à recevoir les implémentations du Dao et et du Service dédiés à la facture, elles sont codées.
		  * 
		  * J'ai simplement reproduit à l'identique la dernière image du pdf de l'atelier, 
		  * il n'y a aucune corrélation avec l'implémentation faite dans mes entités.
		  */
		 
		//Je retourne une liste de hashmap cela me facilitera l'affichage dans la vue
		 ArrayList<Map<String, String>> FacturesList = new ArrayList<Map<String, String>>();
		 
		 //Facture n°1
		 Map<String, String> facture1 = new HashMap<String, String>();
		 facture1.put("num", "FC-1000");
		 facture1.put("date", "28/01/2020");
		 facture1.put("client", "Dupont");
		 facture1.put("prix", "80");
		 FacturesList.add(facture1);
		 
		 //Facture n°2
		 Map<String, String> facture2 = new HashMap<String, String>();
		 facture2.put("num", "FC-1009");
		 facture2.put("date", "28/01/2020");
		 facture2.put("client", "Jonathan");
		 facture2.put("prix", "75");
		 FacturesList.add(facture2);
		    
		 return FacturesList;
		 
	 	//Implémentation future :
	 
	 	/*List<Facture> factures=new ArrayList<Facture>();		
	 	factures = service.getFacturesList();		
		return factures;*/			
	}

}
