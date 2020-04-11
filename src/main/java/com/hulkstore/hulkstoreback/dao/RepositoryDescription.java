package com.hulkstore.hulkstoreback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hulkstore.hulkstoreback.model.Article;
import com.hulkstore.hulkstoreback.model.Description;

public interface RepositoryDescription extends JpaRepository<Description, Long>{

	List<Description>findByArticle(Article article);
	
}
