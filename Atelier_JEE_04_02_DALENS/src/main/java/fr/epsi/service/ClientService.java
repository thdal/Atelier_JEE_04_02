package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Client;

public interface ClientService {
	
	void createClient(Client c);
	
	List<Client> getClientsList();

}
