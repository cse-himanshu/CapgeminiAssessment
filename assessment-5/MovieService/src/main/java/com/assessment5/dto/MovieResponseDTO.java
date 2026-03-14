package com.assessment5.dto;

public class MovieResponseDTO {

	private Long id;

	private String name;

	private String language;

	private Double price;

	public MovieResponseDTO(Long id, String name, String language, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.price = price;
	}

	public MovieResponseDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
