package com.hulkstore.hulkstoreback.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hulkstore.hulkstoreback.model.Category;

public interface RepositoryCategory extends JpaRepository<Category, Long>{
	
	List<Category> findByName(String name);
	
}
