package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ClientDao;
import fr.epsi.dao.ClientDaoImpl;
import fr.epsi.entite.Client;

/*
 * Notre classe de service du client, qui nous permettra de faire
 * la jonction entre la base de donn�es et l'UI d'une fa�on g�n�rale
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ClientServiceImpl implements ClientService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
    private UserTransaction utx;
	
	public void createClient(Client c) {		
		ClientDao dao=new ClientDaoImpl(em, utx);
		dao.create(c);		
	}
	
	public List<Client> getClientsList() {
		ClientDao dao=new ClientDaoImpl(em, utx);		
		return dao.getClientsList();		
	}

}
