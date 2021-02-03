package fr.epsi.dao;

import fr.epsi.entite.Client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/*
 * 
 * La classe d'implémentation DAO du client, qui me permettra d'accéder à la base de données.
 */
public class ClientDaoImpl implements ClientDao{
	
	EntityManager em;
	UserTransaction utx;
	public ClientDaoImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}

	public void create(Client c) {
		
			try {
				utx.begin();
				em.persist(c);
				utx.commit();
			} catch (NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicMixedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	public List<Client> getClientsList(){
	    
	    	List<Client> clients = em.createQuery("select c from Client c order by c.nom asc", Client.class).getResultList();	   
		    return clients;
	}

}
