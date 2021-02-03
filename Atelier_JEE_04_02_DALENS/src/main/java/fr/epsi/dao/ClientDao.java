package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Client;

public interface ClientDao {
    void create(Client c); 
    
   List<Client> getClientsList();

}
