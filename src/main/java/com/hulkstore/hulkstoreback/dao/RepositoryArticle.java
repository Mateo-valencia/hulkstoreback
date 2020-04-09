package com.hulkstore.hulkstoreback.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hulkstore.hulkstoreback.model.Article;

public interface RepositoryArticle extends JpaRepository<Article, Long>{

	List<Article> findByBrand(String brand);

}
