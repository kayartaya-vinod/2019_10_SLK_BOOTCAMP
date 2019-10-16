package com.slksoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.slksoft.entity.Product;

public interface ProductDao {

	public void addProduct(Product product);
	
	public Product findById(Integer id);
	
	public void updateProduct(Product product);
	
	public void deleteById(Integer id);
	
	@Select("select * from products")
	@Results({
		@Result(column = "unit_price", property = "unitPrice"),
		@Result(column = "quantity_per_unit", property = "quantityPerUnit")
	})
	public List<Product> findAll();
	
	public List<Product> findByCategory(String category);
	
	public List<Product> findByBrand(String brand);
	
	public List<Product> findByCategoryAndBrand(String category, String brand);
	
	public List<Product> findByPriceRange(Double min, Double max);
	
}
