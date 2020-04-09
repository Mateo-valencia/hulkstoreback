package com.hulkstore.hulkstoreback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TB_ARTICLE")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String reference;
	private String price;
	private String size;
	private String category;
	private String brand;
	
	public Article () {
		
	}

	public Article(Long id, String referencia, String precio, String tallas, String categoria, String brand) {
		super();
		this.id = id;
		this.reference = referencia;
		this.price = precio;
		this.size = tallas;
		this.category = categoria;
		this.brand = brand;
	}
	
	
}
