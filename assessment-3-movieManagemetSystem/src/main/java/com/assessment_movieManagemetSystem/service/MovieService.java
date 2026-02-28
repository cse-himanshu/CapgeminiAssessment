package com.assessment_movieManagemetSystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assessment_movieManagemetSystem.Repository.MovieRepository;
import com.assessment_movieManagemetSystem.model.Movie;

@Service
public class MovieService {
	private MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> getAllMovies(){
		return movieRepository.findAll();
	}
	
	public void addMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public void editMovie(Long id, Movie movie) {
		Movie oldMovie = movieRepository.findById(id).get();
		oldMovie.setTitle(movie.getTitle());
		oldMovie.setGenre(movie.getGenre());
		oldMovie.setDirector(movie.getDirector());
		oldMovie.setReleaseYear(movie.getReleaseYear());
		oldMovie.setRating(movie.getRating());
		addMovie(oldMovie);
	}
	
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}
	
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).get();
	}
}
