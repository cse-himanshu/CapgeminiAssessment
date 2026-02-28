package com.assessment_movieManagemetSystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assessment_movieManagemetSystem.model.Movie;
import com.assessment_movieManagemetSystem.service.MovieService;

@Controller
@RequestMapping("/api")
public class MovieController {
	private MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/movies")
	public String getMovies(Model model) {
		List<Movie> movies = movieService.getAllMovies();
		model.addAttribute("movies", movies);
		return "movies";
	}
	
	@GetMapping("/addmovie")
	public String showAddMovieForm(Model model) {
		model.addAttribute("movie", new Movie());
		return "addmovie";
	}
	
	@PostMapping("/addmovie")
	public String addMovie(@ModelAttribute("movie") Movie movie) {
		movieService.addMovie(movie);
		return "redirect:/api/movies";
	}
	
	@GetMapping("/editmovie/{id}")
	public String showEditMovieForm(@PathVariable Long id, Model model) {
		Movie oldMovie = movieService.getMovieById(id);
		model.addAttribute("movie", oldMovie);
		return "editmovie";
	}
	
	@PostMapping("/editmovie/{id}")
	public String editMovie(@PathVariable Long id, @ModelAttribute("movie") Movie movie) {
		movieService.editMovie(id, movie);
		return "redirect:/api/movies";
	}
	
	@PostMapping("/deletemovie/{id}")
	public String deleteMovie(@PathVariable Long id) {
		movieService.deleteMovie(id);
		return "redirect:/api/movies";
	}
}
