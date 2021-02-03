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
import fr.epsi.entite.Article;
import fr.epsi.entite.Client;

/*
 * Notre classe de service de l'article, qui nous permettra de faire
 * la jonction entre la base de données et l'UI de façon générale
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ArticleServiceImpl implements ArticleService {
	
	@PersistenceContext
	private EntityManager em;
	
	@Resource
    private UserTransaction utx;

	public void createArticle(Article a) {
		ArticleDao dao = new ArticleDaoImpl(em, utx);
		dao.create(a);	
		
	}

	public List<Article> getArticlesList() {
		ArticleDao dao = new ArticleDaoImpl(em, utx);		
		return dao.getArticlesList();	
	}

}
