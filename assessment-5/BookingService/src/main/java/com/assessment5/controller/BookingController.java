package com.assessment5.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment5.dto.BookingRequestDTO;
import com.assessment5.dto.BookingResponseDTO;
import com.assessment5.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	private final BookingService bookingService;

	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	@PostMapping
	public ResponseEntity<BookingResponseDTO> createBooking(@Valid @RequestBody BookingRequestDTO request) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.createBooking(request));
	}

	@GetMapping
	public ResponseEntity<List<BookingResponseDTO>> getAllBookings() {
		return ResponseEntity.ok(bookingService.getAllBookings());
	}

}
