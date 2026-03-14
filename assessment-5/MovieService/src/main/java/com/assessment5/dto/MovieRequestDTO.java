package com.assessment5.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class MovieRequestDTO {
	@NotBlank(message = "Name should not be blank")
	private String name;
	
	@NotBlank(message = "Language should not be blank")
	private String language;
	
	@NotNull(message = "Price should not be null")
	@Positive(message = "Price should be greater then zero")
	private Double price;

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	public Double getPrice() {
		return price;
	}
	
	
	
	
}
