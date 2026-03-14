package com.assessment5.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.assessment5.dto.MovieResponseDTO;

@FeignClient(name = "MovieService")
public interface MovieClient {

	@GetMapping("/movies/{id}")
	MovieResponseDTO getMovieById(@PathVariable("id") Long id);

}
