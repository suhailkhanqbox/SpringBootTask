package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {

    @Query("select m from Movie m where m.movieName =?1")
    public List<Movie> findByName(String movieName);


}
