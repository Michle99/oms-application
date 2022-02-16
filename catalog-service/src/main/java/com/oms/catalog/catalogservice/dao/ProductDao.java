package com.oms.catalog.catalogservice.dao;

import java.util.List;

import com.oms.catalog.catalogservice.model.Product;

public interface ProductDao {

	Product findBy(Long idProduct);
	Product findBy(String description);
	List<Product> findByCategory(String category);
	List<Product> findAll();
	
}
