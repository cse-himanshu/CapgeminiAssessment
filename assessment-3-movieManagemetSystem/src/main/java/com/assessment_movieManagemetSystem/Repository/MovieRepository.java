package com.assessment_movieManagemetSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment_movieManagemetSystem.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
	
}
