package com.assessment5.dto;

public class BookingResponseDTO {

	private Long bookingId;

	private Long movieId;

	private int tickets;

	private Double totalAmount;

	public BookingResponseDTO(Long bookingId, Long movieId, int tickets, Double totalAmount) {
		super();
		this.bookingId = bookingId;
		this.movieId = movieId;
		this.tickets = tickets;
		this.totalAmount = totalAmount;
	}

	public BookingResponseDTO() {
		super();
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

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

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
