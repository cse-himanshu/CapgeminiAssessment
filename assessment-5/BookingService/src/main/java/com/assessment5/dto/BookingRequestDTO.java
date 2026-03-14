package com.assessment5.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class BookingRequestDTO {

	@NotNull(message = "Movie ID should not be null")
	private Long movieId;

	@Min(value = 1, message = "Tickets should be at least 1")
	private int tickets;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}

}
