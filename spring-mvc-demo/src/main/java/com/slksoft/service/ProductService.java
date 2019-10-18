package com.slksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slksoft.dao.ProductDao;
import com.slksoft.entity.Product;

@Service // qualified for component scan
public class ProductService {

	// automatically injects an instance of ProductDao interface
	// created by Mybatis
	@Autowired
	ProductDao dao;

	public List<Product> getAllProducts() {
		return dao.findAll();
	}

	public Product getProductById(Integer id) {
		return dao.findById(id);
	}

	public void deleteProduct(Integer id) {
		dao.deleteById(id);
	}

	public List<Product> getProductsByPriceRange(Double min, Double max) {
		return dao.findByPriceRange(min, max);
	}

	public void addNewProduct(Product p) {
		dao.addProduct(p);
	}

	public void updateProduct(Product p) {
		dao.updateProduct(p);
	}

}
