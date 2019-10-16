package com.slksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slksoft.dao.ProductDao;
import com.slksoft.entity.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // qualified for component scan
public class ProductService {
	
	// automatically injects an instance of ProductDao interface
	// created by Mybatis
	@Autowired
	ProductDao dao;
	
	public ProductService() {
		log.info("ProductService intantiated!");
	}
	
	public List<Product> getAllProducts() {
		log.info("dao is an instanceof {}", dao.getClass().getName());
		log.info("returning a list of all products");
		return dao.findAll();
	}

}
