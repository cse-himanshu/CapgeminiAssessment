package com.assessment5.dto;

import com.assessment5.model.Movie;

public class Mapper {

	public static MovieResponseDTO toResponseDTO(Movie movie) {
		return new MovieResponseDTO(
				movie.getId(),
				movie.getName(),
				movie.getLanguage(),
				movie.getPrice()
		);
	}

	public static Movie toEntity(MovieRequestDTO dto) {
		Movie movie = new Movie();
		movie.setName(dto.getName());
		movie.setLanguage(dto.getLanguage());
		movie.setPrice(dto.getPrice());
		return movie;
	}

}
