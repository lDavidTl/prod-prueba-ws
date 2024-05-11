package com.producto.prd.service;

import java.util.List;

import com.producto.prd.dto.ProductDto;

public interface ProductService {

	public List<ProductDto> getProductos();

	public ProductDto getProductoById(Long id);

	public List<String> getCategories();

	public List<ProductDto> getProductosByCategory(String category);
}
