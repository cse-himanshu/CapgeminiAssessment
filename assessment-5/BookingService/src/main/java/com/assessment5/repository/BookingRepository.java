package com.assessment5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment5.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
