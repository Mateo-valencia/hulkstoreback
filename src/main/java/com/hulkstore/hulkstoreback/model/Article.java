package com.hulkstore.hulkstoreback.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="TB_ARTICLE")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ARTICLE_ID")
	private Long idArticle;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "article")
	private List<Description> descriptions;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	
	@Column(name = "ART_REFERENCE")
	private String reference;
	@Column(name = "ART_PRICE")
	private String price;
	@Column(name = "ART_BRAND")
	private String brand;
	
	public Article () {
		
	}

	public Article(Category category, String reference, String price, String brand) {
		super();
		this.category = category;
		this.reference = reference;
		this.price = price;
		this.brand = brand;
	}

}
