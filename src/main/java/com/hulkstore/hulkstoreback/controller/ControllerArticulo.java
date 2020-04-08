package com.hulkstore.hulkstoreback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hulkstore.hulkstoreback.dao.InterfaceArticulo;
import com.hulkstore.hulkstoreback.model.Articulo;

@RestController
public class ControllerArticulo {
	@Autowired
	private InterfaceArticulo interfaceArticulo;
	
	@GetMapping("/getArticles")
	public Iterable<Articulo> getArticle(){
		return interfaceArticulo.findAll();
	}
	
	@PostMapping("/setArticles")
	public String setArticle(@RequestBody Articulo article) {
		interfaceArticulo.save(article);
		return "Saving Article";
	}
	
}
