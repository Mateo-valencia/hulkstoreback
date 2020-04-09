package com.hulkstore.hulkstoreback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hulkstore.hulkstoreback.dao.RepositoryArticle;
import com.hulkstore.hulkstoreback.model.Article;

@RestController
public class ControllerArticle {
	
	@Autowired
	private RepositoryArticle repositoryArticle;
	
	@GetMapping("/getArticles")
	public Iterable<Article> getArticle(){
		return repositoryArticle.findAll();
	}
	
	@PostMapping("/setArticles")
	public String setArticle(@RequestBody Article article) {
		repositoryArticle.save(article);
		return "Saving Article";
	}
	
}
