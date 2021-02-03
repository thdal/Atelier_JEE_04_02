package fr.epsi.dao;

import java.util.List;

import fr.epsi.entite.Article;

public interface ArticleDao {
	
	 void create(Article a); 
	    
	 List<Article> getArticlesList();

}
