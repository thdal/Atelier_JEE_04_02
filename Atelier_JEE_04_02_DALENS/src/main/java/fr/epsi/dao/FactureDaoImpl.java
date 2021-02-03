package fr.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Facture;

public class FactureDaoImpl implements FactureDao{
	EntityManager em;
	UserTransaction utx;
	
	public FactureDaoImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}
    
	
	public List<Facture> getFacturesList(){		
		
    	List<Facture> factures = em.createQuery("select f from Facture f", Facture.class).getResultList();
	    return factures;
}

}
