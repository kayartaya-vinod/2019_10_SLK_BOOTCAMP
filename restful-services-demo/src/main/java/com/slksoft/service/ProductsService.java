package com.slksoft.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.slksoft.dao.ProductsDao;
import com.slksoft.entity.Product;

public class ProductsService {

	SqlSessionFactory sqlSessionFactory;

	public ProductsService() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	public Product addNewProduct(Product product) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession(true);) {
			ProductsDao dao = sqlSession.getMapper(ProductsDao.class);
			dao.addNewProduct(product);
			return product;
		}
	}

	public List<Product> getAllProducts() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			ProductsDao dao = sqlSession.getMapper(ProductsDao.class);
			return dao.getAllProducts();
		}
	}

	public List<Product> getProductsByCategory(String category) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			ProductsDao dao = sqlSession.getMapper(ProductsDao.class);
			return dao.getProductsByCategory(category);
		}
	}

	public List<Product> getProductsByBrand(String brand) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			ProductsDao dao = sqlSession.getMapper(ProductsDao.class);
			return dao.getProductsByBrand(brand);
		}
	}

	public List<String> getAllBrands() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			ProductsDao dao = sqlSession.getMapper(ProductsDao.class);
			return dao.getAllBrands();
		}
	}

	public List<String> getAllCategories() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession();) {
			ProductsDao dao = sqlSession.getMapper(ProductsDao.class);
			return dao.getAllCategories();
		}
	}
}
