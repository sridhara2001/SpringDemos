package com.productapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappMybatisApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappMybatisApplication.class, args);
	}

	@Autowired
	private IProductService productService;
	
	@Override
	public void run(String... args) throws Exception {
//		Product product = new Product();
//		product.setProductId(5);
//		product.setProductName("PackageKit");
//		product.setBrand("Nike");
//		product.setPrice(5000);
//		product.setCategory("Football");
//		productService.addProduct(product);
//		
//		productService.deleteProduct(6);
//		productService.updateProduct(1, 3000);
		
		
		List<Product> products =productService.getAll();
		
		for(Product product : products) {
			System.out.println(product);
		}
		
		System.out.println();
		System.out.println("All Products by category and price");
		System.out.println();
		
		products =productService.getByCategoryandPrice("Cricket", 4000);
		for(Product product : products) {
			System.out.println(product);
		}
	}

}
