package com.producto.prd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producto.prd.dto.ProductDto;
import com.producto.prd.service.ProductService;
import com.producto.prd.util.ResponseFormat;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("getProduct")
	@Operation(summary = "Get all products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Get all products, return in data: List<ProductDto.class>", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class)) }),
			@ApiResponse(responseCode = "400", description = "The products cannot be obtained") })
	public ResponseEntity<Map<String, Object>> getProducts(
			@RequestHeader(name = "Authorization") String Authorization) {
		try {
			return ResponseFormat.successEntity(productService.getProductos());
		} catch (Exception e) {
			return ResponseFormat.errorEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("getProduct/{id}")
	@Operation(summary = "Get product by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Get a product by id,  return in data: ProductDto.class", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class)) }),
			@ApiResponse(responseCode = "400", description = "The product cannot be obtained") })
	public ResponseEntity<Map<String, Object>> getProductById(
			@RequestHeader(name = "Authorization") String Authorization, @PathVariable Long id) {
		try {
			return ResponseFormat.successEntity(productService.getProductoById(id));
		} catch (Exception e) {
			return ResponseFormat.errorEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary = "Get all categories")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Get a List of categories, return a List<String>", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = String.class)) }),
			@ApiResponse(responseCode = "400", description = "The category cannot be obtained") })
	@GetMapping("getProduct/categories")
	public ResponseEntity<Map<String, Object>> getCategories(
			@RequestHeader(name = "Authorization") String Authorization) {
		try {
			return ResponseFormat.successEntity(productService.getCategories());
		} catch (Exception e) {
			return ResponseFormat.errorEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("getProductosByCategory/{category}")
	@Operation(summary = "Get all products by category")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Get a product by category,  return in data: ProductDto.class", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductDto.class)) }),
			@ApiResponse(responseCode = "400", description = "The product cannot be obtained") })
	public ResponseEntity<Map<String, Object>> getProductosByCategory(
			@RequestHeader(name = "Authorization") String Authorization, @PathVariable String category) {
		try {
			return ResponseFormat.successEntity(productService.getProductosByCategory(category));
		} catch (Exception e) {
			return ResponseFormat.errorEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
