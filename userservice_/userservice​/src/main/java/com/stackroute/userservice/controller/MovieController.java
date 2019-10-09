package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.Movie;
import com.stackroute.userservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.userservice.exceptions.MovieNotFoundException;
import com.stackroute.userservice.service.MovieService;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="api/v1")
public class MovieController {

    MovieService movieService;

    public MovieController(MovieService movieService){

        this.movieService=movieService;
    }

    @PostMapping("movie")
    public ResponseEntity<?> saveMovie(@RequestBody Movie movie)
    {
        ResponseEntity responseEntity;
        try {
            movieService.saveMovie(movie);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        } catch (MovieAlreadyExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("movie")
    public ResponseEntity<?> getAllMovies() throws MovieNotFoundException {
        ResponseEntity responseEntity;

        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/movie/{id}")
    public ResponseEntity<Movie> getMovieId(@PathVariable(value = "id") int movieId)
            throws Exception {
        Movie movie = movieService.getMovieById(movieId);

        return ResponseEntity.ok().body(movie);
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateUser(
            @PathVariable(value = "id") int movieId, @Valid @RequestBody Movie movie)
            throws Exception {
        Movie movie1=movieService.getMovieById(movieId);
        movie1.setMovieName(movie.getMovieName());
        final Movie updatedMovie = movieService.saveMovie(movie1);
        return ResponseEntity.ok(updatedMovie);
    }

    @DeleteMapping("/movie/{id}")
    public Map<String, Boolean> deleteMovie(@PathVariable(value = "id") int movieId) throws Exception {
        Movie movie=movieService.getMovieById(movieId);
        movieService.deleteMovie(movie);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/movies/{movieName}")
    public ResponseEntity<?> searchMovieByName(@PathVariable(value = "movieName") String movieName){

        ResponseEntity responseEntity;
        try {
            responseEntity=new ResponseEntity<List<Movie>>(movieService.searchMovies(movieName), HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity=new ResponseEntity<List<Movie>>(movieService.searchMovies(movieName), HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}


