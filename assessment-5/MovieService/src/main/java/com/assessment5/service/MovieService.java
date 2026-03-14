package com.assessment5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assessment5.dto.Mapper;
import com.assessment5.dto.MovieRequestDTO;
import com.assessment5.dto.MovieResponseDTO;
import com.assessment5.repository.MovieRepository;

@Service
public class MovieService {

	private final MovieRepository movieRepository;

	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public List<MovieResponseDTO> getAllMovies() {
		return movieRepository.findAll()
				.stream()
				.map(Mapper::toResponseDTO)
				.toList();
	}

	public MovieResponseDTO getMovieById(Long id) {
		return movieRepository.findById(id)
				.map(Mapper::toResponseDTO)
				.orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
	}

	public MovieResponseDTO addMovie(MovieRequestDTO dto) {
		return Mapper.toResponseDTO(movieRepository.save(Mapper.toEntity(dto)));
	}

}
