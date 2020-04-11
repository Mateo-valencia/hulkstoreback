package com.hulkstore.hulkstoreback.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hulkstore.hulkstoreback.model.Article;
import com.hulkstore.hulkstoreback.model.Category;

public interface RepositoryArticle extends JpaRepository<Article, Long>{

	List<Article> findByBrand(String brand);
	
	List<Article> findByCategory(Category category);

	@Query("FROM Article WHERE ART_BRAND = ?1 AND CATEGORY_ID = ?2")
	List<Article> findByBrandAndCategory(String brand, String Category_Id);
	
	@Query("SELECT COUNT(ART_REFERENCE) FROM Article WHERE ART_BRAND = ?1 AND CATEGORY_ID = ?2 AND ART_REFERENCE = ?3\r\n" + 
			"GROUP BY ART_REFERENCE")
	int findQuantityByBrandAndCategory(String brand, String Category_Id,String reference);
	
	@Query("SELECT DISTINCT a.brand FROM Article a")
	List<String> findBrands();
}
