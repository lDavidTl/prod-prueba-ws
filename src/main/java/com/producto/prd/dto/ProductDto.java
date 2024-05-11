package com.producto.prd.dto;

import java.math.BigDecimal;

public class ProductDto {
	private Long id;
	private String title;
	private BigDecimal price;
	private String description;
	private String category;
	private String image;
	private RatingDto rating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public RatingDto getRating() {
		return rating;
	}
	public void setRating(RatingDto rating) {
		this.rating = rating;
	}
}
