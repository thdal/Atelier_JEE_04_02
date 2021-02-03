
package fr.epsi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import fr.epsi.entite.Client;
import fr.epsi.service.ClientService;
import fr.epsi.service.ClientServiceImpl;

public class ClientController {
	
	@EJB
	private ClientService service = new ClientServiceImpl();

	
	public List<Client> getClientsList() {		
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
