package fr.epsi.dao;

import fr.epsi.entite.Article;
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
 * La classe d'implémentation DAO de l'article, qui me permettra d'accéder à la base de données.
 */

public class ArticleDaoImpl implements ArticleDao{
	
	EntityManager em;
	UserTransaction utx;
	public ArticleDaoImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}

	public void create(Article a) {		
			try {
				utx.begin();
				em.persist(a);
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
	
	public List<Article> getArticlesList(){
	    
	    	List<Article> articles = em.createQuery("select a from Article a order by a.nom asc", Article.class).getResultList();		   
		    return articles;
	}

}
