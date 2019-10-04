package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
