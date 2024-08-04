package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Product;
import com.app.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<?> listAllProduct(){
		try {
			List<Product> allProducts = productService.getAllProducts();
			return ResponseEntity.status(HttpStatus.OK).body(allProducts);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		try {
			Product newProduct = productService.addNewProduct(product);
			return ResponseEntity.status(HttpStatus.OK).body(newProduct);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
	@PutMapping
	public ResponseEntity<?> updateProduct(@RequestBody Product product){
		try {
			Product updateProduct = productService.updateProduct(product);
			return ResponseEntity.status(HttpStatus.OK).body(updateProduct);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
	
	@DeleteMapping("/{pid}")
	public ResponseEntity<?> deleteProduct(@RequestBody Long pid){
		try {
			String deleteProduct = productService.deleteProduct(pid);
			return ResponseEntity.status(HttpStatus.OK).body(deleteProduct);
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}	
	}
}
