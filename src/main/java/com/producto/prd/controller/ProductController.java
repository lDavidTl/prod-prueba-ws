package com.producto.prd.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producto.prd.dto.ProductDto;
import com.producto.prd.service.ProductService;
import com.producto.prd.util.ResponseFormat;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("getProduct")
	@Operation(summary = "Get all products")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Get all products"),
			@ApiResponse(responseCode = "400", description = "The products cannot be obtained")
	})
	public ResponseEntity<Map<String, Object>> getProducts(@RequestHeader(name =  "Authorization") String Authorization) {
		try {
			return ResponseFormat.successEntity(productService.getProductos());
		} catch (Exception e) {
			return ResponseFormat.errorEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
}
