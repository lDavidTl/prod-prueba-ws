package com.producto.prd.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producto.prd.dto.ProductDto;
import com.producto.prd.exception.BadRequestException;
import com.producto.prd.feingService.FeingClientProduct;
import com.producto.prd.service.ProductService;

import feign.FeignException;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private FeingClientProduct clientProduct;

	@Override
	public List<ProductDto> getProductos() {
		try {
			return clientProduct.getProductos();
		} catch (FeignException e) {
			log.error("An error occurred while executing the request: " + e.getMessage());
			throw new  BadRequestException("The products cannot be obtained...");
		}
	}

	@Override
	public ProductDto getProductoById(Long id) {
		try {
			return clientProduct.getProductoById(id);
		} catch (FeignException e) {
			log.error("An error occurred while executing the request: " + e.getMessage());
			throw new  BadRequestException("The products cannot be obtained...");
		}
	}

	@Override
	public List<String> getCategories() {
		try {
			return clientProduct.getCategories();
		} catch (FeignException e) {
			log.error("An error occurred while executing the request: " + e.getMessage());
			throw new  BadRequestException("The categories cannot be obtained...");
		}
	}

	@Override
	public List<ProductDto> getProductosByCategory(String category) {
		try {
			return clientProduct.getProductos();
		} catch (FeignException e) {
			log.error("An error occurred while executing the request: " + e.getMessage());
			throw new  BadRequestException("The products cannot be obtained...");
		}
	}

}
