package fr.epsi.service;

import java.util.List;

import fr.epsi.entite.Article;

public interface ArticleService {
	
	void createArticle(Article a);
	
	List<Article> getArticlesList();

}
