package com.slksoft.web.resources;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.slksoft.entity.Product;
import com.slksoft.service.ProductsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/products")
public class ProductResource {

	private ProductsService service;

	// The annotation @PostConstruct instructs the JAXRS runtime (jersey)
	// to automatically invoke this function after the constructor is called
	@PostConstruct
	public void init() throws IOException {
		service = new ProductsService();
	}

	@GET
	@Produces("text/plain")
	public String info() {
		log.info("handling request for GET /api/products in text/plain format");
		return "This is the home of /api/products";
	}

	@GET
	@Produces({ "application/xml", "application/json" })
	public List<Product> getAllProducts(@QueryParam("category") String category, @QueryParam("brand") String brand) {

		log.info("got {} for category", category);
		log.info("got {} for brand", brand);

		if (category != null && brand != null) {
			return service.getProductsByBrand(brand).stream().filter(p -> p.getCategory().equals(category))
					.collect(Collectors.toList());
		}
		if (category != null) {
			return service.getProductsByCategory(category);
		}
		if (brand != null) {
			return service.getProductsByBrand(brand);
		}

		return service.getAllProducts();
	}

}
