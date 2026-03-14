package com.assessment5.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment5.dto.MovieRequestDTO;
import com.assessment5.dto.MovieResponseDTO;
import com.assessment5.service.MovieService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/movies")
public class MovieController {

	private final MovieService movieService;

	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	@GetMapping
	public ResponseEntity<List<MovieResponseDTO>> getAllMovies() {
		return ResponseEntity.ok(movieService.getAllMovies());
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieResponseDTO> getMovieById(@PathVariable Long id) {
		return ResponseEntity.ok(movieService.getMovieById(id));
	}

	@PostMapping
	public ResponseEntity<MovieResponseDTO> addMovie(@Valid @RequestBody MovieRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(movieService.addMovie(dto));
	}

}
