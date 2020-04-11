package com.hulkstore.hulkstoreback.model;

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
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_DESCRIPTION")
public class Description {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDescription;
	
	@Column(name = "DES_NAME")
	private String name;
	@Column(name = "DES_VALUE")
	private String value;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "ARTICLE_ID")
	private Article article;
	
	public Description() {
		
	}

	public Description( String name, String value, Article article) {
		super();
		this.name = name;
		this.value = value;
		this.article = article;
	}




}
