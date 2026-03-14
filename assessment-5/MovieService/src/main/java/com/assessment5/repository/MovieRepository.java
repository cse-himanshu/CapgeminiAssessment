package com.assessment5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment5.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
