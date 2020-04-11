package com.hulkstore.hulkstoreback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hulkstore.hulkstoreback.model.Article;
import com.hulkstore.hulkstoreback.model.Category;
import com.hulkstore.hulkstoreback.services.OperationService;

import javassist.NotFoundException;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ControllerArticle {
	
	@Autowired
	private OperationService operationService;
	
	@GetMapping("/getCategories")
	public List<Category> getCategories(){
		return  operationService.getCategories();
	}
	
	@GetMapping("/getBrands")
	public List<String> getBrands(){
		return  operationService.getBrands();
	}
	
	@PostMapping("/setArticleToCategry/{id}")
	public Article getArticle(@PathVariable Long id,@RequestBody Article article) throws NotFoundException{
		operationService.setArticleToCategory(id, article);
		return operationService.getArticleById(article.getIdArticle());
	}
	
	@GetMapping("/getArticlesByBrand/{brand}/{category}")
	public List<Article> getArticlesByBrand(@PathVariable String brand,@PathVariable String category) {
		return operationService.getArticlesByBrand(brand,category);
	}
	
	@PostMapping("/getQuantityByBrandAndCategory/{category}")
	public int getQuantityByBrandAndCategory(@PathVariable String category,@RequestBody Article article) {
		return operationService.getQuantityByBrandAndCategory(article.getBrand(), category, article.getReference());
	}
	
	@GetMapping("/deleteArticleById/{id}")
	public void deleteArticle(@PathVariable Long id) {
		operationService.deleteArticleById(id);
	}
}
