package com.hulkstore.hulkstoreback.dao;


import org.springframework.data.repository.CrudRepository;

import com.hulkstore.hulkstoreback.model.Article;

public interface RepositoryArticle extends CrudRepository<Article, Long>{

}
