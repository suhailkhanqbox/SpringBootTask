package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.Movie;
import com.stackroute.userservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
@Primary
public class MovieServiceImpl implements MovieService {

    MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl (MovieRepository movieRepository)
    {
        this.movieRepository=movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException {

        /*if (movieRepository.existsById(movie.getMovieId()))
        {
            throw new MovieAlreadyExistsException("movie already exist");
        }*/

        Movie savedMovie= movieRepository.save(movie);
        /*if(savedMovie==null)
        {    throw new MovieAlreadyExistsException("movie already exist");}
        */return savedMovie;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Movie findById(int movieId){
        return movieRepository
                .findById(movieId)
                .orElseThrow(() -> new ResourceAccessException("Movie not found on :: " + movieId));
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return null;
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }


    @Override
    public Movie getMovieById(int movieId) throws ResourceAccessException {
        return movieRepository
                .findById(movieId)
                .orElseThrow(() -> new ResourceAccessException("Movie not found on :: " + movieId));
    }

    @Override
    public List<Movie> searchMovies(String movieName) {
        return movieRepository.findByName(movieName);
    }

}
