package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.ArticleDao;
import fr.epsi.dao.ArticleDaoImpl;
import fr.epsi.dao.FactureDao;
import fr.epsi.dao.FactureDaoImpl;
import fr.epsi.entite.Article;
import fr.epsi.entite.Client;
import fr.epsi.entite.Facture;

/*
 * Notre classe de service de la facture, qui nous permettra de faire
 * la jonction entre la base de données et l'UI de façon générale
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class FactureServiceImpl implements FactureService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
    private UserTransaction utx;

	public List<Facture> getFacturesList() {
		FactureDao dao = new FactureDaoImpl(em, utx);		
		return dao.getFacturesList();	
	}

}
