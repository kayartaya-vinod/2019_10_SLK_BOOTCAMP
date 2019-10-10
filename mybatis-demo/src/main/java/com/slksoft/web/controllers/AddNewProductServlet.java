package com.slksoft.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slksoft.entity.Product;
import com.slksoft.service.ProductsService;

@WebServlet("/add-new-product")
public class AddNewProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/product-form.jsp")
			.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Product p = new Product();
		p.setName(req.getParameter("name"));
		p.setCategory(req.getParameter("category"));
		p.setBrand(req.getParameter("brand"));
		p.setDescription(req.getParameter("description"));
		p.setDiscount(Integer.parseInt(req.getParameter("discount")));
		p.setPicture(req.getParameter("picture"));
		p.setQuantityPerUnit(req.getParameter("quantity_per_unit"));
		p.setUnitPrice(Double.parseDouble(req.getParameter("unit_price")));
		
		ProductsService service = new ProductsService();
		service.addNewProduct(p);
		
		req.setAttribute("product", p);
		
		req.getRequestDispatcher("/WEB-INF/views/new-product-details.jsp").forward(req, resp);
	}

}
















