package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Movie;
import com.stackroute.userservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.exceptions.MovieNotFoundException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface MovieService {

public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;

public List<Movie> getAllMovies() throws MovieNotFoundException;

public Movie deleteMovie(Movie movie) throws MovieNotFoundException;

public Movie getMovieById(int movieId) throws MovieNotFoundException;

public Movie updateMovie(Movie movie);

public  List<Movie> searchMovies(String movieName);
}
