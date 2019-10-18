package com.slksoft.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.slksoft.entity.Product;
import com.slksoft.service.ProductService;
import com.slksoft.web.validators.ProductValidator;

@Controller // qualifies for component scan
public class ProductController {

	@Autowired
	ProductService service;
	
	@Autowired
	ProductValidator pv;
	
	public static final String ATTR_TITLE = "title";

	@GetMapping("/view-products")
	public String getAllProducts(Model model) {
		model.addAttribute("products", service.getAllProducts());
		model.addAttribute(ATTR_TITLE, "List of all products");
		return "show-products";
	}

	@GetMapping("/view-product-details")
	public String getProductDetails(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("pr", service.getProductById(id));
		return "show-product-details";
	}

	@GetMapping("/delete-product")
	public String deleteProduct(@RequestParam Integer id) {
		service.deleteProduct(id);
		return "redirect:./view-products";
	}
	
	@GetMapping("/advanced-search")
	public String advancedSearch() {
		return "search-form";
	}
	
	@GetMapping("/get-products-by-price-range")
	public String getProductsByPriceRange(
			@RequestParam Double min, @RequestParam Double max, Model model) {
		
		model.addAttribute("products", service.getProductsByPriceRange(min, max));
		
		model.addAttribute(ATTR_TITLE, 
			String.format("List of products between Rs.%.1f and Rs.%.1f", min, max));
		return "show-products";
	}
	
	@GetMapping("/edit-product")
	public String editProduct(@RequestParam Integer id, Model model) {
		model.addAttribute("pr", service.getProductById(id));
		model.addAttribute(ATTR_TITLE, "Edit product details");
		return "product-form";
	}
	
	@GetMapping("/add-new-product")
	public String addNewProduct(Model model) {
		model.addAttribute("pr", new Product());
		model.addAttribute(ATTR_TITLE, "Add new product details");
		return "product-form";
	}
	
	@PostMapping("/save-product")
	public String saveProduct(@ModelAttribute("pr") Product p, BindingResult errors) {
		
		pv.validate(p, errors);

		if(errors.hasErrors()) {
			
			return "product-form";
		}
		
		if(p.getId()==null) {
			// add new record
			service.addNewProduct(p);
		}
		else {
			// updated existing one
			service.updateProduct(p);
		}
		return "redirect:./view-product-details?id=" + p.getId();
	}

}











