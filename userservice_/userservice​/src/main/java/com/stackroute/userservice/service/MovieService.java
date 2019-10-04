package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Movie;
import com.stackroute.userservice.exceptions.MovieAlreadyExistsException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface MovieService {

public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

public List<Movie> getAllMovies();

public Movie findById(int movieId);

}
