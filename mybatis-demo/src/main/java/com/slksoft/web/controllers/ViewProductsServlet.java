package com.slksoft.web.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.entity.Product;
import com.slksoft.service.ProductsService;

@WebServlet("/view-products")
public class ViewProductsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. read the inputs
		String category = req.getParameter("category");
		String brand = req.getParameter("brand");

		// 2. get model data using model methods
		ProductsService service = new ProductsService();
		List<Product> list = null;

		if (category != null) {
			list = service.getProductsByCategory(category);
		} else if (brand != null) {
			list = service.getProductsByBrand(brand);
		} else {
			list = service.getAllProducts();
		}

		// 3. store model data in a scope
		req.setAttribute("products", list);
		req.setAttribute("brands", service.getAllBrands());
		req.setAttribute("categories", service.getAllCategories());

		// 4. forward to view
		req.getRequestDispatcher("/WEB-INF/views/show-products.jsp").forward(req, resp);
	}

}
