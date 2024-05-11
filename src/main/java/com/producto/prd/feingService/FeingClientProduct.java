package com.producto.prd.feingService;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.producto.prd.dto.ProductDto;


@FeignClient(name = "productService", url = "${product.url.service}")
public interface FeingClientProduct {
	
	 @GetMapping("products")
	 public List<ProductDto> getProductos();
	 
	 @GetMapping("products/{id}")
	 public ProductDto getProductoById(@PathVariable Long id);
	 
	 @GetMapping("products/categories")
	 public List<String> getCategories();
	 
	 @GetMapping("products/category/{category}")
	 public List<ProductDto> getProductosByCategory(@PathVariable String category);
	 

}
