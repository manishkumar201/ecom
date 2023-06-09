package com.ecom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dtos.ApiResponse;
import com.ecom.dtos.ProductDto;
import com.ecom.services.ProductServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> productsDtos = productServices.getAllProduct();
		return ResponseEntity.ok(productsDtos);
	}
	
	@GetMapping("/{productDtoId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable String productDtoId){
		ProductDto productDto = productServices.getProduct(productDtoId);
		return ResponseEntity.ok(productDto);
	}
	
	@GetMapping("/search/{keyword}")
	public ResponseEntity<List<ProductDto>> searchProduct(@PathVariable int keyword){
		List<ProductDto> productDtos =  productServices.searchProduct(keyword);
		return ResponseEntity.ok(productDtos);
	}
	
	@PostMapping
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
		productServices.addProduct(productDto);
		return new ResponseEntity<ProductDto>(productDto, HttpStatus.CREATED);
	}
	
	@PutMapping("/{productDtoId}")
	public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto,@PathVariable String productDtoId){
		productServices.updateProduct(productDto, productDtoId);
		return ResponseEntity.ok(productDto);
	}
	
	@DeleteMapping("/{productDtoId}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable String productDtoId){
		productServices.deleteProduct(productDtoId);
		return ResponseEntity.ok(ApiResponse.builder().message("product deleted").success(true).build());
	}
	
}
