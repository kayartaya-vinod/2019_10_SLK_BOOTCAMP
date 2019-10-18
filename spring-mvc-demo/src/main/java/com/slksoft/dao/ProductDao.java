package com.slksoft.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.slksoft.entity.Product;

public interface ProductDao {

	@Insert("INSERT INTO products(category,name,brand,description,quantity_per_unit,unit_price,picture,discount) VALUES (#{category},#{name},#{brand},#{description},#{quantityPerUnit},#{unitPrice},#{picture},#{discount})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void addProduct(Product product);
	
	@Update("update products set category=#{category}, name=#{name}, brand=#{brand}, description=#{description}, quantity_per_unit=#{quantityPerUnit}, unit_price=#{unitPrice}, picture=#{picture}, discount=#{discount} where id=#{id}")
	public void updateProduct(Product product);
	
	@Select("select * from products where id=#{id}")
	@Results({
		@Result(column = "unit_price", property = "unitPrice"),
		@Result(column = "quantity_per_unit", property = "quantityPerUnit")
	})
	public Product findById(Integer id);
	
	@Delete("delete from products where id=#{id}")
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
	
	@Select("select * from products where unit_price between #{min} and #{max} order by unit_price")
	@Results({
		@Result(column = "unit_price", property = "unitPrice"),
		@Result(column = "quantity_per_unit", property = "quantityPerUnit")
	})
	public List<Product> findByPriceRange(
			@Param("min") Double min, @Param("max") Double max);
	
}





