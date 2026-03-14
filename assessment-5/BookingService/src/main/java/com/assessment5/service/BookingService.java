package com.assessment5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assessment5.client.MovieClient;
import com.assessment5.dto.BookingRequestDTO;
import com.assessment5.dto.BookingResponseDTO;
import com.assessment5.dto.MovieResponseDTO;
import com.assessment5.model.Booking;
import com.assessment5.repository.BookingRepository;
import java.lang.*;

@Service
public class BookingService {

	private final BookingRepository bookingRepository;
	private final MovieClient movieClient;

	public BookingService(BookingRepository bookingRepository, MovieClient movieClient) {
		this.bookingRepository = bookingRepository;
		this.movieClient = movieClient;
	}

	public BookingResponseDTO createBooking(BookingRequestDTO request) {
		MovieResponseDTO movie = movieClient.getMovieById(request.getMovieId());

		Double totalAmount = movie.getPrice() * request.getTickets();

		Booking booking = new Booking();
		booking.setMovieId(request.getMovieId());
		booking.setTickets(request.getTickets());
		booking.setTotalAmount(totalAmount);

		Booking saved = bookingRepository.save(booking);

		return new BookingResponseDTO(
				saved.getBookingId(),
				saved.getMovieId(),
				saved.getTickets(),
				saved.getTotalAmount()
		);
	}

	public List<BookingResponseDTO> getAllBookings() {
		return bookingRepository.findAll()
				.stream()
				.map(b -> new BookingResponseDTO(
						b.getBookingId(),
						b.getMovieId(),
						b.getTickets(),
						b.getTotalAmount()
				))
				.toList();
	}
	
    public Booking bookingFallback(Booking booking, Throwable t) {
        System.out.println("Product service is down. Returning dummy order. Error: " + t.getMessage());

        // Return dummy order
        Booking dummyBooking = new Booking();
        dummyBooking.setBookingId(booking.getBookingId());
        dummyBooking.setMovieId(booking.getMovieId());        
        return dummyBooking;
    }

}
