package com.slksoft.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.slksoft.service.ProductService;

@Controller // qualifies for component scan
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/view-products")
	public String getAllProducts(Model model) {
		model.addAttribute("products", service.getAllProducts());
		return "show-products";
	}

}
