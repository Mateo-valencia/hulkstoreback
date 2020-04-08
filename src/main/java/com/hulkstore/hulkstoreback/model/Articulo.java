package com.hulkstore.hulkstoreback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TB_ARTICULO")
public class Articulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String referencia;
	private String precio;
	private String tallas;
	private String categoria;
	
	public Articulo () {
		
	}

	public Articulo(Long id, String referencia, String precio, String tallas, String categoria) {
		super();
		this.id = id;
		this.referencia = referencia;
		this.precio = precio;
		this.tallas = tallas;
		this.categoria = categoria;
	}
	
	
}
