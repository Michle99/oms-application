package com.oms.catalog.catalogservice.service;

import java.util.List;

import com.oms.catalog.catalogservice.exception.ProductNotFoundException;
import com.oms.catalog.catalogservice.model.Product;

public interface CatalogService {

	Product findBy(Long idProduct) throws ProductNotFoundException;
	Product findBy(String description) throws ProductNotFoundException;
	List<Product> findByCategory(String category) throws ProductNotFoundException;
	List<Product> findAll() throws ProductNotFoundException;
	
}
