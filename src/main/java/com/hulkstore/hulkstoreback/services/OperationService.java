package com.hulkstore.hulkstoreback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hulkstore.hulkstoreback.dao.RepositoryArticle;
import com.hulkstore.hulkstoreback.dao.RepositoryCategory;
import com.hulkstore.hulkstoreback.model.Article;
import com.hulkstore.hulkstoreback.model.Category;

import javassist.NotFoundException;

@Service
public class OperationService {
	
	@Autowired
	private RepositoryArticle repositoryArticle;
	
	
	@Autowired 
	private RepositoryCategory repositoryCategory;
	
	
	public List<Category> getCategories() {
		return repositoryCategory.findAll();
	}
	
	public List<Category> getCategoriesByName(String name) {
		return repositoryCategory.findByName(name);
	}
	
	public void setCategorie(Category category) {
		repositoryCategory.save(category);
	}
	
	public void setArticleToCategory(Long id,Article article) throws NotFoundException {
		if (repositoryCategory.findById(id) != null) {
			article.setCategory(repositoryCategory.findById(id).get());
			repositoryArticle.save(article);
		}else {
			throw new NotFoundException("Category Not Found");
		}
	}
	
	public List<Article> getArticlesByBrand(String brand, String Category_Id) {
		return repositoryArticle.findByBrandAndCategory(brand, Category_Id);
	}
	
	public List<String> getBrands(){
		return repositoryArticle.findBrands();
	}
	
	public int getQuantityByBrandAndCategory(String brand, String Category_Id, String reference) {
		return repositoryArticle.findQuantityByBrandAndCategory(brand, Category_Id, reference);
	}
	
	public Article getArticleById(Long id) throws NotFoundException {
		if (repositoryArticle.findById(id) != null) {
			return repositoryArticle.findById(id).get();
		}
		else {
			throw new NotFoundException("Article Not found");
		}
	}
	
	public void deleteArticleById(Long id) {
		 repositoryArticle.deleteById(id);
	}

}
