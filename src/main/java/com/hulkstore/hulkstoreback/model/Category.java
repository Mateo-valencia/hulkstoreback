package com.hulkstore.hulkstoreback.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="TB_CATEGORY")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CATEGORY_ID")
	private Long idCategory;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Article> Articles;
	
	@Column(name = "CTG_NAME")
	private String name;
	@Column(name = "CTG_url")
	private String url;
	@Column(name = "CTG_icon")
	private String icon;
	
	public Category () {
		
	}

	public Category(String name, String url, String icon) {
		super();
		this.name = name;
		this.url = url;
		this.icon = icon;
	}
	
}
